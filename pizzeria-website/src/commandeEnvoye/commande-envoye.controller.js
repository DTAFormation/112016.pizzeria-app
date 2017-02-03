
import css from './commande-envoye.component.css';

export default class CommandeEnvoyeController {
    constructor(CommandeService, $routeParams, UtilService, $scope) {

        this.CommandeService = CommandeService;
        this.id = $routeParams.id;
        this.UtilService = UtilService;
        this.$scope = $scope;

    }

    $onInit(){

        this.CommandeService.getCommandeById(this.id)
            .then(commande => {
                this.statut = commande[0].statut;
                this.pizzas =  commande[0].pizzas
                this.boissons = commande[0].boissons;
                this.desserts = commande[0].desserts;
                this.entrees = commande[0].entrees;
                setInterval(this.verifyCommandeState(), 1000);
            });

    }

    verifyCommandeState(){
            this.CommandeService.getCommandeById(this.id)
            .then(commande => {
                if(this.statut != commande[0].statut){
                    this.statut = commande[0].statut;
                    this.$scope.apply();
                }
            });
    }

    havePizza(){
        return this.pizzas!=undefined && this.pizzas.length > 0;
    }

    haveBoisson(){
        return this.pizzas!=undefined && this.boissons.length > 0;
    }

    haveDessert(){
        return this.pizzas!=undefined && this.desserts.length > 0;
    }

    haveEntree(){
        return this.pizzas!=undefined && this.entrees.length > 0;
    }
}