package iih.ci.ord.i.external.thirdws.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 检验打印单据信息_第三方系统回传 DTO数据 
 * 
 */
public class EmsLisPrintDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	/**
	 * 检验医嘱DTO_第三方系统回传
	 * @return List<EmsDrugsPresDTO>
	 */
	public List<EmsLisOrdDTO> getOrdList() {
		return ((List<EmsLisOrdDTO>) getAttrVal("OrdList"));
	}
	/**
	 * 检验医嘱DTO_第三方系统回传
	 * @param PresList
	 */
	public void setOrdList(List<EmsLisOrdDTO> ordList) {
		setAttrVal("OrdList", ordList);
	}
}