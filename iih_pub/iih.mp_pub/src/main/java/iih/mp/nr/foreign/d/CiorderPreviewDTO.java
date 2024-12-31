package iih.mp.nr.foreign.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱体征预览 DTO数据 
 * 
 */
public class CiorderPreviewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 测量项目
	 * @return String
	 */
	public String getId_srvvt() {
		return ((String) getAttrVal("Id_srvvt"));
	}
	/**
	 * 测量项目
	 * @param Id_srvvt
	 */
	public void setId_srvvt(String Id_srvvt) {
		setAttrVal("Id_srvvt", Id_srvvt);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 测量时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 测量时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 项目服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 项目服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}
	/**
	 * 项目编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}
	/**
	 * 项目名称
	 * @param Code_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
}