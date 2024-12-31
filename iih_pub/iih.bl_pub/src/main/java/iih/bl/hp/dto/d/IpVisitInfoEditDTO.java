package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院登记修改dto DTO数据 
 * 
 */
public class IpVisitInfoEditDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院流水号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 住院流水号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 病历信息
	 * @return String
	 */
	public String getRecord() {
		return ((String) getAttrVal("Record"));
	}
	/**
	 * 病历信息
	 * @param Record
	 */
	public void setRecord(String Record) {
		setAttrVal("Record", Record);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}
	/**
	 * 床位号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getDoc_code() {
		return ((String) getAttrVal("Doc_code"));
	}
	/**
	 * 医生编码
	 * @param Doc_code
	 */
	public void setDoc_code(String Doc_code) {
		setAttrVal("Doc_code", Doc_code);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getDoc_name() {
		return ((String) getAttrVal("Doc_name"));
	}
	/**
	 * 医生姓名
	 * @param Doc_name
	 */
	public void setDoc_name(String Doc_name) {
		setAttrVal("Doc_name", Doc_name);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}
	/**
	 * 经办人
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 诊断疾病编码
	 * @return String
	 */
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}
	/**
	 * 诊断疾病编码
	 * @param Di_code
	 */
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}
	/**
	 * 诊断名称
	 * @param Di_name
	 */
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	/**
	 * 前次住院号
	 * @return String
	 */
	public String getLast_code_ent() {
		return ((String) getAttrVal("Last_code_ent"));
	}
	/**
	 * 前次住院号
	 * @param Last_code_ent
	 */
	public void setLast_code_ent(String Last_code_ent) {
		setAttrVal("Last_code_ent", Last_code_ent);
	}
	/**
	 * 第一副诊断疾病编码
	 * @return String
	 */
	public String getCode_firstvicediill() {
		return ((String) getAttrVal("Code_firstvicediill"));
	}
	/**
	 * 第一副诊断疾病编码
	 * @param Code_firstvicediill
	 */
	public void setCode_firstvicediill(String Code_firstvicediill) {
		setAttrVal("Code_firstvicediill", Code_firstvicediill);
	}
	/**
	 * 第一副诊断疾病名称
	 * @return String
	 */
	public String getName_firstvicediill() {
		return ((String) getAttrVal("Name_firstvicediill"));
	}
	/**
	 * 第一副诊断疾病名称
	 * @param Name_firstvicediill
	 */
	public void setName_firstvicediill(String Name_firstvicediill) {
		setAttrVal("Name_firstvicediill", Name_firstvicediill);
	}
	/**
	 * 第二副诊断疾病编码
	 * @return String
	 */
	public String getCode_secvicediill() {
		return ((String) getAttrVal("Code_secvicediill"));
	}
	/**
	 * 第二副诊断疾病编码
	 * @param Code_secvicediill
	 */
	public void setCode_secvicediill(String Code_secvicediill) {
		setAttrVal("Code_secvicediill", Code_secvicediill);
	}
	/**
	 * 第二副诊断疾病名称
	 * @return String
	 */
	public String getName_secvicediill() {
		return ((String) getAttrVal("Name_secvicediill"));
	}
	/**
	 * 第二副诊断疾病名称
	 * @param Name_secvicediill
	 */
	public void setName_secvicediill(String Name_secvicediill) {
		setAttrVal("Name_secvicediill", Name_secvicediill);
	}
}