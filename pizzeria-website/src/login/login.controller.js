export default class LoginController {
    constructor(LoginService, $location, $cookies){
        this.LoginService = LoginService
        this.$location = $location;
        this.$cookies = $cookies;
    }


    login(form, email, mdp){
          if (form.$invalid) return;
        this.LoginService.loginControl(email, mdp)
            .then(client => {
               if(Object.keys(client).length>0){
                   this.error = false;
                   this.currentClient = client;  
                   console.log('currentClient ', this.currentClient)
                   this.isConnected()
                   const expireDate = new Date('01/01/2029')
                   this.$cookies.put('user_session', this.currentClient.nom, {'expires': expireDate})
                    this.$location.path('/'); 

               }else{
                   console.log('error')
                   this.error =true;
                this.$location.path('/login'); 
            }
        })

    }

    isConnected(){
        this.connected = true;
    }

    disConnected(){
        this.connected = false;
    }
}
