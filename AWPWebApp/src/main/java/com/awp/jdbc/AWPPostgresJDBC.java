package com.awp.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.awp.model.Account;
import com.awp.model.Booking;
import com.awp.model.Room;

@Stateless
public class AWPPostgresJDBC {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/aws";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";

	public Connection getDBconnection() {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}

	public List<Booking> getBookings() throws SQLException {
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT * from bookings";

		try {
			dbConnection = getDBconnection();
			statement = dbConnection.createStatement();
			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {
				Booking booking = new Booking();
				booking.setId(rs.getInt("id"));
				booking.setAccountId(rs.getInt("user"));
				booking.setRoomId(rs.getInt("room"));
				booking.setStartDate(rs.getDate("start"));
				booking.setEndDate(rs.getDate("end"));
				
				bookings.add(booking);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return bookings;
	}

	public void addBooking(Booking booking) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO bookings"
				+ "(id, room, user, start, end)"
				+ " VALUES(?,?,?,?,?)";

		try {
			dbConnection = getDBconnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, booking.getId());
			preparedStatement.setInt(2, booking.getRoomId());
			preparedStatement.setInt(3, booking.getAccountId());
			preparedStatement.setDate(4, new Date(booking.getStartDate().getTime()));
			preparedStatement.setDate(5, new Date(booking.getEndDate().getTime()));

			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	public void removeBooking(int id) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String deleteSQL = "DELETE FROM bookings WHERE id = ?";

		try {
			dbConnection = getDBconnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			// execute delete SQL stetement
			preparedStatement.executeUpdate();
			System.out.println("Record is deleted!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	public boolean checkBooking(Booking bk) throws SQLException {
		List<Booking> bookings = getBookings();
		boolean ok = true;
		for(Booking booking : bookings) {
			if(bk.getRoomId() == booking.getRoomId()) {
				System.out.println(bk.getStartDate());
				System.out.println(booking.getEndDate());
				System.out.println(bk.getStartDate().before(booking.getEndDate()));
				if((bk.getStartDate().after(booking.getStartDate()) && 
						bk.getStartDate().before(booking.getEndDate())) || 
						(bk.getEndDate().after(booking.getStartDate())) && 
						bk.getEndDate().before(booking.getEndDate())) {
					ok = false;
				}
			}
		}
		return ok;
	}
	
	public void createUser(Account account) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO users"
				+ "(id, email, password, card_nb, first_name, last_name, address, city, country, is_admin, phone)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = getDBconnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setLong(1, account.getId());
			preparedStatement.setString(2, account.getEmail());
			preparedStatement.setString(3, account.getPassword());
			preparedStatement.setString(4, account.getCardNb());
			preparedStatement.setString(5, account.getFirstName());
			preparedStatement.setString(6, account.getLastName());
			preparedStatement.setString(7, account.getAddress());
			preparedStatement.setString(8, account.getCity());
			preparedStatement.setString(9, account.getCountry());
			preparedStatement.setBoolean(10, account.isAdmin());
			preparedStatement.setString(11, account.getPhoneNb());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	public List<Room> getRooms() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		List<Room> rooms = new ArrayList<Room>();

		String selectTableSQL = "SELECT nr, guests, price, description from rooms";

		try {
			dbConnection = getDBconnection();
			statement = dbConnection.createStatement();
			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {
				int roomId = rs.getInt("nr");
				int guestsNb = rs.getInt("guests");
				double price = rs.getDouble("price");
				String description = rs.getString("description");

				Room room = new Room();
				room.setId(roomId);
				room.setPersonNb(guestsNb);
				room.setPrice(price);
				room.setDescription(description);

				System.out.println(room.getDescription());
				rooms.add(room);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return rooms;
	}

	public Account getUser(String email) throws SQLException {
		Account account = null;

		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT * from users where email='" + email + "'";

		try {
			dbConnection = getDBconnection();
			statement = dbConnection.createStatement();
			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			if(rs.next()) {
				account = new Account();
				account.setEmail(rs.getString("email"));
				account.setPassword(rs.getString("password"));
				account.setFirstName(rs.getString("first_name"));
				account.setLastName(rs.getString("last_name"));
				account.setAddress(rs.getString("address"));
				account.setCardNb(rs.getString("card_nb"));
				account.setCity(rs.getString("city"));
				account.setCountry(rs.getString("country"));
				account.setPhoneNb(rs.getString("phone"));
				account.setAdmin(rs.getBoolean("is_admin"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

		return account;
	}

	public static void main(String[] args) throws ParseException {
		AWPPostgresJDBC jdbc = new AWPPostgresJDBC();
		try {
//			Account account = new Account();
//			account.setEmail("user4@aws.com");
//			account.setPassword("pass");
//			account.setAddress("bla");
//			account.setCardNb("43432554");
//			account.setCity("Rome");
//			account.setCountry("Italy");
//			account.setFirstName("Bla");
//			account.setLastName("BLA");
//			account.setPhoneNb("fdfsdfsf");
//			account.setId(4);
//			jdbc.createUser(account);
			System.out.println(jdbc.getUser("user4@aws.com").getCity());
			
			Booking booking = new Booking();
			booking.setAccountId(2);
			booking.setId(3);
			booking.setRoomId(101);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			booking.setStartDate(format.parse("2016-02-14"));
			booking.setEndDate(format.parse("2016-02-17"));
			System.out.println(jdbc.checkBooking(booking));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
