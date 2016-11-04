'use strict';

angular.module('myApp.view_allusers', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view_allusers', {
    templateUrl: 'app/view_allusers/view_allusers.html',
    controller: 'View_allusersCtrl'
  });
}])

.controller('View_allusersCtrl', function($http,$scope) {
  $http.get('api/demoadmin/users')
            .success(function (data, status, headers, config) {
              $scope.data = data;
            })
            .error(function (data, status, headers, config) {
              
             });
});
