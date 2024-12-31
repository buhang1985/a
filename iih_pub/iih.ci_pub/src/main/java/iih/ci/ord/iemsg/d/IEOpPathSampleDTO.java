package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊病理标本信息dto DTO数据 
 * 
 */
public class IEOpPathSampleDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本id
	 * @return String
	 */
	public String getId_sample() {
		return ((String) getAttrVal("Id_sample"));
	}
	/**
	 * 标本id
	 * @param Id_sample
	 */
	public void setId_sample(String Id_sample) {
		setAttrVal("Id_sample", Id_sample);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 标本分类编码
	 * @return String
	 */
	public String getSampletypecode() {
		return ((String) getAttrVal("Sampletypecode"));
	}
	/**
	 * 标本分类编码
	 * @param Sampletypecode
	 */
	public void setSampletypecode(String Sampletypecode) {
		setAttrVal("Sampletypecode", Sampletypecode);
	}
	/**
	 * 标本分类名称
	 * @return String
	 */
	public String getSampletypename() {
		return ((String) getAttrVal("Sampletypename"));
	}
	/**
	 * 标本分类名称
	 * @param Sampletypename
	 */
	public void setSampletypename(String Sampletypename) {
		setAttrVal("Sampletypename", Sampletypename);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getSampleaccounts() {
		return ((String) getAttrVal("Sampleaccounts"));
	}
	/**
	 * 数量
	 * @param Sampleaccounts
	 */
	public void setSampleaccounts(String Sampleaccounts) {
		setAttrVal("Sampleaccounts", Sampleaccounts);
	}
	/**
	 * 送检标本描述
	 * @return String
	 */
	public String getInspectionsample() {
		return ((String) getAttrVal("Inspectionsample"));
	}
	/**
	 * 送检标本描述
	 * @param Inspectionsample
	 */
	public void setInspectionsample(String Inspectionsample) {
		setAttrVal("Inspectionsample", Inspectionsample);
	}
	/**
	 * 病变部位编码
	 * @return String
	 */
	public String getPathologybodycode() {
		return ((String) getAttrVal("Pathologybodycode"));
	}
	/**
	 * 病变部位编码
	 * @param Pathologybodycode
	 */
	public void setPathologybodycode(String Pathologybodycode) {
		setAttrVal("Pathologybodycode", Pathologybodycode);
	}
	/**
	 * 病变部位名称
	 * @return String
	 */
	public String getPathologybodyname() {
		return ((String) getAttrVal("Pathologybodyname"));
	}
	/**
	 * 病变部位名称
	 * @param Pathologybodyname
	 */
	public void setPathologybodyname(String Pathologybodyname) {
		setAttrVal("Pathologybodyname", Pathologybodyname);
	}
	/**
	 * 离体时间(采集日期)
	 * @return FDateTime
	 */
	public FDateTime getInvitrodate() {
		return ((FDateTime) getAttrVal("Invitrodate"));
	}
	/**
	 * 离体时间(采集日期)
	 * @param Invitrodate
	 */
	public void setInvitrodate(FDateTime Invitrodate) {
		setAttrVal("Invitrodate", Invitrodate);
	}
	/**
	 * 固定时间
	 * @return FDateTime
	 */
	public FDateTime getFixeddate() {
		return ((FDateTime) getAttrVal("Fixeddate"));
	}
	/**
	 * 固定时间
	 * @param Fixeddate
	 */
	public void setFixeddate(FDateTime Fixeddate) {
		setAttrVal("Fixeddate", Fixeddate);
	}
}