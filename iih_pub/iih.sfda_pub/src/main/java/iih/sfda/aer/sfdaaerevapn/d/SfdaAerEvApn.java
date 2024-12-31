package iih.sfda.aer.sfdaaerevapn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevapn.d.desc.SfdaAerEvApnDesc;
import java.math.BigDecimal;

/**
 * 窒息事件 DO数据 
 * 
 */
public class SfdaAerEvApn extends BaseDO {
	private static final long serialVersionUID = 1L;

	//窒息事件主键
	public static final String ID_AER_EV_APN= "Id_aer_ev_apn";
	//护理安全事件
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//窒息原因
	public static final String ID_APN_REAS= "Id_apn_reas";
	//窒息原因sd
	public static final String SD_APN_REAS= "Sd_apn_reas";
	//其他窒息原因
	public static final String OTH_APN_REAS= "Oth_apn_reas";
	//窒息表现
	public static final String PERF_APN= "Perf_apn";
	//事件发生经过补充
	public static final String PRO_DES= "Pro_des";
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
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 窒息事件主键
	 * @return String
	 */
	public String getId_aer_ev_apn() {
		return ((String) getAttrVal("Id_aer_ev_apn"));
	}	
	/**
	 * 窒息事件主键
	 * @param Id_aer_ev_apn
	 */
	public void setId_aer_ev_apn(String Id_aer_ev_apn) {
		setAttrVal("Id_aer_ev_apn", Id_aer_ev_apn);
	}
	/**
	 * 护理安全事件
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 护理安全事件
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
	 * 窒息原因
	 * @return String
	 */
	public String getId_apn_reas() {
		return ((String) getAttrVal("Id_apn_reas"));
	}	
	/**
	 * 窒息原因
	 * @param Id_apn_reas
	 */
	public void setId_apn_reas(String Id_apn_reas) {
		setAttrVal("Id_apn_reas", Id_apn_reas);
	}
	/**
	 * 窒息原因sd
	 * @return String
	 */
	public String getSd_apn_reas() {
		return ((String) getAttrVal("Sd_apn_reas"));
	}	
	/**
	 * 窒息原因sd
	 * @param Sd_apn_reas
	 */
	public void setSd_apn_reas(String Sd_apn_reas) {
		setAttrVal("Sd_apn_reas", Sd_apn_reas);
	}
	/**
	 * 其他窒息原因
	 * @return String
	 */
	public String getOth_apn_reas() {
		return ((String) getAttrVal("Oth_apn_reas"));
	}	
	/**
	 * 其他窒息原因
	 * @param Oth_apn_reas
	 */
	public void setOth_apn_reas(String Oth_apn_reas) {
		setAttrVal("Oth_apn_reas", Oth_apn_reas);
	}
	/**
	 * 窒息表现
	 * @return String
	 */
	public String getPerf_apn() {
		return ((String) getAttrVal("Perf_apn"));
	}	
	/**
	 * 窒息表现
	 * @param Perf_apn
	 */
	public void setPerf_apn(String Perf_apn) {
		setAttrVal("Perf_apn", Perf_apn);
	}
	/**
	 * 事件发生经过补充
	 * @return String
	 */
	public String getPro_des() {
		return ((String) getAttrVal("Pro_des"));
	}	
	/**
	 * 事件发生经过补充
	 * @param Pro_des
	 */
	public void setPro_des(String Pro_des) {
		setAttrVal("Pro_des", Pro_des);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_aer_ev_apn";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_APN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvApnDesc.class);
	}
	
}