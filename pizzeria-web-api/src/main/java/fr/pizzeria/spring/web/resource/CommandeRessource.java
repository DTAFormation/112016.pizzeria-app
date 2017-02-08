package fr.pizzeria.spring.web.resource;

import fr.pizzeria.model.*;
import fr.pizzeria.spring.web.repository.IClientRepository;
import fr.pizzeria.spring.web.repository.ICommandeRepository;
import fr.pizzeria.spring.web.repository.ILivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeRessource {

	private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

	@Autowired
	ICommandeRepository commandeDao;

	@Autowired
	private PizzaResource pizzaResource;

	@Autowired
	IClientRepository clientDao;

	@Autowired
	ILivreurRepository liveurDao;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public List<Commande> getCommandes(@PathVariable Integer id) {
		return commandeDao.findByClientId_Id(id);
	}

	@RequestMapping(path = "/commande/{id}", method = RequestMethod.GET)
	public List<Commande> getClient(@PathVariable Integer id) {
		return commandeDao.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void ajoutCommande(@RequestBody ArrayList<CommandeClient> commandeClient) throws Exception {
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		for (CommandeClient commandeproduit : commandeClient) {

			if (commandeproduit.getType().equals("pizza")) {
				pizzas.add(pizzaResource.listAllPizzas().stream()
						.filter(p -> p.getId().equals(commandeproduit.getIdProduit())).findFirst().get());

			}
		}
		Client client = clientDao.findAll().stream().filter(p -> p.getId().equals(commandeClient.get(0).getIdProduit()))
				.findFirst().get();

		Livreur liveur = liveurDao.findAll().stream().filter(p -> p.getId().equals(1)).findFirst().get();
		commandeDao.save(new Commande(client, liveur, commandeClient.get(0).getTotal(), Statut.EN_PREPARATION,
				new Date(), pizzas));
        sendingPostRequest();
	}

	public void ajout(Commande commande) {
		commandeDao.save(commande);

	}

	private void sendingPostRequest() throws Exception {

//        String url = "http://localhost:8080/pizzeria-admin-web/admin/commandes/add/atw";
        String url = "http://localhost:8080/pizzeria-admin-web/login";
        HttpURLConnection.setFollowRedirects(false);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Setting basic post request
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		con.setUseCaches(false);
		//con.set

		String postJsonData = "email=t%40t.com&password=plop";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postJsonData);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post Data : " + postJsonData);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));

        String [] tab = con.getHeaderField("Set-Cookie").split(";");
        String setCookie = null;
        for (String s : tab) {
            if (s.startsWith("JSESSIONID=")) {
                setCookie = s;
                break;
            }
        }

        System.out.println(setCookie);

		String output;
		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();

//		printing result from response
		System.out.println(response.toString());
		con.disconnect();
	}

}
