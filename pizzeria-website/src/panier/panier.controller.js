import _ from 'lodash'

export default class PanierController {

    constructor(UtilService, PanierService, PizzaService, CommandeService, BoissonService) {
        this.UtilService = UtilService;
        this.PanierService = PanierService;
        this.PizzaService = PizzaService;
        this.CommandeService = CommandeService;
        this.BoissonService = BoissonService;
        this.hip = 0;
    }

    $onInit() {


        this.panier = this.PanierService.getPanier();
        //   this.promProduits = this.PizzaService.getPizzas();
        this.promProduits = this.PanierService.getProduits();
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
                    return e.idProduit === p.id && e.type === p.type;
                });
            });

            this.calculTotal();

            this.CommandeService.majCommande(this.panier, this.total);

        });
    }
}