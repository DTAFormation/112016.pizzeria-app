 export default class InscriptionController{
    constructor(UserService, $location){
        this.UserService = UserService;
        this.$location = $location;
    }

    saveUser(form, user){
        console.log(form.motDePasse)
        if (form.$invalid) return;
        this.UserService.saveUser(user)
            .then(() => this.$location.path('/'));
    }

}



