const api = 'http://localhost:3000/login';

export class LoginService {
   constructor($http, $timeout, $q) {
       this.$http = $http;
       this.$timeout = $timeout;
       this.$q = $q;
   }

   loginControl(email, mdp){
       return this.$http.post(api,[email,mdp])
       .then(response => (response.data));
   }

}