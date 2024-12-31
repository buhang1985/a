package iih.mp.dg.dto.ipdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院发药汇总 DTO数据 
 * 
 */
public class IpDgDispSumDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 药品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 请领单位
	 * @return String
	 */
	public String getId_pkgu_ap() {
		return ((String) getAttrVal("Id_pkgu_ap"));
	}
	/**
	 * 请领单位
	 * @param Id_pkgu_ap
	 */
	public void setId_pkgu_ap(String Id_pkgu_ap) {
		setAttrVal("Id_pkgu_ap", Id_pkgu_ap);
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
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 标志
	 * @return String
	 */
	public String getSign() {
		return ((String) getAttrVal("Sign"));
	}
	/**
	 * 标志
	 * @param Sign
	 */
	public void setSign(String Sign) {
		setAttrVal("Sign", Sign);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan_total() {
		return ((FDouble) getAttrVal("Quan_total"));
	}
	/**
	 * 数量
	 * @param Quan_total
	 */
	public void setQuan_total(FDouble Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getName_pkgu_ap() {
		return ((String) getAttrVal("Name_pkgu_ap"));
	}
	/**
	 * 单位
	 * @param Name_pkgu_ap
	 */
	public void setName_pkgu_ap(String Name_pkgu_ap) {
		setAttrVal("Name_pkgu_ap", Name_pkgu_ap);
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
	 * 厂家
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}
	/**
	 * 厂家
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}
	/**
	 * 药品状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 药品状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders_or() {
		return ((Integer) getAttrVal("Orders_or"));
	}
	/**
	 * 医嘱付数
	 * @param Orders_or
	 */
	public void setOrders_or(Integer Orders_or) {
		setAttrVal("Orders_or", Orders_or);
	}
	/**
	 * 合计金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 合计金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 行号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 行号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
}