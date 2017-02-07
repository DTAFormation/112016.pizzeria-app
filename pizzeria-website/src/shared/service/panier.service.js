import _ from 'lodash';

export class PanierService {
    constructor($localStorage, PizzaService, BoissonService, $q, DessertService, EntreeService, MenuService) {

        this.$localStorage = $localStorage;
        this.BoissonService = BoissonService;
        this.DessertService = DessertService;
        this.PizzaService = PizzaService;
        this.EntreeService = EntreeService;
        this.MenuService = MenuService;
        this.$q = $q;
    }

    getProduits() {

        return this.PizzaService.getPizzas()
            .then(pizzas =>
                this.BoissonService.getBoissons()
                .then(boissons =>
                    this.DessertService.getDesserts()
                    .then(desserts =>
                        this.EntreeService.getEntrees()
                        .then(entrees =>
                            this.MenuService.getMenus()
                            .then(menus =>
                                this.prodList = _.concat(pizzas, boissons, desserts, entrees, menus)
                            )
                        )
                    )
                )
            )

    }

    initPanier() {
        this.$localStorage.jsonPanier = this.$localStorage.jsonPanier || [];
        return this.$localStorage.jsonPanier;
    }

    ajouterElement(element) {
        console.log(element)
        if (this.$localStorage.jsonPanier === undefined)
            this.initPanier();
        let panier = this.$localStorage.jsonPanier;
        let exist = _.find(panier, e => (e.idProduit === element.id && e.type === element.type));
        if (exist !== undefined) {
            ++exist.quantite;
        } else {
            let ajout = {};
            ajout.type = element.type;
            ajout.idProduit = element.id;
            ajout.quantite = 1;
            panier.push(ajout);
        }

    }

    ajouterMenu(menu, entrees, pizzas, desserts, boissons){
        if (this.$localStorage.jsonPanier === undefined)
            this.initPanier();
        let panier = this.$localStorage.jsonPanier;
        let menuPanier = {};
        menuPanier.type = "menu";
        menuPanier.idProduit = menu.id;
        menuPanier.quantite = 1;
        if(entrees!= undefined){
            for(var key in entrees){
                let existEntree = _.find(menuPanier, e => (e.idProduit === entrees[key].id && e.type === entrees[key].type));
                if (existEntree !== undefined) {
                    ++existEntree.quantite;
                } else {
                    let entree = {};
                    entree.type = entrees[key].type;
                    entree.idProduit = entrees[key].id;
                    entree.quantite = 1;
                    menuPanier.entree = [];
                    menuPanier.entree.push(entree);
                }
            }
        }
        if(pizzas!= undefined){
            for(var key in pizzas){
                let existPizza = _.find(menu, e => (e.idProduit === pizzas[key].id && e.type === pizzas[key].type));
                if (existPizza !== undefined) {
                    ++existPizza.quantite;
                } else {
                    let pizza = {};
                    pizza.type = pizzas[key].type;
                    pizza.idProduit = pizzas[key].id;
                    pizza.quantite = 1;
                    menuPanier.pizza = [];
                    menuPanier.pizza.push(pizza);
                }
            }
        }
        if(desserts!= undefined){
            for(var key in desserts){
                let existDessert = _.find(menu, e => (e.idProduit === desserts[key].id && e.type === desserts[key].type));
                if (existDessert !== undefined) {
                    ++existDessert.quantite;
                } else {
                    let dessert = {};
                    dessert.type = desserts[key].type;
                    dessert.idProduit = desserts[key].id;
                    dessert.quantite = 1;
                    menuPanier.dessert = [];
                    menuPanier.dessert.push(dessert);
                }
            }
        }
        if(boissons!= undefined){
            for(var key in boissons){
                let existBoisson = _.find(menu, e => (e.idProduit === boissons[key].id && e.type === boissons[key].type));
                if (existBoisson !== undefined) {
                    ++existBoisson.quantite;
                } else {
                    let boisson = {};
                    boisson.type = boissons[key].type;
                    boisson.idProduit = boissons[key].id;
                    boisson.quantite = 1;
                    menuPanier.boisson = [];
                    menuPanier.boisson.push(boisson);
                }
            }
        }
        panier.push(menuPanier);
    }

    resetPanier() {
        delete this.$localStorage.jsonPanier;
    }

    getPanier() {
        return this.$localStorage.jsonPanier || this.initPanier();
    }
}