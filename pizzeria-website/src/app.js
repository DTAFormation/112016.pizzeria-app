import angular from 'angular';
import ngRoute from 'angular-route';
import ngStorage from 'ngstorage';

import { Home } from './home/home.component';
import { Product } from './product/product.component';
import { ModalPizza } from './modal/modal.component';
import { Panier } from './panier/panier.component';
import { MonCompte } from './moncompte/moncompte.component';

import { PizzaService } from './shared/service/pizza.service';
import { UserService } from './shared/service/users.service';

angular.module('pizzeria', [
        ngRoute,
        'ngStorage'
    ])
    .component('home', Home)
    .component('product', Product)
    .component('modalPizza', ModalPizza)
    .component('panier', Panier)
    .component('moncompte', MonCompte)
    .service('PizzaService', PizzaService)
    .service('UserService', UserService)
    .config(function ($routeProvider, $locationProvider) {

        $locationProvider.html5Mode(true);

        $routeProvider
            .when('/', {
                template: `<home></home>`
            })
            .when('/panier', {
                template: `<panier></panier>`
            })
            .when('/moncompte/:id?',{
                template: `<moncompte></moncompte>`
            })
            .otherwise('/')
    });