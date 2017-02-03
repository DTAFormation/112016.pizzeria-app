package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Boisson;
import fr.pizzeria.spring.web.repository.IBoissonRepository;

@RestController
@RequestMapping("/boissons")
public class BoissonResource {

	@Autowired
	private IBoissonRepository boissonDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Boisson> findAll() {
		return boissonDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutBoisson(@RequestBody Boisson boisson) {
		boissonDao.save(boisson);
	}
}
