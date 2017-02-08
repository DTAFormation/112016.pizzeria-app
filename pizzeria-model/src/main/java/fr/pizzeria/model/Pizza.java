package fr.pizzeria.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pizza")

public class Pizza {

	/*
	 * CREATE TABLE pizza ( id int PRIMARY KEY, code_pizza varchar(15) NOT NULL,
	 * nom varchar(5000) NOT NULL, url varchar(5000) NOT NULL, prix decimal NOT
	 * NULL, note int NOT NULL, categorie varchar(5000) NOT NULL );
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "code", length = 3, nullable = false, unique = true)
	private String code;
	@Column(name = "nom", length = 5000, nullable = false)
	private String nom;
	@Column(name = "prix", nullable = false)
	private BigDecimal prix;
	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", nullable = false)
	private CategoriePizza categorie;
	@Column(name = "url", length = 5000)
	private String urlImage;
	@Column(name = "note", nullable = true)
	private Integer note;
	@Column(name = "nb_votant", nullable = true)
	private Integer nbVotant;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pizza_ingredient", joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
	private List<Ingredient> ingredients;

	public Pizza() {

	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", code=" + code + ", nom=" + nom + ", prix=" + prix + ", categorie " + categorie
				+ ", urlImage " + urlImage + "]\n";
	}

	public Pizza(String code, String nom, BigDecimal prix, CategoriePizza cat, String url) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = cat;
		this.urlImage = url;
	}

	public Pizza(String code, String nom, BigDecimal prix, CategoriePizza cat, String url, Date date) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = cat;
		this.urlImage = url;
		this.note = 0;
		this.date = date;
	}

	public Pizza(String code, String nom, String url, BigDecimal prix, int note, int nbVotant,
			CategoriePizza categoriePizza, Date date) {
		this.code = code;
		this.nom = nom;
		this.urlImage = url;
		this.prix = prix;
		this.note = note;
		this.nbVotant = nbVotant;
		this.categorie = categoriePizza;
		this.date = date;
	}

	public Pizza(String code, String nom, BigDecimal prix, CategoriePizza cat, String url,
			List<Ingredient> ingredients) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = cat;
		this.urlImage = url;
		this.ingredients = ingredients;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNbVotant() {
		return nbVotant;
	}

	public void setNbVotant(Integer nbVotant) {
		this.nbVotant = nbVotant;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}