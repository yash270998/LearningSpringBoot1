package com.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.dal.entities.Student;
import com.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentDalApplicationTests {
	
	@Autowired
	private StudentRepository studrepo;
	
	@Test
	public void testCreateStudent() {
		Student stud = new Student();
		stud.setName("Yash");
		stud.setCourse("Java MicroServices");
		stud.setFees(30d);
		studrepo.save(stud);
	}

}
