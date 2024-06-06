//package com.example.demo.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.anyString;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class InventoryServiceJavaTest {
//
//    @InjectMocks
//    private InventoryService inventoryService;
//
//    @Mock
//    private Connection connection;
//
//    @Mock
//    private PreparedStatement selectStmt;
//
//    @Mock
//    private PreparedStatement updateStmt;
//
//    @Mock
//    private ResultSet resultSet;
//
//    @BeforeEach
//    public void setUp() throws SQLException {
//        MockitoAnnotations.openMocks(this);
//        when(connection.prepareStatement(anyString())).thenReturn(selectStmt);
//        when(selectStmt.executeQuery()).thenReturn(resultSet);
//    }
//
//    @Test
//    public void testPurchaseProduct() throws SQLException {
//        Long productId = 1L;
//
//        when(resultSet.next()).thenReturn(true);
//        when(resultSet.getInt("quantity")).thenReturn(1);
//        when(connection.prepareStatement(anyString())).thenReturn(updateStmt);
//
//        inventoryService.purchaseProduct(productId);
//
//        verify(updateStmt, times(1)).setInt(1, 0);
//        verify(updateStmt, times(1)).setLong(2, productId);
//        verify(updateStmt, times(1)).executeUpdate();
//        verify(connection, times(1)).commit();
//    }
//
//    @Test
//    public void testPurchaseProductInsufficientInventory() throws SQLException {
//        Long productId = 1L;
//
//        when(resultSet.next()).thenReturn(true);
//        when(resultSet.getInt("quantity")).thenReturn(0);
//
//        assertThrows(RuntimeException.class, () -> inventoryService.purchaseProduct(productId));
//
//        verify(updateStmt, never()).executeUpdate();
//        verify(connection, times(1)).rollback();
//    }
//
//    @Test
//    public void testCancelProduct() throws SQLException {
//        Long productId = 1L;
//
//        when(resultSet.next()).thenReturn(true);
//        when(resultSet.getInt("quantity")).thenReturn(1);
//        when(connection.prepareStatement(anyString())).thenReturn(updateStmt);
//
//        inventoryService.cancelProduct(productId);
//
//        verify(updateStmt, times(1)).setInt(1, 2);
//        verify(updateStmt, times(1)).setLong(2, productId);
//        verify(updateStmt, times(1)).executeUpdate();
//        verify(connection, times(1)).commit();
//    }
//}
//
