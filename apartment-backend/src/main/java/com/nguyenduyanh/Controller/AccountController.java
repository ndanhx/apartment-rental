package com.nguyenduyanh.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyenduyanh.Model.Account;
import com.nguyenduyanh.Service.AccountService;
import com.nguyenduyanh.Service.Impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "accountController", urlPatterns = {"/account/*"})
public class AccountController extends HttpServlet {
    private ObjectMapper objectMapper;
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
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            List<Account> accounts = accountService.getAllAccounts();
            objectMapper.writeValue(response.getWriter(), accounts);

        } else if (pathInfo.equals("/get-account-lock")) {
            List<Account> accounts = accountService.getAccountLocked();
            objectMapper.writeValue(response.getWriter(), accounts);
        }else if (pathInfo.equals("/get-account-active")) {
            List<Account> accounts = accountService.getAccountActive();
            objectMapper.writeValue(response.getWriter(), accounts);
        }else if (pathInfo.equals("/get-account-verified")) {
            List<Account> accounts = accountService.getAccountVerified();
            objectMapper.writeValue(response.getWriter(), accounts);
        }else if (pathInfo.equals("/get-total-account-this-year")) {
            int totalAccountThisYear = accountService.totalAccountThisYear();
            objectMapper.writeValue(response.getWriter(), totalAccountThisYear);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            Account addAccount = objectMapper.readValue(request.getReader(), Account.class);
            Account accountCheck = accountService.checkUsername(addAccount.getUsername());
            if (accountCheck == null) {
                addAccount.setCreatedAt(new Date());
                accountService.addAccount(addAccount);
                response.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
            }
        } else if (pathInfo.equals("/login")) {
            Account accountCheckLogin = objectMapper.readValue(request.getReader(), Account.class);
            String username = accountCheckLogin.getUsername();
            String password = accountCheckLogin.getPassword();
            Account account = accountService.checkLogin(username, password);
            if (account != null) {
                Account accountLogged = accountService.getAccountById(account.getIdAccount());
                objectMapper.writeValue(response.getWriter(), accountLogged);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }

        } else if (pathInfo.equals("/logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (pathInfo.equals("/check-role-user")) {
            Account accountCheckLogin = objectMapper.readValue(request.getReader(), Account.class);
            String username = accountCheckLogin.getUsername();
            Account account = accountService.checkUsername(username);
            if (account != null) {
                Account accountLogged = accountService.getAccountById(account.getIdAccount());
                objectMapper.writeValue(response.getWriter(), accountLogged);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }else if (pathInfo.equals("/get-account-by-id")) {
            Account account = objectMapper.readValue(request.getReader(), Account.class);
            int idAccount = account.getIdAccount();
            Account account1 = accountService.getAccountById(idAccount);
            objectMapper.writeValue(response.getWriter(), account1);
        }  else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.equals("/")) {
            Account updateAccount = objectMapper.readValue(request.getReader(), Account.class);
            accountService.updateAccount(updateAccount);
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (pathInfo.equals("/active/lock")) {
            Account lockAccount = objectMapper.readValue(request.getReader(), Account.class);
            accountService.lockAccount(lockAccount);
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (pathInfo.equals("/active/unlock")) {
            Account lockAccount = objectMapper.readValue(request.getReader(), Account.class);
            accountService.unLockAccount(lockAccount);
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (pathInfo.equals("/do-verify")) {
            Account lockAccount = objectMapper.readValue(request.getReader(), Account.class);
            accountService.verifyAccount(lockAccount);
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (pathInfo.equals("/remove-verify")) {
            Account lockAccount = objectMapper.readValue(request.getReader(), Account.class);
            accountService.removeVerifiedAccount(lockAccount);
            response.setStatus(HttpServletResponse.SC_OK);
        }else if (pathInfo.equals("/update-account-but-admin")) {
            Account account = objectMapper.readValue(request.getReader(), Account.class);
            accountService.updateAccountButPassword(account);
            response.setStatus(HttpServletResponse.SC_OK);
        }else if (pathInfo.equals("/change-password")) {
            Account account = objectMapper.readValue(request.getReader(), Account.class);
           int check = accountService.changePassword(account);
           if (check > 0){
               response.setStatus(HttpServletResponse.SC_OK);
           }else {
               response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
           }

        } else {
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
            accountService.deleteAccount(id);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }


}
