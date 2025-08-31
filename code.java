package com.gqt.Assignement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//Connecting to the database 
class DataBaseOperation1 {
	String url = "jdbc:mysql://localhost:3306/gqt";
	String userName = "root";
	String password = "Vinayak#2002";
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query1 = "CREATE TABLE IF NOT EXISTS course"
			+ "(Id INT, Course_name VARCHAR(20), Course_fees FLOAT, Course_duration VARCHAR(30))";

	// Creating table
	public void createTable() {
		try {
			// loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded !!!");

			// establishing the connection
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("connection done!!!");

			// statement object
			stmt = con.createStatement();

			// execute query
			stmt.execute(query1);
			System.out.println("Table 'course' Created!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// inserting Records
	public void inserting() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded !!!");

			con = DriverManager.getConnection(url, userName, password);
			System.out.println("connection done!!!");

			pstmt = con.prepareStatement("INSERT INTO course VALUES(?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			for (int i = 1; i <= 6; i++) {
				System.out.println("Enter the course id :");
				int cid = sc.nextInt();

				System.out.println("Enter the course name :");
				String cname = sc.next();

				System.out.println("Enter the course fees :");
				float cfees = sc.nextFloat();

				System.out.println("Enter the course duration :");
				String cduration = sc.next();

				pstmt.setInt(1, cid);
				pstmt.setString(2, cname);
				pstmt.setFloat(3, cfees);
				pstmt.setString(4, cduration);

				pstmt.addBatch();
				pstmt.executeBatch();
				System.out.println("1 Course added to the batch...\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// modifying Records
	public void modifying() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded !!!");

			con = DriverManager.getConnection(url, userName, password);
			System.out.println("connection done!!!");

			pstmt = con.prepareStatement("UPDATE course SET Course_duration = ? WHERE Id = ?");
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the course id :");
			int cid = sc.nextInt();

			System.out.println("Enter the new duration :");
			String cduration = sc.next();

			pstmt.setString(1, cduration);
			pstmt.setInt(2, cid);

			pstmt.executeUpdate();
			System.out.println("Course updated!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// displaying Records
	public void retrieving() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!!!");

			con = DriverManager.getConnection(url, userName, password);
			System.out.println("connection done!!!");

			String query = "SELECT * FROM course";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			System.out.println("\n======= Course Table Data =======");

			while (rs.next()) {
				int cid = rs.getInt("Id");
				String cname = rs.getString("Course_name");
				float cfees = rs.getFloat("Course_fees");
				String cduration = rs.getString("Course_duration");

				System.out.printf("%-5d %-20s %-10.2f %-15s\n", cid, cname, cfees, cduration);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// Deleting Records
	public void deleting() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!!!");

			con = DriverManager.getConnection(url, userName, password);
			System.out.println("connection done!!!");

			pstmt = con.prepareStatement("DELETE FROM course WHERE Id = ?");
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the course id :");
			int cid = sc.nextInt();
			pstmt.setInt(1, cid);

			pstmt.executeUpdate();
			System.out.println("Course deleted...!! \n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// Exiting
	public void EXIT() {
		System.out.println("Thank you for using the Course Management System.\nHave a great day!");
		System.exit(0);
	}
}

public class assignment02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DataBaseOperation1 dbo = new DataBaseOperation1();

		while (true) {
			System.out.println("\n========= COURSE MENU =========");
			System.out.println("1. Create Course Table");
			System.out.println("2. Insert Courses");
			System.out.println("3. Modify Course Duration");
			System.out.println("4. Retrieve All Courses");
			System.out.println("5. Delete Course");
			System.out.println("6. Exit");
			System.out.println("===============================");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				dbo.createTable();
				break;
			case 2:
				dbo.inserting();
				break;
			case 3:
				dbo.modifying();
				break;
			case 4:
				dbo.retrieving();
				break;
			case 5:
				dbo.deleting();
				break;
			case 6:
				dbo.EXIT();
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}

}
