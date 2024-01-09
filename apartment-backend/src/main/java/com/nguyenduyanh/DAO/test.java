package com.nguyenduyanh.DAO;


import com.nguyenduyanh.Model.*;
import com.nguyenduyanh.Service.*;
import com.nguyenduyanh.Service.Impl.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test {

    static Account account = new Account();
    static List<Account> accounts;
    static AccountService accountService = new AccountServiceImpl();
    static ApartmentService apartmentService = new ApartmentServiceImpl();
    static  PaymentService paymentService =new PaymentServiceImpl();


    public static void main(String[] args) {

//        EncryptSHA encryptSHA = new EncryptSHA();
//        String out = encryptSHA.encryptSHA("seller");
//           System.out.println(out);


//        checkusername();
//        getallaccount();
//        Apartment();
//        checklogin();

//        getallcity();
//        getAllDistrictByCity(64);

//        getAllWardByDistrict(13);

//        listing();
//        setAccount();
//        setType();\getAbySeller
//        getAbySeller();

//    countAccount()  ;

//        getReceipt();

//        gettotalAmountThisMonth();

//        getPaymentDate();
    }


    public static void Apartment() {
        ApartmentService apartmentService = new ApartmentServiceImpl();

        // Test getAllApartments
        List<Apartment> allApartments = apartmentService.getAllApartments();
        System.out.println("All Apartments:");
        for (Apartment apartment : allApartments) {
            System.out.println(apartment.toString());
        }

        System.out.println("=============================");
//        System.out.println("ADD Apartment");
//
//        Apartment apartment = new Apartment();
//        apartment.setNameApartment("Apartment");
//        apartment.setRoom(1);
//        apartment.setBaths(2);
//        apartment.setPrice(1000);
//        apartment.setTypeApartment("House");
//        apartment.setDescription("Beautiful");
//        apartment.setListingStatus(1);
//        apartment.setRentalStatus(1);
//        apartment.setStreetName("Dien Bien Phu");
//        apartment.setIdWard(13);
//        apartment.setIdAccount(1);
//
//        apartmentService.addApartment(apartment);


        // Test getApartmentById
        Apartment retrievedApartment = apartmentService.getApartmentById(22);
        if (retrievedApartment != null) {
            System.out.println("GET APARTMENT BY ID:");
            System.out.println(retrievedApartment.toString());
            System.out.println("============================");
            apartmentService.updateApartment(retrievedApartment);
            System.out.println("Apartment updated successfully.");
        } else {
            System.out.println("Apartment retrieval by ID failed.");
        }
    }

    public static void getallaccount() {
        accounts = accountService.getAllAccounts();
        for (Account account1 : accounts) {
            System.out.println(account1);
        }
    }

    public static void checklogin() {
        account = accountService.checkLogin("duyanh", "duyanh");
        System.out.printf(account.toString());

    }

    public static void checkusername() {
        account = accountService.checkUsername("duyanh");
        System.out.printf(account.toString());

    }


    public static void getallcity() {
        CityService cityService = new CityServiceImpl();
        List<City> cities = cityService.getAllCities();
        for (City city : cities) {
            System.out.println(city.toString() + "\n");
        }
    }

    public static void getAllDistrictByCity(int idCity) {
        DistrictService districtService = new DistrictServiceImpl();
        List<District> districts = districtService.getAllDistrictByCity(idCity);
        for (District district : districts) {
            System.out.println(district.toString() + "\n");
        }
    }

    public static void getAllWardByDistrict(int idDistrict) {
        WardService wardService = new WardServiceImpl();
        List<Ward> wards = wardService.getAllWardsByDistrict(idDistrict);
        for (Ward ward : wards) {
            System.out.println(ward.toString() + "\n");
        }
    }

    public static void setAccount() {

            Account newAccount = new Account();
            newAccount.setUsername("sssss");
            newAccount.setPassword("duyanh");
            newAccount.setName("check en "  );
            newAccount.setPhone("0987654321");
            newAccount.setEmail("user@gmail.com");
            newAccount.setAmount(0);
            newAccount.setRole(1);
            newAccount.setIsActive(1);
            newAccount.setCreatedAt(new Date());
            newAccount.setVerify(0);
            accountService.addAccount(newAccount);
        }


    public static void setType() {
        ApartmentTypeService apartmentTypeService = new ApartmentTypeServiceImpl();
        ApartmentType apartmentType = new ApartmentType();
        apartmentType.setNameType("House");
        apartmentTypeService.addApartmentType(apartmentType);
        apartmentType.setNameType("Single");
        apartmentTypeService.addApartmentType(apartmentType);
        apartmentType.setNameType("Relationship");
        apartmentTypeService.addApartmentType(apartmentType);

    }

    public static void getAbySeller() {
        List<Apartment> apartmentList = apartmentService.getAllApartmentsOfSeller(1);
        System.out.println(apartmentList);
    }


    public static void countAccount() {
        int newAccount = accountService.totalAccountThisYear();
        System.out.println("total: " + newAccount );
    }

    public static void getReceipt() {
        account = new Account();
        account.setIdAccount(1);
        List<PaymentReceipt> paymentReceipts = paymentService.getAllPaymentReceiptsByAccountId(account);
        for (PaymentReceipt paymentReceipt : paymentReceipts){
            System.out.println(paymentReceipt.toString());
        }

    }
    public static void gettotalAmountThisMonth() {
        int t = paymentService.getRevenueThisMonth();
        System.out.println(">>>>>: "+t);
    }

    public static void getPaymentDate() {
        List<PaymentReceipt> paymentReceipts = paymentService.getAllPaymentByDate("2023-09-10", "2023-09-14");
        System.out.println(paymentReceipts);
    }


}
