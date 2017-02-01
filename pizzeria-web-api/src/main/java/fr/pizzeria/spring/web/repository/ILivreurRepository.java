package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Livreur;

public interface ILivreurRepository extends JpaRepository<Livreur, Integer> {

}
