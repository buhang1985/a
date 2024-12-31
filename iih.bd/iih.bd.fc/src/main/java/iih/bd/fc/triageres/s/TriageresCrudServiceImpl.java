package iih.bd.fc.triageres.s;

import iih.bd.fc.triageres.d.TriageResDO;
import iih.bd.fc.triageres.d.desc.TriageResDODesc;
import iih.bd.fc.triageres.i.ITriageresCudService;
import iih.bd.fc.triageres.i.ITriageresRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 检伤判定AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ITriageresCudService.class, ITriageresRService.class }, binding = Binding.JSONRPC)
public class TriageresCrudServiceImpl extends BaseDOService<TriageResDO>
		implements ITriageresCudService, ITriageresRService {
	public TriageresCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(TriageResDODesc.class), IAppFwTempTbl.tmp_iaw_18.name());
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
	protected Validator[] getUpdateValidator(TriageResDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
