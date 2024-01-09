package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.Apartment;
import com.nguyenduyanh.Model.ApartmentType;
import com.nguyenduyanh.Service.ApartmentService;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class ApartmentServiceImpl implements ApartmentService {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public List<Apartment> getAllApartments() {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartmentsPosted() {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE listing_status=1 AND rental_status=1";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartmentsPostedLimit6() {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE listing_status=1 AND rental_status=1 LIMIT 6";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartmentsPostedLimit3Continue(int offset) {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM apartment WHERE listing_status=1 AND rental_status=1 ORDER BY id_apartment LIMIT 3 OFFSET ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, offset);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartmentsPending() {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE listing_status=2 AND rental_status=1";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartmentsSold() {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE rental_status=0";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartmentsActive() {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE rental_status=1";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartmentsTop5() {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * \n" +
                    "FROM Apartment \n" +
                    "WHERE listing_status = 1 \n" +
                    "  AND rental_status = 1 \n" +
                    "ORDER BY heart_count DESC \n" +
                    "LIMIT 5";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;


    }

    @Override
    public int getTotalListingToday() {

        int totalCount = 0;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT COUNT(*) AS total_count FROM Apartment WHERE listing_status=1 AND rental_status=1 ";
            preparedStatement = connection.prepareStatement(sql);
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
    public List<Apartment> searchApartment(Apartment apartment1) {
        List<Apartment> apartments = new ArrayList<>();
        try {

            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE listing_status =1 AND  price >= ? " +
                    "AND (name_apartment LIKE ? OR title LIKE ? ) " +
                    "AND room = ? AND baths = ? AND id_ward = ? AND id_type = ? " +
                    "ORDER BY price ASC";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartment1.getPrice());
            preparedStatement.setString(2, "%" + apartment1.getNameApartment() + "%");
            preparedStatement.setString(3, "%" + apartment1.getTitle() + "%");
            preparedStatement.setInt(4, apartment1.getRoom());
            preparedStatement.setInt(5, apartment1.getBaths());
            preparedStatement.setInt(6, apartment1.getIdWard());
            preparedStatement.setInt(7, apartment1.getIdType());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;


    }

    @Override
    public List<Apartment> getAllApartmentsOfSeller(int idAccount) {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE id_account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAccount);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;

    }

    @Override
    public List<Apartment> getAllApartmentsOfSellerPosted(int idAccount) {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE id_account=? AND listing_status=1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAccount);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;

    }

    @Override
    public List<Apartment> getAllApartmentsOfSellerPending(int idAccount) {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE id_account=? AND listing_status=2";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAccount);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public List<Apartment> getAllApartmentsOfSellerSold(int idAccount) {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE id_account=? AND rental_status=0";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAccount);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;

    }

    @Override
    public List<Apartment> getAllApartmentsOfSellerActive(int idAccount) {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE id_account=? AND rental_status=1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAccount);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;

    }

    @Override
    public List<Apartment> getAllApartmentsOfType(ApartmentType apartmentType) {
        List<Apartment> apartments = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE rental_status=1 AND  listing_status=1 AND id_type=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartmentType.getIdType());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return apartments;
    }

    @Override
    public void addApartment(Apartment apartment) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO Apartment (title, name_apartment, room, baths, area, price, description, listing_status," +
                    " rental_status, street_name, posting_date, end_date, id_ward, id_type, id_account, heart_count,img) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, null, ?, ?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, apartment.getTitle());
            preparedStatement.setString(2, apartment.getNameApartment());
            preparedStatement.setInt(3, apartment.getRoom());
            preparedStatement.setInt(4, apartment.getBaths());
            preparedStatement.setInt(5, apartment.getArea());
            preparedStatement.setInt(6, apartment.getPrice());
            preparedStatement.setString(7, apartment.getDescription());
            preparedStatement.setInt(8, apartment.getListingStatus());
            preparedStatement.setInt(9, apartment.getRentalStatus());
            preparedStatement.setString(10, apartment.getStreetName());
            preparedStatement.setInt(11, apartment.getIdWard());
            preparedStatement.setInt(12, apartment.getIdType());
            preparedStatement.setInt(13, apartment.getIdAccount());
            preparedStatement.setInt(14, apartment.getHeartCount());
            preparedStatement.setString(15, apartment.getImg());

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
    public void updateApartment(Apartment apartment) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Apartment SET title=?, name_apartment=?, room=?, baths=?, area=?, price=?, " +
                    "description=?, listing_status=?, rental_status=?, street_name=?,  " +
                    " id_ward=?, id_type=?, id_account=?, heart_count=? WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, apartment.getTitle());
            preparedStatement.setString(2, apartment.getNameApartment());
            preparedStatement.setInt(3, apartment.getRoom());
            preparedStatement.setInt(4, apartment.getBaths());
            preparedStatement.setInt(5, apartment.getArea());
            preparedStatement.setInt(6, apartment.getPrice());
            preparedStatement.setString(7, apartment.getDescription());
            preparedStatement.setInt(8, apartment.getListingStatus());
            preparedStatement.setInt(9, apartment.getRentalStatus());
            preparedStatement.setString(10, apartment.getStreetName());
            preparedStatement.setInt(11, apartment.getIdWard());
            preparedStatement.setInt(12, apartment.getIdType());
            preparedStatement.setInt(13, apartment.getIdAccount());
            preparedStatement.setInt(14, apartment.getHeartCount());
            preparedStatement.setInt(15, apartment.getIdApartment());
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
    public void activeApartment(Apartment apartment) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Apartment SET rental_status=1 WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartment.getIdApartment());
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
    public void soldApartment(Apartment apartment) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Apartment SET rental_status=0,listing_status=0 WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartment.getIdApartment());
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
    public void acceptListing(Apartment apartment) {
        try {
            apartment.setPostingDate(new java.util.Date());

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(apartment.getPostingDate());

            calendar.add(Calendar.DAY_OF_MONTH, 10);

            Date endDate = calendar.getTime();

            apartment.setEndDate(endDate);

            connection = ConnectDB.getConnection();
            String sql = "UPDATE Apartment SET  listing_status=1, posting_date=?, end_date=? WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, new java.sql.Date(apartment.getPostingDate().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(apartment.getEndDate().getTime()));
            preparedStatement.setInt(3, apartment.getIdApartment());
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
    public void rejectListing(Apartment apartment) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Apartment SET  listing_status=0 WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartment.getIdApartment());
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
    public void updateHeart(Apartment apartment) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Apartment SET  heart_count=heart_count+1 WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartment.getIdApartment());
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
    public void checkApartmentValid() {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Apartment SET listing_status = 0 \n" +
                    " WHERE end_date < CURDATE() AND listing_status = 1;";
            preparedStatement = connection.prepareStatement(sql);
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
    public void postListing(Apartment apartment) {

        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Apartment SET listing_status=2 WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartment.getIdApartment());
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
    public void deleteApartment(int apartmentId) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM Apartment WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartmentId);
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
    public Apartment getApartmentById(int apartmentId) {
        Apartment apartment = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Apartment WHERE id_apartment=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, apartmentId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                apartment = new Apartment();
                apartment.setIdApartment(resultSet.getInt("id_apartment"));
                apartment.setTitle(resultSet.getString("title"));
                apartment.setNameApartment(resultSet.getString("name_apartment"));
                apartment.setRoom(resultSet.getInt("room"));
                apartment.setBaths(resultSet.getInt("baths"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setPrice(resultSet.getInt("price"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setListingStatus(resultSet.getInt("listing_status"));
                apartment.setRentalStatus(resultSet.getInt("rental_status"));
                apartment.setStreetName(resultSet.getString("street_name"));
                apartment.setPostingDate(resultSet.getDate("posting_date"));
                apartment.setEndDate(resultSet.getDate("end_date"));
                apartment.setIdWard(resultSet.getInt("id_ward"));
                apartment.setIdType(resultSet.getInt("id_type"));
                apartment.setIdAccount(resultSet.getInt("id_account"));
                apartment.setHeartCount(resultSet.getInt("heart_count"));
                apartment.setImg(resultSet.getString("img"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return apartment;
    }
}
