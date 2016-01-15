'use strict';

angular.module('myApp')
.factory('AccountService', function($resource) {
  return $resource('/HotelApp/rest/awp/account/:email'); 
}).factory('AuthenticationService', function() {
	  var credentials = {
	    isLogged: false,
	    username: ''
	  };
	  return credentials;
});