package iih.bd.pp.hpdiexpenseselfbatch.s;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseselfbatch.i.IHpdiexpenseselfbatchCudService;
import iih.bd.pp.hpdiexpenseselfbatch.i.IHpdiexpenseselfbatchRService;
import iih.bd.pp.hpdiexpenseselfbatch.s.bp.FindPagingDataByQCondBp;
import iih.bd.pp.hpdiexpenseselfbatch.s.bp.SaveHpDiExpenseSelfBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保计划自费诊断批量CRUD服务
 * 
 * @author hao_wu
 *
 */
public class HpdiexpenseselfbatchCrudServiceImpl
		implements IHpdiexpenseselfbatchRService, IHpdiexpenseselfbatchCudService {

	@Override
	public BdHpDiExpenseSelfDO[] SaveHpDiExpenseSelf(BdHpDiExpenseSelfDO[] bdHpDiExpenseSelfDOs, HPDO hpdo)
			throws BizException {
		SaveHpDiExpenseSelfBp bp = new SaveHpDiExpenseSelfBp();
		BdHpDiExpenseSelfDO[] result = bp.exec(bdHpDiExpenseSelfDOs, hpdo);
		return result;
	}

	@Override
	public PagingRtnData<BdHpDiExpenseSelfDO> FindPagingDataByQCond(QryRootNodeDTO qryRootNodeDTO, HPDO hpdo,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingDataByQCondBp bp = new FindPagingDataByQCondBp();
		PagingRtnData<BdHpDiExpenseSelfDO> result = bp.exec(qryRootNodeDTO, hpdo, orderStr, pg);
		return result;
	}
}
