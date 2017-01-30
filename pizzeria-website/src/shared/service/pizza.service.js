const api = 'API_URL'; // Fill the api URL here and use it everywhere

export class PizzaService {
    constructor($q) {

        this.$q = $q;
    }

    findAll() {

        const pizzas = [{
            id: 0,
            type: 'pizza',
            name: "Margherita",
            src: "http://mister-check.e-monsite.com/medias/images/pizza2.jpg"
        }, {
            id: 1,
            type: 'pizza',
            name: "Peperoni",
            src: "http://timmatic.com/i/2016/12/pepperoni-pizza-wallpaper-wide.jpg"
        }, {
            id: 2,
            type: 'pizza',
            name: "Reine",
            src: "http://astucelle.com/wp-content/uploads/2016/11/image-41.jpeg"
        }];

        return this.$q.resolve(pizzas);
    }
}