package com.nguyenduyanh.Service;

import com.nguyenduyanh.Model.Account;
import com.nguyenduyanh.Model.City;

import java.util.List;

public interface CityService {
    public List<City> getAllCities();

    public City getCityByID(int idCity);
}
