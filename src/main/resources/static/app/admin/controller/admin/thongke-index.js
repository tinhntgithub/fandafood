app.controller("thongkeController", function($scope, $http){
	
	$scope.getAllRestaurant = function() {
		//$hhtp giống axios
		$http.get("/rest/restaurant").then(function(response) {
			$scope.restaurant = response.data
					
		}).catch(function(error) {
			console.log(error);
		})
		}
		$scope.getAllRestaurant();
		
		
		$scope.getStatistical = function() {

		//$hhtp giống axios
		$http.get("/rest/statistical/restaurant").then(function(response) {
			$scope.items = response.data
		}).catch(function(error) {
			console.log(error);
		})
		
		
		
	}
	$scope.getStatistical();		
		
		$scope.restaurantId = "";
		$scope.startDate = "";
		$scope.endDate = "";
		
	$scope.getOrderByRestAndDate = function(){
		$scope.restaurantId = document.getElementById('restaurantId').value;
		 $scope.startDate = document.getElementById('startDate').value;
	     $scope.endDate = document.getElementById('endDate').value;
		$http.get(`/rest/statistical/thongke/?restaurantId=${$scope.restaurantId}&&startDate=${$scope.startDate}&&endDate=${$scope.endDate}`).then(function(response)
		{
			$scope.items = response.data
		}).catch(function(error) {
				console.log(error);
			})
	}
})