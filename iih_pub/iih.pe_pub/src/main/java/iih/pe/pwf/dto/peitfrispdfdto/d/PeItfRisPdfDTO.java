package iih.pe.pwf.dto.peitfrispdfdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检检查图文报告dto DTO数据 
 * 
 */
public class PeItfRisPdfDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 体检编码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}
	/**
	 * 体检编码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 格式
	 * @return String
	 */
	public String getEx_format() {
		return ((String) getAttrVal("Ex_format"));
	}
	/**
	 * 格式
	 * @param Ex_format
	 */
	public void setEx_format(String Ex_format) {
		setAttrVal("Ex_format", Ex_format);
	}
	/**
	 * 报告数据
	 * @return byte[]
	 */
	public byte[] getReport_data() {
		return ((byte[]) getAttrVal("Report_data"));
	}
	/**
	 * 报告数据
	 * @param Report_data
	 */
	public void setReport_data(byte[] Report_data) {
		setAttrVal("Report_data", Report_data);
	}
}