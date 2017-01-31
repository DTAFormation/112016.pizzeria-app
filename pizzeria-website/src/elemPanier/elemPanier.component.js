class ElemPanierController {

    constructor(PanierService, PizzaService) {

        this.PanierService = PanierService;
        this.PizzaService = PizzaService;

    }

    $onInit() {

    }

    ajouterQuantite(element) { // Todo

    }

}

export const ElemPanier = {
    bindings: {
        produit: '<',
    },

    template: require('./elemPanier.component.html'),

    controller: ElemPanierController

};