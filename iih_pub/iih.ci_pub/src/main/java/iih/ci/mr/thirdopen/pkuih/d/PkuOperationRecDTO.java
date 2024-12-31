package iih.ci.mr.thirdopen.pkuih.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 国际医院手麻接收dto DTO数据 
 * 
 */
public class PkuOperationRecDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院号
	 * @return String
	 */
	public String getPathosid() {
		return ((String) getAttrVal("Pathosid"));
	}
	/**
	 * 住院号
	 * @param Pathosid
	 */
	public void setPathosid(String Pathosid) {
		setAttrVal("Pathosid", Pathosid);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getInhossum() {
		return ((String) getAttrVal("Inhossum"));
	}
	/**
	 * 住院次数
	 * @param Inhossum
	 */
	public void setInhossum(String Inhossum) {
		setAttrVal("Inhossum", Inhossum);
	}
	/**
	 * 手术号
	 * @return String
	 */
	public String getOps_id() {
		return ((String) getAttrVal("Ops_id"));
	}
	/**
	 * 手术号
	 * @param Ops_id
	 */
	public void setOps_id(String Ops_id) {
		setAttrVal("Ops_id", Ops_id);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getOps_name() {
		return ((String) getAttrVal("Ops_name"));
	}
	/**
	 * 手术名称
	 * @param Ops_name
	 */
	public void setOps_name(String Ops_name) {
		setAttrVal("Ops_name", Ops_name);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getOps_code() {
		return ((String) getAttrVal("Ops_code"));
	}
	/**
	 * 手术编码
	 * @param Ops_code
	 */
	public void setOps_code(String Ops_code) {
		setAttrVal("Ops_code", Ops_code);
	}
	/**
	 * 术间
	 * @return String
	 */
	public String getOpsplace() {
		return ((String) getAttrVal("Opsplace"));
	}
	/**
	 * 术间
	 * @param Opsplace
	 */
	public void setOpsplace(String Opsplace) {
		setAttrVal("Opsplace", Opsplace);
	}
	/**
	 * 手术开始时间，YYYYMMDDhhmmss
	 * @return String
	 */
	public String getBeg_time() {
		return ((String) getAttrVal("Beg_time"));
	}
	/**
	 * 手术开始时间，YYYYMMDDhhmmss
	 * @param Beg_time
	 */
	public void setBeg_time(String Beg_time) {
		setAttrVal("Beg_time", Beg_time);
	}
	/**
	 * 手术结束时间，YYYYMMDDhhmmss
	 * @return String
	 */
	public String getEnd_time() {
		return ((String) getAttrVal("End_time"));
	}
	/**
	 * 手术结束时间，YYYYMMDDhhmmss
	 * @param End_time
	 */
	public void setEnd_time(String End_time) {
		setAttrVal("End_time", End_time);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getOps_level() {
		return ((String) getAttrVal("Ops_level"));
	}
	/**
	 * 手术级别
	 * @param Ops_level
	 */
	public void setOps_level(String Ops_level) {
		setAttrVal("Ops_level", Ops_level);
	}
	/**
	 * 手术时长
	 * @return String
	 */
	public String getOps_time() {
		return ((String) getAttrVal("Ops_time"));
	}
	/**
	 * 手术时长
	 * @param Ops_time
	 */
	public void setOps_time(String Ops_time) {
		setAttrVal("Ops_time", Ops_time);
	}
	/**
	 * 手术医生编码
	 * @return String
	 */
	public String getOps_doctorno() {
		return ((String) getAttrVal("Ops_doctorno"));
	}
	/**
	 * 手术医生编码
	 * @param Ops_doctorno
	 */
	public void setOps_doctorno(String Ops_doctorno) {
		setAttrVal("Ops_doctorno", Ops_doctorno);
	}
	/**
	 * 手术医生
	 * @return String
	 */
	public String getOps_doctor() {
		return ((String) getAttrVal("Ops_doctor"));
	}
	/**
	 * 手术医生
	 * @param Ops_doctor
	 */
	public void setOps_doctor(String Ops_doctor) {
		setAttrVal("Ops_doctor", Ops_doctor);
	}
	/**
	 * 一助编码（工号）
	 * @return String
	 */
	public String getCode_opsfirsthelper() {
		return ((String) getAttrVal("Code_opsfirsthelper"));
	}
	/**
	 * 一助编码（工号）
	 * @param Code_opsfirsthelper
	 */
	public void setCode_opsfirsthelper(String Code_opsfirsthelper) {
		setAttrVal("Code_opsfirsthelper", Code_opsfirsthelper);
	}
	/**
	 * 一助
	 * @return String
	 */
	public String getOpsfirsthelper() {
		return ((String) getAttrVal("Opsfirsthelper"));
	}
	/**
	 * 一助
	 * @param Opsfirsthelper
	 */
	public void setOpsfirsthelper(String Opsfirsthelper) {
		setAttrVal("Opsfirsthelper", Opsfirsthelper);
	}
	/**
	 * 二助编码（工号）
	 * @return String
	 */
	public String getCode_opssecondhelper() {
		return ((String) getAttrVal("Code_opssecondhelper"));
	}
	/**
	 * 二助编码（工号）
	 * @param Code_opssecondhelper
	 */
	public void setCode_opssecondhelper(String Code_opssecondhelper) {
		setAttrVal("Code_opssecondhelper", Code_opssecondhelper);
	}
	/**
	 * 二助
	 * @return String
	 */
	public String getOpssecondhelper() {
		return ((String) getAttrVal("Opssecondhelper"));
	}
	/**
	 * 二助
	 * @param Opssecondhelper
	 */
	public void setOpssecondhelper(String Opssecondhelper) {
		setAttrVal("Opssecondhelper", Opssecondhelper);
	}
	/**
	 * 切口愈合等级
	 * @return String
	 */
	public String getNotchhealinggrade() {
		return ((String) getAttrVal("Notchhealinggrade"));
	}
	/**
	 * 切口愈合等级
	 * @param Notchhealinggrade
	 */
	public void setNotchhealinggrade(String Notchhealinggrade) {
		setAttrVal("Notchhealinggrade", Notchhealinggrade);
	}
	/**
	 * 手术护士编码（工号）
	 * @return String
	 */
	public String getCode_opsnuse() {
		return ((String) getAttrVal("Code_opsnuse"));
	}
	/**
	 * 手术护士编码（工号）
	 * @param Code_opsnuse
	 */
	public void setCode_opsnuse(String Code_opsnuse) {
		setAttrVal("Code_opsnuse", Code_opsnuse);
	}
	/**
	 * 手术护士
	 * @return String
	 */
	public String getOpsnurse() {
		return ((String) getAttrVal("Opsnurse"));
	}
	/**
	 * 手术护士
	 * @param Opsnurse
	 */
	public void setOpsnurse(String Opsnurse) {
		setAttrVal("Opsnurse", Opsnurse);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getOpsdeptname() {
		return ((String) getAttrVal("Opsdeptname"));
	}
	/**
	 * 科室
	 * @param Opsdeptname
	 */
	public void setOpsdeptname(String Opsdeptname) {
		setAttrVal("Opsdeptname", Opsdeptname);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getDept_stayed() {
		return ((String) getAttrVal("Dept_stayed"));
	}
	/**
	 * 科室编码
	 * @param Dept_stayed
	 */
	public void setDept_stayed(String Dept_stayed) {
		setAttrVal("Dept_stayed", Dept_stayed);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getOpsdiag() {
		return ((String) getAttrVal("Opsdiag"));
	}
	/**
	 * 诊断
	 * @param Opsdiag
	 */
	public void setOpsdiag(String Opsdiag) {
		setAttrVal("Opsdiag", Opsdiag);
	}
	/**
	 * 诊断编码（ICD10）
	 * @return String
	 */
	public String getCode_opsdiag() {
		return ((String) getAttrVal("Code_opsdiag"));
	}
	/**
	 * 诊断编码（ICD10）
	 * @param Code_opsdiag
	 */
	public void setCode_opsdiag(String Code_opsdiag) {
		setAttrVal("Code_opsdiag", Code_opsdiag);
	}
	/**
	 * 急诊标志
	 * @return String
	 */
	public String getOps_type() {
		return ((String) getAttrVal("Ops_type"));
	}
	/**
	 * 急诊标志
	 * @param Ops_type
	 */
	public void setOps_type(String Ops_type) {
		setAttrVal("Ops_type", Ops_type);
	}
	/**
	 * asa评分
	 * @return String
	 */
	public String getAsa_grade() {
		return ((String) getAttrVal("Asa_grade"));
	}
	/**
	 * asa评分
	 * @param Asa_grade
	 */
	public void setAsa_grade(String Asa_grade) {
		setAttrVal("Asa_grade", Asa_grade);
	}
	/**
	 * 麻醉师编码
	 * @return String
	 */
	public String getHocusdoctorno() {
		return ((String) getAttrVal("Hocusdoctorno"));
	}
	/**
	 * 麻醉师编码
	 * @param Hocusdoctorno
	 */
	public void setHocusdoctorno(String Hocusdoctorno) {
		setAttrVal("Hocusdoctorno", Hocusdoctorno);
	}
	/**
	 * 麻醉师名称
	 * @return String
	 */
	public String getHocusdoctor() {
		return ((String) getAttrVal("Hocusdoctor"));
	}
	/**
	 * 麻醉师名称
	 * @param Hocusdoctor
	 */
	public void setHocusdoctor(String Hocusdoctor) {
		setAttrVal("Hocusdoctor", Hocusdoctor);
	}
	/**
	 * 麻醉开始时间，YYYYMMDDhhmmss
	 * @return String
	 */
	public String getHocusbegin() {
		return ((String) getAttrVal("Hocusbegin"));
	}
	/**
	 * 麻醉开始时间，YYYYMMDDhhmmss
	 * @param Hocusbegin
	 */
	public void setHocusbegin(String Hocusbegin) {
		setAttrVal("Hocusbegin", Hocusbegin);
	}
	/**
	 * 麻醉结束时间，YYYYMMDDhhmmss
	 * @return String
	 */
	public String getHocusend() {
		return ((String) getAttrVal("Hocusend"));
	}
	/**
	 * 麻醉结束时间，YYYYMMDDhhmmss
	 * @param Hocusend
	 */
	public void setHocusend(String Hocusend) {
		setAttrVal("Hocusend", Hocusend);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getHocus_mode() {
		return ((String) getAttrVal("Hocus_mode"));
	}
	/**
	 * 麻醉方式
	 * @param Hocus_mode
	 */
	public void setHocus_mode(String Hocus_mode) {
		setAttrVal("Hocus_mode", Hocus_mode);
	}
	/**
	 * 失血量
	 * @return String
	 */
	public String getLose_blood_count() {
		return ((String) getAttrVal("Lose_blood_count"));
	}
	/**
	 * 失血量
	 * @param Lose_blood_count
	 */
	public void setLose_blood_count(String Lose_blood_count) {
		setAttrVal("Lose_blood_count", Lose_blood_count);
	}
	/**
	 * 血浆
	 * @return String
	 */
	public String getTransfuse_count() {
		return ((String) getAttrVal("Transfuse_count"));
	}
	/**
	 * 血浆
	 * @param Transfuse_count
	 */
	public void setTransfuse_count(String Transfuse_count) {
		setAttrVal("Transfuse_count", Transfuse_count);
	}
	/**
	 * 胶体液
	 * @return String
	 */
	public String getPeep_lens() {
		return ((String) getAttrVal("Peep_lens"));
	}
	/**
	 * 胶体液
	 * @param Peep_lens
	 */
	public void setPeep_lens(String Peep_lens) {
		setAttrVal("Peep_lens", Peep_lens);
	}
	/**
	 * 冷沉淀
	 * @return String
	 */
	public String getPerforation() {
		return ((String) getAttrVal("Perforation"));
	}
	/**
	 * 冷沉淀
	 * @param Perforation
	 */
	public void setPerforation(String Perforation) {
		setAttrVal("Perforation", Perforation);
	}
	/**
	 * 压积红
	 * @return String
	 */
	public String getPut_thing() {
		return ((String) getAttrVal("Put_thing"));
	}
	/**
	 * 压积红
	 * @param Put_thing
	 */
	public void setPut_thing(String Put_thing) {
		setAttrVal("Put_thing", Put_thing);
	}
	/**
	 * 血小板
	 * @return String
	 */
	public String getHeal_circs() {
		return ((String) getAttrVal("Heal_circs"));
	}
	/**
	 * 血小板
	 * @param Heal_circs
	 */
	public void setHeal_circs(String Heal_circs) {
		setAttrVal("Heal_circs", Heal_circs);
	}
	/**
	 * 切口数量
	 * @return String
	 */
	public String getCut_count() {
		return ((String) getAttrVal("Cut_count"));
	}
	/**
	 * 切口数量
	 * @param Cut_count
	 */
	public void setCut_count(String Cut_count) {
		setAttrVal("Cut_count", Cut_count);
	}
	/**
	 * 切口感染
	 * @return String
	 */
	public String getCut_infect() {
		return ((String) getAttrVal("Cut_infect"));
	}
	/**
	 * 切口感染
	 * @param Cut_infect
	 */
	public void setCut_infect(String Cut_infect) {
		setAttrVal("Cut_infect", Cut_infect);
	}
	/**
	 * 切口类型
	 * @return String
	 */
	public String getCut_type() {
		return ((String) getAttrVal("Cut_type"));
	}
	/**
	 * 切口类型
	 * @param Cut_type
	 */
	public void setCut_type(String Cut_type) {
		setAttrVal("Cut_type", Cut_type);
	}
	/**
	 * 手术部位
	 * @return String
	 */
	public String getOps_part() {
		return ((String) getAttrVal("Ops_part"));
	}
	/**
	 * 手术部位
	 * @param Ops_part
	 */
	public void setOps_part(String Ops_part) {
		setAttrVal("Ops_part", Ops_part);
	}
	/**
	 * 感染上报
	 * @return String
	 */
	public String getNnis() {
		return ((String) getAttrVal("Nnis"));
	}
	/**
	 * 感染上报
	 * @param Nnis
	 */
	public void setNnis(String Nnis) {
		setAttrVal("Nnis", Nnis);
	}
	/**
	 * 麻醉前用药
	 * @return String
	 */
	public String getOpsmed() {
		return ((String) getAttrVal("Opsmed"));
	}
	/**
	 * 麻醉前用药
	 * @param Opsmed
	 */
	public void setOpsmed(String Opsmed) {
		setAttrVal("Opsmed", Opsmed);
	}
	/**
	 * 身高
	 * @return String
	 */
	public String getHeight() {
		return ((String) getAttrVal("Height"));
	}
	/**
	 * 身高
	 * @param Height
	 */
	public void setHeight(String Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 体重
	 * @return String
	 */
	public String getWeight() {
		return ((String) getAttrVal("Weight"));
	}
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(String Weight) {
		setAttrVal("Weight", Weight);
	}
}