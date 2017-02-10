import lodash from 'lodash';

export default class MonCompteController {

    constructor(UserService, $routeParams, $location, $q, CommandeService) {
        this.UserService = UserService;
        this.CommandeService = CommandeService;
        this.id = $routeParams.id;
        this.$q = $q
        this.$location = $location;

    }

    $onInit() {
        
        this.disable = true;
        this.commandes = [];
        this.user = JSON.parse(localStorage.getItem('userAuth'))
        if(this.user){
            this.UserService.getUser(this.user.id)
                .then(user => {
                    if(user[0]) {
                        this.user = user[0]
                    } else {
                        this.$location.path("/login")
                    }
                })

                
            this.CommandeService.getCommandesByUserId()
                .then(commandes => {
                    lodash(commandes.map(commande => {
                    commande.date = Date(commande.date).toString().replace(/\S+\s(\S+)\s(\d+)\s(\d+)\s.*/,'$2-$1-$3');
                        this.commandes.push(commande)
                    }))
                    .flatten()
                })
        } else {
            this.$location.path('/login')
        }
        

    }

    updateInfo() {

        this.disable = false;
    }

    saveUser(form, user) {
        if (form.$invalid) return;
        this.UserService.saveUser(user)
            .then(() =>  {
                this.UserService.connecterUser(user)
                this.$location.path('/moncompte')
            });

        this.disable = true;
    }

    annulerUpdate() {
        this.UserService.getUser(this.user)
            .then(user => this.user = user[0]);

        this.disable = true;
    }

}