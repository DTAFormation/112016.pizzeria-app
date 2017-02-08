const api = 'http://localhost:3000/client';

export class UserService {
    constructor($http, $timeout) {
        this.$http = $http
        this.$timeout = $timeout
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
                console.log(response.data)
                if(!response.data) {
                    return null
                } else {
                    let userAuthConcat = {
                        id : response.data.user_id,
                        nom : response.data.user_nom,
                        prenom : response.data.user_prenom
                    }
                    console.log(userAuthConcat)
                    localStorage.userAuth = angular.toJson(userAuthConcat)
                    localStorage.userToken = response.data.user_token
                    return userAuthConcat
                }
            })
    }
    
    logoutUser() {
        localStorage.removeItem("userAuth")
        localStorage.removeItem("userToken")
    }    
}