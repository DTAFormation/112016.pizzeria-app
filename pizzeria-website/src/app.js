import angular from 'angular'
import ngRoute from 'angular-route'
import ngStorage from 'ngstorage';

import { Home } from './home/home.component'
import { Product } from './product/product.component'
import { ModalPizza } from './modal/modal.component'

angular.module('pizzeria', [
    ngRoute,
    'ngStorage'
])

.component('home', Home)
.component('product', Product)
.component('modalPizza', ModalPizza)

.controller('lsCtrl', function (
    $scope,
    $localStorage,
    $sessionStorage
) {

    $scope.$localStorage = $localStorage;
    $scope.$sessionStorage = $sessionStorage;

    if ($localStorage.jsonPanier === undefined) {
        $localStorage.jsonPanier = {};
        $localStorage.jsonPanier['pizza'] = [];
        $localStorage.jsonPanier['boisson'] = [];
        $localStorage.jsonPanier['dessert'] = [];
        $localStorage.jsonPanier['menus'] = [];
    }

})

.config(function ($routeProvider, $locationProvider) {

    $locationProvider.html5Mode(true);

    $routeProvider

        .when('/', {
            template: `<home><home>`
        })

        .otherwise('/')
});