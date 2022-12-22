app.controller("restaurantVoucherCtrl", function($scope, $http)
{
	
	
	
	$scope.listVoucher = [];
	
	
	$scope.getAllVoucherByRes = function() {
		
		$http.get("/rest/voucher/restaurant").then(function(response) {
			$scope.dataVoucher = response.data
			console.log($scope.dataVoucher, "Hiển thị các voucher cho nhà hàng này!");
					
		}).catch(function(error) {
			console.log(error);
		})
		}
		
	$scope.getAllVoucherByRes();
		
		
		
		
	$scope.formVoucher={};
	$scope.formVoucher2={};
	
	$scope.createVoucher = function(){

		var item = angular.copy($scope.formVoucher);
		item.startDate = document.getElementById('startDate').value;
		item.endDate = document.getElementById('endDate').value;
		item.status = true;
		console.log(item,"giá trị items")
		
		$http.get(`/rest/voucher/${item.id}`).then(function(response) {
			$scope.checkData = response.data
			
			if($scope.checkData == null){
				
					if(item.id == null || item.id == ""){
						alert("Mã ưu đãi không thể để trống");
					}
					else if(item.name == null || item.name == ""){
						alert("Tên Ưu đãi không thể để trống");
					}
					
					else if(item.minimum_order == null){
						alert("Giá trị áp dụng ưu đãi không thể để trống");
					}
					
					else if(item.discount == null ){
						alert("Giảm giá không thể để trống");
					}
					else{
						
						if(item.startDate == ""){
							alert("Thời gian bắt đầu ưu đãi không thể để trống");
						}
						else if(item.endDate == "" ){
						   alert("Thời gian kết thúc ưu đãi không thể để trống");
					    }else{
							// thêm voucher
							$http.post(`/rest/voucher`,item).then(function(response) {
								$scope.getAllVoucherByRes();
								$scope.resetVoucher();
					            alert("Thêm ưu đãi thành công !")				
							}).catch(function(error) {
								console.log(error);
							})
					    }
						
						
					}
											
			}else{
				alert("Mã voucher đã tồn tại, vui lòng nhập mã khác nhé !")	
			}
            			
		}).catch(function(error) {
			console.log(error);
		})
		
		
		
		  
		
	}

	
	
	
	$scope.updateVoucher = function(){

		var item = angular.copy($scope.formVoucher2);
		
		var x = document.getElementById('startDate2').value;
		if(x != item.startDate){
			item.startDate = x;
		}
		
		var y = document.getElementById('endDate2').value;
		if(y != item.endDate){
			item.endDate = y;
		}
	
		if(item.id == null || item.id == ""){
						alert("Mã ưu đãi không thể để trống");
					}
					else if(item.name == null || item.name == ""){
						alert("Tên ưu đãi không thể để trống");
					}
					
					else if(item.minimum_order == null){
						alert("Giá trị áp dụng ưu đãi không thể để trống");
					}
					
					else if(item.discount == null ){
						alert("Giảm giá không thể để trống");
					}
					else{
						
						if(item.startDate == ""){
							alert("Thời gian bắt đầu ưu đãi không thể để trống");
						}
						else if(item.endDate == "" ){
						   alert("Thời gian kết thúc ưu đãi không thể để trống");
					    }else{
							// thêm voucher
							$http.post(`/rest/voucher`,item).then(function(response) {
								$scope.getAllVoucherByRes();
					            alert("Thêm ưu đãi thành công !")				
							}).catch(function(error) {
								console.log(error);
							})
					    }
						
						
					}
		
		  
		
	}
			
	$scope.deleteVoucher = function(id){
		if (confirm('Bạn có muốn xóa voucher: '+id)) {
				
			$http.delete(`/rest/voucher/${id}`).then(function(response){			
				    $scope.getAllVoucherByRes();
					alert("Xóa ưu đãi Thành Công")
					console.log(response.data)
            }).catch(function(error){
					alert("Xóa Không Thành Công")

            })	
		  
          }
		
	}
	

		
	$scope.resetVoucher = function() {
		  $scope.formVoucher = {};
	}

      $scope.editVoucher = function(id) {
		 console.log("id đã chọn " + id)	
		$http.get(`/rest/voucher/${id}`).then(function(response) {
			$scope.formVoucher2 = response.data
            console.log($scope.formVoucher,"voucher đã chọn !")					
		}).catch(function(error) {
			console.log(error);
		})
		
        
	    }
		
	
})