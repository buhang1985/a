package iih.pis.mbw.dto.pismbwschlistdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwSchlistDTO {

	// 排班ID
	@RPCField(id = 1)
	private String id_sch;
	// 午别
	@RPCField(id = 10)
	private String dayslottp;
	// 上下午
	@RPCField(id = 11)
	private String ampm;
	// 号别编码
	@RPCField(id = 12)
	private String srvcode;
	// 号别名称
	@RPCField(id = 13)
	private String srvname;
	// 费用
	@RPCField(id = 14)
	private double price;
	// 总号源数量
	@RPCField(id = 15)
	private int total;
	// 可用号源数量
	@RPCField(id = 16)
	private int remain;
	// 已使用数
	@RPCField(id = 17)
	private int used;
	// 专家字段
	@RPCField(id = 18)
	private String srvtype;
	// 特长
	@RPCField(id = 19)
	private String speciality;
	// 资源名称
	@RPCField(id = 2)
	private String resname;
	// 星期
	@RPCField(id = 3)
	private String week;
	// 资源编号
	@RPCField(id = 4)
	private String rescode;
	// 服务编码
	@RPCField(id = 5)
	private String servicecode;
	// 科室编码
	@RPCField(id = 6)
	private String deptcode;
	// 科室名称
	@RPCField(id = 7)
	private String deptname;
	// 职称
	@RPCField(id = 8)
	private String doctortitle;
	// 出诊日期
	@RPCField(id = 9)
	private String schdate;

	public String getId_sch() {
		return id_sch;
	}

	public void setId_sch(String id_sch) {
		this.id_sch = id_sch;
	}

	public String getDayslottp() {
		return dayslottp;
	}

	public void setDayslottp(String dayslottp) {
		this.dayslottp = dayslottp;
	}

	public String getAmpm() {
		return ampm;
	}

	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}

	public String getSrvcode() {
		return srvcode;
	}

	public void setSrvcode(String srvcode) {
		this.srvcode = srvcode;
	}

	public String getSrvname() {
		return srvname;
	}

	public void setSrvname(String srvname) {
		this.srvname = srvname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public int getUsed() {
		return used;
	}

	public void setUsed(int used) {
		this.used = used;
	}

	public String getSrvtype() {
		return srvtype;
	}

	public void setSrvtype(String srvtype) {
		this.srvtype = srvtype;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getResname() {
		return resname;
	}

	public void setResname(String resname) {
		this.resname = resname;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getRescode() {
		return rescode;
	}

	public void setRescode(String rescode) {
		this.rescode = rescode;
	}

	public String getServicecode() {
		return servicecode;
	}

	public void setServicecode(String servicecode) {
		this.servicecode = servicecode;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDoctortitle() {
		return doctortitle;
	}

	public void setDoctortitle(String doctortitle) {
		this.doctortitle = doctortitle;
	}

	public String getSchdate() {
		return schdate;
	}

	public void setSchdate(String schdate) {
		this.schdate = schdate;
	}

}
