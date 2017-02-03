const api = 'http://localhost:3000/client';

export class UserService {
    constructor($http, $timeout) {
        this.$http = $http;
        this.$timeout = $timeout;
        this.user = {}
    }

    getUser(id) {
        return this.$http.get(`${ api }/${ id }`)
            .then(response => response.data)
    }

    saveUser(user) {
        return this.$http.post(api, user)
            .then(response => response.data);
    }

    connectUser(user) {
       return this.$http.post(`${ api }/signin`, user)
            .then(response => {
                if(!response.data) {
                    return null
                } else {
                    let userAuthConcat = {
                        id: user.id,
                        nom: user.nom,
                        prenom: user.prenom
                    }
                    localStorage.userAuth = angular.toJson(userAuthConcat)
                    return userAuthConcat
                }
            })
    }
    
    logoutUser() {
        localStorage.removeItem(userAuth)
    }    
}