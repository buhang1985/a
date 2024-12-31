package iih.cssd.dpus.dto.dfpappsend.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 发放单报表dto DTO数据 
 * 
 */
public class DfpSendTableDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请领科室id
	 * @return String
	 */
	public String getId_dep_apply() {
		return ((String) getAttrVal("Id_dep_apply"));
	}
	/**
	 * 请领科室id
	 * @param Id_dep_apply
	 */
	public void setId_dep_apply(String Id_dep_apply) {
		setAttrVal("Id_dep_apply", Id_dep_apply);
	}
	/**
	 * 请领科室
	 * @return String
	 */
	public String getName_dep_apply() {
		return ((String) getAttrVal("Name_dep_apply"));
	}
	/**
	 * 请领科室
	 * @param Name_dep_apply
	 */
	public void setName_dep_apply(String Name_dep_apply) {
		setAttrVal("Name_dep_apply", Name_dep_apply);
	}
	/**
	 * 发送单号
	 * @return String
	 */
	public String getSendno() {
		return ((String) getAttrVal("Sendno"));
	}
	/**
	 * 发送单号
	 * @param Sendno
	 */
	public void setSendno(String Sendno) {
		setAttrVal("Sendno", Sendno);
	}
	/**
	 * 发放时间
	 * @return String
	 */
	public String getDt_send() {
		return ((String) getAttrVal("Dt_send"));
	}
	/**
	 * 发放时间
	 * @param Dt_send
	 */
	public void setDt_send(String Dt_send) {
		setAttrVal("Dt_send", Dt_send);
	}
	/**
	 * 接收人id
	 * @return String
	 */
	public String getId_emp_rcv() {
		return ((String) getAttrVal("Id_emp_rcv"));
	}
	/**
	 * 接收人id
	 * @param Id_emp_rcv
	 */
	public void setId_emp_rcv(String Id_emp_rcv) {
		setAttrVal("Id_emp_rcv", Id_emp_rcv);
	}
	/**
	 * 接收人
	 * @return String
	 */
	public String getName_emp_rcv() {
		return ((String) getAttrVal("Name_emp_rcv"));
	}
	/**
	 * 接收人
	 * @param Name_emp_rcv
	 */
	public void setName_emp_rcv(String Name_emp_rcv) {
		setAttrVal("Name_emp_rcv", Name_emp_rcv);
	}
	/**
	 * 接收时间
	 * @return String
	 */
	public String getDt_rcv() {
		return ((String) getAttrVal("Dt_rcv"));
	}
	/**
	 * 接收时间
	 * @param Dt_rcv
	 */
	public void setDt_rcv(String Dt_rcv) {
		setAttrVal("Dt_rcv", Dt_rcv);
	}
	/**
	 * 请领单明细dto
	 * @return String
	 */
	public String getChilddfpitmlist() {
		return ((String) getAttrVal("Childdfpitmlist"));
	}
	/**
	 * 请领单明细dto
	 * @param Childdfpitmlist
	 */
	public void setChilddfpitmlist(String Childdfpitmlist) {
		setAttrVal("Childdfpitmlist", Childdfpitmlist);
	}
}