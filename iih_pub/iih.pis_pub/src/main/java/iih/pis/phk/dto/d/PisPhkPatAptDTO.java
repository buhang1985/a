package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者管家门诊已预约信息 DTO数据 
 * 
 */
public class PisPhkPatAptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 号别编码
	 * @return String
	 */
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}
	/**
	 * 号别编码
	 * @param Srvcode
	 */
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
	}
	/**
	 * 号别名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}
	/**
	 * 号别名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getRescode() {
		return ((String) getAttrVal("Rescode"));
	}
	/**
	 * 医生编码
	 * @param Rescode
	 */
	public void setRescode(String Rescode) {
		setAttrVal("Rescode", Rescode);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getResname() {
		return ((String) getAttrVal("Resname"));
	}
	/**
	 * 医生名称
	 * @param Resname
	 */
	public void setResname(String Resname) {
		setAttrVal("Resname", Resname);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getDayslotname() {
		return ((String) getAttrVal("Dayslotname"));
	}
	/**
	 * 午别
	 * @param Dayslotname
	 */
	public void setDayslotname(String Dayslotname) {
		setAttrVal("Dayslotname", Dayslotname);
	}
	/**
	 * 午别tp
	 * @return String
	 */
	public String getDayslottp() {
		return ((String) getAttrVal("Dayslottp"));
	}
	/**
	 * 午别tp
	 * @param Dayslottp
	 */
	public void setDayslottp(String Dayslottp) {
		setAttrVal("Dayslottp", Dayslottp);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDate getEnttime() {
		return ((FDate) getAttrVal("Enttime"));
	}
	/**
	 * 预约时间
	 * @param Enttime
	 */
	public void setEnttime(FDate Enttime) {
		setAttrVal("Enttime", Enttime);
	}
	/**
	 * 预约Id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约Id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
}