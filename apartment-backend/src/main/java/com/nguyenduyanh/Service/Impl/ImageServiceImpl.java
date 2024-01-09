package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.Image;
import com.nguyenduyanh.Service.ImageService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ImageServiceImpl implements ImageService {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    private void closeResources() {
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
    @Override
    public void insertImage(Image image) {
        try {
            String sql = "INSERT INTO Image (name_image, link_image, id_apartment) VALUES (?, ?, ?)";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, image.getNameImage());
            preparedStatement.setString(2, image.getLinkImage());
            preparedStatement.setInt(3, image.getIdApartment());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
}
