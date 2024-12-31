package iih.ems.eass.emcard.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.eass.emcard.d.desc.EmCardDODesc;
import java.math.BigDecimal;

/**
 * 资产卡片 DO数据 
 * 
 */
public class EmCardDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//资产卡主键
	public static final String ID_CARD= "Id_card";
	//卡片编号
	public static final String CARD_NO= "Card_no";
	//卡片名称
	public static final String NAME= "Name";
	//使用科室编码
	public static final String ID_DEPT= "Id_dept";
	//设备基本信息
	public static final String ID_EM= "Id_em";
	//是否计量
	public static final String FG_GAUGE= "Fg_gauge";
	//计量仪器分类
	public static final String ID_GAUGE_CA= "Id_gauge_ca";
	//是否自制
	public static final String FG_SELF= "Fg_self";
	//经费来源
	public static final String ID_FEE_SOURCE= "Id_fee_source";
	//经费来源编码
	public static final String SD_FEE_SOURCE= "Sd_fee_source";
	//设备来源
	public static final String ID_EQU_SOURCE= "Id_equ_source";
	//设备来源编码
	public static final String SD_EQU_SOURCE= "Sd_equ_source";
	//产权性质
	public static final String RIGHT_TYPE= "Right_type";
	//国家名称
	public static final String COUNTRY= "Country";
	//出厂编号
	public static final String BARCODE= "Barcode";
	//生产日期
	public static final String DT_FAC= "Dt_fac";
	//合同编号
	public static final String PACT_CODE= "Pact_code";
	//资产用途
	public static final String ID_USE= "Id_use";
	//资产用途编码
	public static final String SD_USE= "Sd_use";
	//资产原值
	public static final String SOURCE_PRICE= "Source_price";
	//资产净值
	public static final String NET_PRICE= "Net_price";
	//资产残值
	public static final String LEAVE_PRICE= "Leave_price";
	//初始数量
	public static final String INIT_NUM= "Init_num";
	//购入单价
	public static final String BUY_PRICE= "Buy_price";
	//购入金额
	public static final String BUY_COST= "Buy_cost";
	//折旧方式
	public static final String ID_DE= "Id_de";
	//折旧年限
	public static final String DE_YEAR= "De_year";
	//已折旧月份
	public static final String LESS_MONTH= "Less_month";
	//月折旧金额
	public static final String DE_MONTH_COST= "De_month_cost";
	//最新折旧时间
	public static final String DT_DE_OPER= "Dt_de_oper";
	//维修次数
	public static final String REPAIR_NUM= "Repair_num";
	//维修费用
	public static final String REPAIR_COST= "Repair_cost";
	//资产建卡状态
	public static final String ID_CARD_ST= "Id_card_st";
	//资产建卡状态编码
	public static final String SD_CARD_ST= "Sd_card_st";
	//资产状态
	public static final String ID_STATE= "Id_state";
	//资产状态编码
	public static final String SD_STATE= "Sd_state";
	//预计净残值
	public static final String PRE_NET_PRICE= "Pre_net_price";
	//保修截止日期
	public static final String DT_REPAIR_END= "Dt_repair_end";
	//维修联系方式
	public static final String REPAIR_CONTACT= "Repair_contact";
	//品牌名称
	public static final String BRAND_NAME= "Brand_name";
	//卡片备注信息
	public static final String REMARK= "Remark";
	//仓库
	public static final String ID_WH= "Id_wh";
	//入库单主键
	public static final String ID_IN= "Id_in";
	//入库单细目主键
	public static final String ID_INITM= "Id_initm";
	//保管等级
	public static final String ID_STOR_LEVEL= "Id_stor_level";
	//保管等级编码
	public static final String SD_STOR_LEVEL= "Sd_stor_level";
	//保管科室
	public static final String ID_STOR_DEPT= "Id_stor_dept";
	//领用日期
	public static final String DT_GET= "Dt_get";
	//保管人
	public static final String ID_STOR_EMP= "Id_stor_emp";
	//启用日期
	public static final String DT_START= "Dt_start";
	//是否新设备
	public static final String FG_NEW= "Fg_new";
	//是否需要付款
	public static final String FG_PAY= "Fg_pay";
	//是否含有附件
	public static final String FG_ANNEX= "Fg_annex";
	//附件信息说明
	public static final String ANNEX_NOTE= "Annex_note";
	//是否进口
	public static final String FG_IMPORT= "Fg_import";
	//进口信息说明
	public static final String IMPORT_NOTE= "Import_note";
	//是否是设备附件
	public static final String FG_PART= "Fg_part";
	//设备附件对应的主设备
	public static final String ID_CARD_PARENT= "Id_card_parent";
	//卡片录入类型
	public static final String ID_ENTER_TYPE= "Id_enter_type";
	//卡片录入类型编码
	public static final String SD_ENTER_TYPE= "Sd_enter_type";
	//登记人
	public static final String ID_REG_OPER= "Id_reg_oper";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//保养周期（天）
	public static final String UPKEEP_CYC= "Upkeep_cyc";
	//首次保养日期
	public static final String DT_UPKEEP_FIRST= "Dt_upkeep_first";
	//上次保养日期
	public static final String DT_UPKEEP_LAST= "Dt_upkeep_last";
	//下次保养日期
	public static final String DT_UPKEEP_NEXT= "Dt_upkeep_next";
	//计量周期（天）
	public static final String GAUGE_CYC= "Gauge_cyc";
	//上次计量时间
	public static final String DT_LAST_GAUGE= "Dt_last_gauge";
	//下次计量时间
	public static final String DT_NEXT_GAUGE= "Dt_next_gauge";
	//是否固定资产
	public static final String FG_FIXED= "Fg_fixed";
	//维修信息
	public static final String MAINTENANCEINFO= "Maintenanceinfo";
	//使用年限
	public static final String USEFULLIFE= "Usefullife";
	//是否打印条码
	public static final String FG_PRINT= "Fg_print";
	//是否急救设备
	public static final String FG_ISAIDEQU= "Fg_isaidequ";
	//发票号
	public static final String INV_NO= "Inv_no";
	//发票日期
	public static final String DT_INV= "Dt_inv";
	//凭证字
	public static final String VOUCHER_WORD= "Voucher_word";
	//停止折旧月份
	public static final String STOP_MONTHS= "Stop_months";
	//最近停止折旧时间
	public static final String DT_LAST_STOPDE= "Dt_last_stopde";
	//最近重新启用折旧时间
	public static final String DT_LAST_RESTARTDE= "Dt_last_restartde";
	//是否停止折旧
	public static final String FG_STOPDEP= "Fg_stopdep";
	//是否顺延折旧年限
	public static final String FG_POSTPONE= "Fg_postpone";
	//最近停用或启用操作员
	public static final String ID_LAST_OPER= "Id_last_oper";
	//保管地点
	public static final String SAVE_PLACE= "Save_place";
	//卫生部编码
	public static final String MOH_CODE= "Moh_code";
	//政府编码
	public static final String GOVER_CODE= "Gover_code";
	//档案编号
	public static final String FILENO= "Fileno";
	//医疗设备标准名称
	public static final String STANDARNAME= "Standarname";
	//财务编码
	public static final String ACCOUNT_NO= "Account_no";
	//计量编号
	public static final String GAUGE_NO= "Gauge_no";
	//条码是否已经打印
	public static final String FG_PRINTED= "Fg_printed";
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
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//审批意见
	public static final String APPOP= "Appop";
	//设备分类内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//设备分类
	public static final String ID_EMCA= "Id_emca";
	//是否失效
	public static final String FG_AVAIL= "Fg_avail";
	//批次
	public static final String BATCH= "Batch";
	//财务年月
	public static final String YEAR_MONTH= "Year_month";
	//是否出库
	public static final String FG_OUT= "Fg_out";
	//出库日期
	public static final String DT_OUT= "Dt_out";
	//出库主键
	public static final String ID_OUT= "Id_out";
	//出库细目主键
	public static final String ID_OUT_ITM= "Id_out_itm";
	//入帐审核状态
	public static final String ID_STU= "Id_stu";
	//入帐审核状态编码
	public static final String SD_STU= "Sd_stu";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//规格
	public static final String SPECS= "Specs";
	//入库单号
	public static final String IN_CODE= "In_code";
	//出库单号
	public static final String OUT_CODE= "Out_code";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//设备编码
	public static final String CODE_EM= "Code_em";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//编码
	public static final String CODE_GA= "Code_ga";
	//名称
	public static final String NAME_GA= "Name_ga";
	//名称
	public static final String NAME_SOURCE= "Name_source";
	//名称
	public static final String NAME_SOURCE_FEE= "Name_source_fee";
	//名称
	public static final String NAME_USE= "Name_use";
	//折旧名称
	public static final String NAME_DE= "Name_de";
	//折旧编码
	public static final String CODE_DE= "Code_de";
	//名称
	public static final String NAME_CARD_ST= "Name_card_st";
	//编码
	public static final String CODE_CARD_ST= "Code_card_st";
	//名称
	public static final String NAME_STATE= "Name_state";
	//编码
	public static final String CODE_STATE= "Code_state";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//名称
	public static final String NAME_STOR_LEVEL= "Name_stor_level";
	//名称
	public static final String NAME_STOR_DEPT= "Name_stor_dept";
	//姓名
	public static final String NAME_STOR_EMP= "Name_stor_emp";
	//卡片名称
	public static final String NAME_CARD_PARENT= "Name_card_parent";
	//卡片编号
	public static final String CARD_NO_PARENT= "Card_no_parent";
	//名称
	public static final String NAME_ENTER_TYPE= "Name_enter_type";
	//姓名
	public static final String NAME_REG_OPER= "Name_reg_oper";
	//姓名
	public static final String NAME_LAST_OPER= "Name_last_oper";
	//名称
	public static final String NAME_EMCA= "Name_emca";
	//名称
	public static final String NAME_STU= "Name_stu";
	//供应商与厂商名称
	public static final String NAME_SUP= "Name_sup";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 资产卡主键
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 资产卡主键
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 卡片编号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 卡片名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 卡片名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 使用科室编码
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 使用科室编码
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 设备基本信息
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备基本信息
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 是否计量
	 * @return FBoolean
	 */
	public FBoolean getFg_gauge() {
		return ((FBoolean) getAttrVal("Fg_gauge"));
	}	
	/**
	 * 是否计量
	 * @param Fg_gauge
	 */
	public void setFg_gauge(FBoolean Fg_gauge) {
		setAttrVal("Fg_gauge", Fg_gauge);
	}
	/**
	 * 计量仪器分类
	 * @return String
	 */
	public String getId_gauge_ca() {
		return ((String) getAttrVal("Id_gauge_ca"));
	}	
	/**
	 * 计量仪器分类
	 * @param Id_gauge_ca
	 */
	public void setId_gauge_ca(String Id_gauge_ca) {
		setAttrVal("Id_gauge_ca", Id_gauge_ca);
	}
	/**
	 * 是否自制
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	/**
	 * 是否自制
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 经费来源
	 * @return String
	 */
	public String getId_fee_source() {
		return ((String) getAttrVal("Id_fee_source"));
	}	
	/**
	 * 经费来源
	 * @param Id_fee_source
	 */
	public void setId_fee_source(String Id_fee_source) {
		setAttrVal("Id_fee_source", Id_fee_source);
	}
	/**
	 * 经费来源编码
	 * @return String
	 */
	public String getSd_fee_source() {
		return ((String) getAttrVal("Sd_fee_source"));
	}	
	/**
	 * 经费来源编码
	 * @param Sd_fee_source
	 */
	public void setSd_fee_source(String Sd_fee_source) {
		setAttrVal("Sd_fee_source", Sd_fee_source);
	}
	/**
	 * 设备来源
	 * @return String
	 */
	public String getId_equ_source() {
		return ((String) getAttrVal("Id_equ_source"));
	}	
	/**
	 * 设备来源
	 * @param Id_equ_source
	 */
	public void setId_equ_source(String Id_equ_source) {
		setAttrVal("Id_equ_source", Id_equ_source);
	}
	/**
	 * 设备来源编码
	 * @return String
	 */
	public String getSd_equ_source() {
		return ((String) getAttrVal("Sd_equ_source"));
	}	
	/**
	 * 设备来源编码
	 * @param Sd_equ_source
	 */
	public void setSd_equ_source(String Sd_equ_source) {
		setAttrVal("Sd_equ_source", Sd_equ_source);
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
	 * 国家名称
	 * @return String
	 */
	public String getCountry() {
		return ((String) getAttrVal("Country"));
	}	
	/**
	 * 国家名称
	 * @param Country
	 */
	public void setCountry(String Country) {
		setAttrVal("Country", Country);
	}
	/**
	 * 出厂编号
	 * @return String
	 */
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}	
	/**
	 * 出厂编号
	 * @param Barcode
	 */
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
	}
	/**
	 * 生产日期
	 * @return FDate
	 */
	public FDate getDt_fac() {
		return ((FDate) getAttrVal("Dt_fac"));
	}	
	/**
	 * 生产日期
	 * @param Dt_fac
	 */
	public void setDt_fac(FDate Dt_fac) {
		setAttrVal("Dt_fac", Dt_fac);
	}
	/**
	 * 合同编号
	 * @return String
	 */
	public String getPact_code() {
		return ((String) getAttrVal("Pact_code"));
	}	
	/**
	 * 合同编号
	 * @param Pact_code
	 */
	public void setPact_code(String Pact_code) {
		setAttrVal("Pact_code", Pact_code);
	}
	/**
	 * 资产用途
	 * @return String
	 */
	public String getId_use() {
		return ((String) getAttrVal("Id_use"));
	}	
	/**
	 * 资产用途
	 * @param Id_use
	 */
	public void setId_use(String Id_use) {
		setAttrVal("Id_use", Id_use);
	}
	/**
	 * 资产用途编码
	 * @return String
	 */
	public String getSd_use() {
		return ((String) getAttrVal("Sd_use"));
	}	
	/**
	 * 资产用途编码
	 * @param Sd_use
	 */
	public void setSd_use(String Sd_use) {
		setAttrVal("Sd_use", Sd_use);
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
	 * 资产残值
	 * @return FDouble
	 */
	public FDouble getLeave_price() {
		return ((FDouble) getAttrVal("Leave_price"));
	}	
	/**
	 * 资产残值
	 * @param Leave_price
	 */
	public void setLeave_price(FDouble Leave_price) {
		setAttrVal("Leave_price", Leave_price);
	}
	/**
	 * 初始数量
	 * @return Integer
	 */
	public Integer getInit_num() {
		return ((Integer) getAttrVal("Init_num"));
	}	
	/**
	 * 初始数量
	 * @param Init_num
	 */
	public void setInit_num(Integer Init_num) {
		setAttrVal("Init_num", Init_num);
	}
	/**
	 * 购入单价
	 * @return FDouble
	 */
	public FDouble getBuy_price() {
		return ((FDouble) getAttrVal("Buy_price"));
	}	
	/**
	 * 购入单价
	 * @param Buy_price
	 */
	public void setBuy_price(FDouble Buy_price) {
		setAttrVal("Buy_price", Buy_price);
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
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 折旧方式
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
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
	 * 月折旧金额
	 * @return FDouble
	 */
	public FDouble getDe_month_cost() {
		return ((FDouble) getAttrVal("De_month_cost"));
	}	
	/**
	 * 月折旧金额
	 * @param De_month_cost
	 */
	public void setDe_month_cost(FDouble De_month_cost) {
		setAttrVal("De_month_cost", De_month_cost);
	}
	/**
	 * 最新折旧时间
	 * @return FDate
	 */
	public FDate getDt_de_oper() {
		return ((FDate) getAttrVal("Dt_de_oper"));
	}	
	/**
	 * 最新折旧时间
	 * @param Dt_de_oper
	 */
	public void setDt_de_oper(FDate Dt_de_oper) {
		setAttrVal("Dt_de_oper", Dt_de_oper);
	}
	/**
	 * 维修次数
	 * @return Integer
	 */
	public Integer getRepair_num() {
		return ((Integer) getAttrVal("Repair_num"));
	}	
	/**
	 * 维修次数
	 * @param Repair_num
	 */
	public void setRepair_num(Integer Repair_num) {
		setAttrVal("Repair_num", Repair_num);
	}
	/**
	 * 维修费用
	 * @return FDouble
	 */
	public FDouble getRepair_cost() {
		return ((FDouble) getAttrVal("Repair_cost"));
	}	
	/**
	 * 维修费用
	 * @param Repair_cost
	 */
	public void setRepair_cost(FDouble Repair_cost) {
		setAttrVal("Repair_cost", Repair_cost);
	}
	/**
	 * 资产建卡状态
	 * @return String
	 */
	public String getId_card_st() {
		return ((String) getAttrVal("Id_card_st"));
	}	
	/**
	 * 资产建卡状态
	 * @param Id_card_st
	 */
	public void setId_card_st(String Id_card_st) {
		setAttrVal("Id_card_st", Id_card_st);
	}
	/**
	 * 资产建卡状态编码
	 * @return String
	 */
	public String getSd_card_st() {
		return ((String) getAttrVal("Sd_card_st"));
	}	
	/**
	 * 资产建卡状态编码
	 * @param Sd_card_st
	 */
	public void setSd_card_st(String Sd_card_st) {
		setAttrVal("Sd_card_st", Sd_card_st);
	}
	/**
	 * 资产状态
	 * @return String
	 */
	public String getId_state() {
		return ((String) getAttrVal("Id_state"));
	}	
	/**
	 * 资产状态
	 * @param Id_state
	 */
	public void setId_state(String Id_state) {
		setAttrVal("Id_state", Id_state);
	}
	/**
	 * 资产状态编码
	 * @return String
	 */
	public String getSd_state() {
		return ((String) getAttrVal("Sd_state"));
	}	
	/**
	 * 资产状态编码
	 * @param Sd_state
	 */
	public void setSd_state(String Sd_state) {
		setAttrVal("Sd_state", Sd_state);
	}
	/**
	 * 预计净残值
	 * @return FDouble
	 */
	public FDouble getPre_net_price() {
		return ((FDouble) getAttrVal("Pre_net_price"));
	}	
	/**
	 * 预计净残值
	 * @param Pre_net_price
	 */
	public void setPre_net_price(FDouble Pre_net_price) {
		setAttrVal("Pre_net_price", Pre_net_price);
	}
	/**
	 * 保修截止日期
	 * @return FDate
	 */
	public FDate getDt_repair_end() {
		return ((FDate) getAttrVal("Dt_repair_end"));
	}	
	/**
	 * 保修截止日期
	 * @param Dt_repair_end
	 */
	public void setDt_repair_end(FDate Dt_repair_end) {
		setAttrVal("Dt_repair_end", Dt_repair_end);
	}
	/**
	 * 维修联系方式
	 * @return String
	 */
	public String getRepair_contact() {
		return ((String) getAttrVal("Repair_contact"));
	}	
	/**
	 * 维修联系方式
	 * @param Repair_contact
	 */
	public void setRepair_contact(String Repair_contact) {
		setAttrVal("Repair_contact", Repair_contact);
	}
	/**
	 * 品牌名称
	 * @return String
	 */
	public String getBrand_name() {
		return ((String) getAttrVal("Brand_name"));
	}	
	/**
	 * 品牌名称
	 * @param Brand_name
	 */
	public void setBrand_name(String Brand_name) {
		setAttrVal("Brand_name", Brand_name);
	}
	/**
	 * 卡片备注信息
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 卡片备注信息
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 入库单主键
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	/**
	 * 入库单主键
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
	}
	/**
	 * 入库单细目主键
	 * @return String
	 */
	public String getId_initm() {
		return ((String) getAttrVal("Id_initm"));
	}	
	/**
	 * 入库单细目主键
	 * @param Id_initm
	 */
	public void setId_initm(String Id_initm) {
		setAttrVal("Id_initm", Id_initm);
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
	 * 领用日期
	 * @return FDate
	 */
	public FDate getDt_get() {
		return ((FDate) getAttrVal("Dt_get"));
	}	
	/**
	 * 领用日期
	 * @param Dt_get
	 */
	public void setDt_get(FDate Dt_get) {
		setAttrVal("Dt_get", Dt_get);
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
	 * 启用日期
	 * @return FDate
	 */
	public FDate getDt_start() {
		return ((FDate) getAttrVal("Dt_start"));
	}	
	/**
	 * 启用日期
	 * @param Dt_start
	 */
	public void setDt_start(FDate Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 是否新设备
	 * @return FBoolean
	 */
	public FBoolean getFg_new() {
		return ((FBoolean) getAttrVal("Fg_new"));
	}	
	/**
	 * 是否新设备
	 * @param Fg_new
	 */
	public void setFg_new(FBoolean Fg_new) {
		setAttrVal("Fg_new", Fg_new);
	}
	/**
	 * 是否需要付款
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}	
	/**
	 * 是否需要付款
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
	/**
	 * 是否含有附件
	 * @return FBoolean
	 */
	public FBoolean getFg_annex() {
		return ((FBoolean) getAttrVal("Fg_annex"));
	}	
	/**
	 * 是否含有附件
	 * @param Fg_annex
	 */
	public void setFg_annex(FBoolean Fg_annex) {
		setAttrVal("Fg_annex", Fg_annex);
	}
	/**
	 * 附件信息说明
	 * @return String
	 */
	public String getAnnex_note() {
		return ((String) getAttrVal("Annex_note"));
	}	
	/**
	 * 附件信息说明
	 * @param Annex_note
	 */
	public void setAnnex_note(String Annex_note) {
		setAttrVal("Annex_note", Annex_note);
	}
	/**
	 * 是否进口
	 * @return FBoolean
	 */
	public FBoolean getFg_import() {
		return ((FBoolean) getAttrVal("Fg_import"));
	}	
	/**
	 * 是否进口
	 * @param Fg_import
	 */
	public void setFg_import(FBoolean Fg_import) {
		setAttrVal("Fg_import", Fg_import);
	}
	/**
	 * 进口信息说明
	 * @return String
	 */
	public String getImport_note() {
		return ((String) getAttrVal("Import_note"));
	}	
	/**
	 * 进口信息说明
	 * @param Import_note
	 */
	public void setImport_note(String Import_note) {
		setAttrVal("Import_note", Import_note);
	}
	/**
	 * 是否是设备附件
	 * @return FBoolean
	 */
	public FBoolean getFg_part() {
		return ((FBoolean) getAttrVal("Fg_part"));
	}	
	/**
	 * 是否是设备附件
	 * @param Fg_part
	 */
	public void setFg_part(FBoolean Fg_part) {
		setAttrVal("Fg_part", Fg_part);
	}
	/**
	 * 设备附件对应的主设备
	 * @return String
	 */
	public String getId_card_parent() {
		return ((String) getAttrVal("Id_card_parent"));
	}	
	/**
	 * 设备附件对应的主设备
	 * @param Id_card_parent
	 */
	public void setId_card_parent(String Id_card_parent) {
		setAttrVal("Id_card_parent", Id_card_parent);
	}
	/**
	 * 卡片录入类型
	 * @return String
	 */
	public String getId_enter_type() {
		return ((String) getAttrVal("Id_enter_type"));
	}	
	/**
	 * 卡片录入类型
	 * @param Id_enter_type
	 */
	public void setId_enter_type(String Id_enter_type) {
		setAttrVal("Id_enter_type", Id_enter_type);
	}
	/**
	 * 卡片录入类型编码
	 * @return String
	 */
	public String getSd_enter_type() {
		return ((String) getAttrVal("Sd_enter_type"));
	}	
	/**
	 * 卡片录入类型编码
	 * @param Sd_enter_type
	 */
	public void setSd_enter_type(String Sd_enter_type) {
		setAttrVal("Sd_enter_type", Sd_enter_type);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg_oper() {
		return ((String) getAttrVal("Id_reg_oper"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_oper
	 */
	public void setId_reg_oper(String Id_reg_oper) {
		setAttrVal("Id_reg_oper", Id_reg_oper);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 保养周期（天）
	 * @return Integer
	 */
	public Integer getUpkeep_cyc() {
		return ((Integer) getAttrVal("Upkeep_cyc"));
	}	
	/**
	 * 保养周期（天）
	 * @param Upkeep_cyc
	 */
	public void setUpkeep_cyc(Integer Upkeep_cyc) {
		setAttrVal("Upkeep_cyc", Upkeep_cyc);
	}
	/**
	 * 首次保养日期
	 * @return FDate
	 */
	public FDate getDt_upkeep_first() {
		return ((FDate) getAttrVal("Dt_upkeep_first"));
	}	
	/**
	 * 首次保养日期
	 * @param Dt_upkeep_first
	 */
	public void setDt_upkeep_first(FDate Dt_upkeep_first) {
		setAttrVal("Dt_upkeep_first", Dt_upkeep_first);
	}
	/**
	 * 上次保养日期
	 * @return FDate
	 */
	public FDate getDt_upkeep_last() {
		return ((FDate) getAttrVal("Dt_upkeep_last"));
	}	
	/**
	 * 上次保养日期
	 * @param Dt_upkeep_last
	 */
	public void setDt_upkeep_last(FDate Dt_upkeep_last) {
		setAttrVal("Dt_upkeep_last", Dt_upkeep_last);
	}
	/**
	 * 下次保养日期
	 * @return FDate
	 */
	public FDate getDt_upkeep_next() {
		return ((FDate) getAttrVal("Dt_upkeep_next"));
	}	
	/**
	 * 下次保养日期
	 * @param Dt_upkeep_next
	 */
	public void setDt_upkeep_next(FDate Dt_upkeep_next) {
		setAttrVal("Dt_upkeep_next", Dt_upkeep_next);
	}
	/**
	 * 计量周期（天）
	 * @return Integer
	 */
	public Integer getGauge_cyc() {
		return ((Integer) getAttrVal("Gauge_cyc"));
	}	
	/**
	 * 计量周期（天）
	 * @param Gauge_cyc
	 */
	public void setGauge_cyc(Integer Gauge_cyc) {
		setAttrVal("Gauge_cyc", Gauge_cyc);
	}
	/**
	 * 上次计量时间
	 * @return FDate
	 */
	public FDate getDt_last_gauge() {
		return ((FDate) getAttrVal("Dt_last_gauge"));
	}	
	/**
	 * 上次计量时间
	 * @param Dt_last_gauge
	 */
	public void setDt_last_gauge(FDate Dt_last_gauge) {
		setAttrVal("Dt_last_gauge", Dt_last_gauge);
	}
	/**
	 * 下次计量时间
	 * @return FDate
	 */
	public FDate getDt_next_gauge() {
		return ((FDate) getAttrVal("Dt_next_gauge"));
	}	
	/**
	 * 下次计量时间
	 * @param Dt_next_gauge
	 */
	public void setDt_next_gauge(FDate Dt_next_gauge) {
		setAttrVal("Dt_next_gauge", Dt_next_gauge);
	}
	/**
	 * 是否固定资产
	 * @return FBoolean
	 */
	public FBoolean getFg_fixed() {
		return ((FBoolean) getAttrVal("Fg_fixed"));
	}	
	/**
	 * 是否固定资产
	 * @param Fg_fixed
	 */
	public void setFg_fixed(FBoolean Fg_fixed) {
		setAttrVal("Fg_fixed", Fg_fixed);
	}
	/**
	 * 维修信息
	 * @return String
	 */
	public String getMaintenanceinfo() {
		return ((String) getAttrVal("Maintenanceinfo"));
	}	
	/**
	 * 维修信息
	 * @param Maintenanceinfo
	 */
	public void setMaintenanceinfo(String Maintenanceinfo) {
		setAttrVal("Maintenanceinfo", Maintenanceinfo);
	}
	/**
	 * 使用年限
	 * @return Integer
	 */
	public Integer getUsefullife() {
		return ((Integer) getAttrVal("Usefullife"));
	}	
	/**
	 * 使用年限
	 * @param Usefullife
	 */
	public void setUsefullife(Integer Usefullife) {
		setAttrVal("Usefullife", Usefullife);
	}
	/**
	 * 是否打印条码
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}	
	/**
	 * 是否打印条码
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 是否急救设备
	 * @return FBoolean
	 */
	public FBoolean getFg_isaidequ() {
		return ((FBoolean) getAttrVal("Fg_isaidequ"));
	}	
	/**
	 * 是否急救设备
	 * @param Fg_isaidequ
	 */
	public void setFg_isaidequ(FBoolean Fg_isaidequ) {
		setAttrVal("Fg_isaidequ", Fg_isaidequ);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getInv_no() {
		return ((String) getAttrVal("Inv_no"));
	}	
	/**
	 * 发票号
	 * @param Inv_no
	 */
	public void setInv_no(String Inv_no) {
		setAttrVal("Inv_no", Inv_no);
	}
	/**
	 * 发票日期
	 * @return FDate
	 */
	public FDate getDt_inv() {
		return ((FDate) getAttrVal("Dt_inv"));
	}	
	/**
	 * 发票日期
	 * @param Dt_inv
	 */
	public void setDt_inv(FDate Dt_inv) {
		setAttrVal("Dt_inv", Dt_inv);
	}
	/**
	 * 凭证字
	 * @return String
	 */
	public String getVoucher_word() {
		return ((String) getAttrVal("Voucher_word"));
	}	
	/**
	 * 凭证字
	 * @param Voucher_word
	 */
	public void setVoucher_word(String Voucher_word) {
		setAttrVal("Voucher_word", Voucher_word);
	}
	/**
	 * 停止折旧月份
	 * @return Integer
	 */
	public Integer getStop_months() {
		return ((Integer) getAttrVal("Stop_months"));
	}	
	/**
	 * 停止折旧月份
	 * @param Stop_months
	 */
	public void setStop_months(Integer Stop_months) {
		setAttrVal("Stop_months", Stop_months);
	}
	/**
	 * 最近停止折旧时间
	 * @return FDate
	 */
	public FDate getDt_last_stopde() {
		return ((FDate) getAttrVal("Dt_last_stopde"));
	}	
	/**
	 * 最近停止折旧时间
	 * @param Dt_last_stopde
	 */
	public void setDt_last_stopde(FDate Dt_last_stopde) {
		setAttrVal("Dt_last_stopde", Dt_last_stopde);
	}
	/**
	 * 最近重新启用折旧时间
	 * @return FDate
	 */
	public FDate getDt_last_restartde() {
		return ((FDate) getAttrVal("Dt_last_restartde"));
	}	
	/**
	 * 最近重新启用折旧时间
	 * @param Dt_last_restartde
	 */
	public void setDt_last_restartde(FDate Dt_last_restartde) {
		setAttrVal("Dt_last_restartde", Dt_last_restartde);
	}
	/**
	 * 是否停止折旧
	 * @return FBoolean
	 */
	public FBoolean getFg_stopdep() {
		return ((FBoolean) getAttrVal("Fg_stopdep"));
	}	
	/**
	 * 是否停止折旧
	 * @param Fg_stopdep
	 */
	public void setFg_stopdep(FBoolean Fg_stopdep) {
		setAttrVal("Fg_stopdep", Fg_stopdep);
	}
	/**
	 * 是否顺延折旧年限
	 * @return FBoolean
	 */
	public FBoolean getFg_postpone() {
		return ((FBoolean) getAttrVal("Fg_postpone"));
	}	
	/**
	 * 是否顺延折旧年限
	 * @param Fg_postpone
	 */
	public void setFg_postpone(FBoolean Fg_postpone) {
		setAttrVal("Fg_postpone", Fg_postpone);
	}
	/**
	 * 最近停用或启用操作员
	 * @return String
	 */
	public String getId_last_oper() {
		return ((String) getAttrVal("Id_last_oper"));
	}	
	/**
	 * 最近停用或启用操作员
	 * @param Id_last_oper
	 */
	public void setId_last_oper(String Id_last_oper) {
		setAttrVal("Id_last_oper", Id_last_oper);
	}
	/**
	 * 保管地点
	 * @return String
	 */
	public String getSave_place() {
		return ((String) getAttrVal("Save_place"));
	}	
	/**
	 * 保管地点
	 * @param Save_place
	 */
	public void setSave_place(String Save_place) {
		setAttrVal("Save_place", Save_place);
	}
	/**
	 * 卫生部编码
	 * @return String
	 */
	public String getMoh_code() {
		return ((String) getAttrVal("Moh_code"));
	}	
	/**
	 * 卫生部编码
	 * @param Moh_code
	 */
	public void setMoh_code(String Moh_code) {
		setAttrVal("Moh_code", Moh_code);
	}
	/**
	 * 政府编码
	 * @return String
	 */
	public String getGover_code() {
		return ((String) getAttrVal("Gover_code"));
	}	
	/**
	 * 政府编码
	 * @param Gover_code
	 */
	public void setGover_code(String Gover_code) {
		setAttrVal("Gover_code", Gover_code);
	}
	/**
	 * 档案编号
	 * @return String
	 */
	public String getFileno() {
		return ((String) getAttrVal("Fileno"));
	}	
	/**
	 * 档案编号
	 * @param Fileno
	 */
	public void setFileno(String Fileno) {
		setAttrVal("Fileno", Fileno);
	}
	/**
	 * 医疗设备标准名称
	 * @return String
	 */
	public String getStandarname() {
		return ((String) getAttrVal("Standarname"));
	}	
	/**
	 * 医疗设备标准名称
	 * @param Standarname
	 */
	public void setStandarname(String Standarname) {
		setAttrVal("Standarname", Standarname);
	}
	/**
	 * 财务编码
	 * @return String
	 */
	public String getAccount_no() {
		return ((String) getAttrVal("Account_no"));
	}	
	/**
	 * 财务编码
	 * @param Account_no
	 */
	public void setAccount_no(String Account_no) {
		setAttrVal("Account_no", Account_no);
	}
	/**
	 * 计量编号
	 * @return String
	 */
	public String getGauge_no() {
		return ((String) getAttrVal("Gauge_no"));
	}	
	/**
	 * 计量编号
	 * @param Gauge_no
	 */
	public void setGauge_no(String Gauge_no) {
		setAttrVal("Gauge_no", Gauge_no);
	}
	/**
	 * 条码是否已经打印
	 * @return FBoolean
	 */
	public FBoolean getFg_printed() {
		return ((FBoolean) getAttrVal("Fg_printed"));
	}	
	/**
	 * 条码是否已经打印
	 * @param Fg_printed
	 */
	public void setFg_printed(FBoolean Fg_printed) {
		setAttrVal("Fg_printed", Fg_printed);
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
	 * 审批意见
	 * @return String
	 */
	public String getAppop() {
		return ((String) getAttrVal("Appop"));
	}	
	/**
	 * 审批意见
	 * @param Appop
	 */
	public void setAppop(String Appop) {
		setAttrVal("Appop", Appop);
	}
	/**
	 * 设备分类内码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 设备分类内码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
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
	 * 是否失效
	 * @return FBoolean
	 */
	public FBoolean getFg_avail() {
		return ((FBoolean) getAttrVal("Fg_avail"));
	}	
	/**
	 * 是否失效
	 * @param Fg_avail
	 */
	public void setFg_avail(FBoolean Fg_avail) {
		setAttrVal("Fg_avail", Fg_avail);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
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
	 * 是否出库
	 * @return FBoolean
	 */
	public FBoolean getFg_out() {
		return ((FBoolean) getAttrVal("Fg_out"));
	}	
	/**
	 * 是否出库
	 * @param Fg_out
	 */
	public void setFg_out(FBoolean Fg_out) {
		setAttrVal("Fg_out", Fg_out);
	}
	/**
	 * 出库日期
	 * @return FDateTime
	 */
	public FDateTime getDt_out() {
		return ((FDateTime) getAttrVal("Dt_out"));
	}	
	/**
	 * 出库日期
	 * @param Dt_out
	 */
	public void setDt_out(FDateTime Dt_out) {
		setAttrVal("Dt_out", Dt_out);
	}
	/**
	 * 出库主键
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库主键
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 出库细目主键
	 * @return String
	 */
	public String getId_out_itm() {
		return ((String) getAttrVal("Id_out_itm"));
	}	
	/**
	 * 出库细目主键
	 * @param Id_out_itm
	 */
	public void setId_out_itm(String Id_out_itm) {
		setAttrVal("Id_out_itm", Id_out_itm);
	}
	/**
	 * 入帐审核状态
	 * @return String
	 */
	public String getId_stu() {
		return ((String) getAttrVal("Id_stu"));
	}	
	/**
	 * 入帐审核状态
	 * @param Id_stu
	 */
	public void setId_stu(String Id_stu) {
		setAttrVal("Id_stu", Id_stu);
	}
	/**
	 * 入帐审核状态编码
	 * @return String
	 */
	public String getSd_stu() {
		return ((String) getAttrVal("Sd_stu"));
	}	
	/**
	 * 入帐审核状态编码
	 * @param Sd_stu
	 */
	public void setSd_stu(String Sd_stu) {
		setAttrVal("Sd_stu", Sd_stu);
	}
	/**
	 * 供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpecs() {
		return ((String) getAttrVal("Specs"));
	}	
	/**
	 * 规格
	 * @param Specs
	 */
	public void setSpecs(String Specs) {
		setAttrVal("Specs", Specs);
	}
	/**
	 * 入库单号
	 * @return String
	 */
	public String getIn_code() {
		return ((String) getAttrVal("In_code"));
	}	
	/**
	 * 入库单号
	 * @param In_code
	 */
	public void setIn_code(String In_code) {
		setAttrVal("In_code", In_code);
	}
	/**
	 * 出库单号
	 * @return String
	 */
	public String getOut_code() {
		return ((String) getAttrVal("Out_code"));
	}	
	/**
	 * 出库单号
	 * @param Out_code
	 */
	public void setOut_code(String Out_code) {
		setAttrVal("Out_code", Out_code);
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
	 * 编码
	 * @return String
	 */
	public String getCode_ga() {
		return ((String) getAttrVal("Code_ga"));
	}	
	/**
	 * 编码
	 * @param Code_ga
	 */
	public void setCode_ga(String Code_ga) {
		setAttrVal("Code_ga", Code_ga);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ga() {
		return ((String) getAttrVal("Name_ga"));
	}	
	/**
	 * 名称
	 * @param Name_ga
	 */
	public void setName_ga(String Name_ga) {
		setAttrVal("Name_ga", Name_ga);
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
	public String getName_source_fee() {
		return ((String) getAttrVal("Name_source_fee"));
	}	
	/**
	 * 名称
	 * @param Name_source_fee
	 */
	public void setName_source_fee(String Name_source_fee) {
		setAttrVal("Name_source_fee", Name_source_fee);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_use() {
		return ((String) getAttrVal("Name_use"));
	}	
	/**
	 * 名称
	 * @param Name_use
	 */
	public void setName_use(String Name_use) {
		setAttrVal("Name_use", Name_use);
	}
	/**
	 * 折旧名称
	 * @return String
	 */
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	/**
	 * 折旧名称
	 * @param Name_de
	 */
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	/**
	 * 折旧编码
	 * @return String
	 */
	public String getCode_de() {
		return ((String) getAttrVal("Code_de"));
	}	
	/**
	 * 折旧编码
	 * @param Code_de
	 */
	public void setCode_de(String Code_de) {
		setAttrVal("Code_de", Code_de);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_card_st() {
		return ((String) getAttrVal("Name_card_st"));
	}	
	/**
	 * 名称
	 * @param Name_card_st
	 */
	public void setName_card_st(String Name_card_st) {
		setAttrVal("Name_card_st", Name_card_st);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_card_st() {
		return ((String) getAttrVal("Code_card_st"));
	}	
	/**
	 * 编码
	 * @param Code_card_st
	 */
	public void setCode_card_st(String Code_card_st) {
		setAttrVal("Code_card_st", Code_card_st);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_state() {
		return ((String) getAttrVal("Name_state"));
	}	
	/**
	 * 名称
	 * @param Name_state
	 */
	public void setName_state(String Name_state) {
		setAttrVal("Name_state", Name_state);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_state() {
		return ((String) getAttrVal("Code_state"));
	}	
	/**
	 * 编码
	 * @param Code_state
	 */
	public void setCode_state(String Code_state) {
		setAttrVal("Code_state", Code_state);
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
	 * 卡片名称
	 * @return String
	 */
	public String getName_card_parent() {
		return ((String) getAttrVal("Name_card_parent"));
	}	
	/**
	 * 卡片名称
	 * @param Name_card_parent
	 */
	public void setName_card_parent(String Name_card_parent) {
		setAttrVal("Name_card_parent", Name_card_parent);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCard_no_parent() {
		return ((String) getAttrVal("Card_no_parent"));
	}	
	/**
	 * 卡片编号
	 * @param Card_no_parent
	 */
	public void setCard_no_parent(String Card_no_parent) {
		setAttrVal("Card_no_parent", Card_no_parent);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_enter_type() {
		return ((String) getAttrVal("Name_enter_type"));
	}	
	/**
	 * 名称
	 * @param Name_enter_type
	 */
	public void setName_enter_type(String Name_enter_type) {
		setAttrVal("Name_enter_type", Name_enter_type);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_reg_oper() {
		return ((String) getAttrVal("Name_reg_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_reg_oper
	 */
	public void setName_reg_oper(String Name_reg_oper) {
		setAttrVal("Name_reg_oper", Name_reg_oper);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_last_oper() {
		return ((String) getAttrVal("Name_last_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_last_oper
	 */
	public void setName_last_oper(String Name_last_oper) {
		setAttrVal("Name_last_oper", Name_last_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_emca() {
		return ((String) getAttrVal("Name_emca"));
	}	
	/**
	 * 名称
	 * @param Name_emca
	 */
	public void setName_emca(String Name_emca) {
		setAttrVal("Name_emca", Name_emca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stu() {
		return ((String) getAttrVal("Name_stu"));
	}	
	/**
	 * 名称
	 * @param Name_stu
	 */
	public void setName_stu(String Name_stu) {
		setAttrVal("Name_stu", Name_stu);
	}
	/**
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
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
		return "Id_card";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_card";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmCardDODesc.class);
	}
	
}