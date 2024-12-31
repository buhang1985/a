package iih.ei.std.d.v1.mp.purchasedrug.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 采购药品明细信息 DTO数据 
 * 
 */
public class PurchaseDrugInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	/**
	 * 序号
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 原始发票日期
	 * @return String
	 */
	public String getDt_orig() {
		return ((String) getAttrVal("Dt_orig"));
	}	
	/**
	 * 原始发票日期
	 * @param Dt_orig
	 */
	public void setDt_orig(String Dt_orig) {
		setAttrVal("Dt_orig", Dt_orig);
	}
	/**
	 * 原始发票号
	 * @return String
	 */
	public String getOrig_code() {
		return ((String) getAttrVal("Orig_code"));
	}	
	/**
	 * 原始发票号
	 * @param Orig_code
	 */
	public void setOrig_code(String Orig_code) {
		setAttrVal("Orig_code", Orig_code);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode_dg() {
		return ((String) getAttrVal("Code_dg"));
	}	
	/**
	 * 药品编码
	 * @param Code_dg
	 */
	public void setCode_dg(String Code_dg) {
		setAttrVal("Code_dg", Code_dg);
	}
	/**
	 * 药品生产厂家编码
	 * @return String
	 */
	public String getCode_mfrs() {
		return ((String) getAttrVal("Code_mfrs"));
	}	
	/**
	 * 药品生产厂家编码
	 * @param Code_mfrs
	 */
	public void setCode_mfrs(String Code_mfrs) {
		setAttrVal("Code_mfrs", Code_mfrs);
	}
	/**
	 * 实际数量
	 * @return String
	 */
	public String getQuan_actual() {
		return ((String) getAttrVal("Quan_actual"));
	}	
	/**
	 * 实际数量
	 * @param Quan_actual
	 */
	public void setQuan_actual(String Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
	}
	/**
	 * 入库价格
	 * @return String
	 */
	public String getPri_act() {
		return ((String) getAttrVal("Pri_act"));
	}	
	/**
	 * 入库价格
	 * @param Pri_act
	 */
	public void setPri_act(String Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 有效期
	 * @return String
	 */
	public String getDate_expi() {
		return ((String) getAttrVal("Date_expi"));
	}	
	/**
	 * 有效期
	 * @param Date_expi
	 */
	public void setDate_expi(String Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	/**
	 * 实际单位
	 * @return String
	 */
	public String getCode_pkgu() {
		return ((String) getAttrVal("Code_pkgu"));
	}	
	/**
	 * 实际单位
	 * @param Code_pkgu
	 */
	public void setCode_pkgu(String Code_pkgu) {
		setAttrVal("Code_pkgu", Code_pkgu);
	}
}