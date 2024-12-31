package iih.bl.pay.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预交金节点用患者信息查询dto DTO数据 
 * 
 */
public class PatInfoQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者主键id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}
	/**
	 * 患者性别
	 * @param Sex_name
	 */
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTelno() {
		return ((String) getAttrVal("Telno"));
	}
	/**
	 * 联系电话
	 * @param Telno
	 */
	public void setTelno(String Telno) {
		setAttrVal("Telno", Telno);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getCertificate_no() {
		return ((String) getAttrVal("Certificate_no"));
	}
	/**
	 * 证件号码
	 * @param Certificate_no
	 */
	public void setCertificate_no(String Certificate_no) {
		setAttrVal("Certificate_no", Certificate_no);
	}
	/**
	 * 所在病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 所在病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
}