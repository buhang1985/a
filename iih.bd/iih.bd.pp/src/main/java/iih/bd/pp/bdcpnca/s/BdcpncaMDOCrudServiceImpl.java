package iih.bd.pp.bdcpnca.s;

import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdcpnca.d.desc.BdCpncaDODesc;
import iih.bd.pp.bdcpnca.i.IBdcpncaMDOCudService;
import iih.bd.pp.bdcpnca.i.IBdcpncaMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 优惠劵_基础数据主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBdcpncaMDOCudService.class, IBdcpncaMDORService.class }, binding = Binding.JSONRPC)
public class BdcpncaMDOCrudServiceImpl extends BaseDOService<BdCpncaDO>
		implements IBdcpncaMDOCudService, IBdcpncaMDORService {

	public BdcpncaMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdCpncaDODesc.class), IAppFwTempTbl.tmp_iaw_24.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(BdCpncaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
