package iih.pe.pitm.pesrvsetdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvsetdef.d.desc.PeSrvSetDefDODesc;
import java.math.BigDecimal;

/**
 * 体检套餐定义（项目组合） DO数据 
 * 
 */
public class PeSrvSetDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检套餐主键标识
	public static final String ID_PESRVSETDEF= "Id_pesrvsetdef";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//体检套餐名称
	public static final String NAME= "Name";
	//体检套餐介绍
	public static final String INTRODUCTION= "Introduction";
	//打印名称
	public static final String NAME_PRT= "Name_prt";
	//体检套餐级别编码
	public static final String SD_LEVEL= "Sd_level";
	//体检套餐级别ID
	public static final String ID_LEVEL= "Id_level";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//原始价格
	public static final String PRI_ORIGINAL= "Pri_original";
	//基础价格
	public static final String PRI_SRVSET= "Pri_srvset";
	//VIP标识
	public static final String FG_VIP= "Fg_vip";
	//体检套餐类别ID
	public static final String ID_PESRVSETCA= "Id_pesrvsetca";
	//默认体检报告
	public static final String NO_REPORT= "No_report";
	//默认问卷
	public static final String NO_INQ= "No_inq";
	//名单导入标签
	public static final String LABEL_SET= "Label_set";
	//组合类别
	public static final String GROUPCA= "Groupca";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//序号
	public static final String SORTNO= "Sortno";
	//选择标识
	public static final String FG_SELECT= "Fg_select";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//减项减价格
	public static final String FG_DEDUCT= "Fg_deduct";
	//名称
	public static final String NAME_LEVEL= "Name_level";
	//编码
	public static final String CODE_LEVEL= "Code_level";
	//编码
	public static final String CODE_SRVSET= "Code_srvset";
	//名称
	public static final String NAME_SRVSET= "Name_srvset";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检套餐主键标识
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}	
	/**
	 * 体检套餐主键标识
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 体检套餐名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 体检套餐名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 体检套餐介绍
	 * @return String
	 */
	public String getIntroduction() {
		return ((String) getAttrVal("Introduction"));
	}	
	/**
	 * 体检套餐介绍
	 * @param Introduction
	 */
	public void setIntroduction(String Introduction) {
		setAttrVal("Introduction", Introduction);
	}
	/**
	 * 打印名称
	 * @return String
	 */
	public String getName_prt() {
		return ((String) getAttrVal("Name_prt"));
	}	
	/**
	 * 打印名称
	 * @param Name_prt
	 */
	public void setName_prt(String Name_prt) {
		setAttrVal("Name_prt", Name_prt);
	}
	/**
	 * 体检套餐级别编码
	 * @return String
	 */
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}	
	/**
	 * 体检套餐级别编码
	 * @param Sd_level
	 */
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
	}
	/**
	 * 体检套餐级别ID
	 * @return String
	 */
	public String getId_level() {
		return ((String) getAttrVal("Id_level"));
	}	
	/**
	 * 体检套餐级别ID
	 * @param Id_level
	 */
	public void setId_level(String Id_level) {
		setAttrVal("Id_level", Id_level);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 原始价格
	 * @return FDouble
	 */
	public FDouble getPri_original() {
		return ((FDouble) getAttrVal("Pri_original"));
	}	
	/**
	 * 原始价格
	 * @param Pri_original
	 */
	public void setPri_original(FDouble Pri_original) {
		setAttrVal("Pri_original", Pri_original);
	}
	/**
	 * 基础价格
	 * @return FDouble
	 */
	public FDouble getPri_srvset() {
		return ((FDouble) getAttrVal("Pri_srvset"));
	}	
	/**
	 * 基础价格
	 * @param Pri_srvset
	 */
	public void setPri_srvset(FDouble Pri_srvset) {
		setAttrVal("Pri_srvset", Pri_srvset);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 体检套餐类别ID
	 * @return String
	 */
	public String getId_pesrvsetca() {
		return ((String) getAttrVal("Id_pesrvsetca"));
	}	
	/**
	 * 体检套餐类别ID
	 * @param Id_pesrvsetca
	 */
	public void setId_pesrvsetca(String Id_pesrvsetca) {
		setAttrVal("Id_pesrvsetca", Id_pesrvsetca);
	}
	/**
	 * 默认体检报告
	 * @return String
	 */
	public String getNo_report() {
		return ((String) getAttrVal("No_report"));
	}	
	/**
	 * 默认体检报告
	 * @param No_report
	 */
	public void setNo_report(String No_report) {
		setAttrVal("No_report", No_report);
	}
	/**
	 * 默认问卷
	 * @return String
	 */
	public String getNo_inq() {
		return ((String) getAttrVal("No_inq"));
	}	
	/**
	 * 默认问卷
	 * @param No_inq
	 */
	public void setNo_inq(String No_inq) {
		setAttrVal("No_inq", No_inq);
	}
	/**
	 * 名单导入标签
	 * @return String
	 */
	public String getLabel_set() {
		return ((String) getAttrVal("Label_set"));
	}	
	/**
	 * 名单导入标签
	 * @param Label_set
	 */
	public void setLabel_set(String Label_set) {
		setAttrVal("Label_set", Label_set);
	}
	/**
	 * 组合类别
	 * @return Integer
	 */
	public Integer getGroupca() {
		return ((Integer) getAttrVal("Groupca"));
	}	
	/**
	 * 组合类别
	 * @param Groupca
	 */
	public void setGroupca(Integer Groupca) {
		setAttrVal("Groupca", Groupca);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 选择标识
	 * @return FBoolean
	 */
	public FBoolean getFg_select() {
		return ((FBoolean) getAttrVal("Fg_select"));
	}	
	/**
	 * 选择标识
	 * @param Fg_select
	 */
	public void setFg_select(FBoolean Fg_select) {
		setAttrVal("Fg_select", Fg_select);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
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
	 * 减项减价格
	 * @return FBoolean
	 */
	public FBoolean getFg_deduct() {
		return ((FBoolean) getAttrVal("Fg_deduct"));
	}	
	/**
	 * 减项减价格
	 * @param Fg_deduct
	 */
	public void setFg_deduct(FBoolean Fg_deduct) {
		setAttrVal("Fg_deduct", Fg_deduct);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_level() {
		return ((String) getAttrVal("Name_level"));
	}	
	/**
	 * 名称
	 * @param Name_level
	 */
	public void setName_level(String Name_level) {
		setAttrVal("Name_level", Name_level);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_level() {
		return ((String) getAttrVal("Code_level"));
	}	
	/**
	 * 编码
	 * @param Code_level
	 */
	public void setCode_level(String Code_level) {
		setAttrVal("Code_level", Code_level);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_srvset() {
		return ((String) getAttrVal("Code_srvset"));
	}	
	/**
	 * 编码
	 * @param Code_srvset
	 */
	public void setCode_srvset(String Code_srvset) {
		setAttrVal("Code_srvset", Code_srvset);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_srvset() {
		return ((String) getAttrVal("Name_srvset"));
	}	
	/**
	 * 名称
	 * @param Name_srvset
	 */
	public void setName_srvset(String Name_srvset) {
		setAttrVal("Name_srvset", Name_srvset);
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
		return "Id_pesrvsetdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvsetdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvSetDefDODesc.class);
	}
	
}