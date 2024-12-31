package iih.nm.net.examchk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examchk.d.desc.ExamChkPsnDODesc;
import java.math.BigDecimal;

/**
 * 考核人员 DO数据 
 * 
 */
public class ExamChkPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//考核人员主键
	public static final String ID_EXAM_CHK_PSN= "Id_exam_chk_psn";
	//考核外键
	public static final String ID_EXAM_CHK= "Id_exam_chk";
	//护理人员外键
	public static final String ID_NUR= "Id_nur";
	//课程学分
	public static final String CUS_CRDT= "Cus_crdt";
	//课程学时
	public static final String SCHEDUL= "Schedul";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//人员姓名
	public static final String NAME_NUR= "Name_nur";
	//名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 考核人员主键
	 * @return String
	 */
	public String getId_exam_chk_psn() {
		return ((String) getAttrVal("Id_exam_chk_psn"));
	}	
	/**
	 * 考核人员主键
	 * @param Id_exam_chk_psn
	 */
	public void setId_exam_chk_psn(String Id_exam_chk_psn) {
		setAttrVal("Id_exam_chk_psn", Id_exam_chk_psn);
	}
	/**
	 * 考核外键
	 * @return String
	 */
	public String getId_exam_chk() {
		return ((String) getAttrVal("Id_exam_chk"));
	}	
	/**
	 * 考核外键
	 * @param Id_exam_chk
	 */
	public void setId_exam_chk(String Id_exam_chk) {
		setAttrVal("Id_exam_chk", Id_exam_chk);
	}
	/**
	 * 护理人员外键
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 护理人员外键
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 课程学分
	 * @return FDouble
	 */
	public FDouble getCus_crdt() {
		return ((FDouble) getAttrVal("Cus_crdt"));
	}	
	/**
	 * 课程学分
	 * @param Cus_crdt
	 */
	public void setCus_crdt(FDouble Cus_crdt) {
		setAttrVal("Cus_crdt", Cus_crdt);
	}
	/**
	 * 课程学时
	 * @return FDouble
	 */
	public FDouble getSchedul() {
		return ((FDouble) getAttrVal("Schedul"));
	}	
	/**
	 * 课程学时
	 * @param Schedul
	 */
	public void setSchedul(FDouble Schedul) {
		setAttrVal("Schedul", Schedul);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 人员姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_exam_chk_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_CHK_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamChkPsnDODesc.class);
	}
	
}