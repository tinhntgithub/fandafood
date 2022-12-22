app.controller("restaurantSettingCtrl", function($scope, $http, $document) {


	$scope.list_food = [];
	
	$scope.getAllFood = function() {

		//$hhtp giống axios
		$http.get("/rest/food/restaurant").then(function(response) {
			$scope.items = response.data
			console.log($scope.items,"cái này là food");

		}).catch(function(error) {
			console.log(error);
		})
	}
	$scope.getAllFood();

	$scope.getAllMenuCate = function() {

		//$hhtp giống axios
		$http.get("/rest/menucate/retaurant").then(function(response) {
			$scope.menucate = response.data
			

		}).catch(function(error) {
			console.log(error);
		})
	}
	$scope.getAllMenuCate();

	$scope.foodCate = [];
	
	$scope.getAllFoodCate = function() {

		$http.get("/rest/foodcate").then(function(response) {
			$scope.foodCate = response.data
			console.log($scope.foodCate,"cái này là foodCate");

		}).catch(function(error) {
			console.log(error);
		})
	}
	$scope.getAllFoodCate();


	$scope.remove_Food = function(id) {

		if (confirm("Bạn có muốn ngừng bán món này chứ ?")) {
			console.log(`Đã xóa món có id : ${id}`);
			
			$http.delete(`/rest/food/${id}`).then(function(response) {
					$scope.getAllFood();
					alert("Xóa thành công !")
				
				}).catch(function(error) {
					console.log(error);
				})
			
		}

	}

	$scope.form = {};
	$scope.form2 = {};
	$scope.imageEdit = "";
	$scope.imageEdit2 = "x";
	
	$scope.upload = function(event) {
		var output = document.getElementById('output');
		output.src = URL.createObjectURL(event[0]);
		output.onload = function() {
			URL.revokeObjectURL(output.src) // free memory
		}
		$scope.image = event;
		$scope.imageEdit = "x";
	}
	
	$scope.upload2 = function(event) {
		var output = document.getElementById('output2');
		output.src = URL.createObjectURL(event[0]);
		output.onload = function() {
			URL.revokeObjectURL(output.src) // free memory
		}
		$scope.image = event;
		$scope.imageEdit2 = "";
	}
	
    $scope.image_new = ""
	$scope.create_food = function() {
		
		var item = angular.copy($scope.form);
		console.log(item,"item đã thêm !");
		
		if(item.name == null || item.name == ""){
				alert("Tên món không để trống !")
			}
			
			else if(item.price == null || item.price == "" ){
				alert("Giá không được để trống và phải lớn hơn 0 !")
			}
			
			else if(item.foodCate == null || item.foodCate == "" ){
				alert("Thể loại món ăn không để trống !")
			}
			
			else if(item.menu_cate == null || item.menu_cate == "" ){
				alert("Menu món ăn không để trống !")
			}
			
			else if(item.status == null){
				alert("Trạng thái không được để trống !")
			}
						
			else{
				
		
			if($scope.imageEdit != ""){				
			var data = new FormData();	
			data.append('file', $scope.image[0]);
			
			$http.post("/rest/img/food", data, {
				transformRequest: angular.identity,
				headers: { 'Content-Type': undefined }
			}).then(resp => {
				
				$scope.image_new = resp.data.name
				
			
			   	item.image = $scope.image_new
				
				$http.post(`/rest/food/`,item).then(function(response) {
					alert("Thêm món thành công !");
					$scope.getAllFood();
					$scope.reset();
				}).catch(function(error) {
					console.log(error);
				})
						
			
			}).catch(error => {
				alert("Lỗi upload hình ảnh");
				console.log("Error", error);
			});
			
			}else{
				alert("ảnh không để trống");
			}
		
		}
		
	}
	
	$scope.update_food = function(){
		
		var item = angular.copy($scope.form2);
			console.log(item,"item của update");
			
			if(item.name == null || item.name == ""){
				alert("Tên món không để trống !")
			}else if(item.price == null || item.price == "" ){
				alert("Giá không được để trống và phải lớn hơn 0 !")
			}
			
			
			else{
				
				if($scope.imageEdit2 == ""){
				var data = new FormData();
				data.append('file', $scope.image[0]);
		
				$http.post("/rest/img/food", data, {
					transformRequest: angular.identity,
					headers: { 'Content-Type': undefined }
				}).then(resp => {
					$scope.imageEdit2 = resp.data.name;
					item.image = resp.data.name;
					
					$http.post(`/rest/food/`,item).then(function(response) {
						alert("Cập nhật món thành công !");
						$scope.getAllFood();
					}).catch(function(error) {
						console.log(error);
					})
					
				}).catch(function(error) {
					console.log("Lỗi update ảnh");
				})
				
			}else{
				item.image = $scope.imageEdit2;
				$http.post(`/rest/food/`,item).then(function(response) {
				alert("Cập nhật món thành công !");
				$scope.getAllFood();
				}).catch(function(error) {
					console.log(error);
				})
			}
				
			}
			
						
			
		   
	
	
		

	}



	$scope.edit_food = function(id) {

		$http.get(`/rest/food/${id}`).then(function(response) {
			$scope.foodSelect = response.data;
			
			$scope.imageEdit2 = $scope.foodSelect.image;
			
			console.log($scope.foodSelect,$scope.foodSelect.image);
			
			$scope.form2 = response.data;
			
			

		}).catch(function(error) {
			console.log(error);
		})

	}
	
	$scope.reset = function() {
		$scope.form = {		
		};
		
		$scope.form.image = "";
	}






})