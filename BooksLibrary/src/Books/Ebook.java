package Books;

public class Ebook extends Book{
    private String format;
    private int sizeInMB;

    public Ebook(String title, String author, String format, int sizeInMB) {
        super(title, author);
        this.format = format;
        this.sizeInMB = sizeInMB;
    }

    public String getFormat() {
        return format;
    }

    public int getSizeInMB() {
        return sizeInMB;
    }
}


