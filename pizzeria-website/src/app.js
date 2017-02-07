import angular from 'angular'
import ngRoute from 'angular-route'
import ngStorage from 'ngstorage'
import rating from 'angular-ui-bootstrap/src/rating';

import { Home } from './home/home.component';
import { Product } from './product/product.component';
import { ProductMenu } from './product/menu/product-menu.component';
import { ModalPizza } from './modal/modal.component';
import { ModalMenu } from './modal/menu/modal-menu.component';
import { ModalMenuChoix } from './modal/menu/modal-menu-choix.component';
import { Inscription } from './inscription/inscription.component';
import { Login } from './login/login.component';
import { BoissonService } from './shared/service/boisson.service';
import { Panier } from './panier/panier.component';
import { Pizza } from './pizza/pizza.component';
import { Boisson } from './boisson/boisson.component';
import { Rating } from './rating/rating.component';
import { PageBox } from './pageBox/page-box.component';

import { CommandeEnvoye } from './commandeEnvoye/commande-envoye.component';
import { MonCompte } from './moncompte/moncompte.component';
import { Commande } from './commande/commande.component';
import { Dessert } from './dessert/dessert.component';
import { Entree } from './entree/entree.component';
import { Menu } from './menu/menu.component';
import { Navbar } from './navbar/navbar.component';
import { SuggestionPanier } from './suggestionPanier/suggestion.component';


import { UserService } from './shared/service/user.service';
import { PizzaService } from './shared/service/pizza.service';
import { PanierService } from './shared/service/panier.service';
import { CommandeService } from './shared/service/commande.service';
import { DessertService } from './shared/service/dessert.service';
import { EntreeService } from './shared/service/entree.service';
import { MenuService } from './shared/service/menu.service';
import { UtilService } from './shared/service/util.service';

angular.module('pizzeria', [
        ngRoute,
        'ngStorage',
        rating
    ])
    .component('home', Home)
    .component('product', Product)
    .component('productMenu', ProductMenu)
    .component('modalPizza', ModalPizza)
    .component('modalMenu', ModalMenu)
    .component('modalMenuChoix', ModalMenuChoix)
    .component('panier', Panier)
    .component('moncompte', MonCompte)
    .component('login', Login)
    .component('pizza', Pizza)
    .component('commande', Commande)
    .component('commandeEnvoye', CommandeEnvoye)
    .component('dessert', Dessert)
    .component('boisson', Boisson)
    .component('entree', Entree)
    .component('menu', Menu)
    .component('inscription', Inscription)
    .component('navbar', Navbar)
    .component('inscription', Inscription)
    .component('suggestionPanier', SuggestionPanier)
    .component('rating', Rating)
    .component('pageBox', PageBox)

.service('PizzaService', PizzaService)
    .service('BoissonService', BoissonService)
    .service('UserService', UserService)
    .service('PanierService', PanierService)
    .service('CommandeService', CommandeService)
    .service('DessertService', DessertService)
    .service('EntreeService', EntreeService)
    .service('MenuService', MenuService)
    .service('UtilService', UtilService)



.config(function($routeProvider, $locationProvider) {

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
        .when('/desserts', {
            template: `<dessert></dessert>`
        })
        .when('/moncompte/:id?', {
            template: `<moncompte></moncompte>`
        })
        .when('/commande', {
            template: `<commande></commande>`
        })
        .when('/boissons', {
            template: `<boisson></boisson>`
        })
        .when('/entrees', {
            template: `<entree></entree>`
        })
        .when('/menus', {
            template: `<menu></menu>`
        })
        .when('/commandeenvoyee/:id?', {
            template: `<commande-envoye></commande-envoye>`
        })
        .otherwise('/')

});