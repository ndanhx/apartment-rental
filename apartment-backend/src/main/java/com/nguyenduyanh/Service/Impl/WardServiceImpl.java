package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.Ward;
import com.nguyenduyanh.Service.WardService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WardServiceImpl implements WardService {

    @Override
    public List<Ward> getAllWardsByDistrict(int idDistrict) {
        List<Ward> wards = new ArrayList<>();
        String sql = "SELECT * FROM Ward WHERE id_district = ?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idDistrict);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Ward ward = new Ward();
                    ward.setIdWard(resultSet.getInt("id_ward"));
                    ward.setNameWard(resultSet.getString("name_ward"));
                    ward.setIdDistrict(resultSet.getInt("id_district"));
                    wards.add(ward);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wards;
    }

    @Override
    public List<Ward> getAllWards() {
        List<Ward> wards = new ArrayList<>();
        String sql = "SELECT * FROM Ward";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Ward ward = new Ward();
                ward.setIdWard(resultSet.getInt("id_ward"));
                ward.setNameWard(resultSet.getString("name_ward"));
                ward.setIdDistrict(resultSet.getInt("id_district"));
                wards.add(ward);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wards;
    }

    @Override
    public Ward getWardByID(int idWard) {
        Ward ward = null;
        String sql = "SELECT * FROM Ward WHERE id_ward =?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idWard);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ward = new Ward();
                    ward.setIdWard(resultSet.getInt("id_ward"));
                    ward.setNameWard(resultSet.getString("name_ward"));
                    ward.setIdDistrict(resultSet.getInt("id_district"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ward;
    }
}