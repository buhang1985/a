package iih.ci.ord.s.bp.event.ms.enums;

public enum UdidocCodeTypeEnum {
	
	DIAG_TYPE("诊断类型","CI.DI.0505"),
	PRES_TYPE("处方类型","CI.OR.0515");
	private String nameString;
	private String valueString;
	private UdidocCodeTypeEnum(String nameString,String valueString) {
		this.nameString=nameString;
		this.valueString=valueString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getValueString() {
		return valueString;
	}
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}
	
}
