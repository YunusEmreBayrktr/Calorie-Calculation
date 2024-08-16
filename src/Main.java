import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		ArrayList<String> peopleData = readFile("people.txt");
		ArrayList<String> foodData = readFile("food.txt");
		ArrayList<String> sportData = readFile("sport.txt");
		ArrayList<String> commandData = readFile(args[0]);
		
		ArrayList<people> people = getPeople(peopleData);
		ArrayList<food> food = getFood(foodData);
		ArrayList<sport> sport = getSport(sportData);
		
		ArrayList<people> printList = new ArrayList<people>();
		ArrayList<people> warnList = new ArrayList<people>();
		
		ArrayList<String> output = new ArrayList<String>();
		
		
		
		
		
		
		
		
		
		for(int line=0; line<commandData.size(); line++) {
			
		
			if(commandData.get(line).split("\t")[0].equals("printList")) {
				for(people pPerson : printList) {
					output.add(pPerson.print()+"\n");
				}
			}
			
			else if(commandData.get(line).split("\t")[0].equals("printWarn")) {
				for(people person : printList) {
					
					if(person.getResult()>0) {
						warnList.add(person);}
				}
				if(warnList.size() == 0) {
					output.add("There\tis\tno\tsuch\tperson\n");}
				else {
					for(people wPerson : warnList ) {
						output.add(wPerson.print()+"\n");}
					}
				warnList.clear();
			}
			
			else if(commandData.get(line).split("\t")[0].substring(0, 5).equals("print")) {
				for(people person : people) {
					if(Integer.parseInt(commandData.get(line).split("\t")[0].substring(6,11)) == person.personID) {
						output.add(person.print()+"\n");
					}
					
				}
			}
			
			else {
				for(people person : people) {
					if(Integer.parseInt(commandData.get(line).split("\t")[0]) == person.personID) {
						
						if(!(printList.contains(person))) {
							printList.add(person);
						}
						
						
						for(food eaten : food) {
							if(eaten.foodID == Integer.parseInt(commandData.get(line).split("\t")[1])) {	
								person.caloriesTaken += eaten.takeCalorie(Integer.parseInt(commandData.get(line).split("\t")[2]));
								output.add(person.personID+"\thas\ttaken\t"+(eaten.calorieCount*Integer.parseInt(commandData.get(line).split("\t")[2]))+"kcal\tfrom\t"+eaten.name+"\n");
							}
						}
						for(sport done : sport) {
							if(done.sportID == Integer.parseInt(commandData.get(line).split("\t")[1])) {
								person.caloriesBurned += done.burnCalorie(Integer.parseInt(commandData.get(line).split("\t")[2]));
								output.add(person.personID+"\thas\tburned\t"+(int)((done.calorieBurn*Integer.parseInt(commandData.get(line).split("\t")[2]))/60)+"kcal\tthanks\tto\t"+done.name+"\n");
							}
						}
					}	
				}	
			}
			output.add("***************\n");
		
		}
	writeFile("monitoring.txt",output);	
	
	

	}

	
	public static ArrayList<String> readFile(String fileName ) throws IOException {
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<String> data = new ArrayList<>();
		String line;
		while((line = br.readLine()) != null) {
			data.add(line);
		}
		br.close();
		return data;
		
	}
	
	public static void writeFile(String fileName , ArrayList<String> data) throws IOException {
		
		File monitoring = new File(fileName);
		FileWriter output = new FileWriter(monitoring);
	
		for(int i=0 ; i<data.size()-2;i++) {
			output.write(data.get(i));
		}
		output.write((data.get(data.size()-2)).replaceAll("\n", ""));
		output.close();
	}
	
	public static ArrayList<people> getPeople(ArrayList<String> data){
		
		ArrayList<people> list = new ArrayList<people>();
		
		for(int i=0 ; i <data.size() ; i++) {
			String[] temp = data.get(i).split("\t");
			list.add(new people(Integer.parseInt(temp[0]),temp[1],temp[2],Integer.parseInt(temp[3])
						,Integer.parseInt(temp[4]),Integer.parseInt(temp[5])));
		}
		return list;
			
	}
	
	public static ArrayList<food> getFood(ArrayList<String> data){
		
		ArrayList<food> list = new ArrayList<food>();
		
		for(int i=0 ; i<data.size() ; i++) {
			
			String[] temp = data.get(i).split("\t");
			list.add(new food(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2])));
		}
		return list;
		
	}
	
	public static ArrayList<sport> getSport(ArrayList<String> data) {
		
		ArrayList<sport> list = new ArrayList<sport>();
		
		for(int i=0 ; i<data.size() ; i++) {
			
			String[] temp = data.get(i).split("\t");
			list.add(new sport(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2])));
		}
		return list;
		
		
	}
	






}
