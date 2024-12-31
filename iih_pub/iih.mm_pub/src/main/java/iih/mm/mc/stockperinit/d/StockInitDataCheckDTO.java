package iih.mm.mc.stockperinit.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 期初初始数据检查结果 DTO数据 
 * 
 */
public class StockInitDataCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 校验状态
	 * @return FBoolean
	 */
	public FBoolean getCheck_stat() {
		return ((FBoolean) getAttrVal("Check_stat"));
	}
	/**
	 * 校验状态
	 * @param Check_stat
	 */
	public void setCheck_stat(FBoolean Check_stat) {
		setAttrVal("Check_stat", Check_stat);
	}
	/**
	 * 校验结果
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}
	/**
	 * 校验结果
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getMm_id() {
		return ((String) getAttrVal("Mm_id"));
	}
	/**
	 * 物品主键
	 * @param Mm_id
	 */
	public void setMm_id(String Mm_id) {
		setAttrVal("Mm_id", Mm_id);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
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
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
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
	 * 现存量
	 * @return FDouble
	 */
	public FDouble getStock() {
		return ((FDouble) getAttrVal("Stock"));
	}
	/**
	 * 现存量
	 * @param Stock
	 */
	public void setStock(FDouble Stock) {
		setAttrVal("Stock", Stock);
	}
	/**
	 * 成本金额
	 * @return FDouble
	 */
	public FDouble getAmt_cost() {
		return ((FDouble) getAttrVal("Amt_cost"));
	}
	/**
	 * 成本金额
	 * @param Amt_cost
	 */
	public void setAmt_cost(FDouble Amt_cost) {
		setAttrVal("Amt_cost", Amt_cost);
	}
	/**
	 * 物品分类主键
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}
	/**
	 * 物品分类主键
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
	 * 包装单位主键
	 * @return String
	 */
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}
	/**
	 * 包装单位主键
	 * @param Id_mmpkgu_actual
	 */
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}
	/**
	 * 包装单位名称
	 * @param Mmpkguname
	 */
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
	}
	/**
	 * 生产厂家名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}
	/**
	 * 生产厂家名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 生产厂家主键
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}
	/**
	 * 生产厂家主键
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 零售价计算方式编码
	 * @return String
	 */
	public String getSd_primode() {
		return ((String) getAttrVal("Sd_primode"));
	}
	/**
	 * 零售价计算方式编码
	 * @param Sd_primode
	 */
	public void setSd_primode(String Sd_primode) {
		setAttrVal("Sd_primode", Sd_primode);
	}
	/**
	 * 是否批次管理
	 * @return FBoolean
	 */
	public FBoolean getFg_batch() {
		return ((FBoolean) getAttrVal("Fg_batch"));
	}
	/**
	 * 是否批次管理
	 * @param Fg_batch
	 */
	public void setFg_batch(FBoolean Fg_batch) {
		setAttrVal("Fg_batch", Fg_batch);
	}
	/**
	 * 本物品计算加成率
	 * @return FDouble
	 */
	public FDouble getRate_pap() {
		return ((FDouble) getAttrVal("Rate_pap"));
	}
	/**
	 * 本物品计算加成率
	 * @param Rate_pap
	 */
	public void setRate_pap(FDouble Rate_pap) {
		setAttrVal("Rate_pap", Rate_pap);
	}
}