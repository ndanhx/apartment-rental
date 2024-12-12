package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.Image;
import com.nguyenduyanh.Service.ImageService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageServiceImpl implements ImageService {

    @Override
    public void insertImage(Image image) {
        String sql = "INSERT INTO Image (name_image, link_image, id_apartment) VALUES (?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, image.getNameImage());
            preparedStatement.setString(2, image.getLinkImage());
            preparedStatement.setInt(3, image.getIdApartment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}