package iih.sfda.aer.sfdaaerevsug.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevsug.d.desc.SfdaAerEvSugDODesc;
import java.math.BigDecimal;

/**
 * 手术事件 DO数据 
 * 
 */
public class SfdaAerEvSugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//手术事件主键
	public static final String ID_AER_EV_SUG= "Id_aer_ev_sug";
	//事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//手术事件错误发生阶段id
	public static final String ID_ERR_OCCURSTG= "Id_err_occurstg";
	//手术事件错误发生阶段
	public static final String SD_ERR_OCCURSTG= "Sd_err_occurstg";
	//其他手术事件错误发生阶段
	public static final String OTH_ERR_OCCURSTG= "Oth_err_occurstg";
	//手术事件错误类型id
	public static final String ID_ERR_TP= "Id_err_tp";
	//手术事件错误类型
	public static final String SD_ERR_TP= "Sd_err_tp";
	//其他手术事件错误类型
	public static final String OTH_ERR_TP= "Oth_err_tp";
	//手术名称
	public static final String NAME_SUG= "Name_sug";
	//手术结束后器械有误id
	public static final String ID_SUGAF_ERR= "Id_sugaf_err";
	//手术结束后器械有误
	public static final String SD_SUGAF_ERR= "Sd_sugaf_err";
	//有误器械名称
	public static final String NAME_ERR_APP= "Name_err_app";
	//有误器械数量
	public static final String COUNT_ERR_APP= "Count_err_app";
	//手术后异物遗留物品名称
	public static final String NAME_SUGAF_LV= "Name_sugaf_lv";
	//遗留物品大小
	public static final String SIZE_SUGAF_LV= "Size_sugaf_lv";
	//遗留体腔何处
	public static final String LOC_SUGAF_LV= "Loc_sugaf_lv";
	//手术标本是否漏送
	public static final String FG_SMP_DEVY= "Fg_smp_devy";
	//手术标本是否遗失
	public static final String FG_SMP_MISS= "Fg_smp_miss";
	//手术部位及术式差错发生次数
	public static final String COUNT_PSTERR= "Count_psterr";
	//手术过程中异物遗留发生次数
	public static final String COUNT_OCCURLV= "Count_occurlv";
	//手术患者是否发生意外伤害
	public static final String FG_ACC_INJY= "Fg_acc_injy";
	//医院内手术意外造成伤害id
	public static final String ID_ACC_INJY= "Id_acc_injy";
	//医院内手术意外造成伤害
	public static final String SD_ACC_INJY= "Sd_acc_injy";
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
	//名称
	public static final String NAME_ERR_OCCURSTG= "Name_err_occurstg";
	//名称
	public static final String NAME_ERR_TP= "Name_err_tp";
	//名称
	public static final String NAME_SUGAF_ERR= "Name_sugaf_err";
	//名称
	public static final String NAME_ACC_INJY= "Name_acc_injy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 手术事件主键
	 * @return String
	 */
	public String getId_aer_ev_sug() {
		return ((String) getAttrVal("Id_aer_ev_sug"));
	}	
	/**
	 * 手术事件主键
	 * @param Id_aer_ev_sug
	 */
	public void setId_aer_ev_sug(String Id_aer_ev_sug) {
		setAttrVal("Id_aer_ev_sug", Id_aer_ev_sug);
	}
	/**
	 * 事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 事件外键
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
	 * 手术事件错误发生阶段id
	 * @return String
	 */
	public String getId_err_occurstg() {
		return ((String) getAttrVal("Id_err_occurstg"));
	}	
	/**
	 * 手术事件错误发生阶段id
	 * @param Id_err_occurstg
	 */
	public void setId_err_occurstg(String Id_err_occurstg) {
		setAttrVal("Id_err_occurstg", Id_err_occurstg);
	}
	/**
	 * 手术事件错误发生阶段
	 * @return String
	 */
	public String getSd_err_occurstg() {
		return ((String) getAttrVal("Sd_err_occurstg"));
	}	
	/**
	 * 手术事件错误发生阶段
	 * @param Sd_err_occurstg
	 */
	public void setSd_err_occurstg(String Sd_err_occurstg) {
		setAttrVal("Sd_err_occurstg", Sd_err_occurstg);
	}
	/**
	 * 其他手术事件错误发生阶段
	 * @return String
	 */
	public String getOth_err_occurstg() {
		return ((String) getAttrVal("Oth_err_occurstg"));
	}	
	/**
	 * 其他手术事件错误发生阶段
	 * @param Oth_err_occurstg
	 */
	public void setOth_err_occurstg(String Oth_err_occurstg) {
		setAttrVal("Oth_err_occurstg", Oth_err_occurstg);
	}
	/**
	 * 手术事件错误类型id
	 * @return String
	 */
	public String getId_err_tp() {
		return ((String) getAttrVal("Id_err_tp"));
	}	
	/**
	 * 手术事件错误类型id
	 * @param Id_err_tp
	 */
	public void setId_err_tp(String Id_err_tp) {
		setAttrVal("Id_err_tp", Id_err_tp);
	}
	/**
	 * 手术事件错误类型
	 * @return String
	 */
	public String getSd_err_tp() {
		return ((String) getAttrVal("Sd_err_tp"));
	}	
	/**
	 * 手术事件错误类型
	 * @param Sd_err_tp
	 */
	public void setSd_err_tp(String Sd_err_tp) {
		setAttrVal("Sd_err_tp", Sd_err_tp);
	}
	/**
	 * 其他手术事件错误类型
	 * @return String
	 */
	public String getOth_err_tp() {
		return ((String) getAttrVal("Oth_err_tp"));
	}	
	/**
	 * 其他手术事件错误类型
	 * @param Oth_err_tp
	 */
	public void setOth_err_tp(String Oth_err_tp) {
		setAttrVal("Oth_err_tp", Oth_err_tp);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getName_sug() {
		return ((String) getAttrVal("Name_sug"));
	}	
	/**
	 * 手术名称
	 * @param Name_sug
	 */
	public void setName_sug(String Name_sug) {
		setAttrVal("Name_sug", Name_sug);
	}
	/**
	 * 手术结束后器械有误id
	 * @return String
	 */
	public String getId_sugaf_err() {
		return ((String) getAttrVal("Id_sugaf_err"));
	}	
	/**
	 * 手术结束后器械有误id
	 * @param Id_sugaf_err
	 */
	public void setId_sugaf_err(String Id_sugaf_err) {
		setAttrVal("Id_sugaf_err", Id_sugaf_err);
	}
	/**
	 * 手术结束后器械有误
	 * @return String
	 */
	public String getSd_sugaf_err() {
		return ((String) getAttrVal("Sd_sugaf_err"));
	}	
	/**
	 * 手术结束后器械有误
	 * @param Sd_sugaf_err
	 */
	public void setSd_sugaf_err(String Sd_sugaf_err) {
		setAttrVal("Sd_sugaf_err", Sd_sugaf_err);
	}
	/**
	 * 有误器械名称
	 * @return String
	 */
	public String getName_err_app() {
		return ((String) getAttrVal("Name_err_app"));
	}	
	/**
	 * 有误器械名称
	 * @param Name_err_app
	 */
	public void setName_err_app(String Name_err_app) {
		setAttrVal("Name_err_app", Name_err_app);
	}
	/**
	 * 有误器械数量
	 * @return Integer
	 */
	public Integer getCount_err_app() {
		return ((Integer) getAttrVal("Count_err_app"));
	}	
	/**
	 * 有误器械数量
	 * @param Count_err_app
	 */
	public void setCount_err_app(Integer Count_err_app) {
		setAttrVal("Count_err_app", Count_err_app);
	}
	/**
	 * 手术后异物遗留物品名称
	 * @return String
	 */
	public String getName_sugaf_lv() {
		return ((String) getAttrVal("Name_sugaf_lv"));
	}	
	/**
	 * 手术后异物遗留物品名称
	 * @param Name_sugaf_lv
	 */
	public void setName_sugaf_lv(String Name_sugaf_lv) {
		setAttrVal("Name_sugaf_lv", Name_sugaf_lv);
	}
	/**
	 * 遗留物品大小
	 * @return String
	 */
	public String getSize_sugaf_lv() {
		return ((String) getAttrVal("Size_sugaf_lv"));
	}	
	/**
	 * 遗留物品大小
	 * @param Size_sugaf_lv
	 */
	public void setSize_sugaf_lv(String Size_sugaf_lv) {
		setAttrVal("Size_sugaf_lv", Size_sugaf_lv);
	}
	/**
	 * 遗留体腔何处
	 * @return String
	 */
	public String getLoc_sugaf_lv() {
		return ((String) getAttrVal("Loc_sugaf_lv"));
	}	
	/**
	 * 遗留体腔何处
	 * @param Loc_sugaf_lv
	 */
	public void setLoc_sugaf_lv(String Loc_sugaf_lv) {
		setAttrVal("Loc_sugaf_lv", Loc_sugaf_lv);
	}
	/**
	 * 手术标本是否漏送
	 * @return Integer
	 */
	public Integer getFg_smp_devy() {
		return ((Integer) getAttrVal("Fg_smp_devy"));
	}	
	/**
	 * 手术标本是否漏送
	 * @param Fg_smp_devy
	 */
	public void setFg_smp_devy(Integer Fg_smp_devy) {
		setAttrVal("Fg_smp_devy", Fg_smp_devy);
	}
	/**
	 * 手术标本是否遗失
	 * @return Integer
	 */
	public Integer getFg_smp_miss() {
		return ((Integer) getAttrVal("Fg_smp_miss"));
	}	
	/**
	 * 手术标本是否遗失
	 * @param Fg_smp_miss
	 */
	public void setFg_smp_miss(Integer Fg_smp_miss) {
		setAttrVal("Fg_smp_miss", Fg_smp_miss);
	}
	/**
	 * 手术部位及术式差错发生次数
	 * @return Integer
	 */
	public Integer getCount_psterr() {
		return ((Integer) getAttrVal("Count_psterr"));
	}	
	/**
	 * 手术部位及术式差错发生次数
	 * @param Count_psterr
	 */
	public void setCount_psterr(Integer Count_psterr) {
		setAttrVal("Count_psterr", Count_psterr);
	}
	/**
	 * 手术过程中异物遗留发生次数
	 * @return Integer
	 */
	public Integer getCount_occurlv() {
		return ((Integer) getAttrVal("Count_occurlv"));
	}	
	/**
	 * 手术过程中异物遗留发生次数
	 * @param Count_occurlv
	 */
	public void setCount_occurlv(Integer Count_occurlv) {
		setAttrVal("Count_occurlv", Count_occurlv);
	}
	/**
	 * 手术患者是否发生意外伤害
	 * @return FBoolean
	 */
	public FBoolean getFg_acc_injy() {
		return ((FBoolean) getAttrVal("Fg_acc_injy"));
	}	
	/**
	 * 手术患者是否发生意外伤害
	 * @param Fg_acc_injy
	 */
	public void setFg_acc_injy(FBoolean Fg_acc_injy) {
		setAttrVal("Fg_acc_injy", Fg_acc_injy);
	}
	/**
	 * 医院内手术意外造成伤害id
	 * @return String
	 */
	public String getId_acc_injy() {
		return ((String) getAttrVal("Id_acc_injy"));
	}	
	/**
	 * 医院内手术意外造成伤害id
	 * @param Id_acc_injy
	 */
	public void setId_acc_injy(String Id_acc_injy) {
		setAttrVal("Id_acc_injy", Id_acc_injy);
	}
	/**
	 * 医院内手术意外造成伤害
	 * @return String
	 */
	public String getSd_acc_injy() {
		return ((String) getAttrVal("Sd_acc_injy"));
	}	
	/**
	 * 医院内手术意外造成伤害
	 * @param Sd_acc_injy
	 */
	public void setSd_acc_injy(String Sd_acc_injy) {
		setAttrVal("Sd_acc_injy", Sd_acc_injy);
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
	 * 名称
	 * @return String
	 */
	public String getName_err_occurstg() {
		return ((String) getAttrVal("Name_err_occurstg"));
	}	
	/**
	 * 名称
	 * @param Name_err_occurstg
	 */
	public void setName_err_occurstg(String Name_err_occurstg) {
		setAttrVal("Name_err_occurstg", Name_err_occurstg);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_err_tp() {
		return ((String) getAttrVal("Name_err_tp"));
	}	
	/**
	 * 名称
	 * @param Name_err_tp
	 */
	public void setName_err_tp(String Name_err_tp) {
		setAttrVal("Name_err_tp", Name_err_tp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sugaf_err() {
		return ((String) getAttrVal("Name_sugaf_err"));
	}	
	/**
	 * 名称
	 * @param Name_sugaf_err
	 */
	public void setName_sugaf_err(String Name_sugaf_err) {
		setAttrVal("Name_sugaf_err", Name_sugaf_err);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_acc_injy() {
		return ((String) getAttrVal("Name_acc_injy"));
	}	
	/**
	 * 名称
	 * @param Name_acc_injy
	 */
	public void setName_acc_injy(String Name_acc_injy) {
		setAttrVal("Name_acc_injy", Name_acc_injy);
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
		return "Id_aer_ev_sug";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_SUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvSugDODesc.class);
	}
	
}