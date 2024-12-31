package iih.bd.pp.baseprisrv.s;

import iih.bd.pp.baseprisrv.d.BaseprisrvAggDO;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.desc.PriSrvDODesc;
import iih.bd.pp.baseprisrv.i.IBaseprisrvCudService;
import iih.bd.pp.baseprisrv.i.IBaseprisrvRService;
import iih.bd.pp.baseprisrv.s.bp.DeletePriSrvBp;
import iih.bd.pp.baseprisrv.s.bp.FindBasePriSrvAggByIdBp;
import iih.bd.pp.baseprisrv.s.bp.SaveBasePriSrvAggBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 价格服务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IBaseprisrvCudService.class, IBaseprisrvRService.class }, binding = Binding.JSONRPC)
public class BaseprisrvCrudServiceImpl extends BaseAggService<BaseprisrvAggDO, PriSrvDO>
		implements IBaseprisrvCudService, IBaseprisrvRService {
	public BaseprisrvCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PriSrvDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
	}

	@Override
	public BaseprisrvAggDO findById(String id) throws BizException {
		FindBasePriSrvAggByIdBp bp = new FindBasePriSrvAggByIdBp();
		BaseprisrvAggDO srvAggDo = bp.exec(id);
		return srvAggDo;
	}

	@Override
	public BaseprisrvAggDO[] save(BaseprisrvAggDO[] aggs) throws BizException {
		SaveBasePriSrvAggBp bp = new SaveBasePriSrvAggBp();
		BaseprisrvAggDO[] result = bp.exec(aggs);
		return result;
	}

	@Override
	public BaseprisrvAggDO[] update(BaseprisrvAggDO[] aggs) throws BizException {
		SaveBasePriSrvAggBp bp = new SaveBasePriSrvAggBp();
		BaseprisrvAggDO[] result = bp.exec(aggs);
		return result;
	}

	@Override
	public BaseprisrvAggDO[] insert(BaseprisrvAggDO[] aggs) throws BizException {
		SaveBasePriSrvAggBp bp = new SaveBasePriSrvAggBp();
		BaseprisrvAggDO[] result = bp.exec(aggs);
		return result;
	}

	@Override
	public void deleteByParentDO(PriSrvDO[] dos) throws BizException {
		DeletePriSrvBp bp = new DeletePriSrvBp();
		bp.exec(dos);
	}
}
