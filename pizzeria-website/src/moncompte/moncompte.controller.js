export default class MonCompteController {

    constructor(UserService, $routeParams, $location) {

        this.UserService = UserService;
        this.id = $routeParams.id;
        this.$location = $location;

        this.UserService.getUser(this.id)
            .then(user => this.user = user[0]);

    }

    $onInit() {

        this.disable = true;

    }

    updateInfo() {

        this.disable = false;

    }

    saveUser(form, user) {
        if (form.$invalid) return;
        this.UserService.saveUser(user)
            .then(() => this.$location.path('/moncompte/' + user.id));

        this.disable = true;
    }

    annulerUpdate() {

        this.disable = true;
        this.UserService.getUser(this.id)
            .then(user => this.user = user);

    }
}