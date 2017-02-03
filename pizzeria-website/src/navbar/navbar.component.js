class NavbarController {
    constructor($scope) {
        this.userAuth = {}
        this.$scope = $scope
        this.$scope.$on("userAuth", () => {
            console.log("connecter")
        })
    }

    $onInit() {
        if(localStorage.getItem("userAuth")) {
            this.userAuth = angular.fromJson(localStorage.getItem("userAuth"))
        }
    }

    logoutUser() {
        localStorage.removeItem("userAuth")
        this.userAuth = {}
    }
}

export const Navbar = {

    template: require('./navbar.html'),
    controller: NavbarController
}