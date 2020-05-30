package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.ProductBean;
import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public static Boolean insertUser(UserBean userBean) throws SQLException {
		
		boolean flag=false;
		Connection con=DbConnection.getConnection();
			
		String insertQuery="insert into user(userId,name,email,password) values (?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(insertQuery);
		
		pstmt.setInt(1, userBean.getUserId());
		pstmt.setString(2, userBean.getFirstName());
		pstmt.setString(3, userBean.getEmail());
		pstmt.setString(4, userBean.getPassword());
		
		int i = pstmt.executeUpdate();
		if(i==1) {
			flag =  true;
		}
		return flag;
	}
public ArrayList<UserBean> getUsers()  {
		
		ArrayList<UserBean>  users = new ArrayList<UserBean>();
		Connection con = DbConnection.getConnection();
		Statement stmt = null;
		
		try {
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("userId"));
				user.setFirstName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				users.add(user);
				
			}
		}catch(Exception e) {
			System.out.println("Error in getUser in Userdao");
		}
		return users;
	}
public static boolean insertProduct(ProductBean p) throws SQLException, ClassNotFoundException {
	boolean flag = false;
	
	
	
	
	Connection con = DbConnection.getConnection();
	String insertQuery = "insert into Products (productsId,name,details,price) values (?,?,?,?)";
	PreparedStatement psmt = con.prepareStatement(insertQuery);
	psmt.setInt(1, p.getProductId());
	psmt.setString(2, p.getName());
	psmt.setString(3, p.getDetails());
	psmt.setInt(4, p.getPrice());
	int i = psmt.executeUpdate();
	if(i==1) {
		flag =  true;
	}
		
	return flag;
	
}
public void deleteProduct(int productId) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String deleteQuery = "delete from products where productId = ?";

	try {
		con = DbConnection.getConnection();
		pstmt = con.prepareStatement(deleteQuery);
		pstmt.setInt(1, productId);
		pstmt.executeUpdate();
	} catch (Exception e) {
		System.out.println("Exce. in userdao->delteUser() => " + e.getMessage());
	} finally {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {

		}
	}
}
public ArrayList<ProductBean> getProducts()  {
	
	ArrayList<ProductBean>  products = new ArrayList<ProductBean>();
	Connection con = DbConnection.getConnection();
	Statement stmt = null;
	
	try {
		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from products");
		while(rs.next()) {
			ProductBean p = new ProductBean();
			p.setProductId(rs.getInt("productsId"));
			p.setName(rs.getString("name"));
			p.setDetails(rs.getString("details"));
			p.setPrice(rs.getInt("price"));
			products.add(p);
		}
	}catch(Exception e) {
		System.out.println("Error in getUser in Userdao");
	}
	return products;
}

public void deleteUser(int userId) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String deleteQuery = "delete from user where userid = ?";

	try {
		con = DbConnection.getConnection();
		pstmt = con.prepareStatement(deleteQuery);
		pstmt.setInt(1, userId);
		pstmt.executeUpdate();
	} catch (Exception e) {
		System.out.println("Exce. in userdao->delteUser() => " + e.getMessage());
	} finally {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {

		}
	}
}
public UserBean getDataByPk(int userId) {
	UserBean user = new UserBean();
	Connection con = DbConnection.getConnection();
	Statement stmt = null;

	try {
		stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from user where userid = " + userId);

		rs.next();
		user.setUserId(rs.getInt("userId"));
		user.setFirstName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
	} catch (Exception e) {
		System.out.println("something went wrong in getusersbypk==>" + e.getMessage());
	}

	return user;

}
public void updateUser(UserBean bean) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String updateQuery = "update user set name = ? , email = ? where userId = ?";

	try {
		con = DbConnection.getConnection();
		pstmt = con.prepareStatement(updateQuery);
		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getEmail());
		pstmt.setInt(3, bean.getUserId());
		pstmt.executeUpdate();
	} catch (Exception e) {
		System.out.println("Exce. in userdao->updateUser() => " + e.getMessage());
	} finally {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {

		}
	}

}
public void updateUserPW(UserBean bean) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String updateQuery = "update user set password = ? where userId = ?";

	try {
		con = DbConnection.getConnection();
		pstmt = con.prepareStatement(updateQuery);
		pstmt.setString(1, bean.getPassword());
		pstmt.setInt(2, bean.getUserId());
		pstmt.executeUpdate();
	} catch (Exception e) {
		System.out.println("Exce. in userdao->updateUserPW() => " + e.getMessage());
	} finally {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {

		}
	}

}
}
