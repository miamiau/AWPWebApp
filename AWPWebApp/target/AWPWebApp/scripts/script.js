// create the module and name it hotelApp
var hotelApp = angular.module('hotelApp', ['ngRoute']);

// configure our routes
hotelApp.config(['$routeProvider',
                 function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl : 'pages/home.html',
            controller  : 'mainController'
        })

        // route for the about page
        .when('/gallery', {
            templateUrl : 'pages/gallery.html',
            controller  : 'galleryController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl : 'pages/contact.html',
            controller  : 'contactController'
        }).

        otherwise({
          redirectTo: ''
        });
}]);

// create the controller and inject Angular's $scope
hotelApp.controller('mainController', function($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

hotelApp.controller('galleryController', function($scope) {
    $scope.message = 'Look! I am an about page.';
});

hotelApp.controller('contactController', function($scope) {
    $scope.message = 'Contact us! JK. This is just a demo.';
});