import css from '../product.component.css';

class ProductMenuController {

    constructor(PanierService, UtilService) {

        this.PanierService = PanierService;
        this.UtilService = UtilService;
    }

    ajouterPanier(product) {

        this.PanierService.ajouterElement(product);

    }

    afficherModale() {

        this.onAfficherModale();


    }

    afficherMenu() {

        this.onAfficherMenu();


    }

}

export const ProductMenu = {
    bindings: {
        menu: '<',
        onAfficherModale: '&',
        onAfficherMenu: '&'
    },

    template: require('./product-menu.component.html'),
    controller: ProductMenuController

};