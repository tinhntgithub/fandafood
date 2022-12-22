app.controller("restaurantMenuCtrl", function($scope, $http){
	
	$scope.getAllMenuCate = function() {

		$http.get(`/rest/menucate/retaurant`,).then(function(response) {
			$scope.items = response.data
			console.log($scope.items);

		}).catch(function(error) {
			console.log(error);
		})
	}
		
	$scope.getAllMenuCate();

	$scope.formMenu = {};
	$scope.formMenu2 = {};
	
	$scope.createMenuCate = function() {

		var item = angular.copy($scope.formMenu)
		console.log(item)
		
		if(item.cate_name == null || item.cate_name == ""){
			alert("Tên thể loại không được để trống !")
		}else{
	    
		$http.post(`/rest/menucate/`,item).then(function(response) {
			alert("Thêm thể loại thành công !")
			$scope.getAllMenuCate();
			$scope.resetMenuCate();
		}).catch(function(error) {
			console.log(error);
		})
		
		}
		
	}
	
	$scope.updateMenuCate = function() {

		var item = angular.copy($scope.formMenu2)
		console.log(item)
		
		if(item.cate_name == null || item.cate_name == ""){
			alert("Tên thể loại không được để trống !")
		}else{
	    
		$http.post(`/rest/menucate/`,item).then(function(response) {
			alert("Cập nhật thể loại thành công !")
			$scope.getAllMenuCate();
		}).catch(function(error) {
			console.log(error);
		})
		
		}
		
	}
	
	$scope.selectMenuCate = function(id) {
    	
		$http.get(`/rest/menucate/${id}`,).then(function(response) {
			$scope.formMenu2 = response.data
		}).catch(function(error) {
			console.log(error);
		})
		
	}
	
	$scope.resetMenuCate = function(id) {
    	
		$scope.formMenu = {};
		
	}
	
	$scope.deleteMenuCate = function(id) {
    	
		if (confirm("Bạn có muốn xóa thể loại này chứ ?")) {
		
			$http.delete(`/rest/menucate/${id}`,).then(function(response) {
				alert("Đã xóa thành công !");
				$scope.getAllMenuCate();
			}).catch(function(error) {
				alert("Xóa thất bại, Thể loại có món ăn không thể xóa !")
			})
		
		}
		
	}
	
	
	
	





})