'use strict';


angular.module("myApp").directive("navbar", function() {
  return {
    restrict: "E",         
    replace: true,         
    transclude: true,      
    templateUrl: "templates/navbar.html"    
  }});
;
