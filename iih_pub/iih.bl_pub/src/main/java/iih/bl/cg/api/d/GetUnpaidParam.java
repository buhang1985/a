package iih.bl.cg.api.d;

import java.util.Date;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年5月22日 下午3:29:46
 * 类说明：获取未缴费列表 接口参数 
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class GetUnpaidParam {

	private String patient_id;//患者ID
	
	private String patient_type;//患者类型
	
	private String sdate ;//开始时间
	
	private String edate ;//结束时间

	/**
	 * 患者ID
	 * @return
	 */
	public String getPatient_id() {
		return patient_id;
	}

	/**
	 * 患者ID
	 * @param patient_id
	 */
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * 患者类型
	 * @return
	 */
	public String getPatient_type() {
		return patient_type;
	}

	/**
	 * 患者类型
	 * @param patient_type
	 */
	public void setPatient_type(String patient_type) {
		this.patient_type = patient_type;
	}

	/**
	 * 开始时间
	 * @return
	 */
	public String getSdate() {
		return sdate;
	}

	/**
	 * 开始时间
	 * @param sdate
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	/**
	 * 结束时间
	 * @return
	 */
	public String getEdate() {
		return edate;
	}

	/**
	 * 结束时间
	 * @param edate
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	
}
