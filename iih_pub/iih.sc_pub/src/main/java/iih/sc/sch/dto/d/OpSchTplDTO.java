package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊排班模板DTO DTO数据 
 * 
 */
public class OpSchTplDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日期
	 * @return FDate
	 */
	public FDate getDate() {
		return ((FDate) getAttrVal("Date"));
	}
	/**
	 * 日期
	 * @param Date
	 */
	public void setDate(FDate Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 计划排班日期
	 * @return FDate
	 */
	public FDate getSch_date() {
		return ((FDate) getAttrVal("Sch_date"));
	}
	/**
	 * 计划排班日期
	 * @param Sch_date
	 */
	public void setSch_date(FDate Sch_date) {
		setAttrVal("Sch_date", Sch_date);
	}
	/**
	 * 周计划索引
	 * @return Integer
	 */
	public Integer getWeek_index() {
		return ((Integer) getAttrVal("Week_index"));
	}
	/**
	 * 周计划索引
	 * @param Week_index
	 */
	public void setWeek_index(Integer Week_index) {
		setAttrVal("Week_index", Week_index);
	}
	/**
	 * 星期几
	 * @return Integer
	 */
	public Integer getWeekno() {
		return ((Integer) getAttrVal("Weekno"));
	}
	/**
	 * 星期几
	 * @param Weekno
	 */
	public void setWeekno(Integer Weekno) {
		setAttrVal("Weekno", Weekno);
	}
	/**
	 * 计划名称
	 * @return String
	 */
	public String getName_pl() {
		return ((String) getAttrVal("Name_pl"));
	}
	/**
	 * 计划名称
	 * @param Name_pl
	 */
	public void setName_pl(String Name_pl) {
		setAttrVal("Name_pl", Name_pl);
	}
	/**
	 * 完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}
	/**
	 * 完成标识
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
	}
	/**
	 * 错误消息
	 * @return String
	 */
	public String getError() {
		return ((String) getAttrVal("Error"));
	}
	/**
	 * 错误消息
	 * @param Error
	 */
	public void setError(String Error) {
		setAttrVal("Error", Error);
	}
	/**
	 * 排班计划id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 排班计划id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
}