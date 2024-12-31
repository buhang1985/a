package iih.mp.dg.dto.opdgdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 最近就诊次数 DTO数据 
 * 
 */
public class OutpatientTimesDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊门诊属性id
	 * @return String
	 */
	public String getId_outpatient() {
		return ((String) getAttrVal("Id_outpatient"));
	}
	/**
	 * 就诊门诊属性id
	 * @param Id_outpatient
	 */
	public void setId_outpatient(String Id_outpatient) {
		setAttrVal("Id_outpatient", Id_outpatient);
	}
	/**
	 * 门诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}
	/**
	 * 门诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
}