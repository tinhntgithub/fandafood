console.log("connnect")

var app = angular.module('myHehe', ['angularUtils.directives.dirPagination']);
app.controller('address_controller', function($scope, $http) {


	$scope.status_address = true;
	$scope.create = function() {
		$scope.status_address = true;
		$(document).ready(function() {
			$("#exampleModalAddress").modal('show');
		});
	}

	$scope.update = function() {
		$scope.status_address = false;
		$(document).ready(function() {
			$("#exampleModalAddress").modal('show');
		});
	}





	//ssssssssssssssssssss
	function toastFunction() {
		var x = document.getElementById("toast");
		x.className = "show";
		setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
	}
	function toast_err_Function() {
		var x = document.getElementById("toast_error");
		x.className = "show";
		setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
	}

	$scope.list_address = []
	$scope.loading_address = function() {

		$http.get(`/rest/address/user`)
			.then(function(resp) {
				$scope.list_address = resp.data;

			}).catch(function(error) {
				console.log(error)
			})

	}

	$scope.loading_address()

	$scope.delivery_id = 0
	$scope.load_delivery_true = function() {
		$http.get(`/rest/address/address_true`).then(function(response) {

			$scope.address_true_check = response.data;

			if ($scope.address_true_check != null) {
				$scope.delivery_id = response.data.id

				$scope.address_true = response.data.city + "/" + response.data.districts + "/" + response.data.wards
			}
		}).catch(function(error) {
			console.log(error)

		})
	}


	$scope.load_delivery_true()





	$scope.form_address = {};

	$scope.create_address = function() {



		if (a == "" && b == "" && c == "") {
			$scope.alert_error = "Bạn phải nhập đủ Tỉnh/thành , quận huyện nhé"
			toast_err_Function()
		} else {
			if (!$scope.validatePhoneNumber($scope.form_address.phone)) {
				$scope.alert_error = "Không đúng định dạng số điện thoại "
				toast_err_Function()
			} else {
				if ($scope.form_address.name == undefined) {
					$scope.form_address.name = document.getElementById("remote_user").innerText;
				}
				if ($scope.form_address.address_detail == undefined) {
					$scope.alert_error = "Nhập vào địa chỉ cụ thể nhé"
					toast_err_Function()
				}
				else {

					$scope.form_address.city = a;
					$scope.form_address.districts = b;
					$scope.form_address.wards = c;
					var json = JSON.stringify(angular.copy($scope.form_address));

					$http.post(`/rest/address`, json)
						.then(function(resp) {

							$("#exampleModalAddress").modal('hide');
							$scope.alert_text = "Thêm vị trí giao hàng thành công"
							$scope.form_address = {};
							toastFunction()
							$scope.loading_address()
						}).catch(function(error) {
							$scope.alert_error = "Thêm vị trí giao hàng không thành công "
							toast_err_Function()
						})
				}

			}
		}
	}

	$scope.choose = function(id) {

		$http.get(`/rest/address/choose/${id}`)
			.then(function(resp) {

				$scope.loading_address();

			}).catch(function(error) {
				console.log(error)
			})
	}

	$scope.validatePhoneNumber = function(input_str) {
		return /(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/.test(input_str);
	},

		$scope.update_address = function() {
			if (!$scope.validatePhoneNumber($scope.form_address.phone)) {
				$scope.alert_error = "Không đúng định dạng số điện thoại "
				toast_err_Function()
			} else {
				if ($scope.form_address.city == "", $scope.form_address.districts == "",
					$scope.form_address.wards == "") {

					$scope.form_address.city = a;
					$scope.form_address.districts = b;
					$scope.form_address.wards = c;
				}
				else {
					$scope.form_address.city = a;
					$scope.form_address.districts = b;
					$scope.form_address.wards = c;
				}

				var json = JSON.stringify(angular.copy($scope.form_address));

				var id_add = $scope.form_address.id
				$http.put(`/rest/address/${id_add}`, json)
					.then(function(resp) {

						$("#exampleModalAddress").modal('hide')
						$scope.alert_text = "Cập nhật vị trí thành công"

						toastFunction()
						$scope.loading_address()


					}).catch(function(error) {
						$scope.alert_error = "Cập nhật vị trí không thành công"
						toast_err_Function()
					})


			}
		}


	$scope.edit_address = function(id) {
		$http.get(`/rest/address/${id}`)
			.then(function(resp) {

				$(document).ready(function() {
					$("#exampleModalAddress").modal('show');
				});
				$scope.status_address = false;
				$scope.form_address = resp.data;

			}).catch(function(error) {
				console.log(error)
			})

	}




	$scope.remove_address = function(id) {

		if (confirm("Bạn có muốn xóa địa chỉ này ?")) {
			$http.delete(`/rest/address/${id}`)
				.then(function(resp) {

					$scope.loading_address();
				}).catch(function(error) {
					alert("Bạn không thể xóa địa chỉ này")
				})
		}

	}





	var citis = document.getElementById("city");
	var districts = document.getElementById("district");
	var wards = document.getElementById("ward");

	var a = ""
	var b = ""
	var c = ""

	var Parameter = {
		url: "https://raw.githubusercontent.com/ThanhLMPC02344/apimientay/main/.github/workflows/jekyll.yml",
		method: "GET",
		responseType: "application/json",
	};
	var promise = axios(Parameter);
	promise.then(function(result) {


		renderCity(result.data);




	});

	function renderCity(data) {
		for (const x of data) {

			citis.options[citis.options.length] = new Option(x.Name, x.Id);
		}

		citis.onchange = function(e) {
			a = e.target.options[e.target.selectedIndex].text;

			district.length = 1;
			ward.length = 1;
			if (this.value != "") {

				const result = data.filter(n => n.Id === this.value);


				for (const k of result[0].Districts) {

					district.options[district.options.length] = new Option(k.Name, k.Id);

				}
			}
		};
		district.onchange = function(e) {

			b = e.target.options[e.target.selectedIndex].text;

			ward.length = 1;
			const dataCity = data.filter((n) => n.Id === citis.value);
			if (this.value != "") {
				const dataWards = dataCity[0].Districts.filter(n => n.Id === this.value)[0].Wards;


				for (const w of dataWards) {

					wards.options[wards.options.length] = new Option(w.Name, w.Id);
				}

			}
		};
		wards.onchange = function(e) {

			c = e.target.options[e.target.selectedIndex].text;

		}

	}


});