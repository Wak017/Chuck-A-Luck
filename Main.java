import java.util.Scanner;

public class Main {
	
	public static void main(String[]args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("veux tu faire jouer le bot? o/n");
		String botJoue = scan.next();
		if(botJoue.equals("o")) {
			System.out.println("combien de fois il joue?");
			int nombreJeux = scan.nextInt();
			System.out.println("après combien de fois qu'il n'a pas vu le 6 doit-il better sur le 6?");
			int nombreFoisSansN = scan.nextInt();
			faireJouerBot(nombreJeux, 1000, nombreFoisSansN);
		}
		
		
		System.out.println("combien as tu d'argent à jouer?");
		joueur Philippe = new joueur(scan.nextInt());
		partie Partie = new partie(Philippe);
		
		while(true) {
			
			Partie.setMise(0);
			System.out.println("veux-tu miser? o/n");
			String veutMiser = scan.next();
			Partie.lancerLesDes();
			
			if(veutMiser.equals("o")) {
				System.out.println("ta mise?");
				Partie.miser(scan.nextInt());
				System.out.println("sur quelle face tu mises?");
				Partie.setFaceMise(scan.nextInt());
				Partie.evaluerVictoireOuDefaite();
			}
			Partie.afficherDes();
			Partie.evaluerJeu();
			Philippe.afficherVictoiresDefaites();
		}
				
	}
	
	public static void faireJouerBot(int nombreJeux, int argent, int sansVoirN) {
		
		joueur bot = new joueur(argent);
		partie[] tableauJeux = new partie[nombreJeux];
		
		for(int i = 0; i < tableauJeux.length; i++) {
			
			tableauJeux[i] = new partie(bot);
			tableauJeux[i].lancerLesDes();
			tableauJeux[i].afficherDes();
			
		}
		
		for(int k = sansVoirN+1; k < tableauJeux.length; k++) {
			
			Boolean veutMiser = false;
			
			if(tableauJeux[k - sansVoirN -1].de1 == 6 || tableauJeux[k - sansVoirN -1].de2 == 6 || tableauJeux[k - sansVoirN -1].de3 == 6) {
				veutMiser = true;
				for(int j = k-1; j >= k-sansVoirN; j--) {
					
					if(tableauJeux[j].de1 == 6 || tableauJeux[j].de2 == 6 || tableauJeux[j].de3 == 6) {
						
						veutMiser = false;
					}
				}
			}
			
			if(veutMiser) {
				System.out.println("derniere fois qu'on a vu un 6 dans ce jeu: "+ tableauJeux[k-sansVoirN-1].de1+", " + tableauJeux[k-sansVoirN-1].de2 + ", " + tableauJeux[k-sansVoirN-1].de3);

				tableauJeux[k].miser(10);
				tableauJeux[k].setFaceMise(6);
				tableauJeux[k].afficherDes();
				tableauJeux[k].evaluerVictoireOuDefaite();
				tableauJeux[k].evaluerJeu();
				bot.afficherVictoiresDefaites();
			}
			
		
		
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
