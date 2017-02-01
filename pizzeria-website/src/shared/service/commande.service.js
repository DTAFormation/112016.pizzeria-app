const api = 'http://localhost:3000/commandes'

export class CommandeService {
    constructor($localStorage, PizzaService, $http) {
         this.$http = $http;
        this.$localStorage = $localStorage;
        this.PizzaService = PizzaService;

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

        let panier = this.$localStorage.jsonPanier;
        let commande = this.$localStorage.commandeEnCours.listeProduit;

        _.remove(panier, e => e.idProduit === produit.id && e.type === produit.type);
    }

    
    getCommandeByUserId(id){
         return this.$http.get(`${ api }/${ id }`)
            .then(response => response.data);
    }

    getCommandeById(id){
         return this.$http.get(`${ api }/commande/${ id }`)
            .then(response => response.data);
    }
}