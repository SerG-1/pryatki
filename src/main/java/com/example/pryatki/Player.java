package com.example.pryatki;

public class Player {
    Integer id;
    String nomer;
    String name;
    Integer points = 0;


    public Player() {

    }
    public Player(Integer id, String nomer, String name) {
        this.id = id;
        this.nomer = nomer;
        this.name = name;
    }

    public Player(String name, Integer points) {
        this.name = name;
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
