package test.rptbean;

/**
 * JavaBean关联子对象数据源示例，在 [Student.getMembers] 中调用
 */
public class Person {
	private String relations;
	private String name;
	private int age;
	private String sex;

	public Person(String relations, String name, int age, String sex) {
		this.relations = relations;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRelations() {
		return relations;
	}

	public void setRelations(String relations) {
		this.relations = relations;
	}
}
