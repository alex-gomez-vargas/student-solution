package studentSolution.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import studentSolution.entity.Student;

/**
 * @author alex.gomez
 *
 */
public class StudentManagement {

	/**
	 * @param args
	 * @throws Exception
	 */
	public void createStudent(String[] args) throws Exception {
		Student student = ParseStudent.parse(args);
		Timestamp update = new Timestamp(new Date().getTime());
		student.setUpdate(update);		
		StudentRepository.getStudents().add(student);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public void deleteStudent(String[] args) throws Exception {
		Student student = ParseStudent.parse(args);
		StudentRepository.getStudents().remove(student);
	}

	/**
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public List<Student> searchStudents(String[] args) throws Exception {
		List<Student> searchResult = new ArrayList<Student>();
		Student searchCriterias = ParseStudent.parse(args);

		List<Student> students = StudentRepository.getStudents();
		if (args.length > 0) {
			for (Student student : students) {
				if (student.equals(searchCriterias)) {
					searchResult.add(student);
				}
			}
		} else {
			searchResult.addAll(students);
		}

		Collections.sort(searchResult);

		return searchResult;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public void createStudentOnCSV(String[] args) throws Exception {
		Student student = ParseStudent.parse(args);
		Timestamp update = new Timestamp(new Date().getTime());
		student.setUpdate(update);
		StudentRepository.createStudentOnCSV(student);
	}
}
