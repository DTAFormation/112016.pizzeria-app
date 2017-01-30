import InscriptionController from './inscription.controller'

export const Inscription ={
    
    bindings : {
        user:'<',
        onSubmit:'&'
    },

    template : require('./inscription.html'),
    controller : InscriptionController
}