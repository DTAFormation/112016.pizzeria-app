const api = 'http://localhost:3000/commandes'

export class CommandeService{

    constructor($q, $http){

        this.$q = $q;
        this.$http = $http;

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