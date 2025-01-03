package iih.pis.ivx.survey.d;

import java.util.ArrayList;

public class Questionnaire {
	
	//问卷模板id
	private String id_moudle;
	
	//问卷名称
	private String name;
	
	//问卷描述
	private String des;
	
	//发送记录id
	private String record;
	
	//问卷是否已经完成
	private boolean finish;
	
	//试题总数
	private int count;
	
	//图片
	private byte[] picture;
	
	//开始时间
	private String beginDate;
	
	//结束时间
	private String endDate;
	
	//题目集合
	private ArrayList<Subject> subjectList;

	public String getId_moudle() {
		return id_moudle;
	}

	public void setId_moudle(String id_moudle) {
		this.id_moudle = id_moudle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
}
