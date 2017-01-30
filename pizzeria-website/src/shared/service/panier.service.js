export class PanierService {
    constructor($localStorage) {

        this.$localStorage = $localStorage;

        $localStorage.jsonPanier = $localStorage.jsonPanier || {};
        $localStorage.jsonPanier.pizza = $localStorage.jsonPanier.pizza || [];
    }

    ajouterPizza(pizza) {

        let pizzas = this.$localStorage.jsonPanier['pizza'];
        let exist = pizzas.find(p => p.id === pizza.id);

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