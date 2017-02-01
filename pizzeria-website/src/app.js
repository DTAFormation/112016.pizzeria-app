import angular from 'angular';
import ngRoute from 'angular-route';
import ngStorage from 'ngstorage';

import { Home } from './home/home.component';
import { Product } from './product/product.component';
import { MonCompte } from './moncompte/moncompte.component';
import { ModalPizza } from './modal/modal.component';
import { Inscription } from './inscription/inscription.component';
import { Login } from './login/login.component';
import { Panier } from './panier/panier.component';
import { Pizza } from './pizza/pizza.component';

import { PizzaService } from './shared/service/pizza.service';
import { PanierService } from './shared/service/panier.service';
import { UserService } from './shared/service/user.service';
import { CommandeService } from './shared/service/commande.service';

angular.module('pizzeria', [
        ngRoute,
        'ngStorage'
    ])
    .component('home', Home)
    .component('product', Product)
    .component('modalPizza', ModalPizza)
    .component('panier', Panier)
    .component('moncompte', MonCompte)
    .component('login', Login)
    .component('pizza', Pizza)
    .component('inscription',Inscription)


    .service('PizzaService', PizzaService)
    .service('UserService', UserService)
    .service('PanierService', PanierService)
    .service('CommandeService', CommandeService)
    
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