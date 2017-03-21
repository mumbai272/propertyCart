var app = angular.module('propertyApp',['ngRoute']);
app.controller('ProjectController',
	function($scope, $rootScope,$routeParams, projectService) {
	console.log($routeParams);
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
