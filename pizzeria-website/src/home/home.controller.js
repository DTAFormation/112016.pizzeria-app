export default class HomeController {
    constructor(PanierService, PizzaService) {

        this.PanierService = PanierService;
        this.PizzaService = PizzaService;
        console.log('test');
    }

    $onInit() {

        this.PizzaService.findAll()
            .then(pizzas =>
                this.pizzas = pizzas
            );

    }

    ajouterPizzaPanier(pizza) {

        this.PanierService.addProduct(pizza);

    }

    afficherModale(pizza) {

        this.currentPizza = pizza;

    }
}