app.controller('foodcateController',function($scope, $http){
	$scope.listAccount = [];
	$scope.getAllFoodCate = function() {
		//$hhtp giống axios
		$http.get("/rest/foodcate").then(function(response) {
			$scope.items = response.data
	
					
		}).catch(function(error) {
			console.log(error);
		})
		}
		
		$scope.reset = function() {
		$scope.formFoodcate = {
			name: "",
		};
	}
		
		$scope.formFoodcate = {};
		//Tạo địa điểm
		$scope.create = function(){

		var item = angular.copy($scope.formFoodcate);			
						$http.post('/rest/foodcate', item).then(function(response) {
								$scope.reset();
								$scope.getAllFoodCate();
						alert("Thành công")			
            }).catch(function(error){

			console.log(error)
            })		
	}
	
	//Lấy dữ liệu 1 id
	$scope.edit = function (id) {
				 $http.get(`/rest/foodcate/${id}`).then(function(response){
					$scope.formFoodcate = response.data;
            }).catch(function(error){
				console.log(error)

            })
			}
		
		//Xóa 
		
		$scope.delete = function(id, name){
				if (confirm('Bạn có muốn xóa thể loại: '+ name)) {
					 $http.delete(`/rest/foodcate/${id}`).then(function(response){
						$scope.getAllFoodCate();
					alert("Xóa Thành Công")
          	  }).catch(function(error){
					alert("Xóa Không Thành Công")
					console.log(error);
            })
}
			}
		
		
		
		$scope.getAllFoodCate();
})