package com.nguyenduyanh.Model;

public class ApartmentType {
    private int idType;
    private String nameType;

    // Constructors
    public ApartmentType() {
    }

    public ApartmentType(String nameType) {
        this.nameType = nameType;
    }

    // Getters and Setters
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public String toString() {
        return "ApartmentType [idType=" + idType + ", nameType=" + nameType + "]";
    }
}
