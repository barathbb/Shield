import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersistenceUtil {
	
	public static Persistence getPersistence(){
		return new PersistenceImpl();
	}

}
