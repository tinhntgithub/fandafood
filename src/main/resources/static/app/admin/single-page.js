var app = angular.module("admin-app", ["ngRoute"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/index",{
		templateUrl:"/admin/admin/admin-dashboard.html",
		controller: "adminIndexCtrl"
	})
	.when("/restaurant/index",{
		templateUrl:"/admin/restaurant/dashboard.html",
		controller: "restaurantIndexCtrl"	
	})
	.when("/not-found",{
		templateUrl:"/assets/admin/banner/list.html",
		controller: "BannerCtrl"		
	})	
	// .when("/spin",{
	// 	templateUrl:"/assets/admin/spin/spin.html",
	// 	controller: "spinCtrl"
	// })
	// .when("/thamgia",{
	// 	templateUrl:"/assets/admin/khachhang/thamgia.html",
	// 	controller: "KhTGCtrl"
	// })
	// .when("/tichdiem",{
	// 	templateUrl:"/assets/admin/khachhang/tichdiem.html",
	// 	controller: "KhTDCtrl"
	// })
	// .when("/doithuong",{
	// 	templateUrl:"/assets/admin/doithuong/list.html",
	// 	controller: "DoiThuongCtrl"
	// })
	.otherwise({
		redirectTo: '/not-found',
	});
})