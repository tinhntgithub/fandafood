app.controller("restaurantIndexCtrl", function($scope, $http){
	
	$scope.testData = "test dữ liệu nha !"
	
	$scope.formRestaurant = {}
	
	$scope.getMyRestaurant = function() {

		//$hhtp giống axios
		$http.get("/rest/restaurant/myRestaurant").then(function(response) {
			$scope.formRestaurant = response.data
			console.log($scope.formRestaurant);
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	
	
	$scope.getLocation = function() {

		//load cái khu vực
		$http.get("/rest/resloca").then(function(response) {
			$scope.locationId = response.data
			
		}).catch(function(error) {
			console.log(error);
		})
	}
	
	$scope.getLocation();
	$scope.getMyRestaurant();
	
	
	//upload ảnh nha
	$scope.upload = function(event) {
		var output = document.getElementById('output');
		output.src = URL.createObjectURL(event[0]);
		output.onload = function() {
			URL.revokeObjectURL(output.src) // free memory
		}
		$scope.image = event;
		$scope.imageEdit = "";
		
		console.log("đã chọn ảnh");
	}
	// kiểm tra đã có chọn ảnh
	$scope.imageEdit = "x";
	
	$scope.updateRestaurant = function() {
		
		$scope.formRestaurant.openTime = document.getElementById('ResOpenTime').value
		$scope.formRestaurant.closeTime = document.getElementById('ResCloseTime').value
		console.log($scope.formRestaurant.openTime);
		console.log($scope.formRestaurant.closeTime);
		var data = new FormData();
		
			if($scope.formRestaurant.name == null || $scope.formRestaurant.name == ""){
				alert("Tên nhà hàng không được để trống !")
			}
			else if($scope.formRestaurant.address == null || $scope.formRestaurant.address == ""){
				alert("Địa chỉ nhà hàng không đưuọc để trống !")
			}else{
				
				
				if($scope.imageEdit == ""){ 
				
				data.append('file', $scope.image[0]);	
				$http.post("/rest/img/food", data, {
					transformRequest: angular.identity,
					headers: { 'Content-Type': undefined }
				}).then(resp => {
					
					$scope.imageEdit = resp.data.name;
					$scope.formRestaurant.mainImage = $scope.imageEdit;
					$http.put("/rest/restaurant/$scope.formRestaurant.restaurantId",$scope.formRestaurant).then(function(response) {
									alert("Cập nhật thành công !");
									$scope.getMyRestaurant();
									
								}).catch(function(error) {
									console.log(error);
								})		
								
				}).catch(error => {
					alert("Lỗi upload hình ảnh");
					console.log("Error", error);
				});
		
		
				}else{
					$http.put("/rest/restaurant/$scope.formRestaurant.restaurantId",$scope.formRestaurant).then(function(response) {
									alert("Cập nhật thành công !");
									$scope.getMyRestaurant();
									
								}).catch(function(error) {
									console.log(error);
								})
				}
				
				
			}
		
		
		
		
		
		
		
		
		
	}
	
})