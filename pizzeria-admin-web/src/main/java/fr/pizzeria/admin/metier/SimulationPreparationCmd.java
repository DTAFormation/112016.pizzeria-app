package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.inject.Inject;

import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Statut;

@Stateless
public class SimulationPreparationCmd {

	@Resource
	private TimerService timerService;

	@Inject
	private CommandeService commandeService;
	private Logger LOG = Logger.getLogger(SimulationPreparationCmd.class.getName());

	@Schedule(second = "*/5", minute = "*", hour = "*")

	public void executerTraitement(Timer timer) {
		LOG.log(Level.INFO, "Changement d'état des commande.");
		changeStatus(getListCommandeAtraiter());
	}

	/**
	 * @see Permet de lister toutes les pizzas qui ne sont pas termiées.
	 *      (Différent du status Statut.LIVRER)
	 */

	private List<Commande> getListCommandeAtraiter() {
		LOG.log(Level.INFO, "Chargement de la liste des commandes en cours de traitement");
		return commandeService.findAll();
	}

	// incrementer les commandes d'un 'état a l'autre
	private void changeStatus(List<Commande> listeCommande) {

		LOG.log(Level.INFO, "Traitement de la liste des commande");
		if (listeCommande.size() != 0) {
			listeCommande.forEach(p -> {
				LOG.log(Level.INFO, "Commande : " + p.getId() + "statut : " + p.getStatut());
				switch (p.getStatut()) {
				case EN_PREPARATION:
					p.setStatut(Statut.EN_CUISSON);
					break;
				case EN_CUISSON:
					p.setStatut(Statut.PRET);
					break;
				case PRET:
					p.setStatut(Statut.EN_LIVRAISON);
					break;
				case EN_LIVRAISON:
					p.setStatut(Statut.LIVRER);
					break;
				case LIVRER:
					break;
				default:
					p.setStatut(Statut.EN_PREPARATION);
					break;
				}
				commandeService.changeStatut(p.getId(), p.getStatut());
				LOG.log(Level.INFO, "Commande : " + p.getId() + "statut : " + p.getStatut());
			});
		} else {
			LOG.log(Level.INFO, "La liste de commande est vide.");
		}
		LOG.log(Level.INFO, "Traitement terminé.");
	}

}
