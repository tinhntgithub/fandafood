app.controller("restaurantOrderCtrl", function($scope, $http){
	
	$scope.testData = "Test data nha hehehe !"
	
	$scope.getAllOderByStatus0 = function(id) {
		
		$http.get(`/rest/order/restaurant/${id}`,).then(function(response) {
			$scope.items1 = response.data
			console.log($scope.items1);

		}).catch(function(error) {
			console.log(error);
		})
	}
	
	$scope.getAllOderByStatus1 = function(id) {
		
		$http.get(`/rest/order/restaurant/${id}`,).then(function(response) {
			$scope.items2 = response.data
			console.log($scope.items2);

		}).catch(function(error) {
			console.log(error);
		})
	}
	
	$scope.getAllOderByStatus2 = function(id) {
		
		$http.get(`/rest/order/restaurant/${id}`,).then(function(response) {
			$scope.items3 = response.data
			console.log($scope.items3);

		}).catch(function(error) {
			console.log(error);
		})
	}
	
	$scope.getAllOderByStatusFull = function() {
		$scope.getAllOderByStatus0(0);
		$scope.getAllOderByStatus1(1);
		$scope.getAllOderByStatus2(2);
	}
		
	$scope.getAllOderByStatusFull();
	
	$scope.formOder = {}
	$scope.formOderDetail =[]
	$scope.formOderAddress = ""
	
	$scope.selectOder = function(id) {
		$http.get(`/rest/order/${id}`,).then(function(response) {
			$scope.formOder = response.data
			$scope.formOderAddress = $scope.formOder.address.wards+" - " + $scope.formOder.address.districts+ " - " + $scope.formOder.address.city;
			console.log($scope.formOder);
		}).catch(function(error) {
			console.log(error);
		})
		
		
		$http.get(`/rest/order/orderDetail/${id}`,).then(function(response) {

			$scope.formOderDetail = response.data
			console.log($scope.formOderDetail);
	
			}).catch(function(error) {
				console.log(error);
			})
		
		
		
		
	}
	
	$scope.updateOderStatus = function(status) {
		
		$scope.formOder.status = status;
		
		$http.put(`/rest/order/$scope.formOder.id`,$scope.formOder).then(function(response) {
		alert("Đã cập nhật lại trạng thái đơn hàng !")
		$scope.getAllOderByStatusFull();

		}).catch(function(error) {
			console.log(error);
		})
	}
	
	
	
})