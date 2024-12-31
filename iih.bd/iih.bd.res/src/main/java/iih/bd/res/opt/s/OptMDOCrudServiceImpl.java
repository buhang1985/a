package iih.bd.res.opt.s;

import iih.bd.res.opt.d.OptDO;
import iih.bd.res.opt.d.desc.OptDODesc;
import iih.bd.res.opt.i.IOptMDOCudService;
import iih.bd.res.opt.i.IOptMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 手术台主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IOptMDOCudService.class, IOptMDORService.class }, binding = Binding.JSONRPC)
public class OptMDOCrudServiceImpl extends BaseDOService<OptDO> implements IOptMDOCudService, IOptMDORService {

	public OptMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(OptDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(OptDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
