package iih.bd.fc.triageca.s;

import iih.bd.fc.triageca.d.TriageCaDO;
import iih.bd.fc.triageca.d.desc.TriageCaDODesc;
import iih.bd.fc.triageca.i.ITriagecaCudService;
import iih.bd.fc.triageca.i.ITriagecaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 检伤分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ITriagecaCudService.class, ITriagecaRService.class }, binding = Binding.JSONRPC)
public class TriagecaCrudServiceImpl extends BaseDOService<TriageCaDO>
		implements ITriagecaCudService, ITriagecaRService {
	public TriagecaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(TriageCaDODesc.class), IAppFwTempTbl.tmp_iaw_28.name());
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
	protected Validator[] getUpdateValidator(TriageCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
