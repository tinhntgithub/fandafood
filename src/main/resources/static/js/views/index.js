	console.log("connnect")
var app = angular.module('myHome', []);
app.controller("myHomeController", function($scope, $http){

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