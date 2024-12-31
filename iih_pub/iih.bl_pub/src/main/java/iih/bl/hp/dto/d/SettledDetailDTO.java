package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 交易费用明细 DTO数据 
 * 
 */
public class SettledDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 收费项目
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}
	/**
	 * 收费项目
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
	 * 收费等级
	 * @return String
	 */
	public String getChargelevel() {
		return ((String) getAttrVal("Chargelevel"));
	}
	/**
	 * 收费等级
	 * @param Chargelevel
	 */
	public void setChargelevel(String Chargelevel) {
		setAttrVal("Chargelevel", Chargelevel);
	}
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}
	/**
	 * 结算id
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
}