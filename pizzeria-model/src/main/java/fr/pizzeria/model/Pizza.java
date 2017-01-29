package fr.pizzeria.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code_pizza;
	private String nom;
	private String urlImage;
	private BigDecimal prix;
	private Integer note;
	private Integer nbre_note;
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;

	public Pizza() {
	}

	public Pizza(String code_pizza, String nom, String urlImage, BigDecimal prix, CategoriePizza categorie) {
		super();
		this.code_pizza = code_pizza;
		this.nom = nom;
		this.urlImage = urlImage;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode_pizza() {
		return code_pizza;
	}

	public void setCode_pizza(String code_pizza) {
		this.code_pizza = code_pizza;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Integer getNbre_note() {
		return nbre_note;
	}

	public void setNbre_note(Integer nbre_note) {
		this.nbre_note = nbre_note;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) obj;
		return new EqualsBuilder().append(code_pizza, rhs.code_pizza).isEquals();
	}

}
