import _ from 'lodash'

class SuggestionController {

    constructor(PanierService, PizzaService, EntreeService, DessertService) {
        this.PanierService = PanierService;
        this.EntreeService = EntreeService;
        this.DessertService = DessertService;
        this.PizzaService = PizzaService;
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
        this.cat = this.pizz.map(piz => piz.categorie);
        console.log(this.cat);
        this.pizzas = this.pizzas.filter(pizza => pizza.categorie === this.cat[0]);
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