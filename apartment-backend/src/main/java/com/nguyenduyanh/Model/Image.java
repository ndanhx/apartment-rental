package com.nguyenduyanh.Model;

public class Image {
    private int idImage;
    private String nameImage;
    private String linkImage;
    private int idApartment;

    // Constructors, getters, and setters

    public Image() {
    }

    public Image(int idImage, String nameImage, String linkImage, int idApartment) {
        this.idImage = idImage;
        this.nameImage = nameImage;
        this.linkImage = linkImage;
        this.idApartment = idApartment;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idImage=" + idImage +
                ", nameImage='" + nameImage + '\'' +
                ", linkImage='" + linkImage + '\'' +
                ", idApartment=" + idApartment +
                '}';
    }
}
