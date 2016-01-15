'use strict';

angular.module('myApp').controller('GalleryCtrl', ['$scope', '$rootScope', 'AuthenticationService', function ($scope, $rootScope, AuthenticationService) {
	
	$rootScope.isLoggedIn = AuthenticationService.isLogged;
    
 }]);