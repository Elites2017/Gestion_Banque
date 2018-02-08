package presentation;

//import domain.Menu;
import domain.Clients;
import domain.Comptes;
import domain.Transactions;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Gestion_B {

	public Gestion_B() {
		// TODO Auto-generated constructor stub
	}
	
	Clients cl = new Clients();
	Double taux, montant, solde_apres_t, solde_avant_t, montantTrans;
	Date date = new Date();
	Scanner lecture = new Scanner(System.in);
	int numCompte,numTrans;
	String typeTrans;
	
	Comptes cpte = new Comptes();
	char choix = '\0';
	ArrayList<Comptes> listeCpte = new ArrayList<Comptes>();
	ArrayList<Transactions> listeTransaction = new ArrayList<Transactions>();
	Date dateTrans = new Date();
	
	public void creerCompte()
	{
		try
		{
			System.out.println("Numero du compte - NB: Un entier positif");
			int cpid = lecture.nextInt();
			while(cpid<=0)
			{
				System.err.println("Numero du compte - NB: Un entier positif");
				cpid = lecture.nextInt();
			}
			
					boolean trouver = false;
				for (Comptes cpte_tenu : listeCpte) 
				{
					int tempCompte = cpte_tenu.getIdCompte();
					if (tempCompte == cpid)
					{
						System.err.println("Ce compte exsite: ");
						trouver = true;
						while(cpid<=0)
						{
							System.err.println("Numero du compte - NB: Un entier positif");
							cpid = lecture.nextInt();
						}
					}
				}

				if (trouver == false)
				{
					
				System.out.println("Numero du client - NB: Un entier positif");
				int clid = lecture.nextInt();
				while(clid<=0)
				{
					System.err.println("Numero du client - NB: Un entier positif");
					clid = lecture.nextInt();
				}
				System.out.println("Client nom");
				String clnom = lecture.next();
				System.out.println("Solde compte - NB: Un nombre positif");
				double cpsolde = lecture.nextDouble();
				while(cpsolde<=0)
				{
					System.err.println("Solde compte - NB: Un nombre positif");
					cpsolde = lecture.nextDouble();
				}
				System.out.println("Type du compte NB: Epargne ou Courant");
				String typeCpte = lecture.next();
				System.out.println("Taux du compte - NB: un decimal superieur a 0 et inferieur a 1");
				taux = lecture.nextDouble();
				while((taux<=0)||(taux>=1))
				{
					System.err.println("Taux du compte - NB: un decimal superieur a 0 et inferieur a 1");
					taux = lecture.nextDouble();
				}
				Date dc = new Date();
				cpte= new Comptes(cpid,clid,clnom,cpsolde,taux,dc,typeCpte);
				cl = new Clients(cpte.getIdClient(),cpte.getNomClient(),1);
				typeTrans = "Depot";
				montantTrans = cpsolde;
				numTrans = listeTransaction.size()+1;
				listeCpte.add(cpte);
				solde_avant_t = 0.0;
				solde_apres_t = montantTrans;
				Transactions trans = new Transactions(numTrans, cpte.getIdClient(), cpte.getIdCompte(), dateTrans, typeTrans,montantTrans,solde_avant_t,solde_apres_t);
				listeTransaction.add(trans);
				
				System.out.println("\n");
				System.out.println("Compte: ");
						
				for (int x=0; x<listeCpte.size(); x++)
					{
						System.out.println(listeCpte.get(x).toString());
						System.out.println("");
					}
				}
		}
		catch(Exception e)
		{
			System.out.println("Erreur, veillez rentrer des donnees correctes");
		}
	}
	
	public void verifierBalance()
	{
		try
		{
			System.out.println("Entrez le numero du Compte :");
			numCompte = lecture.nextInt();
			while(numCompte<=0)
			{
				System.err.println("Numero du compte - NB: Un entier positif");
				numCompte = lecture.nextInt();
			}
			if (listeCpte.isEmpty())
			{
				System.err.println("Ce numero de compte n'existe pas.");
			}
			
			else
			{
				boolean trouver = false;
				for (Comptes cpte_tenu : listeCpte) 
				{
					int tempCompte = cpte_tenu.getIdCompte();
					if (tempCompte == numCompte)
					{
						cpte_tenu.consulterSolde(cpte_tenu.getIdCompte());
						trouver = true;
					}

				}

				if (trouver == false)
				{
					System.err.println("Ce numero de compte n'existe pas.");

				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void faireDepot()
	{
		try
		{
			System.out.println("Entrez le numero du Compte :");
			numCompte = lecture.nextInt();
			while(numCompte<=0)
			{
				System.err.println("Numero du compte - NB: Un entier positif");
				numCompte = lecture.nextInt();
			}
				if (listeCpte.isEmpty())
				{
					System.err.println("Presentement, la banque n'a pas de compte.");
				}
			
				else
				{
					boolean trouver = false;
					for (Comptes cpte_tenu : listeCpte) 
					{
						int tempCompte = cpte_tenu.getIdCompte();
						if (tempCompte == numCompte)
						{
							System.out.println("Entrez le montant a deposer - NB: un montant positif");
							montant = lecture.nextDouble();
							while(montant<=0)
							{
								System.err.println("Entrez le montant a deposer - NB: un montant positif");
								montant = lecture.nextDouble();
							}
							solde_avant_t = cpte_tenu.getSoldeCompte();
							solde_apres_t = solde_avant_t + montant;
							typeTrans = "Depot";
							montantTrans = montant;
							numTrans = listeTransaction.size()+1;
							Transactions trans = new Transactions(numTrans, cpte_tenu.getIdCompte(),cpte_tenu.getIdClient(),dateTrans,typeTrans,montantTrans,solde_avant_t,solde_apres_t);
							listeTransaction.add(trans);
							System.out.println("Vous aviez "+solde_avant_t+" sur votre compte, \n"
									+ "vous venez de faire un depot de: "+montant+", presentement vous avez: "+solde_apres_t+" sur votre compte");
							System.out.println("\n");
							cpte_tenu.depot(montant);
							trouver = true;
						}
					}

				if (trouver == false)
				{
					System.err.println("Ce numero de compte n'existe pas.");

				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void faireRetrait()
	{
		try
		{
			System.out.println("Entrez le numero du Compte :");
			numCompte = lecture.nextInt();
			while(numCompte<=0)
			{
				System.err.println("Numero du compte - NB: Un entier positif");
				numCompte = lecture.nextInt();
			}
			if (listeCpte.isEmpty())
			{
				System.err.println("Presentement, la banque n'a pas de compte.");
			}
			
			else
			{
				boolean trouver = false;
				for (Comptes cpte_tenu : listeCpte) 
				{
					int tempCompte = cpte_tenu.getIdCompte();
					if (tempCompte == numCompte)
					{
						System.out.println("Entrez le montant a enlever - NB: un montant positif inferieur a votre solde");
						montant = lecture.nextDouble();
						while((montant<=0)||(montant>=cpte_tenu.getSoldeCompte()))
						{
							System.err.println("Entrez le montant a enlever - NB: un montant positif inferieur a votre solde");
							montant = lecture.nextDouble();
						}
						solde_avant_t = cpte_tenu.getSoldeCompte();
						solde_apres_t = solde_avant_t - montant;
						typeTrans = "Retrait";
						montantTrans = montant;
						numTrans = listeTransaction.size()+1;
						Transactions trans = new Transactions(numTrans, cpte_tenu.getIdCompte(),cpte_tenu.getIdClient(),dateTrans,typeTrans,montantTrans,solde_avant_t,solde_apres_t);
						listeTransaction.add(trans);
						System.out.println("Vous aviez "+solde_avant_t+" sur votre compte, \n"
								+ "vous venez de faire un retrait de: "+montant+", presentement vous avez: "+solde_apres_t+" sur votre compte");
						System.out.println("\n");
						cpte_tenu.retrait(montant);
						
						trouver = true;
					}

				}

				if (trouver == false)
				{
					System.err.println("Ce numero de compte n'existe pas.");

				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}	
	}
	
	public void verifierQteCompte()
	{
		try
		{
			System.out.println("Entrez le numero du client :");
			int idClient = lecture.nextInt();
			while (idClient <= 0)
			{
				System.err.println("le numero du client - NB: Un entier positif");
				idClient = lecture.nextInt();
			}
			if (listeCpte.isEmpty())
			{
				System.err.println("Presentement, la banque n'a pas de compte pour ce client.");
			}

			else
			{
				boolean trouver = false;
				int i = 0;
				for (Comptes cpte_tenu : listeCpte)
				{
					int tempCompte = cpte_tenu.getIdClient();
					if (tempCompte == idClient) 
					{
						++i;
						trouver = true;
					}
				}
				System.err.println("Nombre de Compte: "+i);
	
				if (trouver == false)
				{
					System.err.println("Ce client n'existe pas.");

				}
			}
		}
		
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void rapportTransaction()
	{
		try
		{
			for (int x=0; x<listeTransaction.size(); x++)
			{
				System.out.println("");
				System.out.println(listeTransaction.get(x).toString());
				System.out.println("");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void calculInteret()
	{
		try
		{
			for (int x=0; x<listeCpte.size(); x++)
			{
				listeCpte.get(x).setSoldeCompte(listeCpte.get(x).getSoldeCompte()*(1 + listeCpte.get(x).getTaux()));
				System.out.println("");
				System.out.println(listeCpte.get(x).toString());
				System.out.println("");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void consulterCompte()
	{
		try
		{
			for (int x=0; x<listeCpte.size(); x++)
			{
				System.out.println("");
				System.out.println(listeCpte.get(x).toString());
				System.out.println("");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void messageAurevoir()
	{
		System.out.println("Merci de votre fidelite a notre banque, aurevoir !" + "");
		System.exit(0);
	}
	
	public void messageParDefaut()
	{
		System.out.println("************************************");
		System.out.println("Cette option n'est pas valibe, choisissez une option valide");
		System.out.println("\n");
	}
	
	public void affichage()
	{
		
		do
		{
			System.out.println("\n");
			System.out.println("************** Bienvenue a la Banque ! **********");
			System.out.println("\n");
			System.out.println("A - Creer un compte");
			System.out.println("B - Verifier la balance d'un compte");
			System.out.println("C - Faire un depot sur un compte");
			System.out.println("D - Faire un retrait sur un compte");
			System.out.println("E - Verifier le nombre de compte");
			System.out.println("F - Rapport de transaction des comptes");
			System.out.println("G - Calculer l'interet pour les comptes");
			System.out.println("H - Consulter tous les comptes");
			System.out.println("I - Sortir");
			System.out.println("\n");
			System.out.println("*********************************************");
			System.out.println("Faites votre choix");
			System.out.println("*********************************************");
			
			choix = lecture.next().charAt(0);
			
			switch(choix)
			{
				case 'a':
				case 'A':
						creerCompte();
					break;
			
				case 'b':
				case 'B':
						verifierBalance();
					break;
				
				case 'c':
				case 'C':
						faireDepot();
					break;
				
				case 'd':
				case 'D':
						faireRetrait();
					break;
					
					
				case 'e':
				case 'E':
					verifierQteCompte();
				break;
						
				case 'f':
				case 'F':
						rapportTransaction();
						break;
				
				case 'g':
				case 'G':
						calculInteret();
					break;
					
				case 'h':
				case 'H':
						consulterCompte();
					break;
					
				case 'i':
				case 'I':
						messageAurevoir();
					break;
					
				default:
						messageParDefaut();
					break;
			}
		}
		
		while(choix != 'I');
			
		lecture.close();
	}
	
}
