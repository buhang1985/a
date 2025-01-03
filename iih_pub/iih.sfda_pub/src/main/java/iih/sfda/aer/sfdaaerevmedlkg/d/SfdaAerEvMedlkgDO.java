package iih.sfda.aer.sfdaaerevmedlkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmedlkg.d.desc.SfdaAerEvMedlkgDODesc;
import java.math.BigDecimal;

/**
 * 输液药物渗漏事件 DO数据 
 * 
 */
public class SfdaAerEvMedlkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//输液药物渗漏事件主键
	public static final String ID_AER_EV_MEDLKG= "Id_aer_ev_medlkg";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//事件概要说明
	public static final String EV_SMY_DES= "Ev_smy_des";
	//静脉导管类型id
	public static final String ID_DTSARTTP= "Id_dtsarttp";
	//静脉导管类型
	public static final String SD_DTSARTTP= "Sd_dtsarttp";
	//渗漏性损伤原因id
	public static final String ID_MEDLKG_RESAS= "Id_medlkg_resas";
	//渗漏性损伤原因
	public static final String SD_MEDLKG_RESAS= "Sd_medlkg_resas";
	//损伤原因补充
	public static final String OTH_MEDLKG_REAS= "Oth_medlkg_reas";
	//渗漏部位id
	public static final String ID_LKG_PTY= "Id_lkg_pty";
	//渗漏部位
	public static final String SD_LKG_PTY= "Sd_lkg_pty";
	//其他渗漏部位
	public static final String OTH_LKG_PTY= "Oth_lkg_pty";
	//外渗药物种类
	public static final String ID_MEDLKG_KIND= "Id_medlkg_kind";
	//外渗药物种类编码
	public static final String SD_MEDLKG_KIND= "Sd_medlkg_kind";
	//其他外渗药物种类
	public static final String OTH_MEDLKG_KIND= "Oth_medlkg_kind";
	//药物渗出的级别id
	public static final String ID_MEDLKG_LVL= "Id_medlkg_lvl";
	//药物渗出的级别
	public static final String SD_MEDLKG_LVL= "Sd_medlkg_lvl";
	//处理方法id
	public static final String ID_HDLE_MTH= "Id_hdle_mth";
	//处理方法
	public static final String SD_HDLE_MTH= "Sd_hdle_mth";
	//其他处理方法
	public static final String OTH_HDLE_MTH= "Oth_hdle_mth";
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
	//其他静脉导管类型
	public static final String OTH_DTSARTTP= "Oth_dtsarttp";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//静脉导管类型
	public static final String NAME_DTSARTTP= "Name_dtsarttp";
	//渗漏性损伤原因
	public static final String NAME_MEDLKG_RESAS= "Name_medlkg_resas";
	//渗漏部位
	public static final String NAME_LKG_PTY= "Name_lkg_pty";
	//名称
	public static final String NAME_MEDLKG_KIND= "Name_medlkg_kind";
	//扩展字段1
	public static final String CTRL1_MEDLKG_LVL= "Ctrl1_medlkg_lvl";
	//处理方法
	public static final String NAME_HDLE_MTH= "Name_hdle_mth";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 输液药物渗漏事件主键
	 * @return String
	 */
	public String getId_aer_ev_medlkg() {
		return ((String) getAttrVal("Id_aer_ev_medlkg"));
	}	
	/**
	 * 输液药物渗漏事件主键
	 * @param Id_aer_ev_medlkg
	 */
	public void setId_aer_ev_medlkg(String Id_aer_ev_medlkg) {
		setAttrVal("Id_aer_ev_medlkg", Id_aer_ev_medlkg);
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
	 * 事件概要说明
	 * @return String
	 */
	public String getEv_smy_des() {
		return ((String) getAttrVal("Ev_smy_des"));
	}	
	/**
	 * 事件概要说明
	 * @param Ev_smy_des
	 */
	public void setEv_smy_des(String Ev_smy_des) {
		setAttrVal("Ev_smy_des", Ev_smy_des);
	}
	/**
	 * 静脉导管类型id
	 * @return String
	 */
	public String getId_dtsarttp() {
		return ((String) getAttrVal("Id_dtsarttp"));
	}	
	/**
	 * 静脉导管类型id
	 * @param Id_dtsarttp
	 */
	public void setId_dtsarttp(String Id_dtsarttp) {
		setAttrVal("Id_dtsarttp", Id_dtsarttp);
	}
	/**
	 * 静脉导管类型
	 * @return String
	 */
	public String getSd_dtsarttp() {
		return ((String) getAttrVal("Sd_dtsarttp"));
	}	
	/**
	 * 静脉导管类型
	 * @param Sd_dtsarttp
	 */
	public void setSd_dtsarttp(String Sd_dtsarttp) {
		setAttrVal("Sd_dtsarttp", Sd_dtsarttp);
	}
	/**
	 * 渗漏性损伤原因id
	 * @return String
	 */
	public String getId_medlkg_resas() {
		return ((String) getAttrVal("Id_medlkg_resas"));
	}	
	/**
	 * 渗漏性损伤原因id
	 * @param Id_medlkg_resas
	 */
	public void setId_medlkg_resas(String Id_medlkg_resas) {
		setAttrVal("Id_medlkg_resas", Id_medlkg_resas);
	}
	/**
	 * 渗漏性损伤原因
	 * @return String
	 */
	public String getSd_medlkg_resas() {
		return ((String) getAttrVal("Sd_medlkg_resas"));
	}	
	/**
	 * 渗漏性损伤原因
	 * @param Sd_medlkg_resas
	 */
	public void setSd_medlkg_resas(String Sd_medlkg_resas) {
		setAttrVal("Sd_medlkg_resas", Sd_medlkg_resas);
	}
	/**
	 * 损伤原因补充
	 * @return String
	 */
	public String getOth_medlkg_reas() {
		return ((String) getAttrVal("Oth_medlkg_reas"));
	}	
	/**
	 * 损伤原因补充
	 * @param Oth_medlkg_reas
	 */
	public void setOth_medlkg_reas(String Oth_medlkg_reas) {
		setAttrVal("Oth_medlkg_reas", Oth_medlkg_reas);
	}
	/**
	 * 渗漏部位id
	 * @return String
	 */
	public String getId_lkg_pty() {
		return ((String) getAttrVal("Id_lkg_pty"));
	}	
	/**
	 * 渗漏部位id
	 * @param Id_lkg_pty
	 */
	public void setId_lkg_pty(String Id_lkg_pty) {
		setAttrVal("Id_lkg_pty", Id_lkg_pty);
	}
	/**
	 * 渗漏部位
	 * @return String
	 */
	public String getSd_lkg_pty() {
		return ((String) getAttrVal("Sd_lkg_pty"));
	}	
	/**
	 * 渗漏部位
	 * @param Sd_lkg_pty
	 */
	public void setSd_lkg_pty(String Sd_lkg_pty) {
		setAttrVal("Sd_lkg_pty", Sd_lkg_pty);
	}
	/**
	 * 其他渗漏部位
	 * @return String
	 */
	public String getOth_lkg_pty() {
		return ((String) getAttrVal("Oth_lkg_pty"));
	}	
	/**
	 * 其他渗漏部位
	 * @param Oth_lkg_pty
	 */
	public void setOth_lkg_pty(String Oth_lkg_pty) {
		setAttrVal("Oth_lkg_pty", Oth_lkg_pty);
	}
	/**
	 * 外渗药物种类
	 * @return String
	 */
	public String getId_medlkg_kind() {
		return ((String) getAttrVal("Id_medlkg_kind"));
	}	
	/**
	 * 外渗药物种类
	 * @param Id_medlkg_kind
	 */
	public void setId_medlkg_kind(String Id_medlkg_kind) {
		setAttrVal("Id_medlkg_kind", Id_medlkg_kind);
	}
	/**
	 * 外渗药物种类编码
	 * @return String
	 */
	public String getSd_medlkg_kind() {
		return ((String) getAttrVal("Sd_medlkg_kind"));
	}	
	/**
	 * 外渗药物种类编码
	 * @param Sd_medlkg_kind
	 */
	public void setSd_medlkg_kind(String Sd_medlkg_kind) {
		setAttrVal("Sd_medlkg_kind", Sd_medlkg_kind);
	}
	/**
	 * 其他外渗药物种类
	 * @return String
	 */
	public String getOth_medlkg_kind() {
		return ((String) getAttrVal("Oth_medlkg_kind"));
	}	
	/**
	 * 其他外渗药物种类
	 * @param Oth_medlkg_kind
	 */
	public void setOth_medlkg_kind(String Oth_medlkg_kind) {
		setAttrVal("Oth_medlkg_kind", Oth_medlkg_kind);
	}
	/**
	 * 药物渗出的级别id
	 * @return String
	 */
	public String getId_medlkg_lvl() {
		return ((String) getAttrVal("Id_medlkg_lvl"));
	}	
	/**
	 * 药物渗出的级别id
	 * @param Id_medlkg_lvl
	 */
	public void setId_medlkg_lvl(String Id_medlkg_lvl) {
		setAttrVal("Id_medlkg_lvl", Id_medlkg_lvl);
	}
	/**
	 * 药物渗出的级别
	 * @return String
	 */
	public String getSd_medlkg_lvl() {
		return ((String) getAttrVal("Sd_medlkg_lvl"));
	}	
	/**
	 * 药物渗出的级别
	 * @param Sd_medlkg_lvl
	 */
	public void setSd_medlkg_lvl(String Sd_medlkg_lvl) {
		setAttrVal("Sd_medlkg_lvl", Sd_medlkg_lvl);
	}
	/**
	 * 处理方法id
	 * @return String
	 */
	public String getId_hdle_mth() {
		return ((String) getAttrVal("Id_hdle_mth"));
	}	
	/**
	 * 处理方法id
	 * @param Id_hdle_mth
	 */
	public void setId_hdle_mth(String Id_hdle_mth) {
		setAttrVal("Id_hdle_mth", Id_hdle_mth);
	}
	/**
	 * 处理方法
	 * @return String
	 */
	public String getSd_hdle_mth() {
		return ((String) getAttrVal("Sd_hdle_mth"));
	}	
	/**
	 * 处理方法
	 * @param Sd_hdle_mth
	 */
	public void setSd_hdle_mth(String Sd_hdle_mth) {
		setAttrVal("Sd_hdle_mth", Sd_hdle_mth);
	}
	/**
	 * 其他处理方法
	 * @return String
	 */
	public String getOth_hdle_mth() {
		return ((String) getAttrVal("Oth_hdle_mth"));
	}	
	/**
	 * 其他处理方法
	 * @param Oth_hdle_mth
	 */
	public void setOth_hdle_mth(String Oth_hdle_mth) {
		setAttrVal("Oth_hdle_mth", Oth_hdle_mth);
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
	 * 其他静脉导管类型
	 * @return String
	 */
	public String getOth_dtsarttp() {
		return ((String) getAttrVal("Oth_dtsarttp"));
	}	
	/**
	 * 其他静脉导管类型
	 * @param Oth_dtsarttp
	 */
	public void setOth_dtsarttp(String Oth_dtsarttp) {
		setAttrVal("Oth_dtsarttp", Oth_dtsarttp);
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
	 * 静脉导管类型
	 * @return String
	 */
	public String getName_dtsarttp() {
		return ((String) getAttrVal("Name_dtsarttp"));
	}	
	/**
	 * 静脉导管类型
	 * @param Name_dtsarttp
	 */
	public void setName_dtsarttp(String Name_dtsarttp) {
		setAttrVal("Name_dtsarttp", Name_dtsarttp);
	}
	/**
	 * 渗漏性损伤原因
	 * @return String
	 */
	public String getName_medlkg_resas() {
		return ((String) getAttrVal("Name_medlkg_resas"));
	}	
	/**
	 * 渗漏性损伤原因
	 * @param Name_medlkg_resas
	 */
	public void setName_medlkg_resas(String Name_medlkg_resas) {
		setAttrVal("Name_medlkg_resas", Name_medlkg_resas);
	}
	/**
	 * 渗漏部位
	 * @return String
	 */
	public String getName_lkg_pty() {
		return ((String) getAttrVal("Name_lkg_pty"));
	}	
	/**
	 * 渗漏部位
	 * @param Name_lkg_pty
	 */
	public void setName_lkg_pty(String Name_lkg_pty) {
		setAttrVal("Name_lkg_pty", Name_lkg_pty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_medlkg_kind() {
		return ((String) getAttrVal("Name_medlkg_kind"));
	}	
	/**
	 * 名称
	 * @param Name_medlkg_kind
	 */
	public void setName_medlkg_kind(String Name_medlkg_kind) {
		setAttrVal("Name_medlkg_kind", Name_medlkg_kind);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1_medlkg_lvl() {
		return ((String) getAttrVal("Ctrl1_medlkg_lvl"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1_medlkg_lvl
	 */
	public void setCtrl1_medlkg_lvl(String Ctrl1_medlkg_lvl) {
		setAttrVal("Ctrl1_medlkg_lvl", Ctrl1_medlkg_lvl);
	}
	/**
	 * 处理方法
	 * @return String
	 */
	public String getName_hdle_mth() {
		return ((String) getAttrVal("Name_hdle_mth"));
	}	
	/**
	 * 处理方法
	 * @param Name_hdle_mth
	 */
	public void setName_hdle_mth(String Name_hdle_mth) {
		setAttrVal("Name_hdle_mth", Name_hdle_mth);
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
		return "Id_aer_ev_medlkg";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MEDLKG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMedlkgDODesc.class);
	}
	
}