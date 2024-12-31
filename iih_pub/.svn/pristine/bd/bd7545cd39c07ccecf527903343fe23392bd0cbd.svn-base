package iih.sfda.aer.sfdaaerevmnoexphosp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmnoexphosp.d.desc.SfdaAerEvMNoexphospDODesc;
import java.math.BigDecimal;

/**
 * 非预期再住院事件 DO数据 
 * 
 */
public class SfdaAerEvMNoexphospDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//非预期再住院主键
	public static final String ID_AER_EV_MNOXEPHOSP= "Id_aer_ev_mnoxephosp";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//非预期再入院分类id
	public static final String ID_NOEXP_AGHOSP= "Id_noexp_aghosp";
	//非预期再入院分类编码
	public static final String SD_NOEXP_AGHOSP= "Sd_noexp_aghosp";
	//上次住院日时
	public static final String LT_IHOSP_TM= "Lt_ihosp_tm";
	//上次主治医生
	public static final String LT_ATD_DOCT= "Lt_atd_doct";
	//上次出院日时
	public static final String LT_OHOSP_TM= "Lt_ohosp_tm";
	//上次住院号
	public static final String LT_OHOSP_NUM= "Lt_ohosp_num";
	//本次入院日时
	public static final String TH_IHOSP_TM= "Th_ihosp_tm";
	//是否是出院当日再次入院
	public static final String EU_AGAN_IHOSP= "Eu_agan_ihosp";
	//上次住院情况说明
	public static final String LT_IHOSP_STATE= "Lt_ihosp_state";
	//上次出院情况说明
	public static final String LT_OHOSP_STATE= "Lt_ohosp_state";
	//再次入院诊断
	public static final String AG_IHOSP_DIAGN= "Ag_ihosp_diagn";
	//属于重点监控疾病id
	public static final String ID_POIT_CONDIS= "Id_poit_condis";
	//属于重点监控疾病编码
	public static final String SD_POIT_CONDIS= "Sd_poit_condis";
	//属于重点监控其他疾病
	public static final String OTH_POIT_CONDIS= "Oth_poit_condis";
	//再次入院原因
	public static final String AG_IHOSP_REAS= "Ag_ihosp_reas";
	//再次住院采取的措施
	public static final String AG_IHOSP_STEP= "Ag_ihosp_step";
	//发生本次事件的过程
	public static final String OCCUR_EVEN_COUR= "Occur_even_cour";
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
	public static final String NAME_NOEXP_AGHOSP= "Name_noexp_aghosp";
	//名称
	public static final String NAME_POIT_CONDIS= "Name_poit_condis";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 非预期再住院主键
	 * @return String
	 */
	public String getId_aer_ev_mnoxephosp() {
		return ((String) getAttrVal("Id_aer_ev_mnoxephosp"));
	}	
	/**
	 * 非预期再住院主键
	 * @param Id_aer_ev_mnoxephosp
	 */
	public void setId_aer_ev_mnoxephosp(String Id_aer_ev_mnoxephosp) {
		setAttrVal("Id_aer_ev_mnoxephosp", Id_aer_ev_mnoxephosp);
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
	 * 非预期再入院分类id
	 * @return String
	 */
	public String getId_noexp_aghosp() {
		return ((String) getAttrVal("Id_noexp_aghosp"));
	}	
	/**
	 * 非预期再入院分类id
	 * @param Id_noexp_aghosp
	 */
	public void setId_noexp_aghosp(String Id_noexp_aghosp) {
		setAttrVal("Id_noexp_aghosp", Id_noexp_aghosp);
	}
	/**
	 * 非预期再入院分类编码
	 * @return String
	 */
	public String getSd_noexp_aghosp() {
		return ((String) getAttrVal("Sd_noexp_aghosp"));
	}	
	/**
	 * 非预期再入院分类编码
	 * @param Sd_noexp_aghosp
	 */
	public void setSd_noexp_aghosp(String Sd_noexp_aghosp) {
		setAttrVal("Sd_noexp_aghosp", Sd_noexp_aghosp);
	}
	/**
	 * 上次住院日时
	 * @return FDateTime
	 */
	public FDateTime getLt_ihosp_tm() {
		return ((FDateTime) getAttrVal("Lt_ihosp_tm"));
	}	
	/**
	 * 上次住院日时
	 * @param Lt_ihosp_tm
	 */
	public void setLt_ihosp_tm(FDateTime Lt_ihosp_tm) {
		setAttrVal("Lt_ihosp_tm", Lt_ihosp_tm);
	}
	/**
	 * 上次主治医生
	 * @return String
	 */
	public String getLt_atd_doct() {
		return ((String) getAttrVal("Lt_atd_doct"));
	}	
	/**
	 * 上次主治医生
	 * @param Lt_atd_doct
	 */
	public void setLt_atd_doct(String Lt_atd_doct) {
		setAttrVal("Lt_atd_doct", Lt_atd_doct);
	}
	/**
	 * 上次出院日时
	 * @return FDateTime
	 */
	public FDateTime getLt_ohosp_tm() {
		return ((FDateTime) getAttrVal("Lt_ohosp_tm"));
	}	
	/**
	 * 上次出院日时
	 * @param Lt_ohosp_tm
	 */
	public void setLt_ohosp_tm(FDateTime Lt_ohosp_tm) {
		setAttrVal("Lt_ohosp_tm", Lt_ohosp_tm);
	}
	/**
	 * 上次住院号
	 * @return String
	 */
	public String getLt_ohosp_num() {
		return ((String) getAttrVal("Lt_ohosp_num"));
	}	
	/**
	 * 上次住院号
	 * @param Lt_ohosp_num
	 */
	public void setLt_ohosp_num(String Lt_ohosp_num) {
		setAttrVal("Lt_ohosp_num", Lt_ohosp_num);
	}
	/**
	 * 本次入院日时
	 * @return FDateTime
	 */
	public FDateTime getTh_ihosp_tm() {
		return ((FDateTime) getAttrVal("Th_ihosp_tm"));
	}	
	/**
	 * 本次入院日时
	 * @param Th_ihosp_tm
	 */
	public void setTh_ihosp_tm(FDateTime Th_ihosp_tm) {
		setAttrVal("Th_ihosp_tm", Th_ihosp_tm);
	}
	/**
	 * 是否是出院当日再次入院
	 * @return Integer
	 */
	public Integer getEu_agan_ihosp() {
		return ((Integer) getAttrVal("Eu_agan_ihosp"));
	}	
	/**
	 * 是否是出院当日再次入院
	 * @param Eu_agan_ihosp
	 */
	public void setEu_agan_ihosp(Integer Eu_agan_ihosp) {
		setAttrVal("Eu_agan_ihosp", Eu_agan_ihosp);
	}
	/**
	 * 上次住院情况说明
	 * @return String
	 */
	public String getLt_ihosp_state() {
		return ((String) getAttrVal("Lt_ihosp_state"));
	}	
	/**
	 * 上次住院情况说明
	 * @param Lt_ihosp_state
	 */
	public void setLt_ihosp_state(String Lt_ihosp_state) {
		setAttrVal("Lt_ihosp_state", Lt_ihosp_state);
	}
	/**
	 * 上次出院情况说明
	 * @return String
	 */
	public String getLt_ohosp_state() {
		return ((String) getAttrVal("Lt_ohosp_state"));
	}	
	/**
	 * 上次出院情况说明
	 * @param Lt_ohosp_state
	 */
	public void setLt_ohosp_state(String Lt_ohosp_state) {
		setAttrVal("Lt_ohosp_state", Lt_ohosp_state);
	}
	/**
	 * 再次入院诊断
	 * @return String
	 */
	public String getAg_ihosp_diagn() {
		return ((String) getAttrVal("Ag_ihosp_diagn"));
	}	
	/**
	 * 再次入院诊断
	 * @param Ag_ihosp_diagn
	 */
	public void setAg_ihosp_diagn(String Ag_ihosp_diagn) {
		setAttrVal("Ag_ihosp_diagn", Ag_ihosp_diagn);
	}
	/**
	 * 属于重点监控疾病id
	 * @return String
	 */
	public String getId_poit_condis() {
		return ((String) getAttrVal("Id_poit_condis"));
	}	
	/**
	 * 属于重点监控疾病id
	 * @param Id_poit_condis
	 */
	public void setId_poit_condis(String Id_poit_condis) {
		setAttrVal("Id_poit_condis", Id_poit_condis);
	}
	/**
	 * 属于重点监控疾病编码
	 * @return String
	 */
	public String getSd_poit_condis() {
		return ((String) getAttrVal("Sd_poit_condis"));
	}	
	/**
	 * 属于重点监控疾病编码
	 * @param Sd_poit_condis
	 */
	public void setSd_poit_condis(String Sd_poit_condis) {
		setAttrVal("Sd_poit_condis", Sd_poit_condis);
	}
	/**
	 * 属于重点监控其他疾病
	 * @return String
	 */
	public String getOth_poit_condis() {
		return ((String) getAttrVal("Oth_poit_condis"));
	}	
	/**
	 * 属于重点监控其他疾病
	 * @param Oth_poit_condis
	 */
	public void setOth_poit_condis(String Oth_poit_condis) {
		setAttrVal("Oth_poit_condis", Oth_poit_condis);
	}
	/**
	 * 再次入院原因
	 * @return String
	 */
	public String getAg_ihosp_reas() {
		return ((String) getAttrVal("Ag_ihosp_reas"));
	}	
	/**
	 * 再次入院原因
	 * @param Ag_ihosp_reas
	 */
	public void setAg_ihosp_reas(String Ag_ihosp_reas) {
		setAttrVal("Ag_ihosp_reas", Ag_ihosp_reas);
	}
	/**
	 * 再次住院采取的措施
	 * @return String
	 */
	public String getAg_ihosp_step() {
		return ((String) getAttrVal("Ag_ihosp_step"));
	}	
	/**
	 * 再次住院采取的措施
	 * @param Ag_ihosp_step
	 */
	public void setAg_ihosp_step(String Ag_ihosp_step) {
		setAttrVal("Ag_ihosp_step", Ag_ihosp_step);
	}
	/**
	 * 发生本次事件的过程
	 * @return String
	 */
	public String getOccur_even_cour() {
		return ((String) getAttrVal("Occur_even_cour"));
	}	
	/**
	 * 发生本次事件的过程
	 * @param Occur_even_cour
	 */
	public void setOccur_even_cour(String Occur_even_cour) {
		setAttrVal("Occur_even_cour", Occur_even_cour);
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
	public String getName_noexp_aghosp() {
		return ((String) getAttrVal("Name_noexp_aghosp"));
	}	
	/**
	 * 名称
	 * @param Name_noexp_aghosp
	 */
	public void setName_noexp_aghosp(String Name_noexp_aghosp) {
		setAttrVal("Name_noexp_aghosp", Name_noexp_aghosp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_poit_condis() {
		return ((String) getAttrVal("Name_poit_condis"));
	}	
	/**
	 * 名称
	 * @param Name_poit_condis
	 */
	public void setName_poit_condis(String Name_poit_condis) {
		setAttrVal("Name_poit_condis", Name_poit_condis);
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
		return "Id_aer_ev_mnoxephosp";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MNOEXPHOSP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMNoexphospDODesc.class);
	}
	
}