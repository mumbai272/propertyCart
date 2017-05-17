var app=angular.module('propertyApp');
app.factory('projectService', 
  function($http) {   
  var projects=[];    
    var factory={};
        factory.getAllProjects = function(success,error){ 

              $http.get('project').then(function(response,status){
                     if(success){
                          success(response.data.object);
                        }
                    },function(response,status){
                      if(error){
                          error(response.data.message);
                        }     
                      }
                  );
          }
        factory.addProject = function(data,success,error){ 

            $http.post('project/add',data).then(function(response,status){
                   if(success){
                        success(response.data.object);
                      }
                  },function(response,status){
                    if(error){
                        error(response.data.message);
                      }     
                    }
                );
        }
        factory.getProjectById = function(projectId,success,error){ 

            $http.get('project/get/'+projectId).then(function(response,status){
                   if(success){
                        success(response.data.object);
                      }
                  },function(response,status){
                    if(error){
                        error(response.data.message);
                      }     
                    }
                );
        }
        factory.getPropertiesByProjectId=function(projectId,success,error){ 

            $http.get('property/'+projectId).then(function(response,status){
                   if(success){
                        success(response.data.object);
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