package iih.ei.std.d.v1.en.opstopschlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊停诊列表 DTO数据 
 * 
 */
public class OpStopSchListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊排班ID
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 门诊排班ID
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 排班日期
	 * @return String
	 */
	public String getDt_sch() {
		return ((String) getAttrVal("Dt_sch"));
	}	
	/**
	 * 排班日期
	 * @param Dt_sch
	 */
	public void setDt_sch(String Dt_sch) {
		setAttrVal("Dt_sch", Dt_sch);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
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
	 * 资源编码
	 * @return String
	 */
	public String getCode_res() {
		return ((String) getAttrVal("Code_res"));
	}	
	/**
	 * 资源编码
	 * @param Code_res
	 */
	public void setCode_res(String Code_res) {
		setAttrVal("Code_res", Code_res);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getName_res() {
		return ((String) getAttrVal("Name_res"));
	}	
	/**
	 * 资源名称
	 * @param Name_res
	 */
	public void setName_res(String Name_res) {
		setAttrVal("Name_res", Name_res);
	}
	/**
	 * 午别类型编码
	 * @return String
	 */
	public String getCode_dayslottp() {
		return ((String) getAttrVal("Code_dayslottp"));
	}	
	/**
	 * 午别类型编码
	 * @param Code_dayslottp
	 */
	public void setCode_dayslottp(String Code_dayslottp) {
		setAttrVal("Code_dayslottp", Code_dayslottp);
	}
	/**
	 * 午别类型名称
	 * @return String
	 */
	public String getName_dayslottp() {
		return ((String) getAttrVal("Name_dayslottp"));
	}	
	/**
	 * 午别类型名称
	 * @param Name_dayslottp
	 */
	public void setName_dayslottp(String Name_dayslottp) {
		setAttrVal("Name_dayslottp", Name_dayslottp);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice_ticket() {
		return ((FDouble) getAttrVal("Price_ticket"));
	}	
	/**
	 * 价格
	 * @param Price_ticket
	 */
	public void setPrice_ticket(FDouble Price_ticket) {
		setAttrVal("Price_ticket", Price_ticket);
	}
	/**
	 * 剩余号源数
	 * @return String
	 */
	public String getRemain_ticket() {
		return ((String) getAttrVal("Remain_ticket"));
	}	
	/**
	 * 剩余号源数
	 * @param Remain_ticket
	 */
	public void setRemain_ticket(String Remain_ticket) {
		setAttrVal("Remain_ticket", Remain_ticket);
	}
	/**
	 * 特长
	 * @return String
	 */
	public String getSpeciality() {
		return ((String) getAttrVal("Speciality"));
	}	
	/**
	 * 特长
	 * @param Speciality
	 */
	public void setSpeciality(String Speciality) {
		setAttrVal("Speciality", Speciality);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	/**
	 * 服务ID
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_scsrv() {
		return ((String) getAttrVal("Code_scsrv"));
	}	
	/**
	 * 服务编码
	 * @param Code_scsrv
	 */
	public void setCode_scsrv(String Code_scsrv) {
		setAttrVal("Code_scsrv", Code_scsrv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}	
	/**
	 * 服务名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
}