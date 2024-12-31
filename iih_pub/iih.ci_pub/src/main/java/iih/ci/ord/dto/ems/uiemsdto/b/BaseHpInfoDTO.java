package iih.ci.ord.dto.ems.uiemsdto.b;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class BaseHpInfoDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 限制报销条件
	 * @return String
	 */
	public String getLimit() {
		return ((String) getAttrVal("Limit"));
	}
	/**
	 * 限制报销条件
	 * @param Limit
	 */
	public void setLimit(String Limit) {
		setAttrVal("Limit", Limit);
	}

	/**
	 * 医保类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 通用医保计划目录类型
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 通用医保计划目录类型
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getName_heath() {
		return ((String) getAttrVal("Name_heath"));
	}
	/**
	 * 医保名称
	 * @param Name_heath
	 */
	public void setName_heath(String Name_heath) {
		setAttrVal("Name_heath", Name_heath);
	}
	/**
	 * 医保
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}

	/**
	 * 医保适应症医生界面判断
	 * @return
	 */
	public Integer getFg_hpindicjudged() {
		return ((Integer) getAttrVal("Fg_hpindicjudged"));
	}	
	/**
	 * 医保适应症医生界面判断
	 * @param Fg_hpindicjudged
	 */
	public void setFg_hpindicjudged(Integer Fg_hpindicjudged) {
		setAttrVal("Fg_hpindicjudged", Fg_hpindicjudged);
	}

	/**
	 * 医保信息
	 * @return
	 */
	public FArrayList getBdHpIndicationDTO()
	{
		return (FArrayList)getAttrVal("BdHpIndicationDTO"); 

	}
	/**
	 * 医保信息
	 * @param BdHpIndicationDTO
	 */
	public void setBdHpIndicationDTO(FArrayList BdHpIndicationDTO )
	{

		setAttrVal("BdHpIndicationDTO", BdHpIndicationDTO);  
	}
	/**
	 * 医保适应症判断标识枚举
	 * @return Integer
	 */
	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}	
	/**
	 * 医保适应症判断标识枚举
	 * @param Eu_hpindicjudge
	 */
	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}
}
