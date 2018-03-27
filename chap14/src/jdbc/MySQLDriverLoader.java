package jdbc;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySQLDriverLoader
 */
public class MySQLDriverLoader extends HttpServlet {
	  public void init(ServletConfig config) throws ServletException{
      	try {
      		//Class.forName("oracle.jdbc.driver.OracleDriver");
      		Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception ex) {
				// TODO: handle exception
				throw new ServletException(ex);
			}
      }
}
