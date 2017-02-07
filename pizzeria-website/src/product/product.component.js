import css from './product.component.css';

class ProductController {

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

    modifierNote($event){

        this.product.nbVotant++;
        this.product.sommeEtoile += angular.copy($event);
        this.product.note = Math.round(this.product.sommeEtoile  / this.product.nbVotant);
        this.updateProduct({
            $event: this.product
        })

    }
}

export const Product = {
    bindings: {
        product: '<',
        onAfficherModale: '&',
        updateProduct: '&'
    },

    template: require('./product.component.html'),
    controller: ProductController

};