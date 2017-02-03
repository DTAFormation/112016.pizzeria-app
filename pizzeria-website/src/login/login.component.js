class LoginController {
    constructor(UserService, $location, $scope){
        this.UserService = UserService;
        this.$location = $location;
        this.$scope = $scope
    }

    $onInit() {
        this.message = '';
    }

    authentification(form, user){
        console.log("Email : " + user.email)
        console.log("PassWord : " + user.motDePasse)
        if(form.$invalid) return;
        this.UserService.connectUser(user)
            .then(user=> {
                if(!user) {
                    this.message = "Email ou Mot de passe incorrect"
                } else {
                    this.$scope.$emit("userAuth", user)
                    this.$location.path('/')
                }
            })
    }
}

export const Login = {
    template: require('./login.html'),
    controller: LoginController
}