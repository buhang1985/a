package iih.mp.dg.dto.prints.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 *  摆药机摆药头 DTO数据 
 * 
 */
public class MachinePrepItemDTO extends BaseDTO {
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
	/**
	 * 病历号
	 * @return String
	 */
	public String getCode_mr() {
		return ((String) getAttrVal("Code_mr"));
	}
	/**
	 * 病历号
	 * @param Code_mr
	 */
	public void setCode_mr(String Code_mr) {
		setAttrVal("Code_mr", Code_mr);
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
	 * 用法
	 * @return String
	 */
	public String getRoute() {
		return ((String) getAttrVal("Route"));
	}
	/**
	 * 用法
	 * @param Route
	 */
	public void setRoute(String Route) {
		setAttrVal("Route", Route);
	}
	/**
	 * 二维码内容
	 * @return String
	 */
	public String getQr_content() {
		return ((String) getAttrVal("Qr_content"));
	}
	/**
	 * 二维码内容
	 * @param Qr_content
	 */
	public void setQr_content(String Qr_content) {
		setAttrVal("Qr_content", Qr_content);
	}
	/**
	 * 摆药单号
	 * @return String
	 */
	public String getCode_ap() {
		return ((String) getAttrVal("Code_ap"));
	}
	/**
	 * 摆药单号
	 * @param Code_ap
	 */
	public void setCode_ap(String Code_ap) {
		setAttrVal("Code_ap", Code_ap);
	}
	/**
	 * 不明
	 * @return String
	 */
	public String getOther() {
		return ((String) getAttrVal("Other"));
	}
	/**
	 * 不明
	 * @param Other
	 */
	public void setOther(String Other) {
		setAttrVal("Other", Other);
	}
}