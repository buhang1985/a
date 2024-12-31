package iih.mp.nr.exenur.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱执行护士维护患者列表 DTO数据 
 * 
 */
public class ExecNurCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 是否已签名
	 * @return Integer
	 */
	public Integer getExeced() {
		return ((Integer) getAttrVal("Execed"));
	}
	/**
	 * 是否已签名
	 * @param Execed
	 */
	public void setExeced(Integer Execed) {
		setAttrVal("Execed", Execed);
	}
	/**
	 * 执行护士
	 * @return String
	 */
	public String getId_exec_nur() {
		return ((String) getAttrVal("Id_exec_nur"));
	}
	/**
	 * 执行护士
	 * @param Id_exec_nur
	 */
	public void setId_exec_nur(String Id_exec_nur) {
		setAttrVal("Id_exec_nur", Id_exec_nur);
	}
	/**
	 * 执行护士名称
	 * @return String
	 */
	public String getName_exec_nur() {
		return ((String) getAttrVal("Name_exec_nur"));
	}
	/**
	 * 执行护士名称
	 * @param Name_exec_nur
	 */
	public void setName_exec_nur(String Name_exec_nur) {
		setAttrVal("Name_exec_nur", Name_exec_nur);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exec() {
		return ((FDateTime) getAttrVal("Dt_exec"));
	}
	/**
	 * 执行时间
	 * @param Dt_exec
	 */
	public void setDt_exec(FDateTime Dt_exec) {
		setAttrVal("Dt_exec", Dt_exec);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 是否已签时间
	 * @return Integer
	 */
	public Integer getSigntime() {
		return ((Integer) getAttrVal("Signtime"));
	}
	/**
	 * 是否已签时间
	 * @param Signtime
	 */
	public void setSigntime(Integer Signtime) {
		setAttrVal("Signtime", Signtime);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
}