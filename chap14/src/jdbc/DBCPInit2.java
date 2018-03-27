package jdbc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit2 extends HttpServlet{
	@Override
	public void init() throws ServletException{
		loadJDBCDriver();
		initConnectionPool();
	}
	
	private void loadJDBCDriver() {
		String driverClass = getInitParameter("jdbcdriver");
		try {
			Class.forName(driverClass);
		//	Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("fail to load JDBC Driver", e); 
		}
	}
	
	private void initConnectionPool() {
		try {
		//	String jdbcUrl = "jdbc:mysql://localhost:3306/guestbook?useUnicode=true&characterEncoding=utf8";
		//	String jdbcUrl = "jdbc:mysql://localhost:3306/chap14?useUnicode=true&characterEncoding=utf8";
		//	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcla";
			String jdbcUrl = getInitParameter("jdbcUrl");
			String username="jspexam";
			String pw = "jsppw";
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl,username,pw);
			
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1");
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxTotal(50);
			
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = getInitParameter("poolName");
			driver.registerPool(poolName, connectionPool);
		//	driver.registerPool("chap14", connectionPool);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
