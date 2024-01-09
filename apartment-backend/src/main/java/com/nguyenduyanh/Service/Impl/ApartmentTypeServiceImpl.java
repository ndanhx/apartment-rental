package com.nguyenduyanh.Service.Impl;

import com.nguyenduyanh.DAO.ConnectDB;
import com.nguyenduyanh.Model.ApartmentType;
import com.nguyenduyanh.Service.ApartmentTypeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentTypeServiceImpl implements ApartmentTypeService {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    @Override
    public void addApartmentType(ApartmentType apartmentType) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO ApartmentType (name_type) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, apartmentType.getNameType());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public void updateApartmentType(ApartmentType apartmentType) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE ApartmentType SET name_type=? WHERE id_type=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, apartmentType.getNameType());
            preparedStatement.setInt(2, apartmentType.getIdType());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    @Override
    public void deleteApartmentType(int idType) {
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM ApartmentType WHERE id_type=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idType);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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

    }

    @Override
    public ApartmentType getApartmentTypeById(int idType) {
        ApartmentType apartmentType = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM ApartmentType WHERE id_type=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idType);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                apartmentType = new ApartmentType();
                apartmentType.setIdType(resultSet.getInt("id_type"));
                apartmentType.setNameType(resultSet.getString("name_type"));
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

        return apartmentType;

    }

    @Override
    public List<ApartmentType> getAllApartmentTypes() {
        List<ApartmentType> apartmentTypes = new ArrayList<>();

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM ApartmentType";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ApartmentType apartmentType = new ApartmentType();
                apartmentType.setIdType(resultSet.getInt("id_type"));
                apartmentType.setNameType(resultSet.getString("name_type"));
                apartmentTypes.add(apartmentType);
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

        return apartmentTypes;
    }
}
