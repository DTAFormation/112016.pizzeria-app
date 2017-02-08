class NavbarController {
    constructor($rootScope, $location) {
        this.$rootScope = $rootScope;
        this.$rootScope.$on("userAuth", (event, user) => {
            this.userAuth = user
        })
        this.$location = $location;
    }

    $onInit() {
        if(localStorage.getItem("userAuth")) {
            this.userAuth = angular.fromJson(localStorage.getItem("userAuth"));
        }
    }

    setUserAuth(user) {
        this.userAuth = user;
    }

    logoutUser() {
        localStorage.removeItem("userAuth");
        this.userAuth = {};
        this.$location.path('/')
    }
    
}

export const Navbar = {

    template: require('./navbar.html'),
    controller: NavbarController
}