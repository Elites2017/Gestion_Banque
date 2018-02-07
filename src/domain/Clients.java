package domain;

public class Clients {
	
	//Declaratin des variables
	
	private Integer idClient;
	private String nomClient;
	private Integer qteCompte;
	
	
	// Constructeur sans paremtre
	
	public Clients() {
		super();
	}

	//Constructeur avec des parametres
	
	/**
	 *
	 * @param idClient
	 * @param nomClient
	 * @param qteCompte
	 */
	
	public Clients(Integer idClient, String nomClient, Integer qteCompte) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.qteCompte = qteCompte;
	}

	// Accesseurs et modificateurs
	
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
	 * @return the qteCompte
	 */
	public int getQteCompte() {
		return qteCompte;
	}

	/**
	 * @param qteCompte the qteCompte to set
	 */
	public void setQteCompte(Integer qteCompte) {
		this.qteCompte = qteCompte;
	}
	
	// Methode de creation d'un client
	
		public Clients creerClient(Clients cl){
			return cl;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "\n"
					+ "Les informations d'un client sont: \n"
					+ "Numero Client: " + idClient + " \n"
					+ "Nom Client: " + nomClient + " \n"
					+ "Nombre Compte=" + qteCompte + "";
		}
}