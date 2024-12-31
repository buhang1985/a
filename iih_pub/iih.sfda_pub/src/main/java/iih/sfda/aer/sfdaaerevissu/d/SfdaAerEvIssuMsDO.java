package iih.sfda.aer.sfdaaerevissu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevissu.d.desc.SfdaAerEvIssuMsDODesc;
import java.math.BigDecimal;

/**
 * 整改措施 DO数据 
 * 
 */
public class SfdaAerEvIssuMsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//整改措施主键
	public static final String ID_AER_EV_ISSU_MS= "Id_aer_ev_issu_ms";
	//整改问题外键
	public static final String ID_AER_EV_ISSU= "Id_aer_ev_issu";
	//对策内容
	public static final String CTM_CONTENT= "Ctm_content";
	//对策实施责任人
	public static final String ID_IMP_PSN= "Id_imp_psn";
	//整改开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//整改结束日期
	public static final String DT_END= "Dt_end";
	//实施详情
	public static final String IMP_DETAILS= "Imp_details";
	//对策效果
	public static final String CTM_EFFECT= "Ctm_effect";
	//对策处置
	public static final String CTM_DSP= "Ctm_dsp";
	//遗留问题说明
	public static final String LEGACY= "Legacy";
	//登记人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//扩展字段1
	public static final String EXT1= "Ext1";
	//扩展字段2
	public static final String EXT2= "Ext2";
	//扩展字段3
	public static final String EXT3= "Ext3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//对策实施责任人
	public static final String NAME_IMP_PSN= "Name_imp_psn";
	//姓名
	public static final String NAME_PSN_REG= "Name_psn_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 整改措施主键
	 * @return String
	 */
	public String getId_aer_ev_issu_ms() {
		return ((String) getAttrVal("Id_aer_ev_issu_ms"));
	}	
	/**
	 * 整改措施主键
	 * @param Id_aer_ev_issu_ms
	 */
	public void setId_aer_ev_issu_ms(String Id_aer_ev_issu_ms) {
		setAttrVal("Id_aer_ev_issu_ms", Id_aer_ev_issu_ms);
	}
	/**
	 * 整改问题外键
	 * @return String
	 */
	public String getId_aer_ev_issu() {
		return ((String) getAttrVal("Id_aer_ev_issu"));
	}	
	/**
	 * 整改问题外键
	 * @param Id_aer_ev_issu
	 */
	public void setId_aer_ev_issu(String Id_aer_ev_issu) {
		setAttrVal("Id_aer_ev_issu", Id_aer_ev_issu);
	}
	/**
	 * 对策内容
	 * @return String
	 */
	public String getCtm_content() {
		return ((String) getAttrVal("Ctm_content"));
	}	
	/**
	 * 对策内容
	 * @param Ctm_content
	 */
	public void setCtm_content(String Ctm_content) {
		setAttrVal("Ctm_content", Ctm_content);
	}
	/**
	 * 对策实施责任人
	 * @return String
	 */
	public String getId_imp_psn() {
		return ((String) getAttrVal("Id_imp_psn"));
	}	
	/**
	 * 对策实施责任人
	 * @param Id_imp_psn
	 */
	public void setId_imp_psn(String Id_imp_psn) {
		setAttrVal("Id_imp_psn", Id_imp_psn);
	}
	/**
	 * 整改开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 整改开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 整改结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 整改结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 实施详情
	 * @return String
	 */
	public String getImp_details() {
		return ((String) getAttrVal("Imp_details"));
	}	
	/**
	 * 实施详情
	 * @param Imp_details
	 */
	public void setImp_details(String Imp_details) {
		setAttrVal("Imp_details", Imp_details);
	}
	/**
	 * 对策效果
	 * @return String
	 */
	public String getCtm_effect() {
		return ((String) getAttrVal("Ctm_effect"));
	}	
	/**
	 * 对策效果
	 * @param Ctm_effect
	 */
	public void setCtm_effect(String Ctm_effect) {
		setAttrVal("Ctm_effect", Ctm_effect);
	}
	/**
	 * 对策处置
	 * @return String
	 */
	public String getCtm_dsp() {
		return ((String) getAttrVal("Ctm_dsp"));
	}	
	/**
	 * 对策处置
	 * @param Ctm_dsp
	 */
	public void setCtm_dsp(String Ctm_dsp) {
		setAttrVal("Ctm_dsp", Ctm_dsp);
	}
	/**
	 * 遗留问题说明
	 * @return String
	 */
	public String getLegacy() {
		return ((String) getAttrVal("Legacy"));
	}	
	/**
	 * 遗留问题说明
	 * @param Legacy
	 */
	public void setLegacy(String Legacy) {
		setAttrVal("Legacy", Legacy);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	 * 对策实施责任人
	 * @return String
	 */
	public String getName_imp_psn() {
		return ((String) getAttrVal("Name_imp_psn"));
	}	
	/**
	 * 对策实施责任人
	 * @param Name_imp_psn
	 */
	public void setName_imp_psn(String Name_imp_psn) {
		setAttrVal("Name_imp_psn", Name_imp_psn);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psn_reg() {
		return ((String) getAttrVal("Name_psn_reg"));
	}	
	/**
	 * 姓名
	 * @param Name_psn_reg
	 */
	public void setName_psn_reg(String Name_psn_reg) {
		setAttrVal("Name_psn_reg", Name_psn_reg);
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
		return "Id_aer_ev_issu_ms";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_ISSU_MS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvIssuMsDODesc.class);
	}
	
}