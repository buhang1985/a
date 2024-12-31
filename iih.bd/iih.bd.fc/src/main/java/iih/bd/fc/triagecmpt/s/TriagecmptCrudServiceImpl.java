package iih.bd.fc.triagecmpt.s;

import iih.bd.fc.triagecmpt.d.TriageCmptDO;
import iih.bd.fc.triagecmpt.d.desc.TriageCmptDODesc;
import iih.bd.fc.triagecmpt.i.ITriagecmptCudService;
import iih.bd.fc.triagecmpt.i.ITriagecmptRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 检伤主诉AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ITriagecmptCudService.class, ITriagecmptRService.class }, binding = Binding.JSONRPC)
public class TriagecmptCrudServiceImpl extends BaseDOService<TriageCmptDO>
		implements ITriagecmptCudService, ITriagecmptRService {
	public TriagecmptCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(TriageCmptDODesc.class), IAppFwTempTbl.tmp_iaw_10.name());
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
	protected Validator[] getUpdateValidator(TriageCmptDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
