'use strict';

angular.module('service-registry.services', ['ngResource'])
.factory('Service', ['$resource',
  function($resource){
    return $resource(
    		'/api/services/:id', 
    		{id:'@id'}, {
    			query: {method:'GET', isArray:true}
    		});
  }]);