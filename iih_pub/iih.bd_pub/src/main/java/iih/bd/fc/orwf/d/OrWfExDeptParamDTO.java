package iih.bd.fc.orwf.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱流向执行部门入口参数 DTO数据 
 * 
 */
public class OrWfExDeptParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_usage() {
		return ((String) getAttrVal("Id_usage"));
	}
	/**
	 * 用法
	 * @param Id_usage
	 */
	public void setId_usage(String Id_usage) {
		setAttrVal("Id_usage", Id_usage);
	}
	/**
	 * 长期临时
	 * @return String
	 */
	public String getRecurstr() {
		return ((String) getAttrVal("Recurstr"));
	}
	/**
	 * 长期临时
	 * @param Recurstr
	 */
	public void setRecurstr(String Recurstr) {
		setAttrVal("Recurstr", Recurstr);
	}
	/**
	 * 星期数
	 * @return String
	 */
	public String getWeekno() {
		return ((String) getAttrVal("Weekno"));
	}
	/**
	 * 星期数
	 * @param Weekno
	 */
	public void setWeekno(String Weekno) {
		setAttrVal("Weekno", Weekno);
	}
	/**
	 * 时间
	 * @return FTime
	 */
	public FTime getTimestr() {
		return ((FTime) getAttrVal("Timestr"));
	}
	/**
	 * 时间
	 * @param Timestr
	 */
	public void setTimestr(FTime Timestr) {
		setAttrVal("Timestr", Timestr);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dept_en() {
		return ((String) getAttrVal("Id_dept_en"));
	}
	/**
	 * 就诊科室
	 * @param Id_dept_en
	 */
	public void setId_dept_en(String Id_dept_en) {
		setAttrVal("Id_dept_en", Id_dept_en);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dept_ns() {
		return ((String) getAttrVal("Id_dept_ns"));
	}
	/**
	 * 护理单元
	 * @param Id_dept_ns
	 */
	public void setId_dept_ns(String Id_dept_ns) {
		setAttrVal("Id_dept_ns", Id_dept_ns);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dept_or() {
		return ((String) getAttrVal("Id_dept_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dept_or
	 */
	public void setId_dept_or(String Id_dept_or) {
		setAttrVal("Id_dept_or", Id_dept_or);
	}
	/**
	 * 主执行科室
	 * @return String
	 */
	public String getId_dept_ex() {
		return ((String) getAttrVal("Id_dept_ex"));
	}
	/**
	 * 主执行科室
	 * @param Id_dept_ex
	 */
	public void setId_dept_ex(String Id_dept_ex) {
		setAttrVal("Id_dept_ex", Id_dept_ex);
	}
	/**
	 * 服务分类内码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}
	/**
	 * 服务分类内码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 流向类型
	 * @return Integer
	 */
	public Integer getEu_wftp() {
		return ((Integer) getAttrVal("Eu_wftp"));
	}
	/**
	 * 流向类型
	 * @param Eu_wftp
	 */
	public void setEu_wftp(Integer Eu_wftp) {
		setAttrVal("Eu_wftp", Eu_wftp);
	}
	/**
	 * 宏执行科室
	 * @return Integer
	 */
	public Integer getEu_macrodepmp() {
		return ((Integer) getAttrVal("Eu_macrodepmp"));
	}
	/**
	 * 宏执行科室
	 * @param Eu_macrodepmp
	 */
	public void setEu_macrodepmp(Integer Eu_macrodepmp) {
		setAttrVal("Eu_macrodepmp", Eu_macrodepmp);
	}
	/**
	 * 执行科室结果
	 * @return FArrayList
	 */
	public FArrayList getRes() {
		return ((FArrayList) getAttrVal("Res"));
	}
	/**
	 * 执行科室结果
	 * @param Res
	 */
	public void setRes(FArrayList Res) {
		setAttrVal("Res", Res);
	}
	/**
	 * 药品剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 药品剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 患者出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 患者出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 年龄等级档案
	 * @return String
	 */
	public String getId_age_level() {
		return ((String) getAttrVal("Id_age_level"));
	}
	/**
	 * 年龄等级档案
	 * @param Id_age_level
	 */
	public void setId_age_level(String Id_age_level) {
		setAttrVal("Id_age_level", Id_age_level);
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
	 * 毒麻分类
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻分类
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 草药剂型
	 * @return String
	 */
	public String getSd_herbpreparationtp() {
		return ((String) getAttrVal("Sd_herbpreparationtp"));
	}
	/**
	 * 草药剂型
	 * @param Sd_herbpreparationtp
	 */
	public void setSd_herbpreparationtp(String Sd_herbpreparationtp) {
		setAttrVal("Sd_herbpreparationtp", Sd_herbpreparationtp);
	}
	/**
	 * 是否校验医嘱内容
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_or() {
		return ((FBoolean) getAttrVal("Fg_chk_or"));
	}
	/**
	 * 是否校验医嘱内容
	 * @param Fg_chk_or
	 */
	public void setFg_chk_or(FBoolean Fg_chk_or) {
		setAttrVal("Fg_chk_or", Fg_chk_or);
	}
	/**
	 * 保留字1
	 * @return String
	 */
	public String getReserv1() {
		return ((String) getAttrVal("Reserv1"));
	}
	/**
	 * 保留字1
	 * @param Reserv1
	 */
	public void setReserv1(String Reserv1) {
		setAttrVal("Reserv1", Reserv1);
	}
	/**
	 * 保留字2
	 * @return String
	 */
	public String getReserv2() {
		return ((String) getAttrVal("Reserv2"));
	}
	/**
	 * 保留字2
	 * @param Reserv2
	 */
	public void setReserv2(String Reserv2) {
		setAttrVal("Reserv2", Reserv2);
	}
	/**
	 * 保留字3
	 * @return String
	 */
	public String getReserv3() {
		return ((String) getAttrVal("Reserv3"));
	}
	/**
	 * 保留字3
	 * @param Reserv3
	 */
	public void setReserv3(String Reserv3) {
		setAttrVal("Reserv3", Reserv3);
	}
	/**
	 * 保留字4
	 * @return String
	 */
	public String getReserv4() {
		return ((String) getAttrVal("Reserv4"));
	}
	/**
	 * 保留字4
	 * @param Reserv4
	 */
	public void setReserv4(String Reserv4) {
		setAttrVal("Reserv4", Reserv4);
	}
	/**
	 * 保留字5
	 * @return String
	 */
	public String getReserv5() {
		return ((String) getAttrVal("Reserv5"));
	}
	/**
	 * 保留字5
	 * @param Reserv5
	 */
	public void setReserv5(String Reserv5) {
		setAttrVal("Reserv5", Reserv5);
	}
	/**
	 * 录入科室
	 * @return String
	 */
	public String getId_dep_record() {
		return ((String) getAttrVal("Id_dep_record"));
	}
	/**
	 * 录入科室
	 * @param Id_dep_record
	 */
	public void setId_dep_record(String Id_dep_record) {
		setAttrVal("Id_dep_record", Id_dep_record);
	}
	/**
	 * 来源方式
	 * @return String
	 */
	public String getEu_orwfexsrcmdtp() {
		return ((String) getAttrVal("Eu_orwfexsrcmdtp"));
	}
	/**
	 * 来源方式
	 * @param Eu_orwfexsrcmdtp
	 */
	public void setEu_orwfexsrcmdtp(String Eu_orwfexsrcmdtp) {
		setAttrVal("Eu_orwfexsrcmdtp", Eu_orwfexsrcmdtp);
	}
}