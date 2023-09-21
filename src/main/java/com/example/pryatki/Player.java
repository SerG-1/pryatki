package com.example.pryatki;

public class Player {
    Integer id;
    String nomer;
    String name;


    public Player(Integer id, String nomer, String name) {
        this.id = id;
        this.nomer = nomer;
        this.name = name;
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
