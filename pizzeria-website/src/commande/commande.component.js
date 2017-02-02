import CommandeController from './commande.controller'

export const Commande = {
      bindings : {
        user:'<',
        onSubmit:'&'
    },
    template: require('./commande.html'),
    controller : CommandeController
}