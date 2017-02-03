export class UtilService{
    constructor(){}

    getPrix(prix){
        return (prix+"€").replace('.',',');
    }
}