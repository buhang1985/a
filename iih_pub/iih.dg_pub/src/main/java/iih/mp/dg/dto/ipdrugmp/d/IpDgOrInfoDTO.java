package iih.mp.dg.dto.ipdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱信息 DTO数据 
 * 
 */
public class IpDgOrInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getRownum() {
		return ((Integer) getAttrVal("Rownum"));
	}
	/**
	 * 序号
	 * @param Rownum
	 */
	public void setRownum(Integer Rownum) {
		setAttrVal("Rownum", Rownum);
	}
	/**
	 * 请领状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 请领状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 摆药状态
	 * @return Integer
	 */
	public Integer getEu_disp() {
		return ((Integer) getAttrVal("Eu_disp"));
	}
	/**
	 * 摆药状态
	 * @param Eu_disp
	 */
	public void setEu_disp(Integer Eu_disp) {
		setAttrVal("Eu_disp", Eu_disp);
	}
	/**
	 * 生成标志
	 * @return Integer
	 */
	public Integer getSign() {
		return ((Integer) getAttrVal("Sign"));
	}
	/**
	 * 生成标志
	 * @param Sign
	 */
	public void setSign(Integer Sign) {
		setAttrVal("Sign", Sign);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}
	/**
	 * 床号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * 病历号
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 病历号
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 病人ID
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 病人ID
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}
	/**
	 * 性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}
	/**
	 * 年龄
	 * @param Age_pat
	 */
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}
	/**
	 * 诊断
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 医嘱内容
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
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
	 * 医嘱服务ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 婴儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标志
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 加急标志
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 退药数量
	 * @return FDouble
	 */
	public FDouble getQuan_ret() {
		return ((FDouble) getAttrVal("Quan_ret"));
	}
	/**
	 * 退药数量
	 * @param Quan_ret
	 */
	public void setQuan_ret(FDouble Quan_ret) {
		setAttrVal("Quan_ret", Quan_ret);
	}
	/**
	 * 无效
	 * @return FBoolean
	 */
	public FBoolean getFg_invalid() {
		return ((FBoolean) getAttrVal("Fg_invalid"));
	}
	/**
	 * 无效
	 * @param Fg_invalid
	 */
	public void setFg_invalid(FBoolean Fg_invalid) {
		setAttrVal("Fg_invalid", Fg_invalid);
	}
	/**
	 * 首日不摆药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_firstdaynotset() {
		return ((FBoolean) getAttrVal("Fg_firstdaynotset"));
	}
	/**
	 * 首日不摆药标识
	 * @param Fg_firstdaynotset
	 */
	public void setFg_firstdaynotset(FBoolean Fg_firstdaynotset) {
		setAttrVal("Fg_firstdaynotset", Fg_firstdaynotset);
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
	 * 医技标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ot() {
		return ((FBoolean) getAttrVal("Fg_ot"));
	}
	/**
	 * 医技标识
	 * @param Fg_ot
	 */
	public void setFg_ot(FBoolean Fg_ot) {
		setAttrVal("Fg_ot", Fg_ot);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 药品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 请领单位
	 * @return String
	 */
	public String getName_pkgu_ap() {
		return ((String) getAttrVal("Name_pkgu_ap"));
	}
	/**
	 * 请领单位
	 * @param Name_pkgu_ap
	 */
	public void setName_pkgu_ap(String Name_pkgu_ap) {
		setAttrVal("Name_pkgu_ap", Name_pkgu_ap);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 药单类型
	 * @return Integer
	 */
	public Integer getEu_shetp() {
		return ((Integer) getAttrVal("Eu_shetp"));
	}
	/**
	 * 药单类型
	 * @param Eu_shetp
	 */
	public void setEu_shetp(Integer Eu_shetp) {
		setAttrVal("Eu_shetp", Eu_shetp);
	}
	/**
	 * 退药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_return() {
		return ((FBoolean) getAttrVal("Fg_return"));
	}
	/**
	 * 退药标识
	 * @param Fg_return
	 */
	public void setFg_return(FBoolean Fg_return) {
		setAttrVal("Fg_return", Fg_return);
	}
	/**
	 * 剂量单位id
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 剂量单位id
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 剂量单位
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 剂量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
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
	 * 用法id
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法id
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
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
	 * 开立医生姓名
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生姓名
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 总量
	 * @return String
	 */
	public String getQuan_cur() {
		return ((String) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量
	 * @param Quan_cur
	 */
	public void setQuan_cur(String Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 可转正常标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cantovalid() {
		return ((FBoolean) getAttrVal("Fg_cantovalid"));
	}
	/**
	 * 可转正常标识
	 * @param Fg_cantovalid
	 */
	public void setFg_cantovalid(FBoolean Fg_cantovalid) {
		setAttrVal("Fg_cantovalid", Fg_cantovalid);
	}
}