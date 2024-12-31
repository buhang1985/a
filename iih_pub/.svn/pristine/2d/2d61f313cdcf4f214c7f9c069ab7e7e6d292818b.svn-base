package iih.bd.pp.hpdiexpenseselfbatch.i;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保计划自费诊断批量查询服务
 * 
 * @author hao_wu
 *
 */
public interface IHpdiexpenseselfbatchRService {

	/**
	 * 使用查询方案查询分页数据
	 * 
	 * @param qryRootNodeDTO
	 * @param hpdo
	 *            医保计划
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<BdHpDiExpenseSelfDO> FindPagingDataByQCond(QryRootNodeDTO qryRootNodeDTO, HPDO hpdo,
			String orderStr, PaginationInfo pg) throws BizException;
}
