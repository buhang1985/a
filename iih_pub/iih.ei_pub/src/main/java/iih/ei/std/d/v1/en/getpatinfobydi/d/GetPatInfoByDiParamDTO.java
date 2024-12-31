package iih.ei.std.d.v1.en.getpatinfobydi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 获取患者信息by诊断入参 DTO数据 
 * 
 */
public class GetPatInfoByDiParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	/**
	 * 诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
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
	 * 诊断开始时间
	 * @return FDate
	 */
	public FDate getDt_b_di() {
		return ((FDate) getAttrVal("Dt_b_di"));
	}	
	/**
	 * 诊断开始时间
	 * @param Dt_b_di
	 */
	public void setDt_b_di(FDate Dt_b_di) {
		setAttrVal("Dt_b_di", Dt_b_di);
	}
	/**
	 * 诊断结束时间
	 * @return FDate
	 */
	public FDate getDt_e_di() {
		return ((FDate) getAttrVal("Dt_e_di"));
	}	
	/**
	 * 诊断结束时间
	 * @param Dt_e_di
	 */
	public void setDt_e_di(FDate Dt_e_di) {
		setAttrVal("Dt_e_di", Dt_e_di);
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
	 * 就诊次数
	 * @return String
	 */
	public String getTimes_ent() {
		return ((String) getAttrVal("Times_ent"));
	}	
	/**
	 * 就诊次数
	 * @param Times_ent
	 */
	public void setTimes_ent(String Times_ent) {
		setAttrVal("Times_ent", Times_ent);
	}
	/**
	 * 诊断医生编码
	 * @return String
	 */
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	/**
	 * 诊断医生编码
	 * @param Code_psn
	 */
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	/**
	 * 诊断科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 诊断科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public PageInfoDTO getPageinfo() {
		return ((PageInfoDTO) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(PageInfoDTO Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}