package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Dessert;

public interface IDessertRepository extends JpaRepository<Dessert, Integer> {

}
