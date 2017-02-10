package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Menu;

public interface IMenuRepository extends JpaRepository<Menu, Integer> {

}
