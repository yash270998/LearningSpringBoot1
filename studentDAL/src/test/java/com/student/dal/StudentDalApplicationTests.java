package com.student.dal;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.dal.entities.Student;
import com.student.dal.repos.StudentRepository;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

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
	
	@Test
	public void testFindStudentByID() {
		
		Optional<Student> studOptional = studrepo.findById(1);
		if(studOptional.isPresent()) {
			System.out.println(studOptional.get());
		}
		
	}
	@Test
	public void testUpdateStudent() {
		
		Optional<Student> studOptional = studrepo.findById(1);
		if(studOptional.isPresent()) {
//			System.out.println(studOptional.get());
			Student stud = studOptional.get();
			stud.setFees(40d);
			studrepo.save(stud);
		}
		
	}
	
	@Test
	public void testDeleteStudent() {
//		Student stud = new Student();
//		stud.setId(1);
//		studrepo.delete(stud);
		studrepo.deleteById(1);
		
	}
}
