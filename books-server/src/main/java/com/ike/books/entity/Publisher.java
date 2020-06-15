package com.ike.books.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Publishers")
public class Publisher {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherid;
    
    @Column
    @NotNull
    private String publishername;

    public Publisher() {
    	
    }
    
	public Publisher(int id, String publishername) {
		super();
		this.publishername = publishername;
		this.publisherid = id;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publisher) {
		this.publishername = publisher;
	}

	public int getPublihserid() {
		return publisherid;
	}

	public void setPublisherid(int publisherid) {
		this.publisherid = publisherid;
	}
    
 
}
