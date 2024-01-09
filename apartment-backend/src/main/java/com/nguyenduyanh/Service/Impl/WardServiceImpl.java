package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.Ward;
import com.nguyenduyanh.Service.WardService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WardServiceImpl implements WardService {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    @Override
    public List<Ward> getAllWardsByDistrict(int idDistrict) {
        List<Ward> wards = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Ward WHERE id_district = ?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idDistrict);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ward ward = new Ward();
                ward.setIdWard(resultSet.getInt("id_ward"));
                ward.setNameWard(resultSet.getString("name_ward"));
                ward.setIdDistrict(resultSet.getInt("id_district"));
                wards.add(ward);
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
        return wards;
    }


    @Override
    public List<Ward> getAllWards() {
        List<Ward> wards = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Ward ";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ward ward = new Ward();
                ward.setIdWard(resultSet.getInt("id_ward"));
                ward.setNameWard(resultSet.getString("name_ward"));
                ward.setIdDistrict(resultSet.getInt("id_district"));
                wards.add(ward);
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
        return wards;
    }

    @Override
    public Ward getWardByID(int idWard) {
        Ward ward = new Ward();
        try {
            String sql = "SELECT * FROM Ward WHERE id_ward =?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idWard);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ward.setIdWard(resultSet.getInt("id_ward"));
                ward.setNameWard(resultSet.getString("name_ward"));
                ward.setIdDistrict(resultSet.getInt("id_district"));
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
        return ward;

    }
}
