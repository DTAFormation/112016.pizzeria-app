export default class EntreeController {

    constructor(EntreeService, PanierService) {
        this.EntreeService = EntreeService;
        this.PanierService = PanierService;
    }

    $onInit() {
        this.initEntree();
        this.getCateg();
    }

    initEntree() {
        this.EntreeService.getEntrees()
            .then(entrees => {
                this.entrees = entrees;
            })
    }


    afficherModale(entree) {
        this.currentEntree = entree;
    }

    ajouterPanier(entree) {
        this.PanierService.ajouterElement(entree);
    }

    sort(predicat) {
        if (predicat != "Tous") {
            this.entrees = this.EntreeService.getEntrees()
                .then(entrees => {
                    this.entrees = entrees.filter((entree) => entree.categorie == predicat);
                })
        } else {
            this.initEntree();
        }
    }

    getCateg() {
        this.EntreeService.getEntrees()
            .then(entrees => {
                let categObj = _.countBy(entrees, 'categorie');
                let categObjArr = [];
                Object.getOwnPropertyNames(categObj).forEach(function (val, idx, array) {
                    categObjArr.push({
                        nom: val,
                        nb: categObj[val]
                    })
                });
                categObjArr.reduce((acc, obj) => this.nbMax = (acc += obj.nb), 0);
                categObjArr.push({ nom: "Tous", nb: this.nbMax });
                this.categs = categObjArr;
            });
    }

}
