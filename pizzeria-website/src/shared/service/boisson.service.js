const api ='http://localhost:3000/boissons'

export class BoissonService{
    constructor( $http) {
        this.$http = $http;

    }

    getBoissons(){
        return this.$http.get(api)
        .then((response)=> response.data);
    }

}