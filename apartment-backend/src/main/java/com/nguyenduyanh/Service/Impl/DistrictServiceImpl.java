package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.District;
import com.nguyenduyanh.Service.DistrictService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictServiceImpl implements DistrictService {

    @Override
    public District getDistrictById(int idDistrict) {
        District district = null;
        String sql = "SELECT * FROM District WHERE id_district=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idDistrict);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    district = new District();
                    district.setIdDistrict(resultSet.getInt("id_district"));
                    district.setNameDistrict(resultSet.getString("name_district"));
                    district.setIdCity(resultSet.getInt("id_city"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return district;
    }

    @Override
    public List<District> getAllDistrictByCity(int idCity) {
        List<District> districts = new ArrayList<>();
        String sql = "SELECT * FROM District WHERE id_city = ?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idCity);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    District district = new District();
                    district.setIdDistrict(resultSet.getInt("id_district"));
                    district.setNameDistrict(resultSet.getString("name_district"));
                    district.setIdCity(resultSet.getInt("id_city"));
                    districts.add(district);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return districts;
    }
}