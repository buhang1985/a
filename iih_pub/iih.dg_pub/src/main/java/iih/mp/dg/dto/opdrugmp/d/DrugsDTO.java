package iih.mp.dg.dto.opdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品明细DTO DTO数据 
 * 
 */
public class DrugsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请领单主键
	 * @return String
	 */
	public String getId_dgoepdt() {
		return ((String) getAttrVal("Id_dgoepdt"));
	}
	/**
	 * 请领单主键
	 * @param Id_dgoepdt
	 */
	public void setId_dgoepdt(String Id_dgoepdt) {
		setAttrVal("Id_dgoepdt", Id_dgoepdt);
	}
	/**
	 * 医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医嘱频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 医嘱频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法要求
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 参考价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}
	/**
	 * 规格
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
	}
	/**
	 * 生产厂商名称
	 * @return String
	 */
	public String getName_manufactory() {
		return ((String) getAttrVal("Name_manufactory"));
	}
	/**
	 * 生产厂商名称
	 * @param Name_manufactory
	 */
	public void setName_manufactory(String Name_manufactory) {
		setAttrVal("Name_manufactory", Name_manufactory);
	}
	/**
	 * 数量_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 数量_医疗单位
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 医疗单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 医疗单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 当前包装单位名称
	 * @return String
	 */
	public String getName_pkgu_cur() {
		return ((String) getAttrVal("Name_pkgu_cur"));
	}
	/**
	 * 当前包装单位名称
	 * @param Name_pkgu_cur
	 */
	public void setName_pkgu_cur(String Name_pkgu_cur) {
		setAttrVal("Name_pkgu_cur", Name_pkgu_cur);
	}
	/**
	 * 基本包装单位名称
	 * @return String
	 */
	public String getName_pkgu_base() {
		return ((String) getAttrVal("Name_pkgu_base"));
	}
	/**
	 * 基本包装单位名称
	 * @param Name_pkgu_base
	 */
	public void setName_pkgu_base(String Name_pkgu_base) {
		setAttrVal("Name_pkgu_base", Name_pkgu_base);
	}
	/**
	 * 数量_总数
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量_总数
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 数量_已发
	 * @return FDouble
	 */
	public FDouble getQuan_mp() {
		return ((FDouble) getAttrVal("Quan_mp"));
	}
	/**
	 * 数量_已发
	 * @param Quan_mp
	 */
	public void setQuan_mp(FDouble Quan_mp) {
		setAttrVal("Quan_mp", Quan_mp);
	}
	/**
	 * 数量_已退药
	 * @return FDouble
	 */
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}
	/**
	 * 数量_已退药
	 * @param Quan_bk
	 */
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
	}
	/**
	 * 数量_操作
	 * @return FDouble
	 */
	public FDouble getQuan_disp() {
		return ((FDouble) getAttrVal("Quan_disp"));
	}
	/**
	 * 数量_操作
	 * @param Quan_disp
	 */
	public void setQuan_disp(FDouble Quan_disp) {
		setAttrVal("Quan_disp", Quan_disp);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getQuan_or() {
		return ((Integer) getAttrVal("Quan_or"));
	}
	/**
	 * 医嘱付数
	 * @param Quan_or
	 */
	public void setQuan_or(Integer Quan_or) {
		setAttrVal("Quan_or", Quan_or);
	}
	/**
	 * 已发药付数
	 * @return Integer
	 */
	public Integer getQuan_pair_mp() {
		return ((Integer) getAttrVal("Quan_pair_mp"));
	}
	/**
	 * 已发药付数
	 * @param Quan_pair_mp
	 */
	public void setQuan_pair_mp(Integer Quan_pair_mp) {
		setAttrVal("Quan_pair_mp", Quan_pair_mp);
	}
	/**
	 * 已退药付数
	 * @return Integer
	 */
	public Integer getQuan_pair_bk() {
		return ((Integer) getAttrVal("Quan_pair_bk"));
	}
	/**
	 * 已退药付数
	 * @param Quan_pair_bk
	 */
	public void setQuan_pair_bk(Integer Quan_pair_bk) {
		setAttrVal("Quan_pair_bk", Quan_pair_bk);
	}
	/**
	 * 操作付数
	 * @return Integer
	 */
	public Integer getQuan_pair_disp() {
		return ((Integer) getAttrVal("Quan_pair_disp"));
	}
	/**
	 * 操作付数
	 * @param Quan_pair_disp
	 */
	public void setQuan_pair_disp(Integer Quan_pair_disp) {
		setAttrVal("Quan_pair_disp", Quan_pair_disp);
	}
	/**
	 * 应收金额
	 * @return FDouble
	 */
	public FDouble getAmt_should() {
		return ((FDouble) getAttrVal("Amt_should"));
	}
	/**
	 * 应收金额
	 * @param Amt_should
	 */
	public void setAmt_should(FDouble Amt_should) {
		setAttrVal("Amt_should", Amt_should);
	}
	/**
	 * 实收金额
	 * @return FDouble
	 */
	public FDouble getAmt_real() {
		return ((FDouble) getAttrVal("Amt_real"));
	}
	/**
	 * 实收金额
	 * @param Amt_real
	 */
	public void setAmt_real(FDouble Amt_real) {
		setAttrVal("Amt_real", Amt_real);
	}
	/**
	 * 退费金额
	 * @return FDouble
	 */
	public FDouble getAmt_rtn() {
		return ((FDouble) getAttrVal("Amt_rtn"));
	}
	/**
	 * 退费金额
	 * @param Amt_rtn
	 */
	public void setAmt_rtn(FDouble Amt_rtn) {
		setAttrVal("Amt_rtn", Amt_rtn);
	}
	/**
	 * 物品价值分类编码
	 * @return String
	 */
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}
	/**
	 * 物品价值分类编码
	 * @param Sd_val
	 */
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	/**
	 * OTC标志
	 * @return FBoolean
	 */
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}
	/**
	 * OTC标志
	 * @param Fg_otc
	 */
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	/**
	 * 贵重OTC标志
	 * @return String
	 */
	public String getSign() {
		return ((String) getAttrVal("Sign"));
	}
	/**
	 * 贵重OTC标志
	 * @param Sign
	 */
	public void setSign(String Sign) {
		setAttrVal("Sign", Sign);
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
	 * 特性
	 * @return String
	 */
	public String getCharacter() {
		return ((String) getAttrVal("Character"));
	}
	/**
	 * 特性
	 * @param Character
	 */
	public void setCharacter(String Character) {
		setAttrVal("Character", Character);
	}
	/**
	 * 单次计量
	 * @return String
	 */
	public String getSingle_med() {
		return ((String) getAttrVal("Single_med"));
	}
	/**
	 * 单次计量
	 * @param Single_med
	 */
	public void setSingle_med(String Single_med) {
		setAttrVal("Single_med", Single_med);
	}
	/**
	 * 皮试结果编码
	 * @return String
	 */
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}
	/**
	 * 皮试结果编码
	 * @param Sd_rst_skintest
	 */
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
	}
	/**
	 * 皮试结果名称
	 * @return String
	 */
	public String getName_rst_skintest() {
		return ((String) getAttrVal("Name_rst_skintest"));
	}
	/**
	 * 皮试结果名称
	 * @param Name_rst_skintest
	 */
	public void setName_rst_skintest(String Name_rst_skintest) {
		setAttrVal("Name_rst_skintest", Name_rst_skintest);
	}
	/**
	 * 时间标识
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间标识
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 计划发药窗口
	 * @return String
	 */
	public String getName_site() {
		return ((String) getAttrVal("Name_site"));
	}
	/**
	 * 计划发药窗口
	 * @param Name_site
	 */
	public void setName_site(String Name_site) {
		setAttrVal("Name_site", Name_site);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 药品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 日期
	 * @return String
	 */
	public String getDate() {
		return ((String) getAttrVal("Date"));
	}
	/**
	 * 日期
	 * @param Date
	 */
	public void setDate(String Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 数量格式化字符串
	 * @return String
	 */
	public String getQuan_str() {
		return ((String) getAttrVal("Quan_str"));
	}
	/**
	 * 数量格式化字符串
	 * @param Quan_str
	 */
	public void setQuan_str(String Quan_str) {
		setAttrVal("Quan_str", Quan_str);
	}
	/**
	 * 可退最大数量
	 * @return FDouble
	 */
	public FDouble getQuan_bk_max() {
		return ((FDouble) getAttrVal("Quan_bk_max"));
	}
	/**
	 * 可退最大数量
	 * @param Quan_bk_max
	 */
	public void setQuan_bk_max(FDouble Quan_bk_max) {
		setAttrVal("Quan_bk_max", Quan_bk_max);
	}
	/**
	 * 草药可退最大付数
	 * @return Integer
	 */
	public Integer getQuan_pairbk_max() {
		return ((Integer) getAttrVal("Quan_pairbk_max"));
	}
	/**
	 * 草药可退最大付数
	 * @param Quan_pairbk_max
	 */
	public void setQuan_pairbk_max(Integer Quan_pairbk_max) {
		setAttrVal("Quan_pairbk_max", Quan_pairbk_max);
	}
	/**
	 * 货位号
	 * @return String
	 */
	public String getCode_shx() {
		return ((String) getAttrVal("Code_shx"));
	}
	/**
	 * 货位号
	 * @param Code_shx
	 */
	public void setCode_shx(String Code_shx) {
		setAttrVal("Code_shx", Code_shx);
	}
	/**
	 * 患者生日
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 患者生日
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
}