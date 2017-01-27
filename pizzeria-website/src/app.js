import angular from 'angular'
import ngRoute from 'angular-route'

import HomeModule from './home'

angular.module('pizzeria', [
    ngRoute,
    HomeModule
])
.config(function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true); 
    $routeProvider
        .when('/', {
            template: '<home></home>'
        })
        .otherwise('/')
});
