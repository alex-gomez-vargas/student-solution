package studentSolution;

import java.util.Arrays;
import java.util.List;

import studentSolution.entity.Student;
import studentSolution.exception.StudentSolutionException;
import studentSolution.logic.StudentManagement;
import studentSolution.logic.StudentRepository;

/**
 * @author alex.gomez
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			if (args.length < 2) {
				throw new StudentSolutionException("Arguments required: CSV Path, Operation, Student args");
			}
			StudentRepository.setPath(args[0]);
			StudentRepository.setStudents();
			StudentManagement sm = new StudentManagement();
			String[] studentArgs = Arrays.copyOfRange(args, 2, args.length);

			String operation = args[1].toLowerCase();
			switch (operation) {
			case "create":
				sm.createStudent(studentArgs);
				for (Student student : StudentRepository.getStudents()) {
					System.out.println(student);
				}
				break;
			case "delete":
				sm.deleteStudent(studentArgs);
				for (Student student : StudentRepository.getStudents()) {
					System.out.println(student);
				}
				break;
			case "search":
				List<Student> students = sm.searchStudents(studentArgs);
				for (Student student : students) {
					System.out.println(student);
				}
				break;
			case "create_on_csv":
				sm.createStudentOnCSV(studentArgs);
				StudentRepository.setStudents();
				for (Student student : StudentRepository.getStudents()) {
					System.out.println(student);
				}
				break;
			default:
				throw new StudentSolutionException("Invalid Operation");
			}
		} catch (StudentSolutionException e) {
			System.out.println(e.getUserMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
