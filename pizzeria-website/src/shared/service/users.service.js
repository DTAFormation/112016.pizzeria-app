const api = 'http://localhost:3000/users';

export class UserService {
    constructor($http, $timeout, $q) {
        this.$http = $http;
        this.$timeout = $timeout;
        this.$q = $q;
    }

    getUser(id) {
       /* return this.$http.get(`${ api }/${ id }`)
            .then(response => response.data)*/ 
            const user = {
                id: 1,
                email: "asdrubal.livio@gmail.com",
                nom: "asdrubal",
                prenom: "livio",
                adresse: "cadet rue du"
            }
            return this.$q.resolve(user);
    }

}