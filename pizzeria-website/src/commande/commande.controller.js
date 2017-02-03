export default class CommandeController {
    constructor(CommandeService, PizzaService, PanierService, BoissonService, DessertService, EntreeService) {

        this.CommandeService = CommandeService;
        this.PizzaService = PizzaService;
        this.BoissonService = BoissonService;
        this.DessertService = DessertService;
        this.PanierService = PanierService;
        this.EntreeService = EntreeService;
        this.total=0;
        this.panierPizza = [];
        this.idClient = 2;



    }

    $onInit() {

        this.total = this.CommandeService.commandeTMP().total;
        this.panier = this.CommandeService.commandeTMP().listeProduit;
        console.log(this.panier);

        this.panier.idClient = this.idClient;
        this.panier.total = this.total;

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
                        this.panierPizza.push(data);
                    })

            }

            if (this.panier[index].type === "dessert") {
                this.DessertService.getdessertsById(this.panier[index].idProduit)
                    .then((data) => {
                        console.log((data))
                        data.quantite = this.panier[index].quantite;
                        this.panierPizza.push(data);
                    })
            }
            
            if (this.panier[index].type === "entrée") {
                this.EntreeService.getEntreesById(this.panier[index].idProduit)
                    .then((data) => {
                        console.log((data))
                        data.quantite = this.panier[index].quantite;
                        this.panierPizza.push(data);
                    })
            }

        }, this);


    }
    livraison() {
        console.log("cliquer sur la livraison");
    }

    emporter() {
        console.log("cliquer sur à emporter");
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