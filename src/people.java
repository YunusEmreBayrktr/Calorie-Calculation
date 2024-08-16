
public class people {
	
	int personID ;
	String name ;
	String gender;
	int weight;
	int height;
	int age;
	int dailyCal = 0;
	int caloriesTaken = 0;
	int caloriesBurned = 0;
	
	
	public people(int personID,String name,String gender,int weight,int height,int birthDate) {
		this.personID = personID;
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.age = 2022-birthDate;
		if(gender.equals("male")) {
			this.dailyCal = (int) Math.round((double)66 + (13.75*weight)+(5*height) -(6.8*age)) ;
		}
		else if(gender.equals("female")) {
			this.dailyCal = (int) Math.round((double)665 + (9.6*weight)+(1.7*height) -(4.7*age)) ;
		}
	}

	public int getResult() {
	
	int result = this.caloriesTaken - this.dailyCal - this.caloriesBurned ;
	return result;
	}
	
	public String print() {
		if(this.getResult()>0) {
			return name + "\t" + age + "\t" + dailyCal + "kcal\t" + caloriesTaken + "kcal\t" + 
					caloriesBurned + "kcal\t+" + this.getResult()+"kcal";
			}
		
		else {
			return name + "\t" + age + "\t" + dailyCal + "kcal\t" + caloriesTaken + "kcal\t" + 
					caloriesBurned + "kcal\t" + this.getResult()+"kcal";
			}
	}
}
