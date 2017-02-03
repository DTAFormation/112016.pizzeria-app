package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Entree;
import fr.pizzeria.spring.web.repository.IEntreeRepository;

@RestController
@RequestMapping("/entrees")
public class EntreeResource {

	@Autowired
	private IEntreeRepository entreeDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Entree> findAll() {
		return entreeDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutEntree(@RequestBody Entree entree) {
		entreeDao.save(entree);
	}
}
