package iih.mr.mrm;

public class SexAndAgeFromDiagDTO {
	
	private String disease; // 疾病名称
	private String id_di; // 疾病id
	private String total; // 总计
	private String shu1; // 5岁以下
	private String shu2; // 5-14岁
	private String shu3; // 15-44岁
	private String shu4; // 45-59岁
	private String shu5; // 60岁以上
	
    public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getId_di() {
		return id_di;
	}
	public void setId_di(String id_di) {
		this.id_di = id_di;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getShu1() {
		return shu1;
	}
	public void setShu1(String shu1) {
		this.shu1 = shu1;
	}
	public String getShu2() {
		return shu2;
	}
	public void setShu2(String shu2) {
		this.shu2 = shu2;
	}
	public String getShu3() {
		return shu3;
	}
	public void setShu3(String shu3) {
		this.shu3 = shu3;
	}
	public String getShu4() {
		return shu4;
	}
	public void setShu4(String shu4) {
		this.shu4 = shu4;
	}
	public String getShu5() {
		return shu5;
	}
	public void setShu5(String shu5) {
		this.shu5 = shu5;
	}
}
