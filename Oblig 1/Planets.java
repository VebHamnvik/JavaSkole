package myClass;

public class Planets {
	//Instansvariabler for objektene
	private String planetName; 
	private double planetRadius;
	private String planetMass;

	//Constructor
	public Planets(String name, double radius, String mass){
		planetName = name;
		planetRadius = radius;
		planetMass = mass;
	}
	
	//Metode for å printe ut informasjonen
	public void printInfo() {
		System.out.println("Planeten " + planetName + " har en radius på " + planetRadius + "km og en masse på " + planetMass + "kg");
	}

	//Set metoder
	public void setName(String name){
		this.planetName = name;
	}
	
	public void setRadius(double radius){
		this.planetRadius = radius;
	}

	public void setMass(String mass){
		this.planetMass = mass;
	}

	//Get metoder
	public String getName(){
		return planetName;
	}

	public double getRadius(){
		return planetRadius;
	}

	public String getMass(){
		return planetMass;
	}

}
