package iih.ei.std.bd.v1.s.bp;

import iih.ei.std.bd.v1.model.BdQryRtnData;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;

/**
 * 根据接口编码查询分页视图数据
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class FindPagingViewDataByItfCodeBp {

	public BdQryRtnData exec(PaginationInfo pgInfo, String itfCode) throws BizException {
		String viewName = findViewNameByCode(itfCode);
		FindPagingViewDataByViewNameBp bp = new FindPagingViewDataByViewNameBp();
		BdQryRtnData rtnData = bp.exec(pgInfo, viewName);
		return rtnData;
	}

	/**
	 * 根据接口编码获取视图名称
	 * 
	 * @param itfCode 接口编码
	 * @return
	 * @throws BizException
	 */
	private String findViewNameByCode(String itfCode) throws BizException {
		FindViewNameByItfCodeBp bp = new FindViewNameByItfCodeBp();
		String viewName = bp.exec(itfCode);
		return viewName;
	}
}
