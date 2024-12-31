package iih.mp.dg.dto.mpdg4ie.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 发药与IE平台交互DTO DTO数据 
 * 
 */
public class MpDg4IEDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消息交互类型
	 * @return String
	 */
	public String getMessagetype() {
		return ((String) getAttrVal("Messagetype"));
	}
	/**
	 * 消息交互类型
	 * @param Messagetype
	 */
	public void setMessagetype(String Messagetype) {
		setAttrVal("Messagetype", Messagetype);
	}
	/**
	 * 消息创建时间
	 * @return String
	 */
	public String getCurrentdate() {
		return ((String) getAttrVal("Currentdate"));
	}
	/**
	 * 消息创建时间
	 * @param Currentdate
	 */
	public void setCurrentdate(String Currentdate) {
		setAttrVal("Currentdate", Currentdate);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getRegionid() {
		return ((String) getAttrVal("Regionid"));
	}
	/**
	 * 域ID
	 * @param Regionid
	 */
	public void setRegionid(String Regionid) {
		setAttrVal("Regionid", Regionid);
	}
	/**
	 * 患者id(编码)
	 * @return String
	 */
	public String getPatientid() {
		return ((String) getAttrVal("Patientid"));
	}
	/**
	 * 患者id(编码)
	 * @param Patientid
	 */
	public void setPatientid(String Patientid) {
		setAttrVal("Patientid", Patientid);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getPatientseqnum() {
		return ((String) getAttrVal("Patientseqnum"));
	}
	/**
	 * 就诊号
	 * @param Patientseqnum
	 */
	public void setPatientseqnum(String Patientseqnum) {
		setAttrVal("Patientseqnum", Patientseqnum);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getAdmiss_times() {
		return ((Integer) getAttrVal("Admiss_times"));
	}
	/**
	 * 就诊次数
	 * @param Admiss_times
	 */
	public void setAdmiss_times(Integer Admiss_times) {
		setAttrVal("Admiss_times", Admiss_times);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 处方信息
	 * @return FArrayList
	 */
	public FArrayList getPres_info() {
		return ((FArrayList) getAttrVal("Pres_info"));
	}
	/**
	 * 处方信息
	 * @param Pres_info
	 */
	public void setPres_info(FArrayList Pres_info) {
		setAttrVal("Pres_info", Pres_info);
	}
	/**
	 * 就诊流水号
	 * @return String
	 */
	public String getVisitordno() {
		return ((String) getAttrVal("Visitordno"));
	}
	/**
	 * 就诊流水号
	 * @param Visitordno
	 */
	public void setVisitordno(String Visitordno) {
		setAttrVal("Visitordno", Visitordno);
	}
	/**
	 * 就诊类别编码
	 * @return String
	 */
	public String getVisittypecode() {
		return ((String) getAttrVal("Visittypecode"));
	}
	/**
	 * 就诊类别编码
	 * @param Visittypecode
	 */
	public void setVisittypecode(String Visittypecode) {
		setAttrVal("Visittypecode", Visittypecode);
	}
	/**
	 * 就诊类别名称
	 * @return String
	 */
	public String getVisittypename() {
		return ((String) getAttrVal("Visittypename"));
	}
	/**
	 * 就诊类别名称
	 * @param Visittypename
	 */
	public void setVisittypename(String Visittypename) {
		setAttrVal("Visittypename", Visittypename);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}
	/**
	 * 申请科室
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
}