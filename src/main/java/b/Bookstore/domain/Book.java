package b.Bookstore.domain;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int pub_year;
	private int isbn;
	private double price;
	
	 @ManyToOne
	 @JsonIgnoreProperties ("books") 
	    @JoinColumn(name = "categoryId")
	    private Category category;

	
	public int getPub_year() {
		return pub_year;
	}
	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return pub_year;
	}
	public void setYear(int year) {
		this.pub_year = year;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", pub_year=" + pub_year + ", isbn="
				+ isbn + ", price=" + price + ", category=" + category + "]";
	}
	public Book(String title, String author, int year, int isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.pub_year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.pub_year = 0;
		this.isbn = 0;
		this.price = 0.0;
		this.category = null;
	}
	
	
	
	
	

}
