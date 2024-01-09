package com.nguyenduyanh.Service;

import com.nguyenduyanh.Model.ApartmentType;

import java.util.List;

public interface ApartmentTypeService {
    public void addApartmentType(ApartmentType apartmentType );

    public void updateApartmentType(ApartmentType apartmentType);

    public void deleteApartmentType(int idType);

    public ApartmentType getApartmentTypeById(int idType);

    public List<ApartmentType> getAllApartmentTypes();
}
