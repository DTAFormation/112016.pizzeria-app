class ProductController {

    constructor() {}

    ajouterPanier() {
        this.onSelect();
    }
}

export const Product = {
    bindings: {
        product: '<',
        onSelect: '&'
    },

    template: require('./product.component.html'),

    controller: ProductController

};