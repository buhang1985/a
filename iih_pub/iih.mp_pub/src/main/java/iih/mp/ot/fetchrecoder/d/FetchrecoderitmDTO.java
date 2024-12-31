package iih.mp.ot.fetchrecoder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 取血列信息 DTO数据 
 * 
 */
public class FetchrecoderitmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 备血检验结果明细主键
	 * @return String
	 */
	public String getId_rptbttestitm() {
		return ((String) getAttrVal("Id_rptbttestitm"));
	}
	/**
	 * 备血检验结果明细主键
	 * @param Id_rptbttestitm
	 */
	public void setId_rptbttestitm(String Id_rptbttestitm) {
		setAttrVal("Id_rptbttestitm", Id_rptbttestitm);
	}
	/**
	 * 血液成分
	 * @return String
	 */
	public String getName_bt() {
		return ((String) getAttrVal("Name_bt"));
	}
	/**
	 * 血液成分
	 * @param Name_bt
	 */
	public void setName_bt(String Name_bt) {
		setAttrVal("Name_bt", Name_bt);
	}
	/**
	 * 血袋条形码
	 * @return String
	 */
	public String getBarcode_bb() {
		return ((String) getAttrVal("Barcode_bb"));
	}
	/**
	 * 血袋条形码
	 * @param Barcode_bb
	 */
	public void setBarcode_bb(String Barcode_bb) {
		setAttrVal("Barcode_bb", Barcode_bb);
	}
	/**
	 * 血袋规格
	 * @return Integer
	 */
	public Integer getNum_bb() {
		return ((Integer) getAttrVal("Num_bb"));
	}
	/**
	 * 血袋规格
	 * @param Num_bb
	 */
	public void setNum_bb(Integer Num_bb) {
		setAttrVal("Num_bb", Num_bb);
	}
	/**
	 * 血袋规格单位
	 * @return String
	 */
	public String getId_unit_bb_name() {
		return ((String) getAttrVal("Id_unit_bb_name"));
	}
	/**
	 * 血袋规格单位
	 * @param Id_unit_bb_name
	 */
	public void setId_unit_bb_name(String Id_unit_bb_name) {
		setAttrVal("Id_unit_bb_name", Id_unit_bb_name);
	}
	/**
	 * 配血血型
	 * @return String
	 */
	public String getId_abo_bt_name() {
		return ((String) getAttrVal("Id_abo_bt_name"));
	}
	/**
	 * 配血血型
	 * @param Id_abo_bt_name
	 */
	public void setId_abo_bt_name(String Id_abo_bt_name) {
		setAttrVal("Id_abo_bt_name", Id_abo_bt_name);
	}
	/**
	 * 配血RH
	 * @return String
	 */
	public String getNd_rh_bt() {
		return ((String) getAttrVal("Nd_rh_bt"));
	}
	/**
	 * 配血RH
	 * @param Nd_rh_bt
	 */
	public void setNd_rh_bt(String Nd_rh_bt) {
		setAttrVal("Nd_rh_bt", Nd_rh_bt);
	}
	/**
	 * 配血时间
	 * @return FDateTime
	 */
	public FDateTime getDt_restitm() {
		return ((FDateTime) getAttrVal("Dt_restitm"));
	}
	/**
	 * 配血时间
	 * @param Dt_restitm
	 */
	public void setDt_restitm(FDateTime Dt_restitm) {
		setAttrVal("Dt_restitm", Dt_restitm);
	}
	/**
	 * 配血人
	 * @return String
	 */
	public String getId_emp_testitm_name() {
		return ((String) getAttrVal("Id_emp_testitm_name"));
	}
	/**
	 * 配血人
	 * @param Id_emp_testitm_name
	 */
	public void setId_emp_testitm_name(String Id_emp_testitm_name) {
		setAttrVal("Id_emp_testitm_name", Id_emp_testitm_name);
	}
	/**
	 * 取血时间
	 * @return FDateTime
	 */
	public FDateTime getDt_senttim() {
		return ((FDateTime) getAttrVal("Dt_senttim"));
	}
	/**
	 * 取血时间
	 * @param Dt_senttim
	 */
	public void setDt_senttim(FDateTime Dt_senttim) {
		setAttrVal("Dt_senttim", Dt_senttim);
	}
	/**
	 * 取血人
	 * @return String
	 */
	public String getId_emp_sentitm_name() {
		return ((String) getAttrVal("Id_emp_sentitm_name"));
	}
	/**
	 * 取血人
	 * @param Id_emp_sentitm_name
	 */
	public void setId_emp_sentitm_name(String Id_emp_sentitm_name) {
		setAttrVal("Id_emp_sentitm_name", Id_emp_sentitm_name);
	}
	/**
	 * 取血标识
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 取血标识
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 取血人Id
	 * @return String
	 */
	public String getId_emp_sentitm() {
		return ((String) getAttrVal("Id_emp_sentitm"));
	}
	/**
	 * 取血人Id
	 * @param Id_emp_sentitm
	 */
	public void setId_emp_sentitm(String Id_emp_sentitm) {
		setAttrVal("Id_emp_sentitm", Id_emp_sentitm);
	}
	/**
	 * 取血单
	 * @return String
	 */
	public String getId_tb() {
		return ((String) getAttrVal("Id_tb"));
	}
	/**
	 * 取血单
	 * @param Id_tb
	 */
	public void setId_tb(String Id_tb) {
		setAttrVal("Id_tb", Id_tb);
	}
}