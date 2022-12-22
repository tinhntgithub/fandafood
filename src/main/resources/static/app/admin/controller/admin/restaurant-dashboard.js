app.controller("restaurantController", function($scope, $http, $document){
	
<<<<<<< HEAD
	
	$scope.getAllLocation = function() {
		//$hhtp giống axios
		$http.get("/rest/resloca").then(function(response) {
			$scope.locations = response.data
	
					
		}).catch(function(error) {
			console.log(error);
		})
		}
		$scope.getAllLocation();
	
=======
>>>>>>> 0da8e6354590aa75b65d971f44ab9387520b3144
		$document.ready(function(){
				function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#imagePreview').css('background-image', 'url('+e.target.result +')');
            $('#imagePreview').hide();
            $('#imagePreview').fadeIn(650);
			
			
			
        }
        reader.readAsDataURL(input.files[0]);
        $scope.formRest.mainImage = input.files[0].name;
    }
}

$("#imageUpload").change(function() {
    readURL(this);
});
	$('.remove-img').on('click', function() {
		var imageUrl = "/img/user/noImage.png";
		$('.avatar-preview, #imagePreview').removeAttr('style');
		$('#imagePreview').css('background-image', 'url(' + imageUrl + ')');
		$scope.formRest.mainImage = "";
	});
	})
	
	
	$scope.upload = function(event) {
		var output = document.getElementById('output');
		output.src = URL.createObjectURL(event[0]);
		output.onload = function() {
			URL.revokeObjectURL(output.src) // free memory
		}
		$scope.mainImage = event;
		
	}
$scope.image_new = ""
	
	
	$scope.getAllRestaurant = function() {
		//$hhtp giống axios
		$http.get("/rest/restaurant").then(function(response) {
			$scope.restaurant = response.data
	
					
		}).catch(function(error) {
			console.log(error);
		})
		}
		
		$scope.formRest = {};
		
			//Lấy dữ liệu 1 id
	$scope.edit = function (id) {
				 $http.get(`/rest/restaurant/${id}`).then(function(response){
					$scope.formRest = response.data;
            }).catch(function(error){
				console.log(error)

            })
			}
		
		//Xóa
		$scope.delete = function(id, name){
				if (confirm('Bạn có muốn xóa nhà hàng: '+ name)) {
					 $http.delete(`/rest/restaurant/${id}`).then(function(response){
						$scope.getAllRestaurant();
					alert("Xóa Thành Công")
          	  }).catch(function(error){
					alert("Xóa Không Thành Công")
					console.log(error);
            })
}
			}
			
			//Xóa trắng form
			$scope.reset = function() {
		$scope.formRest = {
			mainImage: null,
			active: true,
		};
	}
			
			
<<<<<<< HEAD
				$scope.image = "r";
=======
			
>>>>>>> 0da8e6354590aa75b65d971f44ab9387520b3144
			
			//Cập nhật
					$scope.update = function(){
	
		var data = new FormData();
<<<<<<< HEAD
		if($scope.image == ""){ 
=======
>>>>>>> 0da8e6354590aa75b65d971f44ab9387520b3144
		data.append('file', $scope.mainImage[0]);

		$http.post("/rest/img/food", data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			
			$scope.image_new = resp.data.name
			var item = angular.copy($scope.formRest);
		item.mainImage = $scope.image_new
	
		$http.put(`/rest/restaurant`,item).then(function(response) {
			alert('Cập nhật thành công');
		$scope.getAllRestaurant();
		}).catch(function(error) {
			console.log(error);
			alert('Cập nhật thất bại');
		})
						
		
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		});
<<<<<<< HEAD
		}else{
			var item = angular.copy($scope.formRest);
					$http.put("/rest/restaurant", item).then(function(response) {
									alert("Cập nhật thành công !");
									$scope.getAllRestaurant();
									
								}).catch(function(error) {
									console.log(error);
								})
				}
=======
		
		
>>>>>>> 0da8e6354590aa75b65d971f44ab9387520b3144
	
	}
		
		$scope.getAllRestaurant();
})