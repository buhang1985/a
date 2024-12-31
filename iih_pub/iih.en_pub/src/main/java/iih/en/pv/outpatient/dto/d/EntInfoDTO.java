package iih.en.pv.outpatient.dto.d;

/**
 * 就诊信息DTO，对外接口-获取就诊记录返回DTO
 * @author fanliqin
 *
 */
public class EntInfoDTO {

	/**
	 * 患者编码
	 */
    private String patCode;
    /***
     * 门诊就诊次数
     */
    private Integer opTimes;
    /***
     * 住院就诊次数
     */
    private Integer ipTimes;
    /***
     * 就诊类型
     */
    private String entpCode;
    /***
     * 就诊日期
     */
    private String dtAcpt;
    /**
     * 患者分类（编码）
     */
    private String patCaCode;
    /***
     * 价格分类（编码）
     */
    private String patPriCode;
    /**
     * 医保卡号
     */
    private String hpNo;
    /**
     * 初诊标志,0-复诊；1-初诊
     */
    private Integer fgFirst;
    /***
     * 号别编码
     */
    private String srvCode;
    /***
     * 号别名称
     */
    private String srvName;
    /**
     * 挂号科室编码
     */
    private String deptCode;
    /***
     * 医生编码
     */
    private String empPhyCode;
    /***
     * 是否预约好，0-非预约号，1-预约号
     */
    private Integer isApt;
    /**
     * 挂号日期
     */
    private String dtEntry;
    /***
     * 上下午
     */
    private String ampm;
    /***
     * 挂号序号
     */
    private Integer tickNo;
    /***
     * 就诊状态
     */
    private String statusCode;
    /**
     * 就诊编码
     */
    private String entCode;
    /***
     * 退号标志，0-没有退号，1-退号
     */
    private Integer fg_canc;

	public Integer getFg_canc() {
		return fg_canc;
	}
	public void setFg_canc(Integer fg_canc) {
		this.fg_canc = fg_canc;
	}
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getEntpCode() {
		return entpCode;
	}
	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
	}
	public String getDtAcpt() {
		return dtAcpt;
	}
	public void setDtAcpt(String dtAcpt) {
		this.dtAcpt = dtAcpt;
	}
	public String getPatCaCode() {
		return patCaCode;
	}
	public void setPatCaCode(String patCaCode) {
		this.patCaCode = patCaCode;
	}
	public String getPatPriCode() {
		return patPriCode;
	}
	public void setPatPriCode(String patPriCode) {
		this.patPriCode = patPriCode;
	}
	public String getHpNo() {
		return hpNo;
	}
	public void setHpNo(String hpNo) {
		this.hpNo = hpNo;
	}
	public Integer getFgFirst() {
		return fgFirst;
	}
	public void setFgFirst(Integer fgFirst) {
		this.fgFirst = fgFirst;
	}
	public String getSrvCode() {
		return srvCode;
	}
	public void setSrvCode(String srvCode) {
		this.srvCode = srvCode;
	}
	public String getSrvName() {
		return srvName;
	}
	public void setSrvName(String srvName) {
		this.srvName = srvName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getEmpPhyCode() {
		return empPhyCode;
	}
	public void setEmpPhyCode(String empPhyCode) {
		this.empPhyCode = empPhyCode;
	}
	public Integer getIsApt() {
		return isApt;
	}
	public void setIsApt(Integer isApt) {
		this.isApt = isApt;
	}

	public String getAmpm() {
		return ampm;
	}
	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	public Integer getTickNo() {
		return tickNo;
	}
	public void setTickNo(Integer tickNo) {
		this.tickNo = tickNo;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getEntCode() {
		return entCode;
	}
	public void setEntCode(String entCode) {
		this.entCode = entCode;
	}
	public Integer getOpTimes() {
		return opTimes;
	}
	public void setOpTimes(Integer opTimes) {
		this.opTimes = opTimes;
	}
	public Integer getIpTimes() {
		return ipTimes;
	}
	public void setIpTimes(Integer ipTimes) {
		this.ipTimes = ipTimes;
	}
	public String getDtEntry() {
		return dtEntry;
	}
	public void setDtEntry(String dtEntry) {
		this.dtEntry = dtEntry;
	}
    
}
