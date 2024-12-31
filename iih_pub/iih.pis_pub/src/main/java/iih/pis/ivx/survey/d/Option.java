package iih.pis.ivx.survey.d;

public class Option {
	
	//选项id
	private String id_option;
	
	//选项名称
	private String name;
	
	//选项分值
	private double score;
	
	//勾选记录id
	private String record;
	
	//是否勾选
	private boolean check;
	
	//图片
	private byte[] picture;

	public String getId_option() {
		return id_option;
	}

	public void setId_option(String id_option) {
		this.id_option = id_option;
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

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
}
