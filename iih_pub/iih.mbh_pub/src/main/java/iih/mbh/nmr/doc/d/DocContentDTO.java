package iih.mbh.nmr.doc.d;

import java.util.List;

public class DocContentDTO {

	// 显示内容
	private String content;
	// 选择的id
	private String id_uiddoc;
	// 录入的内容
	private String result;
	// 分值
	private String score;
	// 选择的编码
	private String sd_chose;
	// 单位
	private String unit;
	// 值
	private String value;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId_uiddoc() {
		return id_uiddoc;
	}

	public void setId_uiddoc(String id_uiddoc) {
		this.id_uiddoc = id_uiddoc;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getSd_chose() {
		return sd_chose;
	}

	public void setSd_chose(String sd_chose) {
		this.sd_chose = sd_chose;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
