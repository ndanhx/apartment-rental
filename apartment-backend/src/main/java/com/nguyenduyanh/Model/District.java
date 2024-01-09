package com.nguyenduyanh.Model;
public class District {
    private int idDistrict;
    private String nameDistrict;
    private int idCity;

    // Constructors, getters, and setters

    public District() {
    }

    public District(int idDistrict, String nameDistrict, int idCity) {
        this.idDistrict = idDistrict;
        this.nameDistrict = nameDistrict;
        this.idCity = idCity;
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Override
    public String toString() {
        return "District{" +
                "idDistrict=" + idDistrict +
                ", nameDistrict='" + nameDistrict + '\'' +
                ", idCity=" + idCity +
                '}';
    }
}
