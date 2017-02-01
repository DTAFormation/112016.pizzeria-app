import _ from 'lodash';

const api = 'http://localhost:3000/pizzas'; // Fill the api URL here and use it everywhere

export class PizzaService {

    constructor($q, $http) {

        this.$q = $q;
        this.$http = $http;
        this.pizzas = this.findAll();

    }

    findAll() {

        const pizzas = [{
            id: 0,
            type: 'pizza',
            name: "Margherita",
            prix: 12.00,
            urlImage: "http://mister-check.e-monsite.com/medias/images/pizza2.jpg",
            ingredients: ['sel', 'poivre', 'tomate']
        }, {
            id: 1,
            type: 'pizza',
            name: "Peperoni",
            prix: 9.00,
            urlImage: "http://timmatic.com/i/2016/12/pepperoni-pizza-wallpaper-wide.jpg",
            ingredients: ['tomate', 'poivron', 'oignons']
        }, {
            id: 2,
            type: 'pizza',
            name: "Reine",
            prix: 15.50,
            urlImage: "http://astucelle.com/wp-content/uploads/2016/11/image-41.jpeg",
            ingredients: ['champignons', 'viande', 'fromage']
        }];

        return this.$q.resolve(pizzas);
    }

    getPizzas() {

        return this.$http.get(api)
            .then((response) =>
                response.data
            );

    }

    getPizzaById(id) {

        return this.pizzas.then(pizzas => _.find(pizzas, p => p.id === id));
    }
}