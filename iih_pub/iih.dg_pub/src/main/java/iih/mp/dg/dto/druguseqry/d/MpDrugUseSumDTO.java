package iih.mp.dg.dto.druguseqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 用药查询药品汇总 DTO数据 
 * 
 */
public class MpDrugUseSumDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	/**
	 * 单位id
	 * @return String
	 */
	public String getId_unit_pkg() {
		return ((String) getAttrVal("Id_unit_pkg"));
	}
	/**
	 * 单位id
	 * @param Id_unit_pkg
	 */
	public void setId_unit_pkg(String Id_unit_pkg) {
		setAttrVal("Id_unit_pkg", Id_unit_pkg);
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
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
}