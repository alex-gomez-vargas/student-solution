package studentSolution.logic;

import java.lang.reflect.Field;

import studentSolution.entity.Student;

/**
 * @author alex.gomez
 *
 */
public class ParseStudent {
	/**
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public static Student parse(String[] args) throws Exception {
		Student student = new Student();
		for (String attribute : args) {
			String[] keyValue = attribute.split("=");
			String key = keyValue[0];
			String value = keyValue[1];

			Field field = student.getClass().getDeclaredField(key);
			field.setAccessible(true);
			field.set(student, value);
		}

		return student;
	}
}
