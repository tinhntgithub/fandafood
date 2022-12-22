app.controller("restaurantStatisticalCtrl", function($scope, $http)
{
	
	$scope.countOrder = 0;
	$scope.totalOrder = 0;
	
	$scope.getStatistical = function() {

		//$hhtp giống axios
		$http.get("/rest/statistical/restaurant").then(function(response) {
			$scope.items = response.data
			console.log($scope.items,"cái này là ds oder đã hoàn thành");
			$scope.getStatisticalTotal();
		}).catch(function(error) {
			console.log(error);
		})
		
		
		
	}
	
	
	$scope.dateStart = "";
	$scope.dateEnd = "";
	
	$scope.getStatisticalByDate = function() {
		
		 $scope.dateStart = document.getElementById('dateStart').value;
	     $scope.dateEnd = document.getElementById('dateEnd').value;
		
		if($scope.dateStart == "" || $scope.dateStart == null){
			alert("Ngày bắt đầu không để trống !")
		}else if($scope.dateEnd == "" || $scope.dateEnd == null){
			alert("Ngày kết thúc không để trống !")
		}else{
			//$hhtp giống axios
			$http.get(`/rest/statistical/restaurant/date?dateStart=${$scope.dateStart}&&dateEnd=${$scope.dateEnd}`,).then(function(response) {
				$scope.items = response.data
				console.log($scope.items,"cái này là ds oder theo thời gian nha !");
				
				$scope.getStatisticalTotalByDate();
				
			}).catch(function(error) {
				console.log(error);
			})
		}
		
		
	}
	
	
	$scope.getStatisticalTotal = function() {

		$http.get("/rest/statistical/total").then(function(response) {
			$scope.items2 = response.data
			console.log($scope.items2,"cái này là items2");
			
			$scope.countOrder = $scope.items2[0][1];
	        $scope.totalOrder = $scope.items2[0][0];
			
						
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	$scope.getStatisticalTotalByDate = function() {

		$http.get(`/rest/statistical/total/date?dateStart=${$scope.dateStart}&&dateEnd=${$scope.dateEnd}`).then(function(response) {
			$scope.items2 = response.data
			console.log($scope.items2,"cái này là items2");
			
			$scope.countOrder = $scope.items2[0][1];
	        $scope.totalOrder = $scope.items2[0][0];
			
						
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	$scope.getStatistical();
	
	
	
	
	
	
		
});