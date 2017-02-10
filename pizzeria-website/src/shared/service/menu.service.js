const api = 'http://localhost:3000/menus'

export class MenuService {
    constructor($http) {

        this.$http = $http;
        this.menus = this.$http.get(api)
            .then(response => {

                response.data.forEach(function (element) {
                    element.type = "menu"
                }, this);

                return response.data;
            }


            );

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
                            this.prodList = _.concat(pizzas, boissons, desserts, entrees)
                        )
                    )
                )
            )

    }

    initMenu() {

        this.$localStorage.jsonMenu = this.$localStorage.jsonMenu || [];

        return this.$localStorage.jsonMenu;
    }

    ajouterElement(element) {

        if (this.$localStorage.jsonMenu === undefined)
            this.initMenu();

        let menu = this.$localStorage.jsonMenu;

        let exist = _.find(menu, e => (e.idProduit === element.id && e.type === element.type));

        if (exist !== undefined) {
            ++exist.quantite;
        } else {
            let ajout = {};

            ajout.type = element.type;
            ajout.idProduit = element.id;
            ajout.quantite = 1;
            menu.push(ajout);
        }

    }


    resetMenu() {

        delete this.$localStorage.jsonMenu;

    }

    getMenu() {

        return this.$localStorage.jsonMenu || this.initMenu();
    }

    getMenus() {
        return this.menus;
    }

    getMenuById(id) {

        return this.menus.then(menus => _.find(menus, p => p.id === id));
    }

}