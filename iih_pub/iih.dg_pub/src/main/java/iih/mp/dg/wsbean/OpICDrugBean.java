package iih.mp.dg.wsbean;

/**
 * 智能柜药品信息bean
 * @author ly 2017/04/12
 *
 */
public class OpICDrugBean {

	private String DispensingBillCode;
	private String BillType;
	private String ToStockCode;
	private String FromStockCode;
	private String InsertStatus;
	private String InsertUserId;
	private String InsertDate;
	private String BillDetailCode;
	private String DispeinsingCode;
	private String PatientCode;
	private String PatientName;
	private String AdmitDateTime;
	private Integer AdmitCount;
	private String PatientSex;
	private String PatientAge;
	private String BirthDate;
	private String JuminId;
	private String DeptCode;
	private String DeptCode1;
	private String BedNo;
	private String ItemCode;
	private String SubPackagingFlag;
	private Integer PlanQuantity;
	private String PlusCode;
	private String PlusName;
	private String AccountDate;
	
	/**
	 * 单号
	 * @return
	 */
	public String getDispensingBillCode() {
		return DispensingBillCode;
	}
	/**
	 * 单号
	 * 患者ID+就诊次数+处方号
	 * @param dispensingBillCode
	 */
	public void setDispensingBillCode(String dispensingBillCode) {
		DispensingBillCode = dispensingBillCode;
	}
	/**
	 * 单类型
	 * @return
	 */
	public String getBillType() {
		return BillType;
	}
	/**
	 * 单类型
	 * @param billType
	 */
	public void setBillType(String billType) {
		BillType = billType;
	}
	/**
	 * 取药药房
	 * @return
	 */
	public String getToStockCode() {
		return ToStockCode;
	}
	/**
	 * 取药药房
	 * @param toStockCode
	 */
	public void setToStockCode(String toStockCode) {
		ToStockCode = toStockCode;
	}
	/**
	 * 来源药房
	 * @return
	 */
	public String getFromStockCode() {
		return FromStockCode;
	}
	/**
	 * 来源药房
	 * @param fromStockCode
	 */
	public void setFromStockCode(String fromStockCode) {
		FromStockCode = fromStockCode;
	}
	/**
	 * 插入状态
	 * @return
	 */
	public String getInsertStatus() {
		return InsertStatus;
	}
	/**
	 * 插入状态
	 * @param insertStatus
	 */
	public void setInsertStatus(String insertStatus) {
		InsertStatus = insertStatus;
	}
	/**
	 * 医生姓名
	 * @return
	 */
	public String getInsertUserId() {
		return InsertUserId;
	}
	/**
	 * 医生姓名
	 * @param insertUserId
	 */
	public void setInsertUserId(String insertUserId) {
		InsertUserId = insertUserId;
	}
	/**
	 * 开方时间
	 * @return
	 */
	public String getInsertDate() {
		return InsertDate;
	}
	/**
	 * 开方时间
	 * @param insertDate
	 */
	public void setInsertDate(String insertDate) {
		InsertDate = insertDate;
	}
	/**
	 * 处方序号
	 * @return
	 */
	public String getBillDetailCode() {
		return BillDetailCode;
	}
	/**
	 * 处方序号
	 * @param billDetailCode
	 */
	public void setBillDetailCode(String billDetailCode) {
		BillDetailCode = billDetailCode;
	}
	/**
	 * 发放号
	 * @return
	 */
	public String getDispeinsingCode() {
		return DispeinsingCode;
	}
	/**
	 * 发放号
	 * @param dispeinsingCode
	 */
	public void setDispeinsingCode(String dispeinsingCode) {
		DispeinsingCode = dispeinsingCode;
	}
	/**
	 * 患者编码
	 * @return
	 */
	public String getPatientCode() {
		return PatientCode;
	}
	/**
	 * 患者编码
	 * @param patientCode
	 */
	public void setPatientCode(String patientCode) {
		PatientCode = patientCode;
	}
	/**
	 * 患者姓名
	 * @return
	 */
	public String getPatientName() {
		return PatientName;
	}
	/**
	 * 患者姓名
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	/**
	 * 就诊时间
	 * @return
	 */
	public String getAdmitDateTime() {
		return AdmitDateTime;
	}
	/**
	 * 就诊时间
	 * @param admitDateTime
	 */
	public void setAdmitDateTime(String admitDateTime) {
		AdmitDateTime = admitDateTime;
	}
	/**
	 * 就诊次数
	 * @return
	 */
	public Integer getAdmitCount() {
		return AdmitCount;
	}
	/**
	 * 就诊次数
	 * @param admitCount
	 */
	public void setAdmitCount(Integer admitCount) {
		AdmitCount = admitCount;
	}
	/**
	 * 性别
	 * @return
	 */
	public String getPatientSex() {
		return PatientSex;
	}
	/**
	 * 性别
	 * @param patientSex
	 */
	public void setPatientSex(String patientSex) {
		PatientSex = patientSex;
	}
	/**
	 * 年龄
	 * @return
	 */
	public String getPatientAge() {
		return PatientAge;
	}
	/**
	 * 年龄
	 * @param patientAge
	 */
	public void setPatientAge(String patientAge) {
		PatientAge = patientAge;
	}
	/**
	 * 出生日期
	 * @return
	 */
	public String getBirthDate() {
		return BirthDate;
	}
	/**
	 * 出生日期
	 * @param birthDate
	 */
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	/**
	 * 证件号
	 * @return
	 */
	public String getJuminId() {
		return JuminId;
	}
	/**
	 * 证件号
	 * @param juminId
	 */
	public void setJuminId(String juminId) {
		JuminId = juminId;
	}
	/**
	 * 部门编码(留空)
	 * @return
	 */
	public String getDeptCode() {
		return DeptCode;
	}
	/**
	 * 部门编码(留空)
	 * @param deptCode
	 */
	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}
	/**
	 * 部门编码1(留空)
	 * @return
	 */
	public String getDeptCode1() {
		return DeptCode1;
	}
	/**
	 * 部门编码1(留空)
	 * @param deptCode1
	 */
	public void setDeptCode1(String deptCode1) {
		DeptCode1 = deptCode1;
	}
	/**
	 * 床号(留空)
	 * @return
	 */
	public String getBedNo() {
		return BedNo;
	}
	/**
	 * 床号(留空)
	 * @param bedNo
	 */
	public void setBedNo(String bedNo) {
		BedNo = bedNo;
	}
	/**
	 * 药品编码
	 * @return
	 */
	public String getItemCode() {
		return ItemCode;
	}
	/**
	 * 药品编码
	 * @param itemCode
	 */
	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	/**
	 * 子包装标志(留空)
	 * @return
	 */
	public String getSubPackagingFlag() {
		return SubPackagingFlag;
	}
	/**
	 * 子包装标志(留空)
	 * @param subPackagingFlag
	 */
	public void setSubPackagingFlag(String subPackagingFlag) {
		SubPackagingFlag = subPackagingFlag;
	}
	/**
	 * 数量
	 * @return
	 */
	public Integer getPlanQuantity() {
		return PlanQuantity;
	}
	/**
	 * 数量
	 * @param planQuantity
	 */
	public void setPlanQuantity(Integer planQuantity) {
		PlanQuantity = planQuantity;
	}
	/**
	 * 用法编码
	 * @return
	 */
	public String getPlusCode() {
		return PlusCode;
	}
	/**
	 * 用法编码
	 * @param plusCode
	 */
	public void setPlusCode(String plusCode) {
		PlusCode = plusCode;
	}
	/**
	 * 用法
	 * @return
	 */
	public String getPlusName() {
		return PlusName;
	}
	/**
	 * 用法
	 * @param plusName
	 */
	public void setPlusName(String plusName) {
		PlusName = plusName;
	}
	
	/**
	 * 记账时间
	 * @return
	 */
	public String getAccountDate() {
		return AccountDate;
	}
	
	/**
	 * 记账时间
	 * @param accountDate
	 */
	public void setAccountDate(String accountDate) {
		AccountDate = accountDate;
	}
}
