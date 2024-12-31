package iih.ei.std.consis.v1.task.d;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bd.webservice.BaseWsParam;

/**  
 * Function: 医院科室基本数据javabean <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年8月12日 下午9:56:28 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HosDepartBaseInfoBean extends BaseWsParam{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "DEPTCODE")
	private String deptcode;
	@XmlElement(name = "DEPTNAME")
	private String deptname;
	@XmlElement(name = "OUTP_OR_INP")
	private String outp_or_inp;
	
	/**
	 * 科室编号
	 * 
	 * @return
	 */
	public String getDeptcode() {
		return deptcode;
	}
	
	/**
	 * 科室编号
	 * 
	 * @param deptcode
	 */
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}
	
	/**
	 * 科室名称
	 * 
	 * @return
	 */
	public String getDeptname() {
		return deptname;
	}
	
	/**
	 * 科室名称
	 * 
	 * @param deptname
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	/**
	 * 科室类别
	 * 
	 * @return
	 */
	public String getOutp_or_inp() {
		return outp_or_inp;
	}
	
	/**
	 * 科室类别
	 * 
	 * @param outp_or_inp
	 */
	public void setOutp_or_inp(String outp_or_inp) {
		this.outp_or_inp = outp_or_inp;
	}
}
  
