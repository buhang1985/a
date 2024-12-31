package iih.pis.ivx.dto.pisivxermview.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 电子病历-微信 DTO数据 
 * 
 */
public class PisIvxErmViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 电子病历主键标识
	 * @return String
	 */
	public String getId_pisivxermview() {
		return ((String) getAttrVal("Id_pisivxermview"));
	}
	/**
	 * 电子病历主键标识
	 * @param Id_pisivxermview
	 */
	public void setId_pisivxermview(String Id_pisivxermview) {
		setAttrVal("Id_pisivxermview", Id_pisivxermview);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getEntp() {
		return ((String) getAttrVal("Entp"));
	}
	/**
	 * 就诊类型
	 * @param Entp
	 */
	public void setEntp(String Entp) {
		setAttrVal("Entp", Entp);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
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
}