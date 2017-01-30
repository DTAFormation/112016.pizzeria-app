 export default class InscriptionController{
    constructor(UserService){
        this.UserService = UserService;
        
    }

$onChanges(changes){
    if(changes.user){
        this.user = angular.copy(changes.user.currentValue);
    }
}

    saveUser(){
        this.UserService.saveUser(user);
    }

}



