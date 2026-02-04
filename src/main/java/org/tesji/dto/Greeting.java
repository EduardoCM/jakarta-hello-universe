package org.tesji.dto;

import java.sql.Timestamp;

public class Greeting {

	private int id;
    private String name;
    private Timestamp createdAt;

    public Greeting(int id, String name, Timestamp createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
	}

	public String getName() {
        return name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
