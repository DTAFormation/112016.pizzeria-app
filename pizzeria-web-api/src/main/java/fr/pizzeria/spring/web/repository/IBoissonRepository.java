package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Boisson;

public interface IBoissonRepository extends JpaRepository<Boisson, Integer> {

}
