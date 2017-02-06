import css from './menu-modal-choix.css';

class ModalMenuChoixController {
    constructor(UtilService) {
        this.UtilService = UtilService;
        this.entrees = [];
        this.pizzas = [];
        this.desserts = [];
        this.boissons = [];
    }
}

export const ModalMenuChoix = {
    bindings: {
        menu: '<'
    },
    template: require('./menu-modal-choix.html'),
    controller: ModalMenuChoixController
}