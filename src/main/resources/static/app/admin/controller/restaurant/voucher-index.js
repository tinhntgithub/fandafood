app.controller("voucherController", function($scope, $http, $document)
{
	
	$scope.getAllRestaurant = function() {
		//$hhtp giống axios
		$http.get("/rest/restaurant").then(function(response) {
			$scope.restaurant = response.data
			console.log($scope.restaurant);
					
		}).catch(function(error) {
			console.log(error);
		})
		}
	
	
	$scope.listVoucher = [];
	$scope.getAllVoucher = function() {
		//$hhtp giống axios
		$http.get("/rest/voucher").then(function(response) {
			$scope.items = response.data
			console.log($scope.items);
					
		}).catch(function(error) {
			console.log(error);
		})
		}
		
		$scope.reset = function() {
		$scope.formVoucher = {
			restaurant_id: 1,
		};
	}
		
		$scope.formVoucher={};
		$scope.create = function(){

		var item = angular.copy($scope.formVoucher);
		  $http.get(`/rest/voucher/{id}`).then(function(response){
			$scope.checkdata = response.data;
				if($scope.checkdata==""){
					$http.post('/rest/voucher', item).then(function(response) {
								$scope.reset();
								$scope.getAllVoucher();
						alert("Thành công")
						
					}).catch(function(error) {
						alert("Không thành công")
					})
									
				}else{
					alert("Voucher đã tồn tại")
					console.log($scope.checkdata)
				
				}
            }).catch(function(error){

			console.log(error)
            })
		
	}
		
		$scope.deleteVoucher = function(id){
		if (confirm('Bạn có muốn xóa voucher: ' +`${id}`)) {
		  $http.get(`/rest/voucher/${id}`).then(function(response){
			console.log(response.data)
			var dulieu = response.data;
			if (dulieu !== ""){
					$scope.successCheckDelete();
				
					
				}else {
					alert("Không Thể Xóa Voucher Này")
				}
			
            }).catch(function(error){


            })
}
		
	}
	
	$scope.successCheckDelete = function(id){
		  $http.delete(`/rest/voucher/${id}`).then(function(response){			
				$scope.getAllVoucher();
					alert("Xóa Thành Công")
					console.log(response.data)
            }).catch(function(error){
						console.log(error)
					alert("Xóa Không Thành Công")

            })
	}
		
		
		$scope.getAllVoucher();
		$scope.getAllRestaurant();
	
})