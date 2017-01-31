import _ from 'lodash';

export class PanierService {
    constructor($localStorage) {

        this.$localStorage = $localStorage;

    }

    initPanier() {

        this.$localStorage.jsonPanier = this.$localStorage.jsonPanier || {};
        this.$localStorage.jsonPanier.pizza = this.$localStorage.jsonPanier.pizza || [];
        this.$localStorage.jsonPanier.boisson = this.$localStorage.jsonPanier.boisson || [];
        this.$localStorage.jsonPanier.dessert = this.$localStorage.jsonPanier.dessert || [];
        this.$localStorage.jsonPanier.menu = this.$localStorage.jsonPanier.menu || [];

    }

    ajouterPizza(pizza) {

        if (this.$localStorage.jsonPanier === undefined)
            this.initPanier();

        let pizzas = this.$localStorage.jsonPanier['pizza'];
        let exist = _.find(pizzas, p => p.id === pizza.id);

        if (exist !== undefined) {
            exist.quantite += 1;
        } else {
            pizza.quantite = 1;
            pizzas.push(pizza);
        }

    }

    resetPizzas() {

        delete this.$localStorage.jsonPanier.pizza;

    }

    addProduct(product) {

        if (product.type === 'pizza')
            this.ajouterPizza(product);

    }
}