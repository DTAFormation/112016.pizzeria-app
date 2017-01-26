package fr.pizzeria.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String nom;
    private BigDecimal prix;
    @Enumerated(EnumType.STRING)
    private CategoriePizza categorie;
    private String urlImage;

    public Pizza() {
    }

    public Pizza(String code, String nom, BigDecimal prix, CategoriePizza cat) {
        this();
        this.code = code;
        this.nom = nom;
        this.prix = prix;
        this.categorie = cat;
    }

    public Pizza(Integer id, String code, String nom, BigDecimal prix, CategoriePizza categorie, String urlImage) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.urlImage = urlImage;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(code).toHashCode();
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
        return new EqualsBuilder().append(code, rhs.code).isEquals();
    }

}
