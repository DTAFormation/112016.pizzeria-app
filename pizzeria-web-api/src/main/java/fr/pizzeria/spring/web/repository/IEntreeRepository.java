package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Entree;

public interface IEntreeRepository extends JpaRepository<Entree, Integer> {

}
