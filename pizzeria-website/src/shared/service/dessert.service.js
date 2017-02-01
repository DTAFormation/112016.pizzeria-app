const api ='http://localhost:3000/desserts'

export class DessertService{
    constructor($http) {

        this.$http = $http;

    }

    getDesserts(){
        return this.$http.get(api)
            .then(response => response.data);
    }

}