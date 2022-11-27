var app = angular.module('myAccount', []);
app.controller('myAccountController', function($scope, $http, $document) {
    var log = console.log;
    $scope.form = {};

    $scope.signup = function() {
		var item = angular.copy($scope.form);
        log(item)
		  $http.get(`/rest/user/${item.username}`).then(function(response){
			var check = response.data;
            log(check)
				if(!check){
					$http.post('/rest/user', item).then(function(response) {
						log("Đăng ký thành công")
			
					}).catch(function(error) {
						log("không thành công")
					})
				}else{
					log("Username đã tồn tại")
				}
            }).catch(function(error){

			console.log(error)
            })
		
		
	

	};


})