const api = 'http://localhost:3000/entrees'

export class EntreeService {
    constructor($http) {

        this.$http = $http;
        this.entrees = this.$http.get(api)
            .then(response => {

                response.data.forEach(function (element) {
                    element.type = "entree"
                }, this);

                return response.data;
            }


            );

    }


    getEntrees() {
        return this.entrees;
    }

    getEntreesById(id) {

        return this.entrees.then(entrees => _.find(entrees, p => p.id === id));
    }

}