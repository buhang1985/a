package iih.crm.conm.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 合同信息展示DTO DTO数据 
 * 
 */
public class CrmConDataShowDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 合同id
	 * @return String
	 */
	public String getId_con() {
		return ((String) getAttrVal("Id_con"));
	}
	/**
	 * 合同id
	 * @param Id_con
	 */
	public void setId_con(String Id_con) {
		setAttrVal("Id_con", Id_con);
	}
	/**
	 * 营销方案id
	 * @return String
	 */
	public String getId_marplan() {
		return ((String) getAttrVal("Id_marplan"));
	}
	/**
	 * 营销方案id
	 * @param Id_marplan
	 */
	public void setId_marplan(String Id_marplan) {
		setAttrVal("Id_marplan", Id_marplan);
	}
	/**
	 * 营销方案名称
	 * @return String
	 */
	public String getName_marplan() {
		return ((String) getAttrVal("Name_marplan"));
	}
	/**
	 * 营销方案名称
	 * @param Name_marplan
	 */
	public void setName_marplan(String Name_marplan) {
		setAttrVal("Name_marplan", Name_marplan);
	}
	/**
	 * 营销方案编码
	 * @return String
	 */
	public String getCode_marplan() {
		return ((String) getAttrVal("Code_marplan"));
	}
	/**
	 * 营销方案编码
	 * @param Code_marplan
	 */
	public void setCode_marplan(String Code_marplan) {
		setAttrVal("Code_marplan", Code_marplan);
	}
	/**
	 * 合同状态id
	 * @return String
	 */
	public String getId_su_con() {
		return ((String) getAttrVal("Id_su_con"));
	}
	/**
	 * 合同状态id
	 * @param Id_su_con
	 */
	public void setId_su_con(String Id_su_con) {
		setAttrVal("Id_su_con", Id_su_con);
	}
	/**
	 * 合同状态编码
	 * @return String
	 */
	public String getSd_su_con() {
		return ((String) getAttrVal("Sd_su_con"));
	}
	/**
	 * 合同状态编码
	 * @param Sd_su_con
	 */
	public void setSd_su_con(String Sd_su_con) {
		setAttrVal("Sd_su_con", Sd_su_con);
	}
	/**
	 * 合同状态名称
	 * @return String
	 */
	public String getName_su_con() {
		return ((String) getAttrVal("Name_su_con"));
	}
	/**
	 * 合同状态名称
	 * @param Name_su_con
	 */
	public void setName_su_con(String Name_su_con) {
		setAttrVal("Name_su_con", Name_su_con);
	}
	/**
	 * 生效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_valid() {
		return ((FBoolean) getAttrVal("Fg_valid"));
	}
	/**
	 * 生效标志
	 * @param Fg_valid
	 */
	public void setFg_valid(FBoolean Fg_valid) {
		setAttrVal("Fg_valid", Fg_valid);
	}
	/**
	 * 有效期开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 有效期开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 有效期结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 有效期结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 执行完成操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_comp() {
		return ((FDateTime) getAttrVal("Dt_comp"));
	}
	/**
	 * 执行完成操作时间
	 * @param Dt_comp
	 */
	public void setDt_comp(FDateTime Dt_comp) {
		setAttrVal("Dt_comp", Dt_comp);
	}
	/**
	 * 最后的执行操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_last() {
		return ((FDateTime) getAttrVal("Dt_last"));
	}
	/**
	 * 最后的执行操作时间
	 * @param Dt_last
	 */
	public void setDt_last(FDateTime Dt_last) {
		setAttrVal("Dt_last", Dt_last);
	}
	/**
	 * 录入人id
	 * @return String
	 */
	public String getId_emp_inst() {
		return ((String) getAttrVal("Id_emp_inst"));
	}
	/**
	 * 录入人id
	 * @param Id_emp_inst
	 */
	public void setId_emp_inst(String Id_emp_inst) {
		setAttrVal("Id_emp_inst", Id_emp_inst);
	}
	/**
	 * 录入人姓名
	 * @return String
	 */
	public String getName_emp_inst() {
		return ((String) getAttrVal("Name_emp_inst"));
	}
	/**
	 * 录入人姓名
	 * @param Name_emp_inst
	 */
	public void setName_emp_inst(String Name_emp_inst) {
		setAttrVal("Name_emp_inst", Name_emp_inst);
	}
	/**
	 * 录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_inst() {
		return ((FDateTime) getAttrVal("Dt_inst"));
	}
	/**
	 * 录入时间
	 * @param Dt_inst
	 */
	public void setDt_inst(FDateTime Dt_inst) {
		setAttrVal("Dt_inst", Dt_inst);
	}
	/**
	 * 中止执行原因id
	 * @return String
	 */
	public String getId_stop() {
		return ((String) getAttrVal("Id_stop"));
	}
	/**
	 * 中止执行原因id
	 * @param Id_stop
	 */
	public void setId_stop(String Id_stop) {
		setAttrVal("Id_stop", Id_stop);
	}
	/**
	 * 中止执行原因编码
	 * @return String
	 */
	public String getSd_stop() {
		return ((String) getAttrVal("Sd_stop"));
	}
	/**
	 * 中止执行原因编码
	 * @param Sd_stop
	 */
	public void setSd_stop(String Sd_stop) {
		setAttrVal("Sd_stop", Sd_stop);
	}
	/**
	 * 中止执行原因描述
	 * @return String
	 */
	public String getDes_stop() {
		return ((String) getAttrVal("Des_stop"));
	}
	/**
	 * 中止执行原因描述
	 * @param Des_stop
	 */
	public void setDes_stop(String Des_stop) {
		setAttrVal("Des_stop", Des_stop);
	}
	/**
	 * 中止人id
	 * @return String
	 */
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}
	/**
	 * 中止人id
	 * @param Id_emp_stop
	 */
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	/**
	 * 中止人名称
	 * @return String
	 */
	public String getName_emp_stop() {
		return ((String) getAttrVal("Name_emp_stop"));
	}
	/**
	 * 中止人名称
	 * @param Name_emp_stop
	 */
	public void setName_emp_stop(String Name_emp_stop) {
		setAttrVal("Name_emp_stop", Name_emp_stop);
	}
	/**
	 * 中止执行操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}
	/**
	 * 中止执行操作时间
	 * @param Dt_stop
	 */
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
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
}