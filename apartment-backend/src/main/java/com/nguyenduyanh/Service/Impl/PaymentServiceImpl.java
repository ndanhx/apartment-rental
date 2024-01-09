package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.Account;
import com.nguyenduyanh.Model.City;
import com.nguyenduyanh.Model.PaymentReceipt;
import com.nguyenduyanh.Service.CityService;
import com.nguyenduyanh.Service.PaymentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    private void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<PaymentReceipt> getAllPaymentReceipts() {
        List<PaymentReceipt> paymentReceipts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PaymentReceipt";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PaymentReceipt paymentReceipt = new PaymentReceipt();
                paymentReceipt.setIdPayment(resultSet.getInt("id_payment"));
                paymentReceipt.setPaymentDate(resultSet.getDate("payment_date"));
                paymentReceipt.setPaymentMethod(resultSet.getString("payment_method"));
                paymentReceipt.setTotalAmount(resultSet.getLong("total_amount"));
                paymentReceipt.setDescription(resultSet.getString("description"));
                paymentReceipt.setStatus(resultSet.getInt("status"));
                paymentReceipt.setIdAccount(resultSet.getInt("id_account"));
                paymentReceipts.add(paymentReceipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return paymentReceipts;
    }

    @Override
    public List<PaymentReceipt> getAllPaymentReceiptsByAccountId(Account account) {
        List<PaymentReceipt> paymentReceipts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PaymentReceipt WHERE id_account=?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getIdAccount());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PaymentReceipt paymentReceipt = new PaymentReceipt();
                paymentReceipt.setIdPayment(resultSet.getInt("id_payment"));
                paymentReceipt.setPaymentDate(resultSet.getDate("payment_date"));
                paymentReceipt.setPaymentMethod(resultSet.getString("payment_method"));
                paymentReceipt.setTotalAmount(resultSet.getLong("total_amount"));
                paymentReceipt.setDescription(resultSet.getString("description"));
                paymentReceipt.setStatus(resultSet.getInt("status"));
                paymentReceipt.setIdAccount(resultSet.getInt("id_account"));
                paymentReceipts.add(paymentReceipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return paymentReceipts;
    }

    @Override
    public List<PaymentReceipt> getAllPaymentToday() {
        List<PaymentReceipt> paymentReceipts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PaymentReceipt WHERE DATE(payment_date) = CURDATE();";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PaymentReceipt paymentReceipt = new PaymentReceipt();
                paymentReceipt.setIdPayment(resultSet.getInt("id_payment"));
                paymentReceipt.setPaymentDate(resultSet.getDate("payment_date"));
                paymentReceipt.setPaymentMethod(resultSet.getString("payment_method"));
                paymentReceipt.setTotalAmount(resultSet.getLong("total_amount"));
                paymentReceipt.setDescription(resultSet.getString("description"));
                paymentReceipt.setStatus(resultSet.getInt("status"));
                paymentReceipt.setIdAccount(resultSet.getInt("id_account"));
                paymentReceipts.add(paymentReceipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return paymentReceipts;
    }

    @Override
    public List<PaymentReceipt> getAllPaymentByDate(String startDate,String endDate) {
        List<PaymentReceipt> paymentReceipts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PaymentReceipt WHERE payment_date BETWEEN ? AND ?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, startDate);
            preparedStatement.setString(2, endDate);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PaymentReceipt paymentReceipt = new PaymentReceipt();
                paymentReceipt.setIdPayment(resultSet.getInt("id_payment"));
                paymentReceipt.setPaymentDate(resultSet.getDate("payment_date"));
                paymentReceipt.setPaymentMethod(resultSet.getString("payment_method"));
                paymentReceipt.setTotalAmount(resultSet.getLong("total_amount"));
                paymentReceipt.setDescription(resultSet.getString("description"));
                paymentReceipt.setStatus(resultSet.getInt("status"));
                paymentReceipt.setIdAccount(resultSet.getInt("id_account"));
                paymentReceipts.add(paymentReceipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return paymentReceipts;

    }





    @Override
    public int getRevenueThisMonth() {
        int totalAmount = 0;
        try {
            String sql = "SELECT SUM(total_amount) AS total_amount " +
                    "FROM PaymentReceipt " +
                    "WHERE MONTH(payment_date) = MONTH(CURDATE()) " +
                    "AND YEAR(payment_date) = YEAR(CURDATE()) " +
                    "AND status = 1 AND total_amount >0";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalAmount = resultSet.getInt("total_amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return totalAmount;
    }

    @Override
    public void addPaymentReceipt(PaymentReceipt paymentReceipt) {
        try {
            paymentReceipt.setPaymentDate(new java.util.Date());
            paymentReceipt.setStatus(1);
            paymentReceipt.setPaymentMethod("Banking");
            String sql = "INSERT INTO PaymentReceipt (payment_date, payment_method, total_amount, description, status, id_account) VALUES (?, ?, ?, ?, ?, ?)";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, new java.sql.Date(paymentReceipt.getPaymentDate().getTime()));
            preparedStatement.setString(2, paymentReceipt.getPaymentMethod());
            preparedStatement.setLong(3, paymentReceipt.getTotalAmount());
            preparedStatement.setString(4, paymentReceipt.getDescription());
            preparedStatement.setInt(5, paymentReceipt.getStatus());
            preparedStatement.setInt(6, paymentReceipt.getIdAccount());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void deletePaymentReceipt(int paymentId) {

    }
}
