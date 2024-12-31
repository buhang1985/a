package iih.pis.ivx.reg.d;

/**
 * 微信服务号患者绑定结果
 * @author guo.s
 *
 */
public class RegResultBean {
	
	/**
	 * 0成功	非0失败
	 */
	private String resultCode;
	/**
	 * 失败则有消息
	 */
	private String errorMessage;
	
	/**
	 * 注册所填的信息
	 */
	private String name;
	private String type;
	private String code;
	private String sdCode;
	private String mob;
	
	/**
	 * 应在session中存储的属性
	 */
	private String mobile;
	private String id_pisivxaccount;
	private String id_pisivxmember;
	private String id_pisivxent;
	private String patname;
	private String patcode;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSdCode() {
		return sdCode;
	}
	public void setSdCode(String sdCode) {
		this.sdCode = sdCode;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getId_pisivxaccount() {
		return id_pisivxaccount;
	}
	public void setId_pisivxaccount(String id_pisivxaccount) {
		this.id_pisivxaccount = id_pisivxaccount;
	}
	public String getId_pisivxmember() {
		return id_pisivxmember;
	}
	public void setId_pisivxmember(String id_pisivxmember) {
		this.id_pisivxmember = id_pisivxmember;
	}
	public String getId_pisivxent() {
		return id_pisivxent;
	}
	public void setId_pisivxent(String id_pisivxent) {
		this.id_pisivxent = id_pisivxent;
	}
	public String getPatname() {
		return patname;
	}
	public void setPatname(String patname) {
		this.patname = patname;
	}
	public String getPatcode() {
		return patcode;
	}
	public void setPatcode(String patcode) {
		this.patcode = patcode;
	}

}
