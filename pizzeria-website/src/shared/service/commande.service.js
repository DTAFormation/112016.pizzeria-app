const api = 'http://localhost:3000/commandes'

export class CommandeService {
    constructor($http, $localStorage, PizzaService, PanierService) {
        this.$http = $http;
        this.totalCommande;
        this.$localStorage = $localStorage;
        this.commande = [];
        this.PizzaService = PizzaService;
        this.PanierService = PanierService;
    }

    ResetCommande(){
        this.PanierService.resetPanier();
        delete this.$localStorage.commandeEnCours;
        this.totalCommande=0;
    }

    majCommande(listeProduit, total) {

        this.$localStorage.commandeEnCours = {};

        this.$localStorage.commandeEnCours.listeProduit = listeProduit;
        this.$localStorage.commandeEnCours.total = total;
    }

    majQuantiteCache(produit) {

        let tab = this.$localStorage.commandeEnCours.listeProduit;
        let elem = _.find(tab, p => p.idProduit === produit.id && p.type === produit.type);

        elem.quantite = produit.quantite;
    }

    supprimerProduitDuCache(produit) {
;
        let panier = this.$localStorage.jsonPanier;
        _.remove(panier, e => e.idProduit === produit.id && e.type === produit.type);
    }

    commandeTMP() {
        // this.$localStorage.commandeEnCours = {};
        // this.$localStorage.commandeEnCours.total = 42.50;
        // this.$localStorage.commandeEnCours.listeProduit = [{ "type": "pizza", "idProduit": 1, "quantite": 12 },
        // { "type": "pizza", "idProduit": 2, "quantite": 1 },
        // { "type": "pizza", "idProduit": 3, "quantite": 11 }];
        return this.$localStorage.commandeEnCours;
    }


    getCommandesByUserId() {
        return this.$http.get(`${api}`)
            .then(response => response.data);
    }

    envoyeCommandeCache(commandeATraiter) {
        commandeATraiter.forEach(function (element, index) {
            if (commandeATraiter[index].type === "pizza" || commandeATraiter[index].type === "boisson" || commandeATraiter[index].type === "entree" || commandeATraiter[index].type === "dessert" || commandeATraiter[index].type === "menu") {
                element.idClient = commandeATraiter.idClient;
                element.total = commandeATraiter.total;
                this.commande.push(element);
                console.log(element);
            }
        }, this);
        return this.$http.post(api, this.commande)
    }

    getCommandeById(id) {
        return this.$http.get(`${api}/commande/${id}`)
            .then(response => response.data);
    }

}
