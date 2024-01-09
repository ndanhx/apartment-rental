package com.nguyenduyanh.Controller.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyenduyanh.Model.Account;
import com.nguyenduyanh.Model.Apartment;
import com.nguyenduyanh.Service.AccountService;
import com.nguyenduyanh.Service.ApartmentService;
import com.nguyenduyanh.Service.Impl.AccountServiceImpl;
import com.nguyenduyanh.Service.Impl.ApartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "filterController", urlPatterns = {"/apartment/search"})
public class filterController extends HttpServlet {
    ObjectMapper objectMapper;
    private final ApartmentService apartmentService = new ApartmentServiceImpl();
    private final AccountService accountService = new AccountServiceImpl();

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
        try {
            Apartment apartment = new Apartment();
            String keyword = request.getParameter("keyword");
            int room = Integer.parseInt( request.getParameter("room"));
            int bath = Integer.parseInt(request.getParameter("bath"));
            int minPrice = Integer.parseInt(request.getParameter("minPrice")) ;
            int idWard = Integer.parseInt(request.getParameter("idWard")) ;
            int idType = Integer.parseInt(request.getParameter("idType")) ;

            apartment.setNameApartment(keyword.trim());
            apartment.setTitle(keyword.trim());
            apartment.setRoom(room);
            apartment.setBaths(bath);
            apartment.setPrice(minPrice);
            apartment.setIdWard(idWard);
            apartment.setIdType(idType);
            List<Apartment> apartments = apartmentService.searchApartment(apartment);
            objectMapper.writeValue(response.getWriter(), apartments);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }




    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            int id = Integer.parseInt(pathInfo.substring(1));
            apartmentService.deleteApartment(id);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        }
    }
}

