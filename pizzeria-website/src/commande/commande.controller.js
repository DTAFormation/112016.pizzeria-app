import css from './commande.component.css';

export default class CommandeController {
    constructor(CommandeService, PizzaService, PanierService, BoissonService, DessertService, EntreeService, UtilService) {

        this.CommandeService = CommandeService;
        this.PizzaService = PizzaService;
        this.BoissonService = BoissonService;
        this.DessertService = DessertService;
        this.PanierService = PanierService;
        this.EntreeService = EntreeService;
        this.UtilService = UtilService;
        this.total=0;
        this.panierPizza = [];
        this.panierBoisson = [];
        this.panierEntree = [];
        this.panierDessert = [];
        this.idClient = 2;
        this.aEmporter = false;
        this.aLivrer = true;



    }

    $onInit() {

        this.total = this.CommandeService.commandeTMP().total;
        this.panier = this.CommandeService.commandeTMP().listeProduit;

        this.panier.idClient = this.idClient;
        this.panier.total = this.total;
        this.panier.aLivrer = this.aLivrer;

        this.panier.forEach(function (element, index) {
            if (this.panier[index].type === "pizza") {
                this.PizzaService.getPizzaById(this.panier[index].idProduit)
                    .then((data) => {
                        data.quantite = this.panier[index].quantite;
                        this.panierPizza.push(data);
                    })
            }


            if (this.panier[index].type === "boisson") {
                this.BoissonService.getBoissonsById(this.panier[index].idProduit)
                    .then((data) => {
                        data.quantite = this.panier[index].quantite;
                        this.panierBoisson.push(data);
                    })

            }

            if (this.panier[index].type === "dessert") {
                this.DessertService.getdessertsById(this.panier[index].idProduit)
                    .then((data) => {
                        data.quantite = this.panier[index].quantite;
                        this.panierDessert.push(data);
                    })
            }
            
            if (this.panier[index].type === "entree") {
                this.EntreeService.getEntreesById(this.panier[index].idProduit)
                    .then((data) => {
                        data.quantite = this.panier[index].quantite;
                        this.panierEntree.push(data);
                    })
            }

        }, this);


    }

    livraison() {
        this.aEmporter = false;
        this.aLivrer = true;
    }

    emporter() {
        this.aEmporter = true;
        this.aLivrer = false;
    }

    envoyerCommande() {
        this.CommandeService.envoyeCommandeCache(this.panier);
        this.CommandeService.ResetCommande();

    }
    revoieIdCommande() {
        //this.CommandeService.getCommande(this.idClient).then(commandes => console.log(commande))
        this.idCommande();
    }



}