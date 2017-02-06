
class ModalMenuController {
    constructor(UtilService) {
        this.UtilService = UtilService;
    }
}

export const ModalMenu = {
    bindings: {
        menu: '<'
    },
    template: require('./menu-modal.html'),
    controller: ModalMenuController
}