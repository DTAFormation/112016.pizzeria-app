class LoginController {
    constructor(){}

    test(){
        console.log('test');
    }
}

export const Login = {
    template: require('./login.html'),
    controller: LoginController
}