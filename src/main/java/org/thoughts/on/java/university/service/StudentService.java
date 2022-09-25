package org.thoughts.on.java.university.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.thoughts.on.java.university.model.Student;

public class StudentService {

	private EntityManager em;
	
	public StudentService(EntityManager em) {
		this.em = em;
	}
	
	public Student saveStudent(Student s) {
		em.persist(s);
		return s;
	}
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	public void removeStudent(Student s) {
		em.remove(s);
	}
	
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName) {
		TypedQuery<Student> q = em.createNamedQuery(Student.QUERY_STUDENT_BY_FIRSTNAME_AND_LASTNAME, Student.class);
		q.setParameter(Student.PARAM_FIRSTNAME, firstName);
		q.setParameter(Student.PARAM_LASTNAME, lastName);
		return q.getResultList();
	}
}
