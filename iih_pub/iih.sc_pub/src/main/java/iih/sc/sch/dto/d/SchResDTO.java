package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊间加号排班资源DTO DTO数据 
 * 
 */
public class SchResDTO extends BaseDTO {
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
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 排班资源id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 排班资源id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 排班资源名称
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}
	/**
	 * 排班资源名称
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
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
	 * 日期分组名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 日期分组名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 日期分组开始时间
	 * @return FTime
	 */
	public FTime getTime_b() {
		return ((FTime) getAttrVal("Time_b"));
	}
	/**
	 * 日期分组开始时间
	 * @param Time_b
	 */
	public void setTime_b(FTime Time_b) {
		setAttrVal("Time_b", Time_b);
	}
	/**
	 * 日期分组结束时间
	 * @return FTime
	 */
	public FTime getTime_e() {
		return ((FTime) getAttrVal("Time_e"));
	}
	/**
	 * 日期分组结束时间
	 * @param Time_e
	 */
	public void setTime_e(FTime Time_e) {
		setAttrVal("Time_e", Time_e);
	}
	/**
	 * 加号数量
	 * @return Integer
	 */
	public Integer getAddnum() {
		return ((Integer) getAttrVal("Addnum"));
	}
	/**
	 * 加号数量
	 * @param Addnum
	 */
	public void setAddnum(Integer Addnum) {
		setAttrVal("Addnum", Addnum);
	}
	/**
	 * 已加号数量
	 * @return Integer
	 */
	public Integer getAddquecn() {
		return ((Integer) getAttrVal("Addquecn"));
	}
	/**
	 * 已加号数量
	 * @param Addquecn
	 */
	public void setAddquecn(Integer Addquecn) {
		setAttrVal("Addquecn", Addquecn);
	}
}