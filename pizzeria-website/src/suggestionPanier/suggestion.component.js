import _ from 'lodash'

class SuggestionController {

    constructor(PanierService, PizzaService, EntreeService, DessertService) {
        this.PanierService = PanierService;
        this.EntreeService = EntreeService;
        this.DessertService = DessertService;
        this.PizzaService = PizzaService;
        this.pizzaSug = [];
    }

    $onInit() {
        this.PizzaService.getPizzas()
            .then(pizzas => this.pizzas = pizzas);
    }

    $onChanges(changes){
        console.log(changes.produits);
        if(changes.produits.currentValue != undefined){
            this.createSuggestion();
        }
    }

    createSuggestion() {
        this.pizz = this.produits.filter(produit => produit.type === 'pizza');
        this.pizzas = _.sortBy(this.pizzas, ['note']).reverse();
        this.cat = _.uniq(this.pizz.map(piz => piz.categorie));
        if(this.cat.length === 1){
            this.pizzaSug = _.take(this.pizzas.filter(pizza => pizza.categorie === this.cat[0]));
        }else{
            this.cat.forEach(categorie => {
                this.pizza = _.take(this.pizzas.filter(pizza => pizza.categorie === categorie));
                this.pizzaSug.push(this.pizza[0]);
            });
        }
    }

    createSuggestion2() {
        console.log(this.pizzas);
    }

}
export const SuggestionPanier = {
    bindings:{
        produits:'<'
    },
    template: require('./suggestion.html'),
    controller: SuggestionController
}