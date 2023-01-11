import oblig.Planets;

public class Oppgave2_3{
	
	public static void main(String[] args){
		Planets saturn = new Planets("Saturn",58232 , "5.683E26");
		saturn.printInfo();

		Planets mars = new Planets("Mars", 3389.5, "6,39E23");
		mars.printInfo();

		Planets venus = new Planets("Venus", 6051.8, "4,867E24");
		venus.printInfo();

		Planets uranus = new Planets("Uranus", 25362, "8,681E25");
		uranus.printInfo();
	}
}