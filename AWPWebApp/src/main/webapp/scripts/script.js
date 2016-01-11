var hotelApp = angular.module('hotelApp', [ 'ng-route' ]);

hotelApp.config(function($routeProvider) {
	$routeProvider

	.when('/', {
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	})

	.when('/gallery', {
		templateUrl : 'pages/gallery.html',
		controller : 'galleryController'
	})

	.when('/contact', {
		templateUrl : 'pages/contact.html',
		controller : 'contactController'
	});
});

hotelApp.controller('mainController', function($scope) {
	$scope.message = 'Everyone come and see how good I look!';
});

hotelApp.controller('galleryController', function($scope) {
	$scope.message = 'Look! I am an about page.';
});

hotelApp.controller('contactController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});