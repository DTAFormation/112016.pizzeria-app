package fr.pizzeria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commande_menu")
public class CommandeMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToMany
	@JoinTable(name = "menu_entree", joinColumns = @JoinColumn(name = "commande_menu_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "entree_id", referencedColumnName = "id"))
	private List<Entree> entrees;

	@ManyToMany
	@JoinTable(name = "menu_pizza", joinColumns = @JoinColumn(name = "commande_menu_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizzas;
	
	@ManyToMany
	@JoinTable(name = "menu_boisson", joinColumns = @JoinColumn(name = "commande_menu_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "boisson_id", referencedColumnName = "id"))
	private List<Boisson> boissons;
	
	@ManyToMany
	@JoinTable(name = "menu_dessert", joinColumns = @JoinColumn(name = "commande_menu_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "dessert_id", referencedColumnName = "id"))
	private List<Dessert> desserts;
	
	@ManyToOne
    @JoinColumn(name = "commande_id")
	private Commande commande;
	
	@ManyToOne
    @JoinColumn(name = "menu_id")
	private Menu menu;
	
	public CommandeMenu() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(List<Entree> entrees) {
		this.entrees = entrees;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public List<Boisson> getBoissons() {
		return boissons;
	}

	public void setBoissons(List<Boisson> boissons) {
		this.boissons = boissons;
	}

	public List<Dessert> getDesserts() {
		return desserts;
	}

	public void setDesserts(List<Dessert> desserts) {
		this.desserts = desserts;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	
}
