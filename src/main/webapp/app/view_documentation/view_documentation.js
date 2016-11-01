'use strict';
angular.module('myApp.view_documentation', ['ngRoute'])

        .config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view_documentation', {
    templateUrl: 'app/view_documentation/view_documentation.html'
    
  });
}]);