 export default class InscriptionController{

    constructor(UserService, $location){
        this.UserService = UserService;
        this.$location = $location;

        
    }

$onChanges(changes){
    if(changes.user){
        this.user = angular.copy(changes.user.currentValue);
    }
}

    saveUser(){

        this.UserService.saveUser(this.user);
        this.$location.path('/');

    }

}



