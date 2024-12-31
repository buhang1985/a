package iih.ei.std.d.v1.bd.picatedoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 患者分类档案列表DTO DTO数据 
 * 
 */
public class PiCateDocListDTO extends BaseDTO {
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
	 * 患者分类档案
	 * @return String
	 */
	public FArrayList getPicatedoc() {
		return ((FArrayList) getAttrVal("Picatedoc"));
	}	
	/**
	 * 患者分类档案
	 * @param Picatedoc
	 */
	public void setPicatedoc(FArrayList Picatedoc) {
		setAttrVal("Picatedoc", Picatedoc);
	}
}