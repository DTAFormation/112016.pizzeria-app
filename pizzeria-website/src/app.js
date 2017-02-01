import angular from 'angular'
import ngRoute from 'angular-route'
import ngStorage from 'ngstorage'

import { Home } from './home/home.component'
import { Product } from './product/product.component'
import { ModalPizza } from './modal/modal.component'
import { Inscription } from './inscription/inscription.component'
import { UserService } from './shared/service/user.service'
import { Login } from './login/login.component'
import { PizzaService } from './shared/service/pizza.service'
import { PanierService } from './shared/service/panier.service'
import { BoissonService } from './shared/service/boisson.service'
import { Panier } from './panier/panier.component'
import { Pizza } from './pizza/pizza.component'
import { Boisson } from './boisson/boisson.component'
import { CommandeEnvoye } from './commandeEnvoye/commande-envoye.component';
import { MonCompte } from './moncompte/moncompte.component';
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
    .component('boisson', Boisson)
   .component('inscription',Inscription)
    .component('commandeEnvoye', CommandeEnvoye)
    .component('inscription',Inscription)
    .service('PizzaService', PizzaService)
    .service('BoissonService', BoissonService)
    .service('UserService', UserService)
    .service('PanierService', PanierService)
    .service('CommandeService', CommandeService)
    .config(function($routeProvider, $locationProvider) {

    $locationProvider.html5Mode(true);

    $routeProvider
        .when('/', {
            template: `<home></home>`
        })
        .when('/panier', {
            template: `<panier></panier>`
        })
        .when('/moncompte/:id?', {
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
         .when('/boissons', {
                template: `<boisson></boisson>`
            })
        .when('/commandeenvoyee/:id?', {
            template: `<commande-envoye></commande-envoye>`
        })
        .otherwise('/')

});
