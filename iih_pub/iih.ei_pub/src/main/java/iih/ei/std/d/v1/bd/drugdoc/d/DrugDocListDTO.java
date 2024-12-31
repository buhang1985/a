package iih.ei.std.d.v1.bd.drugdoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 药品档案列表DTO DTO数据 
 * 
 */
public class DrugDocListDTO extends BaseDTO {
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
	 * 药品档案
	 * @return String
	 */
	public FArrayList getDrugdoc() {
		return ((FArrayList) getAttrVal("Drugdoc"));
	}	
	/**
	 * 药品档案
	 * @param Drugdoc
	 */
	public void setDrugdoc(FArrayList Drugdoc) {
		setAttrVal("Drugdoc", Drugdoc);
	}
}