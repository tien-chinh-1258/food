package vn.herta.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.herta.configs.DBConnectSQL;

import vn.herta.dao.IUserDao;
import vn.herta.models.UserModel;


public class UserDaoImpl extends DBConnectSQL implements IUserDao {
	

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		                     
		String sql = "SELECT id, username, password, images, fullname, email,phone,roleid,createDate FROM users";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
		conn = super.getConnection(); // ket noi database
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
             // Thêm đối tượng người dùng vào danh sách
		}
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	}
		finally {
		    try {
		        if (rs != null) rs.close();
		        if (ps != null) ps.close();
		        if (conn != null) conn.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		return null;
		}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
		conn = super.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
			
		UserModel user = new UserModel();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setImages(rs.getString("images"));
		user.setFullname(rs.getString("fullname"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setCreateDate(rs.getDate("createDate"));
		return user;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return null;
		}

	
	@Override
	public void insert(UserModel users) {
	    String sql = "INSERT INTO users(id, username, password,images, fullname, email,phone,roleid,createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	    	conn = super.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, users.getId());
	        ps.setString(2, users.getUsername());
	        ps.setString(3, users.getPassword());        	 
	        ps.setString(4, users.getImages());
	        ps.setString(5, users.getFullname());
	        ps.setString(6, users.getEmail());
	        ps.setString(7, users.getPhone());
	        ps.setInt(8, users.getRoleid());
	        ps.setDate(9, users.getCreateDate());
	        
	        ps.executeUpdate();  // Thực hiện chèn dữ liệu vào cơ sở dữ liệu
	        System.out.println("Inserted successfully!");  // Thông báo khi chèn thành công
	        
	    } catch (Exception e) {
	        e.printStackTrace();  // In ra thông tin lỗi nếu có ngoại lệ
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



	@Override
	public UserModel findByUserName(String username) {
	    String sql = "SELECT * FROM users WHERE username = ?";
	    try {
	        conn = super.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            // Lấy thông tin người dùng từ cơ sở dữ liệu
	            UserModel user = new UserModel();
	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setImages(rs.getString("images"));
	            user.setFullname(rs.getString("fullname"));
	            user.setEmail(rs.getString("email"));
	            user.setPhone(rs.getString("phone"));
	            user.setRoleid(rs.getInt("roleid"));
	            user.setCreateDate(rs.getDate("createDate"));
	            return user;
	        }
	     
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
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
