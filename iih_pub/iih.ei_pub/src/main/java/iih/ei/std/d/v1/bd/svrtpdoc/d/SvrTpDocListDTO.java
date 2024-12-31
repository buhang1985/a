package iih.ei.std.d.v1.bd.svrtpdoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 号类(挂号类型)档案列表 DTO数据 
 * 
 */
public class SvrTpDocListDTO extends BaseDTO {
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
	 * 挂号类型
	 * @return String
	 */
	public FArrayList getSvrtpdoc() {
		return ((FArrayList) getAttrVal("Svrtpdoc"));
	}	
	/**
	 * 挂号类型
	 * @param Svrtpdoc
	 */
	public void setSvrtpdoc(FArrayList Svrtpdoc) {
		setAttrVal("Svrtpdoc", Svrtpdoc);
	}
}