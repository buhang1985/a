package iih.ei.std.d.v1.bd.psndoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 人员档案列表DTO DTO数据 
 * 
 */
public class PsnDocListDTO extends BaseDTO {
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
	 * 人员档案
	 * @return String
	 */
	public FArrayList getPsndoc() {
		return ((FArrayList) getAttrVal("Psndoc"));
	}	
	/**
	 * 人员档案
	 * @param Psndoc
	 */
	public void setPsndoc(FArrayList Psndoc) {
		setAttrVal("Psndoc", Psndoc);
	}
}