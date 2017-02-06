class RatingController {

    constructor() {}
    $onInit(){}

    save(form,rating){
        if(form.$invalid) return;
        this.rating=rating;
    }

}

export const Rating = {
    
    template: require('./rating.component.html'),
    controller: RatingController

};