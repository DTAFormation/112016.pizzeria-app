class PizzaController{

    constructor(PizzaService){
        this.PizzaService = PizzaService;
    }

    $onInit(){
        this.PizzaService.getPizzas()

        .then(pizzas => this.pizzas = pizzas);  
    }


}

 export const Pizza = {
        
        template :  require('./pizza.component.html'),
        controller:PizzaController
    }