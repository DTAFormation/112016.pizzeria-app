package fr.pizzeria.spring.web.repository;


import fr.pizzeria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPizzaRepository extends JpaRepository<Pizza,Integer> {

    Pizza findByCode(String code);
}
