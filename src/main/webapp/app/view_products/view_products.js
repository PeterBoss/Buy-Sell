'use strict';

angular.module('myApp.view_products', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view_products', {
                    templateUrl: 'app/view_products/view_products.html',
                    controller: 'ProductsController'
                });
            }])


        .controller("ProductsController", ["$scope", "$http", function ($scope, $http) {
                $scope.submit = function () {
                    if ($scope.cvrInput) {
                        var req = {
                            method: 'GET',
                            skipAuthorization: true,
                            url: 'https://extraction.import.io/query/extractor/afc7488b-b965-4eba-95b9-45e98e7da5fa?_apikey=8ddfcce443064047889c62b5b157923ab8eefb6e49b29d2c7339f4cc69ef4d1729e752ac716db8bcc78fb055715ddd0192e0f4d9bf68f07a3f64d2100897587c930c4bac40fc26c9666e2aae9b02b40c&url=http%3A%2F%2Fwww.dba.dk%2Fmobil-og-telefoni%2Fmobiltelefoner-og-tilbehoer%2Fiphone%2F' + $scope.cvrInput,
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