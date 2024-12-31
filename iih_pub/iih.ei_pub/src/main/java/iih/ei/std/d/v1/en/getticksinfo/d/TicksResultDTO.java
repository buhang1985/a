package iih.ei.std.d.v1.en.getticksinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 获取号段信息出参DTO DTO数据 
 * 
 */
public class TicksResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 号段信息
	 * @return String
	 */
	public FArrayList getTicksinfo() {
		return ((FArrayList) getAttrVal("Ticksinfo"));
	}	
	/**
	 * 号段信息
	 * @param Ticksinfo
	 */
	public void setTicksinfo(FArrayList Ticksinfo) {
		setAttrVal("Ticksinfo", Ticksinfo);
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