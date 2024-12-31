package iih.ci.ord.dws.ip.ems.d.b;

import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class BaseDrugsViewDTO extends OrderListViewDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 物品绑定时机Id-当前就诊类型
	 * @return String
	 */
	public String getId_mmbind() {
		return ((String) getAttrVal("Id_mmbind"));
	}
	/**
	 * 物品绑定时机Id-当前就诊类型
	 * @param Id_mmbind
	 */
	public void setId_mmbind(String Id_mmbind) {
		setAttrVal("Id_mmbind", Id_mmbind);
	}
	/**
	 * 物品绑定时机Sd-当前就诊类型
	 * @return String
	 */
	public String getSd_mmbind() {
		return ((String) getAttrVal("Sd_mmbind"));
	}
	/**
	 * 物品绑定时机Sd-当前就诊类型
	 * @param Sd_mmbind
	 */
	public void setSd_mmbind(String Sd_mmbind) {
		setAttrVal("Sd_mmbind", Sd_mmbind);
	}
	
	/**
	 * 抗菌药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_anti() {
		return ((FBoolean) getAttrVal("Fg_anti"));
	}
	/**
	 * 抗菌药标志
	 * @param Fg_anti
	 */
	public void setFg_anti(FBoolean Fg_anti) {
		setAttrVal("Fg_anti", Fg_anti);
	}
	
	
	/**
	 * 零售单位名称
	 * @return String
	 */
	public String getName_unit_sale() {
		return ((String) getAttrVal("Name_unit_sale"));
	}
	/**
	 * 零售单位名称
	 * @param Name_unit_sale
	 */
	public void setName_unit_sale(String Name_unit_sale) {
		setAttrVal("Name_unit_sale", Name_unit_sale);
	}
	

	/**
	 * 毒麻分类
	 * @return String
	 */
	public String getId_pois() {
		return ((String) getAttrVal("Id_pois"));
	}
	/**
	 * 毒麻分类
	 * @param Id_pois
	 */
	public void setId_pois(String Id_pois) {
		setAttrVal("Id_pois", Id_pois);
	}
	/**
	 * 毒麻分类编码
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻分类编码
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 抗菌药分类
	 * @return String
	 */
	public String getId_anti() {
		return ((String) getAttrVal("Id_anti"));
	}
	/**
	 * 抗菌药分类
	 * @param Id_anti
	 */
	public void setId_anti(String Id_anti) {
		setAttrVal("Id_anti", Id_anti);
	}
	/**
	 * 抗菌药分类编码
	 * @return String
	 */
	public String getSd_anti() {
		return ((String) getAttrVal("Sd_anti"));
	}
	/**
	 * 抗菌药分类编码
	 * @param Sd_anti
	 */
	public void setSd_anti(String Sd_anti) {
		setAttrVal("Sd_anti", Sd_anti);
	}
	/**
	 * 物品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}
	/**
	 * 物品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
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
	 * 毒麻标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pois() {
		return ((FBoolean) getAttrVal("Fg_pois"));
	}
	/**
	 * 毒麻标识
	 * @param Fg_pois
	 */
	public void setFg_pois(FBoolean Fg_pois) {
		setAttrVal("Fg_pois", Fg_pois);
	}
	/**
	 * 默认煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 默认煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 默认煎法名称
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 默认煎法名称
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 默认煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 默认煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 默认煎法要求名称
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}
	/**
	 * 默认煎法要求名称
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}
	/**
	 * 取整模式
	 * @param Sd_mupkgutp
	 */
	public void setSd_mupkgutp(String Sd_mupkgutp) {
		setAttrVal("Sd_mupkgutp", Sd_mupkgutp);
	}
	/**
	 * 取整模式
	 * @param Sd_mupkgutp
	 */
	public String getSd_mupkgutp() {
		return ((String) getAttrVal("Sd_mupkgutp"));
	}
}
