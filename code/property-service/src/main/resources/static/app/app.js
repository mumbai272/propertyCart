var app = angular.module('propertyApp',['ngRoute','ngResource']);
app.config(function($routeProvider) {
	 
	$routeProvider.when("/", {
					controller : "ProjectController",
					templateUrl : "app/partials/projectList.htm"
				}).when('/details', {
				    templateUrl: 'app/partials/projectDetail.htm',
				    controller: 'ProjectController'
				});
});
