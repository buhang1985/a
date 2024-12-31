package iih.mp.nr.vitalsign.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体征测量记录 DTO数据 
 * 
 */
public class VitalSignRecordDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体征模板记录ID
	 * @return String
	 */
	public String getId_mrtpl_vs_itm() {
		return ((String) getAttrVal("Id_mrtpl_vs_itm"));
	}
	/**
	 * 体征模板记录ID
	 * @param Id_mrtpl_vs_itm
	 */
	public void setId_mrtpl_vs_itm(String Id_mrtpl_vs_itm) {
		setAttrVal("Id_mrtpl_vs_itm", Id_mrtpl_vs_itm);
	}
	/**
	 * 体征模板ID
	 * @return String
	 */
	public String getId_mrtpl_vs() {
		return ((String) getAttrVal("Id_mrtpl_vs"));
	}
	/**
	 * 体征模板ID
	 * @param Id_mrtpl_vs
	 */
	public void setId_mrtpl_vs(String Id_mrtpl_vs) {
		setAttrVal("Id_mrtpl_vs", Id_mrtpl_vs);
	}
	/**
	 * 体征记录ID
	 * @return String
	 */
	public String getId_mr_vs() {
		return ((String) getAttrVal("Id_mr_vs"));
	}
	/**
	 * 体征记录ID
	 * @param Id_mr_vs
	 */
	public void setId_mr_vs(String Id_mr_vs) {
		setAttrVal("Id_mr_vs", Id_mr_vs);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}
	/**
	 * 项目编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}
	/**
	 * 项目名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 *  服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 *  服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 属性名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 属性名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 属性编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 属性编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 最大值
	 * @return FDouble
	 */
	public FDouble getValmax() {
		return ((FDouble) getAttrVal("Valmax"));
	}
	/**
	 * 最大值
	 * @param Valmax
	 */
	public void setValmax(FDouble Valmax) {
		setAttrVal("Valmax", Valmax);
	}
	/**
	 * 最小值
	 * @return FDouble
	 */
	public FDouble getValmin() {
		return ((FDouble) getAttrVal("Valmin"));
	}
	/**
	 * 最小值
	 * @param Valmin
	 */
	public void setValmin(FDouble Valmin) {
		setAttrVal("Valmin", Valmin);
	}
	/**
	 * 值来源
	 * @return String
	 */
	public String getSd_dataorigin() {
		return ((String) getAttrVal("Sd_dataorigin"));
	}
	/**
	 * 值来源
	 * @param Sd_dataorigin
	 */
	public void setSd_dataorigin(String Sd_dataorigin) {
		setAttrVal("Sd_dataorigin", Sd_dataorigin);
	}
	/**
	 * 默认项
	 * @return FBoolean
	 */
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}
	/**
	 * 默认项
	 * @param Fg_default
	 */
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	/**
	 * 键盘样式
	 * @return String
	 */
	public String getPages() {
		return ((String) getAttrVal("Pages"));
	}
	/**
	 * 键盘样式
	 * @param Pages
	 */
	public void setPages(String Pages) {
		setAttrVal("Pages", Pages);
	}
	/**
	 * 键盘类型
	 * @return String
	 */
	public String getKeyboardtype() {
		return ((String) getAttrVal("Keyboardtype"));
	}
	/**
	 * 键盘类型
	 * @param Keyboardtype
	 */
	public void setKeyboardtype(String Keyboardtype) {
		setAttrVal("Keyboardtype", Keyboardtype);
	}
	/**
	 * 键盘名称
	 * @return String
	 */
	public String getKeyboardname() {
		return ((String) getAttrVal("Keyboardname"));
	}
	/**
	 * 键盘名称
	 * @param Keyboardname
	 */
	public void setKeyboardname(String Keyboardname) {
		setAttrVal("Keyboardname", Keyboardname);
	}
	
	/**
	 * 体征录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 体征录入时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 录入人ID
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 录入人ID
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 录入人姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}
	/**
	 * 录入人姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 录入科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 录入科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 录入科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 录入科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 录入科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 录入科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 值单位
	 * @return String
	 */
	public String getName_measdoc() {
		return ((String) getAttrVal("Name_measdoc"));
	}
	/**
	 * 值单位
	 * @param Name_measdoc
	 */
	public void setName_measdoc(String Name_measdoc) {
		setAttrVal("Name_measdoc", Name_measdoc);
	}
	/**
	 * 测量部位
	 * @return String
	 */
	public String getName_pos() {
		return ((String) getAttrVal("Name_pos"));
	}
	/**
	 * 测量部位
	 * @param Name_pos
	 */
	public void setName_pos(String Name_pos) {
		setAttrVal("Name_pos", Name_pos);
	}
	/**
	 * 辅助措施
	 * @return String
	 */
	public String getName_aux() {
		return ((String) getAttrVal("Name_aux"));
	}
	/**
	 * 辅助措施
	 * @param Name_aux
	 */
	public void setName_aux(String Name_aux) {
		setAttrVal("Name_aux", Name_aux);
	}
	/**
	 * 辅助录入值
	 * @return String
	 */
	public String getVal_aux() {
		return ((String) getAttrVal("Val_aux"));
	}
	/**
	 * 辅助录入值
	 * @param Val_aux
	 */
	public void setVal_aux(String Val_aux) {
		setAttrVal("Val_aux", Val_aux);
	}
}