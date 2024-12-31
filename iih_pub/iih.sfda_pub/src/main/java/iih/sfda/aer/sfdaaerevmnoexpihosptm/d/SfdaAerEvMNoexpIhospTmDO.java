package iih.sfda.aer.sfdaaerevmnoexpihosptm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmnoexpihosptm.d.desc.SfdaAerEvMNoexpIhospTmDODesc;
import java.math.BigDecimal;

/**
 * 非预期延长住院时间 DO数据 
 * 
 */
public class SfdaAerEvMNoexpIhospTmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//非预期延长住院时间主键
	public static final String ID_AER_EV_MNOEXPIHOSPTM= "Id_aer_ev_mnoexpihosptm";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//患者入院日期
	public static final String PAT_IHOSP_TM= "Pat_ihosp_tm";
	//患者病案号
	public static final String PAT_MED_NUM= "Pat_med_num";
	//住院天数
	public static final String IN_HOSP_DAY= "In_hosp_day";
	//诊疗科室
	public static final String DIAGN_DEP= "Diagn_dep";
	//入院诊断
	public static final String IN_HOSP_DIAGN= "In_hosp_diagn";
	//诊疗经过
	public static final String DIAGN_PASS= "Diagn_pass";
	//当前诊断
	public static final String CURR_DIAGN= "Curr_diagn";
	//长期住院原因id
	public static final String ID_LIHOSP_REAS= "Id_lihosp_reas";
	//长期住院原因编码
	public static final String SD_LIHOSP_REAS= "Sd_lihosp_reas";
	//长期住院其他原因
	public static final String OTH_LIHOSP_REAS= "Oth_lihosp_reas";
	//存在问题
	public static final String EXIS_PROBM= "Exis_probm";
	//非预期事件处理措施
	public static final String NO_EXPT_HANDM= "No_expt_handm";
	//扩展字段1
	public static final String EXT1= "Ext1";
	//扩展字段2
	public static final String EXT2= "Ext2";
	//扩展字段3
	public static final String EXT3= "Ext3";
	//扩展字段4
	public static final String EXT4= "Ext4";
	//扩展字段5
	public static final String EXT5= "Ext5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//扩展字段1
	public static final String NAME_LIHOSP_REAS= "Name_lihosp_reas";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 非预期延长住院时间主键
	 * @return String
	 */
	public String getId_aer_ev_mnoexpihosptm() {
		return ((String) getAttrVal("Id_aer_ev_mnoexpihosptm"));
	}	
	/**
	 * 非预期延长住院时间主键
	 * @param Id_aer_ev_mnoexpihosptm
	 */
	public void setId_aer_ev_mnoexpihosptm(String Id_aer_ev_mnoexpihosptm) {
		setAttrVal("Id_aer_ev_mnoexpihosptm", Id_aer_ev_mnoexpihosptm);
	}
	/**
	 * 护理安全事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 护理安全事件外键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者入院日期
	 * @return FDate
	 */
	public FDate getPat_ihosp_tm() {
		return ((FDate) getAttrVal("Pat_ihosp_tm"));
	}	
	/**
	 * 患者入院日期
	 * @param Pat_ihosp_tm
	 */
	public void setPat_ihosp_tm(FDate Pat_ihosp_tm) {
		setAttrVal("Pat_ihosp_tm", Pat_ihosp_tm);
	}
	/**
	 * 患者病案号
	 * @return String
	 */
	public String getPat_med_num() {
		return ((String) getAttrVal("Pat_med_num"));
	}	
	/**
	 * 患者病案号
	 * @param Pat_med_num
	 */
	public void setPat_med_num(String Pat_med_num) {
		setAttrVal("Pat_med_num", Pat_med_num);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getIn_hosp_day() {
		return ((Integer) getAttrVal("In_hosp_day"));
	}	
	/**
	 * 住院天数
	 * @param In_hosp_day
	 */
	public void setIn_hosp_day(Integer In_hosp_day) {
		setAttrVal("In_hosp_day", In_hosp_day);
	}
	/**
	 * 诊疗科室
	 * @return String
	 */
	public String getDiagn_dep() {
		return ((String) getAttrVal("Diagn_dep"));
	}	
	/**
	 * 诊疗科室
	 * @param Diagn_dep
	 */
	public void setDiagn_dep(String Diagn_dep) {
		setAttrVal("Diagn_dep", Diagn_dep);
	}
	/**
	 * 入院诊断
	 * @return String
	 */
	public String getIn_hosp_diagn() {
		return ((String) getAttrVal("In_hosp_diagn"));
	}	
	/**
	 * 入院诊断
	 * @param In_hosp_diagn
	 */
	public void setIn_hosp_diagn(String In_hosp_diagn) {
		setAttrVal("In_hosp_diagn", In_hosp_diagn);
	}
	/**
	 * 诊疗经过
	 * @return String
	 */
	public String getDiagn_pass() {
		return ((String) getAttrVal("Diagn_pass"));
	}	
	/**
	 * 诊疗经过
	 * @param Diagn_pass
	 */
	public void setDiagn_pass(String Diagn_pass) {
		setAttrVal("Diagn_pass", Diagn_pass);
	}
	/**
	 * 当前诊断
	 * @return String
	 */
	public String getCurr_diagn() {
		return ((String) getAttrVal("Curr_diagn"));
	}	
	/**
	 * 当前诊断
	 * @param Curr_diagn
	 */
	public void setCurr_diagn(String Curr_diagn) {
		setAttrVal("Curr_diagn", Curr_diagn);
	}
	/**
	 * 长期住院原因id
	 * @return String
	 */
	public String getId_lihosp_reas() {
		return ((String) getAttrVal("Id_lihosp_reas"));
	}	
	/**
	 * 长期住院原因id
	 * @param Id_lihosp_reas
	 */
	public void setId_lihosp_reas(String Id_lihosp_reas) {
		setAttrVal("Id_lihosp_reas", Id_lihosp_reas);
	}
	/**
	 * 长期住院原因编码
	 * @return String
	 */
	public String getSd_lihosp_reas() {
		return ((String) getAttrVal("Sd_lihosp_reas"));
	}	
	/**
	 * 长期住院原因编码
	 * @param Sd_lihosp_reas
	 */
	public void setSd_lihosp_reas(String Sd_lihosp_reas) {
		setAttrVal("Sd_lihosp_reas", Sd_lihosp_reas);
	}
	/**
	 * 长期住院其他原因
	 * @return String
	 */
	public String getOth_lihosp_reas() {
		return ((String) getAttrVal("Oth_lihosp_reas"));
	}	
	/**
	 * 长期住院其他原因
	 * @param Oth_lihosp_reas
	 */
	public void setOth_lihosp_reas(String Oth_lihosp_reas) {
		setAttrVal("Oth_lihosp_reas", Oth_lihosp_reas);
	}
	/**
	 * 存在问题
	 * @return String
	 */
	public String getExis_probm() {
		return ((String) getAttrVal("Exis_probm"));
	}	
	/**
	 * 存在问题
	 * @param Exis_probm
	 */
	public void setExis_probm(String Exis_probm) {
		setAttrVal("Exis_probm", Exis_probm);
	}
	/**
	 * 非预期事件处理措施
	 * @return String
	 */
	public String getNo_expt_handm() {
		return ((String) getAttrVal("No_expt_handm"));
	}	
	/**
	 * 非预期事件处理措施
	 * @param No_expt_handm
	 */
	public void setNo_expt_handm(String No_expt_handm) {
		setAttrVal("No_expt_handm", No_expt_handm);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getExt1() {
		return ((String) getAttrVal("Ext1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ext1
	 */
	public void setExt1(String Ext1) {
		setAttrVal("Ext1", Ext1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getExt2() {
		return ((String) getAttrVal("Ext2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ext2
	 */
	public void setExt2(String Ext2) {
		setAttrVal("Ext2", Ext2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getExt3() {
		return ((String) getAttrVal("Ext3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ext3
	 */
	public void setExt3(String Ext3) {
		setAttrVal("Ext3", Ext3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getExt4() {
		return ((String) getAttrVal("Ext4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ext4
	 */
	public void setExt4(String Ext4) {
		setAttrVal("Ext4", Ext4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getExt5() {
		return ((String) getAttrVal("Ext5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ext5
	 */
	public void setExt5(String Ext5) {
		setAttrVal("Ext5", Ext5);
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
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
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
	 * 扩展字段1
	 * @return String
	 */
	public String getName_lihosp_reas() {
		return ((String) getAttrVal("Name_lihosp_reas"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_lihosp_reas
	 */
	public void setName_lihosp_reas(String Name_lihosp_reas) {
		setAttrVal("Name_lihosp_reas", Name_lihosp_reas);
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
		return "Id_aer_ev_mnoexpihosptm";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MNOEXPIHOSPTM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMNoexpIhospTmDODesc.class);
	}
	
}