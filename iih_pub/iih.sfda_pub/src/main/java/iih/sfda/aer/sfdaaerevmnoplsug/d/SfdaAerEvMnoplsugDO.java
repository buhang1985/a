package iih.sfda.aer.sfdaaerevmnoplsug.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmnoplsug.d.desc.SfdaAerEvMnoplsugDODesc;
import java.math.BigDecimal;

/**
 * 非计划再次手术 DO数据 
 * 
 */
public class SfdaAerEvMnoplsugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//非计划再次手术主键
	public static final String ID_AER_EV_MNOPLSUG= "Id_aer_ev_mnoplsug";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//入院时间
	public static final String ADMIT_TIME= "Admit_time";
	//入院科室
	public static final String ID_ADMIT_DEPT= "Id_admit_dept";
	//入院诊断
	public static final String ADMIT_DIAGS= "Admit_diags";
	//非计划再次手术原因
	public static final String NO_PLAN_SUGRES= "No_plan_sugres";
	//入院床号
	public static final String ADMIT_BEDNUM= "Admit_bednum";
	//病情摘要
	public static final String ILL_NESS= "Ill_ness";
	//首次手术时间
	public static final String FIRS_SUG_TIME= "Firs_sug_time";
	//首次手术情况id
	public static final String ID_FIRSUG_CASE= "Id_firsug_case";
	//首次手术情况编码
	public static final String SD_FIRSUG_CASE= "Sd_firsug_case";
	//首次手术情况具体描述
	public static final String FIRSUG_CASE_DES= "Firsug_case_des";
	//首次术后情况
	public static final String FIRS_POPERA_CASE= "Firs_popera_case";
	//属于重点监控手术id
	public static final String ID_KPOT_CONTSUG= "Id_kpot_contsug";
	//属于重点监控手术编码
	public static final String SD_KPOT_CONTSUG= "Sd_kpot_contsug";
	//属于重点其他监控手术
	public static final String KPOT_CONTSUG_OTH= "Kpot_contsug_oth";
	//再次手术时间
	public static final String AGN_SUG_TIME= "Agn_sug_time";
	//再次手术原因
	public static final String AGN_SUG_REAS= "Agn_sug_reas";
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
	//名称
	public static final String NAME_ADMIT_DEPT= "Name_admit_dept";
	//名称
	public static final String NAME_FIRSUG_CASE= "Name_firsug_case";
	//名称
	public static final String NAME_KPOT_CONTSUG= "Name_kpot_contsug";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 非计划再次手术主键
	 * @return String
	 */
	public String getId_aer_ev_mnoplsug() {
		return ((String) getAttrVal("Id_aer_ev_mnoplsug"));
	}	
	/**
	 * 非计划再次手术主键
	 * @param Id_aer_ev_mnoplsug
	 */
	public void setId_aer_ev_mnoplsug(String Id_aer_ev_mnoplsug) {
		setAttrVal("Id_aer_ev_mnoplsug", Id_aer_ev_mnoplsug);
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
	 * 入院时间
	 * @return FDate
	 */
	public FDate getAdmit_time() {
		return ((FDate) getAttrVal("Admit_time"));
	}	
	/**
	 * 入院时间
	 * @param Admit_time
	 */
	public void setAdmit_time(FDate Admit_time) {
		setAttrVal("Admit_time", Admit_time);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_admit_dept() {
		return ((String) getAttrVal("Id_admit_dept"));
	}	
	/**
	 * 入院科室
	 * @param Id_admit_dept
	 */
	public void setId_admit_dept(String Id_admit_dept) {
		setAttrVal("Id_admit_dept", Id_admit_dept);
	}
	/**
	 * 入院诊断
	 * @return String
	 */
	public String getAdmit_diags() {
		return ((String) getAttrVal("Admit_diags"));
	}	
	/**
	 * 入院诊断
	 * @param Admit_diags
	 */
	public void setAdmit_diags(String Admit_diags) {
		setAttrVal("Admit_diags", Admit_diags);
	}
	/**
	 * 非计划再次手术原因
	 * @return String
	 */
	public String getNo_plan_sugres() {
		return ((String) getAttrVal("No_plan_sugres"));
	}	
	/**
	 * 非计划再次手术原因
	 * @param No_plan_sugres
	 */
	public void setNo_plan_sugres(String No_plan_sugres) {
		setAttrVal("No_plan_sugres", No_plan_sugres);
	}
	/**
	 * 入院床号
	 * @return String
	 */
	public String getAdmit_bednum() {
		return ((String) getAttrVal("Admit_bednum"));
	}	
	/**
	 * 入院床号
	 * @param Admit_bednum
	 */
	public void setAdmit_bednum(String Admit_bednum) {
		setAttrVal("Admit_bednum", Admit_bednum);
	}
	/**
	 * 病情摘要
	 * @return String
	 */
	public String getIll_ness() {
		return ((String) getAttrVal("Ill_ness"));
	}	
	/**
	 * 病情摘要
	 * @param Ill_ness
	 */
	public void setIll_ness(String Ill_ness) {
		setAttrVal("Ill_ness", Ill_ness);
	}
	/**
	 * 首次手术时间
	 * @return FDateTime
	 */
	public FDateTime getFirs_sug_time() {
		return ((FDateTime) getAttrVal("Firs_sug_time"));
	}	
	/**
	 * 首次手术时间
	 * @param Firs_sug_time
	 */
	public void setFirs_sug_time(FDateTime Firs_sug_time) {
		setAttrVal("Firs_sug_time", Firs_sug_time);
	}
	/**
	 * 首次手术情况id
	 * @return String
	 */
	public String getId_firsug_case() {
		return ((String) getAttrVal("Id_firsug_case"));
	}	
	/**
	 * 首次手术情况id
	 * @param Id_firsug_case
	 */
	public void setId_firsug_case(String Id_firsug_case) {
		setAttrVal("Id_firsug_case", Id_firsug_case);
	}
	/**
	 * 首次手术情况编码
	 * @return String
	 */
	public String getSd_firsug_case() {
		return ((String) getAttrVal("Sd_firsug_case"));
	}	
	/**
	 * 首次手术情况编码
	 * @param Sd_firsug_case
	 */
	public void setSd_firsug_case(String Sd_firsug_case) {
		setAttrVal("Sd_firsug_case", Sd_firsug_case);
	}
	/**
	 * 首次手术情况具体描述
	 * @return String
	 */
	public String getFirsug_case_des() {
		return ((String) getAttrVal("Firsug_case_des"));
	}	
	/**
	 * 首次手术情况具体描述
	 * @param Firsug_case_des
	 */
	public void setFirsug_case_des(String Firsug_case_des) {
		setAttrVal("Firsug_case_des", Firsug_case_des);
	}
	/**
	 * 首次术后情况
	 * @return String
	 */
	public String getFirs_popera_case() {
		return ((String) getAttrVal("Firs_popera_case"));
	}	
	/**
	 * 首次术后情况
	 * @param Firs_popera_case
	 */
	public void setFirs_popera_case(String Firs_popera_case) {
		setAttrVal("Firs_popera_case", Firs_popera_case);
	}
	/**
	 * 属于重点监控手术id
	 * @return String
	 */
	public String getId_kpot_contsug() {
		return ((String) getAttrVal("Id_kpot_contsug"));
	}	
	/**
	 * 属于重点监控手术id
	 * @param Id_kpot_contsug
	 */
	public void setId_kpot_contsug(String Id_kpot_contsug) {
		setAttrVal("Id_kpot_contsug", Id_kpot_contsug);
	}
	/**
	 * 属于重点监控手术编码
	 * @return String
	 */
	public String getSd_kpot_contsug() {
		return ((String) getAttrVal("Sd_kpot_contsug"));
	}	
	/**
	 * 属于重点监控手术编码
	 * @param Sd_kpot_contsug
	 */
	public void setSd_kpot_contsug(String Sd_kpot_contsug) {
		setAttrVal("Sd_kpot_contsug", Sd_kpot_contsug);
	}
	/**
	 * 属于重点其他监控手术
	 * @return String
	 */
	public String getKpot_contsug_oth() {
		return ((String) getAttrVal("Kpot_contsug_oth"));
	}	
	/**
	 * 属于重点其他监控手术
	 * @param Kpot_contsug_oth
	 */
	public void setKpot_contsug_oth(String Kpot_contsug_oth) {
		setAttrVal("Kpot_contsug_oth", Kpot_contsug_oth);
	}
	/**
	 * 再次手术时间
	 * @return FDateTime
	 */
	public FDateTime getAgn_sug_time() {
		return ((FDateTime) getAttrVal("Agn_sug_time"));
	}	
	/**
	 * 再次手术时间
	 * @param Agn_sug_time
	 */
	public void setAgn_sug_time(FDateTime Agn_sug_time) {
		setAttrVal("Agn_sug_time", Agn_sug_time);
	}
	/**
	 * 再次手术原因
	 * @return String
	 */
	public String getAgn_sug_reas() {
		return ((String) getAttrVal("Agn_sug_reas"));
	}	
	/**
	 * 再次手术原因
	 * @param Agn_sug_reas
	 */
	public void setAgn_sug_reas(String Agn_sug_reas) {
		setAttrVal("Agn_sug_reas", Agn_sug_reas);
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
	 * 名称
	 * @return String
	 */
	public String getName_admit_dept() {
		return ((String) getAttrVal("Name_admit_dept"));
	}	
	/**
	 * 名称
	 * @param Name_admit_dept
	 */
	public void setName_admit_dept(String Name_admit_dept) {
		setAttrVal("Name_admit_dept", Name_admit_dept);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_firsug_case() {
		return ((String) getAttrVal("Name_firsug_case"));
	}	
	/**
	 * 名称
	 * @param Name_firsug_case
	 */
	public void setName_firsug_case(String Name_firsug_case) {
		setAttrVal("Name_firsug_case", Name_firsug_case);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_kpot_contsug() {
		return ((String) getAttrVal("Name_kpot_contsug"));
	}	
	/**
	 * 名称
	 * @param Name_kpot_contsug
	 */
	public void setName_kpot_contsug(String Name_kpot_contsug) {
		setAttrVal("Name_kpot_contsug", Name_kpot_contsug);
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
		return "Id_aer_ev_mnoplsug";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MNOPLSUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMnoplsugDODesc.class);
	}
	
}