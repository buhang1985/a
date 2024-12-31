package iih.bl.pub.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;

/**
 * 账单信息 DTO数据 
 * 
 */
public class BlIihIe_bill_DTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 收据号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 收据号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 红冲账单流水号
	 * @return String
	 */
	public String getRed_rcptno() {
		return ((String) getAttrVal("Red_rcptno"));
	}
	/**
	 * 红冲账单流水号
	 * @param Red_rcptno
	 */
	public void setRed_rcptno(String Red_rcptno) {
		setAttrVal("Red_rcptno", Red_rcptno);
	}
	/**
	 * 账单码编码
	 * @return String
	 */
	public String getInccode() {
		return ((String) getAttrVal("Inccode"));
	}
	/**
	 * 账单码编码
	 * @param Inccode
	 */
	public void setInccode(String Inccode) {
		setAttrVal("Inccode", Inccode);
	}
	/**
	 * 账单码名称
	 * @return String
	 */
	public String getIncname() {
		return ((String) getAttrVal("Incname"));
	}
	/**
	 * 账单码名称
	 * @param Incname
	 */
	public void setIncname(String Incname) {
		setAttrVal("Incname", Incname);
	}
	/**
	 * 账单日期
	 * @return String
	 */
	public String getInc_dt() {
		return ((String) getAttrVal("Inc_dt"));
	}
	/**
	 * 账单日期
	 * @param Inc_dt
	 */
	public void setInc_dt(String Inc_dt) {
		setAttrVal("Inc_dt", Inc_dt);
	}
	/**
	 * 账单金额
	 * @return String
	 */
	public String getInc_amt() {
		return ((String) getAttrVal("Inc_amt"));
	}
	/**
	 * 账单金额
	 * @param Inc_amt
	 */
	public void setInc_amt(String Inc_amt) {
		setAttrVal("Inc_amt", Inc_amt);
	}
	/**
	 * 账单金额单位
	 * @return String
	 */
	public String getInc_amt_unit() {
		return ((String) getAttrVal("Inc_amt_unit"));
	}
	/**
	 * 账单金额单位
	 * @param Inc_amt_unit
	 */
	public void setInc_amt_unit(String Inc_amt_unit) {
		setAttrVal("Inc_amt_unit", Inc_amt_unit);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	
	/**
	 * BlIihIe_item_DTO  账单信息 DTO数据 
	 * @param FarrayList2
	 */
	public FArrayList2 getBliihie_item_dto()
	{
		return ((FArrayList2) getAttrVal("Bliihie_item_dto"));
	}
	/**
	 * BlIihIe_item_DTO  账单信息 DTO数据 
	 * @param BlIihIe_item_DTO
	 */
	public void setBliihie_item_dto(FArrayList2 Bliihie_item_dto) {
		setAttrVal("Bliihie_item_dto", Bliihie_item_dto);
	}
	
}