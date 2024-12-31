package iih.bd.pp.baseprisrv.s;

import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.desc.PriSrvDODesc;
import iih.bd.pp.baseprisrv.i.IBaseprisrvMDOCudService;
import iih.bd.pp.baseprisrv.i.IBaseprisrvMDORService;
import iih.bd.pp.baseprisrv.s.bp.DeletePriSrvBp;
import iih.bd.pp.baseprisrv.s.bp.FindPagingPriSrvByQryNodeBp;
import iih.bd.pp.baseprisrv.s.bp.FindPriSrvBySqlParamBp;
import iih.bd.pp.baseprisrv.s.bp.SavePriSrvBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 价格服务主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBaseprisrvMDOCudService.class,
		IBaseprisrvMDORService.class }, binding = Binding.JSONRPC)
public class BaseprisrvMDOCrudServiceImpl extends BaseDOService<PriSrvDO>
		implements IBaseprisrvMDOCudService, IBaseprisrvMDORService {

	public BaseprisrvMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PriSrvDODesc.class), IAppFwTempTbl.tmp_iaw_06.name());
	}

	@Override
	public PagingRtnData<PriSrvDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		FindPagingPriSrvByQryNodeBp bp = new FindPagingPriSrvByQryNodeBp();
		PagingRtnData<PriSrvDO> result = bp.exec(pg, null, whereStr, orderStr);
		return result;
	}

	@Override
	public void delete(PriSrvDO... dos) throws BizException {
		DeletePriSrvBp bp = new DeletePriSrvBp();
		bp.exec(dos);
	}

	@Override
	public PriSrvDO[] find2(String whereStr, SqlParamDTO sqlParamDTO, String orderStr, FBoolean isLazy)
			throws BizException {
		FindPriSrvBySqlParamBp bp = new FindPriSrvBySqlParamBp();
		PriSrvDO[] result = bp.exec(whereStr, sqlParamDTO, orderStr);
		return result;
	}

	@Override
	public PriSrvDO[] update(PriSrvDO... dos) throws BizException {
		SavePriSrvBp bp = new SavePriSrvBp();
		PriSrvDO[] result = bp.exec(dos);
		return result;
	}
}
