var app=angular.module('propertyApp');
app.factory('projectService', function($http) {   
  var projects=[];    
    var factory={};
        factory.getAllProjects = function(success,error){ 

              $http.get('project').then(function(response,status){
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
        factory.getAllActiveProjects = function(success,error){ 

            $http.get('project?active=true').then(function(response,status){
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
        factory.addProject = function(data,success,error){ 

            $http.post('project',data).then(function(response,status){
                   if(success){
                        success(response.data.data);
                        $('#addProject').modal('hide');
                      }
                  },function(response,status){
                    if(error){
                        error(response.data.message);
                      }     
                    }
                );
        }
        factory.updateProject = function(data,success,error){ 

            $http.put('project',data).then(function(response,status){
                   if(success){
                        success(response.data.data);
                        $('#addProject').modal('hide');
                      }
                  },function(response,status){
                    if(error){
                        error(response.data.message);
                      }     
                    }
                );
        }
        factory.getProjectById = function(projectId,success,error){ 

            $http.get('project/'+projectId).then(function(response,status){
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
        factory.getPropertiesByProjectId=function(projectId,success,error){ 

            $http.get('project/'+projectId+'/property').then(function(response,status){
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
        factory.getAllImages = function(projectId,success,error){ 

            $http.get('project/image/list/'+projectId).then(function(response,status){
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
        factory.uploadImage=function(image){
        	$http.post('project',data).then(function(response,status){
                if(success){
                     success(response.data.data);
                     $('#addProject').modal('hide');
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