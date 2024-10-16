package com.rituraj.Unit9.dao;

import java.util.List;

import com.rituraj.Unit9.entity.Course;
import com.rituraj.Unit9.entity.Instructor;
import com.rituraj.Unit9.entity.InstructorDetail;
import com.rituraj.Unit9.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager myEntityManager)
	{
		this.entityManager = myEntityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {
		
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		Instructor myinst = entityManager.find(Instructor.class, theId);
		
		entityManager.remove(myinst);
		
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		
		InstructorDetail myDetails = entityManager.find(InstructorDetail.class,theId);
		
		// remove the associated object reference
		//break the bidirectional link
		
		myDetails.getInstructor().setInstructorDetail(null);
		
		entityManager.remove(myDetails);
	}

	@Override	
	public List<Course> findCoursesByInstructorId(int theId) {
	
		 // create query
        TypedQuery<Course> query = entityManager.createQuery(
                                    "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		
		TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i" 
		+" JOIN FETCH i.courses " 
		+" JOIN FETCH i.instructorDetail"		
		+ " WHERE i.id = :data\r\n",Instructor.class);
		
		query.setParameter("data",theId);
		
		Instructor instructor  = query.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void updateInstructor(Instructor tempInstructor) {
	
		entityManager.merge(tempInstructor);		
		
	}

	@Override
	public Course findCourseById(int theId) {
		
		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void updateCourse(Course tempCourse) {
		
		entityManager.merge(tempCourse);
		
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
	
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);   //retrieve the isntructor
		
		List<Course> courses = tempInstructor.getCourses();                  //get the courses
		
		for(Course tempCourse : courses)             //break all association of courses from instructor 
		{
			tempCourse.setInstructor(null);                    //remove instructor from courses
		}
		
	    //delete instructor
		entityManager.remove(tempInstructor);
	
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
	
		//retrieve course
		Course tempCourse = entityManager.find(Course.class,theId);
		
		//remove course
		entityManager.remove(tempCourse);
	}

	@Override
	@Transactional
	public void save(Course theCourse) 
	{		
		entityManager.persist(theCourse);		
	}

	@Override
	public Course findCourseAndReviewByCourseId(int theId) {
		
		//create query
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c " 
				              +"JOIN FETCH c.reviews "
				              +"where c.id = :data", Course.class);
		
		query.setParameter("data", theId);
		
		//execute query
		Course course = query.getSingleResult();
		
		return course;
	}

	@Override
	public Course findCourseAndStudentByCourseId(int theId) {
		//create query
				TypedQuery<Course> query = entityManager.createQuery("select c from Course c " 
						              +"JOIN FETCH c.students "
						              +"where c.id = :data", Course.class);
				
				query.setParameter("data", theId);
				
				//execute query
				Course course = query.getSingleResult();
				
		return course;
	}

	@Override
	public Student findStudentAndCoursesByStudentId(int theId) {
		
		//create query 
		TypedQuery<Student> query = entityManager.createQuery("select s from Student s " 
	              +"JOIN FETCH s.courses "
	              +"where s.id = :data", Student.class);

         query.setParameter("data", theId);
         
		//execute query
		Student student = query.getSingleResult();
		
		return student;
	}

	@Override
	@Transactional
	public void update(Student tempStudent) {		
	  entityManager.merge(tempStudent);	
	}

	@Override
	@Transactional
	public void deleteStudentById(int theId) {		
		
		//retrieve stduent
		Student tempStudent = entityManager.find(Student.class, theId);
		
		//delete the student
		entityManager.remove(tempStudent);
	}
	

}
