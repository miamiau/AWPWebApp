'use strict';

angular.module('myApp').controller('SignupCtrl', ['$scope', 'AccountService', '$location', function ($scope, AccountService, $location) {
	
    $scope.account = {};
    $scope.repeatedPass = "";
    $scope.account.id = "";
    
	$scope.addAccount = function() {
		$scope.account.id = new Date().getTime();
    	AccountService.save($scope.account, function() {
    	    console.log("Added account!");
    	  });
    	$location.path('/login'); 
    }
    
 }]);