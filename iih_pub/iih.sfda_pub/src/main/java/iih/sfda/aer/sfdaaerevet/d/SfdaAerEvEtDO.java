package iih.sfda.aer.sfdaaerevet.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevet.d.desc.SfdaAerEvEtDODesc;
import java.math.BigDecimal;

/**
 * 跟踪事件 DO数据 
 * 
 */
public class SfdaAerEvEtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//不良上报跟踪主键
	public static final String ID_AER_EV_ET= "Id_aer_ev_et";
	//不良事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//主题
	public static final String THEME= "Theme";
	//患者是否已经出院
	public static final String EU_PATOUT= "Eu_patout";
	//该事件是否对患者的身体产生影响
	public static final String EU_PSY_EFFT= "Eu_psy_efft";
	//该事件是否对患者的心理产生影响
	public static final String EU_BODY_EFFT= "Eu_body_efft";
	//该事件 是否需要修订工作制度
	public static final String EU_WORKSYS= "Eu_worksys";
	//该事件是否需要完善工作流程
	public static final String EU_WORKFLOW= "Eu_workflow";
	//跟踪反馈情况
	public static final String TRACK_COND= "Track_cond";
	//报告跟踪的整改效果
	public static final String RECTIFY_RES= "Rectify_res";
	//报告跟踪的意见
	public static final String TRACK_OPIN= "Track_opin";
	//序号
	public static final String SORTNO= "Sortno";
	//跟踪者
	public static final String ID_PSN_ET= "Id_psn_et";
	//发起时间
	public static final String DT_ET= "Dt_et";
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
	//姓名
	public static final String NAME_PSN_ET= "Name_psn_et";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 不良上报跟踪主键
	 * @return String
	 */
	public String getId_aer_ev_et() {
		return ((String) getAttrVal("Id_aer_ev_et"));
	}	
	/**
	 * 不良上报跟踪主键
	 * @param Id_aer_ev_et
	 */
	public void setId_aer_ev_et(String Id_aer_ev_et) {
		setAttrVal("Id_aer_ev_et", Id_aer_ev_et);
	}
	/**
	 * 不良事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 不良事件外键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
	}
	/**
	 * 主题
	 * @return String
	 */
	public String getTheme() {
		return ((String) getAttrVal("Theme"));
	}	
	/**
	 * 主题
	 * @param Theme
	 */
	public void setTheme(String Theme) {
		setAttrVal("Theme", Theme);
	}
	/**
	 * 患者是否已经出院
	 * @return Integer
	 */
	public Integer getEu_patout() {
		return ((Integer) getAttrVal("Eu_patout"));
	}	
	/**
	 * 患者是否已经出院
	 * @param Eu_patout
	 */
	public void setEu_patout(Integer Eu_patout) {
		setAttrVal("Eu_patout", Eu_patout);
	}
	/**
	 * 该事件是否对患者的身体产生影响
	 * @return Integer
	 */
	public Integer getEu_psy_efft() {
		return ((Integer) getAttrVal("Eu_psy_efft"));
	}	
	/**
	 * 该事件是否对患者的身体产生影响
	 * @param Eu_psy_efft
	 */
	public void setEu_psy_efft(Integer Eu_psy_efft) {
		setAttrVal("Eu_psy_efft", Eu_psy_efft);
	}
	/**
	 * 该事件是否对患者的心理产生影响
	 * @return Integer
	 */
	public Integer getEu_body_efft() {
		return ((Integer) getAttrVal("Eu_body_efft"));
	}	
	/**
	 * 该事件是否对患者的心理产生影响
	 * @param Eu_body_efft
	 */
	public void setEu_body_efft(Integer Eu_body_efft) {
		setAttrVal("Eu_body_efft", Eu_body_efft);
	}
	/**
	 * 该事件 是否需要修订工作制度
	 * @return Integer
	 */
	public Integer getEu_worksys() {
		return ((Integer) getAttrVal("Eu_worksys"));
	}	
	/**
	 * 该事件 是否需要修订工作制度
	 * @param Eu_worksys
	 */
	public void setEu_worksys(Integer Eu_worksys) {
		setAttrVal("Eu_worksys", Eu_worksys);
	}
	/**
	 * 该事件是否需要完善工作流程
	 * @return Integer
	 */
	public Integer getEu_workflow() {
		return ((Integer) getAttrVal("Eu_workflow"));
	}	
	/**
	 * 该事件是否需要完善工作流程
	 * @param Eu_workflow
	 */
	public void setEu_workflow(Integer Eu_workflow) {
		setAttrVal("Eu_workflow", Eu_workflow);
	}
	/**
	 * 跟踪反馈情况
	 * @return String
	 */
	public String getTrack_cond() {
		return ((String) getAttrVal("Track_cond"));
	}	
	/**
	 * 跟踪反馈情况
	 * @param Track_cond
	 */
	public void setTrack_cond(String Track_cond) {
		setAttrVal("Track_cond", Track_cond);
	}
	/**
	 * 报告跟踪的整改效果
	 * @return String
	 */
	public String getRectify_res() {
		return ((String) getAttrVal("Rectify_res"));
	}	
	/**
	 * 报告跟踪的整改效果
	 * @param Rectify_res
	 */
	public void setRectify_res(String Rectify_res) {
		setAttrVal("Rectify_res", Rectify_res);
	}
	/**
	 * 报告跟踪的意见
	 * @return String
	 */
	public String getTrack_opin() {
		return ((String) getAttrVal("Track_opin"));
	}	
	/**
	 * 报告跟踪的意见
	 * @param Track_opin
	 */
	public void setTrack_opin(String Track_opin) {
		setAttrVal("Track_opin", Track_opin);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 跟踪者
	 * @return String
	 */
	public String getId_psn_et() {
		return ((String) getAttrVal("Id_psn_et"));
	}	
	/**
	 * 跟踪者
	 * @param Id_psn_et
	 */
	public void setId_psn_et(String Id_psn_et) {
		setAttrVal("Id_psn_et", Id_psn_et);
	}
	/**
	 * 发起时间
	 * @return FDateTime
	 */
	public FDateTime getDt_et() {
		return ((FDateTime) getAttrVal("Dt_et"));
	}	
	/**
	 * 发起时间
	 * @param Dt_et
	 */
	public void setDt_et(FDateTime Dt_et) {
		setAttrVal("Dt_et", Dt_et);
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
		return "Id_aer_ev_et";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_ET";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvEtDODesc.class);
	}
	
}