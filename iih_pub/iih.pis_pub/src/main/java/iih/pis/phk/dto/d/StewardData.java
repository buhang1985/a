package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;


/**
 * 患者管家_管家信息 DTO数据 
 * 
 */
public class StewardData extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者管家人员主键
	 * @return String
	 */
	public String getId_steward() {
		return ((String) getAttrVal("Id_steward"));
	}
	/**
	 * 患者管家人员主键
	 * @param Id_steward
	 */
	public void setId_steward(String Id_steward) {
		setAttrVal("Id_steward", Id_steward);
	}
	/**
	 * 管家姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 管家姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 管家管理人数
	 * @return Integer
	 */
	public Integer getManagecount() {
		return ((Integer) getAttrVal("Managecount"));
	}
	/**
	 * 管家管理人数
	 * @param Managecount
	 */
	public void setManagecount(Integer Managecount) {
		setAttrVal("Managecount", Managecount);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 当前患者接收次数
	 * @return Integer
	 */
	public Integer getReceptcount() {
		return ((Integer) getAttrVal("Receptcount"));
	}
	/**
	 * 当前患者接收次数
	 * @param Receptcount
	 */
	public void setReceptcount(Integer Receptcount) {
		setAttrVal("Receptcount", Receptcount);
	}
	/**
	 * 接待时间
	 * @return FDateTime
	 */
	public FDateTime getReceptdata() {
		return ((FDateTime) getAttrVal("Receptdata"));
	}
	/**
	 * 接待时间
	 * @param Receptdata
	 */
	public void setReceptdata(FDateTime Receptdata) {
		setAttrVal("Receptdata", Receptdata);
	}
}