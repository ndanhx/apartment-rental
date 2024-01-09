package com.nguyenduyanh.Model;


public class City {
    private int idCity;
    private String nameCity;

    // Constructors, getters, and setters

    public City() {
    }

    public City(int idCity, String nameCity) {
        this.idCity = idCity;
        this.nameCity = nameCity;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", nameCity='" + nameCity + '\'' +
                '}';
    }
}