export default class HomeController {
    constructor() {}

    $onInit() {
        this.pizzas = [{
            id: 0,
            name: "Margherita",
            src: "http://mister-check.e-monsite.com/medias/images/pizza2.jpg"
        }, {
            id: 1,
            name: "Peperoni",
            src: "http://timmatic.com/i/2016/12/pepperoni-pizza-wallpaper-wide.jpg"
        }, {
            id: 2,
            name: "Reine",
            src: "http://astucelle.com/wp-content/uploads/2016/11/image-41.jpeg"
        }]
    }

    ajouterPanier(pizza, $localStorage) {

        let pizzas = $localStorage.jsonPanier['pizza'];
        let exist = pizzas.find(p => p.id === pizza.id);

        if (exist !== undefined) {
            exist.quantité += 1;
        } else {
            pizza.quantité = 1;
            pizzas.push(pizza);
        }

    }

    afficherModale(pizza) {
        this.currentPizza = pizza;
    }
}