package iih.ems.eass.emde.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.eass.emde.d.desc.EmsDeDODesc;
import java.math.BigDecimal;

/**
 * 设备折旧记录 DO数据 
 * 
 */
public class EmsDeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//折旧记录主键
	public static final String ID_DE= "Id_de";
	//卡片主键
	public static final String ID_CARD= "Id_card";
	//资产名称
	public static final String CARD_NAME= "Card_name";
	//资产编号
	public static final String CARD_NO= "Card_no";
	//设备科室
	public static final String ID_DEPT= "Id_dept";
	//设备仓库
	public static final String ID_WH= "Id_wh";
	//设备分类
	public static final String ID_EMCA= "Id_emca";
	//设备分类编码
	public static final String CODE_EMCA= "Code_emca";
	//设备主键
	public static final String ID_EM= "Id_em";
	//资产原值
	public static final String SOURCE_PRICE= "Source_price";
	//资产净值
	public static final String NET_PRICE= "Net_price";
	//购入金额
	public static final String BUY_COST= "Buy_cost";
	//折旧方式
	public static final String ID_DETP= "Id_detp";
	//折旧年月
	public static final String DE_YM= "De_ym";
	//财务年月
	public static final String YEAR_MONTH= "Year_month";
	//月折折旧金额
	public static final String DE_MONTH_COST= "De_month_cost";
	//已折旧月份
	public static final String LESS_MONTH= "Less_month";
	//折旧年限
	public static final String DE_YEAR= "De_year";
	//产权性质
	public static final String RIGHT_TYPE= "Right_type";
	//设备来源
	public static final String ID_SOURCE= "Id_source";
	//设备来源编码
	public static final String SD_SOURCE= "Sd_source";
	//保管等级
	public static final String ID_STOR_LEVEL= "Id_stor_level";
	//保管等级编码
	public static final String SD_STOR_LEVEL= "Sd_stor_level";
	//保管科室
	public static final String ID_STOR_DEPT= "Id_stor_dept";
	//保管人
	public static final String ID_STOR_EMP= "Id_stor_emp";
	//操作人
	public static final String ID_OPER= "Id_oper";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//折旧日期
	public static final String DT_DE= "Dt_de";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//分类树内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//卡片名称
	public static final String NAME_CARD= "Name_card";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//仓库编码
	public static final String CODE_WH= "Code_wh";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//设备编码
	public static final String CODE_EM= "Code_em";
	//折旧名称
	public static final String NAME_GE= "Name_ge";
	//折旧编码
	public static final String CODE_GE= "Code_ge";
	//月计提比率
	public static final String MRATE_GE= "Mrate_ge";
	//年计提比率
	public static final String NRATE_GE= "Nrate_ge";
	//计算公式
	public static final String JSGS_GE= "Jsgs_ge";
	//名称
	public static final String NAME_SOURCE= "Name_source";
	//名称
	public static final String NAME_STOR_LEVEL= "Name_stor_level";
	//名称
	public static final String NAME_STOR_DEPT= "Name_stor_dept";
	//姓名
	public static final String NAME_STOR_EMP= "Name_stor_emp";
	//姓名
	public static final String NAME_OPER= "Name_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 折旧记录主键
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 折旧记录主键
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 卡片主键
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 卡片主键
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 资产名称
	 * @return String
	 */
	public String getCard_name() {
		return ((String) getAttrVal("Card_name"));
	}	
	/**
	 * 资产名称
	 * @param Card_name
	 */
	public void setCard_name(String Card_name) {
		setAttrVal("Card_name", Card_name);
	}
	/**
	 * 资产编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 资产编号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 设备科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 设备科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 设备仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 设备仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 设备分类
	 * @return String
	 */
	public String getId_emca() {
		return ((String) getAttrVal("Id_emca"));
	}	
	/**
	 * 设备分类
	 * @param Id_emca
	 */
	public void setId_emca(String Id_emca) {
		setAttrVal("Id_emca", Id_emca);
	}
	/**
	 * 设备分类编码
	 * @return String
	 */
	public String getCode_emca() {
		return ((String) getAttrVal("Code_emca"));
	}	
	/**
	 * 设备分类编码
	 * @param Code_emca
	 */
	public void setCode_emca(String Code_emca) {
		setAttrVal("Code_emca", Code_emca);
	}
	/**
	 * 设备主键
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备主键
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 资产原值
	 * @return FDouble
	 */
	public FDouble getSource_price() {
		return ((FDouble) getAttrVal("Source_price"));
	}	
	/**
	 * 资产原值
	 * @param Source_price
	 */
	public void setSource_price(FDouble Source_price) {
		setAttrVal("Source_price", Source_price);
	}
	/**
	 * 资产净值
	 * @return FDouble
	 */
	public FDouble getNet_price() {
		return ((FDouble) getAttrVal("Net_price"));
	}	
	/**
	 * 资产净值
	 * @param Net_price
	 */
	public void setNet_price(FDouble Net_price) {
		setAttrVal("Net_price", Net_price);
	}
	/**
	 * 购入金额
	 * @return FDouble
	 */
	public FDouble getBuy_cost() {
		return ((FDouble) getAttrVal("Buy_cost"));
	}	
	/**
	 * 购入金额
	 * @param Buy_cost
	 */
	public void setBuy_cost(FDouble Buy_cost) {
		setAttrVal("Buy_cost", Buy_cost);
	}
	/**
	 * 折旧方式
	 * @return String
	 */
	public String getId_detp() {
		return ((String) getAttrVal("Id_detp"));
	}	
	/**
	 * 折旧方式
	 * @param Id_detp
	 */
	public void setId_detp(String Id_detp) {
		setAttrVal("Id_detp", Id_detp);
	}
	/**
	 * 折旧年月
	 * @return String
	 */
	public String getDe_ym() {
		return ((String) getAttrVal("De_ym"));
	}	
	/**
	 * 折旧年月
	 * @param De_ym
	 */
	public void setDe_ym(String De_ym) {
		setAttrVal("De_ym", De_ym);
	}
	/**
	 * 财务年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 财务年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	/**
	 * 月折折旧金额
	 * @return FDouble
	 */
	public FDouble getDe_month_cost() {
		return ((FDouble) getAttrVal("De_month_cost"));
	}	
	/**
	 * 月折折旧金额
	 * @param De_month_cost
	 */
	public void setDe_month_cost(FDouble De_month_cost) {
		setAttrVal("De_month_cost", De_month_cost);
	}
	/**
	 * 已折旧月份
	 * @return Integer
	 */
	public Integer getLess_month() {
		return ((Integer) getAttrVal("Less_month"));
	}	
	/**
	 * 已折旧月份
	 * @param Less_month
	 */
	public void setLess_month(Integer Less_month) {
		setAttrVal("Less_month", Less_month);
	}
	/**
	 * 折旧年限
	 * @return Integer
	 */
	public Integer getDe_year() {
		return ((Integer) getAttrVal("De_year"));
	}	
	/**
	 * 折旧年限
	 * @param De_year
	 */
	public void setDe_year(Integer De_year) {
		setAttrVal("De_year", De_year);
	}
	/**
	 * 产权性质
	 * @return String
	 */
	public String getRight_type() {
		return ((String) getAttrVal("Right_type"));
	}	
	/**
	 * 产权性质
	 * @param Right_type
	 */
	public void setRight_type(String Right_type) {
		setAttrVal("Right_type", Right_type);
	}
	/**
	 * 设备来源
	 * @return String
	 */
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}	
	/**
	 * 设备来源
	 * @param Id_source
	 */
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
	}
	/**
	 * 设备来源编码
	 * @return String
	 */
	public String getSd_source() {
		return ((String) getAttrVal("Sd_source"));
	}	
	/**
	 * 设备来源编码
	 * @param Sd_source
	 */
	public void setSd_source(String Sd_source) {
		setAttrVal("Sd_source", Sd_source);
	}
	/**
	 * 保管等级
	 * @return String
	 */
	public String getId_stor_level() {
		return ((String) getAttrVal("Id_stor_level"));
	}	
	/**
	 * 保管等级
	 * @param Id_stor_level
	 */
	public void setId_stor_level(String Id_stor_level) {
		setAttrVal("Id_stor_level", Id_stor_level);
	}
	/**
	 * 保管等级编码
	 * @return String
	 */
	public String getSd_stor_level() {
		return ((String) getAttrVal("Sd_stor_level"));
	}	
	/**
	 * 保管等级编码
	 * @param Sd_stor_level
	 */
	public void setSd_stor_level(String Sd_stor_level) {
		setAttrVal("Sd_stor_level", Sd_stor_level);
	}
	/**
	 * 保管科室
	 * @return String
	 */
	public String getId_stor_dept() {
		return ((String) getAttrVal("Id_stor_dept"));
	}	
	/**
	 * 保管科室
	 * @param Id_stor_dept
	 */
	public void setId_stor_dept(String Id_stor_dept) {
		setAttrVal("Id_stor_dept", Id_stor_dept);
	}
	/**
	 * 保管人
	 * @return String
	 */
	public String getId_stor_emp() {
		return ((String) getAttrVal("Id_stor_emp"));
	}	
	/**
	 * 保管人
	 * @param Id_stor_emp
	 */
	public void setId_stor_emp(String Id_stor_emp) {
		setAttrVal("Id_stor_emp", Id_stor_emp);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	/**
	 * 操作人
	 * @param Id_oper
	 */
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 折旧日期
	 * @return FDate
	 */
	public FDate getDt_de() {
		return ((FDate) getAttrVal("Dt_de"));
	}	
	/**
	 * 折旧日期
	 * @param Dt_de
	 */
	public void setDt_de(FDate Dt_de) {
		setAttrVal("Dt_de", Dt_de);
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
	 * 分类树内码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 分类树内码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
	}
	/**
	 * 卡片名称
	 * @return String
	 */
	public String getName_card() {
		return ((String) getAttrVal("Name_card"));
	}	
	/**
	 * 卡片名称
	 * @param Name_card
	 */
	public void setName_card(String Name_card) {
		setAttrVal("Name_card", Name_card);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 仓库编码
	 * @return String
	 */
	public String getCode_wh() {
		return ((String) getAttrVal("Code_wh"));
	}	
	/**
	 * 仓库编码
	 * @param Code_wh
	 */
	public void setCode_wh(String Code_wh) {
		setAttrVal("Code_wh", Code_wh);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_wh() {
		return ((String) getAttrVal("Name_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_wh
	 */
	public void setName_wh(String Name_wh) {
		setAttrVal("Name_wh", Name_wh);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getName_em() {
		return ((String) getAttrVal("Name_em"));
	}	
	/**
	 * 设备名称
	 * @param Name_em
	 */
	public void setName_em(String Name_em) {
		setAttrVal("Name_em", Name_em);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getCode_em() {
		return ((String) getAttrVal("Code_em"));
	}	
	/**
	 * 设备编码
	 * @param Code_em
	 */
	public void setCode_em(String Code_em) {
		setAttrVal("Code_em", Code_em);
	}
	/**
	 * 折旧名称
	 * @return String
	 */
	public String getName_ge() {
		return ((String) getAttrVal("Name_ge"));
	}	
	/**
	 * 折旧名称
	 * @param Name_ge
	 */
	public void setName_ge(String Name_ge) {
		setAttrVal("Name_ge", Name_ge);
	}
	/**
	 * 折旧编码
	 * @return String
	 */
	public String getCode_ge() {
		return ((String) getAttrVal("Code_ge"));
	}	
	/**
	 * 折旧编码
	 * @param Code_ge
	 */
	public void setCode_ge(String Code_ge) {
		setAttrVal("Code_ge", Code_ge);
	}
	/**
	 * 月计提比率
	 * @return FDouble
	 */
	public FDouble getMrate_ge() {
		return ((FDouble) getAttrVal("Mrate_ge"));
	}	
	/**
	 * 月计提比率
	 * @param Mrate_ge
	 */
	public void setMrate_ge(FDouble Mrate_ge) {
		setAttrVal("Mrate_ge", Mrate_ge);
	}
	/**
	 * 年计提比率
	 * @return FDouble
	 */
	public FDouble getNrate_ge() {
		return ((FDouble) getAttrVal("Nrate_ge"));
	}	
	/**
	 * 年计提比率
	 * @param Nrate_ge
	 */
	public void setNrate_ge(FDouble Nrate_ge) {
		setAttrVal("Nrate_ge", Nrate_ge);
	}
	/**
	 * 计算公式
	 * @return String
	 */
	public String getJsgs_ge() {
		return ((String) getAttrVal("Jsgs_ge"));
	}	
	/**
	 * 计算公式
	 * @param Jsgs_ge
	 */
	public void setJsgs_ge(String Jsgs_ge) {
		setAttrVal("Jsgs_ge", Jsgs_ge);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_source() {
		return ((String) getAttrVal("Name_source"));
	}	
	/**
	 * 名称
	 * @param Name_source
	 */
	public void setName_source(String Name_source) {
		setAttrVal("Name_source", Name_source);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stor_level() {
		return ((String) getAttrVal("Name_stor_level"));
	}	
	/**
	 * 名称
	 * @param Name_stor_level
	 */
	public void setName_stor_level(String Name_stor_level) {
		setAttrVal("Name_stor_level", Name_stor_level);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stor_dept() {
		return ((String) getAttrVal("Name_stor_dept"));
	}	
	/**
	 * 名称
	 * @param Name_stor_dept
	 */
	public void setName_stor_dept(String Name_stor_dept) {
		setAttrVal("Name_stor_dept", Name_stor_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_stor_emp() {
		return ((String) getAttrVal("Name_stor_emp"));
	}	
	/**
	 * 姓名
	 * @param Name_stor_emp
	 */
	public void setName_stor_emp(String Name_stor_emp) {
		setAttrVal("Name_stor_emp", Name_stor_emp);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_oper
	 */
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
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
		return "Id_de";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_de";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsDeDODesc.class);
	}
	
}