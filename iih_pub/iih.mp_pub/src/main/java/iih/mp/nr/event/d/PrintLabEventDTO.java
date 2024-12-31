package iih.mp.nr.event.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class PrintLabEventDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本ID
	 * @return String
	 */
	public String getId_labsamp() {
		return ((String) getAttrVal("Id_labsamp"));
	}
	/**
	 * 标本ID
	 * @param Id_labsamp
	 */
	public void setId_labsamp(String Id_labsamp) {
		setAttrVal("Id_labsamp", Id_labsamp);
	}
	/**
	 * 标本条码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 标本条码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 标本类型
	 * @return String
	 */
	public String getSd_labsamptp() {
		return ((String) getAttrVal("Sd_labsamptp"));
	}
	/**
	 * 标本类型
	 * @param Sd_labsamptp
	 */
	public void setSd_labsamptp(String Sd_labsamptp) {
		setAttrVal("Sd_labsamptp", Sd_labsamptp);
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
}