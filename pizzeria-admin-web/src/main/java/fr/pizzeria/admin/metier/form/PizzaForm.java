package fr.pizzeria.admin.metier.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import fr.pizzeria.admin.exception.PizzaException;
import fr.pizzeria.admin.metier.IngredientService;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Ingredient;
import fr.pizzeria.model.Pizza;

@Named
public class PizzaForm {

	private static final String CHAMP_CODE = "code";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRIX = "prix";
	private static final String CHAMP_CATEGORIE = "categorie";
	private static final String CHAMP_URL = "urlImage";
	private static final String CHAMP_OLD_CODE = "oldCode";
	private static final String CHAMP_INGREDIENDS = "ingredientsPizza[]";
	private String resultat;
	private static Map<String, String> erreurs = new HashMap<>();
	@EJB
	private PizzaService service;
	@EJB
	private IngredientService ingredService;

	private static final Logger LOG = Logger.getLogger(PizzaForm.class.getName());

	/**
	 * Constructeur vide pour injection de dépendances
	 */
	public PizzaForm() {
		// CDI
	}

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Pizza modifierPizzaForm(HttpServletRequest req) {

		erreurs.clear();
		String oldCode = checkOldCode(req);
		Pizza pizza = checkPizza(req);

		try {
			if (erreurs.isEmpty()) {
				service.update(pizza, oldCode);
				resultat = "La pizza a été modifiée";
			} else {
				resultat = "Erreur lors de la modification";
			}
		} catch (PizzaException e) {
			LOG.log(Level.SEVERE, "Erreurs lors de la modification de la pizza", e);
			erreurs.put("Imprévu", "Erreurs lors de la modification de la pizza");
			resultat = "Données invalides";
		}
		return pizza;
	}

	public Pizza ajouterPizzaForm(HttpServletRequest req) {

		erreurs.clear();
		Pizza pizza = checkPizza(req);

		try {
			if (erreurs.isEmpty()) {
				pizza.setDate(new Date());
				service.save(pizza);
				resultat = "La pizza a été ajoutée";
			} else {
				resultat = "Erreur lors de l'ajout de la pizza";
			}
		} catch (PizzaException e) {
			LOG.log(Level.SEVERE, "Erreur lors de l'ajout de pizza", e);
			erreurs.put("Imprevu", "Erreur lors de l'ajout de pizza");
			resultat = "Données invalides";

		}
		return pizza;
	}

	public void deletePizzaForm(HttpServletRequest req) {
		erreurs.clear();
		String code = getValeurChamp(req, CHAMP_CODE);
		if (service.checkCode(code)) {
			service.delete(code);
			resultat = "La pizza a été correctement supprimée";
		} else {
			resultat = "La pizza n'a pas correctement été supprimée";
		}
	}

	private Boolean checkCode(String code) {
		return (code.length() > 3 || code.length() <= 0 || code.isEmpty());
	}

	private String checkNewCode(HttpServletRequest req) {
		String code = getValeurChamp(req, CHAMP_CODE);
		String oldCode = getValeurChamp(req, CHAMP_OLD_CODE);
		if (checkCode(code)) {
			erreurs.put(CHAMP_CODE, "Code invalide");
			return null;
		} else if (service.checkCode(code) && !code.equals(oldCode)) {
			erreurs.put(CHAMP_CODE, "Ce code existe déjà");
			return null;
		} else {
			return code;
		}
	}

	private String checkOldCode(HttpServletRequest req) {
		String code = getValeurChamp(req, CHAMP_OLD_CODE);
		if (checkCode(code)) {
			erreurs.put(CHAMP_CODE, "Code invalide");
			return null;
		} else if (!service.checkCode(code)) {
			erreurs.put(CHAMP_CODE, "Ce code n'existe pas");
			return null;
		} else {
			return code;
		}
	}

	private String checkNom(HttpServletRequest req) {
		String nom = getValeurChamp(req, CHAMP_NOM);
		if (nom.isEmpty()) {
			erreurs.put(CHAMP_NOM, "Nom invalide");
		}
		return nom;
	}

	private BigDecimal checkPrix(HttpServletRequest req) {
		String tempPrix = getValeurChamp(req, CHAMP_PRIX);
		if (tempPrix.isEmpty()) {
			erreurs.put(CHAMP_PRIX, "Veuillez entrer un prix");
			return null;
		} else {
			BigDecimal prix = new BigDecimal(tempPrix);
			if (prix.compareTo(BigDecimal.ZERO) < 0) {
				erreurs.put(CHAMP_PRIX, "Veuillez entrer un prix positif");
			}
			return prix;
		}
	}

	private CategoriePizza checkCategorie(HttpServletRequest req) {
		String tempCategorie = getValeurChamp(req, CHAMP_CATEGORIE);
		if (tempCategorie.isEmpty()) {
			erreurs.put(CHAMP_CATEGORIE, "Catégorie invalide");
			return null;
		}
		CategoriePizza categorie = CategoriePizza.valueOf(tempCategorie);
		if (categorie != null) {
			return categorie;
		} else {
			return null;
		}
	}

	private String checkUrl(HttpServletRequest req) {
		return getValeurChamp(req, CHAMP_URL);
	}

	private Pizza checkPizza(HttpServletRequest req) {
		String code = checkNewCode(req);
		String nom = checkNom(req);
		BigDecimal prix = checkPrix(req);
		CategoriePizza categorie = checkCategorie(req);
		String urlImage = checkUrl(req);
		List<Ingredient> ingredients = checkListIngredient(req);
		if (null != ingredients || ingredients.isEmpty()) {
			return new Pizza(code, nom, prix, categorie, urlImage, ingredients);
		} else {
			return new Pizza(code, nom, prix, categorie, urlImage);
		}

	}

	private List<Ingredient> checkListIngredient(HttpServletRequest req) {
		String[] ingrediendsIdArr = getValeurChampArray(req, CHAMP_INGREDIENDS);
		List<Ingredient> listIngredients = new ArrayList<>();
		if (null != ingrediendsIdArr)
			for (String id : ingrediendsIdArr) {
				Ingredient ingredient = ingredService.retrieveIngredient(Integer.parseInt(id));
				listIngredients.add(ingredient);
			}
		return listIngredients;
	}

	private String getValeurChamp(HttpServletRequest req, String champ) {
		if (champ == null) {
			champ = "";
		}
		String valeur = req.getParameter(champ);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}

	private String[] getValeurChampArray(HttpServletRequest req, String champ) {
		if (champ == null) {
			champ = "";
		}
		LOG.log(Level.INFO, "req : " + req);
		LOG.log(Level.INFO, "champ : " + champ);
		String[] valeurs = req.getParameterValues(champ);
		if (valeurs != null) {
			for (String string : valeurs) {
				LOG.log(Level.INFO, "tab : " + string);
			}
		}

		return valeurs;

	}

}
