package com.example.pryatki;

public class Player1 {
    Integer id;
    String nomer;
    String name;
    Integer points = 0;

    public Player1() {

    }
    public Player1(Integer id, String nomer, String name) {
        this.id = id;
        this.nomer = nomer;
        this.name = name;
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
