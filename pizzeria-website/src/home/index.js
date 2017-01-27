import angular from 'angular';

import { Home } from './home.component'
import { Product } from'../product/product.component'

//import HomeController from './home.controller';

export default angular.module('PizzeriaHome', [])
  
.component('home', Home)
    
.component('product', Product)

.name;
