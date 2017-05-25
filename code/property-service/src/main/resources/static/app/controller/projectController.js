var app = angular.module('propertyApp');
app.controller('ProjectController',
		function($scope, $rootScope, projectService) {
			$rootScope.statusList = [ "Prelaunching", "Under Construction",
					"Ready Possession" ];
			init();
			function init() {
				getAllProjects();
				console.log("got the :" + $scope.projectList);
			}
			function getAllProjects() {
				projectService.getAllProjects(function(data) {
					$scope.projectList = data;
				}, function(msg) {
					$scope.msg = msg;
				});
			}
			$scope.getProjectDetail = function(projectId) {
				projectService.getProjectById(projectId, function(data) {
					$scope.project = data;
				}, function(msg) {
					$scope.msg = msg;
				});
			}
			$scope.getPropertyDetails = function(projectId) {
				projectService.getPropertiesByProjectId(projectId, function(
						data) {
					$scope.properties = data;
				}, function(msg) {
					$scope.msg = msg;
				});
			}
			$scope.addProject = function(newProject) {
				console.log(angular.toJson(newProject));
				projectService.addProject(angular.toJson(newProject), function(
						data) {
					getAllProjects();
					$scope.msg = "project added successfully";
				}, function(msg) {
					$scope.msg = msg;
				});
			}
			$scope.updateProject = function(project) {
				$('#addProject').modal('show');
				$scope.newProject = project;
			}
			$scope.plotOnMap = function(lat, long) {

				var myOptions = {
					center : new google.maps.LatLng(lat, long),
					zoom : 12,
					mapTypeId : google.maps.MapTypeId.ROADMAP
				};
				$scope.map = new google.maps.Map(document
						.getElementById("map_canvas"), myOptions);

				marker = new google.maps.Marker({
					position : new google.maps.LatLng(lat, long),
					map : map
				});

			}
		});
