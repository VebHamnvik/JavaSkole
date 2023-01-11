import oblig.Planets;
import java.util.Scanner;


public class Bonus1{
	
	public static void main(String[] args){
		Scanner navn = new Scanner(System.in);
		System.out.println("Vennligst skriv inn navnet på planeten:");
		String planetNavn = navn.nextLine();

		Scanner radius = new Scanner(System.in);
		System.out.println("Vennligst skriv inn radiusen på planeten:");
		double planetRadius = radius.nextDouble();

		Scanner mass = new Scanner(System.in);
		System.out.println("Vennligst skriv inn massen på planeten:");
		String planetMass = mass.nextLine();

		Planets userPlanet = new Planets(planetNavn, planetRadius, planetMass);

		userPlanet.printInfo();
		
	}
}