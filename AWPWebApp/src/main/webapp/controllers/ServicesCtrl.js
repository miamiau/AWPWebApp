'use strict';

angular.module('myApp').controller('ServicesCtrl', ['$scope', '$rootScope', 'AuthenticationService', function ($scope, $rootScope, AuthenticationService) {
	
	$rootScope.isLoggedIn = AuthenticationService.isLogged;
    
 }]);