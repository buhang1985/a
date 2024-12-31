package iih.nm.net.examchk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examchk.d.desc.ExamChkFlDODesc;
import java.math.BigDecimal;

/**
 * 考核附件 DO数据 
 * 
 */
public class ExamChkFlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//考核文件主键
	public static final String ID_EXAM_CHK_FL= "Id_exam_chk_fl";
	//考核外键
	public static final String ID_EXAM_CHK= "Id_exam_chk";
	//文件名
	public static final String NAME= "Name";
	//上传人
	public static final String ID_UP_PSN= "Id_up_psn";
	//上传时间
	public static final String DT_UP= "Dt_up";
	//文件路径
	public static final String PATH_FILE= "Path_file";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//姓名
	public static final String NAME_UP_PSN= "Name_up_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 考核文件主键
	 * @return String
	 */
	public String getId_exam_chk_fl() {
		return ((String) getAttrVal("Id_exam_chk_fl"));
	}	
	/**
	 * 考核文件主键
	 * @param Id_exam_chk_fl
	 */
	public void setId_exam_chk_fl(String Id_exam_chk_fl) {
		setAttrVal("Id_exam_chk_fl", Id_exam_chk_fl);
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
	 * 文件名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 文件名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 上传人
	 * @return String
	 */
	public String getId_up_psn() {
		return ((String) getAttrVal("Id_up_psn"));
	}	
	/**
	 * 上传人
	 * @param Id_up_psn
	 */
	public void setId_up_psn(String Id_up_psn) {
		setAttrVal("Id_up_psn", Id_up_psn);
	}
	/**
	 * 上传时间
	 * @return FDateTime
	 */
	public FDateTime getDt_up() {
		return ((FDateTime) getAttrVal("Dt_up"));
	}	
	/**
	 * 上传时间
	 * @param Dt_up
	 */
	public void setDt_up(FDateTime Dt_up) {
		setAttrVal("Dt_up", Dt_up);
	}
	/**
	 * 文件路径
	 * @return String
	 */
	public String getPath_file() {
		return ((String) getAttrVal("Path_file"));
	}	
	/**
	 * 文件路径
	 * @param Path_file
	 */
	public void setPath_file(String Path_file) {
		setAttrVal("Path_file", Path_file);
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
	 * 姓名
	 * @return String
	 */
	public String getName_up_psn() {
		return ((String) getAttrVal("Name_up_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_up_psn
	 */
	public void setName_up_psn(String Name_up_psn) {
		setAttrVal("Name_up_psn", Name_up_psn);
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
		return "Id_exam_chk_fl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_CHK_FL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamChkFlDODesc.class);
	}
	
}