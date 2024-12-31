package iih.bd.pp.pripat.i;

import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 患者价格分类服务项目（特殊项目）扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IPriPatSrvOrCaDOExtRService {
	/**
	 * 使用查询方案和患者价格分类查询患者价格分类服务项目分页信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PriPatSrvOrCaDO> FindPagingDataByQCondAndPriPat(QryRootNodeDTO qryRootNodeDTO,
			PriPatDO priPatDO, PaginationInfo pg) throws BizException;
}
