package iih.ci.mr.easyrules.samples.rulepriority;

/**
 * Person class.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Person {

	private String name;

	private int age;

	private boolean adult;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

}