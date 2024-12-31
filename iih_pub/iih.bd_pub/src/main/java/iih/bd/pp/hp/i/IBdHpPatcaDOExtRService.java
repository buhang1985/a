package iih.bd.pp.hp.i;

import iih.bd.pp.hp.d.BdHpPatcaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保患者身份扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IBdHpPatcaDOExtRService {

	/**
	 * 根据医保计划主键和查询方案查询医保患者身份分页数据
	 * 
	 * @param hpId
	 *            医保计划主键
	 * @param qryRootNodeDTO
	 *            查询方案
	 * @param orderStr
	 *            排序语句
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<BdHpPatcaDO> findPagingByHpAndQCond(String hpId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException;
}
