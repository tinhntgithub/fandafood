var app = angular.module('myAccount', []);
app.controller('myAccountController', function ($scope, $http, $document) {
	var log = console.log;
	$scope.form = {};
	$scope.userRole = {};
	$scope.newUser = {};
	$http.get('/rest/role/user').then(function (response) {
		$scope.userRole = response.data
	}).catch(function (error) {
		log("không thành công")
		log(error)
	})


	$scope.signup = function () {
		var item = angular.copy($scope.form);
		log(item)
		$http.get(`/rest/user/${item.username}`).then(function (response) {
			var check = response.data;
			log(check)
			if (!check) {
				//tạo mới user
				$http.post('/rest/user', item).then(function (response) {
					log("Đăng ký thành công")
					//tạo mới auth
					$scope.newUser = response.data
					log($scope.newUser)
					var data = {
						'account': $scope.newUser,
						'role': $scope.userRole
					}
					$http.post('/rest/auth', data).then(function (response) {
						log("thêm auth thành công")
						sessionStorage.setItem("mailOtp", $scope.newUser.email);
						sessionStorage.setItem("userOtp", $scope.newUser.username);
						location.href = "/account/otp"

					}).catch(function (error) {
						log(error)
						log("không thành công")
					})

				}).catch(function (error) {
					log("không thành công")
				})
			} else {
				log("Username đã tồn tại")
			}
		}).catch(function (error) {

			console.log(error)
		})




	};

});
app.controller('myOtpController', function ($scope, $http, $document) {
	var log = console.log;
	var sendto = sessionStorage.getItem("mailOtp");
	var user = sessionStorage.getItem("userOtp");

	$scope.cuser = {}
	$http.get(`/rest/user/` + user).then(function (response) {
		$scope.cuser=response.data


	}).catch(function (error) {
		log(error)
		log("không thành công")
	})

	$scope.otp;

	$document.ready(function () {
		//gửi otp
		$scope.otp = Math.floor(1000 + Math.random() * 9000);
		var obj = {
			'recipient': sendto,
			'msgBody': 'Mã kích hoạt của bạn là ' + $scope.otp,
			'subject': 'FandaFood Customer Service'
		}

		log(obj)
		$http({
			url: '/sendMail',
			method: 'POST',
			data: obj,
			transformResponse: [
				function (data) {
					return data;
				}
			]
		}).then(function (response) {
			console.log(response);

		})
	})








	$scope.otpinput = "";
	$scope.confirmotp = function () {

		var input = angular.copy($scope.otpinput)
		log($scope.otp)
		log(input)
		if (input == $scope.otp) {
			$scope.cuser.active = true
			$http.put(`/rest/user/` + $scope.cuser.username, $scope.cuser).then(function (response) {
				log('ok')
				location.href = "/account/login"
			}).catch(function (error) {
				console.log(error)
			})
		} else { log('Nhập sai rồi') }

	};

});