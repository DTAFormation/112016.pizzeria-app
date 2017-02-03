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

}

export const Product = {
    bindings: {
        product: '<',
        onAfficherModale: '&'
    },

    template: require('./product.component.html'),

    controller: ProductController

};