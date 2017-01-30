import angular from 'angular';
import ngRoute from 'angular-route';
import ngStorage from 'ngstorage';

import { Home } from './home/home.component';
import { Product } from './product/product.component';
import { ModalPizza } from './modal/modal.component';
import { MonCompte } from './moncompte/moncompte.component';
import { Panier } from './panier/panier.component';
import { Pizza } from './pizza/pizza.component';
import { Login } from './login/login.component';
import { Inscription } from './inscription/inscription.component';

import { UserService } from './shared/service/user.service';
import { PizzaService } from './shared/service/pizza.service';
import { PanierService } from './shared/service/panier.service';



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
    .component('inscription',Inscription)
    .component('moncompte', MonCompte)

    .service('PanierService', PanierService)
    .service('PizzaService', PizzaService)
    .service('UserService', UserService)
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
            .when('/login', {
                template: `<login></login>`
            })
            .when('/inscription', {
            template: `<inscription></inscription>`
            })
             .when('/pizzas', {
                template: `<pizza></pizza>`
            })
            .when('/moncompte/:id?',{
                template: `<moncompte></moncompte>`
            })
            .otherwise('/')
    });