package studentSolution.entity;

import java.sql.Timestamp;

/**
 * @author alex.gomez
 *
 */
public class Student implements Comparable<Student> {
	private String type;
	private String name;
	private String gender;
	private Timestamp update;

	public Student() {
	}

	/**
	 * @param type
	 * @param name
	 * @param gender
	 * @param update
	 */
	public Student(String type, String name, String gender, Timestamp update) {
		this.type = type;
		this.name = name;
		this.gender = gender;
		this.update = update;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the update
	 */
	public Timestamp getUpdate() {
		return update;
	}

	/**
	 * @param update
	 *            the update to set
	 */
	public void setUpdate(Timestamp update) {
		this.update = update;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [type=" + type + ", name=" + name + ", gender=" + gender + ", update=" + update + "]";
	}

	public int compareTo(Student otherStudent) {
		return otherStudent.getUpdate().compareTo(this.getUpdate());
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;

		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Student))
			return false;

		Student otherStudent = (Student) other;

		if ((otherStudent.type == null || otherStudent.type.equals(type))
				&& (otherStudent.name == null || otherStudent.name.equals(name))
				&& (otherStudent.gender == null || otherStudent.gender.equals(gender))) {
			result = true;
		}

		return result;
	}
}
