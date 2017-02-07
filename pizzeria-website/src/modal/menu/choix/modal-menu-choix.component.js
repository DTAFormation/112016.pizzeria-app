class ModalMenuChoixController {

    constructor(EntreeService, PizzaService, DessertService, BoissonService) {
        this.EntreeService = EntreeService;
        this.PizzaService = PizzaService;
        this.DessertService = DessertService
        this.BoissonService = BoissonService;
        this.entreesChoix = [];
        this.pizzasChoix = [];
        this.dessertsChoix = [];
        this.boissonsChoix = [];
        this.affichageEntrees= [];
        this.affichagePizzas = [];
        this.affichageDesserts = [];
        this.affichageBoissons = [];
        this.entryIndex = 0;
        this.pizzaIndex = 0;
        this.dessertIndex = 0;
        this.boissonIndex = 0;
    }

    $onInit() {
        this.EntreeService.getEntrees()
            .then(entrees => {
                this.entrees = entrees;
                this.initList(this.entrees, "entree");
            })
        this.PizzaService.getPizzas()
            .then(pizzas =>{
                this.pizzas = pizzas;
                this.initList(this.pizzas, "pizza");
            });
        this.DessertService.getDesserts()
            .then(desserts => {
                this.desserts = desserts;
                this.initList(this.desserts, "dessert");
            })
        this.BoissonService.getBoissons()
            .then(boissons => {
                this.boissons = boissons;
                this.initList(this.boissons, "boisson");
            })
    }

    initList(fullList, type){
        switch(type){
            case "entree":
                if(fullList.length>3){
                    fullList.forEach( (entree, index) => {if(index<3) this.affichageEntrees.push(entree)} );
                } else {
                    this.affichageEntrees = fullList;
                }
                break;
            case "pizza":
                if(fullList.length>3){
                    fullList.forEach( (pizza, index) => {if(index<3) this.affichagePizzas.push(pizza)} );
                } else {
                    this.affichagePizzas = fullList;
                }
                break;
            case "dessert":
                if(fullList.length>3){
                    fullList.forEach( (dessert, index) => {if(index<3) this.affichageDesserts.push(dessert)} );
                } else {
                    this.affichageDesserts = fullList;
                }
                break;
            case "boisson":
                if(fullList.length>3){
                    fullList.forEach( (boisson, index) => {if(index<3) this.affichageBoissons.push(boisson)} );
                } else {
                    this.affichageBoissons = fullList;
                }
                break;
        }
    }

    nextEntry(){
        if(this.entryIndex < this.entrees.length-1){
            this.entryIndex++;
        } else {
            this.entryIndex = 0;
        }
        this.updateEntryAffichage();
    }
    previousEntry(){
        if(this.entryIndex > 0){
            this.entryIndex--;
        } else {
            this.entryIndex = this.entrees.length-1;
        }
        this.updateEntryAffichage();
    }
    updateEntryAffichage(){
        this.affichageEntrees[0] = this.entrees[this.entryIndex];
        this.affichageEntrees[1] = this.entrees[this.entryIndex+1];
        this.affichageEntrees[2] = this.entrees[this.entryIndex+2];
    }

    nextPizza(){
        if(this.pizzaIndex < this.pizzas.length-1){
            this.pizzaIndex++;
        } else {
            this.pizzaIndex = 0;
        }
        this.updatePizzaAffichage();
    }
    previousPizza(){
        if(this.pizzaIndex > 0){
            this.pizzaIndex--;
        } else {
            this.pizzaIndex = this.pizzas.length-1;
        }
        this.updatePizzaAffichage();
    }
    updatePizzaAffichage(){
        console.log(this.pizzaIndex);
        this.affichagePizzas[0] = this.pizzas[this.pizzaIndex];
        this.affichagePizzas[1] = this.pizzas[this.pizzaIndex+1];
        this.affichagePizzas[2] = this.pizzas[this.pizzaIndex+2];
    }
    
    nextDessert(){
        if(this.dessertIndex < this.desserts.length-1){
            this.dessertIndex++;
        } else {
            this.dessertIndex = 0;
        }
        this.updateDessertAffichage();
    }
    previousDessert(){
        if(this.dessertIndex > 0){
            this.dessertIndex--;
        } else {
            this.dessertIndex = this.desserts.length-1;
        }
        this.updateDessertAffichage();
    }
    updateDessertAffichage(){
        this.affichageDesserts[0] = this.desserts[this.dessertIndex];
        this.affichageDesserts[1] = this.desserts[this.dessertIndex+1];
        this.affichageDesserts[2] = this.desserts[this.dessertIndex+2];
    }
    
    nextBoisson(){
        if(this.boissonIndex < this.boissons.length-1){
            this.boissonIndex++;
        } else {
            this.boissonIndex = 0;
        }
        this.updateBoissonAffichage();
    }
    previousBoisson(){
        if(this.boissonIndex > 0){
            this.boissonIndex--;
        } else {
            this.boissonIndex = this.boissons.length-1;
        }
        this.updateBoissonAffichage();
    }
    updateBoissonAffichage(){
        this.affichageBoissons[0] = this.boissons[this.boissonIndex];
        this.affichageBoissons[1] = this.boissons[this.boissonIndex+1];
        this.affichageBoissons[2] = this.boissons[this.boissonIndex+2];
    }

}

export const ModalMenuChoix = {
    bindings: {
        menu: '<'
    },
    template: require('./menu-modal-choix.html'),
    controller: ModalMenuChoixController
}