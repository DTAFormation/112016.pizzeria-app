
import css from './commande-envoye.component.css';

export default class CommandeEnvoyeController {
    constructor(CommandeService, $routeParams) {

        this.CommandeService = CommandeService;
        this.id = $routeParams.id;

    }

    $onInit(){

        this.CommandeService.getCommandeById(this.id)
            .then(commande => {
                this.statut = commande[0].statut;
                this.commande =  commande[0].pizzas
            })

    }
}