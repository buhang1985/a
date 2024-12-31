package iih.bl.st.blstdetaildto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 结算明细 DTO数据 
 * 
 */
public class BlStDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 项目ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpac() {
		return ((String) getAttrVal("Spac"));
	}
	/**
	 * 规格
	 * @param Spac
	 */
	public void setSpac(String Spac) {
		setAttrVal("Spac", Spac);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUtil() {
		return ((String) getAttrVal("Util"));
	}
	/**
	 * 单位
	 * @param Util
	 */
	public void setUtil(String Util) {
		setAttrVal("Util", Util);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getQuan() {
		return ((String) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(String Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 单价
	 * @return String
	 */
	public String getPrice() {
		return ((String) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(String Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 账单项
	 * @return String
	 */
	public String getName_inc_itm() {
		return ((String) getAttrVal("Name_inc_itm"));
	}
	/**
	 * 账单项
	 * @param Name_inc_itm
	 */
	public void setName_inc_itm(String Name_inc_itm) {
		setAttrVal("Name_inc_itm", Name_inc_itm);
	}
}