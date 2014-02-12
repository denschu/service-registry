'use strict';

angular.module('serviceRegistryGuiApp')
  .controller('MainCtrl', function ($scope) {

    $scope.services = [{"name":"service1","version":"1","url":"localhost:8082/service1"},
    					{"name":"service1","version":"2","url":"localhost:8082/service1"},
    					{"name":"service2","version":"1","url":"localhost:8082/service2"}];

  });
