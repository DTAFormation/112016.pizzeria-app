export default class CommandeController {
    constructor(CommandeService, PizzaService) {

        this.CommandeService = CommandeService;
        this.PizzaService = PizzaService;
        this.panierPizza = [];


    }

    $onInit() {
        this.panier = this.CommandeService.commandeTMP().listeProduit;
        console.log(this.panier);

        this.panier.forEach(function (element, index) {
            if (this.panier[index].type === "pizza") {
                this.PizzaService.getPizzaById(this.panier[index].id)
                    .then((data) => {
                       data.quantite=this.panier[index].quantite
                        this.panierPizza.push(data);
                    })
            }
            console.log(this.panierPizza);

            if (this.panier[index].type === "boisson") {


            }
            if (this.panier[index].type === "entrée") {


            }
            if (this.panier[index].type === "dessert") {

            }

        }, this);
       console.log(this.panierPizza);

    }
    livraison(){
        console.log("cliquer sur la livraison");
    }

    emporter(){
        console.log("cliquer sur à emporter");
    }

}