package iih.bd.srv.medusage.s;

import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.i.IMedusageExtCudService;
import iih.bd.srv.medusage.i.IMedusageExtRService;
import iih.bd.srv.medusage.s.bp.FindPagingByQcondAndSrvTpBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 用法扩展服务
 * 
 * @author hao_wu
 *
 */
public class MedusageExtCrudServiceImpl implements IMedusageExtRService, IMedusageExtCudService {

	@Override
	public PagingRtnData<MedUsageDO> FindPagingByQcondAndSrvTp(UdidocDO srvTp, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException {
		FindPagingByQcondAndSrvTpBp bp = new FindPagingByQcondAndSrvTpBp();
		PagingRtnData<MedUsageDO> result = bp.exec(srvTp, qryRootNodeDto, pg);
		return result;
	}

}
