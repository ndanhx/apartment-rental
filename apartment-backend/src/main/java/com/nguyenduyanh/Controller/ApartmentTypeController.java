package com.nguyenduyanh.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyenduyanh.Service.*;
import com.nguyenduyanh.Model.ApartmentType;
import com.nguyenduyanh.Service.Impl.ApartmentTypeServiceImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "apartmentTypeController", urlPatterns = {"/type/*"})

public class ApartmentTypeController extends HttpServlet {
    ObjectMapper objectMapper;
    private final ApartmentTypeService apartmentTypeService = new ApartmentTypeServiceImpl();

    @Override
    public void init() throws ServletException {
        super.init();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        request.setCharacterEncoding("UTF-8");
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            List<ApartmentType> apartmentTypes = apartmentTypeService.getAllApartmentTypes();
            objectMapper.writeValue(response.getWriter(), apartmentTypes);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            ApartmentType addApartmentType = objectMapper.readValue(request.getReader(), ApartmentType.class);
            apartmentTypeService.addApartmentType(addApartmentType);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else if (pathInfo.equals("/get-type-by-id")) {
            ApartmentType apartmentType = objectMapper.readValue(request.getReader(), ApartmentType.class);
            ApartmentType apartmentTypeById = apartmentTypeService.getApartmentTypeById(apartmentType.getIdType());
            objectMapper.writeValue(response.getWriter(), apartmentTypeById);
        } else {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        }
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            int id = Integer.parseInt(pathInfo.substring(1));
            apartmentTypeService.deleteApartmentType(id);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
