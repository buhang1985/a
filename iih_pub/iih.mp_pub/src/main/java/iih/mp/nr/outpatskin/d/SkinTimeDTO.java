package iih.mp.nr.outpatskin.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 皮试时间段 DTO数据 
 * 
 */
public class SkinTimeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getStat_time() {
		return ((FDateTime) getAttrVal("Stat_time"));
	}
	/**
	 * 医嘱开始时间
	 * @param Stat_time
	 */
	public void setStat_time(FDateTime Stat_time) {
		setAttrVal("Stat_time", Stat_time);
	}
	/**
	 * 医嘱结束时间
	 * @return FDateTime
	 */
	public FDateTime getEnd_time() {
		return ((FDateTime) getAttrVal("End_time"));
	}
	/**
	 * 医嘱结束时间
	 * @param End_time
	 */
	public void setEnd_time(FDateTime End_time) {
		setAttrVal("End_time", End_time);
	}
	/**
	 * 医嘱执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 医嘱执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
}