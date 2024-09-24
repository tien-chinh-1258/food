package vn.herta.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.herta.configs.DBConnectMySQL;
import vn.herta.configs.DBConnectSQL;
import vn.herta.dao.IUserDao;
import vn.herta.models.UserModel;


public class UserDaoImpl extends DBConnectMySQL implements IUserDao {
	

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users ";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			list.add(new UserModel(
			
			rs.getInt("id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("images"),
            rs.getString("fullname"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getInt("roleid"),
            rs.getDate("createDate")));
            return list; // Thêm đối tượng người dùng vào danh sách
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
		}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM [users] WHERE id = ? ";
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
		UserModel user = new UserModel();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setFullname(rs.getString("fullname"));
		user.setPassword(rs.getString("password"));
		user.setImages(rs.getString("images"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreateDate(rs.getDate("createDate"));
		return user;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
		}

	
	@Override
	public void insert(UserModel user) {
	    String sql = "INSERT INTO users(id, username, password,images, fullname, email,phone,roleid,createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	       
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, user.getId());
	        ps.setString(2, user.getUsername());
	        ps.setString(3, user.getPassword());
	        ps.setString(4, user.getImages());
	        ps.setString(5, user.getFullname());
	        ps.setString(6, user.getEmail());
	        ps.setString(7, user.getPhone());
	        ps.setInt(8, user.getRoleid());
	        ps.setDate(9, user.getCreateDate());
	        
	        ps.executeUpdate();  // Thực hiện chèn dữ liệu vào cơ sở dữ liệu
	        System.out.println("Inserted successfully!");  // Thông báo khi chèn thành công
	        
	    } catch (Exception e) {
	        e.printStackTrace();  // In ra thông tin lỗi nếu có ngoại lệ
	    } finally {
	        try {

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM [users] WHERE username = ? ";
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
		UserModel user = new UserModel();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setFullname(rs.getString("fullname"));
		user.setPassword(rs.getString("password"));
		user.setImages(rs.getString("images"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreateDate(rs.getDate("createDate"));
		return user;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
		}
	public static void main(String[] args) {
		try {
	    UserDaoImpl userDao = new UserDaoImpl();
	    System.out.println(userDao.findAll());
	    
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	
}
}
