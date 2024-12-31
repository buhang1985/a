package iih.mp.nr.splitplan.splitrequest.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门急诊医嘱执行点拆解请求 DTO数据 
 * 
 */
public class OutSpQueParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 病区
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pats() {
		return ((String) getAttrVal("Id_pats"));
	}
	/**
	 * 患者ID
	 * @param Id_pats
	 */
	public void setId_pats(String Id_pats) {
		setAttrVal("Id_pats", Id_pats);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getOr_tps() {
		return ((String) getAttrVal("Or_tps"));
	}
	/**
	 * 医嘱类型
	 * @param Or_tps
	 */
	public void setOr_tps(String Or_tps) {
		setAttrVal("Or_tps", Or_tps);
	}
	/**
	 * 给药途径
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 给药途径
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	/**
	 * 执行点范围左区间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 执行点范围左区间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 执行点范围右区间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 执行点范围右区间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}