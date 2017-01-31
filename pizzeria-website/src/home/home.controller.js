import lodash from 'lodash';

export default class HomeController {
    constructor(PanierService, PizzaService) {

        this.PanierService = PanierService;
        this.PizzaService = PizzaService;

    }

    $onInit() {
        this.pizza = []

        this.PizzaService.getPizzas()
            .then(pizzas =>{
               this.pizza = lodash
                    .sortBy(pizzas, pizza => 
                        pizza.date
                   )
                
                this.pizzas = lodash
                    .take(this.pizza, 3)
            }
        );

    }

    ajouterPizzaPanier(pizza) {

        this.PanierService.addProduct(pizza);

    }

    afficherModale(pizza) {

        this.currentPizza = pizza;

    }
}