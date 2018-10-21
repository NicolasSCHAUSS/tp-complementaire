package dao;

import java.util.ArrayList;
import java.util.List;

import objet.Client;
import util.ClientException;

/**ClientDao Class
 * @author nschauss
 */
public class ClientDao {

	private List<Client> listClient = null;
	private double minSolde = 0.0;
	private double maxSolde = 0.0;
	private double total = 0.0;
	
	public ClientDao() throws ClientException {
		super();

		listClient = new ArrayList<Client>();
		listClient.add(new Client("DUCK","Riri", 5000.0F));
		listClient.add(new Client("DUCK","Fifi", 5000.0F));
		listClient.add(new Client("DUCK","Loulou", 5000.0F));
		setInfo();
	}
	
	public List<Client> findAllClients() {
		
		return listClient;
	}
	
	public void showAllClients()
	{
		for (Client cl : listClient) {
			System.out.println(cl);
		}
	}
	
	/**ClientDao method to update statistics informations
	 * @see minSolde, maxSolde, total
	 */
	private void setInfo()
	{
		total = 0.0;
		for (Client c : listClient)
		{
			total += c.getSolde();
			
			if (c.getSolde()>maxSolde)
			{
				maxSolde = c.getSolde();
			}
			else if (c.getSolde()<minSolde)
			{
				minSolde = c.getSolde();
			}
		}
	}
	
	@Override
	public String toString()
	{
		setInfo();
		return "Nombre de comptes = "+ listClient.size()+"\r\n"+
			   "Total Solde de tous les comptes = "+ total+"€\r\n"+
			   "Moyenne Solde = "+(total/listClient.size())+"€\r\n"+
			   "Solde le plus faible = "+minSolde+"€\r\n"+
			   "Solde le plus élevé = "+maxSolde+"€";
	}
}
