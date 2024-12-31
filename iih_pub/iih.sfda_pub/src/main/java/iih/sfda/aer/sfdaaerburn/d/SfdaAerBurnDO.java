package iih.sfda.aer.sfdaaerburn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerburn.d.desc.SfdaAerBurnDODesc;
import java.math.BigDecimal;

/**
 * 烧烫伤事件 DO数据 
 * 
 */
public class SfdaAerBurnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//烧伤事件主键
	public static final String ID_AER_EV_BURN= "Id_aer_ev_burn";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//烧伤部位id
	public static final String ID_BURN_PART= "Id_burn_part";
	//烧伤部位
	public static final String SD_BURN_PARTV= "Sd_burn_partv";
	//其他烧伤部位
	public static final String OTH_BURN_PARTV= "Oth_burn_partv";
	//烧伤面积
	public static final String AREA_BURN= "Area_burn";
	//发生烧烫伤后的急救处理id
	public static final String ID_BURN_HDLE= "Id_burn_hdle";
	//发生烧烫伤后的急救处理编码
	public static final String SD_BURN_HDLE= "Sd_burn_hdle";
	//致伤原因id
	public static final String ID_BURN_CAUSES= "Id_burn_causes";
	//致伤原因
	public static final String SD_BURN_CAUSES= "Sd_burn_causes";
	//其他致伤原因
	public static final String OTH_BURN_CAUSES= "Oth_burn_causes";
	//其他发生烧烫伤后的急救处理
	public static final String OTH_BURN_HDLE= "Oth_burn_hdle";
	//烧伤严重程度分类id
	public static final String ID_BURN_WSRCA= "Id_burn_wsrca";
	//烧伤严重程度分类编码
	public static final String SD_BURN_WSRCA= "Sd_burn_wsrca";
	//发生于何种活动id
	public static final String ID_OCUR_ATIVY= "Id_ocur_ativy";
	//发生于何种活动编码
	public static final String SD_OCUR_ATIVY= "Sd_ocur_ativy";
	//其他发生于何种活动
	public static final String OTH_OCUR_ATIVY= "Oth_ocur_ativy";
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
	//烧伤部位
	public static final String NAME_BURN_PART= "Name_burn_part";
	//发生烧伤后的急救处理
	public static final String NAME_BURN_HDLE= "Name_burn_hdle";
	//名称
	public static final String NAME_BURN_CAUSES= "Name_burn_causes";
	//名称
	public static final String NAME_BURN_WSRCA= "Name_burn_wsrca";
	//名称
	public static final String NAME_OCUR_ATIVY= "Name_ocur_ativy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 烧伤事件主键
	 * @return String
	 */
	public String getId_aer_ev_burn() {
		return ((String) getAttrVal("Id_aer_ev_burn"));
	}	
	/**
	 * 烧伤事件主键
	 * @param Id_aer_ev_burn
	 */
	public void setId_aer_ev_burn(String Id_aer_ev_burn) {
		setAttrVal("Id_aer_ev_burn", Id_aer_ev_burn);
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
	 * 烧伤部位id
	 * @return String
	 */
	public String getId_burn_part() {
		return ((String) getAttrVal("Id_burn_part"));
	}	
	/**
	 * 烧伤部位id
	 * @param Id_burn_part
	 */
	public void setId_burn_part(String Id_burn_part) {
		setAttrVal("Id_burn_part", Id_burn_part);
	}
	/**
	 * 烧伤部位
	 * @return String
	 */
	public String getSd_burn_partv() {
		return ((String) getAttrVal("Sd_burn_partv"));
	}	
	/**
	 * 烧伤部位
	 * @param Sd_burn_partv
	 */
	public void setSd_burn_partv(String Sd_burn_partv) {
		setAttrVal("Sd_burn_partv", Sd_burn_partv);
	}
	/**
	 * 其他烧伤部位
	 * @return String
	 */
	public String getOth_burn_partv() {
		return ((String) getAttrVal("Oth_burn_partv"));
	}	
	/**
	 * 其他烧伤部位
	 * @param Oth_burn_partv
	 */
	public void setOth_burn_partv(String Oth_burn_partv) {
		setAttrVal("Oth_burn_partv", Oth_burn_partv);
	}
	/**
	 * 烧伤面积
	 * @return String
	 */
	public String getArea_burn() {
		return ((String) getAttrVal("Area_burn"));
	}	
	/**
	 * 烧伤面积
	 * @param Area_burn
	 */
	public void setArea_burn(String Area_burn) {
		setAttrVal("Area_burn", Area_burn);
	}
	/**
	 * 发生烧烫伤后的急救处理id
	 * @return String
	 */
	public String getId_burn_hdle() {
		return ((String) getAttrVal("Id_burn_hdle"));
	}	
	/**
	 * 发生烧烫伤后的急救处理id
	 * @param Id_burn_hdle
	 */
	public void setId_burn_hdle(String Id_burn_hdle) {
		setAttrVal("Id_burn_hdle", Id_burn_hdle);
	}
	/**
	 * 发生烧烫伤后的急救处理编码
	 * @return String
	 */
	public String getSd_burn_hdle() {
		return ((String) getAttrVal("Sd_burn_hdle"));
	}	
	/**
	 * 发生烧烫伤后的急救处理编码
	 * @param Sd_burn_hdle
	 */
	public void setSd_burn_hdle(String Sd_burn_hdle) {
		setAttrVal("Sd_burn_hdle", Sd_burn_hdle);
	}
	/**
	 * 致伤原因id
	 * @return String
	 */
	public String getId_burn_causes() {
		return ((String) getAttrVal("Id_burn_causes"));
	}	
	/**
	 * 致伤原因id
	 * @param Id_burn_causes
	 */
	public void setId_burn_causes(String Id_burn_causes) {
		setAttrVal("Id_burn_causes", Id_burn_causes);
	}
	/**
	 * 致伤原因
	 * @return String
	 */
	public String getSd_burn_causes() {
		return ((String) getAttrVal("Sd_burn_causes"));
	}	
	/**
	 * 致伤原因
	 * @param Sd_burn_causes
	 */
	public void setSd_burn_causes(String Sd_burn_causes) {
		setAttrVal("Sd_burn_causes", Sd_burn_causes);
	}
	/**
	 * 其他致伤原因
	 * @return String
	 */
	public String getOth_burn_causes() {
		return ((String) getAttrVal("Oth_burn_causes"));
	}	
	/**
	 * 其他致伤原因
	 * @param Oth_burn_causes
	 */
	public void setOth_burn_causes(String Oth_burn_causes) {
		setAttrVal("Oth_burn_causes", Oth_burn_causes);
	}
	/**
	 * 其他发生烧烫伤后的急救处理
	 * @return String
	 */
	public String getOth_burn_hdle() {
		return ((String) getAttrVal("Oth_burn_hdle"));
	}	
	/**
	 * 其他发生烧烫伤后的急救处理
	 * @param Oth_burn_hdle
	 */
	public void setOth_burn_hdle(String Oth_burn_hdle) {
		setAttrVal("Oth_burn_hdle", Oth_burn_hdle);
	}
	/**
	 * 烧伤严重程度分类id
	 * @return String
	 */
	public String getId_burn_wsrca() {
		return ((String) getAttrVal("Id_burn_wsrca"));
	}	
	/**
	 * 烧伤严重程度分类id
	 * @param Id_burn_wsrca
	 */
	public void setId_burn_wsrca(String Id_burn_wsrca) {
		setAttrVal("Id_burn_wsrca", Id_burn_wsrca);
	}
	/**
	 * 烧伤严重程度分类编码
	 * @return String
	 */
	public String getSd_burn_wsrca() {
		return ((String) getAttrVal("Sd_burn_wsrca"));
	}	
	/**
	 * 烧伤严重程度分类编码
	 * @param Sd_burn_wsrca
	 */
	public void setSd_burn_wsrca(String Sd_burn_wsrca) {
		setAttrVal("Sd_burn_wsrca", Sd_burn_wsrca);
	}
	/**
	 * 发生于何种活动id
	 * @return String
	 */
	public String getId_ocur_ativy() {
		return ((String) getAttrVal("Id_ocur_ativy"));
	}	
	/**
	 * 发生于何种活动id
	 * @param Id_ocur_ativy
	 */
	public void setId_ocur_ativy(String Id_ocur_ativy) {
		setAttrVal("Id_ocur_ativy", Id_ocur_ativy);
	}
	/**
	 * 发生于何种活动编码
	 * @return String
	 */
	public String getSd_ocur_ativy() {
		return ((String) getAttrVal("Sd_ocur_ativy"));
	}	
	/**
	 * 发生于何种活动编码
	 * @param Sd_ocur_ativy
	 */
	public void setSd_ocur_ativy(String Sd_ocur_ativy) {
		setAttrVal("Sd_ocur_ativy", Sd_ocur_ativy);
	}
	/**
	 * 其他发生于何种活动
	 * @return String
	 */
	public String getOth_ocur_ativy() {
		return ((String) getAttrVal("Oth_ocur_ativy"));
	}	
	/**
	 * 其他发生于何种活动
	 * @param Oth_ocur_ativy
	 */
	public void setOth_ocur_ativy(String Oth_ocur_ativy) {
		setAttrVal("Oth_ocur_ativy", Oth_ocur_ativy);
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
	/**
	 * 烧伤部位
	 * @return String
	 */
	public String getName_burn_part() {
		return ((String) getAttrVal("Name_burn_part"));
	}	
	/**
	 * 烧伤部位
	 * @param Name_burn_part
	 */
	public void setName_burn_part(String Name_burn_part) {
		setAttrVal("Name_burn_part", Name_burn_part);
	}
	/**
	 * 发生烧伤后的急救处理
	 * @return String
	 */
	public String getName_burn_hdle() {
		return ((String) getAttrVal("Name_burn_hdle"));
	}	
	/**
	 * 发生烧伤后的急救处理
	 * @param Name_burn_hdle
	 */
	public void setName_burn_hdle(String Name_burn_hdle) {
		setAttrVal("Name_burn_hdle", Name_burn_hdle);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_burn_causes() {
		return ((String) getAttrVal("Name_burn_causes"));
	}	
	/**
	 * 名称
	 * @param Name_burn_causes
	 */
	public void setName_burn_causes(String Name_burn_causes) {
		setAttrVal("Name_burn_causes", Name_burn_causes);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_burn_wsrca() {
		return ((String) getAttrVal("Name_burn_wsrca"));
	}	
	/**
	 * 名称
	 * @param Name_burn_wsrca
	 */
	public void setName_burn_wsrca(String Name_burn_wsrca) {
		setAttrVal("Name_burn_wsrca", Name_burn_wsrca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ocur_ativy() {
		return ((String) getAttrVal("Name_ocur_ativy"));
	}	
	/**
	 * 名称
	 * @param Name_ocur_ativy
	 */
	public void setName_ocur_ativy(String Name_ocur_ativy) {
		setAttrVal("Name_ocur_ativy", Name_ocur_ativy);
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
		return "Id_aer_ev_burn";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_BURN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerBurnDODesc.class);
	}
	
}