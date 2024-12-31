package iih.ei.std.d.v1.en.schtickinfo.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 排班对应的号位出参 DTO数据 
 * 
 */
public class SchTickInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排版对应的号位
	 * @return String
	 */
	public FArrayList getSchtickinfo() {
		return ((FArrayList) getAttrVal("Schtickinfo"));
	}	
	/**
	 * 排版对应的号位
	 * @param Schtickinfo
	 */
	public void setSchtickinfo(FArrayList Schtickinfo) {
		setAttrVal("Schtickinfo", Schtickinfo);
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