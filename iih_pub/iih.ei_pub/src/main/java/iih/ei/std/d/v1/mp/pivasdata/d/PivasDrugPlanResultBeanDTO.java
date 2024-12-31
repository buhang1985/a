package iih.ei.std.d.v1.mp.pivasdata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * Pivas药品药单DTO DTO数据 
 * 
 */
public class PivasDrugPlanResultBeanDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getRecipeid() {
		return ((String) getAttrVal("Recipeid"));
	}	
	/**
	 * 医嘱编码
	 * @param Recipeid
	 */
	public void setRecipeid(String Recipeid) {
		setAttrVal("Recipeid", Recipeid);
	}
	/**
	 * 父医嘱编码或组编码
	 * @return String
	 */
	public String getGroupno() {
		return ((String) getAttrVal("Groupno"));
	}	
	/**
	 * 父医嘱编码或组编码
	 * @param Groupno
	 */
	public void setGroupno(String Groupno) {
		setAttrVal("Groupno", Groupno);
	}
	/**
	 * 药单号
	 * @return String
	 */
	public String getDruglistid() {
		return ((String) getAttrVal("Druglistid"));
	}	
	/**
	 * 药单号
	 * @param Druglistid
	 */
	public void setDruglistid(String Druglistid) {
		setAttrVal("Druglistid", Druglistid);
	}
	/**
	 * 用药频次
	 * @return String
	 */
	public String getDrugfreq() {
		return ((String) getAttrVal("Drugfreq"));
	}	
	/**
	 * 用药频次
	 * @param Drugfreq
	 */
	public void setDrugfreq(String Drugfreq) {
		setAttrVal("Drugfreq", Drugfreq);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getDrugcode() {
		return ((String) getAttrVal("Drugcode"));
	}	
	/**
	 * 药品编码
	 * @param Drugcode
	 */
	public void setDrugcode(String Drugcode) {
		setAttrVal("Drugcode", Drugcode);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getDrugname() {
		return ((String) getAttrVal("Drugname"));
	}	
	/**
	 * 药品名称
	 * @param Drugname
	 */
	public void setDrugname(String Drugname) {
		setAttrVal("Drugname", Drugname);
	}
	/**
	 * 药品数量
	 * @return String
	 */
	public String getQuantity() {
		return ((String) getAttrVal("Quantity"));
	}	
	/**
	 * 药品数量
	 * @param Quantity
	 */
	public void setQuantity(String Quantity) {
		setAttrVal("Quantity", Quantity);
	}
	/**
	 * 数量单位
	 * @return String
	 */
	public String getQuantityunit() {
		return ((String) getAttrVal("Quantityunit"));
	}	
	/**
	 * 数量单位
	 * @param Quantityunit
	 */
	public void setQuantityunit(String Quantityunit) {
		setAttrVal("Quantityunit", Quantityunit);
	}
	/**
	 * 执行序号
	 * @return String
	 */
	public String getSchedule() {
		return ((String) getAttrVal("Schedule"));
	}	
	/**
	 * 执行序号
	 * @param Schedule
	 */
	public void setSchedule(String Schedule) {
		setAttrVal("Schedule", Schedule);
	}
	/**
	 * 用药时间
	 * @return String
	 */
	public String getOccdt() {
		return ((String) getAttrVal("Occdt"));
	}	
	/**
	 * 用药时间
	 * @param Occdt
	 */
	public void setOccdt(String Occdt) {
		setAttrVal("Occdt", Occdt);
	}
	/**
	 * 收费时间
	 * @return String
	 */
	public String getChargedt() {
		return ((String) getAttrVal("Chargedt"));
	}	
	/**
	 * 收费时间
	 * @param Chargedt
	 */
	public void setChargedt(String Chargedt) {
		setAttrVal("Chargedt", Chargedt);
	}
	/**
	 * 输液时间
	 * @return String
	 */
	public String getInfusiondate() {
		return ((String) getAttrVal("Infusiondate"));
	}	
	/**
	 * 输液时间
	 * @param Infusiondate
	 */
	public void setInfusiondate(String Infusiondate) {
		setAttrVal("Infusiondate", Infusiondate);
	}
	/**
	 * 瓶签号或药单唯一号
	 * @return String
	 */
	public String getLabelno() {
		return ((String) getAttrVal("Labelno"));
	}	
	/**
	 * 瓶签号或药单唯一号
	 * @param Labelno
	 */
	public void setLabelno(String Labelno) {
		setAttrVal("Labelno", Labelno);
	}
	/**
	 * 药单起止时间
	 * @return String
	 */
	public String getBegindt() {
		return ((String) getAttrVal("Begindt"));
	}	
	/**
	 * 药单起止时间
	 * @param Begindt
	 */
	public void setBegindt(String Begindt) {
		setAttrVal("Begindt", Begindt);
	}
	/**
	 * 药单终止时间
	 * @return String
	 */
	public String getEnddt() {
		return ((String) getAttrVal("Enddt"));
	}	
	/**
	 * 药单终止时间
	 * @param Enddt
	 */
	public void setEnddt(String Enddt) {
		setAttrVal("Enddt", Enddt);
	}
}