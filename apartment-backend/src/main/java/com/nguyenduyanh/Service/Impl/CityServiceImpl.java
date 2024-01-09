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

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        try {
            String sql = "SELECT * FROM City";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                City city = new City();
                city.setIdCity(resultSet.getInt("id_city"));
                city.setNameCity(resultSet.getString("name_city"));
                cities.add(city);
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
        return cities;
    }

    @Override
    public City getCityByID(int idCity) {
        City city = new City();
        try {
            String sql = "SELECT * FROM City WHERE id_city=?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCity);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                city.setIdCity(resultSet.getInt("id_city"));
                city.setNameCity(resultSet.getString("name_city"));

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
        return city;
    }

}
