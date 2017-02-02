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
                console.log(client)
               if(Object.keys(client).length>0){
                   this.error = false;
                   this.currentClient = {id: client.id, nom : client.nom};  
                   console.log('currentClient ', this.currentClient)
                   this.Connected()
                   const expireDate = new Date('01/01/2029')
                   this.$cookies.put('user_session', this.currentClient, {'expires': expireDate})
                    this.$location.path('/'); 

               }else{
                   console.log('error')
                   this.error =true;
                this.$location.path('/login'); 
            }
        })

    }

    Connected(){
        this.connected = true;
    }

    disConnected(){
        this.connected = false;
    }
}
