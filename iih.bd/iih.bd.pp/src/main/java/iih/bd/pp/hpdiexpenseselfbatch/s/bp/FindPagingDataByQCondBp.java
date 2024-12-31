package iih.bd.pp.hpdiexpenseselfbatch.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseselfbatch.s.bp.sql.FindBdHpDiExpenseSelfSql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案查询医保计划自费诊断分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingDataByQCondBp {

	public PagingRtnData<BdHpDiExpenseSelfDO> exec(QryRootNodeDTO qryRootNodeDTO, HPDO hpdo, String orderStr,
			PaginationInfo pg) throws BizException {
		PagingRtnData<BdHpDiExpenseSelfDO> result = FindPagingData(qryRootNodeDTO, hpdo, orderStr, pg);
		return result;
	}

	/**
	 * 根据查询方案查询自费诊断分页信息
	 * 
	 * @param hpdo
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpDiExpenseSelfDO> FindPagingData(QryRootNodeDTO qryRootNodeDTO, HPDO hpdo, String orderStr,
			PaginationInfo pg) throws BizException {
		String wherePart = GetWherePartByQCond(qryRootNodeDTO);
		FindBdHpDiExpenseSelfSql sql = new FindBdHpDiExpenseSelfSql(hpdo.getId_hp(), wherePart);
		PagingServiceImpl<BdHpDiExpenseSelfDO> pagingServiceImpl = new PagingServiceImpl<BdHpDiExpenseSelfDO>();
		PagingRtnData<BdHpDiExpenseSelfDO> result = pagingServiceImpl.findByPageInfo(new BdHpDiExpenseSelfDO(), pg,
				sql.getQrySQLStr(), orderStr, sql.getQryParameter(null));
		return result;
	}

	/**
	 * 使用查询方案生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePartByQCond(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		if (qryRootNodeDTO != null) {
			IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
			String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDTO);
			return wherePart;
		}
		return null;
	}
}
