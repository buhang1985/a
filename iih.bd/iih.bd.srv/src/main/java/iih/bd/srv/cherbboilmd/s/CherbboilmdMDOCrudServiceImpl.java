package iih.bd.srv.cherbboilmd.s;

import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.d.desc.CHerbBoilMdDODesc;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDOCudService;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务中药煎法主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ICherbboilmdMDOCudService.class,
		ICherbboilmdMDORService.class }, binding = Binding.JSONRPC)
public class CherbboilmdMDOCrudServiceImpl extends BaseDOService<CHerbBoilMdDO>
		implements ICherbboilmdMDOCudService, ICherbboilmdMDORService {

	public CherbboilmdMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CHerbBoilMdDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(CHerbBoilMdDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
