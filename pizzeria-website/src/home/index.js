import angular from 'angular';
import HomeController from './home.controller';

export default angular.module('pizzeria.home', [])
    .config(($routeProvider) => {
        $routeProvider.when('/', {
            template: require('./home.html'),
            controller: 'HomeController',
            controllerAs: 'ctrl'
        })
    })
    .controller('HomeController', HomeController)
    .name;
