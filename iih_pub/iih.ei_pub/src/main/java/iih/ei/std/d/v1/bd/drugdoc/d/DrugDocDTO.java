package iih.ei.std.d.v1.bd.drugdoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品档案DTO DTO数据 
 * 
 */
public class DrugDocDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
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
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 基本单位编码
	 * @return String
	 */
	public String getCode_pkgu_base() {
		return ((String) getAttrVal("Code_pkgu_base"));
	}	
	/**
	 * 基本单位编码
	 * @param Code_pkgu_base
	 */
	public void setCode_pkgu_base(String Code_pkgu_base) {
		setAttrVal("Code_pkgu_base", Code_pkgu_base);
	}
	/**
	 * 基本单位
	 * @return String
	 */
	public String getName_pkgu_base() {
		return ((String) getAttrVal("Name_pkgu_base"));
	}	
	/**
	 * 基本单位
	 * @param Name_pkgu_base
	 */
	public void setName_pkgu_base(String Name_pkgu_base) {
		setAttrVal("Name_pkgu_base", Name_pkgu_base);
	}
	/**
	 * 零售单位编码
	 * @return String
	 */
	public String getCode_pkgu_sp() {
		return ((String) getAttrVal("Code_pkgu_sp"));
	}	
	/**
	 * 零售单位编码
	 * @param Code_pkgu_sp
	 */
	public void setCode_pkgu_sp(String Code_pkgu_sp) {
		setAttrVal("Code_pkgu_sp", Code_pkgu_sp);
	}
	/**
	 * 零售单位
	 * @return String
	 */
	public String getName_pkgu_sp() {
		return ((String) getAttrVal("Name_pkgu_sp"));
	}	
	/**
	 * 零售单位
	 * @param Name_pkgu_sp
	 */
	public void setName_pkgu_sp(String Name_pkgu_sp) {
		setAttrVal("Name_pkgu_sp", Name_pkgu_sp);
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
	 * 参考价格
	 * @return String
	 */
	public String getPrice() {
		return ((String) getAttrVal("Price"));
	}	
	/**
	 * 参考价格
	 * @param Price
	 */
	public void setPrice(String Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getName_fac() {
		return ((String) getAttrVal("Name_fac"));
	}	
	/**
	 * 生产厂家
	 * @param Name_fac
	 */
	public void setName_fac(String Name_fac) {
		setAttrVal("Name_fac", Name_fac);
	}
	/**
	 * 药品分类
	 * @return String
	 */
	public String getName_mmca() {
		return ((String) getAttrVal("Name_mmca"));
	}	
	/**
	 * 药品分类
	 * @param Name_mmca
	 */
	public void setName_mmca(String Name_mmca) {
		setAttrVal("Name_mmca", Name_mmca);
	}
	/**
	 * 药品类型
	 * @return String
	 */
	public String getName_mmtp() {
		return ((String) getAttrVal("Name_mmtp"));
	}	
	/**
	 * 药品类型
	 * @param Name_mmtp
	 */
	public void setName_mmtp(String Name_mmtp) {
		setAttrVal("Name_mmtp", Name_mmtp);
	}
	/**
	 * 毒麻分类编码
	 * @return String
	 */
	public String getCode_pois() {
		return ((String) getAttrVal("Code_pois"));
	}	
	/**
	 * 毒麻分类编码
	 * @param Code_pois
	 */
	public void setCode_pois(String Code_pois) {
		setAttrVal("Code_pois", Code_pois);
	}
	/**
	 * 剂型编码
	 * @return String
	 */
	public String getCode_dosage() {
		return ((String) getAttrVal("Code_dosage"));
	}	
	/**
	 * 剂型编码
	 * @param Code_dosage
	 */
	public void setCode_dosage(String Code_dosage) {
		setAttrVal("Code_dosage", Code_dosage);
	}
	/**
	 * 药理分类编码
	 * @return String
	 */
	public String getCode_pharm() {
		return ((String) getAttrVal("Code_pharm"));
	}	
	/**
	 * 药理分类编码
	 * @param Code_pharm
	 */
	public void setCode_pharm(String Code_pharm) {
		setAttrVal("Code_pharm", Code_pharm);
	}
	/**
	 * 不良反应
	 * @return String
	 */
	public String getReact() {
		return ((String) getAttrVal("React"));
	}	
	/**
	 * 不良反应
	 * @param React
	 */
	public void setReact(String React) {
		setAttrVal("React", React);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getPrecaut() {
		return ((String) getAttrVal("Precaut"));
	}	
	/**
	 * 注意事项
	 * @param Precaut
	 */
	public void setPrecaut(String Precaut) {
		setAttrVal("Precaut", Precaut);
	}
	/**
	 * 禁忌症
	 * @return String
	 */
	public String getConstr() {
		return ((String) getAttrVal("Constr"));
	}	
	/**
	 * 禁忌症
	 * @param Constr
	 */
	public void setConstr(String Constr) {
		setAttrVal("Constr", Constr);
	}
	/**
	 * 适应症
	 * @return String
	 */
	public String getIndica() {
		return ((String) getAttrVal("Indica"));
	}	
	/**
	 * 适应症
	 * @param Indica
	 */
	public void setIndica(String Indica) {
		setAttrVal("Indica", Indica);
	}
	/**
	 * 默认用法
	 * @return String
	 */
	public String getCode_usage() {
		return ((String) getAttrVal("Code_usage"));
	}	
	/**
	 * 默认用法
	 * @param Code_usage
	 */
	public void setCode_usage(String Code_usage) {
		setAttrVal("Code_usage", Code_usage);
	}
	/**
	 * 默认频次
	 * @return String
	 */
	public String getCode_freq() {
		return ((String) getAttrVal("Code_freq"));
	}	
	/**
	 * 默认频次
	 * @param Code_freq
	 */
	public void setCode_freq(String Code_freq) {
		setAttrVal("Code_freq", Code_freq);
	}
	/**
	 * 有效期
	 * @return String
	 */
	public String getValid_cn() {
		return ((String) getAttrVal("Valid_cn"));
	}	
	/**
	 * 有效期
	 * @param Valid_cn
	 */
	public void setValid_cn(String Valid_cn) {
		setAttrVal("Valid_cn", Valid_cn);
	}
	/**
	 * 有效期单位
	 * @return String
	 */
	public String getName_valid() {
		return ((String) getAttrVal("Name_valid"));
	}	
	/**
	 * 有效期单位
	 * @param Name_valid
	 */
	public void setName_valid(String Name_valid) {
		setAttrVal("Name_valid", Name_valid);
	}
	/**
	 * 默认剂量
	 * @return String
	 */
	public String getQuan_med() {
		return ((String) getAttrVal("Quan_med"));
	}	
	/**
	 * 默认剂量
	 * @param Quan_med
	 */
	public void setQuan_med(String Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 皮试标识
	 * @return String
	 */
	public String getFg_skin() {
		return ((String) getAttrVal("Fg_skin"));
	}	
	/**
	 * 皮试标识
	 * @param Fg_skin
	 */
	public void setFg_skin(String Fg_skin) {
		setAttrVal("Fg_skin", Fg_skin);
	}
	/**
	 * 启用标识
	 * @return String
	 */
	public String getFg_active() {
		return ((String) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(String Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}