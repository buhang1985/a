package iih.bd.res.opt.s;

import iih.bd.res.opt.d.OptAggDO;
import iih.bd.res.opt.d.OptDO;
import iih.bd.res.opt.d.desc.OptDODesc;
import iih.bd.res.opt.i.IOptCudService;
import iih.bd.res.opt.i.IOptRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 手术台AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IOptCudService.class, IOptRService.class }, binding = Binding.JSONRPC)
public class OptCrudServiceImpl extends BaseAggService<OptAggDO, OptDO> implements IOptCudService, IOptRService {
	public OptCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(OptDODesc.class), IAppFwTempTbl.tmp_iaw_20.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance()};
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(OptAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
