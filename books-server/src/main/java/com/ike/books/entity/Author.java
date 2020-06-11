package com.ike.books.entity;

import javax.persistence.*;

@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorid;

    @Column
    private String authorname;

	public Author() {
    	
    }
    
	public Author(String title, String author_name) {
		super();
		this.authorname = author_name;
	}
	
    public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}


 
}
