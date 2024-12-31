package iih.bd.pp.hpsrvorcadto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保目录对照dto DTO数据 
 * 
 */
public class HpsrvorcaDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保病种目录对照DTO主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 医保病种目录对照DTO主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * HIS编码
	 * @return String
	 */
	public String getHis_code() {
		return ((String) getAttrVal("His_code"));
	}
	/**
	 * HIS编码
	 * @param His_code
	 */
	public void setHis_code(String His_code) {
		setAttrVal("His_code", His_code);
	}
	/**
	 * HIS名称
	 * @return String
	 */
	public String getHis_name() {
		return ((String) getAttrVal("His_name"));
	}
	/**
	 * HIS名称
	 * @param His_name
	 */
	public void setHis_name(String His_name) {
		setAttrVal("His_name", His_name);
	}
	/**
	 * 医保编码
	 * @return String
	 */
	public String getInsur_code() {
		return ((String) getAttrVal("Insur_code"));
	}
	/**
	 * 医保编码
	 * @param Insur_code
	 */
	public void setInsur_code(String Insur_code) {
		setAttrVal("Insur_code", Insur_code);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getInsur_name() {
		return ((String) getAttrVal("Insur_name"));
	}
	/**
	 * 医保名称
	 * @param Insur_name
	 */
	public void setInsur_name(String Insur_name) {
		setAttrVal("Insur_name", Insur_name);
	}
	/**
	 * 医保剂型编码
	 * @return String
	 */
	public String getCode_dosage() {
		return ((String) getAttrVal("Code_dosage"));
	}
	/**
	 * 医保剂型编码
	 * @param Code_dosage
	 */
	public void setCode_dosage(String Code_dosage) {
		setAttrVal("Code_dosage", Code_dosage);
	}
	/**
	 * 医保剂型名称
	 * @return String
	 */
	public String getName_dosage() {
		return ((String) getAttrVal("Name_dosage"));
	}
	/**
	 * 医保剂型名称
	 * @param Name_dosage
	 */
	public void setName_dosage(String Name_dosage) {
		setAttrVal("Name_dosage", Name_dosage);
	}
	/**
	 * HIS剂型编码
	 * @return String
	 */
	public String getHiscode_dosage() {
		return ((String) getAttrVal("Hiscode_dosage"));
	}
	/**
	 * HIS剂型编码
	 * @param Hiscode_dosage
	 */
	public void setHiscode_dosage(String Hiscode_dosage) {
		setAttrVal("Hiscode_dosage", Hiscode_dosage);
	}
	/**
	 * HIS剂型名称
	 * @return String
	 */
	public String getHisname_dosage() {
		return ((String) getAttrVal("Hisname_dosage"));
	}
	/**
	 * HIS剂型名称
	 * @param Hisname_dosage
	 */
	public void setHisname_dosage(String Hisname_dosage) {
		setAttrVal("Hisname_dosage", Hisname_dosage);
	}
	/**
	 * 所属状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 所属状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 医保项目类别
	 * @return String
	 */
	public String getEu_hpsrvtp() {
		return ((String) getAttrVal("Eu_hpsrvtp"));
	}
	/**
	 * 医保项目类别
	 * @param Eu_hpsrvtp
	 */
	public void setEu_hpsrvtp(String Eu_hpsrvtp) {
		setAttrVal("Eu_hpsrvtp", Eu_hpsrvtp);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}
	/**
	 * 扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
}