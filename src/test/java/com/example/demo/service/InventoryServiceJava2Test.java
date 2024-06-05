package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

// JPA（Java Persistence API）是 Java EE 的一部分，它定义了对象-关系映射（ORM）的标准，使开发者能够使用 Java 对象与关系数据库进行交互。JPA 提供了一种机制，将 Java 对象与数据库表进行映射，并自动生成 SQL 查询，从而简化了数据库操作的复杂性。
//结论
//以上代码展示了如何在没有 Spring Boot 的情况下使用纯 Java 和 JDBC 实现行锁和库存操作。通过使用 SELECT ... FOR UPDATE 语句，我们确保在进行库存操作时锁定相关行，从而防止并发修改。使用事务管理和手动提交/回滚操作，可以确保操作的原子性和一致性。
public class InventoryServiceJava2Test {

    @InjectMocks
    private InventoryService inventoryService;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement selectStmt;

    @Mock
    private PreparedStatement updateStmt;

    @Mock
    private ResultSet resultSet;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        when(connection.prepareStatement(anyString())).thenReturn(selectStmt);
        when(selectStmt.executeQuery()).thenReturn(resultSet);
    }

    @Test
    public void testPurchaseProduct() throws SQLException {
        Long productId = 1L;

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("quantity")).thenReturn(1);
        when(connection.prepareStatement(anyString())).thenReturn(updateStmt);

        inventoryService.purchaseProduct(productId);

        verify(updateStmt, times(1)).setInt(1, 0);
        verify(updateStmt, times(1)).setLong(2, productId);
        verify(updateStmt, times(1)).executeUpdate();
        verify(connection, times(1)).commit();
    }

    @Test
    public void testPurchaseProductInsufficientInventory() throws SQLException {
        Long productId = 1L;

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("quantity")).thenReturn(0);

        assertThrows(RuntimeException.class, () -> inventoryService.purchaseProduct(productId));

        verify(updateStmt, never()).executeUpdate();
        verify(connection, times(1)).rollback();
    }

    @Test
    public void testCancelProduct() throws SQLException {
        Long productId = 1L;

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("quantity")).thenReturn(1);
        when(connection.prepareStatement(anyString())).thenReturn(updateStmt);

        inventoryService.cancelProduct(productId);

        verify(updateStmt, times(1)).setInt(1, 2);
        verify(updateStmt, times(1)).setLong(2, productId);
        verify(updateStmt, times(1)).executeUpdate();
        verify(connection, times(1)).commit();
    }
}


