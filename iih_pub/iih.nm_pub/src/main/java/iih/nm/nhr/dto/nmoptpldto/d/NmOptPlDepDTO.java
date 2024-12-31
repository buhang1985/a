package iih.nm.nhr.dto.nmoptpldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 计划轮转科室 DTO数据 
 * 
 */
public class NmOptPlDepDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 实习轮转科室主键
	 * @return String
	 */
	public String getId_opt_pl_dep() {
		return ((String) getAttrVal("Id_opt_pl_dep"));
	}
	/**
	 * 实习轮转科室主键
	 * @param Id_opt_pl_dep
	 */
	public void setId_opt_pl_dep(String Id_opt_pl_dep) {
		setAttrVal("Id_opt_pl_dep", Id_opt_pl_dep);
	}
	/**
	 * 实习计划
	 * @return String
	 */
	public String getId_opt_pl() {
		return ((String) getAttrVal("Id_opt_pl"));
	}
	/**
	 * 实习计划
	 * @param Id_opt_pl
	 */
	public void setId_opt_pl(String Id_opt_pl) {
		setAttrVal("Id_opt_pl", Id_opt_pl);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 轮转科室
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 轮转科室
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 轮转科室名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 轮转科室名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 实习周数
	 * @return String
	 */
	public String getWeeks() {
		return ((String) getAttrVal("Weeks"));
	}
	/**
	 * 实习周数
	 * @param Weeks
	 */
	public void setWeeks(String Weeks) {
		setAttrVal("Weeks", Weeks);
	}
}