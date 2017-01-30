 export default class InscriptionController{
    constructor(UserService){
        this.UserService = UserService;
        this.UserService.getUser
        
    }

$onChanges(changes){
    if(changes.user){
        this.user = angular.copy(changes.user.currentValue);
    }
}

    saveUser(){
        console.log(this.user)
        this.UserService.saveUser(this.user);
    }

}



