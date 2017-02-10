package fr.pizzeria.spring.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.model.Menu;
import fr.pizzeria.spring.web.repository.IMenuRepository;

@RestController
@RequestMapping("/menus")
public class MenuResource {

	@Autowired
	private IMenuRepository menuDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Menu> findAll() {
		return menuDao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutMenu(@RequestBody Menu menu) {
		menuDao.save(menu);
	}
}
