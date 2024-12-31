package iih.sfda.aer.sfdaaerevmbreath.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmbreath.d.desc.SfdaAerEvMbreathDODesc;
import java.math.BigDecimal;

/**
 * 呼吸机事件 DO数据 
 * 
 */
public class SfdaAerEvMbreathDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//呼吸机事件主键
	public static final String ID_AER_EV_MBREATH= "Id_aer_ev_mbreath";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//呼吸机事件分类id
	public static final String ID_EV_CLASSIFY= "Id_ev_classify";
	//呼吸机事件分类编码
	public static final String SD_EV_CLASSIFY= "Sd_ev_classify";
	//呼吸机事件其他分类
	public static final String OTH_EV_CLASSIFY= "Oth_ev_classify";
	//插管套管不良事件id
	public static final String ID_SPILE_PIPE= "Id_spile_pipe";
	//插管套管不良事件编码
	public static final String SD_SPILE_PIPE= "Sd_spile_pipe";
	//机械通气治疗过程中引起的不良事件id
	public static final String ID_MAC_AERATE= "Id_mac_aerate";
	//机械通气治疗过程中引起的不良事件编码
	public static final String SD_MAC_AERATE= "Sd_mac_aerate";
	//呼吸机障碍所致的不良事件id
	public static final String ID_EV_BARRIER= "Id_ev_barrier";
	//呼吸机障碍所致的不良事件编码
	public static final String SD_EV_BARRIER= "Sd_ev_barrier";
	//患者开始使用呼吸机日期
	public static final String STA_TIME= "Sta_time";
	//适应症id
	public static final String ID_ADAPT= "Id_adapt";
	//适应症编码
	public static final String SD_ADAPT= "Sd_adapt";
	//其他情况
	public static final String OTH_ADAPT= "Oth_adapt";
	//是否入住ICU
	public static final String EV_CHECK_ICU= "Ev_check_icu";
	//是否进行手术
	public static final String EV_MARCH_OPS= "Ev_march_ops";
	//手术名称
	public static final String OPS_NAME= "Ops_name";
	//手术时间
	public static final String OPS_TIME= "Ops_time";
	//请叙述事件经过
	public static final String AFF_DESCRIBE= "Aff_describe";
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
	public static final String NAME_EV_CLASSIFY= "Name_ev_classify";
	//名称
	public static final String NAME_SPILE_PIPE= "Name_spile_pipe";
	//名称
	public static final String NAME_MAC_AERATE= "Name_mac_aerate";
	//名称
	public static final String NAME_EV_BARRIER= "Name_ev_barrier";
	//扩展字段1
	public static final String NAME_ADAPT= "Name_adapt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 呼吸机事件主键
	 * @return String
	 */
	public String getId_aer_ev_mbreath() {
		return ((String) getAttrVal("Id_aer_ev_mbreath"));
	}	
	/**
	 * 呼吸机事件主键
	 * @param Id_aer_ev_mbreath
	 */
	public void setId_aer_ev_mbreath(String Id_aer_ev_mbreath) {
		setAttrVal("Id_aer_ev_mbreath", Id_aer_ev_mbreath);
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
	 * 呼吸机事件分类id
	 * @return String
	 */
	public String getId_ev_classify() {
		return ((String) getAttrVal("Id_ev_classify"));
	}	
	/**
	 * 呼吸机事件分类id
	 * @param Id_ev_classify
	 */
	public void setId_ev_classify(String Id_ev_classify) {
		setAttrVal("Id_ev_classify", Id_ev_classify);
	}
	/**
	 * 呼吸机事件分类编码
	 * @return String
	 */
	public String getSd_ev_classify() {
		return ((String) getAttrVal("Sd_ev_classify"));
	}	
	/**
	 * 呼吸机事件分类编码
	 * @param Sd_ev_classify
	 */
	public void setSd_ev_classify(String Sd_ev_classify) {
		setAttrVal("Sd_ev_classify", Sd_ev_classify);
	}
	/**
	 * 呼吸机事件其他分类
	 * @return String
	 */
	public String getOth_ev_classify() {
		return ((String) getAttrVal("Oth_ev_classify"));
	}	
	/**
	 * 呼吸机事件其他分类
	 * @param Oth_ev_classify
	 */
	public void setOth_ev_classify(String Oth_ev_classify) {
		setAttrVal("Oth_ev_classify", Oth_ev_classify);
	}
	/**
	 * 插管套管不良事件id
	 * @return String
	 */
	public String getId_spile_pipe() {
		return ((String) getAttrVal("Id_spile_pipe"));
	}	
	/**
	 * 插管套管不良事件id
	 * @param Id_spile_pipe
	 */
	public void setId_spile_pipe(String Id_spile_pipe) {
		setAttrVal("Id_spile_pipe", Id_spile_pipe);
	}
	/**
	 * 插管套管不良事件编码
	 * @return String
	 */
	public String getSd_spile_pipe() {
		return ((String) getAttrVal("Sd_spile_pipe"));
	}	
	/**
	 * 插管套管不良事件编码
	 * @param Sd_spile_pipe
	 */
	public void setSd_spile_pipe(String Sd_spile_pipe) {
		setAttrVal("Sd_spile_pipe", Sd_spile_pipe);
	}
	/**
	 * 机械通气治疗过程中引起的不良事件id
	 * @return String
	 */
	public String getId_mac_aerate() {
		return ((String) getAttrVal("Id_mac_aerate"));
	}	
	/**
	 * 机械通气治疗过程中引起的不良事件id
	 * @param Id_mac_aerate
	 */
	public void setId_mac_aerate(String Id_mac_aerate) {
		setAttrVal("Id_mac_aerate", Id_mac_aerate);
	}
	/**
	 * 机械通气治疗过程中引起的不良事件编码
	 * @return String
	 */
	public String getSd_mac_aerate() {
		return ((String) getAttrVal("Sd_mac_aerate"));
	}	
	/**
	 * 机械通气治疗过程中引起的不良事件编码
	 * @param Sd_mac_aerate
	 */
	public void setSd_mac_aerate(String Sd_mac_aerate) {
		setAttrVal("Sd_mac_aerate", Sd_mac_aerate);
	}
	/**
	 * 呼吸机障碍所致的不良事件id
	 * @return String
	 */
	public String getId_ev_barrier() {
		return ((String) getAttrVal("Id_ev_barrier"));
	}	
	/**
	 * 呼吸机障碍所致的不良事件id
	 * @param Id_ev_barrier
	 */
	public void setId_ev_barrier(String Id_ev_barrier) {
		setAttrVal("Id_ev_barrier", Id_ev_barrier);
	}
	/**
	 * 呼吸机障碍所致的不良事件编码
	 * @return String
	 */
	public String getSd_ev_barrier() {
		return ((String) getAttrVal("Sd_ev_barrier"));
	}	
	/**
	 * 呼吸机障碍所致的不良事件编码
	 * @param Sd_ev_barrier
	 */
	public void setSd_ev_barrier(String Sd_ev_barrier) {
		setAttrVal("Sd_ev_barrier", Sd_ev_barrier);
	}
	/**
	 * 患者开始使用呼吸机日期
	 * @return FDateTime
	 */
	public FDateTime getSta_time() {
		return ((FDateTime) getAttrVal("Sta_time"));
	}	
	/**
	 * 患者开始使用呼吸机日期
	 * @param Sta_time
	 */
	public void setSta_time(FDateTime Sta_time) {
		setAttrVal("Sta_time", Sta_time);
	}
	/**
	 * 适应症id
	 * @return String
	 */
	public String getId_adapt() {
		return ((String) getAttrVal("Id_adapt"));
	}	
	/**
	 * 适应症id
	 * @param Id_adapt
	 */
	public void setId_adapt(String Id_adapt) {
		setAttrVal("Id_adapt", Id_adapt);
	}
	/**
	 * 适应症编码
	 * @return String
	 */
	public String getSd_adapt() {
		return ((String) getAttrVal("Sd_adapt"));
	}	
	/**
	 * 适应症编码
	 * @param Sd_adapt
	 */
	public void setSd_adapt(String Sd_adapt) {
		setAttrVal("Sd_adapt", Sd_adapt);
	}
	/**
	 * 其他情况
	 * @return String
	 */
	public String getOth_adapt() {
		return ((String) getAttrVal("Oth_adapt"));
	}	
	/**
	 * 其他情况
	 * @param Oth_adapt
	 */
	public void setOth_adapt(String Oth_adapt) {
		setAttrVal("Oth_adapt", Oth_adapt);
	}
	/**
	 * 是否入住ICU
	 * @return Integer
	 */
	public Integer getEv_check_icu() {
		return ((Integer) getAttrVal("Ev_check_icu"));
	}	
	/**
	 * 是否入住ICU
	 * @param Ev_check_icu
	 */
	public void setEv_check_icu(Integer Ev_check_icu) {
		setAttrVal("Ev_check_icu", Ev_check_icu);
	}
	/**
	 * 是否进行手术
	 * @return Integer
	 */
	public Integer getEv_march_ops() {
		return ((Integer) getAttrVal("Ev_march_ops"));
	}	
	/**
	 * 是否进行手术
	 * @param Ev_march_ops
	 */
	public void setEv_march_ops(Integer Ev_march_ops) {
		setAttrVal("Ev_march_ops", Ev_march_ops);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getOps_name() {
		return ((String) getAttrVal("Ops_name"));
	}	
	/**
	 * 手术名称
	 * @param Ops_name
	 */
	public void setOps_name(String Ops_name) {
		setAttrVal("Ops_name", Ops_name);
	}
	/**
	 * 手术时间
	 * @return String
	 */
	public String getOps_time() {
		return ((String) getAttrVal("Ops_time"));
	}	
	/**
	 * 手术时间
	 * @param Ops_time
	 */
	public void setOps_time(String Ops_time) {
		setAttrVal("Ops_time", Ops_time);
	}
	/**
	 * 请叙述事件经过
	 * @return String
	 */
	public String getAff_describe() {
		return ((String) getAttrVal("Aff_describe"));
	}	
	/**
	 * 请叙述事件经过
	 * @param Aff_describe
	 */
	public void setAff_describe(String Aff_describe) {
		setAttrVal("Aff_describe", Aff_describe);
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
	public String getName_ev_classify() {
		return ((String) getAttrVal("Name_ev_classify"));
	}	
	/**
	 * 名称
	 * @param Name_ev_classify
	 */
	public void setName_ev_classify(String Name_ev_classify) {
		setAttrVal("Name_ev_classify", Name_ev_classify);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_spile_pipe() {
		return ((String) getAttrVal("Name_spile_pipe"));
	}	
	/**
	 * 名称
	 * @param Name_spile_pipe
	 */
	public void setName_spile_pipe(String Name_spile_pipe) {
		setAttrVal("Name_spile_pipe", Name_spile_pipe);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mac_aerate() {
		return ((String) getAttrVal("Name_mac_aerate"));
	}	
	/**
	 * 名称
	 * @param Name_mac_aerate
	 */
	public void setName_mac_aerate(String Name_mac_aerate) {
		setAttrVal("Name_mac_aerate", Name_mac_aerate);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ev_barrier() {
		return ((String) getAttrVal("Name_ev_barrier"));
	}	
	/**
	 * 名称
	 * @param Name_ev_barrier
	 */
	public void setName_ev_barrier(String Name_ev_barrier) {
		setAttrVal("Name_ev_barrier", Name_ev_barrier);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_adapt() {
		return ((String) getAttrVal("Name_adapt"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_adapt
	 */
	public void setName_adapt(String Name_adapt) {
		setAttrVal("Name_adapt", Name_adapt);
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
		return "Id_aer_ev_mbreath";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MBREATH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMbreathDODesc.class);
	}
	
}