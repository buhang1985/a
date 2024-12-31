package iih.ci.preop.ems.d;

import iih.ci.preop.ems.d.b.BasePreOpEmsViewDTO;

/**
 * 检验项目申请单 DTO数据 
 * 
 */
public class EmsLisViewDTO extends BasePreOpEmsViewDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 标本类型ID
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}
	/**
	 * 标本类型ID
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 标本类型名称
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}
	/**
	 * 标本类型名称
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 标本类型SD
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}
	/**
	 * 标本类型SD
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	
	/**
	 * 当前诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 标本采集时间ID
	 * @return String
	 */
	public String getId_sampcoltime() {
		return ((String) getAttrVal("Id_sampcoltime"));
	}
	/**
	 * 标本采集时间ID
	 * @param Id_sampcoltime
	 */
	public void setId_sampcoltime(String Id_sampcoltime) {
		setAttrVal("Id_sampcoltime", Id_sampcoltime);
	}
	/**
	 * 标本采集时间
	 * @return String
	 */
	public String getName_sampcoltime() {
		return ((String) getAttrVal("Name_sampcoltime"));
	}
	/**
	 * 标本采集时间
	 * @param Name_sampcoltime
	 */
	public void setName_sampcoltime(String Name_sampcoltime) {
		setAttrVal("Name_sampcoltime", Name_sampcoltime);
	}
}