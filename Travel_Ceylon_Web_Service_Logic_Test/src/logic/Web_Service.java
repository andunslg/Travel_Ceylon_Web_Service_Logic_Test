import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Web_Service {
	private String url;
	private Connection con;
	private Statement stmt;

	public void connectToDB() {
		url = "jdbc:mysql://localhost:3306/sms";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			System.out.println("Error - Unable to Connect to the Database" + e);

		}
	}

	public ArrayList<String> getCategories() {
		ArrayList<String> catList = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from category");

			while (rs.next()) {
				catList.add(rs.getString("Category"));
			}
		} catch (SQLException e) {
			System.out.println("Error - Unable to get Categories" + e);
		}
		return catList;
	}
}
