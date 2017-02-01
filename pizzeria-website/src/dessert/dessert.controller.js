export default class DessertController{

    constructor(DessertService, PanierService){
            this.DessertService = DessertService;
            this.PanierService = PanierService;
        }

       $onInit(){
            this.DessertService.getDesserts()
           .then(desserts => {
               this.desserts = desserts;
           })
       }

     afficherModale(dessert) {
        this.currentDessert = dessert;
    }

     ajouterPanier(dessert) {
         this.PanierService.ajouterPanier(dessert);
     }


}