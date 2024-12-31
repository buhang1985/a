package iih.pis.ivx.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验报告查询入参 DTO数据 
 * 
 */
public class Req extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCardno() {
		return ((String) getAttrVal("Cardno"));
	}
	/**
	 * 就诊卡号
	 * @param Cardno
	 */
	public void setCardno(String Cardno) {
		setAttrVal("Cardno", Cardno);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatid() {
		return ((String) getAttrVal("Patid"));
	}
	/**
	 * 患者编码
	 * @param Patid
	 */
	public void setPatid(String Patid) {
		setAttrVal("Patid", Patid);
	}
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
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}