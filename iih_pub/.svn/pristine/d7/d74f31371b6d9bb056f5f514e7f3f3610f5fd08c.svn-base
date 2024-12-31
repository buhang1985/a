package iih.ei.std.s.v1.bp;

import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.ei.itf.eiitfdo.d.EiItfDO;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * IIH标准接口处理基类
 * 
 * @author hao_wu 2019-9-17
 *
 * @param <T> 入参类型
 * @param <V> 出参类型
 */
public abstract class IIHServiceBaseBP<T extends BaseDO, V extends BaseDO> {

	/**
	 * 处理(不起新事务)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public final V exec(T paramData) throws BizException {
		V rtnData = null;
		if (this.isAffairsExec(paramData)) {
			return execTrans(paramData);
		}
		try {
			this.check(paramData);
			beforeProcess(paramData);
			rtnData = process(paramData);
			afterProcess(paramData);
		} catch (BizException e) {
			afterProcessWhenEx(paramData);
			throw e;
		}
		return rtnData;
	}

	/**
	 * 处理(起新事务)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public final V execTrans(T paramData) throws BizException {

		try {
			this.check(paramData);
		} catch (BizException e) {
			throw e;
		}

		V rtnData = null;
		final T tData = paramData;
		try {
			beforeProcess(tData);
			rtnData = TransactionExecutor.executeNewTransaction(new TransactionalOperation<V>() {
				@Override
				public V doInTransaction(TransactionStatus status) {
					try {
						V v = process(tData);
						return v;
					} catch (BizException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			});
			afterProcess(tData);
		} catch (Exception e) {
			afterProcessWhenEx(tData);
			if (e instanceof RuntimeException && e.getCause() instanceof BizException) {
				throw (BizException) e.getCause();
			} else {
				throw e;
			}
		}
		return rtnData;
	}

	/******* 抽象方法区域 *********/

	/**
	 * 入参校验(子类)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	protected abstract void checkParam(T param) throws BizException;

	/**
	 * 核心处理
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	protected abstract V process(T param) throws BizException;

	/******* 受保护方法区域 *********/

	/**
	 * 处理前处理
	 * 
	 * @param param
	 * @throws BizException
	 */
	protected void beforeProcess(T param) throws BizException {

	}

	/**
	 * 处理后处理
	 * 
	 * @param param
	 * @throws BizException
	 */
	protected void afterProcess(T param) throws BizException {

	}

	/**
	 * 处理异常时处理
	 * 
	 * @param param
	 * @throws BizException
	 */
	protected void afterProcessWhenEx(T param) throws BizException {

	}

	/******* 私有方法区域 *********/

	/***
	 * @Description:根据是否接口注册属性启用事务
	 * @param param
	 * @throws BizException
	 */
	private boolean isAffairsExec(T param) throws BizException {
		EiItfDO eiItfDO = (EiItfDO) Context.get().getAttribute("IIH_WEBSERVICE_PARAM_ITFDO");
		return eiItfDO != null && FBoolean.TRUE.equals(eiItfDO.getFg_affairs());
	}

	/**
	 * 入参校验
	 * 
	 * @param t
	 * @throws BizException
	 */
	private void check(T param) throws BizException {

		if (param == null) {
			throw new BizException("入参为空或者xml转换失败");
		}

		this.checkParam(param);
	}

	/**
	 * 查询分页数据
	 * 
	 * @param sql
	 * @param sqlParam
	 * @param dataClass
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected <DT extends BaseDO> List<DT> findDataList(String sql, SqlParam sqlParam, Class<DT> dataClass)
			throws BizException {
		DAFacade daFacade = new DAFacade();
		List<DT> dataList = (List<DT>) daFacade.execQuery(sql, sqlParam, new BeanListHandler(dataClass));
		return dataList;
	}

	protected <DT extends BaseDO> PagingRtnData<DT> findPagingData(PaginationInfo pageInfo, String sql,
			SqlParam sqlParam, Class<DT> dataClass) throws BizException {
		DT data = null;
		try {
			data = dataClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new BizException(e);
		}
		PagingServiceImpl<DT> pagingServiceImpl = new PagingServiceImpl<DT>();
		PagingRtnData<DT> pagingRtnData = pagingServiceImpl.findByPageInfo(data, pageInfo, sql, null, sqlParam);
		return pagingRtnData;
	}

	/**
	 * 查询分页数据</br>
	 * 调用后从入参pageInfoDto中获取分页信息
	 * 
	 * @param pageInfoDto
	 * @param sql
	 * @param orderStr
	 * @param sqlParam
	 * @param dataClass
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected <DT extends BaseDO> List<DT> findPagingData(PageInfoDTO pageInfoDto, String sql, SqlParam sqlParam,
			Class<DT> dataClass) throws BizException {

		if (pageInfoDto.getPageindex() == null) {
			throw new BizException("页号不允许为空");
		}

		if (pageInfoDto.getPagesize() == null) {
			throw new BizException("分页大小不允许为空");
		}

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setPageIndex(pageInfoDto.getPageindex() - 1);
		paginationInfo.setPageSize(pageInfoDto.getPagesize());

		PagingRtnData<DT> rtnData = findPagingData(paginationInfo, sql, sqlParam, dataClass);

		paginationInfo = rtnData.getPagingInfo();
		pageInfoDto.setPageindex(paginationInfo.getPageIndex() + 1);
		pageInfoDto.setPagecount(paginationInfo.getPageCount());
		pageInfoDto.setRecordscount(paginationInfo.getRecordsCount());

		FArrayList dataList = rtnData.getPageData();
		return dataList;
	}
}
