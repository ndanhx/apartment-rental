package com.nguyenduyanh.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyenduyanh.Model.Account;
import com.nguyenduyanh.Model.Apartment;
import com.nguyenduyanh.Model.ApartmentType;
import com.nguyenduyanh.Model.PaymentReceipt;
import com.nguyenduyanh.Service.AccountService;
import com.nguyenduyanh.Service.ApartmentService;
import com.nguyenduyanh.Service.Impl.AccountServiceImpl;
import com.nguyenduyanh.Service.Impl.ApartmentServiceImpl;
import com.nguyenduyanh.Service.Impl.PaymentServiceImpl;
import com.nguyenduyanh.Service.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "apartmentController", urlPatterns = {"/apartment/*"})
public class ApartmentController extends HttpServlet {
    ObjectMapper objectMapper;
    private final ApartmentService apartmentService = new ApartmentServiceImpl();
    private final AccountService accountService = new AccountServiceImpl();
    private final PaymentService paymentService = new PaymentServiceImpl();

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
            List<Apartment> apartments = apartmentService.getAllApartments();
            objectMapper.writeValue(response.getWriter(), apartments);
        } else if ( pathInfo.equals("/apartment-posted")) {
            List<Apartment> apartments = apartmentService.getAllApartmentsPosted();
            objectMapper.writeValue(response.getWriter(), apartments);
        } else if (pathInfo.equals("/apartment-posted-limit-6")) {
            List<Apartment> apartments = apartmentService.getAllApartmentsPostedLimit6();
            objectMapper.writeValue(response.getWriter(), apartments);
        }else if (pathInfo.equals("/apartment-posted-limit-3-continue")) {
            int offset = Integer.parseInt(request.getParameter("offset")) ;
            List<Apartment> apartments = apartmentService.getAllApartmentsPostedLimit3Continue(offset);
            objectMapper.writeValue(response.getWriter(), apartments);
        } else if (pathInfo.equals("/apartment-pending")) {
            List<Apartment> apartments = apartmentService.getAllApartmentsPending();
            objectMapper.writeValue(response.getWriter(), apartments);
        } else if (pathInfo.equals("/apartment-sold")) {
            List<Apartment> apartments = apartmentService.getAllApartmentsSold();
            objectMapper.writeValue(response.getWriter(), apartments);
        } else if (pathInfo.equals("/apartment-active")) {
            List<Apartment> apartments = apartmentService.getAllApartmentsActive();
            objectMapper.writeValue(response.getWriter(), apartments);
        } else if (pathInfo.equals("/check-apartment-valid")) {
            apartmentService.checkApartmentValid();
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (pathInfo.equals("/get-total-listing-today")) {
            int totalListingToday = apartmentService.getTotalListingToday();
            objectMapper.writeValue(response.getWriter(), totalListingToday);
        } else if (pathInfo.equals("/get-top-5-listing")) {
            List<Apartment> apartments = apartmentService.getAllApartmentsTop5();
            objectMapper.writeValue(response.getWriter(), apartments);
        }
        else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            Apartment addApartment = objectMapper.readValue(request.getReader(), Apartment.class);
//            addApartment.setPostingDate(new Date());
//            addApartment.setEndDate(new Date());
            apartmentService.addApartment(addApartment);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else if (pathInfo.equals("/getApartment")) {
            Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
            Apartment apartmentById = apartmentService.getApartmentById(apartment.getIdApartment());
            objectMapper.writeValue(response.getWriter(), apartmentById);
        } else {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        switch (pathInfo) {

            case "/update-apartment":
                Apartment updateApartment = objectMapper.readValue(request.getReader(), Apartment.class);
                apartmentService.updateApartment(updateApartment);
                response.setStatus(HttpServletResponse.SC_CREATED);
                break;
            case "/update-active-apartment": { // update  active
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                apartmentService.activeApartment(apartment);
                response.setStatus(HttpServletResponse.SC_OK);
                break;
            }
            case "/update-sold-apartment": { // update  sold
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                apartmentService.soldApartment(apartment);
                response.setStatus(HttpServletResponse.SC_OK);
                break;
            }
            case "/accept-listing-apartment": { // update  sold
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                apartmentService.acceptListing(apartment);
                response.setStatus(HttpServletResponse.SC_OK);
                break;
            }

            case "/reject-listing-apartment": { // reject post listing
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                //double check account
                Account account = accountService.getAccountById(apartment.getIdAccount());
                if (account != null) {
                    try {
                        accountService.refundAccount(account);
                        PaymentReceipt paymentReceipt =new PaymentReceipt();
                        paymentReceipt.setTotalAmount(10000);
                        paymentReceipt.setPaymentMethod("Banking");
                        paymentReceipt.setStatus(1);
                        paymentReceipt.setIdAccount(account.getIdAccount());
                        paymentReceipt.setDescription("tai khoan +10,000VND do bai dang bi REJECT");
                        paymentService.addPaymentReceipt(paymentReceipt);
                        apartmentService.rejectListing(apartment);
                        response.setStatus(HttpServletResponse.SC_OK);
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                    }
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
                break;
            }
            case "/post-listing-apartment": { // update  post
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                //double check account amount
                Account account = accountService.getAccountById(apartment.getIdAccount());
                if (account.getAmount() >= 10000) {
                    try {
                        accountService.paymentAccount(account);

                        PaymentReceipt paymentReceipt =new PaymentReceipt();
                        paymentReceipt.setTotalAmount(-10000);
                        paymentReceipt.setPaymentMethod("Banking");
                        paymentReceipt.setStatus(1);
                        paymentReceipt.setIdAccount(account.getIdAccount());
                        paymentReceipt.setDescription("tai khoan -10,000VND thanh toan bai dang");
                        paymentService.addPaymentReceipt(paymentReceipt);

                        apartmentService.postListing(apartment);
                        response.setStatus(HttpServletResponse.SC_OK);
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                    }
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
                break;
            }
            case "/getApartment": {
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                Apartment apartmentById = apartmentService.getApartmentById(apartment.getIdApartment());
                objectMapper.writeValue(response.getWriter(), apartmentById);
                break;
            }
            case "/get-list-apartment-of-seller": {
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                List<Apartment> apartments = apartmentService.getAllApartmentsOfSeller(apartment.getIdAccount());
                objectMapper.writeValue(response.getWriter(), apartments);
                break;
            }
            case "/get-list-apartment-of-seller-posted": {
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                List<Apartment> apartments = apartmentService.getAllApartmentsOfSellerPosted(apartment.getIdAccount());
                objectMapper.writeValue(response.getWriter(), apartments);
                break;
            }
            case "/get-list-apartment-of-seller-pending": {
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                List<Apartment> apartments = apartmentService.getAllApartmentsOfSellerPending(apartment.getIdAccount());
                objectMapper.writeValue(response.getWriter(), apartments);
                break;
            }
            case "/get-list-apartment-of-seller-sold": {
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                List<Apartment> apartments = apartmentService.getAllApartmentsOfSellerSold(apartment.getIdAccount());
                objectMapper.writeValue(response.getWriter(), apartments);
                break;
            }
            case "/get-list-apartment-of-seller-active": {
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                List<Apartment> apartments = apartmentService.getAllApartmentsOfSellerActive(apartment.getIdAccount());
                objectMapper.writeValue(response.getWriter(), apartments);
                break;
            }
            case "/get-list-apartment-of-type": {
                ApartmentType apartmentType = objectMapper.readValue(request.getReader(), ApartmentType.class);
                List<Apartment> apartments = apartmentService.getAllApartmentsOfType(apartmentType);
                objectMapper.writeValue(response.getWriter(), apartments);
                break;
            }

            case "/update-heart": {
                Apartment apartment = objectMapper.readValue(request.getReader(), Apartment.class);
                apartmentService.updateHeart(apartment);
                response.setStatus(HttpServletResponse.SC_OK);
                break;
            }
            default:
                response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                break;
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

