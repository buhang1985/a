package iih.pe.pwf.testrptinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊断信息 DTO数据 
 * 
 */
public class DiagnosisesDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断类别编码
	 * @return String
	 */
	public String getDiagnosistype() {
		return ((String) getAttrVal("Diagnosistype"));
	}
	/**
	 * 诊断类别编码
	 * @param Diagnosistype
	 */
	public void setDiagnosistype(String Diagnosistype) {
		setAttrVal("Diagnosistype", Diagnosistype);
	}
	/**
	 * 诊断类型名称
	 * @return String
	 */
	public String getDiagnosistypename() {
		return ((String) getAttrVal("Diagnosistypename"));
	}
	/**
	 * 诊断类型名称
	 * @param Diagnosistypename
	 */
	public void setDiagnosistypename(String Diagnosistypename) {
		setAttrVal("Diagnosistypename", Diagnosistypename);
	}
	/**
	 * 临床诊断编码(疾病编码)
	 * @return String
	 */
	public String getDiseasecode() {
		return ((String) getAttrVal("Diseasecode"));
	}
	/**
	 * 临床诊断编码(疾病编码)
	 * @param Diseasecode
	 */
	public void setDiseasecode(String Diseasecode) {
		setAttrVal("Diseasecode", Diseasecode);
	}
	/**
	 * 临床诊断(疾病名称)
	 * @return String
	 */
	public String getDiseasename() {
		return ((String) getAttrVal("Diseasename"));
	}
	/**
	 * 临床诊断(疾病名称)
	 * @param Diseasename
	 */
	public void setDiseasename(String Diseasename) {
		setAttrVal("Diseasename", Diseasename);
	}
	/**
	 * 报告号
	 * @return String
	 */
	public String getReportno() {
		return ((String) getAttrVal("Reportno"));
	}
	/**
	 * 报告号
	 * @param Reportno
	 */
	public void setReportno(String Reportno) {
		setAttrVal("Reportno", Reportno);
	}
}