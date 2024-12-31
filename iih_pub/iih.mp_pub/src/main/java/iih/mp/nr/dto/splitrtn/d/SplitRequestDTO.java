package iih.mp.nr.dto.splitrtn.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱拆分请求 DTO数据 
 * 
 */
public class SplitRequestDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区ID集合
	 * @return String
	 */
	public String getId_deps() {
		return ((String) getAttrVal("Id_deps"));
	}
	/**
	 * 病区ID集合
	 * @param Id_deps
	 */
	public void setId_deps(String Id_deps) {
		setAttrVal("Id_deps", Id_deps);
	}
	/**
	 * 医嘱ID集合
	 * @return String
	 */
	public String getId_ors() {
		return ((String) getAttrVal("Id_ors"));
	}
	/**
	 * 医嘱ID集合
	 * @param Id_ors
	 */
	public void setId_ors(String Id_ors) {
		setAttrVal("Id_ors", Id_ors);
	}
	/**
	 * 就诊ID集合
	 * @return String
	 */
	public String getId_ents() {
		return ((String) getAttrVal("Id_ents"));
	}
	/**
	 * 就诊ID集合
	 * @param Id_ents
	 */
	public void setId_ents(String Id_ents) {
		setAttrVal("Id_ents", Id_ents);
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
	 * 医嘱类型集合
	 * @return String
	 */
	public String getSd_srvtps() {
		return ((String) getAttrVal("Sd_srvtps"));
	}
	/**
	 * 医嘱类型集合
	 * @param Sd_srvtps
	 */
	public void setSd_srvtps(String Sd_srvtps) {
		setAttrVal("Sd_srvtps", Sd_srvtps);
	}
	/**
	 * 给药途径集合
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 给药途径集合
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
	/**
	 * 服务项目集合
	 * @return String
	 */
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}
	/**
	 * 服务项目集合
	 * @param Id_srvs
	 */
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 预拆分
	 * @return FBoolean
	 */
	public FBoolean getFg_presplit() {
		return ((FBoolean) getAttrVal("Fg_presplit"));
	}
	/**
	 * 预拆分
	 * @param Fg_presplit
	 */
	public void setFg_presplit(FBoolean Fg_presplit) {
		setAttrVal("Fg_presplit", Fg_presplit);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
}