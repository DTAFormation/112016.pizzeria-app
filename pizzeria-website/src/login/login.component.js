class LoginController {
    constructor(UserService, $location, $rootScope){
        this.UserService = UserService;
        this.$location = $location;
        this.$rootScope = $rootScope
    }

    $onInit() {
        this.message = '';
        this.user = JSON.parse(localStorage.getItem('userAuth'))
        if(this.user) {
            this.$location.path('/moncompte')
        }
    }

    authentification(form, user){
        if(form.$invalid) return;
        this.UserService.connectUser(user)
            .then(user=> {
                if(!user) {
                    this.message = "Email ou Mot de passe incorrect"
                } else {
                    this.$rootScope.$emit("userAuth", user)
                    this.$location.path('/moncompte')
                }
            })
    }
}

export const Login = {
    template: require('./login.html'),
    controller: LoginController
}