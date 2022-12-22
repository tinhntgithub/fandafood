app.controller("reviewController", function($scope, $http, $document){

$scope.getAllReview = function() {
	
		//$hhtp giống axios
		$http.get("/rest/review").then(function(response) {
			$scope.items = response.data
					
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	$scope.getAllRestaurant = function() {
	
		//$hhtp giống axios
		$http.get("/rest/restaurant").then(function(response) {
			$scope.restaurant = response.data
					
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	$scope.getReviewInRestaurant = function(id) {
				  $http.get(`/restaurant/review/${id}`).then(function(response){
					$scope.reviews = response.data
					if($scope.reviews==""){
						alert("Không có đánh giá cho cửa hàng này")

					}else{
						console.log(error)
					}		
            }).catch(function(error){
				console.log(error)

            })
			
		}
		
	$scope.getAllRestaurant();
		$scope.getAllReview();
})