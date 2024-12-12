package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.ApartmentType;
import com.nguyenduyanh.Service.ApartmentTypeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentTypeServiceImpl implements ApartmentTypeService {

    @Override
    public void addApartmentType(ApartmentType apartmentType) {
        String sql = "INSERT INTO ApartmentType (name_type) VALUES (?)";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, apartmentType.getNameType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateApartmentType(ApartmentType apartmentType) {
        String sql = "UPDATE ApartmentType SET name_type=? WHERE id_type=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, apartmentType.getNameType());
            preparedStatement.setInt(2, apartmentType.getIdType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteApartmentType(int idType) {
        String sql = "DELETE FROM ApartmentType WHERE id_type=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idType);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ApartmentType getApartmentTypeById(int idType) {
        String sql = "SELECT * FROM ApartmentType WHERE id_type=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idType);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ApartmentType apartmentType = new ApartmentType();
                    apartmentType.setIdType(resultSet.getInt("id_type"));
                    apartmentType.setNameType(resultSet.getString("name_type"));
                    return apartmentType;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ApartmentType> getAllApartmentTypes() {
        List<ApartmentType> apartmentTypes = new ArrayList<>();
        String sql = "SELECT * FROM ApartmentType";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ApartmentType apartmentType = new ApartmentType();
                apartmentType.setIdType(resultSet.getInt("id_type"));
                apartmentType.setNameType(resultSet.getString("name_type"));
                apartmentTypes.add(apartmentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apartmentTypes;
    }
}
