package iih.ci.ord.external.blood.ruimei.d;
import xap.mw.core.data.*;
/**
 * 患者住院号参数 DTO数据 
 * 
 */
public class PatIpcodeParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者住院号
	 * @return String
	 */
	public String getIpcode() {
		return ((String) getAttrVal("Ipcode"));
	}
	/**
	 * 患者住院号
	 * @param Ipcode
	 */
	public void setIpcode(String Ipcode) {
		setAttrVal("Ipcode", Ipcode);
	}
	
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimesip() {
		return ((String) getAttrVal("Timesip"));
	}
	/**
	 * 住院次数
	 * @param Timesip
	 */
	public void setTimesip(String Timesip) {
		setAttrVal("Timesip", Timesip);
	}
}