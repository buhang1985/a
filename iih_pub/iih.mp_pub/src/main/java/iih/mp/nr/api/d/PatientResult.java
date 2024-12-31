package iih.mp.nr.api.d;

import java.io.Serializable;
import java.util.List;

public class PatientResult implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
   
	/**
	 * 头信息
	 */
	private HeadMessage HeadMessage;
	
	/**
	 * 患者信息
	 */
	private List PatientsList;

	public HeadMessage getHeadMessage() {
		return HeadMessage;
	}

	public void setHeadMessage(HeadMessage headMessage) {
		HeadMessage = headMessage;
	}

	public List getPatientsList() {
		return PatientsList;
	}

	public void setPatientsList(List patientsList) {
		PatientsList = patientsList;
	}
	
	
	
}
