var app = angular.module('myApp', []);
app.controller('MyController', function($scope, $http) {
	console.log("connnect")
	$scope.list_food = [];
	
	$scope.getAllFood = function() {
		//$hhtp giống axios
		$http.get("/rest/food").then(function(response) {
			$scope.items = response.data
			
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	
	
	$scope.getAllFood();
});