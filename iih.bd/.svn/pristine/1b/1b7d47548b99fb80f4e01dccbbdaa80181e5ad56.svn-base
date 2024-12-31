package iih.bd.fc.triagecmpt.s;

import iih.bd.fc.triageca.d.TriageCaDO;
import iih.bd.fc.triagecmpt.d.TriageCmptDO;
import iih.bd.fc.triagecmpt.i.ITriageCmptExtCudService;
import iih.bd.fc.triagecmpt.i.ITriageCmptExtRService;
import iih.bd.fc.triagecmpt.s.bp.FindPagingByQcondAndCaBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 检伤主诉扩展服务
 * 
 * @author hao_wu
 *
 */
public class TriageCmptExtCrudServiceImpl implements ITriageCmptExtCudService, ITriageCmptExtRService {

	@Override
	public PagingRtnData<TriageCmptDO> FindPagingByQcondAndCa(TriageCaDO triageCa, QryRootNodeDTO qryRootNodeDto,
			String orderPart, PaginationInfo pg) throws BizException {
		FindPagingByQcondAndCaBp bp = new FindPagingByQcondAndCaBp();
		PagingRtnData<TriageCmptDO> result = bp.exec(triageCa, qryRootNodeDto, orderPart, pg);
		return result;
	}

}
