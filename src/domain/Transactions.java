package domain;

import java.util.Date;

public class Transactions {
	public int numTransaction;
	private Integer idClient;
	private Integer idCompte;
	public Date dateTransaction;
	public String typeTransaction;
	private Double montantTransaction;
	private Double solde_Av_T;
	private Double solde_Ap_T;
	
	public Transactions(){
		super();
	}
	
	public Transactions(int numTransaction, Integer idClient, Integer idCompte, Date dateTransaction, String typeTransaction, Double montantTransaction, Double solde_Av_T, Double solde_Ap_T) {
		this.numTransaction = numTransaction;
		this.idClient = idClient;
		this.idCompte = idCompte;
		this.dateTransaction = dateTransaction;
		this.typeTransaction = typeTransaction;
		this.montantTransaction = montantTransaction;
		this.solde_Av_T = solde_Av_T;
		this.solde_Ap_T = solde_Ap_T;
	}

	/**
	 * @return the numTransaction
	 */
	public int getNumTransaction() {
		return numTransaction;
	}

	/**
	 * @param numTransaction the numTransaction to set
	 */
	public void setNumTransaction(int numTransaction) {
		this.numTransaction = numTransaction;
	}
	
	/**
	 * @return the idClient
	 */
	public int getidClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setidClient(Integer idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the idCompte
	 */
	public int getidCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte the idCompte to set
	 */
	public void setidCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}
	
	/**
	 * @return the dateTransaction
	 */
	public Date getDateTransaction() {
		return dateTransaction;
	}

	/**
	 * @param dateTransaction the dateTransaction to set
	 */
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	/**
	 * @return the typeTransaction
	 */
	public String getTypeTransaction() {
		return typeTransaction;
	}

	/**
	 * @param typeTransaction the typeTransaction to set
	 */
	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	/**
	 * @return the montantTransaction
	 */
	public Double getMontantTransaction() {
		return montantTransaction;
	}

	/**
	 * @param montantTransaction the montantTransaction to set
	 */
	public void setMontantTransaction(Double montantTransaction) {
		this.montantTransaction = montantTransaction;
	}
	
	//Methode de creation d'une transaction
	
		public Transactions creerTransaction(Transactions t){
			return t;
		}
		
		/**
		 * @return the solde_Av_T
		 */
		public Double getSolde_Av_T() {
			return solde_Av_T;
		}

		/**
		 * @param solde_Av_T the solde_Av_T to set
		 */
		public void setSolde_Av_T(Double solde_Av_T) {
			this.solde_Av_T = solde_Av_T;
		}

		/**
		 * @return the solde_Ap_T
		 */
		public Double getSolde_Ap_T() {
			return solde_Ap_T;
		}

		/**
		 * @param solde_Ap_T the solde_Ap_T to set
		 */
		public void setSolde_Ap_T(Double solde_Ap_T) {
			this.solde_Ap_T = solde_Ap_T;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "\n"
					+ "Numero Transaction: " + numTransaction + " \n"
					+ "Numero Client: " + idClient + " \n"
					+ "Numero Compte: " + idCompte + " \n"
					+ "Date Transaction: " + dateTransaction + " \n"
					+ "Type Transaction: " + typeTransaction + " \n"
					+ "Montant Transaction: " + montantTransaction + " \n"
					+ "Solde Avant Transaction: " + solde_Av_T + " \n"
					+ "Solde Apres Transaction: " + solde_Ap_T + "";
		}
	
}
