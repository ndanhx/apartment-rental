package com.nguyenduyanh.Model;


import java.util.Date;

public class Apartment {
    private int idApartment;
    private String title;
    private String nameApartment;
    private int room;
    private int baths;

    private int area;
    private int price;


    private String description;

    private int listingStatus; // 2: pending, 0:unPost, 1: posted
    private int rentalStatus; // 0: sold, 1: active

    private String streetName;
    private int idWard;

    private Date postingDate;
    private Date endDate;


    private int heartCount;

    private String img;
    private int idType;
    private int idAccount;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "idApartment=" + idApartment +
                ", title='" + title + '\'' +
                ", nameApartment='" + nameApartment + '\'' +
                ", room=" + room +
                ", baths=" + baths +
                ", area=" + area +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", listingStatus=" + listingStatus +
                ", rentalStatus=" + rentalStatus +
                ", streetName='" + streetName + '\'' +
                ", idWard=" + idWard +
                ", postingDate=" + postingDate +
                ", endDate=" + endDate +
                ", heartCount=" + heartCount +
                ", img='" + img + '\'' +
                ", idType=" + idType +
                ", idAccount=" + idAccount +
                '}';
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(int heartCount) {
        this.heartCount = heartCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }



    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    public String getNameApartment() {
        return nameApartment;
    }

    public void setNameApartment(String nameApartment) {
        this.nameApartment = nameApartment;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(int listingStatus) {
        this.listingStatus = listingStatus;
    }

    public int getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(int rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getIdWard() {
        return idWard;
    }

    public void setIdWard(int idWard) {
        this.idWard = idWard;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Apartment() {
    }
}
