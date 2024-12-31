package iih.ei.std.d.v1.en.opstopschlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊停诊列表出参 DTO数据 
 * 
 */
public class OpStopSchListResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊停诊列表
	 * @return String
	 */
	public FArrayList getOpstopschlist() {
		return ((FArrayList) getAttrVal("Opstopschlist"));
	}	
	/**
	 * 门诊停诊列表
	 * @param Opstopschlist
	 */
	public void setOpstopschlist(FArrayList Opstopschlist) {
		setAttrVal("Opstopschlist", Opstopschlist);
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