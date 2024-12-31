package iih.mp.dg.dto.prints.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 贴瓶条头 DTO数据 
 * 
 */
public class BottleLableHeadDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区名称
	 * @return String
	 */
	public String getDep_nur() {
		return ((String) getAttrVal("Dep_nur"));
	}
	/**
	 * 病区名称
	 * @param Dep_nur
	 */
	public void setDep_nur(String Dep_nur) {
		setAttrVal("Dep_nur", Dep_nur);
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
	 * 频次
	 * @return String
	 */
	public String getFreq() {
		return ((String) getAttrVal("Freq"));
	}
	/**
	 * 频次
	 * @param Freq
	 */
	public void setFreq(String Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 日期时间
	 * @return FDateTime
	 */
	public FDateTime getDate() {
		return ((FDateTime) getAttrVal("Date"));
	}
	/**
	 * 日期时间
	 * @param Date
	 */
	public void setDate(FDateTime Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 用药类型
	 * @return String
	 */
	public String getType() {
		return ((String) getAttrVal("Type"));
	}
	/**
	 * 用药类型
	 * @param Type
	 */
	public void setType(String Type) {
		setAttrVal("Type", Type);
	}
	/**
	 * 单号
	 * @return String
	 */
	public String getCode_ap() {
		return ((String) getAttrVal("Code_ap"));
	}
	/**
	 * 单号
	 * @param Code_ap
	 */
	public void setCode_ap(String Code_ap) {
		setAttrVal("Code_ap", Code_ap);
	}
	/**
	 * 二维码内容
	 * @return String
	 */
	public String getCode_qr() {
		return ((String) getAttrVal("Code_qr"));
	}
	/**
	 * 二维码内容
	 * @param Code_qr
	 */
	public void setCode_qr(String Code_qr) {
		setAttrVal("Code_qr", Code_qr);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed() {
		return ((String) getAttrVal("Bed"));
	}
	/**
	 * 床号
	 * @param Bed
	 */
	public void setBed(String Bed) {
		setAttrVal("Bed", Bed);
	}
}