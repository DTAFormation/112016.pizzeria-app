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

}

export const ModalMenuChoix = {
    bindings: {
        menu: '<'
    },
    template: require('./menu-modal-choix.html'),
    controller: ModalMenuChoixController
}