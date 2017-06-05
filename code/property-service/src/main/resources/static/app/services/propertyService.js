var app=angular.module('propertyApp');
app.factory('propertyService', function($http) {   
    var factory={};
        factory.getAllProperties = function(projectId,success,error){ 
        	var api='project/'+projectId+'/property';
              $http.get(api).then(function(response,status){
                     if(success){
                          success(response.data.data);
                        }
                    },function(response,status){
                      if(error){
                          error(response.data.message);
                        }     
                      }
                  );
          }
        factory.addProperty = function(data,success,error){ 

            $http.post('property',data).then(function(response,status){
                   if(success){
                        success(response.data.data);                       
                      }
                  },function(response,status){
                    if(error){
                        error(response.data.message);
                      }     
                    }
                );
        }
        factory.updateProperty = function(data,success,error){ 

            $http.put('property',data).then(function(response,status){
                   if(success){
                        success(response.data.data);
//                        $('#addProject').modal('hide');
                      }
                  },function(response,status){
                    if(error){
                        error(response.data.message);
                      }     
                    }
                );
        }
        factory.getPropertyById = function(projectId,success,error){ 

            $http.get('property/'+projectId).then(function(response,status){
                   if(success){
                        success(response.data.data);
                      }
                  },function(response,status){
                    if(error){
                        error(response.data.message);
                      }     
                    }
                );
        }
       
    return factory;   
  }
);