'use strict';

angular.module('myApp').controller('ContactCtrl', ['$scope', '$rootScope', 'AuthenticationService', function ($scope, $rootScope, AuthenticationService) {
	
	$rootScope.isLoggedIn = AuthenticationService.isLogged;
	
 }]);