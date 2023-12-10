package com.studies.cruddemo;

import com.studies.cruddemo.dao.StudentDAO;
import com.studies.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student student = new Student("Daffy", "Duck", "daffy@uni.com");

		System.out.println("Saving the student ...");
		studentDAO.save(student);

		int id = student.getId();
		System.out.println("Saved student. Generated id: " + id);

		System.out.println("Retrieving student with id: " + id);
		Student foundStudent = studentDAO.findById(id);

        System.out.println("Found student: " + foundStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new student objects ...");
		Student student = new Student("John", "Doe", "john@uni.com");
		Student student2 = new Student("Mary", "Public", "mary@uni.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita@uni.com");

		System.out.println("Saving the students ...");
		studentDAO.save(student);
        studentDAO.save(student2);
        studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student student = new Student("Paul", "Doe", "paul@uni.com");

		System.out.println("Saving the student ...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());
	}
}
