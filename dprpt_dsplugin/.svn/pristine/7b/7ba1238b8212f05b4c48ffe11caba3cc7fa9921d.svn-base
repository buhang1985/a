package test.rptbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JavaBean对象数据源示例
 */
public class Student {
	private int serno;
	
	private String name;
	private int age;
	private String sex;
	private int mark;
	
	// 医嘱测试
	private String doctorOrder = null;
	
	private Integer numNul = null;
	
	private ArrayList<Subject> subjectList = null;
	private ArrayList<Person> memberList = null;

	public Student(int serNo, String name, int age, String sex, int mark) {
		this.serno = serNo;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.mark = mark;
		
		this.subjectList = new ArrayList<Subject>();
		
		this.memberList = new ArrayList<Person>();
		this.memberList.add(new Person("父亲", "崔爸", 40, "男"));
		this.memberList.add(new Person("母亲", "崔妈", 38, "女"));
	}

	public Student(int serNo, String name, int age, int mark) {
		this.serno = serNo;
		this.name = name;
		this.age = age;
		this.mark = mark;
		
		this.subjectList = new ArrayList<Subject>();
		this.memberList = new ArrayList<Person>();
	}
	
	public int getAge() {
		return age;
	}

	public int getMark() {
		return mark;
	}
	
	public int getSerno() {
		return this.serno;
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
	
	public Integer getNumNul() {
		return this.numNul;
	}
	
	public void addSubject(String name) {
		Subject subj = new Subject();
		subj.setName(name);
		subj.setMark(80);
		
		this.subjectList.add(subj);
	}
	
	public String getDoctorOrder() {
		return this.doctorOrder;
	}
	public void setDoctorOrder(String doctorOrder) {
		this.doctorOrder = doctorOrder;
	}
	
	public List<Subject> getSubjects() {
		return this.subjectList;
	}
	
	public Iterator<Person> getMembers() {
		if(null == this.memberList) this.memberList = new ArrayList<Person>();
		
		return this.memberList.iterator();
	}
}
