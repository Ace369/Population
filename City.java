/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Aditi Chamarthy
 *	@since	December 7, 2023
 */
public class City implements Comparable<City> {
	
	// fields
	private String name;
	private String state;
	private String designation;
	private int population;
	// constructor
	public City(String nameIn, String stateIn, String desIn, int popIn){
		name = nameIn;
		state = stateIn;
		designation = desIn;
		population = popIn;
	}
	
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	public int compareTo(City other){
		if(this.population - other.population != 0){
			return this.population - other.population;
		}
		else if(this.state.compareTo(other.state) !=0){
			return this.state.compareTo(other.state);
		}
		else{
			return this.name.compareTo(other.name);
		}
	}
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	public boolean equals(City other){
		if(this.name == other.getName()){return true;}
		else{return false;}
	}
	
	/**	Accessor methods */
	public String getName(){return name;}
	public String getState(){return state;}
	public String getDes(){return designation;}
	public int getPop(){return population;}
	
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, designation,
						population);
	}
	
	
	
	
}
