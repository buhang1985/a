package iih.mm.itf.material.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * MaterialInfoDTO DTO数据 
 * 
 */
public class MaterialInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 医疗物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品类型编码
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}
	/**
	 * 物品类型编码
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 物品类型名称
	 * @return String
	 */
	public String getName_mmtp() {
		return ((String) getAttrVal("Name_mmtp"));
	}
	/**
	 * 物品类型名称
	 * @param Name_mmtp
	 */
	public void setName_mmtp(String Name_mmtp) {
		setAttrVal("Name_mmtp", Name_mmtp);
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
	public String getName_mmca() {
		return ((String) getAttrVal("Name_mmca"));
	}
	/**
	 * 物品分类名称
	 * @param Name_mmca
	 */
	public void setName_mmca(String Name_mmca) {
		setAttrVal("Name_mmca", Name_mmca);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 物品编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 物品名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 商品名称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}
	/**
	 * 商品名称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
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
	 * 条形码
	 * @return String
	 */
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}
	/**
	 * 条形码
	 * @param Barcode
	 */
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
	}
	/**
	 * 化学名称
	 * @return String
	 */
	public String getChemistryname() {
		return ((String) getAttrVal("Chemistryname"));
	}
	/**
	 * 化学名称
	 * @param Chemistryname
	 */
	public void setChemistryname(String Chemistryname) {
		setAttrVal("Chemistryname", Chemistryname);
	}
	/**
	 * 零售价计算方式
	 * @return String
	 */
	public String getSd_primode() {
		return ((String) getAttrVal("Sd_primode"));
	}
	/**
	 * 零售价计算方式
	 * @param Sd_primode
	 */
	public void setSd_primode(String Sd_primode) {
		setAttrVal("Sd_primode", Sd_primode);
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
	 * 生产厂家名称
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}
	/**
	 * 生产厂家名称
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}
	/**
	 * 当前批准文号/注册号
	 * @return String
	 */
	public String getApprno() {
		return ((String) getAttrVal("Apprno"));
	}
	/**
	 * 当前批准文号/注册号
	 * @param Apprno
	 */
	public void setApprno(String Apprno) {
		setAttrVal("Apprno", Apprno);
	}
	/**
	 * 进口分类编码
	 * @return String
	 */
	public String getSd_abrd() {
		return ((String) getAttrVal("Sd_abrd"));
	}
	/**
	 * 进口分类编码
	 * @param Sd_abrd
	 */
	public void setSd_abrd(String Sd_abrd) {
		setAttrVal("Sd_abrd", Sd_abrd);
	}
	/**
	 * 价值分类编码
	 * @return String
	 */
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}
	/**
	 * 价值分类编码
	 * @param Sd_val
	 */
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	/**
	 * 包装单位住院取整模式编码
	 * @return String
	 */
	public String getSd_mupkgutp() {
		return ((String) getAttrVal("Sd_mupkgutp"));
	}
	/**
	 * 包装单位住院取整模式编码
	 * @param Sd_mupkgutp
	 */
	public void setSd_mupkgutp(String Sd_mupkgutp) {
		setAttrVal("Sd_mupkgutp", Sd_mupkgutp);
	}
	/**
	 * 包装单位门诊取整模式编码
	 * @return String
	 */
	public String getSd_opmutp() {
		return ((String) getAttrVal("Sd_opmutp"));
	}
	/**
	 * 包装单位门诊取整模式编码
	 * @param Sd_opmutp
	 */
	public void setSd_opmutp(String Sd_opmutp) {
		setAttrVal("Sd_opmutp", Sd_opmutp);
	}
	/**
	 * 物品有效期限
	 * @return Integer
	 */
	public Integer getValid_cn() {
		return ((Integer) getAttrVal("Valid_cn"));
	}
	/**
	 * 物品有效期限
	 * @param Valid_cn
	 */
	public void setValid_cn(Integer Valid_cn) {
		setAttrVal("Valid_cn", Valid_cn);
	}
	/**
	 * 有效期限单位编码
	 * @return String
	 */
	public String getSd_validu() {
		return ((String) getAttrVal("Sd_validu"));
	}
	/**
	 * 有效期限单位编码
	 * @param Sd_validu
	 */
	public void setSd_validu(String Sd_validu) {
		setAttrVal("Sd_validu", Sd_validu);
	}
	/**
	 * 存量管理模式编码
	 * @return String
	 */
	public String getSd_stmd() {
		return ((String) getAttrVal("Sd_stmd"));
	}
	/**
	 * 存量管理模式编码
	 * @param Sd_stmd
	 */
	public void setSd_stmd(String Sd_stmd) {
		setAttrVal("Sd_stmd", Sd_stmd);
	}
	/**
	 * 加成率计算模式编码
	 * @return String
	 */
	public String getSd_pap() {
		return ((String) getAttrVal("Sd_pap"));
	}
	/**
	 * 加成率计算模式编码
	 * @param Sd_pap
	 */
	public void setSd_pap(String Sd_pap) {
		setAttrVal("Sd_pap", Sd_pap);
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
	/**
	 * 基本体积单位主键
	 * @return String
	 */
	public String getId_unit_volbase() {
		return ((String) getAttrVal("Id_unit_volbase"));
	}
	/**
	 * 基本体积单位主键
	 * @param Id_unit_volbase
	 */
	public void setId_unit_volbase(String Id_unit_volbase) {
		setAttrVal("Id_unit_volbase", Id_unit_volbase);
	}
	/**
	 * 基本体积单位名称
	 * @return String
	 */
	public String getName_unit_volbase() {
		return ((String) getAttrVal("Name_unit_volbase"));
	}
	/**
	 * 基本体积单位名称
	 * @param Name_unit_volbase
	 */
	public void setName_unit_volbase(String Name_unit_volbase) {
		setAttrVal("Name_unit_volbase", Name_unit_volbase);
	}
	/**
	 * 换算系数_体基
	 * @return FDouble
	 */
	public FDouble getFactor_vb() {
		return ((FDouble) getAttrVal("Factor_vb"));
	}
	/**
	 * 换算系数_体基
	 * @param Factor_vb
	 */
	public void setFactor_vb(FDouble Factor_vb) {
		setAttrVal("Factor_vb", Factor_vb);
	}
	/**
	 * 重量单位主键
	 * @return String
	 */
	public String getId_unit_weight() {
		return ((String) getAttrVal("Id_unit_weight"));
	}
	/**
	 * 重量单位主键
	 * @param Id_unit_weight
	 */
	public void setId_unit_weight(String Id_unit_weight) {
		setAttrVal("Id_unit_weight", Id_unit_weight);
	}
	/**
	 * 重量单位名称
	 * @return String
	 */
	public String getName_unit_weight() {
		return ((String) getAttrVal("Name_unit_weight"));
	}
	/**
	 * 重量单位名称
	 * @param Name_unit_weight
	 */
	public void setName_unit_weight(String Name_unit_weight) {
		setAttrVal("Name_unit_weight", Name_unit_weight);
	}
	/**
	 * 重量
	 * @return FDouble
	 */
	public FDouble getFactor_wb() {
		return ((FDouble) getAttrVal("Factor_wb"));
	}
	/**
	 * 重量
	 * @param Factor_wb
	 */
	public void setFactor_wb(FDouble Factor_wb) {
		setAttrVal("Factor_wb", Factor_wb);
	}
	/**
	 * 医学单位主键
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 医学单位主键
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 医学单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 医学单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 换算系数_医基
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 换算系数_医基
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 基本包装单位主键
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}
	/**
	 * 基本包装单位主键
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
	}
	/**
	 * 基本包装单位名称
	 * @return String
	 */
	public String getName_unit_pkgbase() {
		return ((String) getAttrVal("Name_unit_pkgbase"));
	}
	/**
	 * 基本包装单位名称
	 * @param Name_unit_pkgbase
	 */
	public void setName_unit_pkgbase(String Name_unit_pkgbase) {
		setAttrVal("Name_unit_pkgbase", Name_unit_pkgbase);
	}
	/**
	 * 零售包装单位主键
	 * @return String
	 */
	public String getId_unit_pkgsp() {
		return ((String) getAttrVal("Id_unit_pkgsp"));
	}
	/**
	 * 零售包装单位主键
	 * @param Id_unit_pkgsp
	 */
	public void setId_unit_pkgsp(String Id_unit_pkgsp) {
		setAttrVal("Id_unit_pkgsp", Id_unit_pkgsp);
	}
	/**
	 * 零售包装单位名称
	 * @return String
	 */
	public String getName_unit_pkgsp() {
		return ((String) getAttrVal("Name_unit_pkgsp"));
	}
	/**
	 * 零售包装单位名称
	 * @param Name_unit_pkgsp
	 */
	public void setName_unit_pkgsp(String Name_unit_pkgsp) {
		setAttrVal("Name_unit_pkgsp", Name_unit_pkgsp);
	}
	/**
	 * 换算系数_零基
	 * @return FDouble
	 */
	public FDouble getFactor_sb() {
		return ((FDouble) getAttrVal("Factor_sb"));
	}
	/**
	 * 换算系数_零基
	 * @param Factor_sb
	 */
	public void setFactor_sb(FDouble Factor_sb) {
		setAttrVal("Factor_sb", Factor_sb);
	}
	/**
	 * 皮试标志
	 * @return FBoolean
	 */
	public FBoolean getFg_skin() {
		return ((FBoolean) getAttrVal("Fg_skin"));
	}
	/**
	 * 皮试标志
	 * @param Fg_skin
	 */
	public void setFg_skin(FBoolean Fg_skin) {
		setAttrVal("Fg_skin", Fg_skin);
	}
	/**
	 * 皮试类型编码
	 * @return String
	 */
	public String getSd_skinca() {
		return ((String) getAttrVal("Sd_skinca"));
	}
	/**
	 * 皮试类型编码
	 * @param Sd_skinca
	 */
	public void setSd_skinca(String Sd_skinca) {
		setAttrVal("Sd_skinca", Sd_skinca);
	}
	/**
	 * 皮试项目ID
	 * @return String
	 */
	public String getId_srvskin() {
		return ((String) getAttrVal("Id_srvskin"));
	}
	/**
	 * 皮试项目ID
	 * @param Id_srvskin
	 */
	public void setId_srvskin(String Id_srvskin) {
		setAttrVal("Id_srvskin", Id_srvskin);
	}
	/**
	 * 患者使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pat() {
		return ((FBoolean) getAttrVal("Fg_pat"));
	}
	/**
	 * 患者使用标志
	 * @param Fg_pat
	 */
	public void setFg_pat(FBoolean Fg_pat) {
		setAttrVal("Fg_pat", Fg_pat);
	}
	/**
	 * 默认物品出库方式编码
	 * @return String
	 */
	public String getSd_outmode() {
		return ((String) getAttrVal("Sd_outmode"));
	}
	/**
	 * 默认物品出库方式编码
	 * @param Sd_outmode
	 */
	public void setSd_outmode(String Sd_outmode) {
		setAttrVal("Sd_outmode", Sd_outmode);
	}
	/**
	 * 产地
	 * @return String
	 */
	public String getPlace() {
		return ((String) getAttrVal("Place"));
	}
	/**
	 * 产地
	 * @param Place
	 */
	public void setPlace(String Place) {
		setAttrVal("Place", Place);
	}
}