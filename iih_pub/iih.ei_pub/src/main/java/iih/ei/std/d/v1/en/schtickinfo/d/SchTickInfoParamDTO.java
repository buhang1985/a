package iih.ei.std.d.v1.en.schtickinfo.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 排班对应的号位入参 DTO数据 
 * 
 */
public class SchTickInfoParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班Id
	 * @return String
	 */
	public FArrayList getIds_sch() {
		return ((FArrayList) getAttrVal("Ids_sch"));
	}	
	/**
	 * 排班Id
	 * @param Ids_sch
	 */
	public void setIds_sch(FArrayList Ids_sch) {
		setAttrVal("Ids_sch", Ids_sch);
	}
	/**
	 * 渠道类型
	 * @return String
	 */
	public String getType_chl() {
		return ((String) getAttrVal("Type_chl"));
	}	
	/**
	 * 渠道类型
	 * @param Type_chl
	 */
	public void setType_chl(String Type_chl) {
		setAttrVal("Type_chl", Type_chl);
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