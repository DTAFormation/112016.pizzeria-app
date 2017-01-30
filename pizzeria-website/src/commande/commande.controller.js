export default class CommandeController{
    constructor($localStorage){
        this.$localStorage = $localStorage;
        console.log("lancement du component commande");
        console.table(this.$localStorage.jsonPanier.pizza);
        console.log(this.$localStorage.jsonPanier.pizza[0].src)
    }
    

}