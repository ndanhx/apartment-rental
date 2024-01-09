package com.nguyenduyanh.Service;

import com.nguyenduyanh.Model.Account;
import com.nguyenduyanh.Model.PaymentReceipt;

import java.util.Date;
import java.util.List;

public interface PaymentService {
    public List<PaymentReceipt> getAllPaymentReceipts();
    public List<PaymentReceipt> getAllPaymentReceiptsByAccountId(Account account);

    public List<PaymentReceipt> getAllPaymentToday( );

    public List<PaymentReceipt> getAllPaymentByDate(String startDate, String endDate);


    public int getRevenueThisMonth();


    public void addPaymentReceipt(PaymentReceipt paymentReceipt);
    public void deletePaymentReceipt(int paymentId) ;
}
