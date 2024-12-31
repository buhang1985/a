package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 处方明细详细信息 DTO数据 
 * 
 */
public class InpDetailsParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	public static final String FEETP_NAME= "Feetp_name";
	public static final String INPNO= "Inpno";
	public static final String FREQ= "Freq";
	public static final String CREATEDATE= "Createdate";
	public static final String ITEMLEVEL= "Itemlevel";
	public static final String DEPNAME= "Depname";
	public static final String RATIO_SELF= "Ratio_self";
	public static final String SD_ABRD= "Sd_abrd";
	public static final String FEETP_CODE= "Feetp_code";
	public static final String AMT= "Amt";
	public static final String HIS_SDSRVTP= "His_sdsrvtp";
	public static final String PRICE= "Price";
	public static final String HISITEMCODE= "Hisitemcode";
	public static final String DT_TAKEMED= "Dt_takemed";
	public static final String ORDERS= "Orders";
	public static final String CHARGE_TP= "Charge_tp";
	public static final String SPEC= "Spec";
	public static final String OPERATORNAME= "Operatorname";
	public static final String DOCTORNAME= "Doctorname";
	public static final String HOSPNAME= "Hospname";
	public static final String ORDER_TP= "Order_tp";
	public static final String DT_CG= "Dt_cg";
	public static final String DEPCODE= "Depcode";
	public static final String DOSE= "Dose";
	public static final String AMT_DEDUCT= "Amt_deduct";
	public static final String HISITEMNAME= "Hisitemname";
	public static final String HPITEMNAME= "Hpitemname";
	public static final String NAME_ABRD= "Name_abrd";
	public static final String HIS_FG_DRUG= "His_fg_drug";
	public static final String BILLITEMNO= "Billitemno";
	public static final String SRVTP= "Srvtp";
	public static final String HOSPCODE= "Hospcode";
	public static final String PRESDATE= "Presdate";
	public static final String PURCHASEITEM= "Purchaseitem";
	public static final String CATALOG_NAME= "Catalog_name";
	public static final String DOCTORCODE= "Doctorcode";
	public static final String QUAN= "Quan";
	public static final String PRESNO= "Presno";
	public static final String HPITEMCODE= "Hpitemcode";
	public static final String DOSAGE_UNIT= "Dosage_unit";
	public static final String UNIT= "Unit";
	public static final String CATALOG_CODE= "Catalog_code";
	public static final String DOSEAGE= "Doseage";
	public static final String DAYS= "Days";
	public static final String BILLITEMNO_OLD= "Billitemno_old";
	public static final String USAGE= "Usage";
	public static final String FG_SIGLE= "Fg_sigle";
	public static final String UPDATEDATE= "Updatedate";
	public static final String AMT_HP= "Amt_hp";
	/**
	 * 项目序号（费用明细 HIS 系统 唯一标识） 
	 * @return String
	 */
	public String getBillitemno() {
		return ((String) getAttrVal("Billitemno"));
	}
	/**
	 * 项目序号（费用明细 HIS 系统 唯一标识） 
	 * @param Billitemno
	 */
	public void setBillitemno(String Billitemno) {
		setAttrVal("Billitemno", Billitemno);
	}
	/**
	 * 费用类别代码
	 * @return String
	 */
	public String getFeetp_code() {
		return ((String) getAttrVal("Feetp_code"));
	}
	/**
	 * 费用类别代码
	 * @param Feetp_code
	 */
	public void setFeetp_code(String Feetp_code) {
		setAttrVal("Feetp_code", Feetp_code);
	}
	/**
	 * 费用类别名称
	 * @return String
	 */
	public String getFeetp_name() {
		return ((String) getAttrVal("Feetp_name"));
	}
	/**
	 * 费用类别名称
	 * @param Feetp_name
	 */
	public void setFeetp_name(String Feetp_name) {
		setAttrVal("Feetp_name", Feetp_name);
	}
	/**
	 * his系统项目代码
	 * @return String
	 */
	public String getHisitemcode() {
		return ((String) getAttrVal("Hisitemcode"));
	}
	/**
	 * his系统项目代码
	 * @param Hisitemcode
	 */
	public void setHisitemcode(String Hisitemcode) {
		setAttrVal("Hisitemcode", Hisitemcode);
	}
	/**
	 * his系统项目名称
	 * @return String
	 */
	public String getHisitemname() {
		return ((String) getAttrVal("Hisitemname"));
	}
	/**
	 * his系统项目名称
	 * @param Hisitemname
	 */
	public void setHisitemname(String Hisitemname) {
		setAttrVal("Hisitemname", Hisitemname);
	}
	/**
	 * 剂型
	 * @return String
	 */
	public String getDose() {
		return ((String) getAttrVal("Dose"));
	}
	/**
	 * 剂型
	 * @param Dose
	 */
	public void setDose(String Dose) {
		setAttrVal("Dose", Dose);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}
	/**
	 * 单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}
	/**
	 * 医生姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 项目类别
	 * @return String
	 */
	public String getSrvtp() {
		return ((String) getAttrVal("Srvtp"));
	}
	/**
	 * 项目类别
	 * @param Srvtp
	 */
	public void setSrvtp(String Srvtp) {
		setAttrVal("Srvtp", Srvtp);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getPresno() {
		return ((String) getAttrVal("Presno"));
	}
	/**
	 * 处方号
	 * @param Presno
	 */
	public void setPresno(String Presno) {
		setAttrVal("Presno", Presno);
	}
	/**
	 * 处方日期
	 * @return FDateTime
	 */
	public FDateTime getPresdate() {
		return ((FDateTime) getAttrVal("Presdate"));
	}
	/**
	 * 处方日期
	 * @param Presdate
	 */
	public void setPresdate(FDateTime Presdate) {
		setAttrVal("Presdate", Presdate);
	}
	/**
	 * 付数
	 * @return FDouble
	 */
	public FDouble getOrders() {
		return ((FDouble) getAttrVal("Orders"));
	}
	/**
	 * 付数
	 * @param Orders
	 */
	public void setOrders(FDouble Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 医保项目代码
	 * @return String
	 */
	public String getHpitemcode() {
		return ((String) getAttrVal("Hpitemcode"));
	}
	/**
	 * 医保项目代码
	 * @param Hpitemcode
	 */
	public void setHpitemcode(String Hpitemcode) {
		setAttrVal("Hpitemcode", Hpitemcode);
	}
	/**
	 * 医保项目名称
	 * @return String
	 */
	public String getHpitemname() {
		return ((String) getAttrVal("Hpitemname"));
	}
	/**
	 * 医保项目名称
	 * @param Hpitemname
	 */
	public void setHpitemname(String Hpitemname) {
		setAttrVal("Hpitemname", Hpitemname);
	}
	/**
	 * 单次用量
	 * @return FDouble
	 */
	public FDouble getDoseage() {
		return ((FDouble) getAttrVal("Doseage"));
	}
	/**
	 * 单次用量
	 * @param Doseage
	 */
	public void setDoseage(FDouble Doseage) {
		setAttrVal("Doseage", Doseage);
	}
	/**
	 * 可报销金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 可报销金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 使用频次
	 * @return String
	 */
	public String getFreq() {
		return ((String) getAttrVal("Freq"));
	}
	/**
	 * 使用频次
	 * @param Freq
	 */
	public void setFreq(String Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 处方医师编码
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}
	/**
	 * 处方医师编码
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 科别编码
	 * @return String
	 */
	public String getDepcode() {
		return ((String) getAttrVal("Depcode"));
	}
	/**
	 * 科别编码
	 * @param Depcode
	 */
	public void setDepcode(String Depcode) {
		setAttrVal("Depcode", Depcode);
	}
	/**
	 * 科别名称
	 * @return String
	 */
	public String getDepname() {
		return ((String) getAttrVal("Depname"));
	}
	/**
	 * 科别名称
	 * @param Depname
	 */
	public void setDepname(String Depname) {
		setAttrVal("Depname", Depname);
	}
	/**
	 * 执行天数
	 * @return Integer
	 */
	public Integer getDays() {
		return ((Integer) getAttrVal("Days"));
	}
	/**
	 * 执行天数
	 * @param Days
	 */
	public void setDays(Integer Days) {
		setAttrVal("Days", Days);
	}
	/**
	 * 草药单复方标识
	 * @return String
	 */
	public String getFg_sigle() {
		return ((String) getAttrVal("Fg_sigle"));
	}
	/**
	 * 草药单复方标识
	 * @param Fg_sigle
	 */
	public void setFg_sigle(String Fg_sigle) {
		setAttrVal("Fg_sigle", Fg_sigle);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getOperatorname() {
		return ((String) getAttrVal("Operatorname"));
	}
	/**
	 * 经办人
	 * @param Operatorname
	 */
	public void setOperatorname(String Operatorname) {
		setAttrVal("Operatorname", Operatorname);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedate() {
		return ((FDateTime) getAttrVal("Createdate"));
	}
	/**
	 * 创建时间
	 * @param Createdate
	 */
	public void setCreatedate(FDateTime Createdate) {
		setAttrVal("Createdate", Createdate);
	}
	/**
	 * 更新时间
	 * @return FDateTime
	 */
	public FDateTime getUpdatedate() {
		return ((FDateTime) getAttrVal("Updatedate"));
	}
	/**
	 * 更新时间
	 * @param Updatedate
	 */
	public void setUpdatedate(FDateTime Updatedate) {
		setAttrVal("Updatedate", Updatedate);
	}
	/**
	 * 住院登记流水号
	 * @return String
	 */
	public String getInpno() {
		return ((String) getAttrVal("Inpno"));
	}
	/**
	 * 住院登记流水号
	 * @param Inpno
	 */
	public void setInpno(String Inpno) {
		setAttrVal("Inpno", Inpno);
	}
	/**
	 * 就医机构代码
	 * @return String
	 */
	public String getHospcode() {
		return ((String) getAttrVal("Hospcode"));
	}
	/**
	 * 就医机构代码
	 * @param Hospcode
	 */
	public void setHospcode(String Hospcode) {
		setAttrVal("Hospcode", Hospcode);
	}
	/**
	 * 就医机构名称
	 * @return String
	 */
	public String getHospname() {
		return ((String) getAttrVal("Hospname"));
	}
	/**
	 * 就医机构名称
	 * @param Hospname
	 */
	public void setHospname(String Hospname) {
		setAttrVal("Hospname", Hospname);
	}
	/**
	 * 明细扣款金额
	 * @return FDouble
	 */
	public FDouble getAmt_deduct() {
		return ((FDouble) getAttrVal("Amt_deduct"));
	}
	/**
	 * 明细扣款金额
	 * @param Amt_deduct
	 */
	public void setAmt_deduct(FDouble Amt_deduct) {
		setAttrVal("Amt_deduct", Amt_deduct);
	}
	/**
	 * 自付比例
	 * @return FDouble
	 */
	public FDouble getRatio_self() {
		return ((FDouble) getAttrVal("Ratio_self"));
	}
	/**
	 * 自付比例
	 * @param Ratio_self
	 */
	public void setRatio_self(FDouble Ratio_self) {
		setAttrVal("Ratio_self", Ratio_self);
	}
	/**
	 * 记账类别
	 * @return String
	 */
	public String getCharge_tp() {
		return ((String) getAttrVal("Charge_tp"));
	}
	/**
	 * 记账类别
	 * @param Charge_tp
	 */
	public void setCharge_tp(String Charge_tp) {
		setAttrVal("Charge_tp", Charge_tp);
	}
	/**
	 * 项目等级
	 * @return String
	 */
	public String getItemlevel() {
		return ((String) getAttrVal("Itemlevel"));
	}
	/**
	 * 项目等级
	 * @param Itemlevel
	 */
	public void setItemlevel(String Itemlevel) {
		setAttrVal("Itemlevel", Itemlevel);
	}
	/**
	 * 国产/进口标识代码
	 * @return String
	 */
	public String getSd_abrd() {
		return ((String) getAttrVal("Sd_abrd"));
	}
	/**
	 * 国产/进口标识代码
	 * @param Sd_abrd
	 */
	public void setSd_abrd(String Sd_abrd) {
		setAttrVal("Sd_abrd", Sd_abrd);
	}
	/**
	 * 国产/进口标识名
	 * @return String
	 */
	public String getName_abrd() {
		return ((String) getAttrVal("Name_abrd"));
	}
	/**
	 * 国产/进口标识名
	 * @param Name_abrd
	 */
	public void setName_abrd(String Name_abrd) {
		setAttrVal("Name_abrd", Name_abrd);
	}
	/**
	 * 目录属性代码
	 * @return String
	 */
	public String getCatalog_code() {
		return ((String) getAttrVal("Catalog_code"));
	}
	/**
	 * 目录属性代码
	 * @param Catalog_code
	 */
	public void setCatalog_code(String Catalog_code) {
		setAttrVal("Catalog_code", Catalog_code);
	}
	/**
	 * 目录属性名称
	 * @return String
	 */
	public String getCatalog_name() {
		return ((String) getAttrVal("Catalog_name"));
	}
	/**
	 * 目录属性名称
	 * @param Catalog_name
	 */
	public void setCatalog_name(String Catalog_name) {
		setAttrVal("Catalog_name", Catalog_name);
	}
	/**
	 * 集中招标采购项目编码
	 * @return String
	 */
	public String getPurchaseitem() {
		return ((String) getAttrVal("Purchaseitem"));
	}
	/**
	 * 集中招标采购项目编码
	 * @param Purchaseitem
	 */
	public void setPurchaseitem(String Purchaseitem) {
		setAttrVal("Purchaseitem", Purchaseitem);
	}
	/**
	 * 是否药品
	 * @return FBoolean
	 */
	public FBoolean getHis_fg_drug() {
		return ((FBoolean) getAttrVal("His_fg_drug"));
	}
	/**
	 * 是否药品
	 * @param His_fg_drug
	 */
	public void setHis_fg_drug(FBoolean His_fg_drug) {
		setAttrVal("His_fg_drug", His_fg_drug);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getHis_sdsrvtp() {
		return ((String) getAttrVal("His_sdsrvtp"));
	}
	/**
	 * 服务类型
	 * @param His_sdsrvtp
	 */
	public void setHis_sdsrvtp(String His_sdsrvtp) {
		setAttrVal("His_sdsrvtp", His_sdsrvtp);
	}
	/**
	 * 冲红记录对应的原记录的行号
	 * @return String
	 */
	public String getBillitemno_old() {
		return ((String) getAttrVal("Billitemno_old"));
	}
	/**
	 * 冲红记录对应的原记录的行号
	 * @param Billitemno_old
	 */
	public void setBillitemno_old(String Billitemno_old) {
		setAttrVal("Billitemno_old", Billitemno_old);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getUsage() {
		return ((String) getAttrVal("Usage"));
	}
	/**
	 * 用法
	 * @param Usage
	 */
	public void setUsage(String Usage) {
		setAttrVal("Usage", Usage);
	}
	/**
	 * 实际用药时间
	 * @return FDateTime
	 */
	public FDateTime getDt_takemed() {
		return ((FDateTime) getAttrVal("Dt_takemed"));
	}
	/**
	 * 实际用药时间
	 * @param Dt_takemed
	 */
	public void setDt_takemed(FDateTime Dt_takemed) {
		setAttrVal("Dt_takemed", Dt_takemed);
	}
	/**
	 * 用量单位
	 * @return String
	 */
	public String getDosage_unit() {
		return ((String) getAttrVal("Dosage_unit"));
	}
	/**
	 * 用量单位
	 * @param Dosage_unit
	 */
	public void setDosage_unit(String Dosage_unit) {
		setAttrVal("Dosage_unit", Dosage_unit);
	}
	/**
	 * 医嘱类别
	 * @return String
	 */
	public String getOrder_tp() {
		return ((String) getAttrVal("Order_tp"));
	}
	/**
	 * 医嘱类别
	 * @param Order_tp
	 */
	public void setOrder_tp(String Order_tp) {
		setAttrVal("Order_tp", Order_tp);
	}
	/**
	 * 计费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}
	/**
	 * 计费时间
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 发送方交易流水号
	 * @return String
	 */
	public String getSenderserialno() {
		return ((String) getAttrVal("Senderserialno"));
	}
	/**
	 * 发送方交易流水号
	 * @param Senderserialno
	 */
	public void setSenderserialno(String Senderserialno) {
		setAttrVal("Senderserialno", Senderserialno);
	}
	/**
	 * his系统项目id
	 * @return String
	 */
	public String getHisitemid() {
		return ((String) getAttrVal("Hisitemid"));
	}
	/**
	 * his系统项目id
	 * @param Hisitemid
	 */
	public void setHisitemid(String Hisitemid) {
		setAttrVal("Hisitemid", Hisitemid);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 个人编号
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	/**
	 * 审批编码
	 * @return String
	 */
	public String getApprocode() {
		return ((String) getAttrVal("Approcode"));
	}
	/**
	 * 审批编码
	 * @param Approcode
	 */
	public void setApprocode(String Approcode) {
		setAttrVal("Approcode", Approcode);
	}
	/**
	 * 服务机构编码
	 * @return String
	 */
	public String getHospitalno() {
		return ((String) getAttrVal("Hospitalno"));
	}
	/**
	 * 服务机构编码
	 * @param Hospitalno
	 */
	public void setHospitalno(String Hospitalno) {
		setAttrVal("Hospitalno", Hospitalno);
	}
	/**
	 * 门诊号(住院号)
	 * @return String
	 */
	public String getInhosno() {
		return ((String) getAttrVal("Inhosno"));
	}
	/**
	 * 门诊号(住院号)
	 * @param Inhosno
	 */
	public void setInhosno(String Inhosno) {
		setAttrVal("Inhosno", Inhosno);
	}
	/**
	 * 审批标志
	 * @return String
	 */
	public String getKind() {
		return ((String) getAttrVal("Kind"));
	}
	/**
	 * 审批标志
	 * @param Kind
	 */
	public void setKind(String Kind) {
		setAttrVal("Kind", Kind);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getDepname_mp() {
		return ((String) getAttrVal("Depname_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Depname_mp
	 */
	public void setDepname_mp(String Depname_mp) {
		setAttrVal("Depname_mp", Depname_mp);
	}
	/**
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 记账单号
	 * @return String
	 */
	public String getCode_cg() {
		return ((String) getAttrVal("Code_cg"));
	}
	/**
	 * 记账单号
	 * @param Code_cg
	 */
	public void setCode_cg(String Code_cg) {
		setAttrVal("Code_cg", Code_cg);
	}
	/**
	 * 费用区分标志
	 * @return String
	 */
	public String getCdi() {
		return ((String) getAttrVal("Cdi"));
	}
	/**
	 * 费用区分标志
	 * @param Cdi
	 */
	public void setCdi(String Cdi) {
		setAttrVal("Cdi", Cdi);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
}