package iih.ei.std.d.v1.en.getticksinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 获取号段信息入参DTO DTO数据 
 * 
 */
public class TicksParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班Ids
	 * @return String
	 */
	public String getId_schs() {
		return ((String) getAttrVal("Id_schs"));
	}	
	/**
	 * 排班Ids
	 * @param Id_schs
	 */
	public void setId_schs(String Id_schs) {
		setAttrVal("Id_schs", Id_schs);
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
	/**
	 * 是否用尽
	 * @return FBoolean
	 */
	public FBoolean getFg_used() {
		return ((FBoolean) getAttrVal("Fg_used"));
	}	
	/**
	 * 是否用尽
	 * @param Fg_used
	 */
	public void setFg_used(FBoolean Fg_used) {
		setAttrVal("Fg_used", Fg_used);
	}
}