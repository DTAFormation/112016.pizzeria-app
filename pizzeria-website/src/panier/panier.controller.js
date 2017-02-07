import _ from 'lodash'

export default class PanierController {

    constructor(UtilService, PanierService, PizzaService, CommandeService, BoissonService, PromotionService) {
        this.UtilService = UtilService;
        this.PanierService = PanierService;
        this.PizzaService = PizzaService;
        this.CommandeService = CommandeService;
        this.BoissonService = BoissonService;
        this.PromotionService = PromotionService;
        this.hip = 0;
        this.promotionMontant;
        this.promotionType;
        // this.promotionIsValid;
        this.code;
        this.message;
    }

    $onInit() {
        this.panier = this.PanierService.getPanier();
        //   this.promProduits = this.PizzaService.getPizzas();
        this.promProduits = this.PanierService.getProduits();
        this.refreshPanier();
        this.promotions = this.PromotionService.getPromotions();
        // console.log("=====>hello");

    }


    VerifPromo() {
        //console.log("====>Verif Promo " + this.code);
        if (typeof this.code !== 'undefined') {
            // console.log("====>Voici le code  Promo: " + this.code);
            this.promotions.
            then(listePromotion => {
                this.listePromotion = listePromotion;
                console.log(this.listePromotion);
                this.promotion = listePromotion.find(p => p.code === this.code);
                //console.log("====>Promotion est: " + this.promotion);
                if (typeof this.promotion !== 'undefined') {
                    this.message = "Code Valide";
                    //this.promotionIsValid = true;
                    console.log("====>Code promo valide ");
                    this.promotionMontant = this.promotion.montant;
                    this.promotionType = this.promotion.type;
                    // console.log("!!!!!!!!!" + this.promotionType);
                    // console.log(this.promotion);
                    this.calculTotal();
                } else {
                    this.message = "Code Invalide";
                    //this.promotionIsValid = false;
                    console.log("====>Code promo invalide ");
                }
            })
        } else {
            console.log("====>pas de code Promo");
            //this.promotionIsValid = false;
        }
    }

    calculTotal() {

        this.total = 0;

        console.log("Montant: " + this.promotionMontant);
        console.log("Type: " + this.promotionType);

        switch (this.promotionType) {

            case "monetaire":
                console.log("Monetaire");

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
                console.log("Pourcentage");
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

            this.calculTotal();



            this.CommandeService.majCommande(this.panier, this.total);

        });
    }
}