package iih.sfda.aer.sfdaaerevmselectiv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmselectiv.d.desc.SfdaAerEvMselectivDODesc;
import java.math.BigDecimal;

/**
 * 择期手术后并发事件 DO数据 
 * 
 */
public class SfdaAerEvMselectivDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//择期手术后并发事件主键
	public static final String ID_AER_EV_MSELECTIV= "Id_aer_ev_mselectiv";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//择期手术并发症症状id
	public static final String ID_SELE_OPS= "Id_sele_ops";
	//择期手术并发症症状编码
	public static final String SD_SELE_OPS= "Sd_sele_ops";
	//其他症状
	public static final String OTH_SELE_OPS= "Oth_sele_ops";
	//存在何种可能导致死亡的手术并发症id
	public static final String ID_EXIST_POSS= "Id_exist_poss";
	//存在何种可能导致死亡的手术并发症编码
	public static final String SD_EXIST_POSS= "Sd_exist_poss";
	//其他症状的患者
	public static final String OTH_EXIST_POSS= "Oth_exist_poss";
	//存在手术后伤口裂开id
	public static final String ID_EXIST_FISS= "Id_exist_fiss";
	//存在手术后伤口裂开编码
	public static final String SD_EXIST_FISS= "Sd_exist_fiss";
	//手术后肺栓塞或深静脉血栓id
	public static final String ID_PE_DVT= "Id_pe_dvt";
	//手术后肺栓塞或深静脉血栓编码
	public static final String SD_PE_DVT= "Sd_pe_dvt";
	//手术后出血或血肿id
	public static final String ID_BLEED_HEMA= "Id_bleed_hema";
	//手术后出血或血肿编码
	public static final String SD_BLEED_HEMA= "Sd_bleed_hema";
	//手术后骨折id
	public static final String ID_OPS_CATAGMA= "Id_ops_catagma";
	//手术后骨折编码
	public static final String SD_OPS_CATAGMA= "Sd_ops_catagma";
	//手术后生理或代谢紊乱id
	public static final String ID_PHY_META= "Id_phy_meta";
	//手术后生理或代谢编码
	public static final String SD_PHY_META= "Sd_phy_meta";
	//手术后呼吸衰竭id
	public static final String ID_BREATHE_FAIL= "Id_breathe_fail";
	//手术后呼吸衰竭编码
	public static final String SD_BREATHE_FAIL= "Sd_breathe_fail";
	//手术后败血症id
	public static final String ID_BLOOD_POIS= "Id_blood_pois";
	//手术后败血症编码
	public static final String SD_BLOOD_POIS= "Sd_blood_pois";
	//事发经过描述
	public static final String DES_OCCUR= "Des_occur";
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
	public static final String NAME_SELE_OPS= "Name_sele_ops";
	//名称
	public static final String NAME_EXIST_POSS= "Name_exist_poss";
	//扩展字段1
	public static final String NAME_EXIST_FISS= "Name_exist_fiss";
	//名称
	public static final String NAME_PE_DVT= "Name_pe_dvt";
	//扩展字段1
	public static final String NAME_BLEED_HEMA= "Name_bleed_hema";
	//名称
	public static final String NAME_OPS_CATAGMA= "Name_ops_catagma";
	//扩展字段1
	public static final String NAME_PHY_META= "Name_phy_meta";
	//扩展字段1
	public static final String NAME_BREATHE_FAIL= "Name_breathe_fail";
	//扩展字段1
	public static final String NAME_BLOOD_POIS= "Name_blood_pois";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 择期手术后并发事件主键
	 * @return String
	 */
	public String getId_aer_ev_mselectiv() {
		return ((String) getAttrVal("Id_aer_ev_mselectiv"));
	}	
	/**
	 * 择期手术后并发事件主键
	 * @param Id_aer_ev_mselectiv
	 */
	public void setId_aer_ev_mselectiv(String Id_aer_ev_mselectiv) {
		setAttrVal("Id_aer_ev_mselectiv", Id_aer_ev_mselectiv);
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
	 * 择期手术并发症症状id
	 * @return String
	 */
	public String getId_sele_ops() {
		return ((String) getAttrVal("Id_sele_ops"));
	}	
	/**
	 * 择期手术并发症症状id
	 * @param Id_sele_ops
	 */
	public void setId_sele_ops(String Id_sele_ops) {
		setAttrVal("Id_sele_ops", Id_sele_ops);
	}
	/**
	 * 择期手术并发症症状编码
	 * @return String
	 */
	public String getSd_sele_ops() {
		return ((String) getAttrVal("Sd_sele_ops"));
	}	
	/**
	 * 择期手术并发症症状编码
	 * @param Sd_sele_ops
	 */
	public void setSd_sele_ops(String Sd_sele_ops) {
		setAttrVal("Sd_sele_ops", Sd_sele_ops);
	}
	/**
	 * 其他症状
	 * @return String
	 */
	public String getOth_sele_ops() {
		return ((String) getAttrVal("Oth_sele_ops"));
	}	
	/**
	 * 其他症状
	 * @param Oth_sele_ops
	 */
	public void setOth_sele_ops(String Oth_sele_ops) {
		setAttrVal("Oth_sele_ops", Oth_sele_ops);
	}
	/**
	 * 存在何种可能导致死亡的手术并发症id
	 * @return String
	 */
	public String getId_exist_poss() {
		return ((String) getAttrVal("Id_exist_poss"));
	}	
	/**
	 * 存在何种可能导致死亡的手术并发症id
	 * @param Id_exist_poss
	 */
	public void setId_exist_poss(String Id_exist_poss) {
		setAttrVal("Id_exist_poss", Id_exist_poss);
	}
	/**
	 * 存在何种可能导致死亡的手术并发症编码
	 * @return String
	 */
	public String getSd_exist_poss() {
		return ((String) getAttrVal("Sd_exist_poss"));
	}	
	/**
	 * 存在何种可能导致死亡的手术并发症编码
	 * @param Sd_exist_poss
	 */
	public void setSd_exist_poss(String Sd_exist_poss) {
		setAttrVal("Sd_exist_poss", Sd_exist_poss);
	}
	/**
	 * 其他症状的患者
	 * @return String
	 */
	public String getOth_exist_poss() {
		return ((String) getAttrVal("Oth_exist_poss"));
	}	
	/**
	 * 其他症状的患者
	 * @param Oth_exist_poss
	 */
	public void setOth_exist_poss(String Oth_exist_poss) {
		setAttrVal("Oth_exist_poss", Oth_exist_poss);
	}
	/**
	 * 存在手术后伤口裂开id
	 * @return String
	 */
	public String getId_exist_fiss() {
		return ((String) getAttrVal("Id_exist_fiss"));
	}	
	/**
	 * 存在手术后伤口裂开id
	 * @param Id_exist_fiss
	 */
	public void setId_exist_fiss(String Id_exist_fiss) {
		setAttrVal("Id_exist_fiss", Id_exist_fiss);
	}
	/**
	 * 存在手术后伤口裂开编码
	 * @return String
	 */
	public String getSd_exist_fiss() {
		return ((String) getAttrVal("Sd_exist_fiss"));
	}	
	/**
	 * 存在手术后伤口裂开编码
	 * @param Sd_exist_fiss
	 */
	public void setSd_exist_fiss(String Sd_exist_fiss) {
		setAttrVal("Sd_exist_fiss", Sd_exist_fiss);
	}
	/**
	 * 手术后肺栓塞或深静脉血栓id
	 * @return String
	 */
	public String getId_pe_dvt() {
		return ((String) getAttrVal("Id_pe_dvt"));
	}	
	/**
	 * 手术后肺栓塞或深静脉血栓id
	 * @param Id_pe_dvt
	 */
	public void setId_pe_dvt(String Id_pe_dvt) {
		setAttrVal("Id_pe_dvt", Id_pe_dvt);
	}
	/**
	 * 手术后肺栓塞或深静脉血栓编码
	 * @return String
	 */
	public String getSd_pe_dvt() {
		return ((String) getAttrVal("Sd_pe_dvt"));
	}	
	/**
	 * 手术后肺栓塞或深静脉血栓编码
	 * @param Sd_pe_dvt
	 */
	public void setSd_pe_dvt(String Sd_pe_dvt) {
		setAttrVal("Sd_pe_dvt", Sd_pe_dvt);
	}
	/**
	 * 手术后出血或血肿id
	 * @return String
	 */
	public String getId_bleed_hema() {
		return ((String) getAttrVal("Id_bleed_hema"));
	}	
	/**
	 * 手术后出血或血肿id
	 * @param Id_bleed_hema
	 */
	public void setId_bleed_hema(String Id_bleed_hema) {
		setAttrVal("Id_bleed_hema", Id_bleed_hema);
	}
	/**
	 * 手术后出血或血肿编码
	 * @return String
	 */
	public String getSd_bleed_hema() {
		return ((String) getAttrVal("Sd_bleed_hema"));
	}	
	/**
	 * 手术后出血或血肿编码
	 * @param Sd_bleed_hema
	 */
	public void setSd_bleed_hema(String Sd_bleed_hema) {
		setAttrVal("Sd_bleed_hema", Sd_bleed_hema);
	}
	/**
	 * 手术后骨折id
	 * @return String
	 */
	public String getId_ops_catagma() {
		return ((String) getAttrVal("Id_ops_catagma"));
	}	
	/**
	 * 手术后骨折id
	 * @param Id_ops_catagma
	 */
	public void setId_ops_catagma(String Id_ops_catagma) {
		setAttrVal("Id_ops_catagma", Id_ops_catagma);
	}
	/**
	 * 手术后骨折编码
	 * @return String
	 */
	public String getSd_ops_catagma() {
		return ((String) getAttrVal("Sd_ops_catagma"));
	}	
	/**
	 * 手术后骨折编码
	 * @param Sd_ops_catagma
	 */
	public void setSd_ops_catagma(String Sd_ops_catagma) {
		setAttrVal("Sd_ops_catagma", Sd_ops_catagma);
	}
	/**
	 * 手术后生理或代谢紊乱id
	 * @return String
	 */
	public String getId_phy_meta() {
		return ((String) getAttrVal("Id_phy_meta"));
	}	
	/**
	 * 手术后生理或代谢紊乱id
	 * @param Id_phy_meta
	 */
	public void setId_phy_meta(String Id_phy_meta) {
		setAttrVal("Id_phy_meta", Id_phy_meta);
	}
	/**
	 * 手术后生理或代谢编码
	 * @return String
	 */
	public String getSd_phy_meta() {
		return ((String) getAttrVal("Sd_phy_meta"));
	}	
	/**
	 * 手术后生理或代谢编码
	 * @param Sd_phy_meta
	 */
	public void setSd_phy_meta(String Sd_phy_meta) {
		setAttrVal("Sd_phy_meta", Sd_phy_meta);
	}
	/**
	 * 手术后呼吸衰竭id
	 * @return String
	 */
	public String getId_breathe_fail() {
		return ((String) getAttrVal("Id_breathe_fail"));
	}	
	/**
	 * 手术后呼吸衰竭id
	 * @param Id_breathe_fail
	 */
	public void setId_breathe_fail(String Id_breathe_fail) {
		setAttrVal("Id_breathe_fail", Id_breathe_fail);
	}
	/**
	 * 手术后呼吸衰竭编码
	 * @return String
	 */
	public String getSd_breathe_fail() {
		return ((String) getAttrVal("Sd_breathe_fail"));
	}	
	/**
	 * 手术后呼吸衰竭编码
	 * @param Sd_breathe_fail
	 */
	public void setSd_breathe_fail(String Sd_breathe_fail) {
		setAttrVal("Sd_breathe_fail", Sd_breathe_fail);
	}
	/**
	 * 手术后败血症id
	 * @return String
	 */
	public String getId_blood_pois() {
		return ((String) getAttrVal("Id_blood_pois"));
	}	
	/**
	 * 手术后败血症id
	 * @param Id_blood_pois
	 */
	public void setId_blood_pois(String Id_blood_pois) {
		setAttrVal("Id_blood_pois", Id_blood_pois);
	}
	/**
	 * 手术后败血症编码
	 * @return String
	 */
	public String getSd_blood_pois() {
		return ((String) getAttrVal("Sd_blood_pois"));
	}	
	/**
	 * 手术后败血症编码
	 * @param Sd_blood_pois
	 */
	public void setSd_blood_pois(String Sd_blood_pois) {
		setAttrVal("Sd_blood_pois", Sd_blood_pois);
	}
	/**
	 * 事发经过描述
	 * @return String
	 */
	public String getDes_occur() {
		return ((String) getAttrVal("Des_occur"));
	}	
	/**
	 * 事发经过描述
	 * @param Des_occur
	 */
	public void setDes_occur(String Des_occur) {
		setAttrVal("Des_occur", Des_occur);
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
	public String getName_sele_ops() {
		return ((String) getAttrVal("Name_sele_ops"));
	}	
	/**
	 * 名称
	 * @param Name_sele_ops
	 */
	public void setName_sele_ops(String Name_sele_ops) {
		setAttrVal("Name_sele_ops", Name_sele_ops);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_exist_poss() {
		return ((String) getAttrVal("Name_exist_poss"));
	}	
	/**
	 * 名称
	 * @param Name_exist_poss
	 */
	public void setName_exist_poss(String Name_exist_poss) {
		setAttrVal("Name_exist_poss", Name_exist_poss);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_exist_fiss() {
		return ((String) getAttrVal("Name_exist_fiss"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_exist_fiss
	 */
	public void setName_exist_fiss(String Name_exist_fiss) {
		setAttrVal("Name_exist_fiss", Name_exist_fiss);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pe_dvt() {
		return ((String) getAttrVal("Name_pe_dvt"));
	}	
	/**
	 * 名称
	 * @param Name_pe_dvt
	 */
	public void setName_pe_dvt(String Name_pe_dvt) {
		setAttrVal("Name_pe_dvt", Name_pe_dvt);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_bleed_hema() {
		return ((String) getAttrVal("Name_bleed_hema"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_bleed_hema
	 */
	public void setName_bleed_hema(String Name_bleed_hema) {
		setAttrVal("Name_bleed_hema", Name_bleed_hema);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ops_catagma() {
		return ((String) getAttrVal("Name_ops_catagma"));
	}	
	/**
	 * 名称
	 * @param Name_ops_catagma
	 */
	public void setName_ops_catagma(String Name_ops_catagma) {
		setAttrVal("Name_ops_catagma", Name_ops_catagma);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_phy_meta() {
		return ((String) getAttrVal("Name_phy_meta"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_phy_meta
	 */
	public void setName_phy_meta(String Name_phy_meta) {
		setAttrVal("Name_phy_meta", Name_phy_meta);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_breathe_fail() {
		return ((String) getAttrVal("Name_breathe_fail"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_breathe_fail
	 */
	public void setName_breathe_fail(String Name_breathe_fail) {
		setAttrVal("Name_breathe_fail", Name_breathe_fail);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_blood_pois() {
		return ((String) getAttrVal("Name_blood_pois"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_blood_pois
	 */
	public void setName_blood_pois(String Name_blood_pois) {
		setAttrVal("Name_blood_pois", Name_blood_pois);
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
		return "Id_aer_ev_mselectiv";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MSELECTIV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMselectivDODesc.class);
	}
	
}