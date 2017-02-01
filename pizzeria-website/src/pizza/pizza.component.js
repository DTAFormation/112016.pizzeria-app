class PizzaController{

    constructor(PizzaService){
        this.PizzaService = PizzaService;
    }

    $onInit(){
        this.PizzaService.getPizzas()
        .then(pizzas =>{
            this.pizzas = pizzas
        } );

       this.getCateg();
       this.initPizzas();

    }


    initPizzas(){
             this.PizzaService.getPizzas()
        .then(pizzas => this.pizzas = pizzas );
           
       }

       sort(predicat){
        if(predicat !="Tous"){
        this.pizzas =   this.Pizzaservice.getPizzas()
           .then(pizzas => {
               this.pizzas = pizzas
             .filter((pizza)=> pizza.categorie == predicat);
           })
         }else{
         this.initPizzas();
         }
       }

    getCateg(){
          this.PizzaService.getPizzas()
           .then(pizzas =>{
             let categObj = _.countBy(pizzas, 'categorie');
             let categObjArr = []
             Object.getOwnPropertyNames(categObj).forEach(function(val, idx, array) {
             categObjArr.push({ nom :val,
             nb : categObj[val]})   
             });
             categObjArr.reduce((acc, obj)=>this.nbMax = (acc += obj.nb),0);
             categObjArr.push({nom : "Tous", nb : this.nbMax});
             this.categs = categObjArr;
           } )
     }

}

 export const Pizza = {
        
        template :  require('./pizza.component.html'),
        controller:PizzaController
    }