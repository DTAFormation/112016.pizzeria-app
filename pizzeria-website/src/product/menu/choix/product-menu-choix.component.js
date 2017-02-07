import css from '../../product.component.css';

class ProductMenuChoixController {

    constructor(PanierService, UtilService) {

        this.PanierService = PanierService;
        this.UtilService = UtilService;

    }

    ajouterMenu() {
        this.onAjouterMenu();
    }

    afficherModale() {

        this.onAfficherModale();

    }
}

export const ProductMenuChoix = {
    bindings: {
        selectable: '<',
        product: '<',
        onAfficherModale: '&',
        onAjouterMenu: '&'
    },

    template: require('./product-menu-choix.component.html'),
    controller: ProductMenuChoixController

};