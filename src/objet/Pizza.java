package objet;

import util.EnumTypePizza;
import util.PizzaException;

public class Pizza
{
	private String code = null;
	private String designation = null;
	private float prix = Float.NaN;
	private EnumTypePizza type = null;

	public Pizza(String code, String designation, float prix, EnumTypePizza type) throws PizzaException {
		super();
		
		StringBuffer sb = new StringBuffer();
		
		if ((code == null) || (code.trim().length() != 3))
		{
			sb.append("Le code de la pizza doit contenir 3 caractères.\r\n");
		}
		
		if ((designation == null) || (designation.trim().length() < 3))
		{
			sb.append("La désignation de la pizza doit contenir au moins 3 caractères.\r\n");
		}
		
		if ((prix == Float.NaN) || (prix < 0f))
		{
			sb.append("Le prix de la pizza de la pizza ne peut pas être négatif.\r\n");
		}
		
		if (type == null)
		{
			sb.append("Le type de la pizza doit être indiqué.\r\n");
		}
		
		if (sb.length() > 0)
		{
			throw new PizzaException(sb.toString());
		}
		
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	

	@Override
	public String toString() {
		return "Pizza [code=" + code + ", designation=" + designation + ", prix=" + prix + ", type=" + type + "]";
	}

	public EnumTypePizza getType() {
		return type;
	}

	public void setType(EnumTypePizza type) {
		this.type = type;
	}
	
	
	
}
