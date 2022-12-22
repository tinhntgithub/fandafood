var app = angular.module("admin-app", ["ngRoute","angularUtils.directives.dirPagination"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/index",{
		templateUrl:"/admin/admin/admin-dashboard.html",
		controller: "adminIndexCtrl"
	})
	.when("/restaurant/index",{
		templateUrl:"/admin/restaurant/restaurant-dashboard.html",
		controller: "restaurantIndexCtrl"	
	})
	.when("/restaurant/menu",{
		templateUrl:"/admin/restaurant/restaurant-menu.html",
		controller: "restaurantMenuCtrl"	
	})
	.when("/restaurant/order",{
		templateUrl:"/admin/restaurant/restaurant-order.html",
		controller: "restaurantOrderCtrl"	
	})
	.when("/restaurant/review",{
		templateUrl:"/admin/restaurant/restaurant-review.html",
		controller: "restaurantReviewCtrl"	
	})
	.when("/restaurant/food",{
		templateUrl:"/admin/restaurant/restaurant-setting.html",
		controller: "restaurantSettingCtrl"	
	})
	
	.when("/restaurant/voucher",{
		templateUrl:"/admin/restaurant/restaurant-voucher.html",
		controller: "restaurantVoucherCtrl"	
	})
	
	.when("/restaurant/statistical",{
		templateUrl:"/admin/restaurant/restaurant-statistical.html",
		controller: "restaurantStatisticalCtrl"	
	})
	.when("/manager/account",{
		templateUrl:"/admin/admin/account-dashboard.html",
		controller: "accountController"	
	})
	
	.when("/manager/review",{
		templateUrl:"/admin/admin/review-dashboard.html",
		controller: "reviewController"	
	})
		
	.when("/manager/phanquyen",{
		templateUrl:"/admin/admin/phanquyen-dashboard.html",
		controller: "phanquyenController"	
	})
	
	.when("/manager/location",{
		templateUrl:"/admin/admin/location-dashboard.html",
		controller: "locationController"	
	})
	
	.when("/manager/foodcate",{
		templateUrl:"/admin/admin/foodcate-dashboard.html",
		controller: "foodcateController"	
	})
	
	.when("/manager/restaurant",{
		templateUrl:"/admin/admin/restaurant-dashboard.html",
		controller: "restaurantController"	
	})
	
	.when("/manager/thongke",{
		templateUrl:"/admin/admin/thongke-dashboard.html",
		controller: "thongkeController"	
	})
			
	
	.when("/not-found",{
		templateUrl:"/assets/admin/banner/list.html",
		controller: "BannerCtrl"		
	})	
	.otherwise({
		redirectTo: '/not-found',
	});
})