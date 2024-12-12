package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.City;
import com.nguyenduyanh.Service.CityService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityServiceImpl implements CityService {

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM City";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                City city = new City();
                city.setIdCity(resultSet.getInt("id_city"));
                city.setNameCity(resultSet.getString("name_city"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City getCityByID(int idCity) {
        City city = null;
        String sql = "SELECT * FROM City WHERE id_city=?";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idCity);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    city = new City();
                    city.setIdCity(resultSet.getInt("id_city"));
                    city.setNameCity(resultSet.getString("name_city"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }
}