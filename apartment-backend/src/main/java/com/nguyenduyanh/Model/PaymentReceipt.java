package com.nguyenduyanh.Model;

import java.util.Date;

public class PaymentReceipt {
    private int idPayment;
    private Date paymentDate;
    private String paymentMethod;
    private long totalAmount;
    private String description;
    private int status;
    private int idAccount;

    // Constructors, getters, and setters

    public PaymentReceipt() {
    }


    @Override
    public String toString() {
        return "PaymentReceipt{" +
                "idPayment=" + idPayment +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalAmount=" + totalAmount +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", idAccount=" + idAccount +
                '}';
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public PaymentReceipt(int idPayment, Date paymentDate, String paymentMethod, long totalAmount, String description, int status, int idAccount) {
        this.idPayment = idPayment;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.description = description;
        this.status = status;
        this.idAccount = idAccount;
    }
}
