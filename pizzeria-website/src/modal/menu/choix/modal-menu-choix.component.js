import css from "./modal-xlg.css";

class ModalMenuChoixController {

    constructor(EntreeService, PizzaService, DessertService, BoissonService, UtilService, PanierService) {
        this.EntreeService = EntreeService;
        this.PizzaService = PizzaService;
        this.DessertService = DessertService
        this.BoissonService = BoissonService;
        this.UtilService = UtilService;
        this.PanierService = PanierService;
        this.reset();
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

    reset(){
        this.entreesChoix = [];
        this.pizzasChoix = [];
        this.dessertsChoix = [];
        this.boissonsChoix = [];
        this.affichageEntrees= [];
        this.affichagePizzas = [];
        this.affichageDesserts = [];
        this.affichageBoissons = [];
        this.entryIndex0 = 0;
        this.entryIndex1 = 1;
        this.entryIndex2 = 2;
        this.pizzaIndex0 = 0;
        this.pizzaIndex1 = 1;
        this.pizzaIndex2 = 2;
        this.dessertIndex0 = 0;
        this.dessertIndex1 = 1;
        this.dessertIndex2 = 2;
        this.boissonIndex0 = 0;
        this.boissonIndex1 = 1;
        this.boissonIndex2 = 2;
        this.$onInit();
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

    ajouterMenu(product){
        switch(product.type){
            case "entree":
            this.entreesChoix.push(product);
            break;
            case "pizza":
            this.pizzasChoix.push(product);
            break;
            case "dessert":
            this.dessertsChoix.push(product);
            break;
            case "boisson":
            this.boissonsChoix.push(product);
            break;
        }
    }

    retirerMenu(productType, id){
        switch(productType){
            case "entree":
            this.entreesChoix.splice(id,1);
            break;
            case "pizza":
            this.pizzasChoix.splice(id,1);
            break;
            case "dessert":
            this.dessertsChoix.splice(id,1);
            break;
            case "boisson":
            this.boissonsChoix.splice(id,1);
            break;
        }
    }

    nextEntry(){
        if(this.entrees.length>3){
            if(this.entryIndex0 < this.entrees.length-1){
                this.entryIndex0++;
            } else {
                this.entryIndex0 = 0;
            }
            if(this.entryIndex1 < this.entrees.length-1){
                this.entryIndex1++;
            } else {
                this.entryIndex1 = 0;
            }
            if(this.entryIndex2 < this.entrees.length-1){
                this.entryIndex2++;
            } else {
                this.entryIndex2 = 0;
            }
            this.updateEntryAffichage();
        }
    }
    previousEntry(){
        if(this.entrees.length>3){
            if(this.entryIndex0 > 0){
                this.entryIndex0--;
            } else {
                this.entryIndex0 = this.entrees.length-1;
            }
            if(this.entryIndex1 > 0){
                this.entryIndex1--;
            } else {
                this.entryIndex1 = this.entrees.length-1;
            }
            if(this.entryIndex2 > 0){
                this.entryIndex2--;
            } else {
                this.entryIndex2 = this.entrees.length-1;
            }
            this.updateEntryAffichage();
        }
    }
    updateEntryAffichage(){
        this.affichageEntrees[0] = this.entrees[this.entryIndex0];
        this.affichageEntrees[1] = this.entrees[this.entryIndex1];
        this.affichageEntrees[2] = this.entrees[this.entryIndex2];
    }

    nextPizza(){
        if(this.pizzas.length>3){
            if(this.pizzaIndex0 < this.pizzas.length-1){
                this.pizzaIndex0++;
            } else {
                this.pizzaIndex0 = 0;
            }
            if(this.pizzaIndex1 < this.pizzas.length-1){
                this.pizzaIndex1++;
            } else {
                this.pizzaIndex1 = 0;
            }
            if(this.pizzaIndex2 < this.pizzas.length-1){
                this.pizzaIndex2++;
            } else {
                this.pizzaIndex2 = 0;
            }
            this.updatePizzaAffichage();
        }
    }
    previousPizza(){
        if(this.pizzas.length>3){
            if(this.pizzaIndex0 > 0){
                this.pizzaIndex0--;
            } else {
                this.pizzaIndex0 = this.pizzas.length-1;
            }
            if(this.pizzaIndex1 > 0){
                this.pizzaIndex1--;
            } else {
                this.pizzaIndex1 = this.pizzas.length-1;
            }
            if(this.pizzaIndex2 > 0){
                this.pizzaIndex2--;
            } else {
                this.pizzaIndex2 = this.pizzas.length-1;
            }
            this.updatePizzaAffichage();
        }
    }
    updatePizzaAffichage(){
        this.affichagePizzas[0] = this.pizzas[this.pizzaIndex0];
        this.affichagePizzas[1] = this.pizzas[this.pizzaIndex1];
        this.affichagePizzas[2] = this.pizzas[this.pizzaIndex2];
    }
    
    nextDessert(){
        if(this.desserts.length>3){
            if(this.dessertIndex0 < this.desserts.length-1){
                this.dessertIndex0++;
            } else {
                this.dessertIndex0 = 0;
            }
            if(this.dessertIndex1 < this.desserts.length-1){
                this.dessertIndex1++;
            } else {
                this.dessertIndex1 = 0;
            }
            if(this.dessertIndex2 < this.desserts.length-1){
                this.dessertIndex2++;
            } else {
                this.dessertIndex2 = 0;
            }
            this.updateDessertAffichage();
        }
    }
    previousDessert(){
        if(this.desserts.length>3){
            if(this.dessertIndex0 > 0){
                this.dessertIndex0--;
            } else {
                this.dessertIndex0 = this.desserts.length-1;
            }
            if(this.dessertIndex1 > 0){
                this.dessertIndex1--;
            } else {
                this.dessertIndex1 = this.desserts.length-1;
            }
            if(this.dessertIndex2 > 0){
                this.dessertIndex2--;
            } else {
                this.dessertIndex2 = this.desserts.length-1;
            }
            this.updateDessertAffichage();
        }
    }
    updateDessertAffichage(){
        this.affichageDesserts[0] = this.desserts[this.dessertIndex0];
        this.affichageDesserts[1] = this.desserts[this.dessertIndex1];
        this.affichageDesserts[2] = this.desserts[this.dessertIndex2];
    }
    
    nextBoisson(){
        if(this.boissons.length>3){
            if(this.boissonIndex0 < this.boissons.length-1){
                this.boissonIndex0++;
            } else {
                this.boissonIndex0 = 0;
            }
            if(this.boissonIndex1 < this.boissons.length-1){
                this.boissonIndex1++;
            } else {
                this.boissonIndex1 = 0;
            }
            if(this.boissonIndex2 < this.boissons.length-1){
                this.boissonIndex2++;
            } else {
                this.boissonIndex2 = 0;
            }
            this.updateBoissonAffichage();
        }
    }
    previousBoisson(){
        if(this.boissons.length>3){
            if(this.boissonIndex0 > 0){
                this.boissonIndex0--;
            } else {
                this.boissonIndex0 = this.boissons.length-1;
            }
            if(this.boissonIndex1 > 0){
                this.boissonIndex1--;
            } else {
                this.boissonIndex1 = this.boissons.length-1;
            }
            if(this.boissonIndex2 > 0){
                this.boissonIndex2--;
            } else {
                this.boissonIndex2 = this.boissons.length-1;
            }
            this.updateBoissonAffichage();
        }
    }
    updateBoissonAffichage(){
        this.affichageBoissons[0] = this.boissons[this.boissonIndex0];
        this.affichageBoissons[1] = this.boissons[this.boissonIndex1];
        this.affichageBoissons[2] = this.boissons[this.boissonIndex2];
    }

    valider(){
        this.PanierService.ajouterMenu(this.menu, this.entreesChoix, this.pizzasChoix, this.dessertsChoix, this.boissonsChoix);
        this.reset();
    }

}

export const ModalMenuChoix = {
    bindings: {
        menu: '<'
    },
    template: require('./menu-modal-choix.html'),
    controller: ModalMenuChoixController
}