package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.District;
import com.nguyenduyanh.Service.DistrictService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistrictServiceImpl implements DistrictService {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public District getDistrictById(int idDistrict) {
        District district = null;
        try {
            String sql = "SELECT * FROM District WHERE id_district=?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idDistrict);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                district = new District();
                district.setIdDistrict(resultSet.getInt("id_district"));
                district.setNameDistrict(resultSet.getString("name_district"));
                district.setIdCity(resultSet.getInt("id_city"));
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
        return district;
    }


    @Override
    public List<District> getAllDistrictByCity(int idCity) {
        List<District> districts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM District WHERE id_city = ?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCity);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                District district = new District();
                district.setIdDistrict(resultSet.getInt("id_district"));
                district.setNameDistrict(resultSet.getString("name_district"));
                district.setIdCity(resultSet.getInt("id_city"));
                districts.add(district);
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
        return districts;
    }

}
