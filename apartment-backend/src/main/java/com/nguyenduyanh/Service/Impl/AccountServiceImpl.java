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

    EncryptSHA encryptSHA = new EncryptSHA();

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Account";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return accounts;
    }

    @Override
    public void addAccount(Account account) {
        String encryptPassword = encryptSHA.encryptSHA(account.getPassword());
        account.setPassword(encryptPassword);
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO Account (username, password, name, phone, email, amount, role, is_active, create_at, verify, image) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getName());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setLong(6, account.getAmount());
            preparedStatement.setInt(7, account.getRole()); //role
            preparedStatement.setInt(8, 1); //active
            preparedStatement.setDate(9, new java.sql.Date(account.getCreatedAt().getTime()));
            preparedStatement.setInt(10, 0); //verify
            preparedStatement.setString(11, account.getImage()); //image
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }


    @Override
    public void updateAccount(Account account) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET username=?, password=?, name=?, phone=?, email=?, amount=?, role=?, is_active=?, create_at=?, verify=?, image=? WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
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
            preparedStatement.setInt(12, account.getIdAccount()); // Sử dụng id của tài khoản để xác định tài khoản cần cập nhật
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public void updateAccountButPassword(Account account) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET  name=?, phone=?, email=? WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getPhone());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setInt(4, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public int changePassword(Account account) {
        int check = -1;
        String enPassword = new EncryptSHA().encryptSHA(account.getPassword().trim());
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET  password=? WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, enPassword);
            preparedStatement.setInt(2, account.getIdAccount());
             check = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            check = -1;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                check = -1;
            }
        }
        return check;
    }


    @Override
    public void deleteAccount(int accountId) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM Account WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public Account getAccountById(int accountId) {
        Account account = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Account WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account();
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return account;
    }

    @Override
    public Account checkLogin(String username, String password) {
        String encryptPassword = encryptSHA.encryptSHA(password);
        Account account = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Account WHERE username=? AND password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encryptPassword);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account();
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return account;
    }


    @Override
    public Account checkUsername(String username) {
        Account account = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Account WHERE username=? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account();
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return account;
    }

    @Override
    public void lockAccount(Account account) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET  is_active=?  WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public void unLockAccount(Account account) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET  is_active=?  WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public void verifyAccount(Account account) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET verify=1 WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public void removeVerifiedAccount(Account account) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET verify=0 WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public void paymentAccount(Account account) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET  amount=amount-10000  WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public void refundAccount(Account account) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET  amount=amount+10000  WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public int successPayment(Account account, int amount) {
        int check = -1;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET  amount=amount+?  WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, amount);
            preparedStatement.setInt(2, account.getIdAccount());
            check = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return check;
    }

    @Override
    public int totalAccountThisYear() {
        int totalCount = 0;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT COUNT(*) AS total_count FROM Account WHERE YEAR(create_at) = ?";
            preparedStatement = connection.prepareStatement(sql);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            preparedStatement.setInt(1, currentYear);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalCount = resultSet.getInt("total_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return totalCount;
    }

    @Override
    public List<Account> getAccountLocked() {
        List<Account> accounts = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Account WHERE is_active =0";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return accounts;
    }

    @Override
    public List<Account> getAccountActive() {
        List<Account> accounts = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Account WHERE is_active =1";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return accounts;
    }

    @Override
    public List<Account> getAccountVerified() {
        List<Account> accounts = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Account WHERE verify=1";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return accounts;
    }


}
