import _ from 'lodash'

export default class PanierController {

    constructor(PanierService, PizzaService, CommandeService) {

        this.PanierService = PanierService;
        this.PizzaService = PizzaService;
        this.CommandeService = CommandeService;
        this.hip = 0;
    }

    $onInit() {

        this.panier = this.PanierService.getPanier();
        this.promProduits = this.PizzaService.getPizzas();
        this.refreshPanier();
    }

    calculTotal() {

        this.total = 0;
        this.produitList.forEach((p) => {
            this.total += p.prix * p.quantite;
        });
    }

    majQuantite(produit) {

        this.CommandeService.majQuantiteCache(produit);
        this.calculTotal();
    }

    supprimerDuPanier(produit) {

        this.CommandeService.supprimerProduitDuCache(produit);
        this.refreshPanier();
    }

    refreshPanier() {

        this.promProduits.then(listeProd => {

            this.produitList = listeProd.filter(p => {

                return _.find(this.panier, (e) => {

                    p.quantite = e.quantite;
                    return e.idProduit === p.id;
                });
            });

            this.calculTotal();

            this.CommandeService.majCommande(this.panier, this.total);

        });
    }
}