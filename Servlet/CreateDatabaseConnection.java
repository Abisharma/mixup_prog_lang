package jdbc_programs;

/**
DESCRIPTION TO CREATE THE DATABASE :-  
	1. Registering the database driver by using the java.mysql.DriverManager, where DriverMAnager
		is a class given under the jdbc specification. to achieve the registration of the driver
		we require to use the Class.forName(" driver of the particular databse ") method of the 
		inbuil Class Class(inbuilt class).
	2. Open a session to the database, i.e. establishe a connection to the database by using the
		DriverManager.getConnection() method, which returns the connection objects.

Following is the program to build a connection to the mysql(varies according to the choices) 
database.
*/
import java.sql.PreparedStatement;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.CallableStatement;
import java.sql.DatabaseMetaData;
import java.util.Properties;


public class CreateDatabaseConnection {
	
	private Connection connection;
	private Statement statement;
	private ResultSet result_set;
	private PreparedStatement prepared_statement;
	private CallableStatement callable_statement;
	private ResultSetMetaData result_set_meta;
	
		public void createConnectionMysql() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/abhishek","root","12345");
		statement = connection.createStatement();
		System.out.println("connection is successfully created");
		}
		catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		finally {
			try {
			connection.close();
			statement.close();
			}
			catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}	
	
	/**
	 * JDBC Statement : 
	 * basically java.sql.Statement is an interface. it is used to fire the query 
	 * to database it can fire the both ddl and dml sql queries by using
	 * executeUpdate() and executeQuery() methods respectively.
	 * executeUpdate() method returns an  integer value whereas execute
	 * Query() method returns an reference variable of ResultSet types.   
	 * 
	 * JDBC ResultSet : 
	 * Basically when our query return the multiple rows we use the result set
	 * interface to traverse the result. it maintains a cursor that points to it's
	 * current row. initialy cursor is pointed before the first row. the next()
	 * method of resultset interface moves the cursor to the next row. and 
	 * returns falls if there is no more rows to travers. it can be used inside
	 * the while loop used to traverse the all output of the executeQuery()
	 * method, result set interface contains the getxxx() methods to retrieve 
	 * the data from each row, where xxx represents the datatype.
	 * 
	 * 
	 * */
	public void createAndSelectQuery() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
		statement = connection.createStatement();
		
		result_set = statement.executeQuery("show databases");
		System.out.println("databases presented into");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		while(result_set.next()) {
			System.out.println("database  name  : "+result_set.getString("Database"));
		}
		

		System.out.println();
		System.out.println();
		System.out.println("tables presented inside the abhishek database");
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		result_set = statement.executeQuery("show tables");
		while(result_set.next()) {
			System.out.println("table name is    :   "+ result_set.getString(1));
		}
		

		System.out.println();
		System.out.println();
		System.out.println("using the customers table ");
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		result_set = statement.executeQuery("select customer_id,cust_name from customers " );
		while(result_set.next()) {
			System.out.println("customer id  is  :  "+ result_set.getInt("customer_id")+
					"customer name   :  "+result_set.getString("cust_name"));
		}
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				connection.close();
				statement.close();
				result_set.close();
				}
			catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	/**
	 * executeUpdate() : this method is used to execute a query if we want to 
	 * update a record in a table. it's return type is type of int that refers 
	 * to the numer of row get update after fire this query.
	 *  
	 * */
	public void updateARecord() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			statement = connection.createStatement();
			
			result_set = statement.executeQuery("show databases");
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("databasese presented inside the mysql");
			
			System.out.println();
			System.out.println();
			System.out.println();
			while(result_set.next()) {
				System.out.println("dtabase name present    :  " +result_set.getString(1));
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("total tables inside the abhishek database");

			System.out.println();
			System.out.println();
			System.out.println();
			result_set = statement.executeQuery("show tables");
			while(result_set.next()) {
				System.out.println("table name is   :   "+result_set.getString(1));
			}
			
			
			result_set = statement.executeQuery("select * from customers");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("all table records are");
			System.out.println();
			System.out.println();
			System.out.println();
			
			while(result_set.next()) {
				System.out.println(result_set.getString(1) + " \t"+ result_set.getString(2) +"\t\t"+ result_set.getString(3)+ "\t"+result_set.getString(4) );
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("performing the updation operation");
			System.out.println();
			System.out.println();
			System.out.println();
			
			int rows_affected = statement.executeUpdate("update customers set income = "+2500+" where customer_id ="+4+"");
			System.out.println("rows that has been updated are    :   " + rows_affected);
			
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		finally {
			try {
				if(statement!=null) statement.close();
				if(connection != null) connection.close();
				if(result_set != null) result_set.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		
	}
	
	
	public void executeMethodExample() {
		/**
		 * execute():- basically execute() method allow us to execute all type
		 * of query wheather update query or select query, 
		 * it returns the boolean type as return type.
		 * 
		 *  If it return the true than it mean,  it executed the select query so
		 *  we get the result set object and traverse the all record.
		 *  if it returns then it can execute the update query to get 
		 *  the number of affected rows we need to call the 
		 *  getUpdateCount() method. 
		 * 
		 * */
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
		statement = connection.createStatement();
		boolean status = statement.execute("select  * from  course");
		if(status) {
			result_set = statement.getResultSet();
			while(result_set.next()) {
				System.out.println(result_set.getString(1)+"\t"+result_set.getString(2)+
						"\t\t"+result_set.getString(3)+"\t\t"+result_set.getString(4));
			}
		}
		else {
			int count  = statement.getUpdateCount();
			System.out.println("number of rows affected "+count);
		}
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
			}
		catch(SQLException se ) {
			System.out.println(se.getMessage());
		}
	}
	
	
	public void preparedStatementExample() {
		/***
		 * PreparedStatement :- Basically prepared statement is used when we 
		 * want to execute the same sql statement many times. it is used to handle
		 * the precompiled queries. if we want to execute the same query with different 
		 * alues for more than one time then precompiled queries will reduce the number
		 * of the compilations, connection.preparedStatement() method
		 * can provide us the object of the preparedStetement. 
		 * 
		 * prepared statements provides the setxxx() methods to provide the
		 *different  values to the queries.
		 * 
		 * 
		 * */
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			prepared_statement = connection.prepareStatement("insert into customers(customer_id,cust_name,occupation,income,qualification) values(?,?,?,?,?)");
			prepared_statement.setInt(1, 7);
			prepared_statement.setString(2, "Agathe");
			prepared_statement.setString(3, "infirmier");
			prepared_statement.setString(4, "53000");
			prepared_statement.setString(5, "MS");
			boolean status = prepared_statement.execute();
			if(status) {
				System.out.println("Inside the if block ");
			}
			else {
				int row_count= prepared_statement.getUpdateCount();
				System.out.println("number of rows affected   :   "+row_count);
			}
			
		
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		
		finally {
			try {
				if(connection != null) connection.close();
				if(statement!= null)statement.close();
				if(result_set!=null) result_set.close();
			}
			catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}

	
	public void preparedStatementResultSetExample() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			statement = connection.createStatement();
			result_set = statement.executeQuery("show databases");
			
			System.out.println("tables presented into the database");
			System.out.println();
			System.out.println();
			System.out.println();
			
			while(result_set.next()) {
				System.out.println("table name   :   "+result_set.getString(1));
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("retrieving the all records from the table");
			result_set = statement.executeQuery("select * from customers");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			while(result_set.next()) {
				System.out.println("customer id   :  "+result_set.getInt(1)+"  customer _name   :  "+
			result_set.getString(2)+"  occupation  :  "+result_set.getString(3)+"  income   : "+
						result_set.getString(4)+"   qualification  :   "+ result_set.getString(5));
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("retrieving the records by using the preparedStatement interface");
			prepared_statement  = connection.prepareStatement("select * from course where studentid = ?");
			prepared_statement.setInt(1, 141);
			result_set  = prepared_statement.executeQuery();
			while(result_set.next()) {
				System.out.println("student_id   : "+result_set.getInt(1) +"  course_id  :  "+ 
			result_set.getString(2)+"  course_name  : "+result_set.getString(3)+
			"   prof :  "+result_set.getString(4));
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("executing the same query with different parameters");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			prepared_statement = connection.prepareStatement("select * from course where studentid  = ?");
			prepared_statement.setInt(1, 121);
			result_set = prepared_statement.executeQuery();
			while(result_set.next()) {
				System.out.println("student id  :  "+result_set.getInt(1)+
						"  course_id   :  "+ result_set.getInt(2)+
						"  course_name  :  "+result_set.getString(3)+
						"   professor name  :   "+result_set.getString(4));
			}
			
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(result_set!=null) result_set.close();
				if(prepared_statement != null) prepared_statement.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	
	public void getAutoGeneratedPrimaryKey() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			prepared_statement = connection.prepareStatement("create table if not exists autokey ( id int not null primary key auto_increment, name varchar(45))");
			boolean status = prepared_statement.execute();
			if(status) {
				System.out.println("query is not the select kind");
			}
			else {
				int row_count = prepared_statement.getUpdateCount();
				System.out.println("row affected  is "+ row_count);
			}
			
			System.out.println("insertion of records into the table");
			
			prepared_statement = connection.prepareStatement("insert into autokey (name) values(?)",Statement.RETURN_GENERATED_KEYS);
			prepared_statement.setString(1, "Agnès");
			prepared_statement.setString(1, "julliette");
			
			int i = prepared_statement.executeUpdate();
			result_set = prepared_statement.getGeneratedKeys();
			System.out.println("total number of row inserted is  :   "+i);

			/*
			status = prepared_statement.execute();
			
			 * result_set = prepared_statement.getGeneratedKeys(); if(status) {
			 * System.out.println("query is select kind "); result_set =
			 * prepared_statement.getResultSet(); } else {
			 * System.out.println("total rows effectecd   :   "+prepared_statement.
			 * getUpdateCount()); }
			 * 
			 * System.out.println("retrieve auto generated id records from table ");
			 * //result_set = prepared_statement.getGeneratedKeys();
			 */			while(result_set!= null && result_set.next()) {
				System.out.println("the auto generated keys to the id's of the table are   :  "+result_set.getInt(1));
			}
			 System.out.println("tracing the cursor");
			 
			prepared_statement = connection.prepareStatement("select * from autokey");
			status = prepared_statement.execute();
			
			System.out.println(status);
			  if(status) {
				  result_set = prepared_statement.getResultSet();
				  while(result_set.next()) {
			  System.out.println("id  are   :  "+result_set.getInt(1)+"   name is   :   "
			  +result_set.getString(2));
			  }}
			  else {
			  System.out.println("query was not select kind  "+"affected row count is  :  "
			  + prepared_statement.getUpdateCount());
			  
			  }
			 
			
			
			
		}
		catch(ClassNotFoundException cnfe) {
			//System.out.println(cnfe.getMessage());
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			//System.out.println(se.getMessage());
			se.printStackTrace();
		}
		
	}
	
	
	public void executeStoredProcedure() {
		/**
		 * 
		 * Basically a callable statement object is used to execute the stored 
		 * procedure using the jdbc, connection.prepareCall() method
		 * used to provide the object of the callableStatement() type.
		 * 
		 * */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			callable_statement = connection.prepareCall("{call my_procedure(?,?,?,?)}");
			callable_statement.setInt(1, 6);
			callable_statement.setString(2,"Alexi");
			callable_statement.setString(3, "declaire");
			callable_statement.setString(4, "Cergy");
			int row_inserted = callable_statement.executeUpdate();
			System.out.println(row_inserted);
			
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		finally {
			try {
			if(connection != null) connection.close();
			if(callable_statement != null) callable_statement.close();
			}
			catch(SQLException  se) {
				se.printStackTrace();
			}
		}
	}
	
	
	public void executeStoredProcedureWithOutParameter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			callable_statement = connection.prepareCall("{call my_proc(?,?)}");
			callable_statement.setInt(1,2);
			callable_statement.registerOutParameter(2, Types.INTEGER);
			int output = callable_statement.getInt(2);
			System.out.println("output from procedure is  :  "+ output);
			/*
			 * boolean status = callable_statement.execute(); if(status) {
			 * System.out.println("selected query"); } else { int output =
			 * callable_statement.getUpdateCount(); }
			 */			
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		finally {
			try {
			if(connection!=null) connection.close();
			if(callable_statement!=null) callable_statement.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	
	public void executeStoredProcedureWithBatch() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			callable_statement = connection.prepareCall("{call person_proc(?,?,?,?)}");
			callable_statement.setInt(1, 1);
			callable_statement.setInt(2,43);
			callable_statement.setString(3, "hélène");
			callable_statement.setString(4, "chatillon");
			
			callable_statement.addBatch();
			callable_statement.setInt(1, 2);
			callable_statement.setInt(2, 19);
			callable_statement.setString(3, "simon");
			callable_statement.setString(4, "cergy");
			callable_statement.addBatch();
			
			int[] row_inserted = callable_statement.executeBatch();
			for(int r : row_inserted) {
				System.out.println("output of executeBatch"+ r);
			}
			/*
			 * if(status) { System.out.println("query is type of selected "); } else { int
			 * row_inserted = callable_statement.getUpdateCount();
			 * System.out.println("number of rows inserted are "+ row_inserted); }
			 */
			
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
			if(connection!=null) connection.close();
			if(callable_statement!=null) callable_statement.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	
	public void executeResultSetMetaData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			System.out.println("printing the table information");
			callable_statement = connection.prepareCall("select * from actor");
			boolean status = callable_statement.execute();
			result_set = callable_statement.getResultSet();
			result_set_meta = result_set.getMetaData();
			int column_count = result_set_meta.getColumnCount();
			for(int column =1; column<= column_count; column++) {
				System.out.print("\t"+result_set_meta.getColumnName(column));
			}
			
			if(status) {
				System.out.println("query is kind of select query");
				while(result_set.next()) {
					System.out.println("\t"+result_set.getInt(1)+"\t"
				+result_set.getString(2)+"\t"+ result_set.getString(3)
				+"\t"+result_set.getTimestamp(4));
				}
			}
			else {
				System.out.println("query is not select query "+callable_statement.getUpdateCount());
			}
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try{
			if(connection != null) connection.close();
			if(callable_statement != null) callable_statement.close();
			if(result_set != null) result_set.close();
			
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
	}
	
	
	public void executeUpdateBatchWithStatement() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			statement = connection.createStatement();
			statement.addBatch("update batchUpdate set name = 'dalida' where id = 1");
			statement.addBatch("insert into batchUpdate values("+4+",'peru', 'paris')");
			statement.addBatch("update batchUpdate set city = 'pontoise' where name = 'gabrial'");
			int[] row_status= statement.executeBatch();
			for(int row=0; row<row_status.length; row++) {
				System.out.println("result  for  number  "  + row+" Query   is  "+
			row_status[row]);
			}
			
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {			
			if(connection!=null) connection.close();
			if(statement!=null) statement.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public void executeUpdateBatchWithPrepareStatement() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			prepared_statement = connection.prepareStatement("update batchUpdate set name=?where id=?");
			prepared_statement.setString(1,"andré");
			prepared_statement.setInt(2, 4);
			prepared_statement.addBatch();
			prepared_statement.setString(1,"gabrial");
			prepared_statement.setInt(2, 2);
			prepared_statement.addBatch();
			int[] rows = prepared_statement.executeBatch();
			System.out.println(rows.length);
			for(int row=0; row<rows.length; row++) {
				System.out.println("result for the query number   :  "+row +" is   "+rows[row]);
			}
					
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
			if(connection!=null) connection.close();
			if(prepared_statement!=null) prepared_statement.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	
	public void executeScrollableResultSetInsensitiveexample() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=	DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			boolean status = statement.execute("select * from batchUpdate");
			
			
			
			if(status) {
				System.out.println("query is select kind of   :  ");
				result_set = statement.getResultSet();
				System.out.println("is cursor before first row   :   " + result_set.isBeforeFirst());
				while(result_set.next()) {
					System.out.println(result_set.getInt(1)+"\t"+result_set.getString(2)+"\t"+result_set.getString(3));
				}
			}
			
			System.out.println("is cursor is at after the last row : "+result_set.isAfterLast());
			
			while(result_set.previous()) {
				System.out.println(result_set.getInt(1) + "\t"+result_set.getString(2)+"\t"+result_set.getString(3));
			}
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		finally {
			try {
			if(connection != null ) connection.close();
			if(statement != null) statement.close();
			if(result_set != null) result_set.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	
	public void executeScrollableResultSetSensitiveExample() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			prepared_statement = connection.prepareStatement("select * from batchUpdate", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
			boolean status = prepared_statement.execute();
			if(status) {
				result_set = prepared_statement.getResultSet();
				while(result_set.next()) {
					if(result_set.getInt("id") == 4) {
						result_set.updateString(2, "phillpipe");
						result_set.updateRow();
						System.out.println(result_set.getInt(1)+"\t"+result_set.getString(2)+"\t"+result_set.getString(3));
					}
					else {
						System.out.println(result_set.getInt(1)+"\t"+result_set.getString(2)+"\t"+result_set.getString(3));
					}
				}
			}
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
			if(connection!=null) connection.close();
			if(prepared_statement!=null) prepared_statement.close();
			if(result_set!=null) result_set.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	
	public void insertImageInDatabase() {


		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek?jdbcCompliantTruncation=false","root","12345");
			prepared_statement = connection.prepareStatement("insert into photos (id,name,photo) values(?,?,?) ");
			prepared_statement.setInt(1,1);
			prepared_statement.setString(2, "Abhishek");
			InputStream binary_stream = new FileInputStream("H:\\Desktop\\discord.png");
			prepared_statement.setBinaryStream(3, binary_stream);
			
			boolean status = prepared_statement.execute();
			if(status) {
				System.out.println("query is kind of the select");
			}
			else {
				int row_affected = prepared_statement.executeUpdate();
				System.out.println(" Total  inserted rows   :  "+row_affected);
			}
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
		finally {
			try {
				if(connection!=null) connection.close();
				if(prepared_statement!= null) prepared_statement.close();
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		}
		
	
	public void getMetaDataInfoForDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			DatabaseMetaData  db= connection.getMetaData();
			System.out.println(db.getDriverName());
			System.out.println(db.getDriverVersion());
			System.out.println(db.getUserName());
			System.out.println(db.getDatabaseProductName());
			System.out.println(db.getDatabaseProductVersion());
			
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if(connection!=null) connection.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public void useOfPropertiesFile() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.put("username", "root");
			prop.put("password","12345");
		connection = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek",prop);
		System.out.println("got the connection object by using the properties ");
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		finally {
			try {
			if(connection!= null) connection.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	
	public void readImageFromDatabase() {
		InputStream input_stream=null;
		OutputStream output_stream = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","12345");
			prepared_statement = connection.prepareStatement("select * from photos where id=?");
			prepared_statement.setInt(1, 1);
			boolean status = prepared_statement.execute();
			if(status) {
				result_set = prepared_statement.getResultSet();
				while(result_set.next()) {
				System.out.println(result_set.getInt(1)+"\t"+result_set.getString(2)+"\t");
				input_stream = result_set.getBinaryStream(3);
				System.out.println("number of bytes to read "+input_stream.available());
				byte[] byte_array = new byte[input_stream.available()];
				output_stream = new FileOutputStream("H:\\\\Desktop\\\\database_image.png");
				int i = 0;
				while((i = input_stream.read())!=-1) {
					output_stream.write(i);
				}
				output_stream.flush();
				System.out.print("flushed the bytes to output stream");
				//output_stream.write(input_stream);
				/*while(input_stream.read()!=-1) {
					output_stream.write();
				}*/
				}
				
			}
			else {
				System.out.println("query is not select query");
			}
			
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
		finally {
			try {
				if(connection!=null) connection.close();
				if(prepared_statement!=null) prepared_statement.close();
				if(result_set!=null) result_set.close();
				if(input_stream != null) input_stream.close();
				if(output_stream!=null) output_stream.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(IOException io) {
				io.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		//new CreateDatabaseConnection().createConnectionMysql();
		//new CreateDatabaseConnection().createAndSelectQuery();
		//new CreateDatabaseConnection().updateARecord();
		//new CreateDatabaseConnection().executeMethodExample();
		//new CreateDatabaseConnection().preparedStatementExample();
		//new CreateDatabaseConnection().preparedStatementResultSetExample();
		//new CreateDatabaseConnection().getAutoGeneratedPrimaryKey();
		//new CreateDatabaseConnection().executeStoredProcedure();
		//new CreateDatabaseConnection().executeStoredProcedureWithOutParameter(); //doesn't work throws error
		//new CreateDatabaseConnection().executeStoredProcedureWithBatch();
		//new CreateDatabaseConnection().executeResultSetMetaData();
		//new CreateDatabaseConnection().executeUpdateBatchWithStatement();
		//new CreateDatabaseConnection().executeUpdateBatchWithPrepareStatement();
		//new CreateDatabaseConnection().executeScrollableResultSetInsensitiveexample();
		//new CreateDatabaseConnection().executeScrollableResultSetSensitiveExample();
		//new CreateDatabaseConnection().insertImageInDatabase();
		//new CreateDatabaseConnection().getMetaDataInfoForDatabase();
		//new CreateDatabaseConnection().useOfPropertiesFile();
		//new CreateDatabaseConnection().findOutput();
		new CreateDatabaseConnection().readImageFromDatabase();
	}
}
