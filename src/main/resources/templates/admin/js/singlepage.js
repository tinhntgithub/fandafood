var app = angular.module('MyApp' );
app.config(function ($routeProvider) {
    $routeProvider.when('/admin', {
      templateUrl: 'index.html',
		controller : "MyController"

    }).when('/user', {
        templateUrl: 'usermanager.html',
      			controller : "userManager_Ctrl"
      }).when('/product', {
        templateUrl: 'product.html',
      	controller : "product_Ctrl"
      }).when('/category', {
        templateUrl: 'category.html',
 		controller : "category_Ctrl"
    
      }).when('/imageproduct', {
        templateUrl: 'imageProduct.html',
      	controller : "image_Ctrl"
      }).when('/order', {
        templateUrl: 'order.html',
      		controller : "orderAdmin_Ctrl"
      }).when('/authorizing', {
        templateUrl: 'authorizing.html',
      controller : "authorizing_Ctrl"
      }).otherwise({
      redirectTo: '/trangchu',
	
    })
  })