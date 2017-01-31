export default class PanierController {

    constructor (PanierService) {

        this.PanierService = PanierService;
    }

    $onInit() {
        this.panier = this.PanierService.getPanier();
    }

}