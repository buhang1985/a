package iih.nm.nhr.dto.nmoptpldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 小组计划 DTO数据 
 * 
 */
public class NmOptPlDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 实习计划主键
	 * @return String
	 */
	public String getId_opt_pl() {
		return ((String) getAttrVal("Id_opt_pl"));
	}
	/**
	 * 实习计划主键
	 * @param Id_opt_pl
	 */
	public void setId_opt_pl(String Id_opt_pl) {
		setAttrVal("Id_opt_pl", Id_opt_pl);
	}
	/**
	 * 实习小组
	 * @return String
	 */
	public String getId_nm_grp() {
		return ((String) getAttrVal("Id_nm_grp"));
	}
	/**
	 * 实习小组
	 * @param Id_nm_grp
	 */
	public void setId_nm_grp(String Id_nm_grp) {
		setAttrVal("Id_nm_grp", Id_nm_grp);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 计划名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 计划名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 单位周数
	 * @return Integer
	 */
	public Integer getUnit_week() {
		return ((Integer) getAttrVal("Unit_week"));
	}
	/**
	 * 单位周数
	 * @param Unit_week
	 */
	public void setUnit_week(Integer Unit_week) {
		setAttrVal("Unit_week", Unit_week);
	}
	/**
	 * 总周数
	 * @return Integer
	 */
	public Integer getTotal_weeks() {
		return ((Integer) getAttrVal("Total_weeks"));
	}
	/**
	 * 总周数
	 * @param Total_weeks
	 */
	public void setTotal_weeks(Integer Total_weeks) {
		setAttrVal("Total_weeks", Total_weeks);
	}
	/**
	 * 计划轮转科室
	 * @return FArrayList
	 */
	public FArrayList getNmoptpldeps() {
		return ((FArrayList) getAttrVal("Nmoptpldeps"));
	}
	/**
	 * 计划轮转科室
	 * @param Nmoptpldeps
	 */
	public void setNmoptpldeps(FArrayList Nmoptpldeps) {
		setAttrVal("Nmoptpldeps", Nmoptpldeps);
	}
	/**
	 * 计划参与实习生
	 * @return FArrayList
	 */
	public FArrayList getNmoptplpsns() {
		return ((FArrayList) getAttrVal("Nmoptplpsns"));
	}
	/**
	 * 计划参与实习生
	 * @param Nmoptplpsns
	 */
	public void setNmoptplpsns(FArrayList Nmoptplpsns) {
		setAttrVal("Nmoptplpsns", Nmoptplpsns);
	}
}