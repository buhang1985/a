package iih.mp.orm.sugfeeitem.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术补录费用 DTO数据 
 * 
 */
public class SugFeeItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 补录费用主键
	 * @return String
	 */
	public String getId_sugfee() {
		return ((String) getAttrVal("Id_sugfee"));
	}
	/**
	 * 补录费用主键
	 * @param Id_sugfee
	 */
	public void setId_sugfee(String Id_sugfee) {
		setAttrVal("Id_sugfee", Id_sugfee);
	}
	/**
	 * 服务费用
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}
	/**
	 * 服务费用
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}
	/**
	 * 物品
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpace() {
		return ((String) getAttrVal("Space"));
	}
	/**
	 * 规格
	 * @param Space
	 */
	public void setSpace(String Space) {
		setAttrVal("Space", Space);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}
	/**
	 * 单位
	 * @param Unit_name
	 */
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
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
	 * 数量
	 * @return String
	 */
	public String getCount() {
		return ((String) getAttrVal("Count"));
	}
	/**
	 * 数量
	 * @param Count
	 */
	public void setCount(String Count) {
		setAttrVal("Count", Count);
	}
	/**
	 * 总金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * 总金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 账单项编码
	 * @return String
	 */
	public String getCode_inccaitm() {
		return ((String) getAttrVal("Code_inccaitm"));
	}
	/**
	 * 账单项编码
	 * @param Code_inccaitm
	 */
	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal("Code_inccaitm", Code_inccaitm);
	}
	/**
	 * 账单项名称
	 * @return String
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}
	/**
	 * 账单项名称
	 * @param Name_inccaitm
	 */
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
	}
	/**
	 * 核算项目分类编码
	 * @return String
	 */
	public String getCode_account() {
		return ((String) getAttrVal("Code_account"));
	}
	/**
	 * 核算项目分类编码
	 * @param Code_account
	 */
	public void setCode_account(String Code_account) {
		setAttrVal("Code_account", Code_account);
	}
	/**
	 * 核算项目分类名称
	 * @return String
	 */
	public String getName_account() {
		return ((String) getAttrVal("Name_account"));
	}
	/**
	 * 核算项目分类名称
	 * @param Name_account
	 */
	public void setName_account(String Name_account) {
		setAttrVal("Name_account", Name_account);
	}
}