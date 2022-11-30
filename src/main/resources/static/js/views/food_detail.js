var app = angular.module('myApp', []);
app.controller('Food_Detail_Controller', function($scope, $http) {

	$scope.quantity = 1;

	$scope.qty_incr = function() {

		$scope.quantity = $scope.quantity + 1;
	}
	$scope.qty_decr = function() {
		if ($scope.quantity > 1) {
			$scope.quantity = $scope.quantity - 1;
		}

	}
	$scope.list_cart = []
	$scope.list_cart_qty = 0
	$scope.list_cart_lenght = 0
	$scope.list_cart_sum = 0

	$scope.loading_cart = function() {
		$http.get(`/rest/cart`)
			.then(function(resp) {
				$scope.list_cart = resp.data
				$scope.list_cart_lenght = resp.data.length;
				$scope.sumCart()
			}).catch(function(error) {
				console.log(error)
			})
	}

	$scope.sumCart = function() {


		$http.get(`/rest/cart/sum`).then(function(response) {
			$scope.list_cart_sum = response.data
		}).catch(function(error) {
			console.log(error)

		})

	}



	$scope.loading_cart();



	$scope.qty_incr_update = function(item) {

		var value = {
			food: item.food,
			qty: item.qty + 1,
		}


		var json = JSON.stringify(angular.copy(value));

		$http.put(`/rest/cart/${item.id}`, json).then(resp => {
			$scope.loading_cart();
		}).catch(function(error) {
			alert("Cập Nhật Không Thành Công")
			console.log(error)
		})

	}
	$scope.qty_decr_update = function(item) {
		if (item.qty == 1) {
			$http.delete(`/rest/cart/${item.id}`).then(resp => {
				$scope.loading_cart();
			}).catch(function(error) {
				alert(error)

			})
		} else {
			var value = {
				food: item.food,
				qty: item.qty - 1,
			}


			var json = JSON.stringify(angular.copy(value));

			$http.put(`/rest/cart/${item.id}`, json).then(resp => {
				$scope.loading_cart();
			}).catch(function(error) {
				alert("Cập Nhật Không Thành Công")
				console.log(error)
			})

		}
	}










	$scope.cart = {

		items: {},


		//lấy sản phẩm về

		add(id) {

			$http.get(`/rest/food/${id}`).then(resp => {
				this.items = resp.data;

				this.save()

			})



		},
		// post vào csdl
		save() {
			var cartitem = {
				food: this.items,
				qty: $scope.quantity,


			}

			var json = JSON.stringify(angular.copy(cartitem));


			$http.post(`/rest/cart`, json)
				.then(function(resp) {
					alert("Thành Công")

				}).catch(function(error) {
					alert("Không Thành Công")
				})

		},

	}

	$scope.list_address = []
	$scope.form_address = {};
	$scope.isStatus = false;
	$scope.loading_address = function() {

		$http.get(`/rest/address/user`)
			.then(function(resp) {
				$scope.list_address = resp.data;
				
			}).catch(function(error) {
				console.log(error)
			})

	}

	$scope.create_address = function() {
		var json = JSON.stringify(angular.copy($scope.form_address));
		console.log(json)
		$http.post(`/rest/address`, json)
			.then(function(resp) {
					$("#exampleModal").modal('hide');
				alert("Thêm thành công")
				$scope.loading_address();
			}).catch(function(error) {
				console.log(error)
			})

	}
	
	
		$scope.update_address = function() {
		var json = JSON.stringify(angular.copy($scope.form_address));
		var id_add = $scope.form_address.id
		$http.put(`/rest/address/${id_add}`, json)
			.then(function(resp) {
				
				$("#exampleModal").modal('hide')
					
				
			
				$scope.loading_address();
			}).catch(function(error) {
				alert(error)
				console.log(error)
			})

		}


	
	$scope.edit_address = function(id) {
		
		$http.get(`/rest/address/${id}`)
			.then(function(resp) {
				$scope.isStatus=true;
				$scope.form_address = resp.data;
				$scope.loading_address();
			}).catch(function(error) {
				console.log(error)
			})

	}


	$scope.reset_form = function(){
			$scope.form_address = {};
		$scope.isStatus = false;
	}



	$scope.loading_address();








});