package iih.mp.mpbd.exerepair.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 执行修复条件 DTO数据 
 * 
 */
public class ExeRepairCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 修复主键
	 * @return String
	 */
	public String getId_repair() {
		return ((String) getAttrVal("Id_repair"));
	}
	/**
	 * 修复主键
	 * @param Id_repair
	 */
	public void setId_repair(String Id_repair) {
		setAttrVal("Id_repair", Id_repair);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_ors() {
		return ((String) getAttrVal("Id_ors"));
	}
	/**
	 * 医嘱ID
	 * @param Id_ors
	 */
	public void setId_ors(String Id_ors) {
		setAttrVal("Id_ors", Id_ors);
	}
	/**
	 * 修复类型id
	 * @return String
	 */
	public String getId_repairtp() {
		return ((String) getAttrVal("Id_repairtp"));
	}
	/**
	 * 修复类型id
	 * @param Id_repairtp
	 */
	public void setId_repairtp(String Id_repairtp) {
		setAttrVal("Id_repairtp", Id_repairtp);
	}
	/**
	 * 修复类型编码
	 * @return String
	 */
	public String getSd_repairtp() {
		return ((String) getAttrVal("Sd_repairtp"));
	}
	/**
	 * 修复类型编码
	 * @param Sd_repairtp
	 */
	public void setSd_repairtp(String Sd_repairtp) {
		setAttrVal("Sd_repairtp", Sd_repairtp);
	}
	/**
	 * 修复类型
	 * @return String
	 */
	public String getName_repairtp() {
		return ((String) getAttrVal("Name_repairtp"));
	}
	/**
	 * 修复类型
	 * @param Name_repairtp
	 */
	public void setName_repairtp(String Name_repairtp) {
		setAttrVal("Name_repairtp", Name_repairtp);
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
	 * 执行科室 2
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室 2
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行人员id
	 * @return String
	 */
	public String getId_emp_mp() {
		return ((String) getAttrVal("Id_emp_mp"));
	}
	/**
	 * 执行人员id
	 * @param Id_emp_mp
	 */
	public void setId_emp_mp(String Id_emp_mp) {
		setAttrVal("Id_emp_mp", Id_emp_mp);
	}
	/**
	 * 执行人员
	 * @return String
	 */
	public String getName_emp_mp() {
		return ((String) getAttrVal("Name_emp_mp"));
	}
	/**
	 * 执行人员
	 * @param Name_emp_mp
	 */
	public void setName_emp_mp(String Name_emp_mp) {
		setAttrVal("Name_emp_mp", Name_emp_mp);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 医嘱类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * 执行状态id
	 * @return String
	 */
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}
	/**
	 * 执行状态id
	 * @param Id_su_mp
	 */
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
	}
	/**
	 * 执行状态编码
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}
	/**
	 * 执行状态编码
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getName_su_mp() {
		return ((String) getAttrVal("Name_su_mp"));
	}
	/**
	 * 执行状态
	 * @param Name_su_mp
	 */
	public void setName_su_mp(String Name_su_mp) {
		setAttrVal("Name_su_mp", Name_su_mp);
	}
	/**
	 * 修复日志
	 * @return String
	 */
	public String getLog() {
		return ((String) getAttrVal("Log"));
	}
	/**
	 * 修复日志
	 * @param Log
	 */
	public void setLog(String Log) {
		setAttrVal("Log", Log);
	}
	/**
	 * 记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}
	/**
	 * 记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 是否计算服务价格
	 * @return FBoolean
	 */
	public FBoolean getFg_price_cal() {
		return ((FBoolean) getAttrVal("Fg_price_cal"));
	}
	/**
	 * 是否计算服务价格
	 * @param Fg_price_cal
	 */
	public void setFg_price_cal(FBoolean Fg_price_cal) {
		setAttrVal("Fg_price_cal", Fg_price_cal);
	}
	/**
	 * 是否为单患者模式
	 * @return FBoolean
	 */
	public FBoolean getFg_singlepat() {
		return ((FBoolean) getAttrVal("Fg_singlepat"));
	}
	/**
	 * 是否为单患者模式
	 * @param Fg_singlepat
	 */
	public void setFg_singlepat(FBoolean Fg_singlepat) {
		setAttrVal("Fg_singlepat", Fg_singlepat);
	}
	/**
	 * 是否支持后付费
	 * @return FBoolean
	 */
	public FBoolean getFg_postpaid() {
		return ((FBoolean) getAttrVal("Fg_postpaid"));
	}
	/**
	 * 是否支持后付费
	 * @param Fg_postpaid
	 */
	public void setFg_postpaid(FBoolean Fg_postpaid) {
		setAttrVal("Fg_postpaid", Fg_postpaid);
	}
	/**
	 * 是否抛异常
	 * @return FBoolean
	 */
	public FBoolean getFg_exception() {
		return ((FBoolean) getAttrVal("Fg_exception"));
	}
	/**
	 * 是否抛异常
	 * @param Fg_exception
	 */
	public void setFg_exception(FBoolean Fg_exception) {
		setAttrVal("Fg_exception", Fg_exception);
	}
	/**
	 * 记账来源
	 * @return String
	 */
	public String getSrcfunc_des() {
		return ((String) getAttrVal("Srcfunc_des"));
	}
	/**
	 * 记账来源
	 * @param Srcfunc_des
	 */
	public void setSrcfunc_des(String Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}
	/**
	 * 皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 在院执行标记
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_in() {
		return ((FBoolean) getAttrVal("Fg_mp_in"));
	}
	/**
	 * 在院执行标记
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(FBoolean Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}
	/**
	 * 在院整领标识
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}
	/**
	 * 在院整领标识
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
}