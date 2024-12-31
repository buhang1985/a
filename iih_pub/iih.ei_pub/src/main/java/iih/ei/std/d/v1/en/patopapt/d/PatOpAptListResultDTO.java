package iih.ei.std.d.v1.en.patopapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 患者预约记录出参 DTO数据 
 * 
 */
public class PatOpAptListResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约记录
	 * @return String
	 */
	public FArrayList getPatopapt() {
		return ((FArrayList) getAttrVal("Patopapt"));
	}	
	/**
	 * 预约记录
	 * @param Patopapt
	 */
	public void setPatopapt(FArrayList Patopapt) {
		setAttrVal("Patopapt", Patopapt);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public PageInfoDTO getPageinfo() {
		return ((PageInfoDTO) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(PageInfoDTO Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}