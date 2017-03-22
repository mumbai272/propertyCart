var app=angular.module('propertyApp');
app.factory('projectService', 
  function($http) {   
  var projects=[];    
    var factory={};
        factory.getAllProjects = function(success,error){ 

              $http.get('api/project').then(function(response,status){
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