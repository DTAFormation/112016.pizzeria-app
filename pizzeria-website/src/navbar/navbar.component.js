class NavbarController {
    constructor($rootScope) {
        this.$rootScope = $rootScope
        this.$rootScope.$on("userAuth", (event, user) => {
            this.userAuth = user
        })
    }

    $onInit() {
        if(localStorage.getItem("userAuth")) {
            this.userAuth = angular.fromJson(localStorage.getItem("userAuth"))
        }
    }

    setUserAuth(user) {
        this.userAuth = user
    }

    logoutUser() {
        localStorage.removeItem("userAuth")
        localStorage.removeItem("Token")
        this.userAuth = {}
    }
    
}

export const Navbar = {

    template: require('./navbar.html'),
    controller: NavbarController
}