package iih.mp.nr.vitalsigns.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体征数据 DTO数据 
 * 
 */
public class VitalSignsDataDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体征模板
	 * @return String
	 */
	public String getId_mrtplvt() {
		return ((String) getAttrVal("Id_mrtplvt"));
	}
	/**
	 * 体征模板
	 * @param Id_mrtplvt
	 */
	public void setId_mrtplvt(String Id_mrtplvt) {
		setAttrVal("Id_mrtplvt", Id_mrtplvt);
	}
	/**
	 * 体征项目
	 * @return String
	 */
	public String getId_mrtpl_vs() {
		return ((String) getAttrVal("Id_mrtpl_vs"));
	}
	/**
	 * 体征项目
	 * @param Id_mrtpl_vs
	 */
	public void setId_mrtpl_vs(String Id_mrtpl_vs) {
		setAttrVal("Id_mrtpl_vs", Id_mrtpl_vs);
	}
	/**
	 * 体征模板项目ID
	 * @return String
	 */
	public String getId_mrtplvtitm() {
		return ((String) getAttrVal("Id_mrtplvtitm"));
	}
	/**
	 * 体征模板项目ID
	 * @param Id_mrtplvtitm
	 */
	public void setId_mrtplvtitm(String Id_mrtplvtitm) {
		setAttrVal("Id_mrtplvtitm", Id_mrtplvtitm);
	}
	/**
	 * 医疗体征项目ID
	 * @return String
	 */
	public String getId_mrvtitm() {
		return ((String) getAttrVal("Id_mrvtitm"));
	}
	/**
	 * 医疗体征项目ID
	 * @param Id_mrvtitm
	 */
	public void setId_mrvtitm(String Id_mrvtitm) {
		setAttrVal("Id_mrvtitm", Id_mrvtitm);
	}
	/**
	 * 医疗记录体征ID
	 * @return String
	 */
	public String getId_mrvt() {
		return ((String) getAttrVal("Id_mrvt"));
	}
	/**
	 * 医疗记录体征ID
	 * @param Id_mrvt
	 */
	public void setId_mrvt(String Id_mrvt) {
		setAttrVal("Id_mrvt", Id_mrvt);
	}
	/**
	 * 生命体征属性ID
	 * @return String
	 */
	public String getId_srvvt() {
		return ((String) getAttrVal("Id_srvvt"));
	}
	/**
	 * 生命体征属性ID
	 * @param Id_srvvt
	 */
	public void setId_srvvt(String Id_srvvt) {
		setAttrVal("Id_srvvt", Id_srvvt);
	}
	/**
	 * 服务项目ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 值1
	 * @return String
	 */
	public String getValue1() {
		return ((String) getAttrVal("Value1"));
	}
	/**
	 * 值1
	 * @param Value1
	 */
	public void setValue1(String Value1) {
		setAttrVal("Value1", Value1);
	}
	/**
	 * 值2
	 * @return String
	 */
	public String getValue2() {
		return ((String) getAttrVal("Value2"));
	}
	/**
	 * 值2
	 * @param Value2
	 */
	public void setValue2(String Value2) {
		setAttrVal("Value2", Value2);
	}
	/**
	 * 值3
	 * @return String
	 */
	public String getValue3() {
		return ((String) getAttrVal("Value3"));
	}
	/**
	 * 值3
	 * @param Value3
	 */
	public void setValue3(String Value3) {
		setAttrVal("Value3", Value3);
	}
	/**
	 * 测量部位
	 * @return String
	 */
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}
	/**
	 * 测量部位
	 * @param Id_pos
	 */
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}
	/**
	 * 辅助措施
	 * @return String
	 */
	public String getId_aux() {
		return ((String) getAttrVal("Id_aux"));
	}
	/**
	 * 辅助措施
	 * @param Id_aux
	 */
	public void setId_aux(String Id_aux) {
		setAttrVal("Id_aux", Id_aux);
	}
	/**
	 * 测量时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 测量时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
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
	 * 服务项
	 * @return FBoolean
	 */
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}
	/**
	 * 服务项
	 * @param Fg_default
	 */
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	/**
	 * 体征项编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}
	/**
	 * 体征项编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 数据来源编码
	 * @return String
	 */
	public String getCode_dataoringin() {
		return ((String) getAttrVal("Code_dataoringin"));
	}
	/**
	 * 数据来源编码
	 * @param Code_dataoringin
	 */
	public void setCode_dataoringin(String Code_dataoringin) {
		setAttrVal("Code_dataoringin", Code_dataoringin);
	}
	/**
	 * 自定义项目标识
	 * @return FBoolean
	 */
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}
	/**
	 * 自定义项目标识
	 * @param Fg_def
	 */
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
	/**
	 * 是否允许修改
	 * @return FBoolean
	 */
	public FBoolean getFg_disable() {
		return ((FBoolean) getAttrVal("Fg_disable"));
	}
	/**
	 * 是否允许修改
	 * @param Fg_disable
	 */
	public void setFg_disable(FBoolean Fg_disable) {
		setAttrVal("Fg_disable", Fg_disable);
	}
}