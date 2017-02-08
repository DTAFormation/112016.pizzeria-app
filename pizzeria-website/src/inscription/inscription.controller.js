export default class InscriptionController {
    constructor(UserService, $location, $rootScope) {
        this.UserService = UserService;
        this.$location = $location;
        this.$rootScope = $rootScope;
    }

    saveUser(form, user) {
        console.log(form.motDePasse)
        if (form.$invalid) return;
        this.user = angular.copy(user);
        this.UserService.saveUser(this.user);
        this.authentification(this.user);
    }
    authentification(userc) {
        this.UserService.connectUser(userc)
            .then(user => {
                if (!user) {
                    console.log('probleme', userc)
                    this.UserService.connectUser(userc)
                        .then(user => {
                            if (!user) { console.log('probleme', userc) } else {
                                this.$rootScope.$emit("userAuth", user);
                                this.$location.path('/moncompte/' + user.id);
                                console.log(user);
                            }
                        })
                } else {
                    this.$rootScope.$emit("userAuth", user);
                    this.$location.path('/moncompte/' + user.id);
                    console.log(user);
                }
            })
    }
}



