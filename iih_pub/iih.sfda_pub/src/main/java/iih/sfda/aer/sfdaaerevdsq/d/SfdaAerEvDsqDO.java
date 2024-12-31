package iih.sfda.aer.sfdaaerevdsq.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevdsq.d.desc.SfdaAerEvDsqDODesc;
import java.math.BigDecimal;

/**
 * 执行消毒隔离事件 DO数据 
 * 
 */
public class SfdaAerEvDsqDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//执行消毒隔离事件主键
	public static final String ID_AER_EV_DSQ= "Id_aer_ev_dsq";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//是否定期隔离消毒
	public static final String FG_AT_DSQ= "Fg_at_dsq";
	//最近隔离消毒日期
	public static final String DT_REC_DSQ= "Dt_rec_dsq";
	//消毒药物
	public static final String MED_DSQ= "Med_dsq";
	//有无监控护士在场
	public static final String FG_MNUR_ON= "Fg_mnur_on";
	//监控护士名称
	public static final String NAME_MNUR= "Name_mnur";
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
	//集团
	public static final String NAME_GRP= "Name_grp";
	//组织
	public static final String NAME_ORG= "Name_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 执行消毒隔离事件主键
	 * @return String
	 */
	public String getId_aer_ev_dsq() {
		return ((String) getAttrVal("Id_aer_ev_dsq"));
	}	
	/**
	 * 执行消毒隔离事件主键
	 * @param Id_aer_ev_dsq
	 */
	public void setId_aer_ev_dsq(String Id_aer_ev_dsq) {
		setAttrVal("Id_aer_ev_dsq", Id_aer_ev_dsq);
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
	 * 是否定期隔离消毒
	 * @return Integer
	 */
	public Integer getFg_at_dsq() {
		return ((Integer) getAttrVal("Fg_at_dsq"));
	}	
	/**
	 * 是否定期隔离消毒
	 * @param Fg_at_dsq
	 */
	public void setFg_at_dsq(Integer Fg_at_dsq) {
		setAttrVal("Fg_at_dsq", Fg_at_dsq);
	}
	/**
	 * 最近隔离消毒日期
	 * @return FDate
	 */
	public FDate getDt_rec_dsq() {
		return ((FDate) getAttrVal("Dt_rec_dsq"));
	}	
	/**
	 * 最近隔离消毒日期
	 * @param Dt_rec_dsq
	 */
	public void setDt_rec_dsq(FDate Dt_rec_dsq) {
		setAttrVal("Dt_rec_dsq", Dt_rec_dsq);
	}
	/**
	 * 消毒药物
	 * @return String
	 */
	public String getMed_dsq() {
		return ((String) getAttrVal("Med_dsq"));
	}	
	/**
	 * 消毒药物
	 * @param Med_dsq
	 */
	public void setMed_dsq(String Med_dsq) {
		setAttrVal("Med_dsq", Med_dsq);
	}
	/**
	 * 有无监控护士在场
	 * @return Integer
	 */
	public Integer getFg_mnur_on() {
		return ((Integer) getAttrVal("Fg_mnur_on"));
	}	
	/**
	 * 有无监控护士在场
	 * @param Fg_mnur_on
	 */
	public void setFg_mnur_on(Integer Fg_mnur_on) {
		setAttrVal("Fg_mnur_on", Fg_mnur_on);
	}
	/**
	 * 监控护士名称
	 * @return String
	 */
	public String getName_mnur() {
		return ((String) getAttrVal("Name_mnur"));
	}	
	/**
	 * 监控护士名称
	 * @param Name_mnur
	 */
	public void setName_mnur(String Name_mnur) {
		setAttrVal("Name_mnur", Name_mnur);
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
	 * 集团
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 集团
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
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
		return "Id_aer_ev_dsq";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_DSQ";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvDsqDODesc.class);
	}
	
}