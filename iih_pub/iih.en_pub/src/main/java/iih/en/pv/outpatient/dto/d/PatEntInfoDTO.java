package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者就诊信息dto DTO数据 
 * 
 */
public class PatEntInfoDTO  {
	//就诊id
	private String entid;
	//患者编码
	private String patcode;
	//门诊就诊次数
	private Integer optimes;
	//住院就诊次数
	private Integer iptimes;
	//接诊时间
	private String dtacpt;
	//就诊类型
	private String entpcode;
	//患者姓名
	private String patname;
	//就诊科室
	private String phydepid;
	//就诊科室编码
	private String phydepcode;
	//状态
	private String statuscode;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getEntid() {
		return entid;
	}
	/**
	 * 就诊id
	 * @param Entid
	 */
	public void setEntid(String entid) {
	    this.entid =entid;	
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return patcode;
	}
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String patcode) {
		this.patcode = patcode;
	}
	/**
	 * 门诊就诊次数
	 * @return Integer
	 */
	public Integer getOptimes() {
		return optimes;
	}
	/**
	 * 门诊就诊次数
	 * @param Optimes
	 */
	public void setOptimes(Integer optimes) {
		this.optimes = optimes;
	}
	/**
	 * 住院就诊次数
	 * @return Integer
	 */
	public Integer getIptimes() {
		return iptimes;
	}
	/**
	 * 住院就诊次数
	 * @param Iptimes
	 */
	public void setIptimes(Integer iptimes) {
		this.iptimes = iptimes;
	}
	/**
	 * 接诊时间
	 * @return String
	 */
	public String getDtacpt() {
		return dtacpt;
	}
	/**
	 * 接诊时间
	 * @param Dtacpt
	 */
	public void setDtacpt(String dtacpt) {
		this.dtacpt = dtacpt;
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getEntpcode() {
		return entpcode;
	}
	/**
	 * 就诊类型
	 * @param Entpcode
	 */
	public void setEntpcode(String entpcode) {
		this.entpcode = entpcode;
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return patname;
	}
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String patname) {
		this.patname = patname;
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getPhydepid() {
		return phydepid;
	}
	/**
	 * 就诊科室
	 * @param Phydepid
	 */
	public void setPhydepid(String phydepid) {
		this.phydepid = phydepid;
	}
	/**
	 * 就诊科室编码
	 * @return String
	 */
	public String getPhydepcode() {
		return phydepcode;
	}
	/**
	 * 就诊科室编码
	 * @param Phydepcode
	 */
	public void setPhydepcode(String phydepcode) {
		this.phydepcode = phydepcode;
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getStatuscode() {
		return statuscode;
	}
	/**
	 * 状态
	 * @param Statuscode
	 */
	public void setStatuscode(String statuscode) {
		this.statuscode= statuscode;
	}
}