const api = 'API_URL'; // Fill the api URL here and use it everywhere

export class PizzaService {
    constructor($localStorage) {

        this.$localStorage = $localStorage;

        if ($localStorage.jsonPanier === undefined) {
            $localStorage.jsonPanier = {};
        }
        if ($localStorage.jsonPanier.pizza === undefined) {
            $localStorage.jsonPanier['pizza'] = [];
        }

    }

    ajouterPanier(pizza) {

        let pizzas = this.$localStorage.jsonPanier['pizza'];
        let exist = pizzas.find(p => p.id === pizza.id);

        if (exist !== undefined) {
            exist.quantité += 1;
        } else {
            pizza.quantité = 1;
            pizzas.push(pizza);
        }
    }

    resetPizzaPanier() {

        delete this.$localStorage.jsonPanier.pizza;
        
    }
}