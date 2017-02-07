package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Promotion;
import fr.pizzeria.spring.web.repository.IPromotionRepository;

@RestController
@RequestMapping("/promotions")
public class PromotionRessource {
	
	@Autowired
	private IPromotionRepository promotionDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> findAll() {
		return promotionDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutPromotion(@RequestBody Promotion promotion) {
		promotionDao.save(promotion);
	}

}
