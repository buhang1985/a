package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班释放DTO DTO数据 
 * 
 */
public class SchReleaseTaskDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 是否设置就诊类型
	 * @return FBoolean
	 */
	public FBoolean getFg_setentp() {
		return ((FBoolean) getAttrVal("Fg_setentp"));
	}
	/**
	 * 是否设置就诊类型
	 * @param Fg_setentp
	 */
	public void setFg_setentp(FBoolean Fg_setentp) {
		setAttrVal("Fg_setentp", Fg_setentp);
	}
	/**
	 * 是否自动释放号源
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_release() {
		return ((FBoolean) getAttrVal("Fg_auto_release"));
	}
	/**
	 * 是否自动释放号源
	 * @param Fg_auto_release
	 */
	public void setFg_auto_release(FBoolean Fg_auto_release) {
		setAttrVal("Fg_auto_release", Fg_auto_release);
	}
	/**
	 * 号源释放规则id
	 * @return String
	 */
	public String getId_release_rule() {
		return ((String) getAttrVal("Id_release_rule"));
	}
	/**
	 * 号源释放规则id
	 * @param Id_release_rule
	 */
	public void setId_release_rule(String Id_release_rule) {
		setAttrVal("Id_release_rule", Id_release_rule);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 开始就诊时间
	 * @return FTime
	 */
	public FTime getT_b_acpt() {
		return ((FTime) getAttrVal("T_b_acpt"));
	}
	/**
	 * 开始就诊时间
	 * @param T_b_acpt
	 */
	public void setT_b_acpt(FTime T_b_acpt) {
		setAttrVal("T_b_acpt", T_b_acpt);
	}
	/**
	 * 排班票号模式
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}
	/**
	 * 排班票号模式
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 排班开放数
	 * @return Integer
	 */
	public Integer getQuan_total_appt() {
		return ((Integer) getAttrVal("Quan_total_appt"));
	}
	/**
	 * 排班开放数
	 * @param Quan_total_appt
	 */
	public void setQuan_total_appt(Integer Quan_total_appt) {
		setAttrVal("Quan_total_appt", Quan_total_appt);
	}
	/**
	 * 排班总号源数
	 * @return Integer
	 */
	public Integer getQuan_total() {
		return ((Integer) getAttrVal("Quan_total"));
	}
	/**
	 * 排班总号源数
	 * @param Quan_total
	 */
	public void setQuan_total(Integer Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	/**
	 * 主号源池号
	 * @return Integer
	 */
	public Integer getPolno_maj() {
		return ((Integer) getAttrVal("Polno_maj"));
	}
	/**
	 * 主号源池号
	 * @param Polno_maj
	 */
	public void setPolno_maj(Integer Polno_maj) {
		setAttrVal("Polno_maj", Polno_maj);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getId_sctp() {
		return ((String) getAttrVal("Id_sctp"));
	}
	/**
	 * 类型
	 * @param Id_sctp
	 */
	public void setId_sctp(String Id_sctp) {
		setAttrVal("Id_sctp", Id_sctp);
	}
	/**
	 * 计划上备用服务
	 * @return String
	 */
	public String getId_optsrv() {
		return ((String) getAttrVal("Id_optsrv"));
	}
	/**
	 * 计划上备用服务
	 * @param Id_optsrv
	 */
	public void setId_optsrv(String Id_optsrv) {
		setAttrVal("Id_optsrv", Id_optsrv);
	}
}