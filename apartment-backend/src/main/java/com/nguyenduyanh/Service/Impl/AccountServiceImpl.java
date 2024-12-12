package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.DAO.EncryptSHA;
import com.nguyenduyanh.Model.Account;
import com.nguyenduyanh.Service.AccountService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final EncryptSHA encryptSHA = new EncryptSHA();

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                accounts.add(mapResultSetToAccount(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    private void setAccountToPreparedStatement(PreparedStatement preparedStatement, Account account) throws SQLException {
        preparedStatement.setString(1, account.getUsername());
        preparedStatement.setString(2, account.getPassword());
        preparedStatement.setString(3, account.getName());
        preparedStatement.setString(4, account.getPhone());
        preparedStatement.setString(5, account.getEmail());
        preparedStatement.setLong(6, account.getAmount());
        preparedStatement.setInt(7, account.getRole());
        preparedStatement.setInt(8, account.getIsActive());
        preparedStatement.setDate(9, new java.sql.Date(account.getCreatedAt().getTime()));
        preparedStatement.setInt(10, account.getVerify());
        preparedStatement.setString(11, account.getImage());
    }


    @Override
    public void addAccount(Account account) {
        String sql = "INSERT INTO Account (username, password, name, phone, email, amount, role, is_active, create_at, verify, image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            account.setPassword(encryptSHA.encryptSHA(account.getPassword()));
            setAccountToPreparedStatement(preparedStatement, account);
            preparedStatement.setInt(8, 1); // is_active
            preparedStatement.setInt(10, 0); // verify
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "UPDATE Account SET username=?, password=?, name=?, phone=?, email=?, amount=?, role=?, is_active=?, create_at=?, verify=?, image=? WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setAccountToPreparedStatement(preparedStatement, account);
            preparedStatement.setInt(12, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccountButPassword(Account account) {
        String sql = "UPDATE Account SET name=?, phone=?, email=? WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getPhone());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setInt(4, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int changePassword(Account account) {
        String sql = "UPDATE Account SET password=? WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, encryptSHA.encryptSHA(account.getPassword().trim()));
            preparedStatement.setInt(2, account.getIdAccount());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void deleteAccount(int accountId) {
        String sql = "DELETE FROM Account WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccountById(int accountId) {
        String sql = "SELECT * FROM Account WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToAccount(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account checkLogin(String username, String password) {
        String sql = "SELECT * FROM Account WHERE username=? AND password=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encryptSHA.encryptSHA(password));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToAccount(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account checkUsername(String username) {
        String sql = "SELECT * FROM Account WHERE username=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToAccount(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void lockAccount(Account account) {
        updateAccountActiveStatus(account.getIdAccount(), 0);
    }

    @Override
    public void unLockAccount(Account account) {
        updateAccountActiveStatus(account.getIdAccount(), 1);
    }

    @Override
    public void verifyAccount(Account account) {
        updateAccountVerifyStatus(account.getIdAccount(), 1);
    }

    @Override
    public void removeVerifiedAccount(Account account) {
        updateAccountVerifyStatus(account.getIdAccount(), 0);
    }

    @Override
    public void paymentAccount(Account account) {
        updateAccountAmount(account.getIdAccount(), -10000);
    }

    @Override
    public void refundAccount(Account account) {
        updateAccountAmount(account.getIdAccount(), 10000);
    }

    @Override
    public int successPayment(Account account, int amount) {
        String sql = "UPDATE Account SET amount=amount+? WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, amount);
            preparedStatement.setInt(2, account.getIdAccount());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int totalAccountThisYear() {
        String sql = "SELECT COUNT(*) AS total_count FROM Account WHERE YEAR(create_at) = ?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            preparedStatement.setInt(1, currentYear);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("total_count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Account> getAccountLocked() {
        return getAccountsByActiveStatus(0);
    }

    @Override
    public List<Account> getAccountActive() {
        return getAccountsByActiveStatus(1);
    }

    @Override
    public List<Account> getAccountVerified() {
        String sql = "SELECT * FROM Account WHERE verify=1";
        return getAccountsByCondition(sql);
    }

    private List<Account> getAccountsByActiveStatus(int isActive) {
        String sql = "SELECT * FROM Account WHERE is_active=?";
        return getAccountsByCondition(sql, isActive);
    }

    private List<Account> getAccountsByCondition(String sql, Object... params) {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    accounts.add(mapResultSetToAccount(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    private void updateAccountActiveStatus(int accountId, int isActive) {
        String sql = "UPDATE Account SET is_active=? WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, isActive);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateAccountVerifyStatus(int accountId, int verify) {
        String sql = "UPDATE Account SET verify=? WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, verify);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateAccountAmount(int accountId, int amountChange) {
        String sql = "UPDATE Account SET amount=amount+? WHERE id_account=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, amountChange);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Account mapResultSetToAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setIdAccount(resultSet.getInt("id_account"));
        account.setUsername(resultSet.getString("username"));
        account.setPassword(resultSet.getString("password"));
        account.setName(resultSet.getString("name"));
        account.setPhone(resultSet.getString("phone"));
        account.setEmail(resultSet.getString("email"));
        account.setAmount(resultSet.getLong("amount"));
        account.setRole(resultSet.getInt("role"));
        account.setIsActive(resultSet.getInt("is_active"));
        account.setCreatedAt(resultSet.getDate("create_at"));
        account.setVerify(resultSet.getInt("verify"));
        account.setImage(resultSet.getString("image"));
        return account;
    }
}
