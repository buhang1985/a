package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技预约规则DTO DTO数据 
 * 
 */
public class ScMtApt4RuleDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 规则校验类别
	 * @return String
	 */
	public String getRule_type() {
		return ((String) getAttrVal("Rule_type"));
	}
	/**
	 * 规则校验类别
	 * @param Rule_type
	 */
	public void setRule_type(String Rule_type) {
		setAttrVal("Rule_type", Rule_type);
	}
	/**
	 * 爽约退约次数
	 * @return Integer
	 */
	public Integer getTimes_canc_fails() {
		return ((Integer) getAttrVal("Times_canc_fails"));
	}
	/**
	 * 爽约退约次数
	 * @param Times_canc_fails
	 */
	public void setTimes_canc_fails(Integer Times_canc_fails) {
		setAttrVal("Times_canc_fails", Times_canc_fails);
	}
	/**
	 * 正常退约次数
	 * @return Integer
	 */
	public Integer getTimes_canc_norm() {
		return ((Integer) getAttrVal("Times_canc_norm"));
	}
	/**
	 * 正常退约次数
	 * @param Times_canc_norm
	 */
	public void setTimes_canc_norm(Integer Times_canc_norm) {
		setAttrVal("Times_canc_norm", Times_canc_norm);
	}
	/**
	 * 限制时间内退约次数
	 * @return Integer
	 */
	public Integer getTimes_canc_emg() {
		return ((Integer) getAttrVal("Times_canc_emg"));
	}
	/**
	 * 限制时间内退约次数
	 * @param Times_canc_emg
	 */
	public void setTimes_canc_emg(Integer Times_canc_emg) {
		setAttrVal("Times_canc_emg", Times_canc_emg);
	}
	/**
	 * 自助预约次数
	 * @return Integer
	 */
	public Integer getTimes_selfapt() {
		return ((Integer) getAttrVal("Times_selfapt"));
	}
	/**
	 * 自助预约次数
	 * @param Times_selfapt
	 */
	public void setTimes_selfapt(Integer Times_selfapt) {
		setAttrVal("Times_selfapt", Times_selfapt);
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
	 * 预约开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 预约开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 当前时间
	 * @return FDateTime
	 */
	public FDateTime getNow() {
		return ((FDateTime) getAttrVal("Now"));
	}
	/**
	 * 当前时间
	 * @param Now
	 */
	public void setNow(FDateTime Now) {
		setAttrVal("Now", Now);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室id
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 渠道id
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 渠道id
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 排班分类id
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类id
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 预约记录id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约记录id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 退约类型
	 * @return String
	 */
	public String getCanc_apt_type() {
		return ((String) getAttrVal("Canc_apt_type"));
	}
	/**
	 * 退约类型
	 * @param Canc_apt_type
	 */
	public void setCanc_apt_type(String Canc_apt_type) {
		setAttrVal("Canc_apt_type", Canc_apt_type);
	}
	/**
	 * 渠道编码
	 * @return String
	 */
	public String getChl_type() {
		return ((String) getAttrVal("Chl_type"));
	}
	/**
	 * 渠道编码
	 * @param Chl_type
	 */
	public void setChl_type(String Chl_type) {
		setAttrVal("Chl_type", Chl_type);
	}
}