
public class sport {
	
	public int sportID;
	public String name;
	public int calorieBurn;
	
	public sport(int sportID, String name ,int calorieBurn) {
		this.sportID = sportID;
		this.name = name;
		this.calorieBurn = calorieBurn;
		
	}

	public int burnCalorie(int duration) {
		
		int burned = (this.calorieBurn*duration)/60;
		
		return burned;
		
	}
}
