package studentSolution.logic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import studentSolution.entity.Student;

/**
 * @author alex.gomez
 *
 */
public class StudentRepository {
	private static String path;
	private static List<Student> students;

	/**
	 * @param pathCSV
	 * @throws Exception
	 */
	public static void setPath(String pathCSV) throws Exception {
		path = pathCSV;
	}

	/**
	 * @param studentsCSV
	 */
	public static void setStudents() throws Exception {
		Reader in = new FileReader(path);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("type", "name", "gender", "update").parse(in);
		List<Student> studentsCSV = new ArrayList<Student>();
		for (CSVRecord record : records) {
			String type = record.get("type");
			String name = record.get("name");
			String gender = record.get("gender");

			String updateString = record.get("update");
			DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
			Date parsedDate = df.parse(updateString);
			Timestamp update = new Timestamp(parsedDate.getTime());

			Student student = new Student(type, name, gender, update);
			studentsCSV.add(student);
		}
		students = studentsCSV;
	}

	/**
	 * @param student
	 * @throws Exception
	 */
	public static void createStudentOnCSV(Student student) throws Exception {
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
		try {
			fileWriter = new FileWriter(path, true);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

			List<String> row = new ArrayList<String>();
			row.add(student.getType());
			row.add(student.getName());
			row.add(student.getGender());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String updateString = sdf.format(student.getUpdate());
			row.add(updateString);
			csvFilePrinter.printRecord(row);

			System.out.println(row);
		} finally {
			fileWriter.flush();
			fileWriter.close();
			csvFilePrinter.close();
		}
	}

	/**
	 * @return List Students
	 */
	public static List<Student> getStudents() {
		return students;
	}
}
