import _ from 'lodash';

const api = 'http://localhost:3000/pizzas'; // Fill the api URL here and use it everywhere

export class PizzaService {

    constructor($http) {
        this.$http = $http;
        this.pizzas=  this.$http.get(api)
            .then((response) =>
                response.data
            );

    }


    getPizzas() {

        return this.pizzas;
            
    }

    getPizzaById(id) {

       return this.pizzas.then(pizzas => _.find(pizzas, p => p.id === id));
   }

}