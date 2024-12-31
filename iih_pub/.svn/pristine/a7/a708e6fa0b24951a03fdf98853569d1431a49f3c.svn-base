package iih.bd.pp.hpdiexpenseself.i;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
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
public interface IHpdiexpenseselfExtRService {

	/**
	 * 根据医保计划查询自费诊断分页信息
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<BdHpDiExpenseSelfDO> FindPagingData(HPDO hpdo, String orderStr, PaginationInfo pg)
			throws BizException;

	/**
	 * 根据主键值查找医保计划自费诊断数据
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public abstract BdHpDiExpenseSelfDO FindById(String id) throws BizException;

	/**
	 * 根据医保计划查询自费诊断信息
	 * 
	 * @param hpdo
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public abstract BdHpDiExpenseSelfDO[] FindDiExpenseSelfData(HPDO hpdo, String orderStr) throws BizException;

	/**
	 * 根据查询模板查询自费诊断信息
	 * 
	 * @param hpdo
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BdHpDiExpenseSelfDO> findByQCondAndPageInfo(HPDO hpdo, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException;
}
