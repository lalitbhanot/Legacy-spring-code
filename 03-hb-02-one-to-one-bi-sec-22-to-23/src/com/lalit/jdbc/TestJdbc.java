package com.lalit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	
	
	public static void main(String[] args) {
		String schemaName= "hb-01-one-to-one-uni" ;
		String jdbcUrl ="jdbc:mysql://localhost:3306/"+schemaName+"?useSSL=false" ;
		String user ="hbstudent";
		String pass ="hbstudent";
		try {
			System.out.println("Connecting to database : " + jdbcUrl);
			Connection myconn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Done  : " + schemaName );
		}
		catch(Exception e ) {
			e.printStackTrace();
			
		}
	}

}
