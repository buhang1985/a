package iih.bd.pp.baseprisrv.s;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.baseprisrv.d.SrvPriDO;
import iih.bd.pp.baseprisrv.d.desc.SrvPriDODesc;
import iih.bd.pp.baseprisrv.i.ISrvPriDOCudService;
import iih.bd.pp.baseprisrv.i.ISrvPriDORService;
import iih.bd.pp.baseprisrv.s.bp.FindBaseSrvPriBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 价格服务主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvPriDOCudService.class, ISrvPriDORService.class }, binding = Binding.JSONRPC)
public class SrvPriDOCrudServiceImpl extends BaseDOService<SrvPriDO> implements ISrvPriDOCudService, ISrvPriDORService {

	public SrvPriDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvPriDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	public SrvPriDO[] findByAttrValStrings(String attr, String[] values) throws BizException {
		String wherePart = SqlUtils.getInSqlByIds(attr, values);
		FindBaseSrvPriBp bp = new FindBaseSrvPriBp();
		SrvPriDO[] srvPris = bp.exec(wherePart, null);
		return srvPris;
	}

	@Override
	public SrvPriDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		FindBaseSrvPriBp bp = new FindBaseSrvPriBp();
		SrvPriDO[] srvPris = bp.exec(whereStr, orderStr);
		return srvPris;
	}
}
