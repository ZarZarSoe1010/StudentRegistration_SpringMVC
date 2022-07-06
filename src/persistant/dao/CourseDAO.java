package persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import persistant.dto.CourseRequestDTO;
import persistant.dto.CourseResponseDTO;
@Service("courseDao")
public class CourseDAO {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public int insertCourse(CourseRequestDTO dto) {
		int result = 0;
		String sql = "insert into course(cid,name)values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCid());
			ps.setString(2, dto.getName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database insert ERROR!!");
		}
		return result;
	}

	public ArrayList<CourseResponseDTO> selectAll() {
		ArrayList<CourseResponseDTO> list = new ArrayList<>();
		String sql = "select * from course";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CourseResponseDTO res = new CourseResponseDTO();
				res.setCid(rs.getString("cid"));
				res.setName(rs.getString("name"));
				list.add(res);
			}
		} catch (SQLException e) {
			System.out.println("Database select all error!!");
		}
		return list;

	}

}
