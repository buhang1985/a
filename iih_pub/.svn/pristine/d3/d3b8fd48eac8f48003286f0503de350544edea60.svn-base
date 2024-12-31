package iih.nm.net.examchk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examchk.d.desc.ExamChkDODesc;
import java.math.BigDecimal;

/**
 * 护理人员考核 DO数据 
 * 
 */
public class ExamChkDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//考核主键
	public static final String ID_EXAM_CHK= "Id_exam_chk";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//考核计划
	public static final String ID_EXAM_CHK_PL= "Id_exam_chk_pl";
	//考核名称
	public static final String NAME= "Name";
	//年度
	public static final String YEAR= "Year";
	//考核开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//考核结束时间
	public static final String DT_END= "Dt_end";
	//总分
	public static final String TOTAL_SCORE= "Total_score";
	//合格分
	public static final String PASS_SCORE= "Pass_score";
	//主考官
	public static final String ID_CHK_PSN= "Id_chk_psn";
	//考核地点
	public static final String ADDRES_CHK= "Addres_chk";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//考核类型id
	public static final String ID_CHKTP= "Id_chktp";
	//考核类型
	public static final String SD_CHKTP= "Sd_chktp";
	//考核内容
	public static final String CONTENT= "Content";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//拼音码
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//考核计划名称
	public static final String PL_NAME= "Pl_name";
	//主考官
	public static final String NAME_CHK_PSN= "Name_chk_psn";
	//名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//名称
	public static final String NAME_CHKTP= "Name_chktp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 考核主键
	 * @return String
	 */
	public String getId_exam_chk() {
		return ((String) getAttrVal("Id_exam_chk"));
	}	
	/**
	 * 考核主键
	 * @param Id_exam_chk
	 */
	public void setId_exam_chk(String Id_exam_chk) {
		setAttrVal("Id_exam_chk", Id_exam_chk);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 考核计划
	 * @return String
	 */
	public String getId_exam_chk_pl() {
		return ((String) getAttrVal("Id_exam_chk_pl"));
	}	
	/**
	 * 考核计划
	 * @param Id_exam_chk_pl
	 */
	public void setId_exam_chk_pl(String Id_exam_chk_pl) {
		setAttrVal("Id_exam_chk_pl", Id_exam_chk_pl);
	}
	/**
	 * 考核名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 考核名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 年度
	 * @return Integer
	 */
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	/**
	 * 年度
	 * @param Year
	 */
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	/**
	 * 考核开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 考核开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 考核结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 考核结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 总分
	 * @return FDouble
	 */
	public FDouble getTotal_score() {
		return ((FDouble) getAttrVal("Total_score"));
	}	
	/**
	 * 总分
	 * @param Total_score
	 */
	public void setTotal_score(FDouble Total_score) {
		setAttrVal("Total_score", Total_score);
	}
	/**
	 * 合格分
	 * @return FDouble
	 */
	public FDouble getPass_score() {
		return ((FDouble) getAttrVal("Pass_score"));
	}	
	/**
	 * 合格分
	 * @param Pass_score
	 */
	public void setPass_score(FDouble Pass_score) {
		setAttrVal("Pass_score", Pass_score);
	}
	/**
	 * 主考官
	 * @return String
	 */
	public String getId_chk_psn() {
		return ((String) getAttrVal("Id_chk_psn"));
	}	
	/**
	 * 主考官
	 * @param Id_chk_psn
	 */
	public void setId_chk_psn(String Id_chk_psn) {
		setAttrVal("Id_chk_psn", Id_chk_psn);
	}
	/**
	 * 考核地点
	 * @return String
	 */
	public String getAddres_chk() {
		return ((String) getAttrVal("Addres_chk"));
	}	
	/**
	 * 考核地点
	 * @param Addres_chk
	 */
	public void setAddres_chk(String Addres_chk) {
		setAttrVal("Addres_chk", Addres_chk);
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
	 * 考核类型id
	 * @return String
	 */
	public String getId_chktp() {
		return ((String) getAttrVal("Id_chktp"));
	}	
	/**
	 * 考核类型id
	 * @param Id_chktp
	 */
	public void setId_chktp(String Id_chktp) {
		setAttrVal("Id_chktp", Id_chktp);
	}
	/**
	 * 考核类型
	 * @return String
	 */
	public String getSd_chktp() {
		return ((String) getAttrVal("Sd_chktp"));
	}	
	/**
	 * 考核类型
	 * @param Sd_chktp
	 */
	public void setSd_chktp(String Sd_chktp) {
		setAttrVal("Sd_chktp", Sd_chktp);
	}
	/**
	 * 考核内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	/**
	 * 考核内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 考核计划名称
	 * @return String
	 */
	public String getPl_name() {
		return ((String) getAttrVal("Pl_name"));
	}	
	/**
	 * 考核计划名称
	 * @param Pl_name
	 */
	public void setPl_name(String Pl_name) {
		setAttrVal("Pl_name", Pl_name);
	}
	/**
	 * 主考官
	 * @return String
	 */
	public String getName_chk_psn() {
		return ((String) getAttrVal("Name_chk_psn"));
	}	
	/**
	 * 主考官
	 * @param Name_chk_psn
	 */
	public void setName_chk_psn(String Name_chk_psn) {
		setAttrVal("Name_chk_psn", Name_chk_psn);
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
	/**
	 * 名称
	 * @return String
	 */
	public String getName_chktp() {
		return ((String) getAttrVal("Name_chktp"));
	}	
	/**
	 * 名称
	 * @param Name_chktp
	 */
	public void setName_chktp(String Name_chktp) {
		setAttrVal("Name_chktp", Name_chktp);
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
		return "Id_exam_chk";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_CHK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamChkDODesc.class);
	}
	
}