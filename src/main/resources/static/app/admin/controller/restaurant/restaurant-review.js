app.controller("restaurantReviewCtrl", function($scope, $http){

$scope.getAllReview = function() {
	
		//$hhtp giống axios
		$http.get("/rest/review/restaurant").then(function(response) {
			$scope.dataReview = response.data
			console.log($scope.dataReview,"các đánh giá của nhà hàng");
					
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	
	$scope.getTotalReview = function() {
	
		//$hhtp giống axios
		$http.get("/rest/review/restaurant/totalReview").then(function(response) {
			$scope.dataTotalReview = response.data
			console.log($scope.dataTotalReview,"tổng đánh giá của nhà hàng");
					
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	
	$scope.getAllReview();
	$scope.getTotalReview();
	
})