package iih.ei.std.d.v1.en.opaptlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 获取预约记录出参 DTO数据 
 * 
 */
public class OpAptListResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊预约记录
	 * @return String
	 */
	public FArrayList getOpaptinfo() {
		return ((FArrayList) getAttrVal("Opaptinfo"));
	}	
	/**
	 * 门诊预约记录
	 * @param Opaptinfo
	 */
	public void setOpaptinfo(FArrayList Opaptinfo) {
		setAttrVal("Opaptinfo", Opaptinfo);
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