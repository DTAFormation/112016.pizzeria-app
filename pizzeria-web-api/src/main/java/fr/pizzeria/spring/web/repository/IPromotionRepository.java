package fr.pizzeria.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.pizzeria.model.Promotion;

public interface IPromotionRepository extends JpaRepository<Promotion, Integer>{
	
	

}
