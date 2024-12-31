package iih.ei.std.d.v1.en.entlistbypatcode.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 获取患者的就诊记录(通过患者编码)出参 DTO数据 
 * 
 */
public class EntListByPatcodeResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取患者的就诊记录(通过患者编码)
	 * @return String
	 */
	public FArrayList getEntlistbypatcode() {
		return ((FArrayList) getAttrVal("Entlistbypatcode"));
	}	
	/**
	 * 获取患者的就诊记录(通过患者编码)
	 * @param Entlistbypatcode
	 */
	public void setEntlistbypatcode(FArrayList Entlistbypatcode) {
		setAttrVal("Entlistbypatcode", Entlistbypatcode);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public FArrayList getPageinfo() {
		return ((FArrayList) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(FArrayList Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}