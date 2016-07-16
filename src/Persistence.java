import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Persistence {
	 
	static final String mysql_connection_url = "";
	Map<Integer, Connection> activeConnections = new LinkedHashMap<Integer, Connection>();
	
	public PreparedStatement prepareStatement(String sqlQuery) throws SQLException;
	
	public ResultSet executeSelect(PreparedStatement ps);
	public ResultSet executeInsert(PreparedStatement ps);
	public ResultSet executeUpdate(PreparedStatement ps);
	public void executeDelete(PreparedStatement ps);
	
	public void executeQuery();
}

class PersistenceImpl implements Persistence {
	
	protected static final Logger logger = Logger.getLogger(PersistenceImpl.class.getName());
	
	@Override
	public ResultSet executeSelect(final PreparedStatement ps) {
		
		return connect_operate_disconnect(new Callable<ResultSet>() {
			
            public ResultSet call() throws Exception {
            	return ps.executeQuery();
            	/*
            	ResultSet rs = ps.executeQuery();
            	Connection obseleteConnection = activeConnections.get(ps.hashCode());
            	obseleteConnection.close();
            	activeConnections.remove(ps.hashCode());
            	return rs;
            	*/
            }
        }, ps);
		// TODO Auto-generated method stub
	}

	@Override
	public ResultSet executeInsert(final PreparedStatement ps) {
		return connect_operate_disconnect(new Callable<ResultSet>() {
			
            public ResultSet call() throws Exception {
            	return ps.executeQuery();
            }
        }, ps);
		// TODO Auto-generated method stub
	}

	@Override
	public ResultSet executeUpdate(final PreparedStatement ps) {
		return connect_operate_disconnect(new Callable<ResultSet>() {
			
            public ResultSet call() throws Exception {
            	return ps.executeQuery();
            }
        }, ps);
		// TODO Auto-generated method stub
	}

	@Override
	public void executeDelete(final PreparedStatement ps) {
		connect_operate_disconnect(new Callable<Void>() {
			
            public Void call() throws Exception {
            	ps.executeQuery();
            	return null;
            }
        }, ps);
		// TODO Auto-generated method stub
	}

	@Override
	public void executeQuery() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public PreparedStatement prepareStatement(String sqlQuery) throws SQLException {
		Connection c = getMysqlConnection();
		PreparedStatement p = c.prepareStatement(sqlQuery);
		logger.severe("Created a Connection object for a PreparedStatement... ");
		activeConnections.put(p.hashCode(), c);
		return p;
	}
	
	private <T> T connect_operate_disconnect(Callable<T> callable, PreparedStatement ps) {
		T t = null;
		try {
			t = callable.call();
        	Connection obseleteConnection = activeConnections.get(ps.hashCode());
        	ps.close();
        	obseleteConnection.close();
        	activeConnections.remove(ps.hashCode());
        	logger.severe("Disconnected the Connection object... ");
        } catch(Exception e){
        	logger.log(Level.SEVERE, e.getMessage(), e);
        } finally {
        	
        }
		return t;
    }
	
	private Connection getMysqlConnection() throws SQLException{
		return DriverManager.getConnection(mysql_connection_url);
	}
	
}
