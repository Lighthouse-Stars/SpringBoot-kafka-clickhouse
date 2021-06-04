package com.example.lighthouse_project1.clickhouseController;

public class Dept {

    private Integer id;
    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Dept() {

    }

    public Dept(String name, Integer id, String location) {
        this.name =  name;
        this.id = id;
        this.location = location;
    }

}
