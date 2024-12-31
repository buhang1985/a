package iih.ci.rcm.infectionrate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.infectionrate.d.desc.InfectionDiagnosisDODesc;
import java.math.BigDecimal;

/**
 * 感染诊断 DO数据 
 * 
 */
public class InfectionDiagnosisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//诊断主键
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	//疾病诊断
	public static final String ID_DI_DIAGNOSIS= "Id_di_diagnosis";
	//疾病诊断编码
	public static final String SD_DI_DIAGNOSIS= "Sd_di_diagnosis";
	//疾病诊断名称
	public static final String NAME_DI_DIAGNOSIS= "Name_di_diagnosis";
	//医院感染现患率主键
	public static final String ID_MMRATEHOSPITALINFECTION= "Id_mmratehospitalinfection";
	//序号
	public static final String SERIAL_NUMBER= "Serial_number";
	//备注
	public static final String REMARK= "Remark";
	//诊断编码
	public static final String DI_DIAGNOSIS_CODE= "Di_diagnosis_code";
	//诊断名称
	public static final String DI_DIAGNOSIS_NAME= "Di_diagnosis_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 诊断主键
	 * @return String
	 */
	public String getId_diagnosis() {
		return ((String) getAttrVal("Id_diagnosis"));
	}	
	/**
	 * 诊断主键
	 * @param Id_diagnosis
	 */
	public void setId_diagnosis(String Id_diagnosis) {
		setAttrVal("Id_diagnosis", Id_diagnosis);
	}
	/**
	 * 疾病诊断
	 * @return String
	 */
	public String getId_di_diagnosis() {
		return ((String) getAttrVal("Id_di_diagnosis"));
	}	
	/**
	 * 疾病诊断
	 * @param Id_di_diagnosis
	 */
	public void setId_di_diagnosis(String Id_di_diagnosis) {
		setAttrVal("Id_di_diagnosis", Id_di_diagnosis);
	}
	/**
	 * 疾病诊断编码
	 * @return String
	 */
	public String getSd_di_diagnosis() {
		return ((String) getAttrVal("Sd_di_diagnosis"));
	}	
	/**
	 * 疾病诊断编码
	 * @param Sd_di_diagnosis
	 */
	public void setSd_di_diagnosis(String Sd_di_diagnosis) {
		setAttrVal("Sd_di_diagnosis", Sd_di_diagnosis);
	}
	/**
	 * 疾病诊断名称
	 * @return String
	 */
	public String getName_di_diagnosis() {
		return ((String) getAttrVal("Name_di_diagnosis"));
	}	
	/**
	 * 疾病诊断名称
	 * @param Name_di_diagnosis
	 */
	public void setName_di_diagnosis(String Name_di_diagnosis) {
		setAttrVal("Name_di_diagnosis", Name_di_diagnosis);
	}
	/**
	 * 医院感染现患率主键
	 * @return String
	 */
	public String getId_mmratehospitalinfection() {
		return ((String) getAttrVal("Id_mmratehospitalinfection"));
	}	
	/**
	 * 医院感染现患率主键
	 * @param Id_mmratehospitalinfection
	 */
	public void setId_mmratehospitalinfection(String Id_mmratehospitalinfection) {
		setAttrVal("Id_mmratehospitalinfection", Id_mmratehospitalinfection);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSerial_number() {
		return ((String) getAttrVal("Serial_number"));
	}	
	/**
	 * 序号
	 * @param Serial_number
	 */
	public void setSerial_number(String Serial_number) {
		setAttrVal("Serial_number", Serial_number);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDi_diagnosis_code() {
		return ((String) getAttrVal("Di_diagnosis_code"));
	}	
	/**
	 * 诊断编码
	 * @param Di_diagnosis_code
	 */
	public void setDi_diagnosis_code(String Di_diagnosis_code) {
		setAttrVal("Di_diagnosis_code", Di_diagnosis_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_diagnosis_name() {
		return ((String) getAttrVal("Di_diagnosis_name"));
	}	
	/**
	 * 诊断名称
	 * @param Di_diagnosis_name
	 */
	public void setDi_diagnosis_name(String Di_diagnosis_name) {
		setAttrVal("Di_diagnosis_name", Di_diagnosis_name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_diagnosis";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_infectdia";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InfectionDiagnosisDODesc.class);
	}
	
}