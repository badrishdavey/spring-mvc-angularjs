'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', [ 'AngularSpringApp.filters',
		'AngularSpringApp.services', 'AngularSpringApp.directives' ]);

// Declare app level module which depends on filters, and services
App.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/home', {
		templateUrl : 'home/layout',
		controller : HomeController
	});

	$routeProvider.when('/actions', {
		templateUrl : 'actions/layout',
		controller : ActionController
	});

	$routeProvider.otherwise({
		redirectTo : '/home'
	});
} ]);
