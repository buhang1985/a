package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊病理费用项目明细dto DTO数据 
 * 
 */
public class IEOpPathSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 费用项目明细id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 费用项目明细id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 收费项目编码
	 * @return String
	 */
	public String getChargeitemcode() {
		return ((String) getAttrVal("Chargeitemcode"));
	}
	/**
	 * 收费项目编码
	 * @param Chargeitemcode
	 */
	public void setChargeitemcode(String Chargeitemcode) {
		setAttrVal("Chargeitemcode", Chargeitemcode);
	}
	/**
	 * 收费项目名称
	 * @return String
	 */
	public String getChargeitemname() {
		return ((String) getAttrVal("Chargeitemname"));
	}
	/**
	 * 收费项目名称
	 * @param Chargeitemname
	 */
	public void setChargeitemname(String Chargeitemname) {
		setAttrVal("Chargeitemname", Chargeitemname);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getChargeaccount() {
		return ((String) getAttrVal("Chargeaccount"));
	}
	/**
	 * 数量
	 * @param Chargeaccount
	 */
	public void setChargeaccount(String Chargeaccount) {
		setAttrVal("Chargeaccount", Chargeaccount);
	}
	/**
	 * 单价
	 * @return String
	 */
	public String getChargeprice() {
		return ((String) getAttrVal("Chargeprice"));
	}
	/**
	 * 单价
	 * @param Chargeprice
	 */
	public void setChargeprice(String Chargeprice) {
		setAttrVal("Chargeprice", Chargeprice);
	}
}