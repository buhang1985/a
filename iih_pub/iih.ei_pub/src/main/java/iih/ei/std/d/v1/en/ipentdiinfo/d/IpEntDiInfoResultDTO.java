package iih.ei.std.d.v1.en.ipentdiinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院患者诊断出参 DTO数据 
 * 
 */
public class IpEntDiInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院患者诊断
	 * @return String
	 */
	public FArrayList getIpentdiinfolist() {
		return ((FArrayList) getAttrVal("Ipentdiinfolist"));
	}	
	/**
	 * 住院患者诊断
	 * @param Ipentdiinfolist
	 */
	public void setIpentdiinfolist(FArrayList Ipentdiinfolist) {
		setAttrVal("Ipentdiinfolist", Ipentdiinfolist);
	}
}