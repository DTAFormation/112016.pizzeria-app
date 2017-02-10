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
<<<<<<< HEAD
        localStorage.removeItem("userAuth")
        localStorage.removeItem("userToken")
        this.userAuth = {}
=======
        localStorage.removeItem("userAuth");
        this.userAuth = {};
        if(this.$location.path().includes('/moncompte/')){
            this.$location.path('/')
        }
>>>>>>> origin/client
    }
    
}

export const Navbar = {

    template: require('./navbar.html'),
    controller: NavbarController
}