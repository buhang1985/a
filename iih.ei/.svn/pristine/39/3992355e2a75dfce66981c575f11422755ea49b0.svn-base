package iih.ei.std.bd.v1.s.bp;

import java.util.List;
import java.util.Map;

import iih.ei.std.bd.v1.model.BdQryRtnData;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 查询分页视图数据业务逻辑
 * 
 * @author hao_wu 2019-2-26
 *
 */
public class FindPagingViewDataByViewNameBp {

	/**
	 * 
	 * @param pgInfo   分页信息
	 * @param viewName 视图名称
	 * @return
	 * @throws BizException
	 */
	public BdQryRtnData exec(PaginationInfo pgInfo, String viewName) throws BizException {

		// 1.查询记录条数
		Integer recCount = findRecCount(viewName);

		// 2.查询分页视图信息
		List<Map<String, Object>> viewData = findPagingViewData(pgInfo, viewName);

		// 3.获取返回的分页信息
		PaginationInfo rtnPageInfo = getRtnPgInfo(pgInfo, recCount);
		// 4.组装分页返回数据
		BdQryRtnData bdPagingRtnData = new BdQryRtnData();
		bdPagingRtnData.setPgInfo(rtnPageInfo);
		bdPagingRtnData.setPageData(viewData);

		return bdPagingRtnData;
	}

	/**
	 * 查询分页视图数据
	 * 
	 * @param pgInfo   分页信息
	 * @param viewName 视图名称
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> findPagingViewData(PaginationInfo pgInfo, String viewName) throws BizException {
		String pagingDataSql = getPagingDataSql(pgInfo, viewName);

		DAFacade daFacade = new DAFacade();
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) daFacade.execQuery(pagingDataSql,
				new MapListHandler());
		return dataList;
	}

	/**
	 * 获取分页数据SQL
	 * 
	 * @param pgInfo
	 * @param viewName
	 * @return
	 */
	private String getPagingDataSql(PaginationInfo pgInfo, String viewName) {
		String sql = getBaseSql(viewName);
		Integer lRowNum = pgInfo.getPageSize() * (pgInfo.getPageIndex() - 1);
		Integer rRowNum = pgInfo.getPageSize() * (pgInfo.getPageIndex());
		String pagingDataSql = String.format(
				"SELECT * FROM (SELECT row_.*, rownum rownum_ FROM (%s) row_ WHERE rownum <= %s) WHERE rownum_ > %s",
				sql, rRowNum, lRowNum);
		return pagingDataSql;
	}

	/**
	 * 获取返回的分页信息
	 * 
	 * @param pgInfo   传入的分页信息
	 * @param recCount 记录条数
	 * @return
	 */
	private PaginationInfo getRtnPgInfo(PaginationInfo pgInfo, Integer recCount) {
		PaginationInfo rtnPageInfo = new PaginationInfo();

		Integer pageSize = pgInfo.getPageSize();
		Integer pageCount = (recCount / pgInfo.getPageSize()) + (recCount % pgInfo.getPageSize()) > 0 ? 1 : 0;

		rtnPageInfo.setPageCount(pageCount);
		rtnPageInfo.setPageIndex(pgInfo.getPageIndex());
		rtnPageInfo.setPageSize(pageSize);
		rtnPageInfo.setRecordsCount(recCount);
		return rtnPageInfo;
	}

	/**
	 * 查询记录个数
	 * 
	 * @param viewName
	 * @return
	 * @throws BizException
	 */
	private Integer findRecCount(String viewName) throws BizException {

		String recCountSql = getRecCountSql(viewName);

		DAFacade daFacade = new DAFacade();
		Integer recCount = (Integer) daFacade.execQuery(recCountSql, new ColumnHandler());
		return recCount;
	}

	/**
	 * 获取记录条数SQLL
	 * 
	 * @param viewName 视图名称
	 * @return
	 */
	private String getRecCountSql(String viewName) {
		String sql = getBaseSql(viewName);
		String recCountSql = String.format("select count(1) from (%s)", sql);
		return recCountSql;
	}

	/**
	 * 获取基础数据
	 * 
	 * @param viewName
	 * @return
	 */
	private String getBaseSql(String viewName) {
		String envWherePart = String.format("id_org in ('GLOBLE00000000000000','%s','%s')", Context.get().getGroupId(),
				Context.get().getOrgId());
		String sql = String.format("select * from %s where %s", viewName, envWherePart);
		return sql;
	}
}
