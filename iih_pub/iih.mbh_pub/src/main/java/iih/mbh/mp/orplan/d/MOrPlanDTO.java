package iih.mbh.mp.orplan.d;

import java.util.List;

import iih.mbh.mp.entlv.d.EntLvUdidocDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;

@RPCStruct
public class MOrPlanDTO {

	// 唯一标识
	@RPCField(id = 1)
	private String id_key;
	// 长临标志
	@RPCField(id = 10)
	private boolean fg_long;
	// 医嘱停止时间
	@RPCField(id = 11)
	private String dt_end;
	// 医嘱生效时间
	@RPCField(id = 12)
	private String dt_effe;
	// 医嘱内容
	@RPCField(id = 13)
	private String content_or;
	// 医嘱备注
	@RPCField(id = 14)
	private String des_or;
	// 医疗服务类型编码
	@RPCField(id = 15)
	private String sd_srvtp;
	// 医嘱类型名称
	@RPCField(id = 16)
	private String name_srvtp;
	// 频次编码
	@RPCField(id = 17)
	private String code_freq;
	// 频次名称
	@RPCField(id = 18)
	private String name_freq;
	// 给药途径
	@RPCField(id = 19)
	private String name_route;
	// 医嘱ID
	@RPCField(id = 2)
	private String id_or;
	// 开单科室
	@RPCField(id = 20)
	private String name_dep_or;
	// 开单医生
	@RPCField(id = 21)
	private String name_emp_or;
	// 是否允许执行
	@RPCField(id = 22)
	private int enum_enable_mp;
	// 不允许执行提示
	@RPCField(id = 23)
	private String msg_tooltip;
	// 当前状态编码
	@RPCField(id = 24)
	private String code_orpltpsta;
	// 当前状态名称
	@RPCField(id = 25)
	private String name_orpltpsta;
	// 执行人ID
	@RPCField(id = 26)
	private String id_emp_mp;
	// 执行人名称
	@RPCField(id = 27)
	private String name_emp_mp;
	// 执行时间
	@RPCField(id = 28)
	private String dt_mp;
	// 处理功能编码
	@RPCField(id = 29)
	private String code_fun;
	// 执行状态
	@RPCField(id = 3)
	private int eu_su;
	// 处理功能类型
	@RPCField(id = 30)
	private String name_class;
	// 皮试标志
	@RPCField(id = 31)
	private boolean fg_skintest;
	// 本次执行需等待秒
	@RPCField(id = 32)
	private int wait_scd;
	// 诊断名称
	@RPCField(id = 33)
	private String name_diagnosis;
	// 出生日期
	@RPCField(id = 34)
	private String dt_birth;
	// 床号
	@RPCField(id = 35)
	private String name_bed;
	// 年龄
	@RPCField(id = 36)
	private String age;
	// 性别
	@RPCField(id = 37)
	private String sex;
	// 皮试结果
	@RPCField(id = 38)
	private String skin_result;
	// 皮试穿刺等待时间
	@RPCField(id = 39)
	private String wt_time;
	// 计划执行时间
	@RPCField(id = 4)
	private String dt_mp_plan;
	// 闭环状态列表
	@RPCField(id = 40)
	private List<StateAttrDTO> execstates;
	// 皮试id，仅为皮试请求用
	@RPCField(id = 41)
	private String id_skintest;
	// 滴速单位
	@RPCField(id = 42)
	private List<EntLvUdidocDTO> units;
	// 输液情况
	@RPCField(id = 43)
	private List<EntLvUdidocDTO> situations;
	// 上次巡视滴速值
	@RPCField(id = 44)
	private String last_ivgtt;
	// 上次巡视滴速单位
	@RPCField(id = 45)
	private String last_unit;
	// 用法ID
	@RPCField(id = 46)
	private String id_route;
	// 药品余量
	@RPCField(id = 47)
	private String drug_margin;
	// 就诊ID
	@RPCField(id = 5)
	private String id_ent;
	// 计划ID
	@RPCField(id = 6)
	private String id_or_pr;
	// 患者ID
	@RPCField(id = 7)
	private String id_pat;
	// 患者姓名
	@RPCField(id = 8)
	private String name_pat;
	// 就诊类型
	@RPCField(id = 9)
	private String code_entp;
	// 已执行剂量
	@RPCField(id = 48)
	private double exec_dose;

	public String getId_key() {
		return id_key;
	}

	public void setId_key(String id_key) {
		this.id_key = id_key;
	}

	public boolean getFg_long() {
		return fg_long;
	}

	public void setFg_long(boolean fg_long) {
		this.fg_long = fg_long;
	}

	public String getDt_end() {
		return dt_end;
	}

	public void setDt_end(String dt_end) {
		this.dt_end = dt_end;
	}

	public String getDt_effe() {
		return dt_effe;
	}

	public void setDt_effe(String dt_effe) {
		this.dt_effe = dt_effe;
	}

	public String getContent_or() {
		return content_or;
	}

	public void setContent_or(String content_or) {
		this.content_or = content_or;
	}

	public String getDes_or() {
		return des_or;
	}

	public void setDes_or(String des_or) {
		this.des_or = des_or;
	}

