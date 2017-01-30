class PizzaController{

    constructor(PizzaService){
        console.log(PizzaService);
        this.PizzaService = PizzaService;
    }

    $onInit(){
        this.PizzaService.getPizzas()
        .then(pizzas =>{
            this.pizzas = pizzas
            console.log(pizzas)
        } );
       
    }

}

 export const Pizza = {
        
        template :  require('./pizza.component.html'),
        controller:PizzaController
    }