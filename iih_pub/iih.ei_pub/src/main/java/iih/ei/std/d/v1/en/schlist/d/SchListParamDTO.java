package iih.ei.std.d.v1.en.schlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 获取门诊排班列表入参 DTO数据 
 * 
 */
public class SchListParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getName_res() {
		return ((String) getAttrVal("Name_res"));
	}	
	/**
	 * 资源名称
	 * @param Name_res
	 */
	public void setName_res(String Name_res) {
		setAttrVal("Name_res", Name_res);
	}
	/**
	 * 开始时间
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getCode_srvtp() {
		return ((String) getAttrVal("Code_srvtp"));
	}	
	/**
	 * 号别编码
	 * @param Code_srvtp
	 */
	public void setCode_srvtp(String Code_srvtp) {
		setAttrVal("Code_srvtp", Code_srvtp);
	}
	/**
	 * 渠道类型编码
	 * @return String
	 */
	public String getCode_chltp() {
		return ((String) getAttrVal("Code_chltp"));
	}	
	/**
	 * 渠道类型编码
	 * @param Code_chltp
	 */
	public void setCode_chltp(String Code_chltp) {
		setAttrVal("Code_chltp", Code_chltp);
	}
	/**
	 * 是否可用
	 * @return String
	 */
	public String getFg_active() {
		return ((String) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否可用
	 * @param Fg_active
	 */
	public void setFg_active(String Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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