
public class des {
	
	int de1, de2, de3;
	
	public des() {
		
		this.de1 = lancerDe();
		this.de2 = lancerDe();
		this.de3 = lancerDe();
		
	}
	
	public static int lancerDe() {
		
		return (int) Math.floor( 1+ Math.random()*6);
		
	}
	
	public void afficherDe() {
		
		System.out.println("d� 1: "+ de1 + ", d� 2: " + de2 + ", d� 3: " + de3);
		
	}
	
}