	public String getSd_srvtp() {
		return sd_srvtp;
	}

	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}

	public String getName_srvtp() {
		return name_srvtp;
	}

	public void setName_srvtp(String name_srvtp) {
		this.name_srvtp = name_srvtp;
	}

	public String getCode_freq() {
		return code_freq;
	}

	public void setCode_freq(String code_freq) {
		this.code_freq = code_freq;
	}

	public String getName_freq() {
		return name_freq;
	}

	public void setName_freq(String name_freq) {
		this.name_freq = name_freq;
	}

	public String getName_route() {
		return name_route;
	}

	public void setName_route(String name_route) {
		this.name_route = name_route;
	}

	public String getId_or() {
		return id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getName_dep_or() {
		return name_dep_or;
	}

	public void setName_dep_or(String name_dep_or) {
		this.name_dep_or = name_dep_or;
	}

	public String getName_emp_or() {
		return name_emp_or;
	}

	public void setName_emp_or(String name_emp_or) {
		this.name_emp_or = name_emp_or;
	}

	public int getEnum_enable_mp() {
		return enum_enable_mp;
	}

	public void setEnum_enable_mp(int enum_enable_mp) {
		this.enum_enable_mp = enum_enable_mp;
	}

	public String getMsg_tooltip() {
		return msg_tooltip;
	}

	public void setMsg_tooltip(String msg_tooltip) {
		this.msg_tooltip = msg_tooltip;
	}

	public String getCode_orpltpsta() {
		return code_orpltpsta;
	}

	public void setCode_orpltpsta(String code_orpltpsta) {
		this.code_orpltpsta = code_orpltpsta;
	}

	public String getName_orpltpsta() {
		return name_orpltpsta;
	}

	public void setName_orpltpsta(String name_orpltpsta) {
		this.name_orpltpsta = name_orpltpsta;
	}

	public String getId_emp_mp() {
		return id_emp_mp;
	}

	public void setId_emp_mp(String id_emp_mp) {
		this.id_emp_mp = id_emp_mp;
	}

	public String getName_emp_mp() {
		return name_emp_mp;
	}

	public void setName_emp_mp(String name_emp_mp) {
		this.name_emp_mp = name_emp_mp;
	}

	public String getDt_mp() {
		return dt_mp;
	}

	public void setDt_mp(String dt_mp) {
		this.dt_mp = dt_mp;
	}

	public String getCode_fun() {
		return code_fun;
	}

	public void setCode_fun(String code_fun) {
		this.code_fun = code_fun;
	}

	public int getEu_su() {
		return eu_su;
	}

	public void setEu_su(int eu_su) {
		this.eu_su = eu_su;
	}

	public String getName_class() {
		return name_class;
	}

	public void setName_class(String name_class) {
		this.name_class = name_class;
	}

	public boolean getFg_skintest() {
		return fg_skintest;
	}

	public void setFg_skintest(boolean fg_skintest) {
		this.fg_skintest = fg_skintest;
	}

	public int getWait_scd() {
		return wait_scd;
	}

	public void setWait_scd(int wait_scd) {
		this.wait_scd = wait_scd;
	}

	public String getName_diagnosis() {
		return name_diagnosis;
	}

	public void setName_diagnosis(String name_diagnosis) {
		this.name_diagnosis = name_diagnosis;
	}

	public String getDt_birth() {
		return dt_birth;
	}

	public void setDt_birth(String dt_birth) {
		this.dt_birth = dt_birth;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSkin_result() {
		return skin_result;
	}

	public void setSkin_result(String skin_result) {
		this.skin_result = skin_result;
	}

	public String getWt_time() {
		return wt_time;
	}

	public void setWt_time(String wt_time) {
		this.wt_time = wt_time;
	}

	public String getDt_mp_plan() {
		return dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan) {
		this.dt_mp_plan = dt_mp_plan;
	}

	public List<StateAttrDTO> getExecstates() {
		return execstates;
	}

	public void setExecstates(List<StateAttrDTO> execstates) {
		this.execstates = execstates;
	}

	public String getId_skintest() {
		return id_skintest;
	}

	public void setId_skintest(String id_skintest) {
		this.id_skintest = id_skintest;
	}

	public List<EntLvUdidocDTO> getUnits() {
		return units;
	}

	public void setUnits(List<EntLvUdidocDTO> units) {
		this.units = units;
	}

	public List<EntLvUdidocDTO> getSituations() {
		return situations;
	}

	public void setSituations(List<EntLvUdidocDTO> situations) {
		this.situations = situations;
	}

	public String getLast_ivgtt() {
		return last_ivgtt;
	}

	public void setLast_ivgtt(String last_ivgtt) {
		this.last_ivgtt = last_ivgtt;
	}

	public String getLast_unit() {
		return last_unit;
	}

	public void setLast_unit(String last_unit) {
		this.last_unit = last_unit;
	}

	public String getId_route() {
		return id_route;
	}

	public void setId_route(String id_route) {
		this.id_route = id_route;
	}

	public String getDrug_margin() {
		return drug_margin;
	}

	public void setDrug_margin(String drug_margin) {
		this.drug_margin = drug_margin;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getId_or_pr() {
		return id_or_pr;
	}

	public void setId_or_pr(String id_or_pr) {
		this.id_or_pr = id_or_pr;
	}

	public String getId_pat() {
		return id_pat;
	}

	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getCode_entp() {
		return code_entp;
	}

	public void setCode_entp(String code_entp) {
		this.code_entp = code_entp;
	}

	public double getExec_dose() {
		return exec_dose;
	}

	public void setExec_dose(double exec_dose) {
		this.exec_dose = exec_dose;
	}

}
