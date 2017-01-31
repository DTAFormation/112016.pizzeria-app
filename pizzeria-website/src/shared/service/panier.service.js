import _ from 'lodash';

export class PanierService {
    constructor($localStorage) {

        this.$localStorage = $localStorage;

    }

    initPanier() {

        this.$localStorage.jsonPanier = this.$localStorage.jsonPanier || [];

        return this.$localStorage.jsonPanier;
    }

    ajouterElement(element) {

        if (this.$localStorage.jsonPanier === undefined)
            this.initPanier();

        let panier = this.$localStorage.jsonPanier;
        let exist = _.find(panier, e => (e.id === element.id && e.type === element.type));

        if (exist !== undefined) {
            ++exist.quantite;
        } else {
            let ajout = {};

            ajout.type = element.type;
            ajout.id = element.id;
            ajout.quantite = 1;
            panier.push(ajout);
        }

    }

    resetPanier() {

        delete this.$localStorage.jsonPanier;

    }

    getPanier() {

        return this.$localStorage.jsonPanier || this.initPanier();
    }
}
