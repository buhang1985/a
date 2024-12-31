package iih.bd.pp.prilistqry.s;

import iih.bd.pp.dto.d.PricelistqrySrvDTO;
import iih.bd.pp.prilistqry.i.IPriListQryService;
import iih.bd.pp.prilistqry.s.bp.FindPagingByQcondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 价表查询服务
 * 
 * @author hao_wu
 *
 */
public class PriListQryServiceImpl implements IPriListQryService {

	@Override
	public PagingRtnData<PricelistqrySrvDTO> FindPagingByQcond(QryRootNodeDTO qryRootNodeDTO, String orderPart,
			PaginationInfo pg) throws BizException {
		FindPagingByQcondBp bp = new FindPagingByQcondBp();
		PagingRtnData<PricelistqrySrvDTO> result = bp.exec(qryRootNodeDTO, orderPart, pg);
		return result;
	}
}
