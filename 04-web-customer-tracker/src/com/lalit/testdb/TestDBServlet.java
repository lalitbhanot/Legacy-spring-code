package com.lalit.testdb;
// add the jar to the tomcat server to  reslove the error 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.* ;
/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl ="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC" ;
		String user ="springstudent";
		String pass ="springstudent";
		String driver ="com.mysql.cj.jdbc.Driver" ;
		try {
			PrintWriter out=  response.getWriter();
			
			Class.forName(driver);
			out.println("Connecting to JDBC URL : "  + jdbcUrl );
			Connection myconn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Sucess  : " );
		}
		catch(Exception e ) {
			e.printStackTrace();
			
		}
	}

}
