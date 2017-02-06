export class MenuController{

    constructor(MenuService, PanierService){
            this.MenuService = MenuService;
            this.PanierService = PanierService;
        }

       $onInit(){

         this.initMenu();
       }

       initMenu(){
            this.MenuService.getMenus()
           .then(menus => {
               this.menus = menus;
           })
           
       }
       

     afficherModale(menu) {
        this.currentMenu = menu;
    }

    afficherMenu(menu){
        this.currentMenu = menu;
    }

    ajouterProduit(produit){
        this.MenuService.ajouterElement(produit);
    }

     ajouterPanier(menu) {
         this.PanierService.ajouterElement(menu);
     }
}