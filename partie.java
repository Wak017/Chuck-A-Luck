
public class partie {
	
	joueur joueur;
	int de1, de2, de3;
	int mise;
	int faceQuonMise;
	
	public partie(joueur joueur) {
		
		this.joueur = joueur;
		
	}
	
	public void lancerLesDes() {
		
		de1 = lancerDe();
		de2 = lancerDe();
		de3 = lancerDe();
		
	}
	
	public int getDe1() {
		return de1;
	}
	
	public int getDe2() {
		return de2;
	}
	
	public int getDe3() {
		return de3;
	}
	
	public void setMise(int mise) {
		this.mise = mise;
	}
	
	public void setFaceMise(int face) {
		this.faceQuonMise = face;
	}
	
	public static int lancerDe() {
		return (int) Math.floor(1+ Math.random()*6);
	}
	
	public void miser(int mise) {
		
		this.mise = mise;
		joueur.argent -= mise;
		
	}
	
	public void doublerMise() {
		
		joueur.argent += 2*mise;
		
	}
	
	public void triplerMise() {
		
		joueur.argent += 3*mise;
		
	}
	
	public void dixFoisMise() {
		
		joueur.argent += 10*mise;
		
	}
	
	public int nombreDeDesAvecValeur() {
		int memeValeur = 0;
		
		if(de1 == this.faceQuonMise) {
			
			memeValeur += 1;
		}
		
		if(de2 == this.faceQuonMise) {
			
			memeValeur += 1;
		}
		
		if(de3 == this.faceQuonMise) {
			
			memeValeur += 1;
		}
		
		return memeValeur;
		
	}
	
	public void afficherDes() {
		System.out.println("les dés: " + de1 + ", " + de2 + ", " + de3);
	}
	
	public void evaluerVictoireOuDefaite() {
		
		if(nombreDeDesAvecValeur() == 0) {
			
			joueur.aPerdu();
			System.out.println("tu as perdu");
			
		}
		else {
			
			joueur.aGagne();
		}
		
	}
	
	public void evaluerJeu() {
		
		int gagne = nombreDeDesAvecValeur();
		
		switch(gagne) {
			case 0:
				break;
			case 1:
				System.out.println("tu as doublé ta mise");
				doublerMise();
				break;
			case 2:
				System.out.println("tu as triplé ta mise");
				triplerMise();
				break;
			case 3:
				System.out.println("tu as 10x ta mise");
				dixFoisMise();
				break;
		}
		
		System.out.println("tu as maintenant "+ joueur.argent +" $.");
		
	}

}
