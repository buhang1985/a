package iih.pe.pitm.pesrvbcatlog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvbcatlog.d.desc.PeSrvbCatlogDODesc;
import java.math.BigDecimal;

/**
 * 体检项目基本目录 DO数据 
 * 
 */
public class PeSrvbCatlogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检项目主键标识
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属科室
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//体检标本类型主键
	public static final String ID_PESRVSAMPLECA= "Id_pesrvsampleca";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//简称
	public static final String NAME_SHORT= "Name_short";
	//英文名
	public static final String ENAME= "Ename";
	//序号
	public static final String SORTNO= "Sortno";
	//基础价格
	public static final String PRICE= "Price";
	//最大折扣
	public static final String MAX_DISCOUNT= "Max_discount";
	//价表价格
	public static final String PRI_ORIGINAL= "Pri_original";
	//成本价格
	public static final String PRI_COST= "Pri_cost";
	//性别适用
	public static final String SEXLIMIT= "Sexlimit";
	//儿童禁用
	public static final String FG_ENFANT= "Fg_enfant";
	//孕妇禁用
	public static final String FG_PREGNENT= "Fg_pregnent";
	//未婚禁用
	public static final String FG_MARRIED= "Fg_married";
	//人数限制
	public static final String MAX_LIMIT= "Max_limit";
	//导引单打印
	public static final String FG_GUIDEPRINT= "Fg_guideprint";
	//外协项目
	public static final String FG_ASSISTED= "Fg_assisted";
	//检查时长
	public static final String CHKDURATION= "Chkduration";
	//所属目录
	public static final String CATLOG= "Catlog";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务分类
	public static final String ID_SRVCA= "Id_srvca";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
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
	//选择标识
	public static final String FG_SELECT= "Fg_select";
	//检查地点（男）
	public static final String LOC_CATMAN= "Loc_catman";
	//检查地点（女）
	public static final String LOC_CATWOMAN= "Loc_catwoman";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//套餐内项目标识
	public static final String FG_SETDEF= "Fg_setdef";
	//定价模式
	public static final String ID_PRIMD= "Id_primd";
	//定价模式编码
	public static final String SD_PRIMD= "Sd_primd";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//自定义服务名称标志
	public static final String FG_CTM= "Fg_ctm";
	//医嘱可开立标识
	public static final String FG_OR= "Fg_or";
	//医疗物品标识
	public static final String FG_MM= "Fg_mm";
	//费用标识
	public static final String FG_BL= "Fg_bl";
	//价格描述
	public static final String DES_PRI= "Des_pri";
	//网页显示标识
	public static final String FG_WEB= "Fg_web";
	//检查目的
	public static final String PURPOSE= "Purpose";
	//检查项目注意事项
	public static final String ATTENTION= "Attention";
	//自付标识
	public static final String FG_PAYSELF= "Fg_payself";
	//体检科室名称
	public static final String NAME_DEPT= "Name_dept";
	//体检科室编码
	public static final String CODE_DEPT= "Code_dept";
	//编码
	public static final String CODE_SAMPLE= "Code_sample";
	//名称
	public static final String NAME_SAMPLE= "Name_sample";
	//服务分类编码
	public static final String SRVCA_CODE= "Srvca_code";
	//服务分类名称
	public static final String SRVCA_NAME= "Srvca_name";
	//默认服务类型编码
	public static final String CODE_SRVTP_CA= "Code_srvtp_ca";
	//编码
	public static final String CODE_PRIMD= "Code_primd";
	//名称
	public static final String NAME_PRIMD= "Name_primd";
	//编码
	public static final String CODE_SRVTP= "Code_srvtp";
	//名称
	public static final String NAME_SRVTP= "Name_srvtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检项目主键标识
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	/**
	 * 体检项目主键标识
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
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
	 * 所属科室
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 所属科室
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检标本类型主键
	 * @return String
	 */
	public String getId_pesrvsampleca() {
		return ((String) getAttrVal("Id_pesrvsampleca"));
	}	
	/**
	 * 体检标本类型主键
	 * @param Id_pesrvsampleca
	 */
	public void setId_pesrvsampleca(String Id_pesrvsampleca) {
		setAttrVal("Id_pesrvsampleca", Id_pesrvsampleca);
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
	/**
	 * 简称
	 * @return String
	 */
	public String getName_short() {
		return ((String) getAttrVal("Name_short"));
	}	
	/**
	 * 简称
	 * @param Name_short
	 */
	public void setName_short(String Name_short) {
		setAttrVal("Name_short", Name_short);
	}
	/**
	 * 英文名
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 英文名
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
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
	 * 基础价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 基础价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 最大折扣
	 * @return FDouble
	 */
	public FDouble getMax_discount() {
		return ((FDouble) getAttrVal("Max_discount"));
	}	
	/**
	 * 最大折扣
	 * @param Max_discount
	 */
	public void setMax_discount(FDouble Max_discount) {
		setAttrVal("Max_discount", Max_discount);
	}
	/**
	 * 价表价格
	 * @return FDouble
	 */
	public FDouble getPri_original() {
		return ((FDouble) getAttrVal("Pri_original"));
	}	
	/**
	 * 价表价格
	 * @param Pri_original
	 */
	public void setPri_original(FDouble Pri_original) {
		setAttrVal("Pri_original", Pri_original);
	}
	/**
	 * 成本价格
	 * @return FDouble
	 */
	public FDouble getPri_cost() {
		return ((FDouble) getAttrVal("Pri_cost"));
	}	
	/**
	 * 成本价格
	 * @param Pri_cost
	 */
	public void setPri_cost(FDouble Pri_cost) {
		setAttrVal("Pri_cost", Pri_cost);
	}
	/**
	 * 性别适用
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别适用
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 儿童禁用
	 * @return FBoolean
	 */
	public FBoolean getFg_enfant() {
		return ((FBoolean) getAttrVal("Fg_enfant"));
	}	
	/**
	 * 儿童禁用
	 * @param Fg_enfant
	 */
	public void setFg_enfant(FBoolean Fg_enfant) {
		setAttrVal("Fg_enfant", Fg_enfant);
	}
	/**
	 * 孕妇禁用
	 * @return FBoolean
	 */
	public FBoolean getFg_pregnent() {
		return ((FBoolean) getAttrVal("Fg_pregnent"));
	}	
	/**
	 * 孕妇禁用
	 * @param Fg_pregnent
	 */
	public void setFg_pregnent(FBoolean Fg_pregnent) {
		setAttrVal("Fg_pregnent", Fg_pregnent);
	}
	/**
	 * 未婚禁用
	 * @return FBoolean
	 */
	public FBoolean getFg_married() {
		return ((FBoolean) getAttrVal("Fg_married"));
	}	
	/**
	 * 未婚禁用
	 * @param Fg_married
	 */
	public void setFg_married(FBoolean Fg_married) {
		setAttrVal("Fg_married", Fg_married);
	}
	/**
	 * 人数限制
	 * @return Integer
	 */
	public Integer getMax_limit() {
		return ((Integer) getAttrVal("Max_limit"));
	}	
	/**
	 * 人数限制
	 * @param Max_limit
	 */
	public void setMax_limit(Integer Max_limit) {
		setAttrVal("Max_limit", Max_limit);
	}
	/**
	 * 导引单打印
	 * @return FBoolean
	 */
	public FBoolean getFg_guideprint() {
		return ((FBoolean) getAttrVal("Fg_guideprint"));
	}	
	/**
	 * 导引单打印
	 * @param Fg_guideprint
	 */
	public void setFg_guideprint(FBoolean Fg_guideprint) {
		setAttrVal("Fg_guideprint", Fg_guideprint);
	}
	/**
	 * 外协项目
	 * @return FBoolean
	 */
	public FBoolean getFg_assisted() {
		return ((FBoolean) getAttrVal("Fg_assisted"));
	}	
	/**
	 * 外协项目
	 * @param Fg_assisted
	 */
	public void setFg_assisted(FBoolean Fg_assisted) {
		setAttrVal("Fg_assisted", Fg_assisted);
	}
	/**
	 * 检查时长
	 * @return Integer
	 */
	public Integer getChkduration() {
		return ((Integer) getAttrVal("Chkduration"));
	}	
	/**
	 * 检查时长
	 * @param Chkduration
	 */
	public void setChkduration(Integer Chkduration) {
		setAttrVal("Chkduration", Chkduration);
	}
	/**
	 * 所属目录
	 * @return Integer
	 */
	public Integer getCatlog() {
		return ((Integer) getAttrVal("Catlog"));
	}	
	/**
	 * 所属目录
	 * @param Catlog
	 */
	public void setCatlog(Integer Catlog) {
		setAttrVal("Catlog", Catlog);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
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
	 * 检查地点（男）
	 * @return String
	 */
	public String getLoc_catman() {
		return ((String) getAttrVal("Loc_catman"));
	}	
	/**
	 * 检查地点（男）
	 * @param Loc_catman
	 */
	public void setLoc_catman(String Loc_catman) {
		setAttrVal("Loc_catman", Loc_catman);
	}
	/**
	 * 检查地点（女）
	 * @return String
	 */
	public String getLoc_catwoman() {
		return ((String) getAttrVal("Loc_catwoman"));
	}	
	/**
	 * 检查地点（女）
	 * @param Loc_catwoman
	 */
	public void setLoc_catwoman(String Loc_catwoman) {
		setAttrVal("Loc_catwoman", Loc_catwoman);
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
	 * 套餐内项目标识
	 * @return FBoolean
	 */
	public FBoolean getFg_setdef() {
		return ((FBoolean) getAttrVal("Fg_setdef"));
	}	
	/**
	 * 套餐内项目标识
	 * @param Fg_setdef
	 */
	public void setFg_setdef(FBoolean Fg_setdef) {
		setAttrVal("Fg_setdef", Fg_setdef);
	}
	/**
	 * 定价模式
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	/**
	 * 定价模式编码
	 * @return String
	 */
	public String getSd_primd() {
		return ((String) getAttrVal("Sd_primd"));
	}	
	/**
	 * 定价模式编码
	 * @param Sd_primd
	 */
	public void setSd_primd(String Sd_primd) {
		setAttrVal("Sd_primd", Sd_primd);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 自定义服务名称标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ctm() {
		return ((FBoolean) getAttrVal("Fg_ctm"));
	}	
	/**
	 * 自定义服务名称标志
	 * @param Fg_ctm
	 */
	public void setFg_ctm(FBoolean Fg_ctm) {
		setAttrVal("Fg_ctm", Fg_ctm);
	}
	/**
	 * 医嘱可开立标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}	
	/**
	 * 医嘱可开立标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 医疗物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 医疗物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}	
	/**
	 * 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 价格描述
	 * @return String
	 */
	public String getDes_pri() {
		return ((String) getAttrVal("Des_pri"));
	}	
	/**
	 * 价格描述
	 * @param Des_pri
	 */
	public void setDes_pri(String Des_pri) {
		setAttrVal("Des_pri", Des_pri);
	}
	/**
	 * 网页显示标识
	 * @return FBoolean
	 */
	public FBoolean getFg_web() {
		return ((FBoolean) getAttrVal("Fg_web"));
	}	
	/**
	 * 网页显示标识
	 * @param Fg_web
	 */
	public void setFg_web(FBoolean Fg_web) {
		setAttrVal("Fg_web", Fg_web);
	}
	/**
	 * 检查目的
	 * @return String
	 */
	public String getPurpose() {
		return ((String) getAttrVal("Purpose"));
	}	
	/**
	 * 检查目的
	 * @param Purpose
	 */
	public void setPurpose(String Purpose) {
		setAttrVal("Purpose", Purpose);
	}
	/**
	 * 检查项目注意事项
	 * @return String
	 */
	public String getAttention() {
		return ((String) getAttrVal("Attention"));
	}	
	/**
	 * 检查项目注意事项
	 * @param Attention
	 */
	public void setAttention(String Attention) {
		setAttrVal("Attention", Attention);
	}
	/**
	 * 自付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_payself() {
		return ((FBoolean) getAttrVal("Fg_payself"));
	}	
	/**
	 * 自付标识
	 * @param Fg_payself
	 */
	public void setFg_payself(FBoolean Fg_payself) {
		setAttrVal("Fg_payself", Fg_payself);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 体检科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 体检科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 体检科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_sample() {
		return ((String) getAttrVal("Code_sample"));
	}	
	/**
	 * 编码
	 * @param Code_sample
	 */
	public void setCode_sample(String Code_sample) {
		setAttrVal("Code_sample", Code_sample);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sample() {
		return ((String) getAttrVal("Name_sample"));
	}	
	/**
	 * 名称
	 * @param Name_sample
	 */
	public void setName_sample(String Name_sample) {
		setAttrVal("Name_sample", Name_sample);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getSrvca_code() {
		return ((String) getAttrVal("Srvca_code"));
	}	
	/**
	 * 服务分类编码
	 * @param Srvca_code
	 */
	public void setSrvca_code(String Srvca_code) {
		setAttrVal("Srvca_code", Srvca_code);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getSrvca_name() {
		return ((String) getAttrVal("Srvca_name"));
	}	
	/**
	 * 服务分类名称
	 * @param Srvca_name
	 */
	public void setSrvca_name(String Srvca_name) {
		setAttrVal("Srvca_name", Srvca_name);
	}
	/**
	 * 默认服务类型编码
	 * @return String
	 */
	public String getCode_srvtp_ca() {
		return ((String) getAttrVal("Code_srvtp_ca"));
	}	
	/**
	 * 默认服务类型编码
	 * @param Code_srvtp_ca
	 */
	public void setCode_srvtp_ca(String Code_srvtp_ca) {
		setAttrVal("Code_srvtp_ca", Code_srvtp_ca);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_primd() {
		return ((String) getAttrVal("Code_primd"));
	}	
	/**
	 * 编码
	 * @param Code_primd
	 */
	public void setCode_primd(String Code_primd) {
		setAttrVal("Code_primd", Code_primd);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_primd() {
		return ((String) getAttrVal("Name_primd"));
	}	
	/**
	 * 名称
	 * @param Name_primd
	 */
	public void setName_primd(String Name_primd) {
		setAttrVal("Name_primd", Name_primd);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_srvtp() {
		return ((String) getAttrVal("Code_srvtp"));
	}	
	/**
	 * 编码
	 * @param Code_srvtp
	 */
	public void setCode_srvtp(String Code_srvtp) {
		setAttrVal("Code_srvtp", Code_srvtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
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
		return "Id_pesrvbcatlog";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvbcatlog";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvbCatlogDODesc.class);
	}
	
}