import angular from 'angular'
import ngRoute from 'angular-route'
import home from './home'


angular.module('pizzeria', [ngRoute, home])
    .config(function ($routeProvider, $locationProvider) {
        $locationProvider.html5Mode(true);
        $routeProvider.otherwise('/')
    });
