package il.ac.hit.mvcdemo.model;

public class Product {
    int isbn;
    String title;
    double price;
    public Product(int isbn, String title, double price) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
