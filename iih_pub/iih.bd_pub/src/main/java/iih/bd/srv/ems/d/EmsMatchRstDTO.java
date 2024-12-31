package iih.bd.srv.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗单匹配结果DTO DTO数据 
 * 
 */
public class EmsMatchRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗单主键标识
	 * @return String
	 */
	public String getId_ems() {
		return ((String) getAttrVal("Id_ems"));
	}
	/**
	 * 医疗单主键标识
	 * @param Id_ems
	 */
	public void setId_ems(String Id_ems) {
		setAttrVal("Id_ems", Id_ems);
	}
	/**
	 * 功能类字串
	 * @return String
	 */
	public String getFuncclassstr() {
		return ((String) getAttrVal("Funcclassstr"));
	}
	/**
	 * 功能类字串
	 * @param Funcclassstr
	 */
	public void setFuncclassstr(String Funcclassstr) {
		setAttrVal("Funcclassstr", Funcclassstr);
	}
	/**
	 * 显示名称
	 * @return String
	 */
	public String getName_show() {
		return ((String) getAttrVal("Name_show"));
	}
	/**
	 * 显示名称
	 * @param Name_show
	 */
	public void setName_show(String Name_show) {
		setAttrVal("Name_show", Name_show);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 增减方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 增减方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 生效时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 关联类型
	 * @return String
	 */
	public String getEu_ofreftp() {
		return ((String) getAttrVal("Eu_ofreftp"));
	}
	/**
	 * 关联类型
	 * @param Eu_ofreftp
	 */
	public void setEu_ofreftp(String Eu_ofreftp) {
		setAttrVal("Eu_ofreftp", Eu_ofreftp);
	}
	
	
 
	/**
	 * 简化的流程标识
	 * @return FBoolean
	 */
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}
	/**
	 * 简化的流程标识
	 * @param fg_quickwflow
	 */
	public void setFg_quickwflow(FBoolean fg_quickwflow) {
		setAttrVal("Fg_quickwflow", fg_quickwflow);
	}
}