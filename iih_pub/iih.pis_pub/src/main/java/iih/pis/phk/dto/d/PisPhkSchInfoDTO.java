package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者管家排班信息 DTO数据 
 * 
 */
public class PisPhkSchInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班ID
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班ID
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 排班日期
	 * @return String
	 */
	public String getSchdate() {
		return ((String) getAttrVal("Schdate"));
	}
	/**
	 * 排班日期
	 * @param Schdate
	 */
	public void setSchdate(String Schdate) {
		setAttrVal("Schdate", Schdate);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}
	/**
	 * 科室编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}
	/**
	 * 科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}
	/**
	 * 医生姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}
	/**
	 * 医生编码
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 职称
	 * @return String
	 */
	public String getDoctortitle() {
		return ((String) getAttrVal("Doctortitle"));
	}
	/**
	 * 职称
	 * @param Doctortitle
	 */
	public void setDoctortitle(String Doctortitle) {
		setAttrVal("Doctortitle", Doctortitle);
	}
	/**
	 * 资源编码
	 * @return String
	 */
	public String getRescode() {
		return ((String) getAttrVal("Rescode"));
	}
	/**
	 * 资源编码
	 * @param Rescode
	 */
	public void setRescode(String Rescode) {
		setAttrVal("Rescode", Rescode);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getResname() {
		return ((String) getAttrVal("Resname"));
	}
	/**
	 * 资源名称
	 * @param Resname
	 */
	public void setResname(String Resname) {
		setAttrVal("Resname", Resname);
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
	 * 午别类型
	 * @return String
	 */
	public String getDayslottp() {
		return ((String) getAttrVal("Dayslottp"));
	}
	/**
	 * 午别类型
	 * @param Dayslottp
	 */
	public void setDayslottp(String Dayslottp) {
		setAttrVal("Dayslottp", Dayslottp);
	}
	/**
	 * 午别类型（上午/下午）
	 * @return String
	 */
	public String getAmpm() {
		return ((String) getAttrVal("Ampm"));
	}
	/**
	 * 午别类型（上午/下午）
	 * @param Ampm
	 */
	public void setAmpm(String Ampm) {
		setAttrVal("Ampm", Ampm);
	}
	/**
	 * 午别类型type
	 * @return String
	 */
	public String getDayslottype() {
		return ((String) getAttrVal("Dayslottype"));
	}
	/**
	 * 午别类型type
	 * @param Dayslottype
	 */
	public void setDayslottype(String Dayslottype) {
		setAttrVal("Dayslottype", Dayslottype);
	}
	/**
	 * 午别名称
	 * @return String
	 */
	public String getDayslotname() {
		return ((String) getAttrVal("Dayslotname"));
	}
	/**
	 * 午别名称
	 * @param Dayslotname
	 */
	public void setDayslotname(String Dayslotname) {
		setAttrVal("Dayslotname", Dayslotname);
	}
	/**
	 * 号别类型
	 * @return String
	 */
	public String getSrvtype() {
		return ((String) getAttrVal("Srvtype"));
	}
	/**
	 * 号别类型
	 * @param Srvtype
	 */
	public void setSrvtype(String Srvtype) {
		setAttrVal("Srvtype", Srvtype);
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
	 * 号别ID
	 * @return String
	 */
	public String getSrvid() {
		return ((String) getAttrVal("Srvid"));
	}
	/**
	 * 号别ID
	 * @param Srvid
	 */
	public void setSrvid(String Srvid) {
		setAttrVal("Srvid", Srvid);
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
	 * 总号源数
	 * @return Integer
	 */
	public Integer getTotal() {
		return ((Integer) getAttrVal("Total"));
	}
	/**
	 * 总号源数
	 * @param Total
	 */
	public void setTotal(Integer Total) {
		setAttrVal("Total", Total);
	}
	/**
	 * 已使用数
	 * @return Integer
	 */
	public Integer getUsed() {
		return ((Integer) getAttrVal("Used"));
	}
	/**
	 * 已使用数
	 * @param Used
	 */
	public void setUsed(Integer Used) {
		setAttrVal("Used", Used);
	}
	/**
	 * 剩余号源
	 * @return Integer
	 */
	public Integer getRemain() {
		return ((Integer) getAttrVal("Remain"));
	}
	/**
	 * 剩余号源
	 * @param Remain
	 */
	public void setRemain(Integer Remain) {
		setAttrVal("Remain", Remain);
	}
	/**
	 * 是否开放
	 * @return FBoolean
	 */
	public FBoolean getIsopen() {
		return ((FBoolean) getAttrVal("Isopen"));
	}
	/**
	 * 是否开放
	 * @param Isopen
	 */
	public void setIsopen(FBoolean Isopen) {
		setAttrVal("Isopen", Isopen);
	}
}