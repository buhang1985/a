package iih.cssd.dpus.dto.dfpappsend.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 消毒包发放查询条件DTO DTO数据 
 * 
 */
public class DfpappSendQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发放状态
	 * @return Integer
	 */
	public Integer getEu_send() {
		return ((Integer) getAttrVal("Eu_send"));
	}
	/**
	 * 发放状态
	 * @param Eu_send
	 */
	public void setEu_send(Integer Eu_send) {
		setAttrVal("Eu_send", Eu_send);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_begin() {
		return ((String) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(String Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 发送单号
	 * @return String
	 */
	public String getSendno() {
		return ((String) getAttrVal("Sendno"));
	}
	/**
	 * 发送单号
	 * @param Sendno
	 */
	public void setSendno(String Sendno) {
		setAttrVal("Sendno", Sendno);
	}
	/**
	 * 请领单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 请领单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 请领科室
	 * @return String
	 */
	public String getId_dep_app() {
		return ((String) getAttrVal("Id_dep_app"));
	}
	/**
	 * 请领科室
	 * @param Id_dep_app
	 */
	public void setId_dep_app(String Id_dep_app) {
		setAttrVal("Id_dep_app", Id_dep_app);
	}
}