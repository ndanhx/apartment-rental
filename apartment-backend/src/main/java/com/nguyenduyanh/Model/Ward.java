package com.nguyenduyanh.Model;

public class Ward {
    private int idWard;
    private String nameWard;
    private int idDistrict;

    // Constructors, getters, and setters

    public Ward() {
    }

    public Ward(int idWard, String nameWard, int idDistrict) {
        this.idWard = idWard;
        this.nameWard = nameWard;
        this.idDistrict = idDistrict;
    }

    public int getIdWard() {
        return idWard;
    }

    public void setIdWard(int idWard) {
        this.idWard = idWard;
    }

    public String getNameWard() {
        return nameWard;
    }

    public void setNameWard(String nameWard) {
        this.nameWard = nameWard;
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    @Override
    public String toString() {
        return "Ward{" +
                "idWard=" + idWard +
                ", nameWard='" + nameWard + '\'' +
                ", idDistrict=" + idDistrict +
                '}';
    }
}
