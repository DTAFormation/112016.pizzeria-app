import _ from 'lodash'

export default class PanierController {

    constructor(UtilService, PanierService, EntreeService, PizzaService, CommandeService, BoissonService, DessertService, PromotionService) {
        this.UtilService = UtilService;
        this.PanierService = PanierService;
        this.EntreeService = EntreeService;
        this.PizzaService = PizzaService;
        this.CommandeService = CommandeService;
        this.BoissonService = BoissonService;
        this.PromotionService = PromotionService;
        this.DessertService = DessertService;
        this.hip = 0;
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
                    if(e.pizzas!==undefined){
                        p.pizzas = [];
                        e.pizzas.forEach(product =>{
                            this.PizzaService.getPizzaById(product.idProduit).then(productP => {
                                let productL = productP;
                                productL.quantite = product.quantite;
                                p.pizzas.push(productL);
                            });
                        });
                    }
                    if(e.entrees!==undefined){
                        p.entrees = [];
                        e.entrees.forEach(product =>{
                            this.EntreeService.getEntreesById(product.idProduit).then(productP => {
                                let productL = productP;
                                productL.quantite = product.quantite;
                                p.entrees.push(productL);
                            });
                        });
                    }
                    if(e.desserts!==undefined){
                        p.desserts = [];
                        e.desserts.forEach(product =>{
                            this.DessertService.getdessertsById(product.idProduit).then(productP => {
                                let productL = productP;
                                productL.quantite = product.quantite;
                                p.desserts.push(productL);
                            });
                        });
                    }
                    if(e.boissons!==undefined){
                        p.boissons = [];
                        e.boissons.forEach(product =>{
                            this.BoissonService.getBoissonsById(product.idProduit).then(productP => {
                                let productL = productP;
                                productL.quantite = product.quantite;
                                p.boissons.push(productL);
                            });
                        });
                    }
                    return e.idProduit === p.id && e.type === p.type;
                });
            });
            this.calculTotal();


            this.CommandeService.majCommande(this.panier, this.total);

        });
    }
}