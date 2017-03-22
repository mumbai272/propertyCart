var app = angular.module('propertyApp',['ngRoute']);
app.config(function($routeProvider) {
	$routeProvider
	.when("/", {
		controller : "ProjectController",
		templateUrl : "app/partials/projectList.htm"
	}).otherwise({
		redirectTo : "/"
	});
});