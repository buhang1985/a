package iih.mp.dg.dto.ipdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 请领head数据 DTO数据 
 * 
 */
public class IpDgDispHdDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请领主键
	 * @return String
	 */
	public String getId_dgipap() {
		return ((String) getAttrVal("Id_dgipap"));
	}
	/**
	 * 请领主键
	 * @param Id_dgipap
	 */
	public void setId_dgipap(String Id_dgipap) {
		setAttrVal("Id_dgipap", Id_dgipap);
	}
	/**
	 * 发放主键
	 * @return String
	 */
	public String getId_dgipde() {
		return ((String) getAttrVal("Id_dgipde"));
	}
	/**
	 * 发放主键
	 * @param Id_dgipde
	 */
	public void setId_dgipde(String Id_dgipde) {
		setAttrVal("Id_dgipde", Id_dgipde);
	}
	/**
	 * 请领单号
	 * @return String
	 */
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}
	/**
	 * 请领单号
	 * @param Code_dgipap
	 */
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	/**
	 * 请领单类型
	 * @return String
	 */
	public String getId_aptype() {
		return ((String) getAttrVal("Id_aptype"));
	}
	/**
	 * 请领单类型
	 * @param Id_aptype
	 */
	public void setId_aptype(String Id_aptype) {
		setAttrVal("Id_aptype", Id_aptype);
	}
	/**
	 * 请领单类型编码
	 * @return String
	 */
	public String getSd_aptype() {
		return ((String) getAttrVal("Sd_aptype"));
	}
	/**
	 * 请领单类型编码
	 * @param Sd_aptype
	 */
	public void setSd_aptype(String Sd_aptype) {
		setAttrVal("Sd_aptype", Sd_aptype);
	}
	/**
	 * 请领单类型名称
	 * @return String
	 */
	public String getName_aptype() {
		return ((String) getAttrVal("Name_aptype"));
	}
	/**
	 * 请领单类型名称
	 * @param Name_aptype
	 */
	public void setName_aptype(String Name_aptype) {
		setAttrVal("Name_aptype", Name_aptype);
	}
	/**
	 * 药单请领状态
	 * @return Integer
	 */
	public Integer getSd_dgap() {
		return ((Integer) getAttrVal("Sd_dgap"));
	}
	/**
	 * 药单请领状态
	 * @param Sd_dgap
	 */
	public void setSd_dgap(Integer Sd_dgap) {
		setAttrVal("Sd_dgap", Sd_dgap);
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
	 * 出院带药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_outp() {
		return ((FBoolean) getAttrVal("Fg_outp"));
	}
	/**
	 * 出院带药标志
	 * @param Fg_outp
	 */
	public void setFg_outp(FBoolean Fg_outp) {
		setAttrVal("Fg_outp", Fg_outp);
	}
	/**
	 * 医技药单标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ot() {
		return ((FBoolean) getAttrVal("Fg_ot"));
	}
	/**
	 * 医技药单标识
	 * @param Fg_ot
	 */
	public void setFg_ot(FBoolean Fg_ot) {
		setAttrVal("Fg_ot", Fg_ot);
	}
	/**
	 * 摆药周期
	 * @return Integer
	 */
	public Integer getEn_drugcycle() {
		return ((Integer) getAttrVal("En_drugcycle"));
	}
	/**
	 * 摆药周期
	 * @param En_drugcycle
	 */
	public void setEn_drugcycle(Integer En_drugcycle) {
		setAttrVal("En_drugcycle", En_drugcycle);
	}
	/**
	 * 摆药开始时间
	 * @return String
	 */
	public String getDt_begin() {
		return ((String) getAttrVal("Dt_begin"));
	}
	/**
	 * 摆药开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(String Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 周期摆药模式
	 * @return Integer
	 */
	public Integer getEn_dayfirdrug() {
		return ((Integer) getAttrVal("En_dayfirdrug"));
	}
	/**
	 * 周期摆药模式
	 * @param En_dayfirdrug
	 */
	public void setEn_dayfirdrug(Integer En_dayfirdrug) {
		setAttrVal("En_dayfirdrug", En_dayfirdrug);
	}
	/**
	 * 库房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 库房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_warehourse() {
		return ((String) getAttrVal("Name_warehourse"));
	}
	/**
	 * 仓库名称
	 * @param Name_warehourse
	 */
	public void setName_warehourse(String Name_warehourse) {
		setAttrVal("Name_warehourse", Name_warehourse);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_confirm() {
		return ((FDateTime) getAttrVal("Dt_confirm"));
	}
	/**
	 * 确认时间
	 * @param Dt_confirm
	 */
	public void setDt_confirm(FDateTime Dt_confirm) {
		setAttrVal("Dt_confirm", Dt_confirm);
	}
	/**
	 * 发药人
	 * @return String
	 */
	public String getName_emp_dp() {
		return ((String) getAttrVal("Name_emp_dp"));
	}
	/**
	 * 发药人
	 * @param Name_emp_dp
	 */
	public void setName_emp_dp(String Name_emp_dp) {
		setAttrVal("Name_emp_dp", Name_emp_dp);
	}
	/**
	 * 发药明细
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 发药明细
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
	/**
	 * 后审核状态
	 * @return Integer
	 */
	public Integer getEn_check() {
		return ((Integer) getAttrVal("En_check"));
	}
	/**
	 * 后审核状态
	 * @param En_check
	 */
	public void setEn_check(Integer En_check) {
		setAttrVal("En_check", En_check);
	}
	/**
	 * 草药审核标志
	 * @return FBoolean
	 */
	public FBoolean getFg_verify() {
		return ((FBoolean) getAttrVal("Fg_verify"));
	}
	/**
	 * 草药审核标志
	 * @param Fg_verify
	 */
	public void setFg_verify(FBoolean Fg_verify) {
		setAttrVal("Fg_verify", Fg_verify);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方号
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getName_pres() {
		return ((String) getAttrVal("Name_pres"));
	}
	/**
	 * 处方类型
	 * @param Name_pres
	 */
	public void setName_pres(String Name_pres) {
		setAttrVal("Name_pres", Name_pres);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
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
	 * 明细数据
	 * @return FArrayList
	 */
	public FArrayList getDetails() {
		return ((FArrayList) getAttrVal("Details"));
	}
	/**
	 * 明细数据
	 * @param Details
	 */
	public void setDetails(FArrayList Details) {
		setAttrVal("Details", Details);
	}
	/**
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 是否合并打印
	 * @return FBoolean
	 */
	public FBoolean getFg_combine_print() {
		return ((FBoolean) getAttrVal("Fg_combine_print"));
	}
	/**
	 * 是否合并打印
	 * @param Fg_combine_print
	 */
	public void setFg_combine_print(FBoolean Fg_combine_print) {
		setAttrVal("Fg_combine_print", Fg_combine_print);
	}
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 预置字段
	 * @return String
	 */
	public String getPreset_field() {
		return ((String) getAttrVal("Preset_field"));
	}
	/**
	 * 预置字段
	 * @param Preset_field
	 */
	public void setPreset_field(String Preset_field) {
		setAttrVal("Preset_field", Preset_field);
	}
}