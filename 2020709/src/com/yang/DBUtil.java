package com.yang;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static volatile DataSource dataSource=null;
    public static Connection getConnection() throws SQLException {
        if(dataSource==null){
            synchronized(DBUtil.class){
                if(dataSource==null){
                    dataSource=initDataSource();
                }
            }
        }
        return dataSource.getConnection();
    }

    private static DataSource initDataSource() {
        MysqlDataSource mysqlDataSource=new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("sg7188916");
        mysqlDataSource.setDatabaseName("hjb2_0705");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");
        return mysqlDataSource;
    }
}
