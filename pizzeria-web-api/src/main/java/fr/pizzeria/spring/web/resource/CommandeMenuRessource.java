package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.CommandeMenu;
import fr.pizzeria.spring.web.repository.ICommandeMenuRepository;

@RestController
public class CommandeMenuRessource {

	@Autowired
	private ICommandeMenuRepository menuDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<CommandeMenu> findAll() {
		return menuDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutMenu(@RequestBody CommandeMenu menu) {
		menuDao.save(menu);
	}
}
