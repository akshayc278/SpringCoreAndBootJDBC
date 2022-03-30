package com.tech.tab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tech.tab.ConfigurationOne;
import com.tech.tab.DBConfiguration;
import com.tech.tab.model.Student;


@Repository
public class RepositoryOne {
	
	@Autowired
	private ConfigurationOne ConfigurationOne;
	@Autowired
	private DBConfiguration dBConfiguration;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Student> addInList(Student s){
		List<Student> list= ConfigurationOne.getStudent();
		list.add(s);
		return list;
	}
	public boolean addInDB(Student s) throws SQLException{
		Connection con=dBConfiguration.getConnection();
		String sql="INSERT INTO `Student`(`sid`, `sname`) VALUES (?,?)";
		System.out.println(con);
		PreparedStatement pr=con.prepareStatement(sql);
		pr.setInt(1, s.getId());
		pr.setString(2, s.getName());
		int i=pr.executeUpdate();
		return i==1;
	}
	public  List<Student> getStudentFromDB() throws SQLException{
		Connection con=dBConfiguration.getConnection();
		System.out.println(con);
		String sql="select * from Student";
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		List<Student> list=new LinkedList<>();
		while (rs.next()) {
			int sid=rs.getInt(1);
			String sname=rs.getString(2);
			//System.out.println(sid+ " "+sname);
			Student temp=new Student(sid,sname);
			list.add(temp);
		}
		return list;		
		
	}
	
	public List<Student> getStudentSpringJDBC(){
		String sql="select * from Student";
		
		List<Student> list =jdbcTemplate.query(sql,new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s=new Student(rs.getInt("sid"),rs.getString("sname"));
				return s;
			}
			
		});
		return list;
	}
	
	public boolean deleteFromDB(Integer id) {
		String sql="delete from Student where sid=?";
		int noOfRows=jdbcTemplate.update(sql, new Object[] {id});
		return noOfRows>=0;
	}
}
