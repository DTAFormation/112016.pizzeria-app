import InscriptionController from './inscription.controller'

export const Inscription ={
    
    bindings : {
        onSubmit:'&'
    },

    template : require('./inscription.html'),
    controller : InscriptionController
}