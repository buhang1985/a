package iih.bd.pp.primd.s;

import iih.bd.pp.primd.d.PrimdDO;
import iih.bd.pp.primd.d.desc.PrimdDODesc;
import iih.bd.pp.primd.i.IPrimdCudService;
import iih.bd.pp.primd.i.IPrimdRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 定价模式AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPrimdCudService.class, IPrimdRService.class }, binding = Binding.JSONRPC)
public class PrimdCrudServiceImpl extends BaseDOService<PrimdDO> implements IPrimdCudService, IPrimdRService {

	public PrimdCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PrimdDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(PrimdDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
