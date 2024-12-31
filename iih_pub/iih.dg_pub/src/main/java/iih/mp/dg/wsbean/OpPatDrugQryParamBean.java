package iih.mp.dg.wsbean;

/**
 * 患者用药查询参数
 * @author ly 2017/04/10
 *
 */
public class OpPatDrugQryParamBean {

	private String DrugName;
	private String DrugSpell;
	private String PatientID;
	private String StartTime;
	private String EndTime;
	
	/**
	 * 药品名称
	 * @return
	 */
	public String getDrugName() {
		return DrugName;
	}
	
	/**
	 * 药品名称
	 * @param drugName
	 */
	public void setDrugName(String drugName) {
		DrugName = drugName;
	}
	
	/**
	 * 药品简拼
	 * @return
	 */
	public String getDrugSpell() {
		return DrugSpell;
	}
	
	/**
	 * 药品简拼
	 * @param drugSpell
	 */
	public void setDrugSpell(String drugSpell) {
		DrugSpell = drugSpell;
	}
	
	/**
	 * 患者PID
	 * @return
	 */
	public String getPatientID() {
		return PatientID;
	}
	
	/**
	 * 患者PID
	 * @param patientID
	 */
	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	
	/**
	 * 开始时间 
	 * 格式:yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public String getStartTime() {
		return StartTime;
	}
	
	/**
	 * 开始时间 
	 * 格式:yyyy-MM-dd hh:mm:ss
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	
	/**
	 * 结束时间 
	 * 格式:yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public String getEndTime() {
		return EndTime;
	}
	
	/**
	 * 结束时间 
	 * 格式:yyyy-MM-dd hh:mm:ss
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
}
