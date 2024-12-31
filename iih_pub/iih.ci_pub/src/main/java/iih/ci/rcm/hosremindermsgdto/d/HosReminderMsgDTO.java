package iih.ci.rcm.hosremindermsgdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 院感提醒消息 DTO数据 
 * 
 */
public class HosReminderMsgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 提醒消息主键
	 * @return String
	 */
	public String getId_hosremsg() {
		return ((String) getAttrVal("Id_hosremsg"));
	}
	/**
	 * 提醒消息主键
	 * @param Id_hosremsg
	 */
	public void setId_hosremsg(String Id_hosremsg) {
		setAttrVal("Id_hosremsg", Id_hosremsg);
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
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床号
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床号名称
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号名称
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 科室id
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}
	/**
	 * 科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 主管医生id
	 * @return String
	 */
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}
	/**
	 * 主管医生id
	 * @param Id_doc
	 */
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	/**
	 * 主管医生编号
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}
	/**
	 * 主管医生编号
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 主管医生名称
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}
	/**
	 * 主管医生名称
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
}