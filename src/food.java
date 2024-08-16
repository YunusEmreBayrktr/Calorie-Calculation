
public class food {
	
	public int foodID;
	public String name;
	public int calorieCount;
	
	
	public food(int foodID, String name, int calorieCount) {
		this.foodID = foodID;
		this.name = name;
		this.calorieCount = calorieCount;
		
	}
	
	public int takeCalorie(int portion) {
	
		int calorie = this.calorieCount * portion;
		
		return calorie;
		
	}
}
