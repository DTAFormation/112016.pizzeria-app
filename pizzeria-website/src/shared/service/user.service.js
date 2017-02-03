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
                let user = response.data
                if(!response.data) {
                    console.log("utilisateur non valide")
                    return null
                } else {
                    console.log("utilisateur authentifier : ")
                    let userAuthConcat = {
                        id: user.id,
                        nom: user.nom,
                        prenom: user.prenom
                    }
                    console.table(userAuthConcat)
                    localStorage.userAuth = angular.toJson(userAuthConcat)
                    console.log("utilisateur enregistré dans la session")
                    return userAuthConcat
                }
            })
    }
    
    logoutUser() {
        localStorage.removeItem(userAuth)
    }    
}