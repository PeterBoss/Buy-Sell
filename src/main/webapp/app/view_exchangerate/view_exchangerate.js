'use strict';

angular.module('myApp.view_exchangerate', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view_exchangerate', {
              templateUrl: 'app/view_exchangerate/view_exchangerate.html',
              controller: 'View2Ctrl'
          
                });
          }]);

        

