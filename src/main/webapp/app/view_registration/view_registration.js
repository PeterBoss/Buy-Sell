'use strict';

angular.module('myApp.view_registration', ['ngRoute'])
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view_registration', {
                    templateUrl: 'app/view_registration/view_registration.html',
                    controller: 'AppRegistrationController',
                    controllerAs: 'ctrl'
                });
            }])
        .controller('AppRegistrationController', function ($scope) {
            $scope.register = function () {
                console.log("TESTING REGISTRATION");
                console.log($scope.user);
            };
        });