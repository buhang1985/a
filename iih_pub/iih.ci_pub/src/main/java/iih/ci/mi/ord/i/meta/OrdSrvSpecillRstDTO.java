package iih.ci.mi.ord.i.meta;

import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱服务项目特殊病校验结果
 * @author HUMS
 *
 */
public class OrdSrvSpecillRstDTO extends OrdSrvSpecillParamDTO{

	private static final long serialVersionUID = 1L;

	/**
	 * 是否为特殊病药品
	 * @return String
	 */
	public FBoolean getFg_specdrug() {
		return ((FBoolean) getAttrVal("Fg_specdrug"));
	}
	
	/**
	 * 是否为特殊病药品
	 * @param Fg_specdrug
	 */
	public void setFg_specdrug(FBoolean Fg_specdrug) {
		setAttrVal("Fg_specdrug", Fg_specdrug);
	}
	
	/**
	 * 特殊病判断判断结果（药品：是特殊病药品，并且存在对应的特殊病诊断或病种，非药品：存在特殊诊断 返回结果是Y ,否则返回N）
	 * @return FBoolean
	 */
	public FBoolean getFg_specill() {
		return ((FBoolean) getAttrVal("Fg_specill"));
	}
	
	/**
	 * 特殊病判断判断结果
	 * @param Fg_specill
	 */
	public void setFg_specill(FBoolean Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	
	/**
	 * 特殊病判断判断结果（药品：是特殊病药品，并且存在对应的特殊病诊断或病种，非药品：存在特殊诊断 返回结果是Y ,否则返回N）
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}
	
	/**
	 * 特殊病判断判断结果
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
	}
}
