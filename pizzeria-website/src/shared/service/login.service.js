const api = 'http://localhost:3000/login';

export class LoginService {
   constructor($http) {
       this.$http = $http;

   }

   loginControl(email, mdp){
       return this.$http.post(api,[email,mdp])
       .then(response => {
           console.log('service login retour ',response.data)
      return response.data});
   }

}