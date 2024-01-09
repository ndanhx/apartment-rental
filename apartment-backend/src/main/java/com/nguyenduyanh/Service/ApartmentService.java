package com.nguyenduyanh.Service;

import com.nguyenduyanh.Model.Apartment;
import com.nguyenduyanh.Model.ApartmentType;

import java.util.List;

public interface ApartmentService {
    public List<Apartment> getAllApartments();
    public List<Apartment> getAllApartmentsPosted();
    public List<Apartment> getAllApartmentsPostedLimit6();
    public List<Apartment> getAllApartmentsPostedLimit3Continue(int offset);
    public List<Apartment> getAllApartmentsPending();
    public List<Apartment> getAllApartmentsSold();
    public List<Apartment> getAllApartmentsActive();
    public List<Apartment> getAllApartmentsTop5();

    public int getTotalListingToday();

    public List<Apartment> searchApartment(Apartment apartment);


    public List<Apartment> getAllApartmentsOfSeller(int idAccount);
    public List<Apartment> getAllApartmentsOfSellerPosted(int idAccount);
    public List<Apartment> getAllApartmentsOfSellerPending(int idAccount);
    public List<Apartment> getAllApartmentsOfSellerSold(int idAccount);
    public List<Apartment> getAllApartmentsOfSellerActive(int idAccount);

    public List<Apartment> getAllApartmentsOfType(ApartmentType apartmentType);

    public void addApartment(Apartment apartment);
    public void updateApartment(Apartment apartment);
    public void activeApartment(Apartment apartment);
    public void soldApartment(Apartment apartment);
    public void acceptListing(Apartment apartment);
    public void rejectListing(Apartment apartment);
    public void updateHeart(Apartment apartment);

    public void checkApartmentValid();

    public void postListing(Apartment apartment);
    public void deleteApartment(int apartmentId);


    public Apartment getApartmentById(int apartmentId);



}
