package com.nguyenduyanh.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyenduyanh.Model.City;
import com.nguyenduyanh.Model.District;
import com.nguyenduyanh.Model.Ward;
import com.nguyenduyanh.Service.CityService;
import com.nguyenduyanh.Service.DistrictService;
import com.nguyenduyanh.Service.Impl.CityServiceImpl;
import com.nguyenduyanh.Service.Impl.DistrictServiceImpl;
import com.nguyenduyanh.Service.Impl.WardServiceImpl;
import com.nguyenduyanh.Service.WardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "addressController", urlPatterns = {"/address/*"})

public class AddressController extends HttpServlet {

    private ObjectMapper objectMapper;
    private final CityService cityService = new CityServiceImpl();
    private final DistrictService districtService = new DistrictServiceImpl();
    private final WardService wardService = new WardServiceImpl();

    @Override
    public void init() throws ServletException {
        super.init();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (pathInfo.equals("/city")) {
            List<City> cities = cityService.getAllCities();
            objectMapper.writeValue(response.getWriter(), cities);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }


    public String getAddressByIdWard(int idWard) {
        String nameWard = null;
        String nameDistrict = null;
        String nameCity = null;

        try {
            Ward ward = wardService.getWardByID(idWard);
            nameWard = ward.getNameWard();

            District district = districtService.getDistrictById(ward.getIdDistrict());
            nameDistrict = district.getNameDistrict();

            City city = cityService.getCityByID(district.getIdCity());
            nameCity = city.getNameCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameWard + ", " + nameDistrict + ", " + nameCity;
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (pathInfo.equals("/district")) {
            District district = objectMapper.readValue(request.getReader(), District.class);
            List<District> districts = districtService.getAllDistrictByCity(district.getIdCity());
            objectMapper.writeValue(response.getWriter(), districts);
        } else if (pathInfo.equals("/ward")) {
            Ward ward = objectMapper.readValue(request.getReader(), Ward.class);
            List<Ward> wards = wardService.getAllWardsByDistrict(ward.getIdDistrict());
            objectMapper.writeValue(response.getWriter(), wards);
        } else if (pathInfo.equals("/get-address")) {
            Ward ward = objectMapper.readValue(request.getReader(), Ward.class);
            String address = getAddressByIdWard(ward.getIdWard());
            objectMapper.writeValue(response.getWriter(), address);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }
    }

}


