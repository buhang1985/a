package iih.ci.ord.i.external.provide.meta.mr;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;

public class CiDiagInfoDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	
	/**
	 * 诊断时间
	 * @return FDateTime
	 */
	public FDateTime getDt_di() {
		return ((FDateTime) getAttrVal("Dt_di"));
	}
	/**
	 * 诊断时间
	 * @param Dt_di
	 */
	public void setDt_di(FDateTime Dt_di) {
		setAttrVal("Dt_di", Dt_di);
	}
	
	/**
	 *诊断体系
	 * @return String
	 */
	public String getId_disys() {
		return ((String) getAttrVal("Id_disys"));
	}
	/**
	 * 诊断体系
	 * @param Id_disys
	 */
	public void setId_disys(String Id_disys) {
		setAttrVal("Id_disys", Id_disys);
	}
	/**
	 *诊断体系编码
	 * @return String
	 */
	public String getSd_disys() {
		return ((String) getAttrVal("Sd_disys"));
	}
	/**
	 * 诊断体系编码
	 * @param Sd_disys
	 */
	public void setSd_disys(String Sd_disys) {
		setAttrVal("Sd_disys", Sd_disys);
	}
	/**
	 *诊断体系名称
	 * @return String
	 */
	public String getName_disys() {
		return ((String) getAttrVal("Name_disys"));
	}
	/**
	 * 诊断体系名称
	 * @param Name_disys
	 */
	public void setName_disys(String Name_disys) {
		setAttrVal("Name_disys", Name_disys);
	}
	
	/**
	 *诊断类型
	 * @return String
	 */
	public String getId_ditp() {
		return ((String) getAttrVal("Id_ditp"));
	}
	/**
	 * 诊断类型
	 * @param Id_ditp
	 */
	public void setId_ditp(String Id_ditp) {
		setAttrVal("Id_ditp", Id_ditp);
	}
	/**
	 *诊断类型编码
	 * @return String
	 */
	public String getSd_ditp() {
		return ((String) getAttrVal("Sd_ditp"));
	}
	/**
	 * 诊断类型编码
	 * @param Sd_ditp
	 */
	public void setSd_ditp(String Sd_ditp) {
		setAttrVal("Sd_ditp", Sd_ditp);
	}
	/**
	 *诊断类型名称
	 * @return String
	 */
	public String getName_ditp() {
		return ((String) getAttrVal("Name_ditp"));
	}
	/**
	 * 诊断类型名称
	 * @param Name_ditp
	 */
	public void setName_ditp(String Name_ditp) {
		setAttrVal("Name_ditp", Name_ditp);
	}
	
	/**
	 *诊断明细
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 诊断明细
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 *诊断明细编码
	 * @return String
	 */
	public String getCode_diitm() {
		return ((String) getAttrVal("Code_diitm"));
	}
	/**
	 * 诊断明细编码
	 * @param Code_diitm
	 */
	public void setCode_diitm(String Code_diitm) {
		setAttrVal("Code_diitm", Code_diitm);
	}
	/**
	 *诊断明细名称
	 * @return String
	 */
	public String getName_diitm() {
		return ((String) getAttrVal("Name_diitm"));
	}
	/**
	 * 诊断明细名称
	 * @param Name_diitm
	 */
	public void setName_diitm(String Name_diitm) {
		setAttrVal("Name_diitm", Name_diitm);
	}
	
	/**
	 *补充说明
	 * @return String
	 */
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}
	/**
	 * 补充说明
	 * @param Supplement
	 */
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
	}
	
}
