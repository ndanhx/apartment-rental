package com.nguyenduyanh.Service;

import com.nguyenduyanh.Model.District;
import com.nguyenduyanh.Model.Ward;

import java.util.List;

public interface WardService {
    public List<Ward> getAllWardsByDistrict(int idDistrict);

    public List<Ward> getAllWards();


    public Ward getWardByID( int idWard );
}
