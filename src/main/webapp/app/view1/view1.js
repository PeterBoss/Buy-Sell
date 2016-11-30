'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'app/view1/view1.html',
    controller: 'View1Ctrl',
    controllerAs : 'ctrl'
  });
}])

.controller('View1Ctrl', ["InfoFactory","InfoService",function(InfoFactory,InfoService) {
  this.msgFromFactory = InfoFactory.getInfo();
  this.msgFromService = InfoService.getInfo();
}])

 .controller('ebayCtrl', function($scope,  $http){
      $scope.searchbutton = $scope.searchButton; 
      var sog = document.getElementById("SearchField");
      console.log("step 1");
     $http.get('/api/ebaysearch/'+sog)
             .success(function (){
              console.log(sog);
             
                 
             })
             .error(function (){
                 console.log("error");
                 
             });
 });