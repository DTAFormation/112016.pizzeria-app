import css from './pizza.component.css';

class PizzaController{

    constructor(PizzaService){
        this.PizzaService = PizzaService;
    }

    $onInit(){
        this.PizzaService.getPizzas()
            .then(pizzas =>{
                this.pizzas = pizzas
        });
        this.getCateg();
        this.initPizzas();
        this.predicat = "Tous"
    }


    initPizzas(){
        this.PizzaService.getPizzas()
            .then(pizzas => 
                this.pizzas = pizzas 
            );
    }

    sort(predicat){
        this.predicat = predicat
        if(predicat.nom != "Tous") {
            this.pizzas = this.PizzaService.getPizzas()
            .then(pizzas => {
                this.pizzas = pizzas
                .filter((pizza)=> pizza.categorie == predicat.nom);
            })
         } else {
            this.initPizzas();
         }
    }

    isCategSelected(categ) {
        return this.predicat === categ.nom
    }

    getCateg(){
        this.PizzaService.getPizzas()
            .then(pizzas =>{
                let categObj = _.countBy(pizzas, 'categorie');
                let categObjArr = []
                Object.getOwnPropertyNames(categObj).forEach(function(val, idx, array) {
                    categObjArr.push({ 
                        nom : val,
                        nb : categObj[val]
                    })   
                });
                categObjArr.reduce((acc, obj)=>this.nbMax = (acc += obj.nb),0);
                categObjArr.unshift({nom : "Tous", nb : this.nbMax});
                this.categs = categObjArr;
            })
     }

  afficherModale(pizza) {

        this.currentPizza = pizza;

    }

}

 export const Pizza = {
        
        template :  require('./pizza.component.html'),
        controller:PizzaController
    }