package iih.mp.nr.dto.labcrvalqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 危急值查询结果 DTO数据 
 * 
 */
public class LabcrvalResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 危急值
	 * @return String
	 */
	public String getId_lab_crval() {
		return ((String) getAttrVal("Id_lab_crval"));
	}
	/**
	 * 危急值
	 * @param Id_lab_crval
	 */
	public void setId_lab_crval(String Id_lab_crval) {
		setAttrVal("Id_lab_crval", Id_lab_crval);
	}
	/**
	 * 危急值项目
	 * @return String
	 */
	public String getId_lab_crval_itm() {
		return ((String) getAttrVal("Id_lab_crval_itm"));
	}
	/**
	 * 危急值项目
	 * @param Id_lab_crval_itm
	 */
	public void setId_lab_crval_itm(String Id_lab_crval_itm) {
		setAttrVal("Id_lab_crval_itm", Id_lab_crval_itm);
	}
	/**
	 * 患者标识
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 患者标识
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 所属科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊日期
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 就诊日期
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}
	/**
	 * 就诊次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 联系电话
	 * @return String
	 */
	public String getTel_no() {
		return ((String) getAttrVal("Tel_no"));
	}
	/**
	 * 联系电话
	 * @param Tel_no
	 */
	public void setTel_no(String Tel_no) {
		setAttrVal("Tel_no", Tel_no);
	}
	/**
	 * 处理建议
	 * @return String
	 */
	public String getHnd_msg() {
		return ((String) getAttrVal("Hnd_msg"));
	}
	/**
	 * 处理建议
	 * @param Hnd_msg
	 */
	public void setHnd_msg(String Hnd_msg) {
		setAttrVal("Hnd_msg", Hnd_msg);
	}
	/**
	 * 处理护士
	 * @return String
	 */
	public String getName_hnd_nur() {
		return ((String) getAttrVal("Name_hnd_nur"));
	}
	/**
	 * 处理护士
	 * @param Name_hnd_nur
	 */
	public void setName_hnd_nur(String Name_hnd_nur) {
		setAttrVal("Name_hnd_nur", Name_hnd_nur);
	}
	/**
	 * 护士处理时间
	 * @return String
	 */
	public String getDt_hnd_nur() {
		return ((String) getAttrVal("Dt_hnd_nur"));
	}
	/**
	 * 护士处理时间
	 * @param Dt_hnd_nur
	 */
	public void setDt_hnd_nur(String Dt_hnd_nur) {
		setAttrVal("Dt_hnd_nur", Dt_hnd_nur);
	}
	/**
	 * 危急值日期时间
	 * @return String
	 */
	public String getDt_rpt() {
		return ((String) getAttrVal("Dt_rpt"));
	}
	/**
	 * 危急值日期时间
	 * @param Dt_rpt
	 */
	public void setDt_rpt(String Dt_rpt) {
		setAttrVal("Dt_rpt", Dt_rpt);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_itm() {
		return ((String) getAttrVal("Code_itm"));
	}
	/**
	 * 项目编码
	 * @param Code_itm
	 */
	public void setCode_itm(String Code_itm) {
		setAttrVal("Code_itm", Code_itm);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}
	/**
	 * 项目名称
	 * @param Name_itm
	 */
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
	}
	/**
	 * 项目名称(英)
	 * @return String
	 */
	public String getName_itm_en() {
		return ((String) getAttrVal("Name_itm_en"));
	}
	/**
	 * 项目名称(英)
	 * @param Name_itm_en
	 */
	public void setName_itm_en(String Name_itm_en) {
		setAttrVal("Name_itm_en", Name_itm_en);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr() {
		return ((String) getAttrVal("Code_amr"));
	}
	/**
	 * 住院号
	 * @param Code_amr
	 */
	public void setCode_amr(String Code_amr) {
		setAttrVal("Code_amr", Code_amr);
	}
	/**
	 * 检验结果值
	 * @return String
	 */
	public String getRes_val() {
		return ((String) getAttrVal("Res_val"));
	}
	/**
	 * 检验结果值
	 * @param Res_val
	 */
	public void setRes_val(String Res_val) {
		setAttrVal("Res_val", Res_val);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 开单医生
	 * @return String
	 */
	public String getName_ord_doc() {
		return ((String) getAttrVal("Name_ord_doc"));
	}
	/**
	 * 开单医生
	 * @param Name_ord_doc
	 */
	public void setName_ord_doc(String Name_ord_doc) {
		setAttrVal("Name_ord_doc", Name_ord_doc);
	}
	/**
	 * 处理意见
	 * @return String
	 */
	public String getHnd_opinion() {
		return ((String) getAttrVal("Hnd_opinion"));
	}
	/**
	 * 处理意见
	 * @param Hnd_opinion
	 */
	public void setHnd_opinion(String Hnd_opinion) {
		setAttrVal("Hnd_opinion", Hnd_opinion);
	}
	/**
	 * 检验结果信息
	 * @return String
	 */
	public String getChk_msg() {
		return ((String) getAttrVal("Chk_msg"));
	}
	/**
	 * 检验结果信息
	 * @param Chk_msg
	 */
	public void setChk_msg(String Chk_msg) {
		setAttrVal("Chk_msg", Chk_msg);
	}
	/**
	 * 处理医生
	 * @return String
	 */
	public String getName_hnd_doc() {
		return ((String) getAttrVal("Name_hnd_doc"));
	}
	/**
	 * 处理医生
	 * @param Name_hnd_doc
	 */
	public void setName_hnd_doc(String Name_hnd_doc) {
		setAttrVal("Name_hnd_doc", Name_hnd_doc);
	}
	/**
	 * 医生处理时间
	 * @return String
	 */
	public String getDt_hnd_doc() {
		return ((String) getAttrVal("Dt_hnd_doc"));
	}
	/**
	 * 医生处理时间
	 * @param Dt_hnd_doc
	 */
	public void setDt_hnd_doc(String Dt_hnd_doc) {
		setAttrVal("Dt_hnd_doc", Dt_hnd_doc);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getVal_ref() {
		return ((String) getAttrVal("Val_ref"));
	}
	/**
	 * 参考值
	 * @param Val_ref
	 */
	public void setVal_ref(String Val_ref) {
		setAttrVal("Val_ref", Val_ref);
	}
	/**
	 * 检查结果状态
	 * @return String
	 */
	public String getName_deviate() {
		return ((String) getAttrVal("Name_deviate"));
	}
	/**
	 * 检查结果状态
	 * @param Name_deviate
	 */
	public void setName_deviate(String Name_deviate) {
		setAttrVal("Name_deviate", Name_deviate);
	}
}