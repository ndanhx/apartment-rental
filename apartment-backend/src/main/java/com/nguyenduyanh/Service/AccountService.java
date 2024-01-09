package com.nguyenduyanh.Service;

import com.nguyenduyanh.Model.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAllAccounts();

    public void addAccount(Account account);
    public void updateAccount(Account account);
    public void updateAccountButPassword(Account account);
    public int changePassword(Account account);

    public void deleteAccount(int accountId);
    public Account getAccountById(int accountId);

    public Account checkLogin(String username, String password);


    public Account checkUsername(String username);

    public void lockAccount(Account account);

    public void unLockAccount(Account account);
    public void verifyAccount(Account account);
    public void removeVerifiedAccount(Account account);


    public void paymentAccount(Account account);
    public void refundAccount(Account account);
    public int successPayment(Account account, int amount);

    public int totalAccountThisYear();

    public List<Account> getAccountLocked();
    public List<Account> getAccountActive();
    public List<Account> getAccountVerified();






}
