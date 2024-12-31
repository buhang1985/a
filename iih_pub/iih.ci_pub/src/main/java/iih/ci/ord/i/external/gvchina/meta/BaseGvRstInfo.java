package iih.ci.ord.i.external.gvchina.meta;

public class BaseGvRstInfo {
	/**
	 * 主键
	 */
	private String id_key;
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 就诊次数
	 */
	private int enTimes;
	/**
	 * 项目编码
	 */
	private String code;
	
	/**
	 * 项目名称
	 */
	private String name;

	public String getId_key() {
		return id_key;
	}

	public void setId_key(String id_key) {
		this.id_key = id_key;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public int getEnTimes() {
		return enTimes;
	}

	public void setEnTimes(int enTimes) {
		this.enTimes = enTimes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
