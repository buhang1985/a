package iih.bd.pp.pripat.s;

import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDOExtCudService;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDOExtRService;
import iih.bd.pp.pripat.s.bp.FindPagingDataByQCondAndPriPatBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 患者价格分类服务项目（特殊项目）扩展服务
 * 
 * @author hao_wu
 *
 */
public class PriPatSrvOrCaDOExtCrudServiceImpl implements IPriPatSrvOrCaDOExtCudService, IPriPatSrvOrCaDOExtRService {

	@Override
	public PagingRtnData<PriPatSrvOrCaDO> FindPagingDataByQCondAndPriPat(QryRootNodeDTO qryRootNodeDTO,
			PriPatDO priPatDO, PaginationInfo pg) throws BizException {
		FindPagingDataByQCondAndPriPatBp bp = new FindPagingDataByQCondAndPriPatBp();
		PagingRtnData<PriPatSrvOrCaDO> result = bp.exec(qryRootNodeDTO, priPatDO, pg);
		return result;
	}
}
