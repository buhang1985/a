package iih.en.doc.pregdoc.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class PregDocQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 产科建档id
	 * @return String
	 */
	public String getId_pergdoc() {
		return ((String) getAttrVal("Id_pergdoc"));
	}
	/**
	 * 产科建档id
	 * @param Id_pergdoc
	 */
	public void setId_pergdoc(String Id_pergdoc) {
		setAttrVal("Id_pergdoc", Id_pergdoc);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 卡号key
	 * @return String
	 */
	public String getKey_pat() {
		return ((String) getAttrVal("Key_pat"));
	}
	/**
	 * 卡号key
	 * @param Key_pat
	 */
	public void setKey_pat(String Key_pat) {
		setAttrVal("Key_pat", Key_pat);
	}
	/**
	 * 卡号value
	 * @return String
	 */
	public String getValue_pat() {
		return ((String) getAttrVal("Value_pat"));
	}
	/**
	 * 卡号value
	 * @param Value_pat
	 */
	public void setValue_pat(String Value_pat) {
		setAttrVal("Value_pat", Value_pat);
	}
	/**
	 * 预产期开始时间
	 * @return FDate
	 */
	public FDate getD_except_b() {
		return ((FDate) getAttrVal("D_except_b"));
	}
	/**
	 * 预产期开始时间
	 * @param D_except_b
	 */
	public void setD_except_b(FDate D_except_b) {
		setAttrVal("D_except_b", D_except_b);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getD_except_e() {
		return ((FDate) getAttrVal("D_except_e"));
	}
	/**
	 * 结束时间
	 * @param D_except_e
	 */
	public void setD_except_e(FDate D_except_e) {
		setAttrVal("D_except_e", D_except_e);
	}
	/**
	 * 预约
	 * @return String
	 */
	public String getSd_status_appt() {
		return ((String) getAttrVal("Sd_status_appt"));
	}
	/**
	 * 预约
	 * @param Sd_status_appt
	 */
	public void setSd_status_appt(String Sd_status_appt) {
		setAttrVal("Sd_status_appt", Sd_status_appt);
	}
	/**
	 * 建档
	 * @return String
	 */
	public String getSd_status_doc() {
		return ((String) getAttrVal("Sd_status_doc"));
	}
	/**
	 * 建档
	 * @param Sd_status_doc
	 */
	public void setSd_status_doc(String Sd_status_doc) {
		setAttrVal("Sd_status_doc", Sd_status_doc);
	}
	/**
	 * 证件类型id
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 证件类型id
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 预产期时间
	 * @return FBoolean
	 */
	public FBoolean getFg_check_except() {
		return ((FBoolean) getAttrVal("Fg_check_except"));
	}
	/**
	 * 预产期时间
	 * @param Fg_check_except
	 */
	public void setFg_check_except(FBoolean Fg_check_except) {
		setAttrVal("Fg_check_except", Fg_check_except);
	}
	/**
	 * 建档时间标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dt_doc() {
		return ((FBoolean) getAttrVal("Fg_dt_doc"));
	}
	/**
	 * 建档时间标识
	 * @param Fg_dt_doc
	 */
	public void setFg_dt_doc(FBoolean Fg_dt_doc) {
		setAttrVal("Fg_dt_doc", Fg_dt_doc);
	}
	/**
	 * 建档开始时间
	 * @return FDate
	 */
	public FDate getDt_doc_b() {
		return ((FDate) getAttrVal("Dt_doc_b"));
	}
	/**
	 * 建档开始时间
	 * @param Dt_doc_b
	 */
	public void setDt_doc_b(FDate Dt_doc_b) {
		setAttrVal("Dt_doc_b", Dt_doc_b);
	}
	/**
	 * 建档结束时间
	 * @return FDate
	 */
	public FDate getDt_doc_e() {
		return ((FDate) getAttrVal("Dt_doc_e"));
	}
	/**
	 * 建档结束时间
	 * @param Dt_doc_e
	 */
	public void setDt_doc_e(FDate Dt_doc_e) {
		setAttrVal("Dt_doc_e", Dt_doc_e);
	}
	/**
	 * 预约时间标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dt_appt() {
		return ((FBoolean) getAttrVal("Fg_dt_appt"));
	}
	/**
	 * 预约时间标识
	 * @param Fg_dt_appt
	 */
	public void setFg_dt_appt(FBoolean Fg_dt_appt) {
		setAttrVal("Fg_dt_appt", Fg_dt_appt);
	}
	/**
	 * 预约开始时间
	 * @return FDate
	 */
	public FDate getDt_appt_b() {
		return ((FDate) getAttrVal("Dt_appt_b"));
	}
	/**
	 * 预约开始时间
	 * @param Dt_appt_b
	 */
	public void setDt_appt_b(FDate Dt_appt_b) {
		setAttrVal("Dt_appt_b", Dt_appt_b);
	}
	/**
	 * 预约结束时间
	 * @return FDate
	 */
	public FDate getDt_appt_e() {
		return ((FDate) getAttrVal("Dt_appt_e"));
	}
	/**
	 * 预约结束时间
	 * @param Dt_appt_e
	 */
	public void setDt_appt_e(FDate Dt_appt_e) {
		setAttrVal("Dt_appt_e", Dt_appt_e);
	}
	/**
	 * 体征信息标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}
	/**
	 * 体征信息标识
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 高血压标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hypert() {
		return ((FBoolean) getAttrVal("Fg_hypert"));
	}
	/**
	 * 高血压标识
	 * @param Fg_hypert
	 */
	public void setFg_hypert(FBoolean Fg_hypert) {
		setAttrVal("Fg_hypert", Fg_hypert);
	}
	/**
	 * 糖尿病妊娠标识
	 * @return FBoolean
	 */
	public FBoolean getFg_diab_preg() {
		return ((FBoolean) getAttrVal("Fg_diab_preg"));
	}
	/**
	 * 糖尿病妊娠标识
	 * @param Fg_diab_preg
	 */
	public void setFg_diab_preg(FBoolean Fg_diab_preg) {
		setAttrVal("Fg_diab_preg", Fg_diab_preg);
	}
	/**
	 * 妊娠糖尿病标识
	 * @return FBoolean
	 */
	public FBoolean getFg_preg_diab() {
		return ((FBoolean) getAttrVal("Fg_preg_diab"));
	}
	/**
	 * 妊娠糖尿病标识
	 * @param Fg_preg_diab
	 */
	public void setFg_preg_diab(FBoolean Fg_preg_diab) {
		setAttrVal("Fg_preg_diab", Fg_preg_diab);
	}
	/**
	 * 已分娩标识
	 * @return FBoolean
	 */
	public FBoolean getFg_have_born() {
		return ((FBoolean) getAttrVal("Fg_have_born"));
	}
	/**
	 * 已分娩标识
	 * @param Fg_have_born
	 */
	public void setFg_have_born(FBoolean Fg_have_born) {
		setAttrVal("Fg_have_born", Fg_have_born);
	}
	/**
	 * 早产标识
	 * @return FBoolean
	 */
	public FBoolean getFg_premature() {
		return ((FBoolean) getAttrVal("Fg_premature"));
	}
	/**
	 * 早产标识
	 * @param Fg_premature
	 */
	public void setFg_premature(FBoolean Fg_premature) {
		setAttrVal("Fg_premature", Fg_premature);
	}
	/**
	 * 建档状态标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stat() {
		return ((FBoolean) getAttrVal("Fg_stat"));
	}
	/**
	 * 建档状态标识
	 * @param Fg_stat
	 */
	public void setFg_stat(FBoolean Fg_stat) {
		setAttrVal("Fg_stat", Fg_stat);
	}
	/**
	 * 预约状态
	 * @return FBoolean
	 */
	public FBoolean getFg_appt() {
		return ((FBoolean) getAttrVal("Fg_appt"));
	}
	/**
	 * 预约状态
	 * @param Fg_appt
	 */
	public void setFg_appt(FBoolean Fg_appt) {
		setAttrVal("Fg_appt", Fg_appt);
	}
	/**
	 * 建档状态
	 * @return FBoolean
	 */
	public FBoolean getFg_reg() {
		return ((FBoolean) getAttrVal("Fg_reg"));
	}
	/**
	 * 建档状态
	 * @param Fg_reg
	 */
	public void setFg_reg(FBoolean Fg_reg) {
		setAttrVal("Fg_reg", Fg_reg);
	}
	/**
	 * 完成状态
	 * @return FBoolean
	 */
	public FBoolean getFg_fin() {
		return ((FBoolean) getAttrVal("Fg_fin"));
	}
	/**
	 * 完成状态
	 * @param Fg_fin
	 */
	public void setFg_fin(FBoolean Fg_fin) {
		setAttrVal("Fg_fin", Fg_fin);
	}
	/**
	 * 取消状态
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 取消状态
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 胎次标识
	 * @return FBoolean
	 */
	public FBoolean getFg_times_born() {
		return ((FBoolean) getAttrVal("Fg_times_born"));
	}
	/**
	 * 胎次标识
	 * @param Fg_times_born
	 */
	public void setFg_times_born(FBoolean Fg_times_born) {
		setAttrVal("Fg_times_born", Fg_times_born);
	}
	/**
	 * 开始胎次
	 * @return Integer
	 */
	public Integer getTimes_born_b() {
		return ((Integer) getAttrVal("Times_born_b"));
	}
	/**
	 * 开始胎次
	 * @param Times_born_b
	 */
	public void setTimes_born_b(Integer Times_born_b) {
		setAttrVal("Times_born_b", Times_born_b);
	}
	/**
	 * 结束胎次
	 * @return Integer
	 */
	public Integer getTimes_born_e() {
		return ((Integer) getAttrVal("Times_born_e"));
	}
	/**
	 * 结束胎次
	 * @param Times_born_e
	 */
	public void setTimes_born_e(Integer Times_born_e) {
		setAttrVal("Times_born_e", Times_born_e);
	}
	/**
	 * 孕次标识
	 * @return FBoolean
	 */
	public FBoolean getFg_times_preg() {
		return ((FBoolean) getAttrVal("Fg_times_preg"));
	}
	/**
	 * 孕次标识
	 * @param Fg_times_preg
	 */
	public void setFg_times_preg(FBoolean Fg_times_preg) {
		setAttrVal("Fg_times_preg", Fg_times_preg);
	}
	/**
	 * 开始孕次
	 * @return Integer
	 */
	public Integer getTimes_preg_b() {
		return ((Integer) getAttrVal("Times_preg_b"));
	}
	/**
	 * 开始孕次
	 * @param Times_preg_b
	 */
	public void setTimes_preg_b(Integer Times_preg_b) {
		setAttrVal("Times_preg_b", Times_preg_b);
	}
	/**
	 * 结束孕次
	 * @return Integer
	 */
	public Integer getTimes_preg_e() {
		return ((Integer) getAttrVal("Times_preg_e"));
	}
	/**
	 * 结束孕次
	 * @param Times_preg_e
	 */
	public void setTimes_preg_e(Integer Times_preg_e) {
		setAttrVal("Times_preg_e", Times_preg_e);
	}
}