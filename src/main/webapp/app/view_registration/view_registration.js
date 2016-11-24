'use strict';

angular.module('myApp.view_registration', ['ngRoute'])
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view_registration', {
                    templateUrl: 'app/view_registration/view_registration.html',
                    controller: 'AppRegistrationController',
                    controllerAs: 'ctrl'
                });
            }])
        .controller('AppRegistrationController', function ($scope, $http, $location) {
            $scope.register = function () {
                $http.put('api/registration', $scope.user)
                        .success(function () {
                            $location.path("#/view1");
                        });
            };
        });