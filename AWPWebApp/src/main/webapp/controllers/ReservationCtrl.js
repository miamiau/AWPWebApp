'use strict';

angular.module('myApp').controller('ReservationCtrl', ['$scope', '$rootScope', 'AuthenticationService', function ($scope, $rootScope, AuthenticationService) {
	
	$rootScope.isLoggedIn = AuthenticationService.isLogged;
    
 }]);