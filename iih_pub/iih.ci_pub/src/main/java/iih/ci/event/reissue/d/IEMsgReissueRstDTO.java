package iih.ci.event.reissue.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 消息补发返回dto DTO数据 
 * 
 */
public class IEMsgReissueRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结果码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 结果码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 返回结果
	 * @return String
	 */
	public String getResult() {
		return ((String) getAttrVal("Result"));
	}
	/**
	 * 返回结果
	 * @param Result
	 */
	public void setResult(String Result) {
		setAttrVal("Result", Result);
	}
	/**
	 * 消息条目
	 * @return
	 */
	public List<IEMsgReissueItmDTO> getReissueItms(){
		return ((List<IEMsgReissueItmDTO>) getAttrVal("ReissueItms"));
	}
	/**
	 * 消息条目
	 * @param ReissueItms
	 */
	public void setReissueItms(List<IEMsgReissueItmDTO> ReissueItms) {
		setAttrVal("ReissueItms", ReissueItms);
	}
}