package iih.bd.pp.baseprisrv.s;

import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.i.IBasePriSrvExtCudService;
import iih.bd.pp.baseprisrv.i.IBasePriSrvExtRService;
import iih.bd.pp.baseprisrv.s.bp.DisableBasePriSrvBp;
import iih.bd.pp.baseprisrv.s.bp.EnableBasePriSrvBp;
import iih.bd.pp.baseprisrv.s.bp.FindPagingByCaAndQryNodeBp;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 基础价表服务扩展服务
 * 
 * @author hao_wu 2019-8-16
 *
 */
public class BasePriSrvExtCrudServiceImpl implements IBasePriSrvExtCudService, IBasePriSrvExtRService {

	@Override
	public PagingRtnData<PriSrvDO> findPagingByCaAndQryNode(SrvCateDO srvCateDo, QryRootNodeDTO qryRootNodeDto,
			String whereStr, String orderStr, PaginationInfo pg) throws BizException {
		FindPagingByCaAndQryNodeBp bp = new FindPagingByCaAndQryNodeBp();
		PagingRtnData<PriSrvDO> result = bp.exec(srvCateDo, qryRootNodeDto, whereStr, orderStr, pg);
		return result;
	}

	@Override
	public PriSrvDO[] enable(PriSrvDO[] priSrvDos) throws BizException {
		EnableBasePriSrvBp bp = new EnableBasePriSrvBp();
		PriSrvDO[] result = bp.exec(priSrvDos);
		return result;
	}

	@Override
	public PriSrvDO[] disable(PriSrvDO[] priSrvDos) throws BizException {
		DisableBasePriSrvBp bp = new DisableBasePriSrvBp();
		PriSrvDO[] result = bp.exec(priSrvDos);
		return result;
	}
}
