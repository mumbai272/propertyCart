var app = angular.module('propertyApp',['ngRoute']);
app.config(function($routeProvider, $locationProvider) {
	$locationProvider.html5Mode({ enabled: true });
	$routeProvider.when("/", {   
								controller : "ProjectController",
								templateUrl : "/app/partials/projectList.htm"
							 }
						);
});