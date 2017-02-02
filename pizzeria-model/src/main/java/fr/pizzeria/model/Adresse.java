package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adresse")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero", nullable = false)
	private Integer numero;
	@Column(name = "adresse1", length = 5000, nullable = false)
	private String adresse1;
	@Column(name = "adresse2", length = 5000)
	private String adresse2;
	@Column(name = "adresse3", length = 5000)
	private String adresse3;
	@Column(name = "code_postale", length = 5, nullable = false)
	private String codePostal;
	@Column(name = "ville", length = 5000, nullable = false)
	private String ville;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "client_id")
	// private Client resident;

	public Adresse() {

	}

	public Adresse(Integer numero, String adresse1, String adresse2, String adresse3, String codePostal, String ville) {
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

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	// public Client getResident() {
	// return resident;
	// }
	//
	// public void setResident(Client resident) {
	// this.resident = resident;
	// if (!resident.getAdresse().contains(this)) {
	// resident.getAdresse().add(this);
	// }
	// }
}
