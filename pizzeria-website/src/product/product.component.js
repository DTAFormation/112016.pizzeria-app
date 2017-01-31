class ProductController {

    constructor(PanierService) {

        this.PanierService = PanierService;
    }

    ajouterPanier(product) {

        this.PanierService.addProduct(product);

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