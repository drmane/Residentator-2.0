package transaction_manager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 * Implementación de la Transacción usando MySQL
 * @author Daniel
 *
 */
public class TransactionMySQL implements Transaction {
	
	private Connection conection;

	@Override
	public void start() {
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    String host = "jdbc:mysql://db4free.net:3306/residentatorms3";
		    conection = DriverManager.getConnection(host,"residentatorms3","residentatorms3");
		} catch (Exception e) {
			System.err.println("ERROR!! Ha fallado la conexión con la BD");
		    e.printStackTrace();
		}
		
		try {
			conection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR!! Al desactivar el AutoCommit");
			e.printStackTrace();
		}	
	}

	@Override
	public void commit() {
		try {
			conection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void rollback() {
		try {
			conection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public Object getResource() {
		return conection;
	}

}
