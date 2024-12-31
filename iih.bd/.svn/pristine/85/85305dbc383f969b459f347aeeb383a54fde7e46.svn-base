package iih.bd.pp.hpdiexpenseself.s;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseself.i.IHpdiexpenseselfExtRService;
import iih.bd.pp.hpdiexpenseself.s.bp.FindByIdBp;
import iih.bd.pp.hpdiexpenseself.s.bp.FindDiExpenseSelfDataBp;
import iih.bd.pp.hpdiexpenseself.s.bp.FindPagingDataBp;
import iih.bd.pp.hpdiexpenseself.s.bp.FindPagingDataByQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保计划自费诊断扩展服务
 * 
 * @author hao_wu
 *
 */
public class HpdiexpenseselfExtCrudServiceImpl implements IHpdiexpenseselfExtRService {

	@Override
	public PagingRtnData<BdHpDiExpenseSelfDO> FindPagingData(HPDO hpdo, String orderStr, PaginationInfo pg)
			throws BizException {
		FindPagingDataBp bp = new FindPagingDataBp();
		PagingRtnData<BdHpDiExpenseSelfDO> result = bp.exec(hpdo, orderStr, pg);
		return result;
	}

	@Override
	public BdHpDiExpenseSelfDO FindById(String id) throws BizException {
		FindByIdBp bp = new FindByIdBp();
		BdHpDiExpenseSelfDO result = bp.exec(id);
		return result;
	}

	@Override
	public BdHpDiExpenseSelfDO[] FindDiExpenseSelfData(HPDO hpdo, String orderStr) throws BizException {
		FindDiExpenseSelfDataBp bp = new FindDiExpenseSelfDataBp();
		BdHpDiExpenseSelfDO[] result = bp.exec(hpdo, orderStr);
		return result;
	}

	@Override
	public PagingRtnData<BdHpDiExpenseSelfDO> findByQCondAndPageInfo(HPDO hpdo, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingDataByQCondBp bp = new FindPagingDataByQCondBp();
		return bp.exec(hpdo, qryRootNodeDTO, orderStr, pg);
	}

}
