package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import lombok.extern.log4j.Log4j;

public class JDBCTests {
    public static void main(String[] args) {
        Connection con = null;
        
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ko?useSSL=false&useUnicode=true&characterEncoding=euckr";
        String user = "book_ex";
        String passwd = "book_ex";

        try {
            Class.forName(className);
            con = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connect Success!");
        } catch(Exception e) {
            System.out.println("Connect Failed!");
            e.printStackTrace();
        } finally {
                try {
                    if(con != null && !con.isClosed()) {
                        con.close();
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
        }
        
    }
	
}