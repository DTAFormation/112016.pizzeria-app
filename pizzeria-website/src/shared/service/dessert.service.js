const api = 'http://localhost:3000/desserts'

export class DessertService {
    constructor($http) {

        this.$http = $http;
        this.desserts = this.$http.get(api)
            .then(response => {

                response.data.forEach(function (element) {
                    element.type = "dessert"
                }, this);

                return response.data;
            }


            );

    }


    getDesserts() {
        return this.desserts;
    }

    getdessertsById(id) {

        return this.desserts.then(desserts => _.find(desserts, p => p.id === id));
    }

}