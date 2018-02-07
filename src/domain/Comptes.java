package domain;

import java.util.Date;

//import javax.swing.plaf.synth.SynthSeparatorUI;

public class Comptes {
	
	// Declaration de variable
	
	private Integer idCompte;
	private Integer idClient;
	private String nomClient;
	private Double soldeCompte;
	public Double taux;
	public Date dateCreationCompte;
	public String typeCompte; 
	
	// Constructeur avec les parametres (du compte)
	
	/**
	 * @param idCompte
	 * @param idClient
	 * @param nomClient
	 * @param soldeCompte
	 * @param taux
	 * @param dateCreationCompte
	 *typeCompte;
	 */
	
	public Comptes(){
		super();
	}
	
	public Comptes(Integer idCompte, Integer idClient, String nomClient, Double soldeCompte, Double taux,
			Date dateCreationCompte, String typeCompte) {
		super();
		this.idCompte = idCompte;
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.soldeCompte = soldeCompte;
		this.taux = taux;
		this.dateCreationCompte = dateCreationCompte;
		this.typeCompte = typeCompte;
	}

	// Accesseus et modificateurs
	
	/**
	 * @return the idCompte
	 */
	public Integer getIdCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte the idCompte to set
	 */
	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * @return the idClient
	 */
	public Integer getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the soldeCompte
	 */
	public Double getSoldeCompte() {
		return soldeCompte;
	}

	/**
	 * @param soldeCompte the soldeCompte to set
	 */
	public void setSoldeCompte(Double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	/**
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}

	/**
	 * @return the dateCreationCompte
	 */
	public Date getDateCreationCompte() {
		return dateCreationCompte;
	}

	/**
	 * @param dateCreationCompte the dateCreationCompte to set
	 */
	public void setDateCreationCompte(Date dateCreationCompte) {
		this.dateCreationCompte = dateCreationCompte;
	}

	/**
	 * @return the dateTransaction
	 */
	public String getTypeCompte() {
		return typeCompte;
	}

	
	
	// Methode de creation d'un compte
	
	public Comptes creerCompte(Comptes c){
		return c;
	}
	
	// Methode effectuant un depot
	
	public void depot(Double montant){
		soldeCompte += montant;
	}
	
	// Methode effectuant un retrait
	
		public void retrait(Double montant){
			soldeCompte -= montant;
		}
	
		// Methode permettant de consulter le solde du compte
		
		public void consulterSolde(Integer idCompte){
			System.out.println("Presentement, le solde de votre compte est: " +soldeCompte);
		}
		
		// Methode permettant de calculer l'interet
		
		public void calculInteret(){
			if(soldeCompte <= 100)
			{
				soldeCompte = soldeCompte + (soldeCompte*taux);
			}
			else
			{
				soldeCompte = soldeCompte + (soldeCompte*taux);
			}
		}
		
		// Methode permettant de recherche la quantite compte d'un client
		
		public void rechercherQteCompte(Integer idClient){
			Clients cli = new Clients();
			System.out.println("Presentement vous avez: " +cli.getQteCompte()+ " comptes");
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "\n"
					+ "Les caracteristiques du compte sont: \n"
					+ "Numero du compte: " + idCompte + " \n"
					+ "Numero du titulaire: " + idClient + " \n"
					+ "Nom du titulaire: " + nomClient+ " \n"
					+ "Solde du Compte: " + soldeCompte + " \n"
					+ "Taux du compte: " + taux + " \n"
					+ "Date de creation: " + dateCreationCompte +" \n"
					+ "Type du compte: " + typeCompte + "";
		}


}