package iih.ei.std.d.v1.sc.mtstopsch.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技停诊列表 DTO数据 
 * 
 */
public class MtStopSchDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊排班Id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 门诊排班Id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getDate_sch() {
		return ((FDate) getAttrVal("Date_sch"));
	}	
	/**
	 * 排班日期
	 * @param Date_sch
	 */
	public void setDate_sch(FDate Date_sch) {
		setAttrVal("Date_sch", Date_sch);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
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
	 * 资源编号
	 * @return String
	 */
	public String getCode_res() {
		return ((String) getAttrVal("Code_res"));
	}	
	/**
	 * 资源编号
	 * @param Code_res
	 */
	public void setCode_res(String Code_res) {
		setAttrVal("Code_res", Code_res);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 午别编码
	 * @return String
	 */
	public String getDayslottp() {
		return ((String) getAttrVal("Dayslottp"));
	}	
	/**
	 * 午别编码
	 * @param Dayslottp
	 */
	public void setDayslottp(String Dayslottp) {
		setAttrVal("Dayslottp", Dayslottp);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getAmpm() {
		return ((String) getAttrVal("Ampm"));
	}	
	/**
	 * 午别
	 * @param Ampm
	 */
	public void setAmpm(String Ampm) {
		setAttrVal("Ampm", Ampm);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 剩余号源数
	 * @return Integer
	 */
	public Integer getRemain() {
		return ((Integer) getAttrVal("Remain"));
	}	
	/**
	 * 剩余号源数
	 * @param Remain
	 */
	public void setRemain(Integer Remain) {
		setAttrVal("Remain", Remain);
	}
	/**
	 * 特长
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 特长
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 开放标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 开放标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}