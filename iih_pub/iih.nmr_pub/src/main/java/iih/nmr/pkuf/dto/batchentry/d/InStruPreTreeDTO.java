package iih.nmr.pkuf.dto.batchentry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 文书批量预览树 DTO数据 
 * 
 */
public class InStruPreTreeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 树主键标识
	 * @return String
	 */
	public String getId_key() {
		return ((String) getAttrVal("Id_key"));
	}
	/**
	 * 树主键标识
	 * @param Id_key
	 */
	public void setId_key(String Id_key) {
		setAttrVal("Id_key", Id_key);
	}
	/**
	 * 父ID
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父ID
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 医疗记录数据源ID
	 * @return String
	 */
	public String getId_nmr_doc_coll() {
		return ((String) getAttrVal("Id_nmr_doc_coll"));
	}
	/**
	 * 医疗记录数据源ID
	 * @param Id_nmr_doc_coll
	 */
	public void setId_nmr_doc_coll(String Id_nmr_doc_coll) {
		setAttrVal("Id_nmr_doc_coll", Id_nmr_doc_coll);
	}
	/**
	 * 医疗记录采集记录
	 * @return String
	 */
	public String getId_nmr_doc() {
		return ((String) getAttrVal("Id_nmr_doc"));
	}
	/**
	 * 医疗记录采集记录
	 * @param Id_nmr_doc
	 */
	public void setId_nmr_doc(String Id_nmr_doc) {
		setAttrVal("Id_nmr_doc", Id_nmr_doc);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 文书名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 文书名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 功能编码
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}
	/**
	 * 功能编码
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 文书主键标识
	 * @return String
	 */
	public String getId_nu() {
		return ((String) getAttrVal("Id_nu"));
	}
	/**
	 * 文书主键标识
	 * @param Id_nu
	 */
	public void setId_nu(String Id_nu) {
		setAttrVal("Id_nu", Id_nu);
	}
	/**
	 * 就诊Id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊Id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 数据集
	 * @return String
	 */
	public String getId_set() {
		return ((String) getAttrVal("Id_set"));
	}
	/**
	 * 数据集
	 * @param Id_set
	 */
	public void setId_set(String Id_set) {
		setAttrVal("Id_set", Id_set);
	}
	/**
	 * 文书序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 文书序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 子节点标识
	 * @return FBoolean
	 */
	public FBoolean getFg_child() {
		return ((FBoolean) getAttrVal("Fg_child"));
	}
	/**
	 * 子节点标识
	 * @param Fg_child
	 */
	public void setFg_child(FBoolean Fg_child) {
		setAttrVal("Fg_child", Fg_child);
	}
	/**
	 * 创建人员
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 创建人员
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 采集人姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 采集人姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 创建日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 创建日期时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 创建科室
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 创建科室
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 采集科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 采集科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
}