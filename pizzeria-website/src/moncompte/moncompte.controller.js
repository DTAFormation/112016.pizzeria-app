import lodash from 'lodash';

export default class MonCompteController {

    constructor(UserService, $routeParams, $location, CommandeService) {

        this.UserService = UserService;
        this.CommandeService = CommandeService;
        this.id = $routeParams.id;
        this.$location = $location;

        this.UserService.getUser(this.id)
            .then(user => this.user = user[0]);

    }
    $onInit() {

        this.disable = true;
        this.CommandeService.getCommandeByUserId(this.id)
            .then(commandes =>{
                lodash(commandes.map(commande => {
                   commande.date = Date(commande.date)
                   this.commandes.push(commande)
                }))
                .flatten()
            })

    }

    updateInfo() {

        this.disable = false;

    }

    saveUser(form, user) {
        if (form.$invalid) return;
        this.UserService.saveUser(user)
            .then(() => this.$location.path('/moncompte/' + user.id));

        this.disable = true;
    }

    annulerUpdate() {

       
        this.UserService.getUser(this.id)
            .then(user => this.user = user[0]);

        this.disable = true;
    }
 
    
}