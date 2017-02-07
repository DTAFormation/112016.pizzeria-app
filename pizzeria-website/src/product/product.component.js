import css from './product.component.css';

class ProductController {

    constructor(PanierService, UtilService, PizzaService) {

        this.PanierService = PanierService;
        this.UtilService = UtilService;
        this.PizzaService = PizzaService;

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
        this.PizzaService.setPizzaVote(angular.copy(this.product));

    }
}

export const Product = {
    bindings: {
        product: '<',
        onAfficherModale: '&'
    },

    template: require('./product.component.html'),
    controller: ProductController

};