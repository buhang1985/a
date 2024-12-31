package iih.nm.net.examchkpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examchkpl.d.desc.ExamChkPlDODesc;
import java.math.BigDecimal;

/**
 * 考核计划 DO数据 
 * 
 */
public class ExamChkPlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//考核计划主键
	public static final String ID_EXAM_CHK_PL= "Id_exam_chk_pl";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//考核计划名称
	public static final String NAME= "Name";
	//考核类型id
	public static final String ID_CHKTP= "Id_chktp";
	//考核类型编码
	public static final String SD_CHKTP= "Sd_chktp";
	//主考官
	public static final String ID_CHK_PSN= "Id_chk_psn";
	//通知标识
	public static final String FG_INFO= "Fg_info";
	//考核开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//考核结束时间
	public static final String DT_END= "Dt_end";
	//通知起始时间
	public static final String DT_INFO_BEGIN= "Dt_info_begin";
	//通知截止时间
	public static final String DT_INFO_END= "Dt_info_end";
	//护士层级id
	public static final String ID_NUR_LVL= "Id_nur_lvl";
	//护士层级(可多选)
	public static final String SD_NUR_LVL= "Sd_nur_lvl";
	//考核地点
	public static final String ADRESS_CHK= "Adress_chk";
	//考核内容
	public static final String CONTENT= "Content";
	//考核计划状态id
	public static final String ID_STATUS= "Id_status";
	//考核计划状态
	public static final String SD_STATUS= "Sd_status";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
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
	//名称
	public static final String NAME_CHKTP= "Name_chktp";
	//姓名
	public static final String NAME_CHK_PSN= "Name_chk_psn";
	//名称
	public static final String NAME_NUR_LVL= "Name_nur_lvl";
	//名称
	public static final String NAME_STATUS= "Name_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 考核计划主键
	 * @return String
	 */
	public String getId_exam_chk_pl() {
		return ((String) getAttrVal("Id_exam_chk_pl"));
	}	
	/**
	 * 考核计划主键
	 * @param Id_exam_chk_pl
	 */
	public void setId_exam_chk_pl(String Id_exam_chk_pl) {
		setAttrVal("Id_exam_chk_pl", Id_exam_chk_pl);
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
	 * 考核计划名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 考核计划名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 考核类型编码
	 * @return String
	 */
	public String getSd_chktp() {
		return ((String) getAttrVal("Sd_chktp"));
	}	
	/**
	 * 考核类型编码
	 * @param Sd_chktp
	 */
	public void setSd_chktp(String Sd_chktp) {
		setAttrVal("Sd_chktp", Sd_chktp);
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
	 * 通知标识
	 * @return FBoolean
	 */
	public FBoolean getFg_info() {
		return ((FBoolean) getAttrVal("Fg_info"));
	}	
	/**
	 * 通知标识
	 * @param Fg_info
	 */
	public void setFg_info(FBoolean Fg_info) {
		setAttrVal("Fg_info", Fg_info);
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
	 * 通知起始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_info_begin() {
		return ((FDateTime) getAttrVal("Dt_info_begin"));
	}	
	/**
	 * 通知起始时间
	 * @param Dt_info_begin
	 */
	public void setDt_info_begin(FDateTime Dt_info_begin) {
		setAttrVal("Dt_info_begin", Dt_info_begin);
	}
	/**
	 * 通知截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_info_end() {
		return ((FDateTime) getAttrVal("Dt_info_end"));
	}	
	/**
	 * 通知截止时间
	 * @param Dt_info_end
	 */
	public void setDt_info_end(FDateTime Dt_info_end) {
		setAttrVal("Dt_info_end", Dt_info_end);
	}
	/**
	 * 护士层级id
	 * @return String
	 */
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}	
	/**
	 * 护士层级id
	 * @param Id_nur_lvl
	 */
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	/**
	 * 护士层级(可多选)
	 * @return String
	 */
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}	
	/**
	 * 护士层级(可多选)
	 * @param Sd_nur_lvl
	 */
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
	}
	/**
	 * 考核地点
	 * @return String
	 */
	public String getAdress_chk() {
		return ((String) getAttrVal("Adress_chk"));
	}	
	/**
	 * 考核地点
	 * @param Adress_chk
	 */
	public void setAdress_chk(String Adress_chk) {
		setAttrVal("Adress_chk", Adress_chk);
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
	 * 考核计划状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	/**
	 * 考核计划状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 考核计划状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 考核计划状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_chk_psn() {
		return ((String) getAttrVal("Name_chk_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_chk_psn
	 */
	public void setName_chk_psn(String Name_chk_psn) {
		setAttrVal("Name_chk_psn", Name_chk_psn);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}	
	/**
	 * 名称
	 * @param Name_nur_lvl
	 */
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	/**
	 * 名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
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
		return "Id_exam_chk_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_CHK_PL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamChkPlDODesc.class);
	}
	
}