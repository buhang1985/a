package iih.bd.fc.dto.deptflow.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱流向计算 DTO数据 
 * 
 */
public class DeptFlowDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 流向科室ID
	 * @return String
	 */
	public String getId_wfdep() {
		return ((String) getAttrVal("Id_wfdep"));
	}
	/**
	 * 流向科室ID
	 * @param Id_wfdep
	 */
	public void setId_wfdep(String Id_wfdep) {
		setAttrVal("Id_wfdep", Id_wfdep);
	}
	/**
	 * 医嘱流向主键
	 * @return String
	 */
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}
	/**
	 * 医嘱流向主键
	 * @param Id_wf
	 */
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
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
	 * 流向编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 流向编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 流向名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 流向名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 宏标志
	 * @return FBoolean
	 */
	public FBoolean getFg_macro() {
		return ((FBoolean) getAttrVal("Fg_macro"));
	}
	/**
	 * 宏标志
	 * @param Fg_macro
	 */
	public void setFg_macro(FBoolean Fg_macro) {
		setAttrVal("Fg_macro", Fg_macro);
	}
	/**
	 * 宏_执行科室
	 * @return Integer
	 */
	public Integer getEu_macrodepmp() {
		return ((Integer) getAttrVal("Eu_macrodepmp"));
	}
	/**
	 * 宏_执行科室
	 * @param Eu_macrodepmp
	 */
	public void setEu_macrodepmp(Integer Eu_macrodepmp) {
		setAttrVal("Eu_macrodepmp", Eu_macrodepmp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行机构
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}
	/**
	 * 执行机构
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	/**
	 * 服务分类ID串
	 * @return String
	 */
	public String getId_srvcas() {
		return ((String) getAttrVal("Id_srvcas"));
	}
	/**
	 * 服务分类ID串
	 * @param Id_srvcas
	 */
	public void setId_srvcas(String Id_srvcas) {
		setAttrVal("Id_srvcas", Id_srvcas);
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
	 * 服务项目串
	 * @return String
	 */
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}
	/**
	 * 服务项目串
	 * @param Id_srvs
	 */
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 医嘱用法串
	 * @return String
	 */
	public String getId_usgs() {
		return ((String) getAttrVal("Id_usgs"));
	}
	/**
	 * 医嘱用法串
	 * @param Id_usgs
	 */
	public void setId_usgs(String Id_usgs) {
		setAttrVal("Id_usgs", Id_usgs);
	}
	/**
	 * 剂型串
	 * @return String
	 */
	public String getId_dosages() {
		return ((String) getAttrVal("Id_dosages"));
	}
	/**
	 * 剂型串
	 * @param Id_dosages
	 */
	public void setId_dosages(String Id_dosages) {
		setAttrVal("Id_dosages", Id_dosages);
	}
	/**
	 * 物品串
	 * @return String
	 */
	public String getId_mms() {
		return ((String) getAttrVal("Id_mms"));
	}
	/**
	 * 物品串
	 * @param Id_mms
	 */
	public void setId_mms(String Id_mms) {
		setAttrVal("Id_mms", Id_mms);
	}
	/**
	 * 物品目录限制
	 * @return FBoolean
	 */
	public FBoolean getFg_mmwh() {
		return ((FBoolean) getAttrVal("Fg_mmwh"));
	}
	/**
	 * 物品目录限制
	 * @param Fg_mmwh
	 */
	public void setFg_mmwh(FBoolean Fg_mmwh) {
		setAttrVal("Fg_mmwh", Fg_mmwh);
	}
	/**
	 * 出院带药标识
	 * @return Integer
	 */
	public Integer getEu_presoutpctr() {
		return ((Integer) getAttrVal("Eu_presoutpctr"));
	}
	/**
	 * 出院带药标识
	 * @param Eu_presoutpctr
	 */
	public void setEu_presoutpctr(Integer Eu_presoutpctr) {
		setAttrVal("Eu_presoutpctr", Eu_presoutpctr);
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
	 * @param Eu_presoutpctr
	 */
	public void setSd_herbpreparationtp(String Sd_herbpreparationtp) {
		setAttrVal("Sd_herbpreparationtp", Sd_herbpreparationtp);
	}
	
	/**
	 * 毒麻分类编码串
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻分类编码串
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 医嘱周期类型
	 * @return Integer
	 */
	public Integer getOrdrecurtp() {
		return ((Integer) getAttrVal("Ordrecurtp"));
	}
	/**
	 * 医嘱周期类型
	 * @param Ordrecurtp
	 */
	public void setOrdrecurtp(Integer Ordrecurtp) {
		setAttrVal("Ordrecurtp", Ordrecurtp);
	}
	/**
	 * 开始时间
	 * @return FTime
	 */
	public FTime getTime_b() {
		return ((FTime) getAttrVal("Time_b"));
	}
	/**
	 * 开始时间
	 * @param Time_b
	 */
	public void setTime_b(FTime Time_b) {
		setAttrVal("Time_b", Time_b);
	}
	/**
	 * 结束时间
	 * @return FTime
	 */
	public FTime getTime_e() {
		return ((FTime) getAttrVal("Time_e"));
	}
	/**
	 * 结束时间
	 * @param Time_e
	 */
	public void setTime_e(FTime Time_e) {
		setAttrVal("Time_e", Time_e);
	}
	/**
	 * 星期串编码
	 * @return String
	 */
	public String getSd_weeks() {
		return ((String) getAttrVal("Sd_weeks"));
	}
	/**
	 * 星期串编码
	 * @param Sd_weeks
	 */
	public void setSd_weeks(String Sd_weeks) {
		setAttrVal("Sd_weeks", Sd_weeks);
	}
	/**
	 * 开单科室串
	 * @return String
	 */
	public String getId_dep_ors() {
		return ((String) getAttrVal("Id_dep_ors"));
	}
	/**
	 * 开单科室串
	 * @param Id_dep_ors
	 */
	public void setId_dep_ors(String Id_dep_ors) {
		setAttrVal("Id_dep_ors", Id_dep_ors);
	}
	/**
	 * 就诊科室串
	 * @return String
	 */
	public String getId_dep_clinics() {
		return ((String) getAttrVal("Id_dep_clinics"));
	}
	/**
	 * 就诊科室串
	 * @param Id_dep_clinics
	 */
	public void setId_dep_clinics(String Id_dep_clinics) {
		setAttrVal("Id_dep_clinics", Id_dep_clinics);
	}
	/**
	 * 护理单元串
	 * @return String
	 */
	public String getId_dep_nurs() {
		return ((String) getAttrVal("Id_dep_nurs"));
	}
	/**
	 * 护理单元串
	 * @param Id_dep_nurs
	 */
	public void setId_dep_nurs(String Id_dep_nurs) {
		setAttrVal("Id_dep_nurs", Id_dep_nurs);
	}
	/**
	 * 机构编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 机构编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 机构名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 机构名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
}