/**
 * 
 */
console.log("connnect")

var app = angular.module('myHihi', ['angularUtils.directives.dirPagination']);
app.controller('restaurant_detail', function($scope, $http) {
	var id_res = document.getElementById("restaurantId").innerText;

	$scope.alert_text = ""
	$scope.alert_error = ""


	$scope.reviewRestaurant = [];

	$scope.loadReviewRestaurant = function(id) {
		$http.get(`/rest/review/${id}`).then(function(response) {
			$scope.hihi = response.data;

		}).catch(function(error) {
			console.log(error)
		})
	}
	$scope.quantity = 1;
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
				restaurant: { restaurantId: id_res }

			}

			var json = JSON.stringify(angular.copy(cartitem));


			$http.post(`/rest/cart`, json)
				.then(function(resp) {
					$scope.alert_text = "Thêm vào giỏ hàng thành công"
					toastFunction()
					$scope.loadAll_cart()
				}).catch(function(error) {
					$scope.alert_error = "Thêm vào giỏ hàng không thành công"
					toast_err_Function()
				})

		},

	}

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

	$scope.qty_incr = function() {

		$scope.quantity = $scope.quantity + 1;
	}
	$scope.qty_decr = function() {
		if ($scope.quantity > 1) {
			$scope.quantity = $scope.quantity - 1;
		}

	}

	$scope.listCart_res = [];

	$scope.loadAll_cart = function() {
		
		$http.get(`/rest/cart/restaraunt/${id_res}`)
			.then(function(resp) {
				$scope.listCart_res = resp.data;
				$scope.list_cart_lenght = resp.data.length;
				$scope.sumCart()
			}).catch(function(error) {

			})
	}

	$scope.loadAll_cart()

	$scope.remove_cart = function(id) {
		$http.delete(`/rest/cart/${id}`)
			.then(function(resp) {
				$scope.alert_text = "Xóa món ăn thành công"
				toastFunction()
				$scope.loadAll_cart()
				$scope.sumCart()
			}).catch(function(error) {
				$scope.alert_error = "Xóa món ăn không thành công"
				toast_err_Function()
			})
	}


	$scope.qty_incr_update = function(item) {

		var value = {
			food: item.food,
			qty: item.qty + 1,
			restaurant: { restaurantId: id_res }
		}


		var json = JSON.stringify(angular.copy(value));

		$http.put(`/rest/cart/${item.id}`, json).then(resp => {
			$scope.alert_text = "Cập nhật giỏ hàng thành công"
			toastFunction()
			$scope.loadAll_cart()
		}).catch(function(error) {

			$scope.alert_error = "Cập nhật giỏ hàng thành công"
			toast_err_Function()
		})

	}
	$scope.qty_decr_update = function(item) {
		if (item.qty == 1) {
			$http.delete(`/rest/cart/${item.id}`).then(resp => {
				$scope.alert_text = "Cập nhật giỏ hàng thành công"
					toastFunction()
				$scope.loadAll_cart()
			}).catch(function(error) {
				$scope.alert_error = "Cập nhật giỏ hàng không thành công"
					toast_err_Function()

			})
		} else {
			var value = {
				food: item.food,
				qty: item.qty - 1,
				restaurant: { restaurantId: id_res }
			}


			var json = JSON.stringify(angular.copy(value));

			$http.put(`/rest/cart/${item.id}`, json).then(resp => {
				$scope.alert_text = "Cập nhật giỏ hàng thành công"
					toastFunction()
				$scope.loadAll_cart()
			}).catch(function(error) {
				$scope.alert_error = "Cập nhật giỏ hàng không thành công"
					toast_err_Function()
			})

		}
	}



	$scope.sumCart = function() {


		$http.get(`/rest/cart/sum/${id_res}`).then(function(response) {
			$scope.list_cart_sum = response.data

		}).catch(function(error) {
			console.log(error)

		})

	}

	$scope.delivery_id = 0
	$scope.load_delivery_true = function() {
		$http.get(`/rest/address/address_true`).then(function(response) {

			$scope.address_true_check = response.data;
		
			if ($scope.address_true_check != null) {
				$scope.delivery_id = response.data.id

				$scope.address_true = response.data.city + "/" + response.data.districts + "/" + response.data.wards
			}
		}).catch(function(error) {
			console.log(error)

		})
	}


	$scope.load_delivery_true()




	$scope.click_voucher = function(result) {
		$scope.result = result

	}

	$scope.discount = 0
	$scope.click_voucher_apply = function() {
		console.log($scope.result)

		if ($scope.result == undefined) {
			$scope.alert_error = "Mã hết hạng hoặc không được áp dụng với đơn của bạn"
					toast_err_Function()
			
		} else {
			$http.get(`/rest/voucher/${$scope.result}`).then(function(response) {
			
				$scope.discount = response.data.discount
					$scope.alert_text = `Mã `+$scope.result +" Đã được sử dụng . Đơn hàng giảm "+$scope.discount +"k" 
					toastFunction()
			}).catch(function(error) {
				$scope.alert_error = "Mã hết hạng hoặc không được áp dụng với đơn của bạn"
					toast_err_Function()
			})

		}

	}


	$scope.order_form = {}
	$scope.order = {
		date: new Date(),
		address: "",
		note: $scope.order_form.note,
		total: 0,
		status: 0,
		restaurant: { restaurantId: "" },
		voucher: { id: "" },
		get orderDetails() {
			return $scope.listCart_res.map(item => {
				return {
					food: { food_id: item.food.food_id },
					price: item.food.price,
					quantity: item.qty
				}
			})
		},
		pay() {


			console.log($scope.address_true_check)


			if ($scope.address_true_check == null) {

				$(document).ready(function() {
					$("#exampleModalAddress").modal('show');
				});

			} else {
				var orderd = angular.copy(this);
				orderd.address = $scope.address_pay;
				orderd.voucher.id = $scope.result;
				orderd.restaurant.restaurantId = id_res;
				orderd.total = $scope.list_cart_sum + $scope.discount

				var json = JSON.stringify(angular.copy(orderd));

				let text = "Bạn có muốn đặt hàng ? ";
				if (confirm(text) == true) {
					$http.post(`/rest/order`, json)
						.then(resp => {
							$scope.alert_text = "Đặt hàng thành Công"
					toastFunction()
							
							$scope.discount = 0
							$scope.result = ""
							this.clearcart();
						})
						.catch(err => {
							$scope.alert_error = "Đặt hàng không thành công"
					toast_err_Function()
						})
				}



			}


		},
		clearcart() {
			$http.delete(`/rest/cart/clearCart/${document.getElementById("remote_user").innerText}`).then(resp => {
				$scope.loadAll_cart()
				$scope.sumCart();

				console.log(resp);
			}).catch(error => {
				console.log(error);
			})
		}

	}

	$scope.array = [];

	$scope.loadingVoucher = function() {
		$http.get(`/rest/voucher`)
			.then(resp => {
				$scope.array = resp.data
				console.log(resp)
			})
			.catch(err => {
				console.log(err)
			})
	}

	$scope.loadingVoucher_apply = function() {
		$http.get(`/rest/voucher`)
			.then(resp => {
				$scope.array = resp.data
				console.log(resp)
			})
			.catch(err => {
				console.log(err)
			})
	}

	$scope.loading_apply = function() {
		$http.get(`/rest/voucher/apply`)
			.then(resp => {
				$scope.array = resp.data
				
			})
			.catch(err => {
				console.log(err)
			})
	}
	$scope.loading_apply();


	$scope.difference_date = function(current_date, end_Date) {

		var end = new Date(end_Date);
		var current = new Date(current_date);
		const time = Math.abs(current - end);

		const diffInDays = Math.ceil(time / (1000 * 60 * 60 * 24));

		return diffInDays;

	}




	$scope.form_address = {};

	$scope.create_address = function() {
		$scope.form_address.city = a;
		$scope.form_address.districts = b;
		$scope.form_address.wards = c;

		var json = JSON.stringify(angular.copy($scope.form_address));

		$http.post(`/rest/address`, json)
			.then(function(resp) {
	
				$("#exampleModalAddress").modal('hide');
				$scope.alert_text = "Thêm vị trí giao hàng thành công"
					
				toastFunction()
				$scope.load_delivery_true();
			}).catch(function(error) {
				console.log(error)
			})

	}


	$scope.update_address = function() {
	
	
		if($scope.form_address.city == "" ,$scope.form_address.districts == "",
		$scope.form_address.wards == "" ){
			$scope.form_address.city = a;
			$scope.form_address.districts = b;
			$scope.form_address.wards = c;
		}else{
			$scope.form_address.city = a;
			$scope.form_address.districts = b;
			$scope.form_address.wards = c;
		}
		
		


		var json = JSON.stringify(angular.copy($scope.form_address));

		var id_add = $scope.form_address.id
		$http.put(`/rest/address/${id_add}`, json)
			.then(function(resp) {

				$("#exampleModalAddress").modal('hide')
				$scope.alert_text = "Cập nhật vị trí thành công"
					
				toastFunction()
				$scope.load_delivery_true()


			}).catch(function(error) {
				$scope.alert_error = "Cập nhật vị trí không thành công"
					toast_err_Function()
			})

	}


	$scope.edit_address = function() {
		$http.get(`/rest/address/${$scope.delivery_id}`)
			.then(function(resp) {

				$(document).ready(function() {
					$("#exampleModalAddress").modal('show');
				});
				$scope.isStatus = false;
				$scope.form_address = resp.data;

			}).catch(function(error) {
				console.log(error)
			})

	}












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


		renderCity(result.data);




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