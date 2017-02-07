package fr.pizzeria.admin.metier;

import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.Statut;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class CommandeService {

    @PersistenceContext
    private EntityManager em;

    public List<Commande> findAll() {
        return em.createQuery("select p from Commande p", Commande.class).getResultList();
    }

    public Commande get(Integer id) {

        TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE c.id =:id", Commande.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Commande> getThreeLasts() {

        return em.createQuery("select p from Commande p", Commande.class).setMaxResults(3).getResultList();
    }

    public void save(Commande commande) {

        em.persist(commande);
    }

    public void update(Commande commande, Integer id) {

        Commande oldCommande = get(id);
        oldCommande.setLivreurId(commande.getLivreurId());
        oldCommande.setClientId(commande.getClientId());
        oldCommande.setDate(commande.getDate());
        oldCommande.setStatut(commande.getStatut());
        BigDecimal total = new BigDecimal(0);
        for (Pizza pizza : oldCommande.getPizzas()) {
            total = total.add(pizza.getPrix());
        }
        oldCommande.setTotal(total);
    }

    public void changeStatut(Integer id, Statut statut) {
        Commande commandeToUpdate = get(id);
        commandeToUpdate.setStatut(statut);
    }

    public void delete(Integer id) {
        Commande commande = get(id);
        em.remove(commande);
    }

    public Map<String, String> getListStatuts() {
        Map<String, String> statuts = new HashMap<>();
        Arrays.asList(Statut.values()).forEach(c -> {
            statuts.put(c.name(), c.getLabel());
        });
        return statuts;
    }
}
