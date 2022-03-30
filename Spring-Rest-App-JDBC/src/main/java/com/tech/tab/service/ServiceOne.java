package com.tech.tab.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.tab.DBConfiguration;
import com.tech.tab.model.Student;
import com.tech.tab.repository.RepositoryOne;

@Service
public class ServiceOne {

	@Autowired
	private String getClassName1;

	@Autowired
	private List<Student> getStudent;

	@Autowired
	private RepositoryOne repositoryOne;

//	public ServiceOne(String getClassName3) {
//		this.getClassName5=getClassName3;
//		System.out.println(getClassName5);
//	}

//	public ServiceOne(List<Student> getStudent) {
//		this.getStudent3=getStudent;
//		System.out.println(getStudent+"kk");
//	}

//	public void setGetClassName(String getClassName) {
//		this.getClassName = getClassName;
//		
//	}
	public void getinfo() {
		System.out.println(getClassName1);
	}

	public List<Student> getStudent() {

		return getStudent;

	}

	public List<Student> getStudentFromDb() throws SQLException {

		return repositoryOne.getStudentFromDB();

	}

	public List<Student> postNewStudent(Student s) {

		return repositoryOne.addInList(s);

	}

	public boolean postNewStudentInDB(Student s) throws SQLException {

		return repositoryOne.addInDB(s);

	}

	public List<Student> getStudentFromSpringDb() throws SQLException {

		return repositoryOne.getStudentSpringJDBC();

	}
	public boolean deleteFromDb(Integer id) {
		return repositoryOne.deleteFromDB(id);
	}

}
