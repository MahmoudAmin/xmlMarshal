package com.example.controllers;

/**
 * Created by mahmoud on 10/5/16.
 */
 public class Country {
    private Integer id;
    private String countryName;
    private String pmName;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getPmName() {
        return pmName;
    }
    public void setPmName(String pmName) {
        this.pmName = pmName;
    }
}
