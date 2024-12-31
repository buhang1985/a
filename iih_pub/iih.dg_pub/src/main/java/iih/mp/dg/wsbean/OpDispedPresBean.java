package iih.mp.dg.wsbean;


/**
 * 门诊已摆药处方信息bean
 * @author ly
 *
 */
public class OpDispedPresBean {

	private String Prescription_no;
	private String Patient_id;
	private String Patient_name;
	private String Wicket;
	private String Shelf_no;
	private String Charge_time;
	private Integer Ledger_sn;
	private String Confim_flag;
	
	/**
	 * 唯一处方编号
	 * @return String
	 */
	public String getPrescription_no() {
		return Prescription_no;
	}
	/**
	 * 唯一处方编号
	 * @param prescription_no
	 */
	public void setPrescription_no(String prescription_no) {
		Prescription_no = prescription_no;
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatient_id() {
		return Patient_id;
	}
	/**
	 * 患者ID
	 * @param patient_id
	 */
	public void setPatient_id(String patient_id) {
		Patient_id = patient_id;
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatient_name() {
		return Patient_name;
	}
	/**
	 * 患者姓名
	 * @param patient_name
	 */
	public void setPatient_name(String patient_name) {
		Patient_name = patient_name;
	}
	/**
	 * 取药窗口号
	 * @return String
	 */
	public String getWicket() {
		return Wicket;
	}
	/**
	 * 取药窗口号
	 * @param wicket
	 */
	public void setWicket(String wicket) {
		Wicket = wicket;
	}
	/**
	 * 药架货位号
	 * @return String
	 */
	public String getShelf_no() {
		return Shelf_no;
	}
	/**
	 * 药架货位号
	 * @param shelf_no
	 */
	public void setShelf_no(String shelf_no) {
		Shelf_no = shelf_no;
	}
	/**
	 * 收费时间
	 * @return FDateTime
	 */
	public String getCharge_time() {
		return Charge_time;
	}
	/**
	 * 收费时间
	 * @param charge_time
	 */
	public void setCharge_time(String charge_time) {
		Charge_time = charge_time;
	}
	/**
	 * 结账次数
	 * @return Integer
	 */
	public Integer getLedger_sn() {
		return Ledger_sn;
	}
	/**
	 * 结账次数
	 * @param ledger_sn
	 */
	public void setLedger_sn(Integer ledger_sn) {
		Ledger_sn = ledger_sn;
	}
	/**
	 * 发药标记
	 * @return String
	 */
	public String getConfim_flag() {
		return Confim_flag;
	}
	/**
	 * 发药标记
	 * @param confim_flag
	 */
	public void setConfim_flag(String confim_flag) {
		Confim_flag = confim_flag;
	}
}
