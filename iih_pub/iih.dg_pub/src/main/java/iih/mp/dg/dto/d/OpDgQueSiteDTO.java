package iih.mp.dg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊药品对应发药窗口 DTO数据 
 * 
 */
public class OpDgQueSiteDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 站点名称
	 * @return String
	 */
	public String getName_site() {
		return ((String) getAttrVal("Name_site"));
	}
	/**
	 * 站点名称
	 * @param Name_site
	 */
	public void setName_site(String Name_site) {
		setAttrVal("Name_site", Name_site);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
}