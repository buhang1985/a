package iih.mm.qy.drugintoutdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品入出存信息DTO DTO数据 
 * 
 */
public class DrugIntOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 入库单明细主键
	 * @return String
	 */
	public String getId_initm() {
		return ((String) getAttrVal("Id_initm"));
	}
	/**
	 * 入库单明细主键
	 * @param Id_initm
	 */
	public void setId_initm(String Id_initm) {
		setAttrVal("Id_initm", Id_initm);
	}
	/**
	 * 入库单据主键
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}
	/**
	 * 入库单据主键
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
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
	 * 药品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}
	/**
	 * 药品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}
	/**
	 * 药品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
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
	public String getName_pkgu() {
		return ((String) getAttrVal("Name_pkgu"));
	}
	/**
	 * 单位
	 * @param Name_pkgu
	 */
	public void setName_pkgu(String Name_pkgu) {
		setAttrVal("Name_pkgu", Name_pkgu);
	}
	/**
	 * 发药数量
	 * @return FDouble
	 */
	public FDouble getQuan_st_base() {
		return ((FDouble) getAttrVal("Quan_st_base"));
	}
	/**
	 * 发药数量
	 * @param Quan_st_base
	 */
	public void setQuan_st_base(FDouble Quan_st_base) {
		setAttrVal("Quan_st_base", Quan_st_base);
	}
	/**
	 * 现存数量
	 * @return FDouble
	 */
	public FDouble getNum_actual() {
		return ((FDouble) getAttrVal("Num_actual"));
	}
	/**
	 * 现存数量
	 * @param Num_actual
	 */
	public void setNum_actual(FDouble Num_actual) {
		setAttrVal("Num_actual", Num_actual);
	}
	/**
	 * 发药日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 发药日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_type() {
		return ((String) getAttrVal("Code_type"));
	}
	/**
	 * 就诊类型
	 * @param Code_type
	 */
	public void setCode_type(String Code_type) {
		setAttrVal("Code_type", Code_type);
	}
	/**
	 * 当日结存
	 * @return FDouble
	 */
	public FDouble getMmbl_current() {
		return ((FDouble) getAttrVal("Mmbl_current"));
	}
	/**
	 * 当日结存
	 * @param Mmbl_current
	 */
	public void setMmbl_current(FDouble Mmbl_current) {
		setAttrVal("Mmbl_current", Mmbl_current);
	}
	/**
	 * 发药金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 发药金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 处方数量
	 * @return FDouble
	 */
	public FDouble getPresnum() {
		return ((FDouble) getAttrVal("Presnum"));
	}
	/**
	 * 处方数量
	 * @param Presnum
	 */
	public void setPresnum(FDouble Presnum) {
		setAttrVal("Presnum", Presnum);
	}
	/**
	 * 期初结存
	 * @return FDouble
	 */
	public FDouble getInitialbalancenum() {
		return ((FDouble) getAttrVal("Initialbalancenum"));
	}
	/**
	 * 期初结存
	 * @param Initialbalancenum
	 */
	public void setInitialbalancenum(FDouble Initialbalancenum) {
		setAttrVal("Initialbalancenum", Initialbalancenum);
	}
	/**
	 * 门诊药房领用
	 * @return FDouble
	 */
	public FDouble getOpcollarusenum() {
		return ((FDouble) getAttrVal("Opcollarusenum"));
	}
	/**
	 * 门诊药房领用
	 * @param Opcollarusenum
	 */
	public void setOpcollarusenum(FDouble Opcollarusenum) {
		setAttrVal("Opcollarusenum", Opcollarusenum);
	}
	/**
	 * 病区药房领用
	 * @return FDouble
	 */
	public FDouble getIpcollarusenum() {
		return ((FDouble) getAttrVal("Ipcollarusenum"));
	}
	/**
	 * 病区药房领用
	 * @param Ipcollarusenum
	 */
	public void setIpcollarusenum(FDouble Ipcollarusenum) {
		setAttrVal("Ipcollarusenum", Ipcollarusenum);
	}
	/**
	 * 批号
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}
	/**
	 * 批号
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
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
	 * 仓库名
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}
	/**
	 * 仓库名
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 物品分类id
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}
	/**
	 * 物品分类id
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 毒麻标识
	 * @return String
	 */
	public String getFg_pois() {
		return ((String) getAttrVal("Fg_pois"));
	}
	/**
	 * 毒麻标识
	 * @param Fg_pois
	 */
	public void setFg_pois(String Fg_pois) {
		setAttrVal("Fg_pois", Fg_pois);
	}
	/**
	 * 库存状态
	 * @return String
	 */
	public String getSd_warn() {
		return ((String) getAttrVal("Sd_warn"));
	}
	/**
	 * 库存状态
	 * @param Sd_warn
	 */
	public void setSd_warn(String Sd_warn) {
		setAttrVal("Sd_warn", Sd_warn);
	}
	/**
	 * 物品分类
	 * @return String
	 */
	public String getName_mmca() {
		return ((String) getAttrVal("Name_mmca"));
	}
	/**
	 * 物品分类
	 * @param Name_mmca
	 */
	public void setName_mmca(String Name_mmca) {
		setAttrVal("Name_mmca", Name_mmca);
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
	 * 打印名
	 * @return String
	 */
	public String getPrintname() {
		return ((String) getAttrVal("Printname"));
	}
	/**
	 * 打印名
	 * @param Printname
	 */
	public void setPrintname(String Printname) {
		setAttrVal("Printname", Printname);
	}
	/**
	 * 通用名
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}
	/**
	 * 通用名
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
}