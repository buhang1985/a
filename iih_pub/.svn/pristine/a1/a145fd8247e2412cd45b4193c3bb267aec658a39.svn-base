package iih.ci.ord.i.external.thirdws.ris.d;

import xap.mw.core.data.*;

import java.util.List;



/**
 * 第三方检查打印入参 DTO数据 
 * 
 */
public class EmsRisPrintDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检查医嘱DTO_第三方系统回传
	 * @return List<EmsDrugsPresDTO>
	 */
	public List<EmsRisOrdDTO> getOrdList() {
		return ((List<EmsRisOrdDTO>) getAttrVal("OrdList"));
	}
	/**
	 * 检查医嘱DTO_第三方系统回传
	 * @param PresList
	 */
	public void setOrdList(List<EmsRisOrdDTO> ordList) {
		setAttrVal("OrdList", ordList);
	}
	
	/**
	 * 申请单打印号
	 * @return String
	 */
	public String getCode_app() {
		return ((String) getAttrVal("Code_app"));
	}
	/**
	 * 申请单打印号
	 * @param Code_app
	 */
	public void setCode_app(String Code_app) {
		setAttrVal("Code_app", Code_app);
	}
	/**
	 * 申请金额
	 * @return String
	 */
	public String getAmt_app() {
		return ((String) getAttrVal("Amt_app"));
	}
	/**
	 * 申请金额
	 * @param Amt_app
	 */
	public void setAmt_app(String Amt_app) {
		setAttrVal("Amt_app", Amt_app);
	}
}