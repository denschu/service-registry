'use strict';

angular.module('service-registry')
  .controller('MainCtrl', function ($scope, Service) {
	//Gets the service from /api/services
	$scope.services = Service.query();   
  });