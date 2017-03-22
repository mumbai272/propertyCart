var app = angular.module('propertyApp');
app.controller('ProjectController',
	function($scope, $rootScope, projectService) {
		init();
		function init(){
			projectService.getAllProjects(function(data){
				$scope.projectList=data;
			},function(msg){
				$scope.msg=msg;
			});
			console.log("got the :"+ $scope.projectList);	
		}
	}
);
