package iih.mp.dg.dto.opdgdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品明细v2 DTO数据 
 * 
 */
public class DrugsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 用法id
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法id
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
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
	 * 药品库存
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}
	/**
	 * 药品库存
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
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
	/**
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 药品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 药品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
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
	 * 当前包装单位id
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}
	/**
	 * 当前包装单位id
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	/**
	 * 基本包装单位id
	 * @return String
	 */
	public String getId_pkgu_base() {
		return ((String) getAttrVal("Id_pkgu_base"));
	}
	/**
	 * 基本包装单位id
	 * @param Id_pkgu_base
	 */
	public void setId_pkgu_base(String Id_pkgu_base) {
		setAttrVal("Id_pkgu_base", Id_pkgu_base);
	}
	/**
	 * 本记录是否被选中
	 * @return FBoolean
	 */
	public FBoolean getSelected() {
		return ((FBoolean) getAttrVal("Selected"));
	}
	/**
	 * 本记录是否被选中
	 * @param Selected
	 */
	public void setSelected(FBoolean Selected) {
		setAttrVal("Selected", Selected);
	}
	/**
	 * 整数版操作数量
	 * @return FDouble
	 */
	public FDouble getQuan_disp_int() {
		return ((FDouble) getAttrVal("Quan_disp_int"));
	}
	/**
	 * 整数版操作数量
	 * @param Quan_disp_int
	 */
	public void setQuan_disp_int(FDouble Quan_disp_int) {
		setAttrVal("Quan_disp_int", Quan_disp_int);
	}
	/**
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getPaysta() {
		return ((String) getAttrVal("Paysta"));
	}
	/**
	 * 记账状态
	 * @param Paysta
	 */
	public void setPaysta(String Paysta) {
		setAttrVal("Paysta", Paysta);
	}
	/**
	 * 毒麻分类编码
	 * @return String
	 */
	public String getDg_sd_pois() {
		return ((String) getAttrVal("Dg_sd_pois"));
	}
	/**
	 * 毒麻分类编码
	 * @param Dg_sd_pois
	 */
	public void setDg_sd_pois(String Dg_sd_pois) {
		setAttrVal("Dg_sd_pois", Dg_sd_pois);
	}
	/**
	 * 抗菌药分类编码
	 * @return String
	 */
	public String getDg_sd_anti() {
		return ((String) getAttrVal("Dg_sd_anti"));
	}
	/**
	 * 抗菌药分类编码
	 * @param Dg_sd_anti
	 */
	public void setDg_sd_anti(String Dg_sd_anti) {
		setAttrVal("Dg_sd_anti", Dg_sd_anti);
	}
	/**
	 * 是否在院执行
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_in() {
		return ((FBoolean) getAttrVal("Fg_mp_in"));
	}
	/**
	 * 是否在院执行
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(FBoolean Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}
	/**
	 * 药品执行id
	 * @return String
	 */
	public String getId_dgop() {
		return ((String) getAttrVal("Id_dgop"));
	}
	/**
	 * 药品执行id
	 * @param Id_dgop
	 */
	public void setId_dgop(String Id_dgop) {
		setAttrVal("Id_dgop", Id_dgop);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方编码
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 高危标识
	 * @return FBoolean
	 */
	public FBoolean getFg_highrisk() {
		return ((FBoolean) getAttrVal("Fg_highrisk"));
	}
	/**
	 * 高危标识
	 * @param Fg_highrisk
	 */
	public void setFg_highrisk(FBoolean Fg_highrisk) {
		setAttrVal("Fg_highrisk", Fg_highrisk);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务类型id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 发药人姓名
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}
	/**
	 * 发药人姓名
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
	}
	/**
	 * 发药时间
	 * @return FDateTime
	 */
	public FDateTime getDt_disp() {
		return ((FDateTime) getAttrVal("Dt_disp"));
	}
	/**
	 * 发药时间
	 * @param Dt_disp
	 */
	public void setDt_disp(FDateTime Dt_disp) {
		setAttrVal("Dt_disp", Dt_disp);
	}
}