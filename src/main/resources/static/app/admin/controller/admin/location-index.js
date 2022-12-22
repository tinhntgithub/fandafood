app.controller('locationController',function($scope, $http){
	$scope.listAccount = [];
	$scope.getAllLocation = function() {
		//$hhtp giống axios
		$http.get("/rest/resloca").then(function(response) {
			$scope.items = response.data
	
					
		}).catch(function(error) {
			console.log(error);
		})
		}
		
		$scope.reset = function() {
		$scope.formLoca = {
			location: "",
		};
	}
		
		$scope.formLoca = {};
		//Tạo địa điểm
		$scope.create = function(){

		var item = angular.copy($scope.formLoca);			
						$http.post('/rest/resloca', item).then(function(response) {
								$scope.reset();
								$scope.getAllLocation();
						alert("Thành công")			
            }).catch(function(error){

			console.log(error)
            })		
	}
	
	//Lấy dữ liệu 1 id
	$scope.edit = function (id) {
				 $http.get(`/rest/resloca/${id}`).then(function(response){
					$scope.formLoca = response.data;
            }).catch(function(error){
				console.log(error)

            })
			}
		
		//Xóa 
		
		$scope.delete = function(id, location){
				if (confirm('Bạn có muốn xóa địa điểm: '+ location)) {
					 $http.delete(`/rest/resloca/${id}`).then(function(response){
						$scope.getAllLocation();
					alert("Xóa Thành Công")
          	  }).catch(function(error){
					alert("Xóa Không Thành Công")
					console.log(error);
            })
}
			}
		
		
		
		$scope.getAllLocation();
})