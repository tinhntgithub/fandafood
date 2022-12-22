var app = angular.module("admin-app", ["ngRoute"]);
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
	.when("/restaurant/setting",{
		templateUrl:"/admin/restaurant/restaurant-setting.html",
		controller: "restaurantSettingCtrl"	
	})
	
	.when("/restaurant/account",{
		templateUrl:"/admin/restaurant/account-dashboard.html",
		controller: "restaurantMenuCtrl"	
	})
	
	.when("/restaurant/voucher",{
		templateUrl:"/admin/restaurant/voucher-dashboard.html",
		controller: "restaurantMenuCtrl"	
	})
	
	.when("/restaurant/review",{
		templateUrl:"/admin/restaurant/review-dashboard.html",
		controller: "restaurantMenuCtrl"	
	})
	
	.when("/not-found",{
		templateUrl:"/assets/admin/banner/list.html",
		controller: "BannerCtrl"		
	})	
	.otherwise({
		redirectTo: '/not-found',
	});
})