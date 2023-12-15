import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *	Population - <description goes here>
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	
 *	@since	
 */
public class Population {
	
	// List of cities
	private List<City> cities;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	
	public Population(){
		cities = new ArrayList<City>();
	}
	
	public static void main(String[] args){
		Population pop = new Population();
		pop.run();
	}
	
	public void run(){
		printIntroduction();
		loadCities();
		askQuery();
	}
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
	public void loadCities(){
		Scanner input = FileUtils.openToRead(DATA_FILE);
		int index = 0;
		while(input.hasNext()){
			String state = input.next();
			if(state.equals("New") || state.equals("North") || state.equals("South") || state.equals("West")){
				state += " " + input.next();
			}
			String line = input.nextLine();
			String name = new String();
			String des = new String();
			int pop = 0;
			
			int lastIndex = line.length() - 1;
			
			while(line.charAt(lastIndex) >='0' && line.charAt(lastIndex) <='9'){
				lastIndex--;
			}
			pop = Integer.parseInt(line.substring(lastIndex+1, line.length()));
			line = line.substring(0,lastIndex+1);
			while(line.charAt(lastIndex-1) != 9){
				lastIndex--;
			}
			des = line.substring(lastIndex, line.length()).trim();
			
			name = line.substring(0, lastIndex).trim();
			
			City current = new City(name, state, des, pop);
			cities.add(current);
			
		}
	}
	
	public void askQuery(){
		int input = 0;
		while(input != 9){
			printMenu();
			input = Prompt.getInt("Enter Selection");
			if(input == 1){
				ascendPop();
				System.out.println("Fifty least populous cities");
				for(int i = 0; i < 50; i++){
					City current = cities.get(i);
					
					System.out.printf("%2d: %-20s%-25s%-20s%5d%n",i+1,current.getState(), current.getName(), current.getDes(), current.getPop());
				}
			}
			else if(input == 2){
				
			}
			else if(input == 3){
				
			}
			else if(input == 4){
				
			}
			else if(input == 5){
				
			}
			else if(input == 6){
				
			}
			else if(input !=9){
				System.out.println("Please enter a valid integer.");
			}
		}
	}

	private void swap(int x, int y) {
		City temp = cities.get(x);
		cities.set(x, cities.get(y));
		cities.set(y, temp);
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order 
	 */
	public void ascendPop() {
		
		for(int outer = cities.size(); outer > 1; outer--){
			int max = 0;
			for(int inner = 0; inner < outer; inner++){
				if(cities.get(max).getPop()<cities.get(inner).getPop()){
					max = inner;
				}
			}
			swap(max, outer-1);
		}
	}
}
