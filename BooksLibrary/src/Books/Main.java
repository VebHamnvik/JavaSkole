package Books;

public class Main {
    public static void main(String[] args) {
        // TODO: 01.02.2023 Create book objects
        Book warAndPeace = new Book("War and Peace", "Leo Tolstoy");
        Ebook nameOfWind = new Ebook("The Name of The Wind", "Patrick Rothfuss", "ePub", 3);

        System.out.println(warAndPeace.getTitle());
    }
}
