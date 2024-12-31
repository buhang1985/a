package iih.mp.nr.vitalsigns.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 行结构 DTO数据 
 * 
 */
public class RowDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 单元格
	 * @return FArrayList
	 */
	public FArrayList getCells() {
		return ((FArrayList) getAttrVal("Cells"));
	}
	/**
	 * 单元格
	 * @param Cells
	 */
	public void setCells(FArrayList Cells) {
		setAttrVal("Cells", Cells);
	}
	/**
	 * 是否可见
	 * @return FBoolean
	 */
	public FBoolean getFg_visiable() {
		return ((FBoolean) getAttrVal("Fg_visiable"));
	}
	/**
	 * 是否可见
	 * @param Fg_visiable
	 */
	public void setFg_visiable(FBoolean Fg_visiable) {
		setAttrVal("Fg_visiable", Fg_visiable);
	}
	/**
	 * 行类型
	 * @return Integer
	 */
	public Integer getEnumtp() {
		return ((Integer) getAttrVal("Enumtp"));
	}
	/**
	 * 行类型
	 * @param Enumtp
	 */
	public void setEnumtp(Integer Enumtp) {
		setAttrVal("Enumtp", Enumtp);
	}
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
	 * 模板向项目
	 * @return String
	 */
	public String getId_mrtplvtitm() {
		return ((String) getAttrVal("Id_mrtplvtitm"));
	}
	/**
	 * 模板向项目
	 * @param Id_mrtplvtitm
	 */
	public void setId_mrtplvtitm(String Id_mrtplvtitm) {
		setAttrVal("Id_mrtplvtitm", Id_mrtplvtitm);
	}
	/**
	 * 测量项目ID
	 * @return String
	 */
	public String getId_mrvtitm() {
		return ((String) getAttrVal("Id_mrvtitm"));
	}
	/**
	 * 测量项目ID
	 * @param Id_mrvtitm
	 */
	public void setId_mrvtitm(String Id_mrvtitm) {
		setAttrVal("Id_mrvtitm", Id_mrvtitm);
	}
	/**
	 * 测量事件ID
	 * @return String
	 */
	public String getId_mrvtev() {
		return ((String) getAttrVal("Id_mrvtev"));
	}
	/**
	 * 测量事件ID
	 * @param Id_mrvtev
	 */
	public void setId_mrvtev(String Id_mrvtev) {
		setAttrVal("Id_mrvtev", Id_mrvtev);
	}
	/**
	 * 服务项目有
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目有
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
	 * 启用测量部位
	 * @return FBoolean
	 */
	public FBoolean getFg_pos() {
		return ((FBoolean) getAttrVal("Fg_pos"));
	}
	/**
	 * 启用测量部位
	 * @param Fg_pos
	 */
	public void setFg_pos(FBoolean Fg_pos) {
		setAttrVal("Fg_pos", Fg_pos);
	}
	/**
	 * 启用辅助措施
	 * @return FBoolean
	 */
	public FBoolean getFg_aux() {
		return ((FBoolean) getAttrVal("Fg_aux"));
	}
	/**
	 * 启用辅助措施
	 * @param Fg_aux
	 */
	public void setFg_aux(FBoolean Fg_aux) {
		setAttrVal("Fg_aux", Fg_aux);
	}
	/**
	 * 医疗记录
	 * @return String
	 */
	public String getId_mrvt() {
		return ((String) getAttrVal("Id_mrvt"));
	}
	/**
	 * 医疗记录
	 * @param Id_mrvt
	 */
	public void setId_mrvt(String Id_mrvt) {
		setAttrVal("Id_mrvt", Id_mrvt);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 业务数据标志
	 * @return FBoolean
	 */
	public FBoolean getFg_histary() {
		return ((FBoolean) getAttrVal("Fg_histary"));
	}
	/**
	 * 业务数据标志
	 * @param Fg_histary
	 */
	public void setFg_histary(FBoolean Fg_histary) {
		setAttrVal("Fg_histary", Fg_histary);
	}
	/**
	 * 自定义标识
	 * @return FBoolean
	 */
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}
	/**
	 * 自定义标识
	 * @param Fg_def
	 */
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
}