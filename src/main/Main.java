package main;

import dao.ClientDao;
import dao.PizzaDao;
import objet.Client;
import objet.Livreur;
import util.ClientException;
import util.PizzaException;

/**Main Class
 * @author nschauss
 * @use ClientDao, PizzaDao
 */
public class Main {

	public static void main(String[] args) {
		
		try
		{
			//Init Pizza and Client DAO
			PizzaDao pizzaDao = new PizzaDao();
			ClientDao clientDao = new ClientDao();
			System.out.println("Init Pizza DAO:");
			System.out.println(pizzaDao);
			
			//Test Credit exception on a new rich client
			System.out.println("Test rich client:");
			clientDao.findAllClients().add(new Client("DUCK", "Picsou", 300000.0F));
			//Test Debit exception on a new poor client
			System.out.println("Test poor client:");
			clientDao.findAllClients().add(new Client("DUCK", "Donald", -2000.0F));
			
			//Test Debit exception on first client
			System.out.println("Test expansive commands from same client balance :");
			clientDao.findAllClients().get(0).commandePizza(pizzaDao.findPizzaByCode("DYN"));
			clientDao.findAllClients().get(0).commandePizza(pizzaDao.findPizzaByCode("DYN"));
			
			//Test Class Livreur
			System.out.println("Test DeliveryMan client...");
			clientDao.findAllClients().add(new Livreur("DUCK", "Daisy", -5000.0F));
			clientDao.findAllClients().get(clientDao.findAllClients().size()-1).commandePizza(pizzaDao.findPizzaByCode("DYN"));
			Livreur daisy = (Livreur) clientDao.findAllClients().get(clientDao.findAllClients().size()-1);
			daisy.crediterCompte(20000.0F);
			
			//Show Client info
			System.out.println("Show ClientDAO list & informations:");
			clientDao.showAllClients();
			System.out.println(clientDao);
			
		} catch (PizzaException | ClientException  e) {
			e.printStackTrace();
			
			// Bad Pizza DOA or Client DOA : stop program
			System.err.println("Erreur lors de la création du DAO : le programme ne peut pas continuer !");
			System.exit(-1);
		}
		
	}

}
