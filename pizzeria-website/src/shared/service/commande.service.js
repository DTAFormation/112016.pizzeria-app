const api = 'http://localhost:3000/commandes'

export class CommandeService {

    constructor($q, $http, $localStorage) {

        this.$q = $q;
        this.$http = $http;
        this.totalCommande;
        this.$localStorage = $localStorage;
        this.commande = [];

    }

    commandeTMP() {
        this.$localStorage.commandeEnCours = {};
        this.$localStorage.commandeEnCours.total = 42.50;
        this.$localStorage.commandeEnCours.listeProduit = [{ "type": "pizza", "idProduit": 1, "quantite": 12 },
        { "type": "pizza", "idProduit": 2, "quantite": 1 },
        { "type": "pizza", "idProduit": 3, "quantite": 11 }];
        return this.$localStorage.commandeEnCours;
    }


    getCommandesByUserId(id) {
        return this.$http.get(`${api}/${id}`)
            .then(response => response.data);
    }

    envoyeffCommande(commandeATraiter) {
        commandeATraiter.forEach(function (element, index) {
            if (commandeATraiter[index].type === "pizza") {
                element.idClient = commandeATraiter.idClient;
                element.total = commandeATraiter.total;
                this.commande.push(element);
            }
        }, this);
        console.log(this.commande);

        return this.$http.post(api, this.commande)
            .then(response => response.data);
    }

}