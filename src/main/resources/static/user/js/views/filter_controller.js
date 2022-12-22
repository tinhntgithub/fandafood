var app = angular.module('mySearch', ['angularUtils.directives.dirPagination']);
app.controller('search_controller', function($scope, $http) {
	console.log("connect")

	$scope.list_restaraunt = [];
	$scope.list_food = [];
	$scope.status_filter = true;
	$scope.input_restaraunt = "";


	$scope.getAll_restaraunt = function() {
		$http.get(`/rest/restaurant`)
			.then(resp => {
				$scope.list_restaraunt = resp.data
				console.log($scope.list_restaraunt)

			})
			.catch(err => {
				console.log(err)
			})
	}

	$scope.getAll_food = function() {
		$http.get(`/rest/food`)
			.then(resp => {
				$scope.list_food = resp.data

			})
			.catch(err => {
				console.log(err)
			})
	}

	$scope.input_food = ""
	$scope.search_food = function() {

		if ($scope.input_food == "") {
			$scope.getAll_food()
		} else {

			$http.get(`/rest/food/search/${$scope.input_food}`)
				.then(resp => {

					$scope.list_food = resp.data
					
				})
				.catch(err => {
					console.log(err)
				})
		}
	}


	$scope.search_restaraunt = function() {
	
		if ($scope.input_restaraunt == "") {
			$scope.getAll_restaraunt()
		} else {
			$http.get(`/rest/restaurant/search/${$scope.input_restaraunt}`)
				.then(resp => {
					$scope.list_restaraunt = resp.data

				})
				.catch(err => {
					console.log(err)
				})
		}

	}

	$scope.change_status = function() {
		$scope.status_filter = true;
	}

	$scope.change_status_false = function() {
		$scope.status_filter = false;
	}

	$scope.getAll_restaraunt()
	$scope.getAll_food()
	 $scope.list_favorite = [];

		$scope.loading_favorite =  function(){
			$http.get(`/rest/fav`)
				.then(resp => {
					$scope.list_favorite = resp.data
					
				})
				.catch(err => {
					console.log(err)
				})
		}
	

	$scope.loading_favorite();

	
	 $scope.dislike =  function(id){
		
		$http.get(`/rest/fav/dislike/${id}`)
				.then(resp => {
						$scope.loading_favorite();
		$scope.loadAll_favorite ()

				})
				.catch(err => {
					console.log(err)
				})
	}
	$scope.loading_favorite()
		 $scope.like =  function(id){
		$http.post(`/rest/fav/like/${id}`)
				.then(resp => {
						$scope.loading_favorite();
		$scope.loadAll_favorite ()

				})
				.catch(err => {
					console.log(err)
				})
	}
	$scope.list_your_favorite = [];
	
	$scope.loadAll_favorite = function(){
		$http.get(`/rest/fav`)
				.then(resp => {
						
		$scope.list_your_favorite = resp.data
	

				})
				.catch(err => {
					console.log(err)
				})
	}
	
	$scope.loadAll_favorite ()
		//ssssssssssssssssssss
	function toastFunction() {
		var x = document.getElementById("toast");
		x.className = "show";
		setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
	}
	function toast_err_Function() {
		var x = document.getElementById("toast_error");
		x.className = "show";
		setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
	}
	
	$scope.quantity = 1;
	$scope.cart = {

		items: {},
		

		//lấy sản phẩm về

		add(id , rest_id) {
			
			$http.get(`/rest/food/${id}`).then(resp => {
				this.items = resp.data;
				
				this.save(rest_id)

			})



		},
		// post vào csdl
		save(id_rest) {
			
			var cartitem = {
				food: this.items,
				qty: $scope.quantity,
				restaurant: { restaurantId: id_rest }

			}

			var json = JSON.stringify(angular.copy(cartitem));
		console.log(json)

			$http.post(`/rest/cart`, json)
				.then(function(resp) {
					$scope.alert_text = "Thêm vào giỏ hàng thành công"
					toastFunction()
			
				}).catch(function(error) {
					$scope.alert_error = "Thêm vào giỏ hàng không thành công"
					toast_err_Function()
				})

		},

	}
	
	
	
});