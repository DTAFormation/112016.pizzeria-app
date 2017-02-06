class RatingController {

    constructor() {}
    $onInit(){}

    save(form,rating){
        if(form.$invalid) return;
        this.modifierNote({
            $event: rating
        });
    }

}

export const Rating = {
    bindings:{
        rating:'<',
        modifierNote: '&'
    },
    template: require('./rating.component.html'),
    controller: RatingController

};