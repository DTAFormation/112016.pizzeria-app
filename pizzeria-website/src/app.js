import angular from 'angular'
import ngRoute from 'angular-route'
import ngStorage from 'ngstorage';

import { Home } from './home/home.component'
import { Product } from './product/product.component'
import { ModalPizza } from './modal/modal.component'

import { Inscription } from './inscription/inscription.component'
import { UserService } from './shared/service/user.service'
import { Login } from './login/login.component'
import { PizzaService } from './shared/service/pizza.service'
import { PanierService } from './shared/service/panier.service'
import { Panier } from './panier/panier.component';
import { Pizza } from './pizza/pizza.component';





angular.module('pizzeria', [
        ngRoute,
        'ngStorage'
    ])
    .component('home', Home)
    .component('product', Product)
    .component('modalPizza', ModalPizza)
    .component('panier', Panier)
    .component('login', Login)
    .component('pizza', Pizza)
    .service('PizzaService', PizzaService)
    .service('UserService', UserService)
    .component('inscription',Inscription)
    .service('PanierService', PanierService)
    .config(function ($routeProvider, $locationProvider) {

        $locationProvider.html5Mode(true);

        $routeProvider
            .when('/', {
                template: `<home></home>`
            })
            .when('/panier', {
                template: `<panier></panier>`
            })

            .when('/login', {
                template: `<login></login>`
            })

            .when('/inscription', {
            template: `<inscription></inscription>`
            })

             .when('/pizzas', {
                template: `<pizza></pizza>`
            })

            .otherwise('/')
    });