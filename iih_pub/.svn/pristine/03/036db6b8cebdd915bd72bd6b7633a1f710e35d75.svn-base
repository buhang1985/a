package iih.ems.einv.emin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.emin.d.desc.EmsInDODesc;
import java.math.BigDecimal;

/**
 * 设备入库 DO数据 
 * 
 */
public class EmsInDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//入库主键
	public static final String ID_IN= "Id_in";
	//入库单号
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//是否红单
	public static final String FG_RED= "Fg_red";
	//设备库存交易类型
	public static final String ID_STTP= "Id_sttp";
	//设备库存交易类型编码
	public static final String SD_STTP= "Sd_sttp";
	//设备库存交易分类
	public static final String ID_STCA= "Id_stca";
	//入库单状态
	public static final String ID_STU= "Id_stu";
	//入库单状态编码
	public static final String SD_STU= "Sd_stu";
	//使用科室
	public static final String ID_DEPT= "Id_dept";
	//经费来源
	public static final String ID_FEESOURCE= "Id_feesource";
	//经费来源编码
	public static final String SD_FEESOURCE= "Sd_feesource";
	//设备来源
	public static final String ID_EMSOURCE= "Id_emsource";
	//设备来源编码
	public static final String SD_EMSOURCE= "Sd_emsource";
	//国家名称
	public static final String COUNTRY= "Country";
	//合同编号
	public static final String PACT_CODE= "Pact_code";
	//资产用途
	public static final String ID_EMUSE= "Id_emuse";
	//资产用途编码
	public static final String SD_EMUSE= "Sd_emuse";
	//购买日期
	public static final String DT_BUY= "Dt_buy";
	//购买人员
	public static final String ID_BUY_OPER= "Id_buy_oper";
	//供货公司
	public static final String ID_SUP= "Id_sup";
	//发票号码
	public static final String INV_NO= "Inv_no";
	//凭证号码
	public static final String VOUCHER_NO= "Voucher_no";
	//核准人员
	public static final String ID_CHK_OPER= "Id_chk_oper";
	//核准日期
	public static final String DT_CHK= "Dt_chk";
	//购买货币类型
	public static final String ID_MTYPE= "Id_mtype";
	//购买货币类型编码
	public static final String SD_MTYPE= "Sd_mtype";
	//供货商结算状态
	public static final String ID_PST= "Id_pst";
	//供货商结算状态编码
	public static final String SD_PST= "Sd_pst";
	//供货商结算流水号
	public static final String ID_PAY= "Id_pay";
	//供货商结算单号
	public static final String CODE_PAY= "Code_pay";
	//入库仓库
	public static final String ID_WH= "Id_wh";
	//验收单号
	public static final String ID_INSP= "Id_insp";
	//入库时间
	public static final String DT_IN= "Dt_in";
	//入库人
	public static final String ID_IN_OPER= "Id_in_oper";
	//是否固定资产
	public static final String FG_FIXED= "Fg_fixed";
	//使用年限
	public static final String USEFULLIFE= "Usefullife";
	//发票日期
	public static final String INV_DATE= "Inv_date";
	//凭证字
	public static final String VOUCHER_WORD= "Voucher_word";
	//入库金额
	public static final String AMT= "Amt";
	//财务年月
	public static final String YEAR_MONTH= "Year_month";
	//确认人
	public static final String ID_CONF_OPER= "Id_conf_oper";
	//确认时间
	public static final String DT_CONF= "Dt_conf";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//备注
	public static final String REMARK= "Remark";
	//名称
	public static final String NAME_TP= "Name_tp";
	//编码
	public static final String CODE_TP= "Code_tp";
	//编码
	public static final String CODE_CA= "Code_ca";
	//名称
	public static final String NAME_CA= "Name_ca";
	//编码
	public static final String CODE_STU= "Code_stu";
	//名称
	public static final String NAME_STU= "Name_stu";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//编码
	public static final String CODE_DEPT= "Code_dept";
	//编码
	public static final String CODE_FEE= "Code_fee";
	//名称
	public static final String NAME_FEE= "Name_fee";
	//编码
	public static final String CODE_SOU= "Code_sou";
	//名称
	public static final String NAME_SOU= "Name_sou";
	//编码
	public static final String CODE_USE= "Code_use";
	//名称
	public static final String NAME_USE= "Name_use";
	//供应商与厂商名称
	public static final String NAME_SUP= "Name_sup";
	//人员编码
	public static final String CODE_CHK= "Code_chk";
	//姓名
	public static final String NAME_CHK= "Name_chk";
	//编码
	public static final String CODE_HB= "Code_hb";
	//名称
	public static final String NAME_HB= "Name_hb";
	//编码
	public static final String CODE_JS= "Code_js";
	//名称
	public static final String NAME_JS= "Name_js";
	//仓库编码
	public static final String CODE_WH= "Code_wh";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//验收单名称
	public static final String NAME_INSP= "Name_insp";
	//编码
	public static final String CODE_INSP= "Code_insp";
	//姓名
	public static final String NAME_OPER= "Name_oper";
	//姓名
	public static final String NAME_CONF= "Name_conf";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 入库主键
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	/**
	 * 入库主键
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
	}
	/**
	 * 入库单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 入库单号
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
	 * 是否红单
	 * @return FBoolean
	 */
	public FBoolean getFg_red() {
		return ((FBoolean) getAttrVal("Fg_red"));
	}	
	/**
	 * 是否红单
	 * @param Fg_red
	 */
	public void setFg_red(FBoolean Fg_red) {
		setAttrVal("Fg_red", Fg_red);
	}
	/**
	 * 设备库存交易类型
	 * @return String
	 */
	public String getId_sttp() {
		return ((String) getAttrVal("Id_sttp"));
	}	
	/**
	 * 设备库存交易类型
	 * @param Id_sttp
	 */
	public void setId_sttp(String Id_sttp) {
		setAttrVal("Id_sttp", Id_sttp);
	}
	/**
	 * 设备库存交易类型编码
	 * @return String
	 */
	public String getSd_sttp() {
		return ((String) getAttrVal("Sd_sttp"));
	}	
	/**
	 * 设备库存交易类型编码
	 * @param Sd_sttp
	 */
	public void setSd_sttp(String Sd_sttp) {
		setAttrVal("Sd_sttp", Sd_sttp);
	}
	/**
	 * 设备库存交易分类
	 * @return String
	 */
	public String getId_stca() {
		return ((String) getAttrVal("Id_stca"));
	}	
	/**
	 * 设备库存交易分类
	 * @param Id_stca
	 */
	public void setId_stca(String Id_stca) {
		setAttrVal("Id_stca", Id_stca);
	}
	/**
	 * 入库单状态
	 * @return String
	 */
	public String getId_stu() {
		return ((String) getAttrVal("Id_stu"));
	}	
	/**
	 * 入库单状态
	 * @param Id_stu
	 */
	public void setId_stu(String Id_stu) {
		setAttrVal("Id_stu", Id_stu);
	}
	/**
	 * 入库单状态编码
	 * @return String
	 */
	public String getSd_stu() {
		return ((String) getAttrVal("Sd_stu"));
	}	
	/**
	 * 入库单状态编码
	 * @param Sd_stu
	 */
	public void setSd_stu(String Sd_stu) {
		setAttrVal("Sd_stu", Sd_stu);
	}
	/**
	 * 使用科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 使用科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 经费来源
	 * @return String
	 */
	public String getId_feesource() {
		return ((String) getAttrVal("Id_feesource"));
	}	
	/**
	 * 经费来源
	 * @param Id_feesource
	 */
	public void setId_feesource(String Id_feesource) {
		setAttrVal("Id_feesource", Id_feesource);
	}
	/**
	 * 经费来源编码
	 * @return String
	 */
	public String getSd_feesource() {
		return ((String) getAttrVal("Sd_feesource"));
	}	
	/**
	 * 经费来源编码
	 * @param Sd_feesource
	 */
	public void setSd_feesource(String Sd_feesource) {
		setAttrVal("Sd_feesource", Sd_feesource);
	}
	/**
	 * 设备来源
	 * @return String
	 */
	public String getId_emsource() {
		return ((String) getAttrVal("Id_emsource"));
	}	
	/**
	 * 设备来源
	 * @param Id_emsource
	 */
	public void setId_emsource(String Id_emsource) {
		setAttrVal("Id_emsource", Id_emsource);
	}
	/**
	 * 设备来源编码
	 * @return String
	 */
	public String getSd_emsource() {
		return ((String) getAttrVal("Sd_emsource"));
	}	
	/**
	 * 设备来源编码
	 * @param Sd_emsource
	 */
	public void setSd_emsource(String Sd_emsource) {
		setAttrVal("Sd_emsource", Sd_emsource);
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
	public String getId_emuse() {
		return ((String) getAttrVal("Id_emuse"));
	}	
	/**
	 * 资产用途
	 * @param Id_emuse
	 */
	public void setId_emuse(String Id_emuse) {
		setAttrVal("Id_emuse", Id_emuse);
	}
	/**
	 * 资产用途编码
	 * @return String
	 */
	public String getSd_emuse() {
		return ((String) getAttrVal("Sd_emuse"));
	}	
	/**
	 * 资产用途编码
	 * @param Sd_emuse
	 */
	public void setSd_emuse(String Sd_emuse) {
		setAttrVal("Sd_emuse", Sd_emuse);
	}
	/**
	 * 购买日期
	 * @return FDate
	 */
	public FDate getDt_buy() {
		return ((FDate) getAttrVal("Dt_buy"));
	}	
	/**
	 * 购买日期
	 * @param Dt_buy
	 */
	public void setDt_buy(FDate Dt_buy) {
		setAttrVal("Dt_buy", Dt_buy);
	}
	/**
	 * 购买人员
	 * @return String
	 */
	public String getId_buy_oper() {
		return ((String) getAttrVal("Id_buy_oper"));
	}	
	/**
	 * 购买人员
	 * @param Id_buy_oper
	 */
	public void setId_buy_oper(String Id_buy_oper) {
		setAttrVal("Id_buy_oper", Id_buy_oper);
	}
	/**
	 * 供货公司
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 供货公司
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 发票号码
	 * @return String
	 */
	public String getInv_no() {
		return ((String) getAttrVal("Inv_no"));
	}	
	/**
	 * 发票号码
	 * @param Inv_no
	 */
	public void setInv_no(String Inv_no) {
		setAttrVal("Inv_no", Inv_no);
	}
	/**
	 * 凭证号码
	 * @return String
	 */
	public String getVoucher_no() {
		return ((String) getAttrVal("Voucher_no"));
	}	
	/**
	 * 凭证号码
	 * @param Voucher_no
	 */
	public void setVoucher_no(String Voucher_no) {
		setAttrVal("Voucher_no", Voucher_no);
	}
	/**
	 * 核准人员
	 * @return String
	 */
	public String getId_chk_oper() {
		return ((String) getAttrVal("Id_chk_oper"));
	}	
	/**
	 * 核准人员
	 * @param Id_chk_oper
	 */
	public void setId_chk_oper(String Id_chk_oper) {
		setAttrVal("Id_chk_oper", Id_chk_oper);
	}
	/**
	 * 核准日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 核准日期
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 购买货币类型
	 * @return String
	 */
	public String getId_mtype() {
		return ((String) getAttrVal("Id_mtype"));
	}	
	/**
	 * 购买货币类型
	 * @param Id_mtype
	 */
	public void setId_mtype(String Id_mtype) {
		setAttrVal("Id_mtype", Id_mtype);
	}
	/**
	 * 购买货币类型编码
	 * @return String
	 */
	public String getSd_mtype() {
		return ((String) getAttrVal("Sd_mtype"));
	}	
	/**
	 * 购买货币类型编码
	 * @param Sd_mtype
	 */
	public void setSd_mtype(String Sd_mtype) {
		setAttrVal("Sd_mtype", Sd_mtype);
	}
	/**
	 * 供货商结算状态
	 * @return String
	 */
	public String getId_pst() {
		return ((String) getAttrVal("Id_pst"));
	}	
	/**
	 * 供货商结算状态
	 * @param Id_pst
	 */
	public void setId_pst(String Id_pst) {
		setAttrVal("Id_pst", Id_pst);
	}
	/**
	 * 供货商结算状态编码
	 * @return String
	 */
	public String getSd_pst() {
		return ((String) getAttrVal("Sd_pst"));
	}	
	/**
	 * 供货商结算状态编码
	 * @param Sd_pst
	 */
	public void setSd_pst(String Sd_pst) {
		setAttrVal("Sd_pst", Sd_pst);
	}
	/**
	 * 供货商结算流水号
	 * @return String
	 */
	public String getId_pay() {
		return ((String) getAttrVal("Id_pay"));
	}	
	/**
	 * 供货商结算流水号
	 * @param Id_pay
	 */
	public void setId_pay(String Id_pay) {
		setAttrVal("Id_pay", Id_pay);
	}
	/**
	 * 供货商结算单号
	 * @return String
	 */
	public String getCode_pay() {
		return ((String) getAttrVal("Code_pay"));
	}	
	/**
	 * 供货商结算单号
	 * @param Code_pay
	 */
	public void setCode_pay(String Code_pay) {
		setAttrVal("Code_pay", Code_pay);
	}
	/**
	 * 入库仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 入库仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 验收单号
	 * @return String
	 */
	public String getId_insp() {
		return ((String) getAttrVal("Id_insp"));
	}	
	/**
	 * 验收单号
	 * @param Id_insp
	 */
	public void setId_insp(String Id_insp) {
		setAttrVal("Id_insp", Id_insp);
	}
	/**
	 * 入库时间
	 * @return FDateTime
	 */
	public FDateTime getDt_in() {
		return ((FDateTime) getAttrVal("Dt_in"));
	}	
	/**
	 * 入库时间
	 * @param Dt_in
	 */
	public void setDt_in(FDateTime Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	/**
	 * 入库人
	 * @return String
	 */
	public String getId_in_oper() {
		return ((String) getAttrVal("Id_in_oper"));
	}	
	/**
	 * 入库人
	 * @param Id_in_oper
	 */
	public void setId_in_oper(String Id_in_oper) {
		setAttrVal("Id_in_oper", Id_in_oper);
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
	 * 发票日期
	 * @return FDate
	 */
	public FDate getInv_date() {
		return ((FDate) getAttrVal("Inv_date"));
	}	
	/**
	 * 发票日期
	 * @param Inv_date
	 */
	public void setInv_date(FDate Inv_date) {
		setAttrVal("Inv_date", Inv_date);
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
	 * 入库金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 入库金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	 * 确认人
	 * @return String
	 */
	public String getId_conf_oper() {
		return ((String) getAttrVal("Id_conf_oper"));
	}	
	/**
	 * 确认人
	 * @param Id_conf_oper
	 */
	public void setId_conf_oper(String Id_conf_oper) {
		setAttrVal("Id_conf_oper", Id_conf_oper);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 确认时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
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
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_tp() {
		return ((String) getAttrVal("Name_tp"));
	}	
	/**
	 * 名称
	 * @param Name_tp
	 */
	public void setName_tp(String Name_tp) {
		setAttrVal("Name_tp", Name_tp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_tp() {
		return ((String) getAttrVal("Code_tp"));
	}	
	/**
	 * 编码
	 * @param Code_tp
	 */
	public void setCode_tp(String Code_tp) {
		setAttrVal("Code_tp", Code_tp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	/**
	 * 编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}	
	/**
	 * 名称
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_stu() {
		return ((String) getAttrVal("Code_stu"));
	}	
	/**
	 * 编码
	 * @param Code_stu
	 */
	public void setCode_stu(String Code_stu) {
		setAttrVal("Code_stu", Code_stu);
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
	 * 编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_fee() {
		return ((String) getAttrVal("Code_fee"));
	}	
	/**
	 * 编码
	 * @param Code_fee
	 */
	public void setCode_fee(String Code_fee) {
		setAttrVal("Code_fee", Code_fee);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_fee() {
		return ((String) getAttrVal("Name_fee"));
	}	
	/**
	 * 名称
	 * @param Name_fee
	 */
	public void setName_fee(String Name_fee) {
		setAttrVal("Name_fee", Name_fee);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_sou() {
		return ((String) getAttrVal("Code_sou"));
	}	
	/**
	 * 编码
	 * @param Code_sou
	 */
	public void setCode_sou(String Code_sou) {
		setAttrVal("Code_sou", Code_sou);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sou() {
		return ((String) getAttrVal("Name_sou"));
	}	
	/**
	 * 名称
	 * @param Name_sou
	 */
	public void setName_sou(String Name_sou) {
		setAttrVal("Name_sou", Name_sou);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_use() {
		return ((String) getAttrVal("Code_use"));
	}	
	/**
	 * 编码
	 * @param Code_use
	 */
	public void setCode_use(String Code_use) {
		setAttrVal("Code_use", Code_use);
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
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_chk() {
		return ((String) getAttrVal("Code_chk"));
	}	
	/**
	 * 人员编码
	 * @param Code_chk
	 */
	public void setCode_chk(String Code_chk) {
		setAttrVal("Code_chk", Code_chk);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_chk() {
		return ((String) getAttrVal("Name_chk"));
	}	
	/**
	 * 姓名
	 * @param Name_chk
	 */
	public void setName_chk(String Name_chk) {
		setAttrVal("Name_chk", Name_chk);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_hb() {
		return ((String) getAttrVal("Code_hb"));
	}	
	/**
	 * 编码
	 * @param Code_hb
	 */
	public void setCode_hb(String Code_hb) {
		setAttrVal("Code_hb", Code_hb);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_hb() {
		return ((String) getAttrVal("Name_hb"));
	}	
	/**
	 * 名称
	 * @param Name_hb
	 */
	public void setName_hb(String Name_hb) {
		setAttrVal("Name_hb", Name_hb);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_js() {
		return ((String) getAttrVal("Code_js"));
	}	
	/**
	 * 编码
	 * @param Code_js
	 */
	public void setCode_js(String Code_js) {
		setAttrVal("Code_js", Code_js);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_js() {
		return ((String) getAttrVal("Name_js"));
	}	
	/**
	 * 名称
	 * @param Name_js
	 */
	public void setName_js(String Name_js) {
		setAttrVal("Name_js", Name_js);
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
	 * 验收单名称
	 * @return String
	 */
	public String getName_insp() {
		return ((String) getAttrVal("Name_insp"));
	}	
	/**
	 * 验收单名称
	 * @param Name_insp
	 */
	public void setName_insp(String Name_insp) {
		setAttrVal("Name_insp", Name_insp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_insp() {
		return ((String) getAttrVal("Code_insp"));
	}	
	/**
	 * 编码
	 * @param Code_insp
	 */
	public void setCode_insp(String Code_insp) {
		setAttrVal("Code_insp", Code_insp);
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
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_conf() {
		return ((String) getAttrVal("Name_conf"));
	}	
	/**
	 * 姓名
	 * @param Name_conf
	 */
	public void setName_conf(String Name_conf) {
		setAttrVal("Name_conf", Name_conf);
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
		return "Id_in";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_in";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsInDODesc.class);
	}
	
}