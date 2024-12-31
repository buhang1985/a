package iih.bd.pp.hpdiexpenseself.s;

import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseself.d.desc.BdHpDiExpenseSelfDODesc;
import iih.bd.pp.hpdiexpenseself.i.IHpdiexpenseselfCudService;
import iih.bd.pp.hpdiexpenseself.i.IHpdiexpenseselfRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保计划自费诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpdiexpenseselfCudService.class,
		IHpdiexpenseselfRService.class }, binding = Binding.JSONRPC)
public class HpdiexpenseselfCrudServiceImpl extends BaseDOService<BdHpDiExpenseSelfDO>
		implements IHpdiexpenseselfCudService, IHpdiexpenseselfRService {
	public HpdiexpenseselfCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdHpDiExpenseSelfDODesc.class), IAppFwTempTbl.tmp_iaw_06.name());
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
	protected Validator[] getUpdateValidator(BdHpDiExpenseSelfDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
