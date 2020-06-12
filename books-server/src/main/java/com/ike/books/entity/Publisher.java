package com.ike.books.entity;

import javax.persistence.*;

@Entity
@Table(name = "Publishers")
public class Publisher {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherid;
    
    @Column
    private String publishername;

    public Publisher() {
    	
    }
    
	public Publisher(String publishername) {
		super();
		this.publishername = publishername;
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
