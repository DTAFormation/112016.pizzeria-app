package fr.pizzeria.spring.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Integer> {

	List<Commande> findByClientId(Integer id);

	List<Commande> findById(Integer id);

	Commande findByIdAndClientId(Integer id, Integer clientId);

}
