'use strict';

angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'app/view1/view1.html',
                    controller: 'View1Ctrl',
                    controllerAs: 'ctrl'
                });
            }])

        .controller('View1Ctrl', ["InfoFactory", "InfoService", function (InfoFactory, InfoService) {
                this.msgFromFactory = InfoFactory.getInfo();
                this.msgFromService = InfoService.getInfo();
            }])


        .controller('ebayCtrl', function ($scope, $http) {
            $scope.myFunc = function () {
                $http.get('api/ebaysearch/' + $scope.keyword)
                        .then(function (response) {
                            var t = JSON.parse(response.data);
                            $scope.ebayItems = t.findItemsByKeywordsResponse[0].searchResult[0].item;
                        });
            };
        });
        