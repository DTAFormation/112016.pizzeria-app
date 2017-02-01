package fr.pizzeria.spring.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Client;

public interface IClientRepository extends JpaRepository<Client, Integer> {

	List<Client> findById(Integer id);

}
