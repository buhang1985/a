package iih.bd.mm.meterial.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 卫材基本信息导出模板 DTO数据 
 * 
 */
public class McMaterialDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 物品类型
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}
	/**
	 * 物品类型
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 卫材分类
	 * @return String
	 */
	public String getMmca_code() {
		return ((String) getAttrVal("Mmca_code"));
	}
	/**
	 * 卫材分类
	 * @param Mmca_code
	 */
	public void setMmca_code(String Mmca_code) {
		setAttrVal("Mmca_code", Mmca_code);
	}
	/**
	 * 卫材编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 卫材编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 卫材名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 卫材名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 卫材规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 卫材规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getPkgbase_code() {
		return ((String) getAttrVal("Pkgbase_code"));
	}
	/**
	 * 包装单位
	 * @param Pkgbase_code
	 */
	public void setPkgbase_code(String Pkgbase_code) {
		setAttrVal("Pkgbase_code", Pkgbase_code);
	}
	/**
	 * 进口分类
	 * @return String
	 */
	public String getSd_abrd() {
		return ((String) getAttrVal("Sd_abrd"));
	}
	/**
	 * 进口分类
	 * @param Sd_abrd
	 */
	public void setSd_abrd(String Sd_abrd) {
		setAttrVal("Sd_abrd", Sd_abrd);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}
	/**
	 * 生产厂家
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
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
	/**
	 * 是否批次管理(0否，1是)
	 * @return String
	 */
	public String getFg_batchmix() {
		return ((String) getAttrVal("Fg_batchmix"));
	}
	/**
	 * 是否批次管理(0否，1是)
	 * @param Fg_batchmix
	 */
	public void setFg_batchmix(String Fg_batchmix) {
		setAttrVal("Fg_batchmix", Fg_batchmix);
	}
	/**
	 * 卫材描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 卫材描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice_in() {
		return ((FDouble) getAttrVal("Price_in"));
	}
	/**
	 * 单价
	 * @param Price_in
	 */
	public void setPrice_in(FDouble Price_in) {
		setAttrVal("Price_in", Price_in);
	}
}