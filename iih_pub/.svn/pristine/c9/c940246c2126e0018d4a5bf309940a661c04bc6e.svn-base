package iih.sfda.aer.sfdaaerevfdb.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevfdb.d.desc.SfdaAerEvFdbDODesc;
import java.math.BigDecimal;

/**
 * 跌倒/坠床 DO数据 
 * 
 */
public class SfdaAerEvFdbDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//跌倒坠床事件
	public static final String ID_AER_EV_FDB= "Id_aer_ev_fdb";
	//护理安全事件
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团组织
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//跌倒/坠床事件类型id
	public static final String ID_FDB_TP= "Id_fdb_tp";
	//跌倒/坠床事件类型
	public static final String SD_FDB_TP= "Sd_fdb_tp";
	//跌倒/坠床发生的对象id
	public static final String ID_FDB_OCCUROBJ= "Id_fdb_occurobj";
	//跌倒/坠床发生的对象
	public static final String SD_FDB_OCCUROBJ= "Sd_fdb_occurobj";
	//跌倒/坠床发生的环节id
	public static final String ID_FDB_OCCURLINK= "Id_fdb_occurlink";
	//跌倒/坠床发生的环节
	public static final String SD_FDB_OCCURLINK= "Sd_fdb_occurlink";
	//跌倒/坠床发生的原因(三甲指标)id
	public static final String ID_FDB_OCCURREAS= "Id_fdb_occurreas";
	//跌倒/坠床发生的原因(三甲指标)
	public static final String SD_FDB_OCCURREAS= "Sd_fdb_occurreas";
	//其他跌倒/坠床发生的原因(三甲指标)
	public static final String OTH_FDB_OCCURREAS= "Oth_fdb_occurreas";
	//跌倒/坠床有无造成伤害(三甲指标)
	public static final String FG_FDB_HURT= "Fg_fdb_hurt";
	//跌倒/坠床造成伤害等级id
	public static final String ID_FDB_HURTLVL= "Id_fdb_hurtlvl";
	//跌倒/坠床造成伤害等级
	public static final String SD_FDB_HURTLVL= "Sd_fdb_hurtlvl";
	//事件发生前是否为跌倒/坠床高危险群
	public static final String EU_ACURBEF_HRSK= "Eu_acurbef_hrsk";
	//事件发生前的独立活动能力id
	public static final String ID_INDEPDT_ATY= "Id_indepdt_aty";
	//事件发生前的独立活动能力
	public static final String SD_INDEPDT_ATY= "Sd_indepdt_aty";
	//事件发生前床栏使用情形id
	public static final String ID_BEDRAIL_STAT= "Id_bedrail_stat";
	//事件发生前床栏使用情形
	public static final String SD_BEDRAIL_STAT= "Sd_bedrail_stat";
	//当事人当时意识状态id
	public static final String ID_PARTY_IDLGY= "Id_party_idlgy";
	//当事人当时意识状态
	public static final String SD_PARTY_IDLGY= "Sd_party_idlgy";
	//事件发生于何项活动过程id
	public static final String ID_OCCUR_ATYPRES= "Id_occur_atypres";
	//事件发生于何项活动过程
	public static final String SD_OCCUR_ATYPRES= "Sd_occur_atypres";
	//其他事件发生于何项活动过程
	public static final String OTH_OCCUR_ATYPRES= "Oth_occur_atypres";
	//平日有无陪伴者
	public static final String EU_ANY_CPY= "Eu_any_cpy";
	//事件发生时有无陪伴者
	public static final String EU_CPY_HERE= "Eu_cpy_here";
	//事件发生时陪伴者
	public static final String NAME_CPY_HERE= "Name_cpy_here";
	//本次住院期间是否发生再次跌倒/坠床
	public static final String FG_RECUR_FDB= "Fg_recur_fdb";
	//再次发生跌倒/坠床是否上报
	public static final String EU_RECUR_REPORT= "Eu_recur_report";
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
	//集团组织
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_FDB_TP= "Name_fdb_tp";
	//名称
	public static final String NAME_FDB_OCCUROBJ= "Name_fdb_occurobj";
	//名称
	public static final String NAME_FDB_OCCURLINK= "Name_fdb_occurlink";
	//名称
	public static final String NAME_FDB_OCCURREAS= "Name_fdb_occurreas";
	//名称
	public static final String NAME_FDB_HURTLVL= "Name_fdb_hurtlvl";
	//名称
	public static final String NAME_INDEPDT_ATY= "Name_indepdt_aty";
	//名称
	public static final String NAME_BEDRAIL_STAT= "Name_bedrail_stat";
	//名称
	public static final String NAME_PARTY_IDLGY= "Name_party_idlgy";
	//名称
	public static final String NAME_OCCUR_ATYPRES= "Name_occur_atypres";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 跌倒坠床事件
	 * @return String
	 */
	public String getId_aer_ev_fdb() {
		return ((String) getAttrVal("Id_aer_ev_fdb"));
	}	
	/**
	 * 跌倒坠床事件
	 * @param Id_aer_ev_fdb
	 */
	public void setId_aer_ev_fdb(String Id_aer_ev_fdb) {
		setAttrVal("Id_aer_ev_fdb", Id_aer_ev_fdb);
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
	 * 集团组织
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团组织
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
	 * 跌倒/坠床事件类型id
	 * @return String
	 */
	public String getId_fdb_tp() {
		return ((String) getAttrVal("Id_fdb_tp"));
	}	
	/**
	 * 跌倒/坠床事件类型id
	 * @param Id_fdb_tp
	 */
	public void setId_fdb_tp(String Id_fdb_tp) {
		setAttrVal("Id_fdb_tp", Id_fdb_tp);
	}
	/**
	 * 跌倒/坠床事件类型
	 * @return String
	 */
	public String getSd_fdb_tp() {
		return ((String) getAttrVal("Sd_fdb_tp"));
	}	
	/**
	 * 跌倒/坠床事件类型
	 * @param Sd_fdb_tp
	 */
	public void setSd_fdb_tp(String Sd_fdb_tp) {
		setAttrVal("Sd_fdb_tp", Sd_fdb_tp);
	}
	/**
	 * 跌倒/坠床发生的对象id
	 * @return String
	 */
	public String getId_fdb_occurobj() {
		return ((String) getAttrVal("Id_fdb_occurobj"));
	}	
	/**
	 * 跌倒/坠床发生的对象id
	 * @param Id_fdb_occurobj
	 */
	public void setId_fdb_occurobj(String Id_fdb_occurobj) {
		setAttrVal("Id_fdb_occurobj", Id_fdb_occurobj);
	}
	/**
	 * 跌倒/坠床发生的对象
	 * @return String
	 */
	public String getSd_fdb_occurobj() {
		return ((String) getAttrVal("Sd_fdb_occurobj"));
	}	
	/**
	 * 跌倒/坠床发生的对象
	 * @param Sd_fdb_occurobj
	 */
	public void setSd_fdb_occurobj(String Sd_fdb_occurobj) {
		setAttrVal("Sd_fdb_occurobj", Sd_fdb_occurobj);
	}
	/**
	 * 跌倒/坠床发生的环节id
	 * @return String
	 */
	public String getId_fdb_occurlink() {
		return ((String) getAttrVal("Id_fdb_occurlink"));
	}	
	/**
	 * 跌倒/坠床发生的环节id
	 * @param Id_fdb_occurlink
	 */
	public void setId_fdb_occurlink(String Id_fdb_occurlink) {
		setAttrVal("Id_fdb_occurlink", Id_fdb_occurlink);
	}
	/**
	 * 跌倒/坠床发生的环节
	 * @return String
	 */
	public String getSd_fdb_occurlink() {
		return ((String) getAttrVal("Sd_fdb_occurlink"));
	}	
	/**
	 * 跌倒/坠床发生的环节
	 * @param Sd_fdb_occurlink
	 */
	public void setSd_fdb_occurlink(String Sd_fdb_occurlink) {
		setAttrVal("Sd_fdb_occurlink", Sd_fdb_occurlink);
	}
	/**
	 * 跌倒/坠床发生的原因(三甲指标)id
	 * @return String
	 */
	public String getId_fdb_occurreas() {
		return ((String) getAttrVal("Id_fdb_occurreas"));
	}	
	/**
	 * 跌倒/坠床发生的原因(三甲指标)id
	 * @param Id_fdb_occurreas
	 */
	public void setId_fdb_occurreas(String Id_fdb_occurreas) {
		setAttrVal("Id_fdb_occurreas", Id_fdb_occurreas);
	}
	/**
	 * 跌倒/坠床发生的原因(三甲指标)
	 * @return String
	 */
	public String getSd_fdb_occurreas() {
		return ((String) getAttrVal("Sd_fdb_occurreas"));
	}	
	/**
	 * 跌倒/坠床发生的原因(三甲指标)
	 * @param Sd_fdb_occurreas
	 */
	public void setSd_fdb_occurreas(String Sd_fdb_occurreas) {
		setAttrVal("Sd_fdb_occurreas", Sd_fdb_occurreas);
	}
	/**
	 * 其他跌倒/坠床发生的原因(三甲指标)
	 * @return String
	 */
	public String getOth_fdb_occurreas() {
		return ((String) getAttrVal("Oth_fdb_occurreas"));
	}	
	/**
	 * 其他跌倒/坠床发生的原因(三甲指标)
	 * @param Oth_fdb_occurreas
	 */
	public void setOth_fdb_occurreas(String Oth_fdb_occurreas) {
		setAttrVal("Oth_fdb_occurreas", Oth_fdb_occurreas);
	}
	/**
	 * 跌倒/坠床有无造成伤害(三甲指标)
	 * @return FBoolean
	 */
	public FBoolean getFg_fdb_hurt() {
		return ((FBoolean) getAttrVal("Fg_fdb_hurt"));
	}	
	/**
	 * 跌倒/坠床有无造成伤害(三甲指标)
	 * @param Fg_fdb_hurt
	 */
	public void setFg_fdb_hurt(FBoolean Fg_fdb_hurt) {
		setAttrVal("Fg_fdb_hurt", Fg_fdb_hurt);
	}
	/**
	 * 跌倒/坠床造成伤害等级id
	 * @return String
	 */
	public String getId_fdb_hurtlvl() {
		return ((String) getAttrVal("Id_fdb_hurtlvl"));
	}	
	/**
	 * 跌倒/坠床造成伤害等级id
	 * @param Id_fdb_hurtlvl
	 */
	public void setId_fdb_hurtlvl(String Id_fdb_hurtlvl) {
		setAttrVal("Id_fdb_hurtlvl", Id_fdb_hurtlvl);
	}
	/**
	 * 跌倒/坠床造成伤害等级
	 * @return String
	 */
	public String getSd_fdb_hurtlvl() {
		return ((String) getAttrVal("Sd_fdb_hurtlvl"));
	}	
	/**
	 * 跌倒/坠床造成伤害等级
	 * @param Sd_fdb_hurtlvl
	 */
	public void setSd_fdb_hurtlvl(String Sd_fdb_hurtlvl) {
		setAttrVal("Sd_fdb_hurtlvl", Sd_fdb_hurtlvl);
	}
	/**
	 * 事件发生前是否为跌倒/坠床高危险群
	 * @return Integer
	 */
	public Integer getEu_acurbef_hrsk() {
		return ((Integer) getAttrVal("Eu_acurbef_hrsk"));
	}	
	/**
	 * 事件发生前是否为跌倒/坠床高危险群
	 * @param Eu_acurbef_hrsk
	 */
	public void setEu_acurbef_hrsk(Integer Eu_acurbef_hrsk) {
		setAttrVal("Eu_acurbef_hrsk", Eu_acurbef_hrsk);
	}
	/**
	 * 事件发生前的独立活动能力id
	 * @return String
	 */
	public String getId_indepdt_aty() {
		return ((String) getAttrVal("Id_indepdt_aty"));
	}	
	/**
	 * 事件发生前的独立活动能力id
	 * @param Id_indepdt_aty
	 */
	public void setId_indepdt_aty(String Id_indepdt_aty) {
		setAttrVal("Id_indepdt_aty", Id_indepdt_aty);
	}
	/**
	 * 事件发生前的独立活动能力
	 * @return String
	 */
	public String getSd_indepdt_aty() {
		return ((String) getAttrVal("Sd_indepdt_aty"));
	}	
	/**
	 * 事件发生前的独立活动能力
	 * @param Sd_indepdt_aty
	 */
	public void setSd_indepdt_aty(String Sd_indepdt_aty) {
		setAttrVal("Sd_indepdt_aty", Sd_indepdt_aty);
	}
	/**
	 * 事件发生前床栏使用情形id
	 * @return String
	 */
	public String getId_bedrail_stat() {
		return ((String) getAttrVal("Id_bedrail_stat"));
	}	
	/**
	 * 事件发生前床栏使用情形id
	 * @param Id_bedrail_stat
	 */
	public void setId_bedrail_stat(String Id_bedrail_stat) {
		setAttrVal("Id_bedrail_stat", Id_bedrail_stat);
	}
	/**
	 * 事件发生前床栏使用情形
	 * @return String
	 */
	public String getSd_bedrail_stat() {
		return ((String) getAttrVal("Sd_bedrail_stat"));
	}	
	/**
	 * 事件发生前床栏使用情形
	 * @param Sd_bedrail_stat
	 */
	public void setSd_bedrail_stat(String Sd_bedrail_stat) {
		setAttrVal("Sd_bedrail_stat", Sd_bedrail_stat);
	}
	/**
	 * 当事人当时意识状态id
	 * @return String
	 */
	public String getId_party_idlgy() {
		return ((String) getAttrVal("Id_party_idlgy"));
	}	
	/**
	 * 当事人当时意识状态id
	 * @param Id_party_idlgy
	 */
	public void setId_party_idlgy(String Id_party_idlgy) {
		setAttrVal("Id_party_idlgy", Id_party_idlgy);
	}
	/**
	 * 当事人当时意识状态
	 * @return String
	 */
	public String getSd_party_idlgy() {
		return ((String) getAttrVal("Sd_party_idlgy"));
	}	
	/**
	 * 当事人当时意识状态
	 * @param Sd_party_idlgy
	 */
	public void setSd_party_idlgy(String Sd_party_idlgy) {
		setAttrVal("Sd_party_idlgy", Sd_party_idlgy);
	}
	/**
	 * 事件发生于何项活动过程id
	 * @return String
	 */
	public String getId_occur_atypres() {
		return ((String) getAttrVal("Id_occur_atypres"));
	}	
	/**
	 * 事件发生于何项活动过程id
	 * @param Id_occur_atypres
	 */
	public void setId_occur_atypres(String Id_occur_atypres) {
		setAttrVal("Id_occur_atypres", Id_occur_atypres);
	}
	/**
	 * 事件发生于何项活动过程
	 * @return String
	 */
	public String getSd_occur_atypres() {
		return ((String) getAttrVal("Sd_occur_atypres"));
	}	
	/**
	 * 事件发生于何项活动过程
	 * @param Sd_occur_atypres
	 */
	public void setSd_occur_atypres(String Sd_occur_atypres) {
		setAttrVal("Sd_occur_atypres", Sd_occur_atypres);
	}
	/**
	 * 其他事件发生于何项活动过程
	 * @return String
	 */
	public String getOth_occur_atypres() {
		return ((String) getAttrVal("Oth_occur_atypres"));
	}	
	/**
	 * 其他事件发生于何项活动过程
	 * @param Oth_occur_atypres
	 */
	public void setOth_occur_atypres(String Oth_occur_atypres) {
		setAttrVal("Oth_occur_atypres", Oth_occur_atypres);
	}
	/**
	 * 平日有无陪伴者
	 * @return Integer
	 */
	public Integer getEu_any_cpy() {
		return ((Integer) getAttrVal("Eu_any_cpy"));
	}	
	/**
	 * 平日有无陪伴者
	 * @param Eu_any_cpy
	 */
	public void setEu_any_cpy(Integer Eu_any_cpy) {
		setAttrVal("Eu_any_cpy", Eu_any_cpy);
	}
	/**
	 * 事件发生时有无陪伴者
	 * @return Integer
	 */
	public Integer getEu_cpy_here() {
		return ((Integer) getAttrVal("Eu_cpy_here"));
	}	
	/**
	 * 事件发生时有无陪伴者
	 * @param Eu_cpy_here
	 */
	public void setEu_cpy_here(Integer Eu_cpy_here) {
		setAttrVal("Eu_cpy_here", Eu_cpy_here);
	}
	/**
	 * 事件发生时陪伴者
	 * @return String
	 */
	public String getName_cpy_here() {
		return ((String) getAttrVal("Name_cpy_here"));
	}	
	/**
	 * 事件发生时陪伴者
	 * @param Name_cpy_here
	 */
	public void setName_cpy_here(String Name_cpy_here) {
		setAttrVal("Name_cpy_here", Name_cpy_here);
	}
	/**
	 * 本次住院期间是否发生再次跌倒/坠床
	 * @return FBoolean
	 */
	public FBoolean getFg_recur_fdb() {
		return ((FBoolean) getAttrVal("Fg_recur_fdb"));
	}	
	/**
	 * 本次住院期间是否发生再次跌倒/坠床
	 * @param Fg_recur_fdb
	 */
	public void setFg_recur_fdb(FBoolean Fg_recur_fdb) {
		setAttrVal("Fg_recur_fdb", Fg_recur_fdb);
	}
	/**
	 * 再次发生跌倒/坠床是否上报
	 * @return Integer
	 */
	public Integer getEu_recur_report() {
		return ((Integer) getAttrVal("Eu_recur_report"));
	}	
	/**
	 * 再次发生跌倒/坠床是否上报
	 * @param Eu_recur_report
	 */
	public void setEu_recur_report(Integer Eu_recur_report) {
		setAttrVal("Eu_recur_report", Eu_recur_report);
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
	 * 集团组织
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 集团组织
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
	public String getName_fdb_tp() {
		return ((String) getAttrVal("Name_fdb_tp"));
	}	
	/**
	 * 名称
	 * @param Name_fdb_tp
	 */
	public void setName_fdb_tp(String Name_fdb_tp) {
		setAttrVal("Name_fdb_tp", Name_fdb_tp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_fdb_occurobj() {
		return ((String) getAttrVal("Name_fdb_occurobj"));
	}	
	/**
	 * 名称
	 * @param Name_fdb_occurobj
	 */
	public void setName_fdb_occurobj(String Name_fdb_occurobj) {
		setAttrVal("Name_fdb_occurobj", Name_fdb_occurobj);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_fdb_occurlink() {
		return ((String) getAttrVal("Name_fdb_occurlink"));
	}	
	/**
	 * 名称
	 * @param Name_fdb_occurlink
	 */
	public void setName_fdb_occurlink(String Name_fdb_occurlink) {
		setAttrVal("Name_fdb_occurlink", Name_fdb_occurlink);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_fdb_occurreas() {
		return ((String) getAttrVal("Name_fdb_occurreas"));
	}	
	/**
	 * 名称
	 * @param Name_fdb_occurreas
	 */
	public void setName_fdb_occurreas(String Name_fdb_occurreas) {
		setAttrVal("Name_fdb_occurreas", Name_fdb_occurreas);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_fdb_hurtlvl() {
		return ((String) getAttrVal("Name_fdb_hurtlvl"));
	}	
	/**
	 * 名称
	 * @param Name_fdb_hurtlvl
	 */
	public void setName_fdb_hurtlvl(String Name_fdb_hurtlvl) {
		setAttrVal("Name_fdb_hurtlvl", Name_fdb_hurtlvl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_indepdt_aty() {
		return ((String) getAttrVal("Name_indepdt_aty"));
	}	
	/**
	 * 名称
	 * @param Name_indepdt_aty
	 */
	public void setName_indepdt_aty(String Name_indepdt_aty) {
		setAttrVal("Name_indepdt_aty", Name_indepdt_aty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_bedrail_stat() {
		return ((String) getAttrVal("Name_bedrail_stat"));
	}	
	/**
	 * 名称
	 * @param Name_bedrail_stat
	 */
	public void setName_bedrail_stat(String Name_bedrail_stat) {
		setAttrVal("Name_bedrail_stat", Name_bedrail_stat);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_party_idlgy() {
		return ((String) getAttrVal("Name_party_idlgy"));
	}	
	/**
	 * 名称
	 * @param Name_party_idlgy
	 */
	public void setName_party_idlgy(String Name_party_idlgy) {
		setAttrVal("Name_party_idlgy", Name_party_idlgy);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_occur_atypres() {
		return ((String) getAttrVal("Name_occur_atypres"));
	}	
	/**
	 * 名称
	 * @param Name_occur_atypres
	 */
	public void setName_occur_atypres(String Name_occur_atypres) {
		setAttrVal("Name_occur_atypres", Name_occur_atypres);
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
		return "Id_aer_ev_fdb";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_FDB";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvFdbDODesc.class);
	}
	
}