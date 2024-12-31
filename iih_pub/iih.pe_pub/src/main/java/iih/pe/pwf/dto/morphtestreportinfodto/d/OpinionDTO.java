package iih.pe.pwf.dto.morphtestreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 补充意见信息 DTO数据 
 * 
 */
public class OpinionDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验项编码
	 * @return String
	 */
	public String getLabitemcode() {
		return ((String) getAttrVal("Labitemcode"));
	}
	/**
	 * 检验项编码
	 * @param Labitemcode
	 */
	public void setLabitemcode(String Labitemcode) {
		setAttrVal("Labitemcode", Labitemcode);
	}
	/**
	 * 意见顺序号
	 * @return String
	 */
	public String getSeqno() {
		return ((String) getAttrVal("Seqno"));
	}
	/**
	 * 意见顺序号
	 * @param Seqno
	 */
	public void setSeqno(String Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 补充意见
	 * @return String
	 */
	public String getOpinion() {
		return ((String) getAttrVal("Opinion"));
	}
	/**
	 * 补充意见
	 * @param Opinion
	 */
	public void setOpinion(String Opinion) {
		setAttrVal("Opinion", Opinion);
	}
}