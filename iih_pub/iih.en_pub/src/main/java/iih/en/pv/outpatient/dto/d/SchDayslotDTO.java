package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班日期分组DTO DTO数据 
 * 
 */
public class SchDayslotDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 停止挂号时间
	 * @return FTime
	 */
	public FTime getT_e_reg() {
		return ((FTime) getAttrVal("T_e_reg"));
	}
	/**
	 * 停止挂号时间
	 * @param T_e_reg
	 */
	public void setT_e_reg(FTime T_e_reg) {
		setAttrVal("T_e_reg", T_e_reg);
	}
	/**
	 * 日期分组id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 日期分组id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 日期分组开始时间
	 * @return FTime
	 */
	public FTime getTime_begin() {
		return ((FTime) getAttrVal("Time_begin"));
	}
	/**
	 * 日期分组开始时间
	 * @param Time_begin
	 */
	public void setTime_begin(FTime Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	/**
	 * 日期分组结束时间
	 * @return FTime
	 */
	public FTime getTime_end() {
		return ((FTime) getAttrVal("Time_end"));
	}
	/**
	 * 日期分组结束时间
	 * @param Time_end
	 */
	public void setTime_end(FTime Time_end) {
		setAttrVal("Time_end", Time_end);
	}
}