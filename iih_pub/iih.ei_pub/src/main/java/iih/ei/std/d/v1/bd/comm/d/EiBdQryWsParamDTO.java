package iih.ei.std.d.v1.bd.comm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.bd.comm.d.QueryNodeDTO;

/**
 * 参数DTO DTO数据 
 * 
 */
public class EiBdQryWsParamDTO extends BaseDTO {
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
	 * 查询方案
	 * @return String
	 */
	public QueryNodeDTO getQuerynode() {
		return ((QueryNodeDTO) getAttrVal("Querynode"));
	}	
	/**
	 * 查询方案
	 * @param Querynode
	 */
	public void setQuerynode(QueryNodeDTO Querynode) {
		setAttrVal("Querynode", Querynode);
	}
}