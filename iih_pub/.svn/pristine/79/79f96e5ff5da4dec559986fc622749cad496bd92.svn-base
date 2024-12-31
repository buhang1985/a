package iih.bd.pp.srvctrdi.i;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保诊断限制扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface ISrvctrdiExtRService {
	/**
	 * 使用查询方案查询分页数据
	 * 
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<BdHpSrvCtrDiDO> FindPagingDataByQCond(QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException;

	/**
	 * 使用主键查询
	 * 
	 * @param id
	 *            主键
	 * @return
	 * @throws BizException
	 */
	public abstract BdHpSrvCtrDiDO FindById(String id) throws BizException;

	/**
	 * 使用医保计划和查询方案查询分页数据
	 * 
	 * @param hpdo
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<BdHpSrvCtrDiDO> FindPagingDataByHpAndQCond(HPDO hpdo, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException;
}
