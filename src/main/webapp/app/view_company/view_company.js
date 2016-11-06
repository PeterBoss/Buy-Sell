'use strict';

angular.module('myApp.view_company', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view_company', {
                    templateUrl: 'app/view_company/view_company.html',
                    controller: 'CompanyController'
                });
            }])


        .controller("CompanyController", ["$scope", "$http", function ($scope, $http) {
                $scope.submit = function () {
                    if ($scope.cvrInput) {
                        var req = {
                            method: 'GET',
                            skipAuthorization: true,
                            url: 'http://cvrapi.dk/api?vat=' + $scope.cvrInput + '&country=dk',
                            headers: {'User-Agent': 'test'}
                        };
                        $http(req).then(function (response) {
                            $scope.data = response.data;
                            $scope.unitData = response.data.productionunits;
                        });
                    } else {
                        alert("Please enter cvr");
                    }
                };

                $scope.getDetails = function (unit) {
                    $scope.unit = unit;
                };
            }]);