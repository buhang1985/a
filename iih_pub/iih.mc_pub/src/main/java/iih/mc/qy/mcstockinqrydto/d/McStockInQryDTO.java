package iih.mc.qy.mcstockinqrydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 耗材入库查询DTO DTO数据 
 * 
 */
public class McStockInQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	public String getStin_code() {
		return ((String) getAttrVal("Stin_code"));
	}
	/**
	 * 入库单号
	 * @param Stin_code
	 */
	public void setStin_code(String Stin_code) {
		setAttrVal("Stin_code", Stin_code);
	}
	/**
	 * 红蓝字标志
	 * @return FBoolean
	 */
	public FBoolean getRed_blue() {
		return ((FBoolean) getAttrVal("Red_blue"));
	}
	/**
	 * 红蓝字标志
	 * @param Red_blue
	 */
	public void setRed_blue(FBoolean Red_blue) {
		setAttrVal("Red_blue", Red_blue);
	}
	/**
	 * 交易分类
	 * @return String
	 */
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}
	/**
	 * 交易分类
	 * @param Id_mmstca
	 */
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
	}
	/**
	 * 交易分类名称
	 * @return String
	 */
	public String getMmstca_name() {
		return ((String) getAttrVal("Mmstca_name"));
	}
	/**
	 * 交易分类名称
	 * @param Mmstca_name
	 */
	public void setMmstca_name(String Mmstca_name) {
		setAttrVal("Mmstca_name", Mmstca_name);
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
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
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
	 * 供应商名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}
	/**
	 * 供应商名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 生产厂商
	 * @return String
	 */
	public String getId_factory() {
		return ((String) getAttrVal("Id_factory"));
	}
	/**
	 * 生产厂商
	 * @param Id_factory
	 */
	public void setId_factory(String Id_factory) {
		setAttrVal("Id_factory", Id_factory);
	}
	/**
	 * 厂商名称
	 * @return String
	 */
	public String getFactory_name() {
		return ((String) getAttrVal("Factory_name"));
	}
	/**
	 * 厂商名称
	 * @param Factory_name
	 */
	public void setFactory_name(String Factory_name) {
		setAttrVal("Factory_name", Factory_name);
	}
	/**
	 * 年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}
	/**
	 * 年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	/**
	 * 单据状态
	 * @return String
	 */
	public String getId_su_st() {
		return ((String) getAttrVal("Id_su_st"));
	}
	/**
	 * 单据状态
	 * @param Id_su_st
	 */
	public void setId_su_st(String Id_su_st) {
		setAttrVal("Id_su_st", Id_su_st);
	}
	/**
	 * 入库状态名称
	 * @return String
	 */
	public String getSu_st_name() {
		return ((String) getAttrVal("Su_st_name"));
	}
	/**
	 * 入库状态名称
	 * @param Su_st_name
	 */
	public void setSu_st_name(String Su_st_name) {
		setAttrVal("Su_st_name", Su_st_name);
	}
	/**
	 * 制单人
	 * @return String
	 */
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}
	/**
	 * 制单人
	 * @param Id_emp_st
	 */
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	/**
	 * 制单人姓名
	 * @return String
	 */
	public String getEmp_st_name() {
		return ((String) getAttrVal("Emp_st_name"));
	}
	/**
	 * 制单人姓名
	 * @param Emp_st_name
	 */
	public void setEmp_st_name(String Emp_st_name) {
		setAttrVal("Emp_st_name", Emp_st_name);
	}
	/**
	 * 制单时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 制单时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 制单日期
	 * @return FDate
	 */
	public FDate getDt_st_short() {
		return ((FDate) getAttrVal("Dt_st_short"));
	}
	/**
	 * 制单日期
	 * @param Dt_st_short
	 */
	public void setDt_st_short(FDate Dt_st_short) {
		setAttrVal("Dt_st_short", Dt_st_short);
	}
	/**
	 * 确认人
	 * @return String
	 */
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}
	/**
	 * 确认人
	 * @param Id_emp_conf
	 */
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	/**
	 * 确认人姓名
	 * @return String
	 */
	public String getEmp_conf_name() {
		return ((String) getAttrVal("Emp_conf_name"));
	}
	/**
	 * 确认人姓名
	 * @param Emp_conf_name
	 */
	public void setEmp_conf_name(String Emp_conf_name) {
		setAttrVal("Emp_conf_name", Emp_conf_name);
	}
	/**
	 * 确认时间
	 * @return String
	 */
	public String getDt_conf() {
		return ((String) getAttrVal("Dt_conf"));
	}
	/**
	 * 确认时间
	 * @param Dt_conf
	 */
	public void setDt_conf(String Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 医疗物品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}
	/**
	 * 医疗物品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 医疗物品类型名称
	 * @return String
	 */
	public String getMmtp_name() {
		return ((String) getAttrVal("Mmtp_name"));
	}
	/**
	 * 医疗物品类型名称
	 * @param Mmtp_name
	 */
	public void setMmtp_name(String Mmtp_name) {
		setAttrVal("Mmtp_name", Mmtp_name);
	}
	/**
	 * 物品分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}
	/**
	 * 物品分类
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 物品分类名称
	 * @return String
	 */
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}
	/**
	 * 物品分类名称
	 * @param Mmca_name
	 */
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 物品规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}
	/**
	 * 包装单位
	 * @param Id_mmpkgu_actual
	 */
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkgu_actual_name() {
		return ((String) getAttrVal("Mmpkgu_actual_name"));
	}
	/**
	 * 包装单位名称
	 * @param Mmpkgu_actual_name
	 */
	public void setMmpkgu_actual_name(String Mmpkgu_actual_name) {
		setAttrVal("Mmpkgu_actual_name", Mmpkgu_actual_name);
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
	 * 失效期
	 * @return FDate
	 */
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}
	/**
	 * 失效期
	 * @param Date_expi
	 */
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 采购价
	 * @return FDouble
	 */
	public FDouble getPri_po() {
		return ((FDouble) getAttrVal("Pri_po"));
	}
	/**
	 * 采购价
	 * @param Pri_po
	 */
	public void setPri_po(FDouble Pri_po) {
		setAttrVal("Pri_po", Pri_po);
	}
	/**
	 * 进价
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}
	/**
	 * 进价
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 售价
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}
	/**
	 * 售价
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}
	/**
	 * 数量
	 * @param Quan_actual
	 */
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
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
	 * 合计金额
	 * @return FDouble
	 */
	public FDouble getAmt_sum() {
		return ((FDouble) getAttrVal("Amt_sum"));
	}
	/**
	 * 合计金额
	 * @param Amt_sum
	 */
	public void setAmt_sum(FDouble Amt_sum) {
		setAttrVal("Amt_sum", Amt_sum);
	}
	/**
	 * 高低值分类
	 * @return Integer
	 */
	public Integer getEu_mmca() {
		return ((Integer) getAttrVal("Eu_mmca"));
	}
	/**
	 * 高低值分类
	 * @param Eu_mmca
	 */
	public void setEu_mmca(Integer Eu_mmca) {
		setAttrVal("Eu_mmca", Eu_mmca);
	}
	/**
	 * 供应商条码
	 * @return String
	 */
	public String getSup_bcode() {
		return ((String) getAttrVal("Sup_bcode"));
	}
	/**
	 * 供应商条码
	 * @param Sup_bcode
	 */
	public void setSup_bcode(String Sup_bcode) {
		setAttrVal("Sup_bcode", Sup_bcode);
	}
	/**
	 * 进价金额
	 * @return FDouble
	 */
	public FDouble getSum_pri() {
		return ((FDouble) getAttrVal("Sum_pri"));
	}
	/**
	 * 进价金额
	 * @param Sum_pri
	 */
	public void setSum_pri(FDouble Sum_pri) {
		setAttrVal("Sum_pri", Sum_pri);
	}
	/**
	 * 售价金额
	 * @return FDouble
	 */
	public FDouble getSum_sa() {
		return ((FDouble) getAttrVal("Sum_sa"));
	}
	/**
	 * 售价金额
	 * @param Sum_sa
	 */
	public void setSum_sa(FDouble Sum_sa) {
		setAttrVal("Sum_sa", Sum_sa);
	}
	/**
	 * 总数量
	 * @return FDouble
	 */
	public FDouble getSum_num() {
		return ((FDouble) getAttrVal("Sum_num"));
	}
	/**
	 * 总数量
	 * @param Sum_num
	 */
	public void setSum_num(FDouble Sum_num) {
		setAttrVal("Sum_num", Sum_num);
	}
}