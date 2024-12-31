package iih.ci.mr.mrdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * mrwritetpldto DTO数据 
 * 
 */
public class MrWriteTplDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 模板主键
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}
	/**
	 * 模板主键
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	/**
	 * 模板名称
	 * @return String
	 */
	public String getName_mrtpl() {
		return ((String) getAttrVal("Name_mrtpl"));
	}
	/**
	 * 模板名称
	 * @param Name_mrtpl
	 */
	public void setName_mrtpl(String Name_mrtpl) {
		setAttrVal("Name_mrtpl", Name_mrtpl);
	}
	/**
	 * 模板序号
	 * @return String
	 */
	public String getOrder_mrtpl() {
		return ((String) getAttrVal("Order_mrtpl"));
	}
	/**
	 * 模板序号
	 * @param Order_mrtpl
	 */
	public void setOrder_mrtpl(String Order_mrtpl) {
		setAttrVal("Order_mrtpl", Order_mrtpl);
	}
	/**
	 * 数据集编码
	 * @return String
	 */
	public String getCode_set() {
		return ((String) getAttrVal("Code_set"));
	}
	/**
	 * 数据集编码
	 * @param Code_set
	 */
	public void setCode_set(String Code_set) {
		setAttrVal("Code_set", Code_set);
	}
	/**
	 * 编辑器类型
	 * @return String
	 */
	public String getId_mred() {
		return ((String) getAttrVal("Id_mred"));
	}
	/**
	 * 编辑器类型
	 * @param Id_mred
	 */
	public void setId_mred(String Id_mred) {
		setAttrVal("Id_mred", Id_mred);
	}
	/**
	 * 适应病种id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 适应病种id
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 适应病种
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 适应病种
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 所属id
	 * @return String
	 */
	public String getId_owtp() {
		return ((String) getAttrVal("Id_owtp"));
	}
	/**
	 * 所属id
	 * @param Id_owtp
	 */
	public void setId_owtp(String Id_owtp) {
		setAttrVal("Id_owtp", Id_owtp);
	}
	/**
	 * 所属
	 * @return String
	 */
	public String getName_owtp() {
		return ((String) getAttrVal("Name_owtp"));
	}
	/**
	 * 所属
	 * @param Name_owtp
	 */
	public void setName_owtp(String Name_owtp) {
		setAttrVal("Name_owtp", Name_owtp);
	}
	/**
	 * 模板状态主键
	 * @return String
	 */
	public String getId_su_mrtpl() {
		return ((String) getAttrVal("Id_su_mrtpl"));
	}
	/**
	 * 模板状态主键
	 * @param Id_su_mrtpl
	 */
	public void setId_su_mrtpl(String Id_su_mrtpl) {
		setAttrVal("Id_su_mrtpl", Id_su_mrtpl);
	}
	/**
	 * 模板状态
	 * @return String
	 */
	public String getName_su_mrtpl() {
		return ((String) getAttrVal("Name_su_mrtpl"));
	}
	/**
	 * 模板状态
	 * @param Name_su_mrtpl
	 */
	public void setName_su_mrtpl(String Name_su_mrtpl) {
		setAttrVal("Name_su_mrtpl", Name_su_mrtpl);
	}
	/**
	 * 文书名称
	 * @return String
	 */
	public String getName_mr() {
		return ((String) getAttrVal("Name_mr"));
	}
	/**
	 * 文书名称
	 * @param Name_mr
	 */
	public void setName_mr(String Name_mr) {
		setAttrVal("Name_mr", Name_mr);
	}
	/**
	 * 业务时间
	 * @return FDateTime
	 */
	public FDateTime getDt_record() {
		return ((FDateTime) getAttrVal("Dt_record"));
	}
	/**
	 * 业务时间
	 * @param Dt_record
	 */
	public void setDt_record(FDateTime Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	/**
	 * 上级查房医师
	 * @return String
	 */
	public String getId_up_doctor() {
		return ((String) getAttrVal("Id_up_doctor"));
	}
	/**
	 * 上级查房医师
	 * @param Id_up_doctor
	 */
	public void setId_up_doctor(String Id_up_doctor) {
		setAttrVal("Id_up_doctor", Id_up_doctor);
	}
	/**
	 * 业务事件
	 * @return String
	 */
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}
	/**
	 * 业务事件
	 * @param Id_source
	 */
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
	}
	/**
	 * 模板科室id
	 * @return String
	 */
	public String getId_dept_mrtpl() {
		return ((String) getAttrVal("Id_dept_mrtpl"));
	}
	/**
	 * 模板科室id
	 * @param Id_dept_mrtpl
	 */
	public void setId_dept_mrtpl(String Id_dept_mrtpl) {
		setAttrVal("Id_dept_mrtpl", Id_dept_mrtpl);
	}
	/**
	 * 模板科室
	 * @return String
	 */
	public String getName_dept_mrtpl() {
		return ((String) getAttrVal("Name_dept_mrtpl"));
	}
	/**
	 * 模板科室
	 * @param Name_dept_mrtpl
	 */
	public void setName_dept_mrtpl(String Name_dept_mrtpl) {
		setAttrVal("Name_dept_mrtpl", Name_dept_mrtpl);
	}
	/**
	 * 检索模板名称
	 * @return String
	 */
	public String getName_search() {
		return ((String) getAttrVal("Name_search"));
	}
	/**
	 * 检索模板名称
	 * @param Name_search
	 */
	public void setName_search(String Name_search) {
		setAttrVal("Name_search", Name_search);
	}
	/**
	 * 医疗记录自定义分类id
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}
	/**
	 * 医疗记录自定义分类id
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 医疗记录自定义
	 * @return String
	 */
	public String getName_mrcactm() {
		return ((String) getAttrVal("Name_mrcactm"));
	}
	/**
	 * 医疗记录自定义
	 * @param Name_mrcactm
	 */
	public void setName_mrcactm(String Name_mrcactm) {
		setAttrVal("Name_mrcactm", Name_mrcactm);
	}
	/**
	 * 流程类型
	 * @return String
	 */
	public String getId_wf_type() {
		return ((String) getAttrVal("Id_wf_type"));
	}
	/**
	 * 流程类型
	 * @param Id_wf_type
	 */
	public void setId_wf_type(String Id_wf_type) {
		setAttrVal("Id_wf_type", Id_wf_type);
	}
	/**
	 * 前新起一页
	 * @return FBoolean
	 */
	public FBoolean getNewtop() {
		return ((FBoolean) getAttrVal("Newtop"));
	}
	/**
	 * 前新起一页
	 * @param Newtop
	 */
	public void setNewtop(FBoolean Newtop) {
		setAttrVal("Newtop", Newtop);
	}
	/**
	 * 后新起一页
	 * @return FBoolean
	 */
	public FBoolean getNewend() {
		return ((FBoolean) getAttrVal("Newend"));
	}
	/**
	 * 后新起一页
	 * @param Newend
	 */
	public void setNewend(FBoolean Newend) {
		setAttrVal("Newend", Newend);
	}
	/**
	 * 审签级别类型
	 * @return String
	 */
	public String getId_mr_sign_lvl() {
		return ((String) getAttrVal("Id_mr_sign_lvl"));
	}
	/**
	 * 审签级别类型
	 * @param Id_mr_sign_lvl
	 */
	public void setId_mr_sign_lvl(String Id_mr_sign_lvl) {
		setAttrVal("Id_mr_sign_lvl", Id_mr_sign_lvl);
	}
	/**
	 * 审签类型
	 * @return String
	 */
	public String getName_mr_sign_lvl() {
		return ((String) getAttrVal("Name_mr_sign_lvl"));
	}
	/**
	 * 审签类型
	 * @param Name_mr_sign_lvl
	 */
	public void setName_mr_sign_lvl(String Name_mr_sign_lvl) {
		setAttrVal("Name_mr_sign_lvl", Name_mr_sign_lvl);
	}
	/**
	 * 医疗记录类型id
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}
	/**
	 * 医疗记录类型id
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 医疗记录类型
	 * @return String
	 */
	public String getName_mrtp() {
		return ((String) getAttrVal("Name_mrtp"));
	}
	/**
	 * 医疗记录类型
	 * @param Name_mrtp
	 */
	public void setName_mrtp(String Name_mrtp) {
		setAttrVal("Name_mrtp", Name_mrtp);
	}
	/**
	 * 审签级别编码
	 * @return String
	 */
	public String getSd_mr_sign_lvl() {
		return ((String) getAttrVal("Sd_mr_sign_lvl"));
	}
	/**
	 * 审签级别编码
	 * @param Sd_mr_sign_lvl
	 */
	public void setSd_mr_sign_lvl(String Sd_mr_sign_lvl) {
		setAttrVal("Sd_mr_sign_lvl", Sd_mr_sign_lvl);
	}
	/**
	 * 个人
	 * @return FBoolean
	 */
	public FBoolean getFg_person() {
		return ((FBoolean) getAttrVal("Fg_person"));
	}
	/**
	 * 个人
	 * @param Fg_person
	 */
	public void setFg_person(FBoolean Fg_person) {
		setAttrVal("Fg_person", Fg_person);
	}
	/**
	 * 科室
	 * @return FBoolean
	 */
	public FBoolean getFg_dep() {
		return ((FBoolean) getAttrVal("Fg_dep"));
	}
	/**
	 * 科室
	 * @param Fg_dep
	 */
	public void setFg_dep(FBoolean Fg_dep) {
		setAttrVal("Fg_dep", Fg_dep);
	}
	/**
	 * 全院
	 * @return FBoolean
	 */
	public FBoolean getFg_hospital() {
		return ((FBoolean) getAttrVal("Fg_hospital"));
	}
	/**
	 * 全院
	 * @param Fg_hospital
	 */
	public void setFg_hospital(FBoolean Fg_hospital) {
		setAttrVal("Fg_hospital", Fg_hospital);
	}
	/**
	 * 上级医生
	 * @return String
	 */
	public String getId_emp_higher() {
		return ((String) getAttrVal("Id_emp_higher"));
	}
	/**
	 * 上级医生
	 * @param Id_emp_higher
	 */
	public void setId_emp_higher(String Id_emp_higher) {
		setAttrVal("Id_emp_higher", Id_emp_higher);
	}
	/**
	 * 是否默认
	 * @return FBoolean
	 */
	public FBoolean getIsdefault() {
		return ((FBoolean) getAttrVal("Isdefault"));
	}
	/**
	 * 是否默认
	 * @param Isdefault
	 */
	public void setIsdefault(FBoolean Isdefault) {
		setAttrVal("Isdefault", Isdefault);
	}
	/**
	 * 审签级别id
	 * @return String
	 */
	public String getId_mr_signlvl() {
		return ((String) getAttrVal("Id_mr_signlvl"));
	}
	/**
	 * 审签级别id
	 * @param Id_mr_signlvl
	 */
	public void setId_mr_signlvl(String Id_mr_signlvl) {
		setAttrVal("Id_mr_signlvl", Id_mr_signlvl);
	}
	/**
	 * 审签级别sd
	 * @return String
	 */
	public String getSd_mr_signlvl() {
		return ((String) getAttrVal("Sd_mr_signlvl"));
	}
	/**
	 * 审签级别sd
	 * @param Sd_mr_signlvl
	 */
	public void setSd_mr_signlvl(String Sd_mr_signlvl) {
		setAttrVal("Sd_mr_signlvl", Sd_mr_signlvl);
	}
	/**
	 * 病历签名模板
	 * @return String
	 */
	public String getId_mrsigntpl() {
		return ((String) getAttrVal("Id_mrsigntpl"));
	}
	/**
	 * 病历签名模板
	 * @param Id_mrsigntpl
	 */
	public void setId_mrsigntpl(String Id_mrsigntpl) {
		setAttrVal("Id_mrsigntpl", Id_mrsigntpl);
	}
	/**
	 * 签名流
	 * @return byte[]
	 */
	public byte[] getSign_fs() {
		return ((byte[]) getAttrVal("Sign_fs"));
	}
	/**
	 * 签名流
	 * @param Sign_fs
	 */
	public void setSign_fs(byte[] Sign_fs) {
		setAttrVal("Sign_fs", Sign_fs);
	}
}