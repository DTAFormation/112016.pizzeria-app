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

        this.note = ((this.product.note * this.product.nbVotant) + angular.copy($event)) / (this.product.nbVotant + 1);
        this.product.note = this.note;
        this.product.nbVotant = this.product.nbVotant + 1;
        this.PizzaService.setPizzaVote(this.product);

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