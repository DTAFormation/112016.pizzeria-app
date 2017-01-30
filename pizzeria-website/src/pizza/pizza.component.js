class PizzaController{

    constructor(PizzaService){
        console.log(PizzaService);
        this.PizzaService = PizzaService;
        this.PizzaService.getPizzas()
        .then(pizzas => this.pizzas = pizzas);
    }

}

 export const Pizza = {
        
        template :  require('./pizza.component.html'),
        controller:PizzaController
    }