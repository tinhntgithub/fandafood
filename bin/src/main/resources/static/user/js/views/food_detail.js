
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

	$scope.remove_cart = function(id) {
		$http.delete(`/rest/cart/${id}`)
			.then(function(resp) {

				$scope.loading_cart();
			}).catch(function(error) {
				alert("Không Thành Công")
			})
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
		$scope.form_address.city = a;
		$scope.form_address.districts = b;
		$scope.form_address.wards = c;

		var json = JSON.stringify(angular.copy($scope.form_address));

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

		$scope.form_address.city = a;
		$scope.form_address.districts = b;
		$scope.form_address.wards = c;


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



				$scope.isStatus = true;
				$scope.form_address = resp.data;
				$scope.loading_address();
			}).catch(function(error) {
				console.log(error)
			})

	}

	$scope.choose = function(id) {

		$http.get(`/rest/address/choose/${id}`)
			.then(function(resp) {

				$scope.loading_address();
				$scope.loading_address_true();
			}).catch(function(error) {
				console.log(error)
			})
	}

	$scope.remove_address = function(id) {

		if (confirm("Bạn có muốn xóa địa chỉ này ?")) {
			$http.delete(`/rest/address/${id}`)
				.then(function(resp) {

					$scope.loading_address();
				}).catch(function(error) {
					alert("Bạn không thể xóa địa chỉ này")
				})
		}

	}




	$scope.reset_form = function() {
		$scope.form_address = {};

		$scope.isStatus = false;
	}



	$scope.loading_address();

	$scope.username = "";

	$scope.loadinguser = function() {
		var user = document.getElementById("remote_user").innerText;
		$http.get(`/rest/user/${user}`)
			.then(resp => {
				$scope.username = resp.data.firstname + " " + resp.data.lastname
			})
			.catch(err => {
			})
	}

	$scope.city_show = "";
	$scope.districts_show = "";
	$scope.wards_show = "";


	$scope.loading_address_true = function() {
		$http.get(`/rest/address/address_true`)
			.then(resp => {
				$scope.city_show = resp.data.city;
				$scope.districts_show = resp.data.districts;
				$scope.wards_show = resp.data.wards;
				$scope.address_id = resp.data.id
				$scope.address_pay = resp.data;
			})
			.catch(err => {
			})
	}

	$scope.loading_address_true()
	$scope.loadinguser()

	$scope.order_form = {}

	$scope.order_pay = function() {
		var value = {

			address: $scope.address_pay,
			note: $scope.order_form.note,
			total: $scope.list_cart_sum,
			status: 1,
		}

		var json = JSON.stringify(angular.copy(value));
		$http.post(`/rest/order`, json)
			.then(resp => {

			})
			.catch(err => {
			})
	}




	$scope.order = {
		date: new Date(),
		address: "",
		note: $scope.order_form.note,
		total: $scope.list_cart_sum,
		status: 0,
		get orderDetails() {
			return $scope.list_cart.map(item => {
				return {
					food: { food_id: item.food.food_id },
					price: item.food.price,
					quantity: item.qty
				}
			})
		},
		pay() {

			var orderd = angular.copy(this);
			orderd.address = $scope.address_pay;
			var json = JSON.stringify(angular.copy(orderd));
			$http.post(`/rest/order`, json)
				.then(resp => {
					alert("Đặt hàng thành Công")
				this.clearcart();
				})
				.catch(err => {
					console.log(err)
				})
		},
		clearcart() {
			$http.delete(`/rest/cart/clearCart/${document.getElementById("remote_user").innerText}`).then(resp => {
				$scope.loading_cart();
				$scope.sumCart();
				
				console.log(resp);
			}).catch(error => {
				console.log(error);
			})
		}

	}






	$scope.list =[];
	$scope.list_detail =[];
	$scope.trangthai = true;
	$scope.getStatusOrder = function(status){
		$scope.trangthai = false;
		$http.get(`/rest/order/myorder?status=${status}`).
		then(resp =>{
			$scope.list=resp.data
			
		})	
		.catch(err => {
			
		})
		
		$http.get(`/rest/odetail`).
		then(resp =>{
			$scope.list_detail =resp.data
			
		})
		.catch(err => {
			
		})
		
		
	}


	$scope.loaddefault = function(){
		$http.get(`/rest/order/myorder?status=1`).
		then(resp =>{
			$scope.list=resp.data
			console.log(resp.data)
		})	
		.catch(err => {
			
		})
		$http.get(`/rest/odetail`).
		then(resp =>{
			$scope.list_detail =resp.data
			
		})
		.catch(err => {
			
		})
	}
	
	
$scope.loaddefault();







	var citis = document.getElementById("city");
	var districts = document.getElementById("district");
	var wards = document.getElementById("ward");

	var a = ""
	var b = ""
	var c = ""

	var Parameter = {
		url: "https://raw.githubusercontent.com/ThanhLMPC02344/apimientay/main/.github/workflows/jekyll.yml",
		method: "GET",
		responseType: "application/json",
	};
	var promise = axios(Parameter);
	promise.then(function(result) {
		if (window.location.pathname == "/home/checkout") {
			renderCity(result.data);
		}


	});

	function renderCity(data) {
		for (const x of data) {

			citis.options[citis.options.length] = new Option(x.Name, x.Id);
		}

		citis.onchange = function(e) {
			a = e.target.options[e.target.selectedIndex].text;

			district.length = 1;
			ward.length = 1;
			if (this.value != "") {

				const result = data.filter(n => n.Id === this.value);


				for (const k of result[0].Districts) {

					district.options[district.options.length] = new Option(k.Name, k.Id);

				}
			}
		};
		district.onchange = function(e) {

			b = e.target.options[e.target.selectedIndex].text;

			ward.length = 1;
			const dataCity = data.filter((n) => n.Id === citis.value);
			if (this.value != "") {
				const dataWards = dataCity[0].Districts.filter(n => n.Id === this.value)[0].Wards;


				for (const w of dataWards) {

					wards.options[wards.options.length] = new Option(w.Name, w.Id);
				}

			}
		};
		wards.onchange = function(e) {

			c = e.target.options[e.target.selectedIndex].text;

		}

	}



});