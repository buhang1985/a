package iih.mp.dg.ws.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**  
 * Function: 医院科室基本数据表头javabean  <br/>  
 * Date:     2018年8月12日 下午9:56:15 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
@XmlRootElement(name = "ROOT")
@XmlAccessorType(XmlAccessType.FIELD)
public class HosDepartBaseInfoBeanList implements Serializable{


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

	@XmlElement(name = "CONSIS_BASIC_DEPTVW")
	private HosDepartBaseInfoBean[] _hosDepartBaseInfo;

	/**
	 * 系统名称代码
	 * 
	 * @param opsystem
	 */
	public void setOpsystem(String opsystem) {
		this.opsystem = opsystem;
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

	/**
	 *  医院科室基本数据
	 * 
	 * @return
	 */
	public HosDepartBaseInfoBean[] get_hosDepartBaseInfo() {
		return _hosDepartBaseInfo;
	}
	/**
	 *  医院科室基本数据
	 * 
	 * @param _hosDepartBaseInfo
	 */
	public void set_hosDepartBaseInfo(HosDepartBaseInfoBean[] _hosDepartBaseInfo) {
		this._hosDepartBaseInfo = _hosDepartBaseInfo;
	}

}
  
