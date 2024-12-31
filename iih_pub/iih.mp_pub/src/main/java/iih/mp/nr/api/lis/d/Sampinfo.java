package iih.mp.nr.api.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * Lis标本信息 DTO数据 
 * 
 */
public class Sampinfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本名称
	 * @return String
	 */
	public String getName_lab() {
		return ((String) getAttrVal("Name_lab"));
	}
	/**
	 * 标本名称
	 * @param Name_lab
	 */
	public void setName_lab(String Name_lab) {
		setAttrVal("Name_lab", Name_lab);
	}
	/**
	 * 标本条码号
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 标本条码号
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_labsamp() {
		return ((String) getAttrVal("Sd_labsamp"));
	}
	/**
	 * 标本类型编码
	 * @param Sd_labsamp
	 */
	public void setSd_labsamp(String Sd_labsamp) {
		setAttrVal("Sd_labsamp", Sd_labsamp);
	}
	/**
	 * 采集方法
	 * @return String
	 */
	public String getSd_colltp() {
		return ((String) getAttrVal("Sd_colltp"));
	}
	/**
	 * 采集方法
	 * @param Sd_colltp
	 */
	public void setSd_colltp(String Sd_colltp) {
		setAttrVal("Sd_colltp", Sd_colltp);
	}
	/**
	 * 容器类型
	 * @return String
	 */
	public String getSd_tubetp() {
		return ((String) getAttrVal("Sd_tubetp"));
	}
	/**
	 * 容器类型
	 * @param Sd_tubetp
	 */
	public void setSd_tubetp(String Sd_tubetp) {
		setAttrVal("Sd_tubetp", Sd_tubetp);
	}
	/**
	 * 标本说明
	 * @return String
	 */
	public String getDes_labsamp() {
		return ((String) getAttrVal("Des_labsamp"));
	}
	/**
	 * 标本说明
	 * @param Des_labsamp
	 */
	public void setDes_labsamp(String Des_labsamp) {
		setAttrVal("Des_labsamp", Des_labsamp);
	}
	/**
	 * 作废标识
	 * @return String
	 */
	public String getFg_invalid() {
		return ((String) getAttrVal("Fg_invalid"));
	}
	/**
	 * 作废标识
	 * @param Fg_invalid
	 */
	public void setFg_invalid(String Fg_invalid) {
		setAttrVal("Fg_invalid", Fg_invalid);
	}
	/**
	 * 需求量
	 * @return String
	 */
	public String getUnit_quan() {
		return ((String) getAttrVal("Unit_quan"));
	}
	/**
	 * 需求量
	 * @param Unit_quan
	 */
	public void setUnit_quan(String Unit_quan) {
		setAttrVal("Unit_quan", Unit_quan);
	}
	/**
	 * 加急标识
	 * @return String
	 */
	public String getFg_urgent() {
		return ((String) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(String Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
}