package iih.en.doc.pregdoc.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 建档信息dto DTO数据 
 * 
 */
public class PregDocInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 建档主键
	 * @return String
	 */
	public String getId_entdoc() {
		return ((String) getAttrVal("Id_entdoc"));
	}
	/**
	 * 建档主键
	 * @param Id_entdoc
	 */
	public void setId_entdoc(String Id_entdoc) {
		setAttrVal("Id_entdoc", Id_entdoc);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者信息主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者信息主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 产科建档主键
	 * @return String
	 */
	public String getId_pregdoc() {
		return ((String) getAttrVal("Id_pregdoc"));
	}
	/**
	 * 产科建档主键
	 * @param Id_pregdoc
	 */
	public void setId_pregdoc(String Id_pregdoc) {
		setAttrVal("Id_pregdoc", Id_pregdoc);
	}
	/**
	 * 建档时间
	 * @return FDateTime
	 */
	public FDateTime getDt_doc() {
		return ((FDateTime) getAttrVal("Dt_doc"));
	}
	/**
	 * 建档时间
	 * @param Dt_doc
	 */
	public void setDt_doc(FDateTime Dt_doc) {
		setAttrVal("Dt_doc", Dt_doc);
	}
	/**
	 * 预产期
	 * @return FDate
	 */
	public FDate getD_expect() {
		return ((FDate) getAttrVal("D_expect"));
	}
	/**
	 * 预产期
	 * @param D_expect
	 */
	public void setD_expect(FDate D_expect) {
		setAttrVal("D_expect", D_expect);
	}
	/**
	 * 预约日期
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 预约日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 预约状态sd
	 * @return String
	 */
	public String getSd_status_apt() {
		return ((String) getAttrVal("Sd_status_apt"));
	}
	/**
	 * 预约状态sd
	 * @param Sd_status_apt
	 */
	public void setSd_status_apt(String Sd_status_apt) {
		setAttrVal("Sd_status_apt", Sd_status_apt);
	}
	/**
	 * 短信发送状态
	 * @return String
	 */
	public String getNote_status() {
		return ((String) getAttrVal("Note_status"));
	}
	/**
	 * 短信发送状态
	 * @param Note_status
	 */
	public void setNote_status(String Note_status) {
		setAttrVal("Note_status", Note_status);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt_op() {
		return ((FDateTime) getAttrVal("Dt_acpt_op"));
	}
	/**
	 * 就诊时间
	 * @param Dt_acpt_op
	 */
	public void setDt_acpt_op(FDateTime Dt_acpt_op) {
		setAttrVal("Dt_acpt_op", Dt_acpt_op);
	}
	/**
	 * 手机号
	 * @return String
	 */
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}
	/**
	 * 手机号
	 * @param Telno_pat
	 */
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	/**
	 * 预约ID
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约ID
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 短信内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 短信内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 预约状态名称
	 * @return String
	 */
	public String getName_status_apt() {
		return ((String) getAttrVal("Name_status_apt"));
	}
	/**
	 * 预约状态名称
	 * @param Name_status_apt
	 */
	public void setName_status_apt(String Name_status_apt) {
		setAttrVal("Name_status_apt", Name_status_apt);
	}
	/**
	 * 就诊状态名称
	 * @return String
	 */
	public String getName_status_en() {
		return ((String) getAttrVal("Name_status_en"));
	}
	/**
	 * 就诊状态名称
	 * @param Name_status_en
	 */
	public void setName_status_en(String Name_status_en) {
		setAttrVal("Name_status_en", Name_status_en);
	}
	/**
	 * 产妇状况主键
	 * @return String
	 */
	public String getId_pregdocstat() {
		return ((String) getAttrVal("Id_pregdocstat"));
	}
	/**
	 * 产妇状况主键
	 * @param Id_pregdocstat
	 */
	public void setId_pregdocstat(String Id_pregdocstat) {
		setAttrVal("Id_pregdocstat", Id_pregdocstat);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt_ip() {
		return ((FDateTime) getAttrVal("Dt_acpt_ip"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt_ip
	 */
	public void setDt_acpt_ip(FDateTime Dt_acpt_ip) {
		setAttrVal("Dt_acpt_ip", Dt_acpt_ip);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 入院科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 入院科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
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
	 * 糖尿病妊娠
	 * @return FBoolean
	 */
	public FBoolean getFg_diab_preg() {
		return ((FBoolean) getAttrVal("Fg_diab_preg"));
	}
	/**
	 * 糖尿病妊娠
	 * @param Fg_diab_preg
	 */
	public void setFg_diab_preg(FBoolean Fg_diab_preg) {
		setAttrVal("Fg_diab_preg", Fg_diab_preg);
	}
	/**
	 * 妊娠糖尿病
	 * @return FBoolean
	 */
	public FBoolean getFg_preg_diab() {
		return ((FBoolean) getAttrVal("Fg_preg_diab"));
	}
	/**
	 * 妊娠糖尿病
	 * @param Fg_preg_diab
	 */
	public void setFg_preg_diab(FBoolean Fg_preg_diab) {
		setAttrVal("Fg_preg_diab", Fg_preg_diab);
	}
	/**
	 * 建档体重
	 * @return FDouble
	 */
	public FDouble getWeit_doc() {
		return ((FDouble) getAttrVal("Weit_doc"));
	}
	/**
	 * 建档体重
	 * @param Weit_doc
	 */
	public void setWeit_doc(FDouble Weit_doc) {
		setAttrVal("Weit_doc", Weit_doc);
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
	 * 分娩体重
	 * @return FDouble
	 */
	public FDouble getWeit_born() {
		return ((FDouble) getAttrVal("Weit_born"));
	}
	/**
	 * 分娩体重
	 * @param Weit_born
	 */
	public void setWeit_born(FDouble Weit_born) {
		setAttrVal("Weit_born", Weit_born);
	}
	/**
	 * 分娩时长(min)
	 * @return Integer
	 */
	public Integer getMins_born() {
		return ((Integer) getAttrVal("Mins_born"));
	}
	/**
	 * 分娩时长(min)
	 * @param Mins_born
	 */
	public void setMins_born(Integer Mins_born) {
		setAttrVal("Mins_born", Mins_born);
	}
	/**
	 * 产后出血量(ml)
	 * @return Integer
	 */
	public Integer getVol_out_blood() {
		return ((Integer) getAttrVal("Vol_out_blood"));
	}
	/**
	 * 产后出血量(ml)
	 * @param Vol_out_blood
	 */
	public void setVol_out_blood(Integer Vol_out_blood) {
		setAttrVal("Vol_out_blood", Vol_out_blood);
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
	 * 孕次
	 * @return Integer
	 */
	public Integer getTimes_preg() {
		return ((Integer) getAttrVal("Times_preg"));
	}
	/**
	 * 孕次
	 * @param Times_preg
	 */
	public void setTimes_preg(Integer Times_preg) {
		setAttrVal("Times_preg", Times_preg);
	}
	/**
	 * 产次
	 * @return Integer
	 */
	public Integer getTimes_born() {
		return ((Integer) getAttrVal("Times_born"));
	}
	/**
	 * 产次
	 * @param Times_born
	 */
	public void setTimes_born(Integer Times_born) {
		setAttrVal("Times_born", Times_born);
	}
}