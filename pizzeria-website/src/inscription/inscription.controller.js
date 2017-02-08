 export default class InscriptionController{
    constructor(UserService, $location, $rootScope){
        this.UserService = UserService;
        this.$location = $location;
        this.$rootScope = $rootScope;
    }

    saveUser(form, user){
        console.log(form.motDePasse)
        if (form.$invalid) return;
        this.user = angular.copy(user);
        this.UserService.saveUser(this.user);
        this.authentification(this.user);
    }
    authentification(user){
        this.UserService.connectUser(user)
            .then(user=> {
                    this.$rootScope.$emit("userAuth", user)
                    this.$location.path('/moncompte/' + user.id)
                
            })
    }
}



