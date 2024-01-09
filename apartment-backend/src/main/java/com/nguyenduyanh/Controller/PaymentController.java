package com.nguyenduyanh.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyenduyanh.Model.Account;
import com.nguyenduyanh.Model.PaymentReceipt;
import com.nguyenduyanh.Service.AccountService;
import com.nguyenduyanh.Service.Impl.AccountServiceImpl;
import com.nguyenduyanh.Service.Impl.PaymentServiceImpl;
import com.nguyenduyanh.Service.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "paymentController", urlPatterns = {"/payment/*"})
public class PaymentController extends HttpServlet {
    private ObjectMapper objectMapper;
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
        String idAccountStr = request.getParameter("idAccount");
        String username = request.getParameter("username");
        Account account = new Account();
        account.setIdAccount(Integer.parseInt(idAccountStr));
        account.setUsername(username);
        Account findAccount = accountService.checkUsername(account.getUsername());
        request.setAttribute("account", findAccount);
        request.getRequestDispatcher("/vnpay_pay.jsp").forward(request, response);




    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (  pathInfo.equals("/get-list-payment-by-account")) {
            Account account = objectMapper.readValue(request.getReader(), Account.class);
            List<PaymentReceipt> paymentReceipts = paymentService.getAllPaymentReceiptsByAccountId(account);
            objectMapper.writeValue(response.getWriter(), paymentReceipts);
        }else if (  pathInfo.equals("/get-list-payment")) {
            List<PaymentReceipt> paymentReceipts = paymentService.getAllPaymentReceipts( );
            objectMapper.writeValue(response.getWriter(), paymentReceipts);
        }else if (  pathInfo.equals("/get-list-payment-today")) {
            List<PaymentReceipt> paymentReceipts = paymentService.getAllPaymentToday( );
            objectMapper.writeValue(response.getWriter(), paymentReceipts);
        }else if (  pathInfo.equals("/get-total-amount-this-month")) {
            int amount = paymentService.getRevenueThisMonth();
            objectMapper.writeValue(response.getWriter(), amount);
        }
        else if (pathInfo.equals("/get-list-payment-by-date")) {
            String startDate = request.getParameter("start");
            String endDate = request.getParameter("end");
            List<PaymentReceipt> paymentReceipts = paymentService.getAllPaymentByDate(startDate, endDate);
            objectMapper.writeValue(response.getWriter(), paymentReceipts);
        }
    }
}
