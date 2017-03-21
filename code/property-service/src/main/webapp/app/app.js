var app = angular.module('propertyApp',['ngRoute']);
app.config(function($routeProvider) {
	$routeProvider
	.when("/", {
		controller : "ProjectController",
		templateUrl : "app/partials/projectList.htm"
		
	}).when("/project/:projectId",{
		controller : "ProjectController",
		templateUrl : "app/partials/projectDetail.htm"
	}).otherwise({
		redirectTo : "/"
	});
});