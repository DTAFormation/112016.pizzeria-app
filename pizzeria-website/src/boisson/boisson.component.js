class BoissonController{

    constructor(BoissonService){
            this.BoissonService = BoissonService;
        }

       $onInit(){
           this.BoissonService.getBoissons()
           .then(boissons => this.boissons = boissons)
       }
       

     afficherModale(boisson) {
        this.currentBoisson = boisson;
    }

     ajouterPanier(boisson) {
         this.BoissonService.ajouterPanier(boisson);
     }

}

export const Boisson = {
    template:require('./boisson.component.html'),
    controller: BoissonController
}