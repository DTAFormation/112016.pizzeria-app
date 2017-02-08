import _ from 'lodash'

export default class PanierController {

    constructor(UtilService, PanierService, PizzaService, CommandeService, BoissonService, PromotionService) {
        this.UtilService = UtilService;
        this.PanierService = PanierService;
        this.PizzaService = PizzaService;
        this.CommandeService = CommandeService;
        this.BoissonService = BoissonService;
        this.PromotionService = PromotionService;
        this.promotionMontant;
        this.promotionType;
        this.code;
        this.message;
    }

    $onInit() {
        this.panier = this.PanierService.getPanier();
        this.promProduits = this.PanierService.getProduits();
        this.refreshPanier();
        this.promotions = this.PromotionService.getPromotions();

    }


    VerifPromo() {
        if (typeof this.code !== 'undefined') {
            this.promotions.
            then(listePromotion => {
                this.listePromotion = listePromotion;
                this.promotion = listePromotion.find(p => p.code === this.code);
                if (typeof this.promotion !== 'undefined') {
                    this.promotionMontant = this.promotion.montant;
                    this.promotionType = this.promotion.type;
                    if (this.promotionType === "monetaire") {
                        this.message = "Code Valide -" + this.promotionMontant + " € sur votre commande";
                    } else {
                        this.message = "Code Valide -" + this.promotionMontant + " % sur votre commande soit " +
                            (((this.promotionMontant / 100) * this.total)).toFixed(2) + " € d'économie";
                    }
                    this.calculTotal();
                } else {
                    this.message = "Code Invalide";
                }
            })
        } else {}
    }

    calculTotal() {

        this.total = 0;
        switch (this.promotionType) {

            case "monetaire":

                this.produitList.forEach((p) => {
                    this.total += p.prix * p.quantite;
                });
                this.total = this.total - this.promotionMontant;
                var tempTotal = this.total;
                if (Math.sign(tempTotal) === -1) {
                    this.total = 0;
                }

                break;
            case "pourcentage":

                this.produitList.forEach((p) => {
                    this.total += p.prix * p.quantite;
                });
                this.total = this.total - ((this.promotionMontant / 100) * this.total);
                var tempTotal = this.total;

                if (Math.sign(tempTotal) === -1) {
                    this.total = 0;
                }

                break;

            default:
                this.produitList.forEach((p) => {
                    this.total += p.prix * p.quantite;
                });


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
            
                    console.log(this.produitList);
            this.calculTotal();


            this.CommandeService.majCommande(this.panier, this.total);

        });
    }
}