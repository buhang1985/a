package iih.ci.mrfp.hospitalfirstpagedto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDate;

/**
 * otherdiagdto DTO数据 
 * 
 */
public class MrfpOtherdiagDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	/**
	 * id
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 其他诊断-确认日期
	 * @return FDate
	 */
	public FDate getDt_otherdiag() {
		return ((FDate) getAttrVal("Dt_otherdiag"));
	}	
	/**
	 * 其他诊断-确认日期
	 * @param Dt_otherdiag
	 */
	public void setDt_otherdiag(FDate Dt_otherdiag) {
		setAttrVal("Dt_otherdiag", Dt_otherdiag);
	}
	/**
	 * 其他诊断-疾病编码
	 * @return String
	 */
	public String getCode_otherdiag() {
		return ((String) getAttrVal("Code_otherdiag"));
	}	
	/**
	 * 其他诊断-疾病编码
	 * @param Code_otherdiag
	 */
	public void setCode_otherdiag(String Code_otherdiag) {
		setAttrVal("Code_otherdiag", Code_otherdiag);
	}
	/**
	 * 其他诊断-疾病名称
	 * @return String
	 */
	public String getName_otherdiag() {
		return ((String) getAttrVal("Name_otherdiag"));
	}	
	/**
	 * 其他诊断-疾病名称
	 * @param Name_otherdiag
	 */
	public void setName_otherdiag(String Name_otherdiag) {
		setAttrVal("Name_otherdiag", Name_otherdiag);
	}
	/**
	 * 其他诊断-入院病情名称
	 * @return String
	 */
	public String getRuyuanbq_otherdiag() {
		return ((String) getAttrVal("Ruyuanbq_otherdiag"));
	}	
	/**
	 * 其他诊断-入院病情名称
	 * @param Ruyuanbq_otherdiag
	 */
	public void setRuyuanbq_otherdiag(String Ruyuanbq_otherdiag) {
		setAttrVal("Ruyuanbq_otherdiag", Ruyuanbq_otherdiag);
	}
}