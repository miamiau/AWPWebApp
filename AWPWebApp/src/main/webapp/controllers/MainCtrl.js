'use strict';

angular.module('myApp').controller('MainCtrl', ['$scope', '$rootScope', 'AuthenticationService', function ($scope, $rootScope, AuthenticationService) {
	
	$rootScope.isLoggedIn = AuthenticationService.isLogged;
	
	$rootScope.logOut = function() {
		AuthenticationService.isLogged = false;
    	AuthenticationService.username = '';
		$rootScope.isLoggedIn = false;
	}
    
 }]);