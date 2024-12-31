package iih.mp.nr.dto.orderview.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱内容 DTO数据 
 * 
 */
public class OrderViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 医嘱状态ID
	 * @return String
	 */
	public String getId_su_or() {
		return ((String) getAttrVal("Id_su_or"));
	}
	/**
	 * 医嘱状态ID
	 * @param Id_su_or
	 */
	public void setId_su_or(String Id_su_or) {
		setAttrVal("Id_su_or", Id_su_or);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}
	/**
	 * 执行状态
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	/**
	 * 医嘱状态名称
	 * @return String
	 */
	public String getName_su_or() {
		return ((String) getAttrVal("Name_su_or"));
	}
	/**
	 * 医嘱状态名称
	 * @param Name_su_or
	 */
	public void setName_su_or(String Name_su_or) {
		setAttrVal("Name_su_or", Name_su_or);
	}
	/**
	 * 结果状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 结果状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 核停标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}
	/**
	 * 核停标识
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 剂量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 单位ID
	 * @return String
	 */
	public String getId_nuit_med() {
		return ((String) getAttrVal("Id_nuit_med"));
	}
	/**
	 * 单位ID
	 * @param Id_nuit_med
	 */
	public void setId_nuit_med(String Id_nuit_med) {
		setAttrVal("Id_nuit_med", Id_nuit_med);
	}
	/**
	 * 剂量单位名称
	 * @return String
	 */
	public String getName_nuit_med() {
		return ((String) getAttrVal("Name_nuit_med"));
	}
	/**
	 * 剂量单位名称
	 * @param Name_nuit_med
	 */
	public void setName_nuit_med(String Name_nuit_med) {
		setAttrVal("Name_nuit_med", Name_nuit_med);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 生效时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 停止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 停止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 停止医生
	 * @return String
	 */
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}
	/**
	 * 停止医生
	 * @param Id_emp_stop
	 */
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	/**
	 * 停止医生名称
	 * @return String
	 */
	public String getName_emp_stop() {
		return ((String) getAttrVal("Name_emp_stop"));
	}
	/**
	 * 停止医生名称
	 * @param Name_emp_stop
	 */
	public void setName_emp_stop(String Name_emp_stop) {
		setAttrVal("Name_emp_stop", Name_emp_stop);
	}
	/**
	 * 停止护士
	 * @return String
	 */
	public String getId_emp_chk_stop() {
		return ((String) getAttrVal("Id_emp_chk_stop"));
	}
	/**
	 * 停止护士
	 * @param Id_emp_chk_stop
	 */
	public void setId_emp_chk_stop(String Id_emp_chk_stop) {
		setAttrVal("Id_emp_chk_stop", Id_emp_chk_stop);
	}
	/**
	 * 停止护士名称
	 * @return String
	 */
	public String getName_emp_chk_stop() {
		return ((String) getAttrVal("Name_emp_chk_stop"));
	}
	/**
	 * 停止护士名称
	 * @param Name_emp_chk_stop
	 */
	public void setName_emp_chk_stop(String Name_emp_chk_stop) {
		setAttrVal("Name_emp_chk_stop", Name_emp_chk_stop);
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
	 * 执行科室
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}
	/**
	 * 确认时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 停止确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk_stop() {
		return ((FDateTime) getAttrVal("Dt_chk_stop"));
	}
	/**
	 * 停止确认时间
	 * @param Dt_chk_stop
	 */
	public void setDt_chk_stop(FDateTime Dt_chk_stop) {
		setAttrVal("Dt_chk_stop", Dt_chk_stop);
	}
	/**
	 * 服务类型编号
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编号
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务类型ID
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型ID
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱来源ID
	 * @return String
	 */
	public String getId_orsrcfun() {
		return ((String) getAttrVal("Id_orsrcfun"));
	}
	/**
	 * 医嘱来源ID
	 * @param Id_orsrcfun
	 */
	public void setId_orsrcfun(String Id_orsrcfun) {
		setAttrVal("Id_orsrcfun", Id_orsrcfun);
	}
	/**
	 * 医嘱来源编码
	 * @return String
	 */
	public String getSd_orsrcfun() {
		return ((String) getAttrVal("Sd_orsrcfun"));
	}
	/**
	 * 医嘱来源编码
	 * @param Sd_orsrcfun
	 */
	public void setSd_orsrcfun(String Sd_orsrcfun) {
		setAttrVal("Sd_orsrcfun", Sd_orsrcfun);
	}
}