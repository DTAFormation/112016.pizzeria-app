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
import { Panier } from './panier/panier.component';



angular.module('pizzeria', [
        ngRoute,
        'ngStorage'
    ])
    .component('home', Home)
    .component('product', Product)
    .component('modalPizza', ModalPizza)
    .component('panier', Panier)
    .component('login', Login)
    .service('PizzaService', PizzaService)
    .service('UserService', UserService)
    .component('inscription',Inscription)
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
            .when('/nouveaucompte', {
            template: `<inscription></inscription>`
            })
            .otherwise('/')
    });