package iih.ei.std.d.v1.mp.basedata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本类型数据出参 DTO数据 
 * 
 */
public class SamptpInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本类型
	 * @return String
	 */
	public FArrayList getSamptpinfo() {
		return ((FArrayList) getAttrVal("Samptpinfo"));
	}	
	/**
	 * 标本类型
	 * @param Samptpinfo
	 */
	public void setSamptpinfo(FArrayList Samptpinfo) {
		setAttrVal("Samptpinfo", Samptpinfo);
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