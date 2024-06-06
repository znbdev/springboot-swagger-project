//package com.example.demo.service;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class InventoryServiceJava {
//
//    public void purchaseProduct(Long productId) throws SQLException {
//        try (Connection connection = DatabaseManager.getConnection()) {
//            connection.setAutoCommit(false);
//            try {
//                // 锁定行
//                String selectForUpdateSQL = "SELECT quantity FROM inventory WHERE product_id = ? FOR UPDATE";
//                try (PreparedStatement selectStmt = connection.prepareStatement(selectForUpdateSQL)) {
//                    selectStmt.setLong(1, productId);
//                    ResultSet rs = selectStmt.executeQuery();
//                    if (rs.next()) {
//                        int quantity = rs.getInt("quantity");
//                        if (quantity > 0) {
//                            // 更新库存
//                            String updateSQL = "UPDATE inventory SET quantity = ? WHERE product_id = ?";
//                            try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
//                                updateStmt.setInt(1, quantity - 1);
//                                updateStmt.setLong(2, productId);
//                                updateStmt.executeUpdate();
//                            }
//                            connection.commit();
//                        } else {
//                            throw new RuntimeException("Insufficient inventory");
//                        }
//                    } else {
//                        throw new RuntimeException("Product not found");
//                    }
//                }
//            } catch (SQLException e) {
//                connection.rollback();
//                throw e;
//            }
//        }
//    }
//
//    public void cancelProduct(Long productId) throws SQLException {
//        try (Connection connection = DatabaseManager.getConnection()) {
//            connection.setAutoCommit(false);
//            try {
//                // 锁定行
//                String selectForUpdateSQL = "SELECT quantity FROM inventory WHERE product_id = ? FOR UPDATE";
//                try (PreparedStatement selectStmt = connection.prepareStatement(selectForUpdateSQL)) {
//                    selectStmt.setLong(1, productId);
//                    ResultSet rs = selectStmt.executeQuery();
//                    if (rs.next()) {
//                        int quantity = rs.getInt("quantity");
//                        // 更新库存
//                        String updateSQL = "UPDATE inventory SET quantity = ? WHERE product_id = ?";
//                        try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
//                            updateStmt.setInt(1, quantity + 1);
//                            updateStmt.setLong(2, productId);
//                            updateStmt.executeUpdate();
//                        }
//                        connection.commit();
//                    } else {
//                        throw new RuntimeException("Product not found");
//                    }
//                }
//            } catch (SQLException e) {
//                connection.rollback();
//                throw e;
//            }
//        }
//    }
//}
