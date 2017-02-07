const api = 'http://localhost:3000/boissons'

export class BoissonService {
    
    constructor($http) {
        this.$http = $http;
        this.boisson = this.$http.get(api)
            .then((response) => response.data);
    }

    getBoissons() {
        return this.boisson;
    }

    getBoissonsById(id) {
        return this.boisson.then(boisson => _.find(boisson, p => p.id === id));
    }

}