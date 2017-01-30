class LoginController {
    constructor(LoginService){
        this.LoginService = LoginService
    }

    login(){
        this.LoginService.loginControl(this.email,this.mdp)
            .then(response => {
                if(!response){
                    this.loguer = true
                } 
                else {
                     this.loguer = false
                }
            })

    }
}

export const Login = {
    template: require('./login.html'),
    controller: LoginController
}