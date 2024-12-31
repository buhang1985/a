package iih.bd.pp.hpdiexpenseself.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseself.s.bp.sql.FindBdHpDiExpenseSelfSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 根据医保计划查询自费诊断分页信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingDataBp {

	public PagingRtnData<BdHpDiExpenseSelfDO> exec(HPDO hpdo, String orderStr, PaginationInfo pg) throws BizException {
		if (hpdo == null) {
			throw new BizException("医保计划不允许为空。");
		}
		PagingRtnData<BdHpDiExpenseSelfDO> result = FindPagingData(hpdo, orderStr, pg);
		SetupCalculateFieldsValue(result);
		return result;
	}

	/**
	 * 设置计算字段值
	 * 
	 * @param result
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void SetupCalculateFieldsValue(PagingRtnData<BdHpDiExpenseSelfDO> result) throws BizException {
		FArrayList dataList = result.getPageData();
		if (dataList == null || dataList.size() <= 0) {
			return;
		}
		SetupDiExpenseSelfCalculateFieldsBp bp = new SetupDiExpenseSelfCalculateFieldsBp();
		bp.exec((BdHpDiExpenseSelfDO[]) dataList.toArray(new BdHpDiExpenseSelfDO[0]));
	}

	/**
	 * 据医保计划查询自费诊断分页信息
	 * 
	 * @param hpdo
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpDiExpenseSelfDO> FindPagingData(HPDO hpdo, String orderStr, PaginationInfo pg)
			throws BizException {
		FindBdHpDiExpenseSelfSql sql = new FindBdHpDiExpenseSelfSql(hpdo);
		PagingServiceImpl<BdHpDiExpenseSelfDO> pagingServiceImpl = new PagingServiceImpl<BdHpDiExpenseSelfDO>();
		PagingRtnData<BdHpDiExpenseSelfDO> result = pagingServiceImpl.findByPageInfo(new BdHpDiExpenseSelfDO(), pg,
				sql.getQrySQLStr(), orderStr, sql.getQryParameter(null));
		return result;
	}
}
