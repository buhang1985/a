package iih.mr.mrm;

public class DiseaseSortReportDTO {
	
	private String disease; // 疾病名称
	private String sd_di; // 疾病编码
	private String serial_number; // 统计码
	private String total; // 总计
	private String cure; // 治愈
	private String become_better; // 好转
	private String healed; // 未愈
	private String death; // 死亡
	private String other; // 其他
	private String in_hospital_day; //住院天数
	
	public String getSd_di() {
		return sd_di;
	}
	public void setSd_di(String sd_di) {
		this.sd_di = sd_di;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCure() {
		return cure;
	}
	public void setCure(String cure) {
		this.cure = cure;
	}
	public String getBecome_better() {
		return become_better;
	}
	public void setBecome_better(String become_better) {
		this.become_better = become_better;
	}
	public String getHealed() {
		return healed;
	}
	public void setHealed(String healed) {
		this.healed = healed;
	}
	public String getDeath() {
		return death;
	}
	public void setDeath(String death) {
		this.death = death;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getIn_hospital_day() {
		return in_hospital_day;
	}
	public void setIn_hospital_day(String in_hospital_day) {
		this.in_hospital_day = in_hospital_day;
	}
}
