var app = angular.module('propertyApp');
app.controller('ProjectController', function($scope, $rootScope, $http,
		projectService, propertyService) {
	$rootScope.statusList = [ "Prelaunching", "Under Construction",
			"Ready Possession" ];
	$rootScope.bedroomList = [ 1, 2, 3 ];
	$rootScope.imageType = [ "Image", "Thumbnail" ];
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
		projectService.getPropertiesByProjectId(projectId, function(data) {
			$scope.properties = data;
		}, function(msg) {
			$scope.msg = msg;
		});
	}
	$scope.addProject = function(newProject) {
		console.log(angular.toJson(newProject));
		projectService.addProject(angular.toJson(newProject), function(data) {
			getAllProjects();
			$scope.msg = "project added successfully";
		}, function(msg) {
			$scope.msg = msg;
		});
	}
	$scope.editProject = function(project) {
		$('#addProject').modal('show');
		$scope.newProject = project;
	}
	$scope.updateProject = function(project) {

		projectService.updateProject(angular.toJson(project), function(data) {
			getAllProjects();
			$scope.msg = "project updated successfully";
		}, function(msg) {
			$scope.msg = msg;
		});
	}
	$scope.setProject = function(project, type) {
		$scope.currentProject = project;
		if (type && type === 'property') {
			getAllProperties($scope.currentProject.id);
		}
		if (type && type === 'image') {
			getAllImages($scope.currentProject.id);
		}
	}
	$scope.editPropety = function(property) {
		$scope.newProperty = property;
	}
	function getAllProperties(projectId) {
		propertyService.getAllProperties(projectId, function(data) {
			$scope.currentProject.properties = data;
		}, function(msg) {
			$scope.msg = msg;
		});
	}
	$scope.addProperty = function(newProperty) {
		newProperty.projectId = $scope.currentProject.id;
		newProperty.addressId = $scope.currentProject.addressId;
		newProperty.isNew = true;
		propertyService.addProperty(angular.toJson(newProperty),
				function(data) {
					getAllProperties($scope.currentProject.id);
					$scope.newProperty = {};
					$scope.msg = "property added successfully";
				}, function(msg) {
					$scope.msg = msg;
				});
	}
	function getAllImages(projectId) {
		projectService.getAllImages(projectId, function(data) {
			$scope.currentProject.images = data;
			$scope.newImage = {};
		}, function(msg) {
			$scope.msg = msg;
		});
	}

	$scope.addImage = function(newImage) {

		var type = newImage.type;
		var fd = new FormData();
		var uploadUrl = 'project/' + $scope.currentProject.id + '/uploadFile';
		angular.forEach($scope.files, function(file) {
			fd.append('file', file);
		});
		fd.append('type', type);
		$http.post(uploadUrl, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).then(function(response, status) {
			if (success) {
				getAllImages($scope.currentProject.id)
				$scope.newImage = {};
			}
		}, function(response, status) {
			if (error) {
				$scope.msg = response.data.message;
			}
		});
	}
	$scope.deleteImage = function(id) {
		$http({
			method : "DELETE",
			url : 'project/image/' + id
		}).then(function(response, status) {
			if (success) {
				getAllImages($scope.currentProject.id)
				$scope.newImage = {};
			}
		}, function(response, status) {
			if (error) {
				$scope.msg = response.data.message;
			}
		});
	}
	$scope.plotOnMap = function(lat, long) {

		var myOptions = {
			center : new google.maps.LatLng(lat, long),
			zoom : 12,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		$scope.map = new google.maps.Map(document.getElementById("map_canvas"),
				myOptions);

		marker = new google.maps.Marker({
			position : new google.maps.LatLng(lat, long),
			map : map
		});

	}
});
