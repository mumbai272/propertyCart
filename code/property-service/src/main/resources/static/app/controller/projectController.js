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
		$scope.getProjectDetail=function(projectId){
			projectService.getProjectById(projectId,function(data){
				$scope.project=data;
			},function(msg){
				$scope.msg=msg;
			});
		}
		$scope.getPropertyDetails=function(projectId){
			projectService.getPropertiesByProjectId(projectId,function(data){
				$scope.properties=data;
			},function(msg){
				$scope.msg=msg;
			});
		}
		$scope.plotOnMap=function(lat,long) 
		{
		 
		var myOptions = {center: new google.maps.LatLng(lat, long),
		 zoom: 12,
		 mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		$scope.map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);
		 
		
		 marker = new google.maps.Marker({
		position: new google.maps.LatLng(lat, long),
		map: map
		});
		 
		}	
	}
);
