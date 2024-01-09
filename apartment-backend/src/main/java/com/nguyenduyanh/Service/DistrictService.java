package com.nguyenduyanh.Service;

import com.nguyenduyanh.Model.District;

import java.util.List;

public interface DistrictService {
    public District getDistrictById(int idDistrict);

    public List<District> getAllDistrictByCity(int IdCity);


}
