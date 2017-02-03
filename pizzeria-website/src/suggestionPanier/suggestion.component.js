class SuggestionController {

    constructor(PanierService, PizzaService, EntreeService, DessertService) {
        this.PanierService = PanierService;
        this.EntreeService = EntreeService;
        this.DessertService = DessertService;
        this.PizzaService = PizzaService;
    }

    $onInit() {
        //this.panier = this.PanierService.getPanier();
        // this.promProduits = this.PanierService.getProduits();
        this.pizzas = [{}]
        this.PizzaService.getPizzas()
            .then(pizzas => this.pizzas = pizzas);
        this.promProduits = this.PanierService.getProduits();
    }

    createSuggestion() {
        console.log(this.promProduits);
    }

    createSuggestion2() {
        console.log(this.pizzas);
    }

}
export const SuggestionPanier = {

    template: require('./suggestion.html'),
    controller: SuggestionController

}