package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private String adresse1;
	private String adresse2;
	private String adresse3;
	private Integer codePostal;
	private String ville;

	public Adresse() {

	}

	public Adresse(Integer numero, String adresse1, String adresse2, String adresse3, Integer codePostal,
			String ville) {
		super();
		this.numero = numero;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.adresse3 = adresse3;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getAdresse3() {
		return adresse3;
	}

	public void setAdresse3(String adresse3) {
		this.adresse3 = adresse3;
	}

	public Integer getcodePostal() {
		return codePostal;
	}

	public void setcodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
