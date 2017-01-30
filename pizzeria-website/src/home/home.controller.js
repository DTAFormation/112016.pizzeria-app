export default class HomeController {
    constructor(PanierService, PizzaService) {

        this.PanierService = PanierService;
        this.PizzaService = PizzaService;

    }

    $onInit() {

        this.PizzaService.findAll().then(pizzas => this.pizzas = pizzas);

    }

    ajouterPizzaPanier(pizza) {

        this.PanierService.ajouterPizza(pizza);

    }

    afficherModale(pizza) {

        this.currentPizza = pizza;

    }
}