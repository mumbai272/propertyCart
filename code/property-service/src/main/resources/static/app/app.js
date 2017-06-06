var app = angular.module('propertyApp', [ 'ngRoute', 'ngResource' ]);
app.config(function($routeProvider) {

	$routeProvider.when("/", {
		controller : "ProjectController",
		templateUrl : "app/partials/projectList.htm"
	}).when('/details', {
		templateUrl : 'app/partials/projectDetail.htm',
		controller : 'ProjectController'
	}).when('/admin/add', {
		templateUrl : 'app/partials/projectManage.htm',
		controller : 'ProjectController'
	});
});
app.directive('fileInput', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, elm, attrs) {
			elm.bind('change', function() {
				$parse(attrs.fileInput).assign(scope, elm[0].files);
				scope.$apply();
			});
		}
	}
} ]);
