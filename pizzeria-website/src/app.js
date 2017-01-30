import angular from 'angular'
import ngRoute from 'angular-route'
import ngStorage from 'ngstorage';

import { Home } from './home/home.component'
import { Product } from './product/product.component'
import { ModalPizza } from './modal/modal.component'

import { PizzaService } from './shared/service/pizza.service'
import { Panier } from './panier/panier.component';

angular.module('pizzeria', [
        ngRoute,
        'ngStorage'
    ])
    .component('home', Home)
    .component('product', Product)
    .component('modalPizza', ModalPizza)
    .component('panier', Panier)
    .service('PizzaService', PizzaService)
    .config(function ($routeProvider, $locationProvider) {

        $locationProvider.html5Mode(true);

        $routeProvider
            .when('/', {
                template: `<home></home>`
            })
            .when('/panier', {
                template: `<panier></panier>`
            })
            .otherwise('/')
    });