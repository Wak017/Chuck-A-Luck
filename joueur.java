
public class joueur {
	
	int argent;
	int gagne;
	int perdu;
	
	public joueur(int argent) {
		
		this.argent = argent;
		
	}
	
	public void aPerdu() {
		perdu ++;
	}
	
	public void aGagne() {
		gagne ++;
	}
	
	public int victoires() {
		return gagne;
	}
	
	public int defaites() {
		return perdu;
	}
	
	public void afficherVictoiresDefaites() {
		System.out.println("gagné: "+ victoires() + ", perdu: "+ defaites());

	}
	
	
	
}
