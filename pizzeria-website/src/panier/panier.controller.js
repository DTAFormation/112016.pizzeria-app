import _ from 'lodash'

export default class PanierController {

    constructor(UtilService, PanierService, PizzaService, CommandeService, BoissonService) {
        this.UtilService = UtilService;
        this.PanierService = PanierService;
        this.PizzaService = PizzaService;
        this.CommandeService = CommandeService;
        this.BoissonService = BoissonService;
        this.hip = 0;
        this.promo = 0; //implementer les promotions en BDD
        this.code;
    }

    $onInit() {
        this.panier = this.PanierService.getPanier();
        //   this.promProduits = this.PizzaService.getPizzas();
        this.promProduits = this.PanierService.getProduits();
        this.refreshPanier();
    }


    VerifPromo() {
        console.log("!!!!!!!!!!");
    }

    calculTotal() {

        this.total = 0;

        switch (this.promo) {

            case 0:

                this.produitList.forEach((p) => {
                    this.total += p.prix * p.quantite;
                });
                break;

            default:

                this.produitList.forEach((p) => {
                    this.total += p.prix * p.quantite;
                });
                this.total = this.total - this.promo;
                var tempTotal = this.total;
                if (Math.sign(tempTotal) === -1) {
                    this.total = 0;
                }
        }
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