package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.CommandeMenu;

public interface ICommandeMenuRepository extends JpaRepository<CommandeMenu, Integer> {

}
