package com.ike.books.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;
    
    @Column(unique = true)
    private String title;

    @Column
    private int author;
    
    @Column
    private int publisher;
    
    @ManyToOne
    @JoinColumn(name = "authorid", nullable = false)
    @JsonIgnoreProperties("authors")
    private Author authors;
    
    @ManyToOne
    @JoinColumn(name = "publisherid", nullable = false)
    @JsonIgnoreProperties("publishers")
    private Publisher publishers;
    
	@Column
	@Temporal(TemporalType.DATE)
    private Date publisheddate;
    
    @Column
    private int pages;
    
    public Book(int bookid, String title, Author author, Publisher publisher, Date publisheddate, int pages) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.authors = author;
		this.publishers = publisher;
		this.publisheddate = publisheddate;
		this.pages = pages;
	}

	public Book() {
    	
    }  

    public int getBookid() {
		return bookid;
	}


	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthors() {
		return authors;
	}

	public void setAuthors(Author authors) {
		this.authors = authors;
	}

	public Publisher getPublishers() {
		return publishers;
	}

	public void setPublishers(Publisher publishers) {
		this.publishers = publishers;
	}

	public Date getPublisheddate() {
		return publisheddate;
	}

	public void setPublisheddate(Date publisheddate) {
		this.publisheddate = publisheddate;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getPublisher() {
		return publisher;
	}

	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}

}
