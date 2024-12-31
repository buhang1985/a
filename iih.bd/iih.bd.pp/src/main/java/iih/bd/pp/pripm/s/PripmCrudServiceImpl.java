package iih.bd.pp.pripm.s;

import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.d.desc.PriPmDODesc;
import iih.bd.pp.pripm.i.IPripmCudService;
import iih.bd.pp.pripm.i.IPripmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 付款方式AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPripmCudService.class, IPripmRService.class }, binding = Binding.JSONRPC)
public class PripmCrudServiceImpl extends BaseDOService<PriPmDO> implements IPripmCudService, IPripmRService {
	public PripmCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PriPmDODesc.class), IAppFwTempTbl.tmp_iaw_24.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(PriPmDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
