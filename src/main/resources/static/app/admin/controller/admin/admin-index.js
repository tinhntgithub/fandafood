app.controller("adminIndexCtrl", function($scope, $http){
	
	$scope.getUser= function() {
		//$hhtp giống axios
		$http.get("/rest/user/current").then(function(response) {
			$scope.accoutuser = response.data				
		}).catch(function(error) {
			console.log(error);
		})
		}
		
	$scope.getUser();	
})