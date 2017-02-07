class ModalMenuChoixController {

    constructor(EntreeService, PizzaService, DessertService, BoissonService) {
        this.EntreeService = EntreeService;
        this.PizzaService = PizzaService;
        this.DessertService = DessertService
        this.BoissonService = BoissonService;
    }

    $onInit() {
        this.EntreeService.getEntrees()
            .then(entrees => {
                this.entrees = entrees;
            })
        this.PizzaService.getPizzas()
            .then(pizzas =>
                this.pizzas = pizzas
            );
        this.DessertService.getDesserts()
            .then(desserts => {
                this.desserts = desserts;
            })
        this.BoissonService.getBoissons()
            .then(boissons => {
                this.boissons = boissons;
            })
    }
}

export const ModalMenuChoix = {
    bindings: {
        menu: '<'
    },
    template: require('./menu-modal-choix.html'),
    controller: ModalMenuChoixController
}