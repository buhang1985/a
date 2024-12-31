package iih.ei.std.d.v1.bd.sugdoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 手术项目档案列表DTO DTO数据 
 * 
 */
public class SugDocListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 手术项目档案
	 * @return String
	 */
	public FArrayList getSugdoc() {
		return ((FArrayList) getAttrVal("Sugdoc"));
	}	
	/**
	 * 手术项目档案
	 * @param Sugdoc
	 */
	public void setSugdoc(FArrayList Sugdoc) {
		setAttrVal("Sugdoc", Sugdoc);
	}
}