class ElemPanierController {

    constructor(PanierService) {

        this.PanierService = PanierService;
    }

    ajouterQuantite(element) { // Todo

    }

}

export const ElemPanier = {
    bindings: {
        element: '<',
    },

    template: require('./elemPanier.component.html'),

    controller: ElemPanierController

};