'use strict';

angular.module('serviceRegistryGuiApp')
  .controller('MainCtrl', function ($scope) {
    $scope.services = [
      'Service 1',
      'Service 2',
      'Service 3'
    ];
  });
