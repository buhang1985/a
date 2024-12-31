package iih.bd.srv.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE住院频次字典DTO DTO数据 
 * 
 */
public class IEIpFreqDictDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE住院频次字典主键标识
	 * @return String
	 */
	public String getId_ieipfreqdict() {
		return ((String) getAttrVal("Id_ieipfreqdict"));
	}
	/**
	 * IE住院频次字典主键标识
	 * @param Id_ieipfreqdict
	 */
	public void setId_ieipfreqdict(String Id_ieipfreqdict) {
		setAttrVal("Id_ieipfreqdict", Id_ieipfreqdict);
	}
	/**
	 * 操作类型
	 * @return String
	 */
	public String getAction() {
		return ((String) getAttrVal("Action"));
	}
	/**
	 * 操作类型
	 * @param Action
	 */
	public void setAction(String Action) {
		setAttrVal("Action", Action);
	}
	/**
	 * 频率编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 频率编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 频率名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 频率名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}
	/**
	 * 拼音码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 打印名称
	 * @return String
	 */
	public String getPrint_name() {
		return ((String) getAttrVal("Print_name"));
	}
	/**
	 * 打印名称
	 * @param Print_name
	 */
	public void setPrint_name(String Print_name) {
		setAttrVal("Print_name", Print_name);
	}
	/**
	 * 周日标志
	 * @return String
	 */
	public String getWeek_day() {
		return ((String) getAttrVal("Week_day"));
	}
	/**
	 * 周日标志
	 * @param Week_day
	 */
	public void setWeek_day(String Week_day) {
		setAttrVal("Week_day", Week_day);
	}
	/**
	 * 允许修改标志
	 * @return String
	 */
	public String getDonot_modify() {
		return ((String) getAttrVal("Donot_modify"));
	}
	/**
	 * 允许修改标志
	 * @param Donot_modify
	 */
	public void setDonot_modify(String Donot_modify) {
		setAttrVal("Donot_modify", Donot_modify);
	}
	/**
	 * 排序码
	 * @return String
	 */
	public String getSort_code() {
		return ((String) getAttrVal("Sort_code"));
	}
	/**
	 * 排序码
	 * @param Sort_code
	 */
	public void setSort_code(String Sort_code) {
		setAttrVal("Sort_code", Sort_code);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
	/**
	 * 门诊标识
	 * @return String
	 */
	public String getMzflag() {
		return ((String) getAttrVal("Mzflag"));
	}
	/**
	 * 门诊标识
	 * @param Mzflag
	 */
	public void setMzflag(String Mzflag) {
		setAttrVal("Mzflag", Mzflag);
	}
}