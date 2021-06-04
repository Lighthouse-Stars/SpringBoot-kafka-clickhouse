package com.example.lighthouse_project1.KafkaMessages;

public class MessageDao {
    private String names;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getBorn() {
        return location;
    }

    public void setBorn(String location) {
        this.location = location;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String location;
    private Integer ID;
}
