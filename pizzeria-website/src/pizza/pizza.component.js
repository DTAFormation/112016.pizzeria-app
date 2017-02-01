class PizzaController{

    constructor(PizzaService){
        this.PizzaService = PizzaService;
    }

    $onInit(){
        this.PizzaService.getPizzas()
        .then(pizzas =>{
            this.pizzas = pizzas
        } );
       
    }

  afficherModale(pizza) {

        this.currentPizza = pizza;

    }
}

 export const Pizza = {
        
        template :  require('./pizza.component.html'),
        controller:PizzaController
    }