export default class BoissonController{

    constructor(BoissonService, PanierService){
            this.BoissonService = BoissonService;
            this.PanierService = PanierService;
        }

       $onInit(){

         this.initBoisson();
         this.getCateg();
       }

       initBoisson(){
            this.BoissonService.getBoissons()
           .then(boissons => {
               this.boissons = boissons;
           })
           
       }
       

     afficherModale(boisson) {
        this.currentBoisson = boisson;
    }

     ajouterPanier(boisson) {
         this.PanierService.ajouterPanier(boisson);
     }

     sort(predicat){
        if(predicat !="Tous"){
        this.boissons =   this.BoissonService.getBoissons()
           .then(boissons => {
               this.boissons = boissons
             .filter((boisson)=> boisson.categorie == predicat);
           })
         }else{
         this.initBoisson();
         }
  
      
       
         
     }

     getCateg(){
          this.BoissonService.getBoissons()
           .then(boissons =>{
             let categObj = _.countBy(boissons, 'categorie');
             let categObjArr = []
             Object.getOwnPropertyNames(categObj).forEach(function(val, idx, array) {
             categObjArr.push({ nom :val,
             nb : categObj[val]})   
             });
             categObjArr.reduce((acc, obj)=>this.nbMax = (acc += obj.nb),0);
             categObjArr.push({nom : "Tous", nb : this.nbMax});
             this.categs = categObjArr;
           } )
     }

}
