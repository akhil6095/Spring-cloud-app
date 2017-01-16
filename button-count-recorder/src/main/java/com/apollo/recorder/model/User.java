package com.apollo.recorder.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;
    private final String userName;
    private int count;

    public User(final String userName) {
	this.userName = userName;
    }

    public String getId() {
	return id;
    }

    public String getUserName() {
	return userName;
    }

    public void setCount(final int count) {
	this.count = count;
    }

    public int getCount() {
	return count;
    }

}
