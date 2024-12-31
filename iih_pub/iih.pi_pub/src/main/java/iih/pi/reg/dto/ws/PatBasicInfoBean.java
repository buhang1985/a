package iih.pi.reg.dto.ws;

/**
 * 患者建档weserivce入参患者基本信息类
 * @author ly 2017/10/14
 *
 */
public class PatBasicInfoBean {

	/**
	 * 终端编码
	 */
	private String terminalCode;
	
	/**
	 * 参保机构代码
	 */
	private String insuredOrgCode;
	
	/**
	 * 患者就诊卡号
	 */
	private String patCardCode;
	
	/**
	 * 患者医保卡号
	 */
	private String medInsCode;
	
	/**
	 * 证件类型
	 */
	private String idType;
	
	/**
	 * 证件号码
	 */
	private String idCode;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 出生日期
	 */
	private String birthDate;
	
	/**
	 * 手机号码
	 */
	private String mob;
	
	/**
	 * 工作单位
	 */
	private String workUnit;
	
	/**
	 * 现住址区县码
	 */
	private String nowDistrict;
	
	/**
	 * 现住址街道
	 */
	private String nowStreet;
	
	/**
	 * 备用参数
	 */
	private String spareParam;
	

	/**
	 * 终端编码
	 * @return
	 */
	public String getTerminalCode() {
		return terminalCode;
	}

	/**
	 * 终端编码
	 * @param terminalCode
	 */
	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	/**
	 * 参保机构代码
	 * @return
	 */
	public String getInsuredOrgCode() {
		return insuredOrgCode;
	}

	/**
	 * 参保机构代码
	 * @param insuredOrgCode
	 */
	public void setInsuredOrgCode(String insuredOrgCode) {
		this.insuredOrgCode = insuredOrgCode;
	}

	/**
	 * 患者就诊卡号
	 * @return
	 */
	public String getPatCardCode() {
		return patCardCode;
	}

	/**
	 * 患者就诊卡号
	 * @param patCardCode
	 */
	public void setPatCardCode(String patCardCode) {
		this.patCardCode = patCardCode;
	}

	/**
	 * 患者医保卡号
	 * @return
	 */
	public String getMedInsCode() {
		return medInsCode;
	}

	/**
	 * 患者医保卡号
	 * @param medInsCode
	 */
	public void setMedInsCode(String medInsCode) {
		this.medInsCode = medInsCode;
	}

	/**
	 * 证件类型
	 * @return
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * 证件类型
	 * @param idType
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * 证件号码
	 * @return
	 */
	public String getIdCode() {
		return idCode;
	}

	/**
	 * 证件号码
	 * @param idCode
	 */
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	/**
	 * 姓名
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 性别
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 性别
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 出生日期
	 * @return
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * 出生日期
	 * @param birthDate
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * 手机号码
	 * @return
	 */
	public String getMob() {
		return mob;
	}

	/**
	 * 手机号码
	 * @param mob
	 */
	public void setMob(String mob) {
		this.mob = mob;
	}

	/**
	 * 工作单位
	 * @return
	 */
	public String getWorkUnit() {
		return workUnit;
	}

	/**
	 * 工作单位
	 * @param workUnit
	 */
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	
	/**
	 * 现住址区县
	 * @return
	 */
	public String getNowDistrict() {
		return nowDistrict;
	}

	/**
	 * 现住址区县
	 * @param nowDistrict
	 */
	public void setNowDistrict(String nowDistrict) {
		this.nowDistrict = nowDistrict;
	}

	/**
	 * 现住址街道
	 * @return
	 */
	public String getNowStreet() {
		return nowStreet;
	}

	/**
	 * 现住址街道
	 * @param nowStreet
	 */
	public void setNowStreet(String nowStreet) {
		this.nowStreet = nowStreet;
	}

	/**
	 * 备用参数
	 * @return
	 */
	public String getSpareParam() {
		return spareParam;
	}

	/**
	 * 备用参数
	 * @param spareParam
	 */
	public void setSpareParam(String spareParam) {
		this.spareParam = spareParam;
	}
}
 