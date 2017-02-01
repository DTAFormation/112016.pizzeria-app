const api = 'http://localhost:3000/commandes'

export class CommandeService {

   constructor($q, $http, $localStorage) {

       this.$q = $q;
       this.$http = $http;
       this.totalCommande;
       this.$localStorage = $localStorage;

   }

   commandeTMP() {
       this.$localStorage.commandeEnCours = {};
       this.$localStorage.commandeEnCours.total = 42.50;
       this.$localStorage.commandeEnCours.listeProduit = [{ "type": "pizza", "id": 1, "quantite": 12 },
       { "type": "pizza", "id": 2, "quantite": 1 },
       { "type": "pizza", "id": 3, "quantite": 11 }];
       return this.$localStorage.commandeEnCours;
   }


   getCommandesByUserId(id) {
       return this.$http.get(`${api}/${id}`)
           .then(response => response.data);
   }

   getTotal() {

   }

   setTotal() {

   }

}