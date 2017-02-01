import _ from 'lodash'

export default class PanierController {

    constructor(PanierService, PizzaService) {

        this.PanierService = PanierService;
        this.PizzaService = PizzaService;
        this.produitList = [];
 
    }

    $onInit() {

        this.panier = this.PanierService.getPanier();

        this.panier.forEach(e => {

            this.PizzaService.getPizzaById(e.id).then(produit => {

                produit.quantite = e.quantite;
                this.produitList.push(produit);
            });
        });
    }

}