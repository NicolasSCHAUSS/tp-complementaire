package objet;

import dao.ICompteStat;
import util.ClientException;
import util.CreditException;
import util.DebitException;

/**Client Class
 * @author nschauss
 */
public class Client implements ICompteStat{
	
	private static int id_counter = 0;
	protected int id ;
	protected String nom ;
	protected String prenom ;
	protected float solde ;
	
	/**Client Constructor
	 * @param nom
	 * @param prenom
	 * @param solde
	 * @throws ClientException
	 * @use crediterCompte(), debiterCompte
	 */
	public Client(String nom, String prenom, float solde) throws ClientException {
		super();
		Client.id_counter++;
		//No need to refer id by using id_counter
		this.id = id_counter;
		StringBuffer sb = new StringBuffer();
		
		//Handle last name exception
		if ((nom == null) || (nom.trim().length() <= 2))
		{
			sb.append("Le nom du client doit contenir au moins 2 caractères.\r\n");
		}
		//Handle first name exception
		if ((prenom == null) || (prenom.trim().length() <= 2))
		{
			sb.append("Le prénom du client doit contenir au moins 2 caractères.\r\n");
		}
		//Throw client exception
		if (sb.length() > 0)
		{
			throw new ClientException(sb.toString());
		}
		
		this.nom = nom;
		this.prenom = prenom;
		//Handle balance exception
		try {
			
			if(solde>0)
			{
				crediterCompte(solde);
			}
			else
			{
				debiterCompte(Math.abs(solde));
			}
				
		} catch	(CreditException|DebitException e) {
			System.err.println("Le solde du client sera configuré à 0.0€ par default!");
			this.solde = 0.0F;
			e.printStackTrace();
		}
	}
	
	/**
	 * Client method to credit balance
	 * @param montant
	 * @throws CreditException, on balance limit (5000€)
	 */
	public void crediterCompte(double montant) throws CreditException
	{
		if(this.solde+montant<=5000.0)
		{
			this.solde += montant;
		}
		else
		{
			throw new CreditException("Credit annulé, solde > 5000€ !");
		}
			
	}
	
	/**
	 * Client method to debit balance
	 * @param montant
	 * @throws DebitException, on negative balance (less than 0€)
	 */
	public void debiterCompte(double montant) throws DebitException
	{
		if(this.solde-montant>=0)
		{
			this.solde-=montant;
		}
		else
		{
			throw new DebitException("Debit annulé, solde < 0€ !");
		}
	}
	
	/**
	 * Client method to command pizza
	 * @param pizza
	 * @use debiterCompte()
	 */
	public void commandePizza(Pizza pizza)
	{
		try { 
			debiterCompte(pizza.getPrix());
		} catch (DebitException e) {
			System.err.println("Le solde du client ne lui permet pas de passer de commande !");
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString()
	{
		return "Client [id="+ id +", nom="+ nom +", prenom="+ prenom +", solde="+ solde +"€]";
	}

	@Override
	public double getSolde() {
		
		return solde;
	}
}
