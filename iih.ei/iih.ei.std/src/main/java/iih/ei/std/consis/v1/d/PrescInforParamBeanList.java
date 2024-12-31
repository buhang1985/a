package iih.ei.std.consis.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 处方信息JavaBean集合
 * 
 * @author dj.zhang
 * @data 2018年7月12日上午10:24:08
 * 
 */
@XmlRootElement(name = "ROOT")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrescInforParamBeanList implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "OPSYSTEM")
	private String opsystem;
	@XmlElement(name = "OPWINID")
	private String opwinid;
	@XmlElement(name = "OPTYPE")
	private String optype;
	@XmlElement(name = "OPIP")
	private String opip;
	@XmlElement(name = "OPMANNO")
	private String opmanno;
	@XmlElement(name = "OPMANNAME")
	private String opmanname;

	@XmlElement(name = "CONSIS_PRESC_MSTVW")
	private PrescInforParamBean[] _prescBeans;

	/**
	 * 处方主信息
	 * 
	 * @return
	 */
	public PrescInforParamBean[] get_prescBeans() {
		return _prescBeans;
	}

	/**
	 * 处方主信息
	 * 
	 * @param _prescBeans
	 */
	public void set_prescBeans(PrescInforParamBean[] _prescBeans) {
		this._prescBeans = _prescBeans;
	}

	/**
	 * 系统名称代码
	 * 
	 * @return
	 */
	public String getOpsystem() {
		return opsystem;
	}

	/**
	 * 系统名称代码
	 * 
	 * @param opsystem
	 */
	public void setOpsystem(String opsystem) {
		this.opsystem = opsystem;
	}

	/**
	 * 操作终端窗口号
	 * 
	 * @return
	 */
	public String getOpwinid() {
		return opwinid;
	}

	/**
	 * 操作终端窗口号
	 * 
	 * @param opwinid
	 */
	public void setOpwinid(String opwinid) {
		this.opwinid = opwinid;
	}

	/**
	 * 操作代码
	 * 
	 * @return
	 */
	public String getOptype() {
		return optype;
	}

	/**
	 * 操作代码
	 * 
	 * @param optype
	 */
	public void setOptype(String optype) {
		this.optype = optype;
	}

	/**
	 * 终端IP地址
	 * 
	 * @return
	 */
	public String getOpip() {
		return opip;
	}

	/**
	 * 终端IP地址
	 * 
	 * @param opip
	 */
	public void setOpip(String opip) {
		this.opip = opip;
	}

	/**
	 * 终端操作员编号
	 * 
	 * @return
	 */
	public String getOpmanno() {
		return opmanno;
	}

	/**
	 * 终端操作员编号
	 * 
	 * @param opmanno
	 */
	public void setOpmanno(String opmanno) {
		this.opmanno = opmanno;
	}

	/**
	 * 终端操作员姓名
	 * 
	 * @return
	 */
	public String getOpmanname() {
		return opmanname;
	}

	/**
	 * 终端操作员姓名
	 * 
	 * @param opmanname
	 */
	public void setOpmanname(String opmanname) {
		this.opmanname = opmanname;
	}

}
