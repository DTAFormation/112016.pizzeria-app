export default class CommandeController {
    constructor(CommandeService, PizzaService) {

        this.CommandeService = CommandeService;
        this.PizzaService = PizzaService;
        this.panierPizza = [];
        this.idClient=2;
        


    }

    $onInit() {
        
        this.total = this.CommandeService.commandeTMP().total;
        this.panier = this.CommandeService.commandeTMP().listeProduit;

        this.panier.idClient=this.idClient;
        this.panier.total=this.total;

        this.panier.forEach(function (element, index) {
            if (this.panier[index].type === "pizza") {
                this.PizzaService.getPizzaById(this.panier[index].idProduit)
                    .then((data) => {
                        data.quantite = this.panier[index].quantite;
                        this.panierPizza.push(data);
                    })
            }


            if (this.panier[index].type === "boisson") {


            }
            if (this.panier[index].type === "entrée") {


            }
            if (this.panier[index].type === "dessert") {

            }

        }, this);


    }
    livraison() {
        console.log("cliquer sur la livraison");
    }

    emporter() {
        console.log("cliquer sur à emporter");
    }

    envoyerCommande(){
        this.CommandeService.envoyeCommandeCache(this.panier);

    }

}