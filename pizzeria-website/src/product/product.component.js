class ProductController {

    constructor() {}

    ajouterPanier() {
        this.onSelect();
    }

    afficherModale() {
        this.onAfficherModale();
    }

}

export const Product = {
    bindings: {
        product: '<',
        onSelect: '&',
        onAfficherModale: '&'
    },

    template: require('./product.component.html'),

    controller: ProductController

};