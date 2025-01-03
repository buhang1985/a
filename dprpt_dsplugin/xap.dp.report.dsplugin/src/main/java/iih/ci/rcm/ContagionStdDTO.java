package iih.ci.rcm;

public class ContagionStdDTO {
	private String maritalStatus;// 婚姻状况
	private String nation;// 民族
	private String otherNation;
	private String cultureLevel;// 文化程度
	private String stdHistory;// 性病史
	private String contactHistory;// 接触史
	private String infectionWay;// 感染途径
	private String sampSource;// 样本来源
	private String concluson;// 实验室检测结论
	private String monitor;// 监测性病
	
	public String getMaritalStatus() {
		return maritalStatus;
	}

	public String getOtherNation() {
		return otherNation;
	}

	public void setOtherNation(String otherNation) {
		this.otherNation = otherNation;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCultureLevel() {
		return cultureLevel;
	}

	public void setCultureLevel(String cultureLevel) {
		this.cultureLevel = cultureLevel;
	}

	public String getStdHistory() {
		return stdHistory;
	}

	public void setStdHistory(String stdHistory) {
		this.stdHistory = stdHistory;
	}

	public String getContactHistory() {
		return contactHistory;
	}

	public void setContactHistory(String contactHistory) {
		this.contactHistory = contactHistory;
	}

	public String getInfectionWay() {
		return infectionWay;
	}

	public void setInfectionWay(String infectionWay) {
		this.infectionWay = infectionWay;
	}

	public String getSampSource() {
		return sampSource;
	}

	public void setSampSource(String sampSource) {
		this.sampSource = sampSource;
	}

	public String getConcluson() {
		return concluson;
	}

	public void setConcluson(String concluson) {
		this.concluson = concluson;
	}
	
	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

}
