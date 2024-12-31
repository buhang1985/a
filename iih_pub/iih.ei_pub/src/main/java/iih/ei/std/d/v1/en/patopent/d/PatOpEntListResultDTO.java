package iih.ei.std.d.v1.en.patopent.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 患者挂号记录出参 DTO数据 
 * 
 */
public class PatOpEntListResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 挂号记录
	 * @return String
	 */
	public FArrayList getPatopent() {
		return ((FArrayList) getAttrVal("Patopent"));
	}	
	/**
	 * 挂号记录
	 * @param Patopent
	 */
	public void setPatopent(FArrayList Patopent) {
		setAttrVal("Patopent", Patopent);
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