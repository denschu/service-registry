'use strict';

angular.module('service-registry')
  .controller('MainCtrl', function ($scope, Service) {
	  
	//Gets the service from /api/services
	$scope.services = function () {
		Service.query();
    } 
	
	$scope.saveService = function () {		
        window.location = "/#add-service";
    };
    
  })
  .controller('ServiceCreationCtrl', function ($scope, Service, $location) {
      // callback for ng-click 'saveService':
      $scope.saveService = function () {
          Service.create($scope.service);
          $location.path('/services');
      }
  });