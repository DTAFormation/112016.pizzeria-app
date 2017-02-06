package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Personne {

	// @OneToMany(mappedBy = "resident")
	// private List<Adresse> adresse;

	@Column(name = "adresse", nullable = true)
	private String adresse;

	public Client() {

	}

	public Client(Integer id, String nom, String prenom, String email, String motDePasse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Client(String nom, String prenom, String email, String motDePasse,
			String adresse /* Adresse adresse */) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
		// this.adresse.add(adresse);

	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse "
				+ motDePasse + ", adresse " + adresse + "]\n";
	}

	// public List<Adresse> getAdresse() {
	// return this.adresse;
	// }
	//
	// public void setAdresse(Adresse adresse) {
	// this.adresse.add(adresse);
	// if (adresse.getResident() != this) {
	// adresse.setResident(this);
	// }
	// }
}
