export default class DessertController{

    constructor(DessertService, PanierService){
        this.DessertService = DessertService;
        this.PanierService = PanierService;
    }

    $onInit(){
         this.initDessert();
         this.getCateg();
    }

    initDessert(){
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

    getCateg(){
        this.DessertService.getDesserts()
        .then(desserts =>{
            let categObj = _.countBy(desserts, 'categorie');
            let categObjArr = []
            Object.getOwnPropertyNames(categObj).forEach(function(val, idx, array) {
                categObjArr.push({ 
                    nom : val, nb : categObj[val]
                })   
            });
            categObjArr.reduce((acc, obj)=>this.nbMax = (acc += obj.nb),0);
            categObjArr.push({nom : "Tous", nb : this.nbMax});
            this.categs = categObjArr;
        })
    }

    sort(predicat){
        if(predicat !="Tous"){
        this.desserts = this.DessertService.getDesserts()
           .then(desserts => {
               this.desserts = desserts
                 .filter((dessert)=> dessert.categorie == predicat);
           })
        }
        else{
            this.initDessert();
        }      
    }
}