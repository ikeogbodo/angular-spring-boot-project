package com.ike.books.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorid;

    @Column
    @NotNull
    private String authorname;

	public Author() {
    	
    }
    
	public Author(int id, String author_name) {
		super();
		this.authorname = author_name;
		this.authorid = id;
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
