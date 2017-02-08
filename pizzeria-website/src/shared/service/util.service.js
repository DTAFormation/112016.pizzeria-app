export class UtilService {
    constructor() {}

    getPrix(prix, langage, devise) {
        if (typeof prix !== 'undefined') {
            return prix.toLocaleString(langage, { style: 'currency', currency: devise });
            //return prix + " €";
        }
    }
}