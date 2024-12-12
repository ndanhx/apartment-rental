package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.Apartment;
import com.nguyenduyanh.Model.ApartmentType;
import com.nguyenduyanh.Service.ApartmentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ApartmentServiceImpl implements ApartmentService {

    @Override
    public List<Apartment> getAllApartments() {
        String sql = "SELECT * FROM Apartment";
        return getApartmentsByQuery(sql);
    }

    @Override
    public List<Apartment> getAllApartmentsPosted() {
        String sql = "SELECT * FROM Apartment WHERE listing_status=1 AND rental_status=1";
        return getApartmentsByQuery(sql);
    }

    @Override
    public List<Apartment> getAllApartmentsPostedLimit6() {
        String sql = "SELECT * FROM Apartment WHERE listing_status=1 AND rental_status=1 LIMIT 6";
        return getApartmentsByQuery(sql);
    }

    @Override
    public List<Apartment> getAllApartmentsPostedLimit3Continue(int offset) {
        String sql = "SELECT * FROM Apartment WHERE listing_status=1 AND rental_status=1 ORDER BY id_apartment LIMIT 3 OFFSET ?";
        return getApartmentsByQueryWithParams(sql, offset);
    }

    @Override
    public List<Apartment> getAllApartmentsPending() {
        String sql = "SELECT * FROM Apartment WHERE listing_status=2 AND rental_status=1";
        return getApartmentsByQuery(sql);
    }

    @Override
    public List<Apartment> getAllApartmentsSold() {
        String sql = "SELECT * FROM Apartment WHERE rental_status=0";
        return getApartmentsByQuery(sql);
    }

    @Override
    public List<Apartment> getAllApartmentsActive() {
        String sql = "SELECT * FROM Apartment WHERE rental_status=1";
        return getApartmentsByQuery(sql);
    }

    @Override
    public List<Apartment> getAllApartmentsTop5() {
        String sql = "SELECT * FROM Apartment WHERE listing_status=1 AND rental_status=1 ORDER BY heart_count DESC LIMIT 5";
        return getApartmentsByQuery(sql);
    }

    @Override
    public int getTotalListingToday() {
        String sql = "SELECT COUNT(*) AS total_count FROM Apartment WHERE listing_status=1 AND rental_status=1";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("total_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Apartment> searchApartment(Apartment apartment1) {
        String sql = "SELECT * FROM Apartment WHERE listing_status=1 AND price >= ? " +
                "AND (name_apartment LIKE ? OR title LIKE ?) " +
                "AND room = ? AND baths = ? AND id_ward = ? AND id_type = ? ORDER BY price ASC";
        return getApartmentsByQueryWithParams(sql, apartment1.getPrice(),
                "%" + apartment1.getNameApartment() + "%",
                "%" + apartment1.getTitle() + "%",
                apartment1.getRoom(), apartment1.getBaths(),
                apartment1.getIdWard(), apartment1.getIdType());
    }

    @Override
    public List<Apartment> getAllApartmentsOfSeller(int idAccount) {
        String sql = "SELECT * FROM Apartment WHERE id_account=?";
        return getApartmentsByQueryWithParams(sql, idAccount);
    }

    @Override
    public List<Apartment> getAllApartmentsOfSellerPosted(int idAccount) {
        String sql = "SELECT * FROM Apartment WHERE id_account=? AND listing_status=1";
        return getApartmentsByQueryWithParams(sql, idAccount);
    }

    @Override
    public List<Apartment> getAllApartmentsOfSellerPending(int idAccount) {
        String sql = "SELECT * FROM Apartment WHERE id_account=? AND listing_status=2";
        return getApartmentsByQueryWithParams(sql, idAccount);
    }

    @Override
    public List<Apartment> getAllApartmentsOfSellerSold(int idAccount) {
        String sql = "SELECT * FROM Apartment WHERE id_account=? AND rental_status=0";
        return getApartmentsByQueryWithParams(sql, idAccount);
    }

    @Override
    public List<Apartment> getAllApartmentsOfSellerActive(int idAccount) {
        String sql = "SELECT * FROM Apartment WHERE id_account=? AND rental_status=1";
        return getApartmentsByQueryWithParams(sql, idAccount);
    }

    @Override
    public List<Apartment> getAllApartmentsOfType(ApartmentType apartmentType) {
        String sql = "SELECT * FROM Apartment WHERE rental_status=1 AND listing_status=1 AND id_type=?";
        return getApartmentsByQueryWithParams(sql, apartmentType.getIdType());
    }

    @Override
    public void addApartment(Apartment apartment) {
        String sql = "INSERT INTO Apartment (title, name_apartment, room, baths, area, price, description, listing_status, " +
                "rental_status, street_name, posting_date, end_date, id_ward, id_type, id_account, heart_count, img) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executeUpdateWithParams(sql, apartment.getTitle(), apartment.getNameApartment(),
                apartment.getRoom(), apartment.getBaths(), apartment.getArea(),
                apartment.getPrice(), apartment.getDescription(),
                apartment.getListingStatus(), apartment.getRentalStatus(),
                apartment.getStreetName(), apartment.getPostingDate(),
                apartment.getEndDate(), apartment.getIdWard(),
                apartment.getIdType(), apartment.getIdAccount(),
                apartment.getHeartCount(), apartment.getImg());
    }

    @Override
    public void updateApartment(Apartment apartment) {
        String sql = "UPDATE Apartment SET title=?, name_apartment=?, room=?, baths=?, area=?, price=?, " +
                "description=?, listing_status=?, rental_status=?, street_name=?, id_ward=?, id_type=?, id_account=?, heart_count=? " +
                "WHERE id_apartment=?";
        executeUpdateWithParams(sql, apartment.getTitle(), apartment.getNameApartment(),
                apartment.getRoom(), apartment.getBaths(), apartment.getArea(),
                apartment.getPrice(), apartment.getDescription(),
                apartment.getListingStatus(), apartment.getRentalStatus(),
                apartment.getStreetName(), apartment.getIdWard(),
                apartment.getIdType(), apartment.getIdAccount(),
                apartment.getHeartCount(), apartment.getIdApartment());
    }

    @Override
    public void activeApartment(Apartment apartment) {
        updateRentalStatus(apartment.getIdApartment(), 1);
    }

    @Override
    public void soldApartment(Apartment apartment) {
        String sql = "UPDATE Apartment SET rental_status=0, listing_status=0 WHERE id_apartment=?";
        executeUpdateWithParams(sql, apartment.getIdApartment());
    }

    @Override
    public void acceptListing(Apartment apartment) {
        apartment.setPostingDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(apartment.getPostingDate());
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        apartment.setEndDate(calendar.getTime());

        String sql = "UPDATE Apartment SET listing_status=1, posting_date=?, end_date=? WHERE id_apartment=?";
        executeUpdateWithParams(sql, new java.sql.Date(apartment.getPostingDate().getTime()),
                new java.sql.Date(apartment.getEndDate().getTime()), apartment.getIdApartment());
    }

    @Override
    public void rejectListing(Apartment apartment) {
        String sql = "UPDATE Apartment SET listing_status=0 WHERE id_apartment=?";
        executeUpdateWithParams(sql, apartment.getIdApartment());
    }

    @Override
    public void updateHeart(Apartment apartment) {
        String sql = "UPDATE Apartment SET heart_count=heart_count+1 WHERE id_apartment=?";
        executeUpdateWithParams(sql, apartment.getIdApartment());
    }

    @Override
    public void checkApartmentValid() {
        String sql = "UPDATE Apartment SET listing_status=0 WHERE end_date < CURDATE() AND listing_status=1";
        executeUpdateWithParams(sql);
    }

    @Override
    public void postListing(Apartment apartment) {
        String sql = "UPDATE Apartment SET listing_status=2 WHERE id_apartment=?";
        executeUpdateWithParams(sql, apartment.getIdApartment());
    }

    @Override
    public void deleteApartment(int apartmentId) {
        String sql = "DELETE FROM Apartment WHERE id_apartment=?";
        executeUpdateWithParams(sql, apartmentId);
    }

    @Override
    public Apartment getApartmentById(int apartmentId) {
        String sql = "SELECT * FROM Apartment WHERE id_apartment=?";
        List<Apartment> apartments = getApartmentsByQueryWithParams(sql, apartmentId);
        return apartments.isEmpty() ? null : apartments.get(0);
    }

    private List<Apartment> getApartmentsByQuery(String sql, Object... params) {
        List<Apartment> apartments = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    apartments.add(mapResultSetToApartment(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apartments;
    }

    private List<Apartment> getApartmentsByQueryWithParams(String sql, Object... params) {
        return getApartmentsByQuery(sql, params);
    }

    private void executeUpdateWithParams(String sql, Object... params) {
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateRentalStatus(int apartmentId, int status) {
        String sql = "UPDATE Apartment SET rental_status=? WHERE id_apartment=?";
        executeUpdateWithParams(sql, status, apartmentId);
    }

    private Apartment mapResultSetToApartment(ResultSet resultSet) throws SQLException {
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
        return apartment;
    }
}
