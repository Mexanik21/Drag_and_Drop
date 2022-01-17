package com.example.draganddrop.madel;

public class Member {
    private String tv_item;

    public String getFirstName() {
        return tv_item;
    }

    public void setFirstName(String firstName) {
        this.tv_item = firstName;
    }

    public Member(String tv_item) {
        this.tv_item = tv_item;
    }
}