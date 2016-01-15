'use strict';

angular.module('myApp').controller('HomeCtrl', ['$scope', '$rootScope', 'AuthenticationService', function ($scope, $rootScope, AuthenticationService) {
	
	console.log("Loading home controller");
	
	$rootScope.isLoggedIn = AuthenticationService.isLogged;
	
	console.log("User is logged in: ", $scope.isLoggedIn);
    
 }]);