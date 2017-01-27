class ProductController {

    constructor() {}

    $onInit() {
        console.log('produit', this.product);
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