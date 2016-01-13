angular
	.module('myApp', ['ngRoute'])
	.config(['$routeProvider',function($routeProvider) {
	  $routeProvider
	   .when('/', {
		   templateUrl: 'templates/home.html',
		   controller: 'HomeCtrl',
	   })
	  .when('/services', {
		  templateUrl: 'templates/services.html',
		  controller: 'ServicesCtrl'
	  })
	  .when('/gallery', {
		  templateUrl: 'templates/gallery.html',
		  controller: 'GalleryCtrl'
	  })
	  .when('/reservation', {
		  templateUrl: 'templates/reservation.html',
		  controller: 'ReservationCtrl'
	  })
	  .when('/contact', {
		  templateUrl: 'templates/contact.html',
		  controller: 'ContactCtrl'
	  })
      .otherwise({
          redirectTo: '/'
        });
	}]);