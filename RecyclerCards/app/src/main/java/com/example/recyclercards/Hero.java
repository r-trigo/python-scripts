package com.example.recyclercards;

/**
 * Created by Seksu on 01/07/2016.
 */
public class Hero {

    private int portrait;
    private String name;
    private String role;
    private String difficulty_level;

    public Hero () {
    };

    public Hero(int portrait, String name, String role, String difficulty_level) {
        this.portrait = portrait;
        this.name = name;
        this.role = role;
        this.difficulty_level = difficulty_level;
    }

    public int getPortrait() {
        return portrait;
    }

    public void setPortrait(int portrait) {
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }
}
