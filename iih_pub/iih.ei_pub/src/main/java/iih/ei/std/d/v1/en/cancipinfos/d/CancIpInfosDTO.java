package iih.ei.std.d.v1.en.cancipinfos.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 退院患者列表 DTO数据 
 * 
 */
public class CancIpInfosDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}	
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 退院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 退院时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 更新时间
	 * @return FDateTime
	 */
	public FDateTime getUpdate_time() {
		return ((FDateTime) getAttrVal("Update_time"));
	}	
	/**
	 * 更新时间
	 * @param Update_time
	 */
	public void setUpdate_time(FDateTime Update_time) {
		setAttrVal("Update_time", Update_time);
	}
}