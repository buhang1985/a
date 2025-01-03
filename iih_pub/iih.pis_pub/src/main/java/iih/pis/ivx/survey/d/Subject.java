package iih.pis.ivx.survey.d;

import java.util.ArrayList;

public class Subject {
	
	//题目id
	private String id_subject;
	
	//题目名称
	private String name;
	
	//题目分值
	private double score;
	
	//题型
	private int type;
	
	//图片
	private byte[] picture;
	
	//回答内容
	private String content;
	
	//选项列表
	private ArrayList<Option> optionList;
	
	// 已选择选项
	private ArrayList<String> selectedOptionList;
	
	public String getId_subject() {
		return id_subject;
	}

	public void setId_subject(String id_subject) {
		this.id_subject = id_subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<Option> getOptionList() {
		return optionList;
	}

	public void setOptionList(ArrayList<Option> optionList) {
		this.optionList = optionList;
	}

	public ArrayList<String> getSelectedOptionList() {
		return selectedOptionList;
	}

	public void setSelectedOptionList(ArrayList<String> selectedOptionList) {
		this.selectedOptionList = selectedOptionList;
	}

}
