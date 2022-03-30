package com.tech.tab.comtroller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.tab.model.Student;
import com.tech.tab.service.ServiceOne;

@RestController
@RequestMapping("/api")
public class ControllerOne {
	
	@Autowired
	private ServiceOne serviceOne;
	
	@GetMapping("/demo")
	public void demo() {
		serviceOne.getinfo();
		System.out.println("hello");
	}
	
	@GetMapping("/students")
	public List<Student> getStudentOne() {
		
		return serviceOne.getStudent();
	}
	@GetMapping("/studentsdb")
	public List<Student> getStudentsFromDB() throws SQLException {
		return serviceOne.getStudentFromDb();
	}
	@GetMapping("/getspringdb")
	public List<Student> getStudentsFromSpringDB() throws SQLException {
		return serviceOne.getStudentFromSpringDb();
	}
	
	@PostMapping("/post")
	public List<Student> postnewStudent(@RequestBody Student s ){
		return serviceOne.postNewStudent(s);
		//serviceOne.getStudentFromDb();
	}
	@PostMapping("/postdb")
	public boolean postnewStudentInDB(@RequestBody Student s ){
		try {
			return serviceOne.postNewStudentInDB(s);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteFromDB(@PathVariable Integer id) {
		return serviceOne.deleteFromDb(id);
	}
}
