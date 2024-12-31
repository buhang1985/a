package iih.mp.dg.dto.mpherbverify.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 草药审核结果dto DTO数据 
 * 
 */
public class MpHerbVerifyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请领主键
	 * @return String
	 */
	public String getId_dgipap() {
		return ((String) getAttrVal("Id_dgipap"));
	}
	/**
	 * 请领主键
	 * @param Id_dgipap
	 */
	public void setId_dgipap(String Id_dgipap) {
		setAttrVal("Id_dgipap", Id_dgipap);
	}
	/**
	 * 审核通过标志
	 * @return FBoolean
	 */
	public FBoolean getFg_verify() {
		return ((FBoolean) getAttrVal("Fg_verify"));
	}
	/**
	 * 审核通过标志
	 * @param Fg_verify
	 */
	public void setFg_verify(FBoolean Fg_verify) {
		setAttrVal("Fg_verify", Fg_verify);
	}
	/**
	 * 审核信息
	 * @return String
	 */
	public String getMsg_verify() {
		return ((String) getAttrVal("Msg_verify"));
	}
	/**
	 * 审核信息
	 * @param Msg_verify
	 */
	public void setMsg_verify(String Msg_verify) {
		setAttrVal("Msg_verify", Msg_verify);
	}
}