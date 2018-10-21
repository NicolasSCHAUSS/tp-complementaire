package objet;

import util.ClientException;
import util.CreditException;
import util.DebitException;

/**Livreur Class
 * @author nschauss
 */
public class Livreur extends Client {

	/**
	 * Livreur Constructor
	 * @param nom
	 * @param prenom
	 * @param solde
	 * @throws ClientException
	 */
	public Livreur(String nom, String prenom, float solde) throws ClientException {
		super(nom, prenom, solde);
	}
	
	/**
	 * Client method to credit balance
	 * @param montant
	 * @throws CreditException, on balance limit (5000€)
	 */
	@Override
	public void crediterCompte(double montant)
	{
		this.solde += montant;
	}
	
	/**
	 * Client method to debit balance
	 * @param montant
	 * @throws DebitException, on negative balance (less than 0€)
	 */
	@Override
	public void debiterCompte(double montant)
	{
		this.solde -= montant;
	}
	
	/**
	 * Client method to command pizza
	 * @param pizza
	 * @use debiterCompte()
	 */
	@Override
	public void commandePizza(Pizza pizza)
	{
		debiterCompte(pizza.getPrix());
	}
	
	@Override
	public String toString()
	{
		return super.toString().replace("Client","Livreur");
	}

}
