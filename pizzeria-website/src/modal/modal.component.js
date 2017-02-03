
class ModalController {
    constructor(UtilService) {
        this.UtilService = UtilService;
    }
}

export const ModalPizza = {
    bindings: {
        pizza: '<'
    },
    template: require('./modal.component.html'),
    controller: ModalController
}