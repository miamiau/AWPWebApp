'use strict';

angular.module('myApp').controller('LoginCtrl', ['$scope', 'AuthenticationService', 'AccountService', '$location', function ($scope, AuthenticationService, AccountService, $location) {
	
	$scope.email = "";
	$scope.password = "";
    
	$scope.login = function() {
    	
    	var account = AccountService.get({ email: $scope.email }, function() {
    	    console.log(account);
    	    if(account.password == $scope.password) {
    	    	AuthenticationService.isLogged = true;
    	    	AuthenticationService.username = account.email;
    	    	$('#loginModal').modal('hide');
    	    	console.log("Authenticated");
    	    	$location.path('/');
    	    } else {
    	    	AuthenticationService.isLogged = false;
    	    	AuthenticationService.username = '';
    	    	$('#loginModal').modal('hide');
    	    	console.log("Not Authenticated");
    	      }
    	    
    	  });
    }
	
	$scope.redirectToRegister = function() {
		$location.path('/signup');
	}
    
 }]);