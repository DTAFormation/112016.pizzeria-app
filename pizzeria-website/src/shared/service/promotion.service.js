const api = 'http://localhost:3000/promotions'

export class PromotionService {

    constructor($http) {
        this.$http = $http;
        this.promotions = this.$http.get(api)
            .then(response =>
                response.data
            );
    }

    getPromotions() {
        return this.promotions;
    }

    getPromotionsById(id) {
        return this.promotions.then(promotions => _.find(promotions, p => p.id === id));
    }

}