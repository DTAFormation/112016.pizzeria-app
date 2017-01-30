export default class MonCompteController {

    constructor(UserService,$routeParams){

        this.UserService = UserService;
        this.id = $routeParams.id;

        this.UserService.getUser(this.id)
            .then(user => this.user = user);

    }

    $onInit(){
        
        this.disable = true;

    }

    updateInfo(){

        this.disable = false;

    }


}