package iih.ci.ord.dws.ip.ems.d;

import xap.mw.coreitf.d.*;
import iih.ci.ord.dws.ip.ems.d.b.BaseDrugsViewDTO;

/**
 * 西药医疗单 DTO数据 
 * 
 */
public class EmsDrugsViewDTO extends BaseDrugsViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药房ID
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 药房ID
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 药房
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 药房
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 药房过滤条件
	 * @return String
	 */
	public String getFilter_dep_wh() {
		return ((String) getAttrVal("Filter_dep_wh"));
	}
	/**
	 * 药房过滤条件
	 * @param Filter_dep_wh
	 */
	public void setFilter_dep_wh(String Filter_dep_wh) {
		setAttrVal("Filter_dep_wh", Filter_dep_wh);
	}
	/**
	 * 是否自备药
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}
	/**
	 * 是否自备药
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
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
	 * 首日执行次数
	 * @return Integer
	 */
	public Integer getQuan_firday_mp() {
		return ((Integer) getAttrVal("Quan_firday_mp"));
	}
	/**
	 * 首日执行次数
	 * @param Quan_firday_mp
	 */
	public void setQuan_firday_mp(Integer Quan_firday_mp) {
		setAttrVal("Quan_firday_mp", Quan_firday_mp);
	}
	/**
	 * 抗菌药用药目的ID
	 * @return String
	 */
	public String getId_antipurpose() {
		return ((String) getAttrVal("Id_antipurpose"));
	}
	/**
	 * 抗菌药用药目的ID
	 * @param Id_antipurpose
	 */
	public void setId_antipurpose(String Id_antipurpose) {
		setAttrVal("Id_antipurpose", Id_antipurpose);
	}
	/**
	 * 抗菌药用药目的编码
	 * @return String
	 */
	public String getSd_antipurpose() {
		return ((String) getAttrVal("Sd_antipurpose"));
	}
	/**
	 * 抗菌药用药目的编码
	 * @param Sd_antipurpose
	 */
	public void setSd_antipurpose(String Sd_antipurpose) {
		setAttrVal("Sd_antipurpose", Sd_antipurpose);
	}
	/**
	 * 抗菌药用药目的
	 * @return String
	 */
	public String getName_antipurpose() {
		return ((String) getAttrVal("Name_antipurpose"));
	}
	/**
	 * 抗菌药用药目的
	 * @param Name_antipurpose
	 */
	public void setName_antipurpose(String Name_antipurpose) {
		setAttrVal("Name_antipurpose", Name_antipurpose);
	}
	/**
	 * 抗菌药预防用药目的ID
	 * @return String
	 */
	public String getId_prepurpose() {
		return ((String) getAttrVal("Id_prepurpose"));
	}
	/**
	 * 抗菌药预防用药目的ID
	 * @param Id_prepurpose
	 */
	public void setId_prepurpose(String Id_prepurpose) {
		setAttrVal("Id_prepurpose", Id_prepurpose);
	}
	/**
	 * 抗菌药预防用药目的编码
	 * @return String
	 */
	public String getSd_prepurpose() {
		return ((String) getAttrVal("Sd_prepurpose"));
	}
	/**
	 * 抗菌药预防用药目的编码
	 * @param Sd_prepurpose
	 */
	public void setSd_prepurpose(String Sd_prepurpose) {
		setAttrVal("Sd_prepurpose", Sd_prepurpose);
	}
	/**
	 * 抗菌药预防用药目的
	 * @return String
	 */
	public String getName_prepurpose() {
		return ((String) getAttrVal("Name_prepurpose"));
	}
	/**
	 * 抗菌药预防用药目的
	 * @param Name_prepurpose
	 */
	public void setName_prepurpose(String Name_prepurpose) {
		setAttrVal("Name_prepurpose", Name_prepurpose);
	}
	/**
	 * 抗菌药手术预防用切口等级ID
	 * @return String
	 */
	public String getId_preincitp() {
		return ((String) getAttrVal("Id_preincitp"));
	}
	/**
	 * 抗菌药手术预防用切口等级ID
	 * @param Id_preincitp
	 */
	public void setId_preincitp(String Id_preincitp) {
		setAttrVal("Id_preincitp", Id_preincitp);
	}
	/**
	 * 抗菌药手术预防用切口等级编码
	 * @return String
	 */
	public String getSd_preincitp() {
		return ((String) getAttrVal("Sd_preincitp"));
	}
	/**
	 * 抗菌药手术预防用切口等级编码
	 * @param Sd_preincitp
	 */
	public void setSd_preincitp(String Sd_preincitp) {
		setAttrVal("Sd_preincitp", Sd_preincitp);
	}
	/**
	 * 抗菌药手术预防用切口等级
	 * @return String
	 */
	public String getName_preincitp() {
		return ((String) getAttrVal("Name_preincitp"));
	}
	/**
	 * 抗菌药手术预防用切口等级
	 * @param Name_preincitp
	 */
	public void setName_preincitp(String Name_preincitp) {
		setAttrVal("Name_preincitp", Name_preincitp);
	}
	/**
	 * 抗菌药用药原因ID
	 * @return String
	 */
	public String getId_predrugreason() {
		return ((String) getAttrVal("Id_predrugreason"));
	}
	/**
	 * 抗菌药用药原因ID
	 * @param Id_predrugreason
	 */
	public void setId_predrugreason(String Id_predrugreason) {
		setAttrVal("Id_predrugreason", Id_predrugreason);
	}
	/**
	 * 抗菌药用药原因编码
	 * @return String
	 */
	public String getSd_predrugreason() {
		return ((String) getAttrVal("Sd_predrugreason"));
	}
	/**
	 * 抗菌药用药原因编码
	 * @param Sd_predrugreason
	 */
	public void setSd_predrugreason(String Sd_predrugreason) {
		setAttrVal("Sd_predrugreason", Sd_predrugreason);
	}
	/**
	 * 抗菌药用药原因
	 * @return String
	 */
	public String getName_predrugreason() {
		return ((String) getAttrVal("Name_predrugreason"));
	}
	/**
	 * 抗菌药用药原因
	 * @param Name_predrugreason
	 */
	public void setName_predrugreason(String Name_predrugreason) {
		setAttrVal("Name_predrugreason", Name_predrugreason);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 商品名
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 商品名
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	
	/**
	 * 外配药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_extdispense() {
		return ((FBoolean) getAttrVal("Fg_extdispense"));
	}
	/**
	 * 外配药标识
	 * @param Fg_extdispense
	 */
	public void setFg_extdispense(FBoolean Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
	}
	/**
	 * 产房用药
	 * @return FBoolean
	 */
	public FBoolean getFg_deliveryroom_use() {
		return ((FBoolean) getAttrVal("Fg_deliveryroom_use"));
	}
	/**
	 * 产房用药
	 * @param Fg_deliveryroom_use
	 */
	public void setFg_deliveryroom_use(FBoolean Fg_deliveryroom_use) {
		setAttrVal("Fg_deliveryroom_use", Fg_deliveryroom_use);
	}
	/**
	 * 高危药品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_highrisk() {
		return ((FBoolean) getAttrVal("Fg_highrisk"));
	}	
	/**
	 * 高危药品标识
	 * @param Fg_highrisk
	 */
	public void setFg_highrisk(FBoolean Fg_highrisk) {
		setAttrVal("Fg_highrisk", Fg_highrisk);
	}
}