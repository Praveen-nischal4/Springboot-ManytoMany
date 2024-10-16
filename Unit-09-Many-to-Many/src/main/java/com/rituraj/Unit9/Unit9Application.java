package com.rituraj.Unit9;

import com.rituraj.Unit9.dao.AppDAO;
import com.rituraj.Unit9.entity.Course;
import com.rituraj.Unit9.entity.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Unit9Application {

	public static void main(String[] args) {
		SpringApplication.run(Unit9Application.class, args);
	}

	@Bean	
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner -> {			
			
			//createCourseAndStudents(appDAO);
			
			//findCourseAndStudents(appDAO);
			
			//finsStudentAndCourses(appDAO);
			
			//addMoreCoursesForStudent(appDAO);
			
			//deleteCourse(appDAO);
			
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		
		int theId =2;
		
		System.out.println("Deleting Student with id :"+theId);
		
		appDAO.deleteStudentById(theId);
		
		System.out.println("Done!!!!");
		
	}

	/*
	 * private void deleteCourse(AppDAO appDAO) {
	 * 
	 * int theId =10;
	 * 
	 * System.out.println("Deleting course with id :"+theId);
	 * 
	 * appDAO.deleteCourseById(theId);
	 * 
	 * System.out.println("Done!!!!!!!!"); }
	 */

	/*
	 * private void addMoreCoursesForStudent(AppDAO appDAO) {
	 * 
	 * int theId=2;
	 * 
	 * Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
	 * 
	 * //create more courses for Students Course tempCourse = new
	 * Course("Beginner to Pro -Spring Cloud"); Course tempCourse1 = new
	 * Course("AWS -Beginner to Professional"); Course tempCourse2 = new
	 * Course("Web development using React"); Course tempCourse3 = new
	 * Course("RESTAPI course using Spring Framework");
	 * 
	 * //add courses to student tempStudent.addCourse(tempCourse);
	 * tempStudent.addCourse(tempCourse1); tempStudent.addCourse(tempCourse2);
	 * tempStudent.addCourse(tempCourse3);
	 * 
	 * //save System.out.println("Updating Students :"+tempStudent);
	 * System.out.println("Associated Courses :"+tempStudent.getCourses());
	 * 
	 * appDAO.update(tempStudent); //this will update students and also save
	 * associated courses
	 * 
	 * System.out.println("Done!!!!!"); }
	 */
	
	
	
	/*
	 * private void finsStudentAndCourses(AppDAO appDAO) {
	 * 
	 * int theId=2;
	 * 
	 * Student tempStudent =appDAO.findStudentAndCoursesByStudentId(theId);
	 * 
	 * System.out.println("Loaded Student :"+tempStudent);
	 * System.out.println("Associated Courses : "+tempStudent.getCourses());
	 * 
	 * System.out.println("Done!!!!");
	 * 
	 * }
	 */
	
	
	
	

	/*
	 * private void findCourseAndStudents(AppDAO appDAO) {
	 * 
	 * int theId=10;
	 * 
	 * Course tempCourse = appDAO.findCourseAndStudentByCourseId(theId);
	 * 
	 * System.out.println("Loaded Course : "+tempCourse);
	 * System.out.println("Associated Students :"+tempCourse.getStudents());
	 * 
	 * System.out.println("Done!!!!!"); }
	 */
	/*
	 * private void createCourseAndStudents(AppDAO appDAO) {
	 * 
	 * //create Course Course tempCourse = new
	 * Course("Beginner to Master -Spring Boot");
	 * 
	 * //create Students Student tempStudent1 = new
	 * Student("Deepika"," Tripathi","deepatripathi478@gmail.com"); Student
	 * tempStudent2 = new Student("Kashish"," Rizvi","rizvikashsih478@gmail.com");
	 * 
	 * //add student to course tempCourse.addStudents(tempStudent1);
	 * tempCourse.addStudents(tempStudent2);
	 * 
	 * //save the courses and associated Students
	 * System.out.println("Saving the course :"+tempCourse);
	 * System.out.println("Saving Associated Students :"+tempCourse.getStudents());
	 * 
	 * appDAO.save(tempCourse); System.out.println("Done !!!"); }
	 */
	
}
