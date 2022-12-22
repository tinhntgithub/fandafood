app.controller("accountController", function($scope, $http, $document)
{
	$scope.getUser= function() {
		//$hhtp giống axios
		$http.get("/rest/user/current").then(function(response) {
			$scope.accoutuser = response.data				
		}).catch(function(error) {
			console.log(error);
		})
		}
		
	$scope.getUser();	
	
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
        $scope.formUser.avatar = input.files[0].name;
    }
}

$("#imageUpload").change(function() {
    readURL(this);
});
	$('.remove-img').on('click', function() {
		var imageUrl = "/img/user/noImage.png";
		$('.avatar-preview, #imagePreview').removeAttr('style');
		$('#imagePreview').css('background-image', 'url(' + imageUrl + ')');
		$scope.formUser.avatar = "";
	});
	})
	
	$scope.upload = function(event) {
		var output = document.getElementById('output');
		output.src = URL.createObjectURL(event[0]);
		output.onload = function() {
			URL.revokeObjectURL(output.src) // free memory
		}
		$scope.avatar = event;
		
	}
$scope.image_new = ""
	
	$scope.listAccount = [];
	$scope.getAllAccount = function() {
		//$hhtp giống axios
		$http.get("/rest/user").then(function(response) {
			$scope.items = response.data
	
					
		}).catch(function(error) {
			console.log(error);
		})
		}
		$scope.formUser={};
		$scope.formUser.createdate= new Date();
		
		//Tạo 
		$scope.create = function() {
	
		var data = new FormData();
		data.append('file', $scope.avatar[0]);

		$http.post("/rest/img/user", data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			
			$scope.image_new = resp.data.name
			var item = angular.copy($scope.formUser);
		item.avatar = $scope.image_new
	
		$http.post(`/rest/user`,item).then(function(response) {
			alert('Thêm thành công');
		$scope.getAllAccount();
		}).catch(function(error) {
			console.log(error);
			alert('Thêm thất bại');
		})
						
		
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		});
		
		
	}
	//Xóa trắng form
		$scope.reset = function() {
		$scope.isUpdate = false;
		$scope.formUser = {
			createdate: new Date(),
			gender: true,
			active: true,
			email: "",
			avatar: null,
		};
	}
	
	$scope.deleteUser = function(id){
		if (confirm('Bạn có muốn xóa người dùng: ' +`${id}`)) {
		var username = localStorage.getItem('user');
		  $http.get(`/rest/user/${id}`).then(function(response){
			
			var dulieu = response.data;
			if (dulieu !== ""){
					if(id == username){
					alert("Không thể xóa bản thân")
					}
					$scope.successCheckDelete(id);
				
					
				}else {
					alert("Không Thể Xóa Admin")
				}
			
            }).catch(function(error){


            })
}
		
	}
	
	
	$scope.successCheckDelete = function(id){
		  $http.delete(`/rest/user/${id}`).then(function(response){			
				$scope.getAllAccount();
					alert("Xóa Thành Công")
					
            }).catch(function(error){
						console.log(error)
					alert("Xóa Không Thành Công")

            })
	}
	
	//Lấy dữ liệu 1 id
	$scope.isUpdate = false;
			$scope.editUser = function(id) {
				  $http.get(`/rest/user/${id}`).then(function(response){
					$scope.formUser= response.data
					$scope.isUpdate = true;
					
            }).catch(function(error){
				console.log(error)

            })
			
		}
		
		//Cập nhật
			$scope.update = function(){
	
		var data = new FormData();
		data.append('file', $scope.avatar[0]);

		$http.post("/rest/img/user", data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			
			$scope.image_new = resp.data.name
			var item = angular.copy($scope.formUser);
		item.avatar = $scope.image_new
		$http.put(`/rest/user`,item).then(function(response) {
		
			alert('Cập nhật thành công');
		$scope.getAllAccount();
		}).catch(function(error) {
			console.log(error);
			alert('Cập nhật thất bại');
		})
						
		
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		});
		
		
	
	}
		
		
		
		$scope.getAllAccount();
		
});