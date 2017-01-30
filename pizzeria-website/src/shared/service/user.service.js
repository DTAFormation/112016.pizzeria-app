const api = 'http://localhost:3000/client';

export class UserService {
   constructor($http, $timeout, $q) {
       this.$http = $http;
       this.$timeout = $timeout;
       this.$q = $q;
   }

  getUser(id) {
       return this.$http.get( ` ${ api }/${ id }`)
            .then(response => response.data)
    }

   saveUser(user){
       return this.$http.post(api,user)
       .then(response => response.data);
   }

}