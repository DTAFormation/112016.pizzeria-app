export default class HomeController {
    constructor(PizzaService) {

        this.PizzaService = PizzaService;
    }

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

    /** 
     ** Use PizzeriaService.displayPanier() from PizzaService to display the data in the console
     **/
    ajouterPizzaPanier(pizza) {

        this.PizzaService.ajouterPanier(pizza);
    }

    afficherModale(pizza) {
        this.currentPizza = pizza;
    }
}